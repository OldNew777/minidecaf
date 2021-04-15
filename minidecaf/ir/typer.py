from ..utils import *
from ..generated.MiniDecafExprParser import MiniDecafExprParser
from ..generated.MiniDecafExprVisitor import MiniDecafExprVisitor
from .instr import *
from .namespace import *
from .types import *


class TypeInfo:
	def __init__(self):
		self.location = {} 		# ExpressionContext -> (IRInstr|ExpressionContext)+
		self.functions = {} 	# str -> FuncTypeInfo
		self._type = {} 		# ExpressionContext -> Type

	def leftValueLocation(self, ctx):
		return self.location[ctx]

	def setLeftValueLocation(self, ctx, locations:list):
		self.location[ctx] = locations

	def __str__(self):
		res = "Left value analysis result: (location of expression at lhs == value of rhs):\n\t"
		def p(ctx):
			return f"{ctx.start.line},{ctx.start.column}~{ctx.stop.line},{ctx.stop.column}"
		def g(locationStep):
			if isinstance(locationStep, IRInstr):
				return f"{locationStep}"
			else:
				return f"[{p(locationStep)}]"
		def f(ctx_location):
			ctx, location = ctx_location
			ctxStr = f"{p(ctx)}"
			locationStr = " :: ".join(map(g, location))
			return f"{ctxStr:>32} : {locationStr}"
		res += "\n\t".join(map(f, self.location.items()))
		res += "\n\nType info for funcs:\n\t"
		def h(name_function):
			name, funcInfo = name_function
			return f"{name:>32} : ({funcInfo.parametersType}) -> {funcInfo.returnType}"
		res += "\n\t".join(map(h, self.functions.items()))
		return res

	def __getitem__(self, ctx):
		return self._type[ctx]


class FunctionTypeInfo:
	def __init__(self, returnType:Type, parametersType:list):
		self.returnType = returnType
		self.parametersType = parametersType

	def compatible(self, other):
		return self.returnType == other.returnType and self.parametersType == other.parametersType

	def call(self):
		@TypeRule
		def callRule(ctx, argumentsType:list):
			if self.parametersType == argumentsType:
				return self.returnType
			return f"bad argument types"
		return callRule


def SaveType(f):
	def g(self, ctx):
		ty = f(self, ctx)
		self.typeInfo._type[ctx] = ty
		return ty
	return g


class TypeVisitor(MiniDecafExprVisitor):
	"""Type checking.
	Run after name resolution, type checking computes the type of each
	expression, and also check for incompatibilities like int*+int*. Besides
	type checking, Typer also does left value analysis i.e. determine which
	expressions are left values and their address."""
	def __init__(self, nameInfo: NameInfo):
		self.variable2type = {} # Variable -> Type
		self.nameInfo = nameInfo
		self.currentFunction = None
		self.typeInfo = TypeInfo()
		self.locator = Locator(self.nameInfo, self.typeInfo)


	def _variable(self, term):
		return self.nameInfo[term]

	def parametersType(self, ctx:MiniDecafExprParser.ParameterListContext):
		res = []
		for declaration in ctx.declaration():
			if declaration.expression() is not None:
				raise MiniDecafLocatedError(declaration, "parameter cannot have initializers")
			if isinstance(self._declarationType(declaration), ArrayType):
				raise MiniDecafLocatedError(declaration, "parameter cannot be ArrayType")
			res += [self._declarationType(declaration)]
		return res

	def _functionTypeInfo(self, ctx):
		returnType = ctx.variableType().accept(self)
		parametersType = self.parametersType(ctx.parameterList())
		return FunctionTypeInfo(returnType, parametersType)

	def _declarationType(self, ctx:MiniDecafExprParser.DeclarationContext):
		base = ctx.variableType().accept(self)
		dimensions = [int(text(x)) for x in ctx.Integer()]
		if len(dimensions) == 0:
			return base
		else:
			return ArrayType.make(base, dimensions)

	def _argumentType(self, ctx:MiniDecafExprParser.ArgumentListContext):
		return list(map(lambda x: x.accept(self), ctx.expression()))


	def locate(self, ctx):
		location = self.locator.locate(self.currentFunction, ctx)
		if location is None:
			raise MiniDecafLocatedError(ctx, "left value expected")
		self.typeInfo.setLeftValueLocation(ctx, location)


	def checkUnary(self, ctx, operator:str, ty:Type):
		if operator in { '-', '!', '~' }:
			rule = intUnaryOperateRule
		elif operator == '&':
			rule = getAddressRule
		elif operator == '*':
			rule = dereferenceRule
		return rule(ctx, ty)

	def checkBinary(self, ctx, operator:str, lhs:Type, rhs:Type):
		if operator in ['*', '/', '%'] + logicbitOps:
			rule = intBinaryOperateRule
		elif operator in eqOps:
			rule = equalRule
		elif operator in relOps:
			rule = relationalRule
		elif operator == '=':
			rule = assignRule
		elif operator == '+':
			rule = tryEach('+', intBinaryOperateRule, pointerArithmeticRule)
		else:
			rule = tryEach('-', intBinaryOperateRule, pointerArithmeticRule, pointerDifferentRule)
		return rule(ctx, lhs, rhs)

	def checkFunction(self, ctx):
		functionTypeInfo = self._functionTypeInfo(ctx)
		function = text(ctx.Identifier())
		if function in self.typeInfo.functions:
			definedFunctionTypeInfo = self.typeInfo.functions[function]
			if not functionTypeInfo.compatible(definedFunctionTypeInfo):
				raise MiniDecafLocatedError(ctx, f"conflicting types for {function}")
		else:
			self.typeInfo.functions[function] = functionTypeInfo


	def visitChildren(self, ctx):
		ty = MiniDecafExprVisitor.visitChildren(self, ctx)
		self.typeInfo._type[ctx] = ty
		return ty

	def visitPointerType(self, ctx:MiniDecafExprParser.PointerTypeContext):
		return PointerType(ctx.variableType().accept(self))

	def visitIntType(self, ctx:MiniDecafExprParser.IntTypeContext):
		return IntType()

	@SaveType
	def visitCCast(self, ctx:MiniDecafExprParser.CCastContext):
		ctx.cast().accept(self)
		return ctx.variableType().accept(self)

	@SaveType
	def visitCUnary(self, ctx:MiniDecafExprParser.CUnaryContext):
		res = self.checkUnary(ctx.unaryOperator(), text(ctx.unaryOperator()),
				ctx.cast().accept(self))
		if text(ctx.unaryOperator()) == '&':
			self.locate(ctx.cast())
		return res

	@SaveType
	def visitAtomParen(self, ctx:MiniDecafExprParser.AtomParenContext):
		return ctx.expression().accept(self)

	@SaveType
	def visitCAdd(self, ctx:MiniDecafExprParser.CAddContext):
		return self.checkBinary(ctx.addOperator(), text(ctx.addOperator()),
				ctx.add().accept(self), ctx.multiply().accept(self))

	@SaveType
	def visitCMultiply(self, ctx:MiniDecafExprParser.CMultiplyContext):
		return self.checkBinary(ctx.multiplyOperator(), text(ctx.multiplyOperator()),
				ctx.multiply().accept(self), ctx.cast().accept(self))

	@SaveType
	def visitCRelational(self, ctx:MiniDecafExprParser.CRelationalContext):
		return self.checkBinary(ctx.relationalOperator(), text(ctx.relationalOperator()),
				ctx.relational().accept(self), ctx.add().accept(self))

	@SaveType
	def visitCEqual(self, ctx:MiniDecafExprParser.CEqualContext):
		return self.checkBinary(ctx.equalOperator(), text(ctx.equalOperator()),
				ctx.equal().accept(self), ctx.relational().accept(self))

	@SaveType
	def visitCLogical_and(self, ctx:MiniDecafExprParser.CLogical_andContext):
		return self.checkBinary(ctx, "&&",
				ctx.logical_and().accept(self), ctx.bit_or().accept(self))

	@SaveType
	def visitCLogical_or(self, ctx:MiniDecafExprParser.CLogical_orContext):
		return self.checkBinary(ctx, "||",
				ctx.logical_or().accept(self), ctx.logical_and().accept(self))

	@SaveType
	def visitCBit_or(self, ctx:MiniDecafExprParser.CBit_orContext):
		return self.checkBinary(ctx, "|",
				ctx.bit_or().accept(self), ctx.bit_xor().accept(self))

	@SaveType
	def visitCBit_xor(self, ctx:MiniDecafExprParser.CBit_xorContext):
		return self.checkBinary(ctx, "^",
				ctx.bit_xor().accept(self), ctx.bit_and().accept(self))

	@SaveType
	def visitCBit_and(self, ctx:MiniDecafExprParser.CBit_andContext):
		return self.checkBinary(ctx, "&",
				ctx.bit_and().accept(self), ctx.equal().accept(self))

	@SaveType
	def visitCConditional(self, ctx:MiniDecafExprParser.CConditionalContext):
		return conditionalRule(ctx, ctx.logical_or().accept(self),
				ctx.expression().accept(self), ctx.conditional().accept(self))

	@SaveType
	def visitCAssign(self, ctx:MiniDecafExprParser.CAssignContext):
		res = self.checkBinary(ctx.assignOperator(), text(ctx.assignOperator()),
				ctx.unary().accept(self), ctx.assign().accept(self))
		self.locate(ctx.unary())
		return res

	@SaveType
	def visitPostfixCall(self, ctx:MiniDecafExprParser.PostfixCallContext):
		argumentType = self._argumentType(ctx.argumentList())
		function = text(ctx.Identifier())
		rule = self.typeInfo.functions[function].call()
		return rule(ctx, argumentType)

	@SaveType
	def visitPostfixArray(self, ctx:MiniDecafExprParser.PostfixArrayContext):
		return arrayRule(ctx,
				ctx.postfix().accept(self), ctx.expression().accept(self))

	@SaveType
	def visitAtomInteger(self, ctx:MiniDecafExprParser.AtomIntegerContext):
		if safeEval(text(ctx)) == 0:
			return NullType()
		else:
			return IntType()

	@SaveType
	def visitAtomIdentifier(self, ctx:MiniDecafExprParser.AtomIdentifierContext):
		variable = self._variable(ctx.Identifier())
		return self.variable2type[variable]

	def visitDeclaration(self, ctx:MiniDecafExprParser.DeclarationContext):
		variable = self._variable(ctx.Identifier())
		ty = self._declarationType(ctx)
		self.variable2type[variable] = ty
		if ctx.expression() is not None:
			initType = ctx.expression().accept(self)
			assignRule(ctx, ty, initType)

	def visitFunctionDefine(self, ctx:MiniDecafExprParser.FunctionDefineContext):
		function = text(ctx.Identifier())
		self.currentFunction = function
		self.checkFunction(ctx)
		self.visitChildren(ctx)
		self.currentFunction = None

	def visitFunctionDeclaration(self, ctx:MiniDecafExprParser.FunctionDeclarationContext):
		function = text(ctx.Identifier())
		self.currentFunction = function
		self.checkFunction(ctx)
		self.currentFunction = None

	def visitDeclarationExternal(self, ctx:MiniDecafExprParser.DeclarationExternalContext):
		ctx = ctx.declaration()
		variable = self.nameInfo.globalInfos[text(ctx.Identifier())].variable
		ty = self._declarationType(ctx)
		if variable in self.variable2type:
			definedType = self.variable2type[variable]
			if definedType != ty:
				raise MiniDecafLocatedError(ctx, f"conflicting types for {variable.identifier}")
		else:
			self.variable2type[variable] = ty
		if ctx.expression() is not None:
			initType = ctx.expression().accept(self)
			assignRule(ctx, ty, initType)

	def visitReturnStatement(self, ctx:MiniDecafExprParser.ReturnStatementContext):
		functionReturnType = self.typeInfo.functions[self.currentFunction].returnType
		ty = ctx.expression().accept(self)
		returnRule(ctx, functionReturnType, ty)

	def visitIfStatement(self, ctx:MiniDecafExprParser.IfStatementContext):
		self.visitChildren(ctx)
		statementConditionalRule(ctx, ctx.expression().accept(self)) # idempotent

	def visitForDeclarationStatement(self, ctx:MiniDecafExprParser.ForDeclarationStatementContext):
		self.visitChildren(ctx)
		if ctx.ctrl is not None: statementConditionalRule(ctx, ctx.ctrl.accept(self))

	def visitForStatement(self, ctx:MiniDecafExprParser.ForStatementContext):
		self.visitChildren(ctx)
		if ctx.ctrl is not None: statementConditionalRule(ctx, ctx.ctrl.accept(self))

	def visitWhileStatement(self, ctx:MiniDecafExprParser.WhileStatementContext):
		self.visitChildren(ctx)
		statementConditionalRule(ctx, ctx.expression().accept(self))

	def visitDoWhileStatement(self, ctx:MiniDecafExprParser.DoWhileStatementContext):
		self.visitChildren(ctx)
		statementConditionalRule(ctx, ctx.expression().accept(self))


class Locator(MiniDecafExprVisitor):
	def __init__(self, nameInfo:NameInfo, typeInfo:TypeInfo):
		self.nameInfo = nameInfo
		self.typeInfo = typeInfo

	def locate(self, function:str, ctx):
		self.function = function
		res = ctx.accept(self)
		self.function = None
		return res

	def visitAtomIdentifier(self, ctx:MiniDecafExprParser.AtomIdentifierContext):
		variable = self.nameInfo[ctx.Identifier()]
		if variable.offset is None:
			return [GlobalSymbol(variable.identifier)]
		else:
			return [FrameSlot(variable.offset)]

	def visitCUnary(self, ctx:MiniDecafExprParser.CUnaryContext):
		operator = text(ctx.unaryOperator())
		if operator == '*':
			return [ctx.cast()]

	def visitPostfixArray(self, ctx:MiniDecafExprParser.PostfixArrayContext):
		baseTypeSize = self.typeInfo[ctx.postfix()].base.sizeof()
		return [ctx.postfix(), ctx.expression(), Const(baseTypeSize), Binary('*'), Binary('+')]

	def visitAtomParen(self, ctx:MiniDecafExprParser.AtomParenContext):
		return ctx.expression().accept(self)

