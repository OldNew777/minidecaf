from ..utils import *
from .instr import *
from .namespace import NameInfo
from .typer import TypeInfo
from .types import *

from ..generated.MiniDecafExprParser import MiniDecafExprParser
from ..generated.MiniDecafExprVisitor import MiniDecafExprVisitor

from antlr4 import ParserRuleContext


class LabelManager:
	def __init__(self):
		self.nlabels = {}
		self.loopEntry = []
		self.loopExit = []

	def newLabel(self, scope="_L"):
		incOrInit(self.nlabels, scope)
		return f"{scope}_{self.nlabels[scope]}"

	def enterLoop(self, entry, exit):
		self.loopEntry.append(entry)
		self.loopExit.append(exit)

	def exitLoop(self):
		self.loopEntry.pop()
		self.loopExit.pop()

	def breakLabel(self, cxt:ParserRuleContext):
		if len(self.loopExit) == 0:
			raise MiniDecafLocatedError(cxt, "not in a loop")
		return self.loopExit[-1]

	def continueLabel(self, cxt:ParserRuleContext):
		if len(self.loopExit) == 0:
			raise MiniDecafLocatedError(cxt, "not in a loop")
		return self.loopEntry[-1]


class StackIRGen(MiniDecafExprVisitor):
	def __init__(self, emitter, nameInfo:TypeInfo, typeInfo:TypeInfo):
		self._E = emitter
		self.labelManager = LabelManager()
		self.nameInfo = nameInfo
		self.typeInfo = typeInfo

		self.currentFunctionNameInfo = None
		self.hasMain = False

	def variable(self, variable):
		return self.currentFunctionNameInfo[variable]

	def emitVariable(self, variable):
		if variable.offset == None:
			self._E([GlobalSymbol(variable.identifier)])
		else:
			self._E([FrameSlot(variable.offset)])

	def emitLocalVariable(self, leftValue:MiniDecafExprParser.ExpressionContext):
		location = self.typeInfo.leftValueLocation(leftValue)
		for locStep in location:
			if isinstance(locStep, IRInstr):
				self._E([locStep])
			else:
				locStep.accept(self)
				

	def _binaryExpression(self, ctx, operator):
		self.visitChildren(ctx)
		self._E([Binary(text(operator))])

	def _addExpression(self, ctx, operator, leftCtx, rightCtx):
		if isinstance(self.typeInfo[leftCtx], PointerType):
			sizeOfVariable = self.typeInfo[leftCtx].sizeof()
			if isinstance(self.typeInfo[rightCtx], PointerType):		# pointer - pointer
				leftCtx.accept(self)
				rightCtx.accept(self)
				self._E([Binary(operator)])
				self._E([Const(sizeOfVariable), Binary('/')])

			else:			# pointer + int
				leftCtx.accept(self)
				rightCtx.accept(self)
				self._E([Const(sizeOfVariable), Binary('*')])
				self._E([Binary(operator)])

		elif isinstance(self.typeInfo[leftCtx], IntType):
			sizeOfVariable = self.typeInfo[rightCtx].sizeof()
			if isinstance(self.typeInfo[rightCtx], PointerType):		# int + pointer
				leftCtx.accept(self)
				self._E([Const(sizeOfVariable), Binary('*')])
				rightCtx.accept(self)
				self._E([Binary(operator)])

			else:			# int + int
				self._binaryExpression(ctx, operator)

		else:
			raise MiniDecafLocatedError(ctx, f"type arithmetic computing error : {self.typeInfo[leftCtx]} {operator} {self.typeInfo[rightCtx]}")


	def loop(self, name, init, cond, body, post):
		entryLabel = self.labelManager.newLabel(f"{name}_entry")
		if post is not None:
			continueLabel = self.labelManager.newLabel(f"{name}_continue")
		else:
			continueLabel = entryLabel
		exitLabel = self.labelManager.newLabel(f"{name}_exit")
		self.labelManager.enterLoop(continueLabel, exitLabel)
		if init is not None:
			init.accept(self)
			if isinstance(init, MiniDecafExprParser.ExpressionContext):
				self._E([Pop()])
		self._E([Label(entryLabel)])
		if cond is not None:
			cond.accept(self)
		else:
			self._E([Const(1)])
		self._E([Branch("beqz", exitLabel)])
		body.accept(self)
		if post is not None:
			self._E([Label(continueLabel)])
			post.accept(self)
			if isinstance(post, MiniDecafExprParser.ExpressionContext):
				self._E([Pop()])
		self._E([Branch("br", entryLabel), Label(exitLabel)])
		self.labelManager.exitLoop()


	# Visit a parse tree produced by MiniDecafExprParser#program.
	def visitProgram(self, ctx:MiniDecafExprParser.ProgramContext):
		for globalInfo in self.nameInfo.globalInfos.values():
			self._E.emitGlobal(globalInfo)

			# check function/global identifier conflicts
			if globalInfo.variable.identifier in self.nameInfo.funcNameInfos.keys():
				raise MiniDecafLocatedError(ctx, f"function/global identifier {globalInfo.variable.identifier} conflicts")

		self.visitChildren(ctx)

		# check whether using undefined function
		for functionLabel, function in self.nameInfo.funcNameInfos.items():
			if function.defined == False and function.used == True:
				raise MiniDecafLocatedError(ctx, f"using undefined function {functionLabel}")


	# Visit a parse tree produced by MiniDecafExprParser#functionExternal.
	def visitFunctionExternal(self, ctx:MiniDecafExprParser.FunctionExternalContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#declarationExternal.
	def visitDeclarationExternal(self, ctx:MiniDecafExprParser.DeclarationExternalContext):
		pass


	# Visit a parse tree produced by MiniDecafExprParser#functionDefine.
	def visitFunctionDefine(self, ctx:MiniDecafExprParser.FunctionDefineContext):
		functionLabel = text(ctx.Identifier())
		if functionLabel == 'main':
			self.hasMain = True
		self.currentFunctionNameInfo = self.nameInfo.funcNameInfos[functionLabel]
		parameterInfo = self.nameInfo.parameterInfos[functionLabel]
		self._E.enterFuntion(functionLabel, parameterInfo)
		for var in parameterInfo.vars:
			self._E([Comment(f"[ir-offset]: {var} -> {var.offset}  # param")])
		ctx.block().accept(self)
		self._E.exitFunction()
		self.currentFunctionNameInfo = None


	# Visit a parse tree produced by MiniDecafExprParser#functionDeclaration.
	def visitFunctionDeclaration(self, ctx:MiniDecafExprParser.FunctionDeclarationContext):
		pass


	# Visit a parse tree produced by MiniDecafExprParser#pointerType.
	def visitPointerType(self, ctx:MiniDecafExprParser.PointerTypeContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#intType.
	def visitIntType(self, ctx:MiniDecafExprParser.IntTypeContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#parameterList.
	def visitParameterList(self, ctx:MiniDecafExprParser.ParameterListContext):
		pass


	# Visit a parse tree produced by MiniDecafExprParser#declaration.
	def visitDeclaration(self, ctx:MiniDecafExprParser.DeclarationContext):
		variable = self.variable(ctx.Identifier())
		if ctx.expression() != None:
			ctx.expression().accept(self)
		else:
			# 初始化为0
			self._E([Const(0)] * (variable.size // INT_BYTES))
		self._E([Comment(f"[ir-offset]: {variable} -> {variable.offset}")])


	# Visit a parse tree produced by MiniDecafExprParser#block.
	def visitBlock(self, ctx:MiniDecafExprParser.BlockContext):
		self._E([Comment("[ir-block] Enter")])
		self.visitChildren(ctx)
		self._E([Pop()] * self.currentFunctionNameInfo.blockSlots[ctx])
		self._E([Comment("[ir-block] Exit")])


	# Visit a parse tree produced by MiniDecafExprParser#blockItemStatement.
	def visitBlockItemStatement(self, ctx:MiniDecafExprParser.BlockItemStatementContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#blockItemDeclaration.
	def visitBlockItemDeclaration(self, ctx:MiniDecafExprParser.BlockItemDeclarationContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#returnStatement.
	def visitReturnStatement(self, ctx:MiniDecafExprParser.ReturnStatementContext):
		self._E([Comment("[ir-statement] Return")])
		ctx.expression().accept(self)
		self._E([Ret()])


	# Visit a parse tree produced by MiniDecafExprParser#expressionStatement.
	def visitExpressionStatement(self, ctx:MiniDecafExprParser.ExpressionStatementContext):
		self._E([Comment("[ir-statement] Expression")])
		self.visitChildren(ctx)
		self._E([Pop()])


	# Visit a parse tree produced by MiniDecafExprParser#blankStatement.
	def visitBlankStatement(self, ctx:MiniDecafExprParser.BlankStatementContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#ifStatement.
	def visitIfStatement(self, ctx:MiniDecafExprParser.IfStatementContext):
		self._E([Comment("[ir-statement] If")])
		ctx.expression().accept(self)
		exitLabel = self.labelManager.newLabel("if_exit")
		elseLabel = self.labelManager.newLabel("if_else")
		self
		if ctx.elseStatement != None:
			self._E([Branch("beqz", elseLabel)])
			ctx.thenStatement.accept(self)
			self._E([Branch("br", exitLabel), Label(elseLabel)])
			ctx.elseStatement.accept(self)
			self._E([Label(exitLabel)])
		else:
			self._E([Branch("beqz", exitLabel)])
			ctx.thenStatement.accept(self)
			self._E([Label(exitLabel)])


	# Visit a parse tree produced by MiniDecafExprParser#blockStatement.
	def visitBlockStatement(self, ctx:MiniDecafExprParser.BlockStatementContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#forDeclarationStatement.
	def visitForDeclarationStatement(self, ctx:MiniDecafExprParser.ForDeclarationStatementContext):
		self.loop("for", ctx.init, ctx.ctrl, ctx.statement(), ctx.post)
		self._E([Pop()] * self.currentFunctionNameInfo.blockSlots[ctx])


	# Visit a parse tree produced by MiniDecafExprParser#forStatement.
	def visitForStatement(self, ctx:MiniDecafExprParser.ForStatementContext):
		self.loop("for", ctx.init, ctx.ctrl, ctx.statement(), ctx.post)


	# Visit a parse tree produced by MiniDecafExprParser#whileStatement.
	def visitWhileStatement(self, ctx:MiniDecafExprParser.WhileStatementContext):
		self.loop("while", None, ctx.expression(), ctx.statement(), None)


	# Visit a parse tree produced by MiniDecafExprParser#doWhileStatement.
	def visitDoWhileStatement(self, ctx:MiniDecafExprParser.DoWhileStatementContext):
		self.loop("dowhile", ctx.statement(), ctx.expression(), ctx.statement(), None)


	# Visit a parse tree produced by MiniDecafExprParser#breakStatement.
	def visitBreakStatement(self, ctx:MiniDecafExprParser.BreakStatementContext):
		self._E([Branch("br", self.labelManager.breakLabel(ctx))])


	# Visit a parse tree produced by MiniDecafExprParser#continueStatement.
	def visitContinueStatement(self, ctx:MiniDecafExprParser.ContinueStatementContext):
		self._E([Branch("br", self.labelManager.continueLabel(ctx))])


	# Visit a parse tree produced by MiniDecafExprParser#expression.
	def visitExpression(self, ctx:MiniDecafExprParser.ExpressionContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#tAssign.
	def visitTAssign(self, ctx:MiniDecafExprParser.TAssignContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#cAssign.
	def visitCAssign(self, ctx:MiniDecafExprParser.CAssignContext):
		ctx.assign().accept(self)
		self.emitLocalVariable(ctx.unary())
		self._E([Store()])
		# 这里每次都不pop值出去，虽然能满足左值引用的特性，但是每次单纯的赋值就会使得栈大小 + 1
		# 有爆栈风险！


	# Visit a parse tree produced by MiniDecafExprParser#tConditional.
	def visitTConditional(self, ctx:MiniDecafExprParser.TConditionalContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#cConditional.
	def visitCConditional(self, ctx:MiniDecafExprParser.CConditionalContext):
		ctx.logical_or().accept(self)
		exitLabel = self.labelManager.newLabel("conditional_exit")
		elseLabel = self.labelManager.newLabel("conditional_else")
		self._E([Branch("beqz", elseLabel)])
		ctx.expression().accept(self)
		self._E([Branch("br", exitLabel), Label(elseLabel)])
		ctx.conditional().accept(self)
		self._E([Label(exitLabel)])


	# Visit a parse tree produced by MiniDecafExprParser#tLogical_or.
	def visitTLogical_or(self, ctx:MiniDecafExprParser.TLogical_orContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#cLogical_or.
	def visitCLogical_or(self, ctx:MiniDecafExprParser.CLogical_orContext):
		self._binaryExpression(ctx, "||")


	# Visit a parse tree produced by MiniDecafExprParser#tLogical_and.
	def visitTLogical_and(self, ctx:MiniDecafExprParser.TLogical_andContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#cLogical_and.
	def visitCLogical_and(self, ctx:MiniDecafExprParser.CLogical_andContext):
		self._binaryExpression(ctx, "&&")


	# Visit a parse tree produced by MiniDecafExprParser#tBit_or.
	def visitTBit_or(self, ctx:MiniDecafExprParser.TBit_orContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#cBit_or.
	def visitCBit_or(self, ctx:MiniDecafExprParser.CBit_orContext):
		self._binaryExpression(ctx, "|")


	# Visit a parse tree produced by MiniDecafExprParser#tBit_xor.
	def visitTBit_xor(self, ctx:MiniDecafExprParser.TBit_xorContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#cBit_xor.
	def visitCBit_xor(self, ctx:MiniDecafExprParser.CBit_xorContext):
		self._binaryExpression(ctx, "^")


	# Visit a parse tree produced by MiniDecafExprParser#cBit_and.
	def visitCBit_and(self, ctx:MiniDecafExprParser.CBit_andContext):
		self._binaryExpression(ctx, "&")


	# Visit a parse tree produced by MiniDecafExprParser#tBit_and.
	def visitTBit_and(self, ctx:MiniDecafExprParser.TBit_andContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#cEqual.
	def visitCEqual(self, ctx:MiniDecafExprParser.CEqualContext):
		self._binaryExpression(ctx, text(ctx.equalOperator()))


	# Visit a parse tree produced by MiniDecafExprParser#tEqual.
	def visitTEqual(self, ctx:MiniDecafExprParser.TEqualContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#cRelational.
	def visitCRelational(self, ctx:MiniDecafExprParser.CRelationalContext):
		self._binaryExpression(ctx, text(ctx.relationalOperator()))


	# Visit a parse tree produced by MiniDecafExprParser#tRelational.
	def visitTRelational(self, ctx:MiniDecafExprParser.TRelationalContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#cAdd.
	def visitCAdd(self, ctx:MiniDecafExprParser.CAddContext):
		self._addExpression(ctx, text(ctx.addOperator()), ctx.add(), ctx.multiply())


	# Visit a parse tree produced by MiniDecafExprParser#tAdd.
	def visitTAdd(self, ctx:MiniDecafExprParser.TAddContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#tMultiply.
	def visitTMultiply(self, ctx:MiniDecafExprParser.TMultiplyContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#cMultiply.
	def visitCMultiply(self, ctx:MiniDecafExprParser.CMultiplyContext):
		self._binaryExpression(ctx, text(ctx.multiplyOperator()))


	# Visit a parse tree produced by MiniDecafExprParser#cCast.
	def visitTCast(self, ctx:MiniDecafExprParser.CCastContext):
		return self.visitChildren(ctx)

	# Visit a parse tree produced by MiniDecafExprParser#cCast.
	def visitCCast(self, ctx:MiniDecafExprParser.CCastContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#tUnary.
	def visitTUnary(self, ctx:MiniDecafExprParser.TUnaryContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#cUnary.
	def visitCUnary(self, ctx:MiniDecafExprParser.CUnaryContext):
		op = text(ctx.unaryOperator())
		if op == '&':
			self.emitLocalVariable(ctx.cast())
		elif op == '*':
			self.visitChildren(ctx)
			self._E([Load()])
		else:
			self.visitChildren(ctx)
			self._E([Unary(op)])


	# Visit a parse tree produced by MiniDecafExprParser#postfixArray.
	def visitPostfixArray(self, ctx:MiniDecafExprParser.PostfixArrayContext):
		sizeOfBase = self.typeInfo[ctx.postfix()].base.sizeof()
		ctx.postfix().accept(self)
		ctx.expression().accept(self)
		self._E([Const(sizeOfBase), Binary('*'), Binary('+')])
		if not isinstance(self.typeInfo[ctx], ArrayType):
			self._E([Load()])


	# Visit a parse tree produced by MiniDecafExprParser#postfixCall.
	def visitPostfixCall(self, ctx:MiniDecafExprParser.PostfixCallContext):
		functionLabel = text(ctx.Identifier())
		argumentList = ctx.argumentList().expression()

		# function not defined error
		if functionLabel not in self.nameInfo.funcNameInfos:
			raise MiniDecafLocatedError(ctx, f"function {functionLabel} not defined")
		# arguments num unmatch error
		if self.nameInfo.parameterInfos[functionLabel].paramNum != len(argumentList):
			raise MiniDecafLocatedError(ctx, f"function {functionLabel} arguments num {self.nameInfo.parameterInfos[functionLabel].paramNum} unmatch")
		
		self.nameInfo.funcNameInfos[functionLabel].used = True

		for argument in reversed(argumentList):
			argument.accept(self)
		self._E([Call(functionLabel)])


	# Visit a parse tree produced by MiniDecafExprParser#tPostfix.
	def visitTPostfix(self, ctx:MiniDecafExprParser.TPostfixContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#argumentList.
	def visitArgumentList(self, ctx:MiniDecafExprParser.ArgumentListContext):
		return self.visitChildren(ctx)


	# Visit a parse tree produced by MiniDecafExprParser#atomInteger.
	def visitAtomInteger(self, ctx:MiniDecafExprParser.AtomIntegerContext):
		number = int(text(ctx.Integer()))
		self._E([Const(number)])


	# Visit a parse tree produced by MiniDecafExprParser#atomIdentifier.
	def visitAtomIdentifier(self, ctx:MiniDecafExprParser.AtomIdentifierContext):
		variable = self.variable(ctx.Identifier())
		self.emitVariable(variable)
		if not isinstance(self.typeInfo[ctx], ArrayType):
			self._E([Load()])

	# Visit a parse tree produced by MiniDecafExprParser#atomParen.
	def visitAtomParen(self, ctx:MiniDecafExprParser.AtomParenContext):
		return self.visitChildren(ctx)
