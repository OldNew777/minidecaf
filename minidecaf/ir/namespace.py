from ..utils import *
from ..generated.MiniDecafExprParser import MiniDecafExprParser
from ..generated.MiniDecafExprVisitor import MiniDecafExprVisitor


class Variable:
	_variableNumber = {}
	def __init__(self, identifier:str, offset:int, size:int=INT_BYTES):
		incOrInit(Variable._variableNumber, identifier)
		self.identifier = identifier
		self.id = Variable._variableNumber[identifier]
		self.offset = offset
		self.size = size

	def __eq__(self, target):
		return \
			self.id == target.id and \
			self.identifier == target.identifier and\
			self.offset == target.offset

	def __str__(self):
		return f"{self.identifier}({self.id})"

	def __repr__(self):
		return self.__str__()

	def __hash__(self):
		return hash((self.identifier, self.id, self.offset))


class ParameterInfo:
	def __init__(self, vars:[Variable]):
		self.vars = vars
		self.paramNum = len(vars)

	def __str__(self):
		return f"{self.paramNum}"

	def compatible(self, other):
		return self.paramNum == other.paramNum

	def inParam(self, identifier:str):
		for variable in self.vars:
			if identifier == variable.identifier:
				return True
		return False


class FunctionNameInfo:
	def __init__(self):
		self._variable = {}		# identifier->Variable
		self._position = {}
		self.blockSlots = {}
		
		# judge whether defined/used
		# to verify redefined/undefined error
		self.defined = False
		self.used = False

	def bind(self, identifier, variable, position):
		self._variable[identifier] = variable
		self._position[identifier] = position

	def __str__(self):
		ans = "name resolution:\n"
		def f(pv):
			position, variable = pv
			return f"{str(position):>16} : {str(variable):<10} at frameslot {variable.offset}"
		ans += "\n".join(map(f,
			[(self._position[identifier], self._variable[identifier]) for identifier in self._variable]))

		ans += "\nnumber of slots in each block:\n"
		def g(bs):
			ctx, slots = bs
			startPos = (ctx.start.line, ctx.start.column)
			stopPos = (ctx.stop.line, ctx.stop.column)
			region = f"{startPos} ~ {stopPos}"
			return f"{region:>32} : {slots}"
		ans += "\n".join(map(g, 
			[(ctx, self.blockSlots[ctx]) for ctx in self.blockSlots]))

		return ans

	def __repr__(self):
		return self.__str__()

	def __getitem__(self, identifier):
		return self._variable[identifier]

class GlobalInfo:
	def __init__(self, variable:Variable, init=None):
		self.variable = variable
		self.size = variable.size
		self.init = init

	def __str__(self):
		return f"{self.variable}, size={self.size}, {self.initStr()}"

	def initStr(self):
		if self.init is None:
			return "uninitialized"
		else:
			return f"initializer={self.init}"


class NameInfo:
	def __init__(self):
		self.funcNameInfos = {}
		self.parameterInfos = {}
		self.globalInfos = {}
		self._variable = {}			# identifier->Variable

	def enterFunction(self, func:str, functionNameInfo: FunctionNameInfo, parameterInfo:ParameterInfo):
		functionNameInfo.defined = True
		self.funcNameInfos[func] = functionNameInfo
		self.parameterInfos[func] = parameterInfo

	def declareFunction(self, func:str, functionNameInfo: FunctionNameInfo, parameterInfo:ParameterInfo):
		functionNameInfo.defined = False
		self.funcNameInfos[func] = functionNameInfo
		self.parameterInfos[func] = parameterInfo

	def freeze(self):
		for funcNameInfo in self.funcNameInfos.values():
			self._variable.update(funcNameInfo._variable)

	def __getitem__(self, ctx):
		return self._variable[ctx]

	def __str__(self):
		def f(fn):
			func, funcNameInfo = fn
			indentedFuncNameInfo = "\t" + str(funcNameInfo).replace("\n", "\n\t")
			return f"NameInfo for {func}:\n{indentedFuncNameInfo}"
		res = "\n--------\n\n".join(map(f, self.funcNameInfos.items()))
		res += "\n--------\n\nGlobInfos:\n\t"
		res += "\n\t".join(map(str, self.globalInfos.values()))
		return res


class NameVisitor(MiniDecafExprVisitor):
	def __init__(self):
		self._variable = stacked_dict()
		self._slotsNumber = []
		self._currentFunctionNameInfo = None
		self._currentParameterInfo = None
		self._processingArguments = False

		self.currentSlots = 0
		self.nameInfo = NameInfo()


	def defVariable(self, ctx, identifier, elementNumber:int):
		self.currentSlots += elementNumber
		variable = self._variable[text(identifier)] = \
			Variable(text(identifier), -INT_BYTES * self.currentSlots, elementNumber * INT_BYTES)
		position = (ctx.start.line, ctx.start.column)
		self._currentFunctionNameInfo.bind(identifier, variable, position)
		
	def useVariable(self, ctx, identifier):
		variable = self._variable[text(identifier)]
		position = (ctx.start.line, ctx.start.column)
		self._currentFunctionNameInfo.bind(identifier, variable, position)

	def declareElementNumber(self, ctx:MiniDecafExprParser.DeclarationContext):
		# count element number in variable:
		# int/pointer
		# single/multiple dimension array
		dimensionsSize = [int(text(x)) for x in ctx.Integer()]
		for x in dimensionsSize:
			if x <= 0 or x > MAX_INT:
				raise MiniDecafLocatedError(ctx, "array dimension size <= 0 error")
		res = prod(dimensionsSize)
		return res

	def enterScope(self, ctx):
		self._variable.push()
		self._slotsNumber.append(self.currentSlots)

	def exitScope(self, ctx):
		self._currentFunctionNameInfo.blockSlots[ctx] = self.currentSlots - self._slotsNumber[-1]
		self.currentSlots = self._slotsNumber[-1]
		self._variable.pop()
		self._slotsNumber.pop()

	def function(self, ctx, orderType:str):
		functionLabel = text(ctx.Identifier())
		if orderType == 'define' and \
			functionLabel in self.nameInfo.funcNameInfos and \
				self.nameInfo.funcNameInfos[functionLabel].defined == True:
			# redefined error
			raise MiniDecafLocatedError(ctx, f"Redefinition of function {functionLabel}")

		functionNameInfo = self._currentFunctionNameInfo = FunctionNameInfo()
		self.enterScope(ctx)
		self._processingArguments = True
		parameterInfo = ParameterInfo(ctx.parameterList().accept(self))
		self._processingArguments = False
		self._currentParameterInfo = parameterInfo

		if parameterInfo.inParam(functionLabel):
			# 检查函数名是否与参数名重合
			raise MiniDecafLocatedError(ctx, f"Conflicting parameter name with function : {functionLabel}")
		
		if functionLabel in self.nameInfo.parameterInfos and \
			not parameterInfo.compatible(self.nameInfo.parameterInfos[functionLabel]):
			# 这里仅检查参数数量是否与之前声明的同名函数相同
			raise MiniDecafLocatedError(ctx, f"Conflicting parameter num for {functionLabel}")

		if orderType == 'define':
			self.nameInfo.enterFunction(functionLabel, functionNameInfo, parameterInfo)
			ctx.block().accept(self)
		elif orderType == 'declaration':
			if functionLabel not in self.nameInfo.funcNameInfos:
				self.nameInfo.declareFunction(functionLabel, functionNameInfo, parameterInfo)
		self.exitScope(ctx)
		self._currentFunctionNameInfo = None
		self._currentParameterInfo = None

	def globalInitializer(self, ctx:MiniDecafExprParser.ExpressionContext):
		if ctx == None:
			return None
		try:
			return safeEval(text(ctx))
		except:
			raise MiniDecafLocatedError(ctx, "Global initializers must be constants")


	# visit paser tree
	def visitBlock(self, ctx:MiniDecafExprParser.BlockContext):
		self.enterScope(ctx)
		self.visitChildren(ctx)
		self.exitScope(ctx)

	def visitDeclaration(self, ctx:MiniDecafExprParser.DeclarationContext):
		if ctx.expression() != None:
			ctx.expression().accept(self)
		variable = text(ctx.Identifier())
		if variable in self._variable.peek():
			raise MiniDecafLocatedError(ctx, f"redefinition of {variable}")
		if (not self._processingArguments) and self._currentParameterInfo.inParam(variable):
			raise MiniDecafLocatedError(ctx, f"redefinition of {variable}")
		self.defVariable(ctx, ctx.Identifier(), self.declareElementNumber(ctx))

	def visitAtomIdentifier(self, ctx:MiniDecafExprParser.AtomIdentifierContext):
		variable = text(ctx.Identifier())
		if variable not in self._variable:
			raise MiniDecafLocatedError(ctx, f"{variable} undeclared")
		self.useVariable(ctx, ctx.Identifier())

	def visitForDeclarationStatement(self, ctx:MiniDecafExprParser.ForDeclarationStatementContext):
		self.enterScope(ctx)
		self.visitChildren(ctx)
		self.exitScope(ctx)

	def visitFunctionDefine(self, ctx:MiniDecafExprParser.FunctionDefineContext):
		self.function(ctx, 'define')

	def visitFunctionDeclaration(self, ctx:MiniDecafExprParser.FunctionDeclarationContext):
		self.function(ctx, 'declaration')

	def visitParameterList(self, ctx:MiniDecafExprParser.ParameterListContext):
		self.visitChildren(ctx)
		def f(declaration):
			return self._variable[text(declaration.Identifier())]
		declarationList = ctx.declaration()
		return list(map(f, declarationList))

	def visitDeclarationExternal(self, ctx:MiniDecafExprParser.DeclarationExternalContext):
		ctx = ctx.declaration()
		init = self.globalInitializer(ctx.expression())
		identifier = text(ctx.Identifier())
		variable = Variable(identifier, None, self.declareElementNumber(ctx) * INT_BYTES)
		globalInfo = GlobalInfo(variable, init)
		
		if identifier in self._variable.peek():
			preVariable = self._variable[identifier]
			preGlobalInfo = self.nameInfo.globalInfos[preVariable.identifier]

			# check init
			if preGlobalInfo.init != None:
				if globalInfo.init != None:
					raise MiniDecafLocatedError(ctx, f"redefinition of variable {identifier}")
				return
			
			elif globalInfo.init != None:
				self.nameInfo.globalInfos[preVariable.identifier].init = init
		
		else:
			self._variable[identifier] = variable
			self.nameInfo.globalInfos[variable.identifier] = globalInfo
			
	def visitProgram(self, ctx:MiniDecafExprParser.ProgramContext):
		self.visitChildren(ctx)
		# save all variable info
		self.nameInfo.freeze()
