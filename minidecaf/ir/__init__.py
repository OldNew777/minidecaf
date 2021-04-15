from ..utils import *
from .instr import *
from .irgen import StackIRGen
from .namespace import *
from .typer import TypeVisitor, TypeInfo


def irGen(tree, nameInfo:NameInfo, typeInfo:TypeInfo):
	irEmitter = IREmitter()
	stackIRGen = StackIRGen(irEmitter, nameInfo, typeInfo)
	stackIRGen.visit(tree)
	if not stackIRGen.hasMain:
		raise MiniDecafError("paser error : no main")
	return irEmitter.getIR()

def typeCheck(tree, nameInfo):
	typer = TypeVisitor(nameInfo)
	typer.visit(tree)
	return typer.typeInfo


class IRGlobal:
	def __init__(self, identifier:str, size:int, init=None, align=4):
		self.identifier = identifier
		self.size = size
		self.init = init # byte array
		self.align = align

	def __str__(self):
		return f"{self.identifier}:\n\tsize={self.size}, align={self.align}\n\t{self.initStr()}"

	def initStr(self):
		if self.init is None:
			return "uninitialized"
		else:
			return f"initializer={self.init}"


class IRFunc:
	def __init__(self, name:str, parameterInfo:ParameterInfo, instrs:[IRInstr]):
		self.name = name
		self.parameterInfo = parameterInfo
		self.instrs = instrs

	def __str__(self):
		def f(i):
			if type(i) is Comment:
				return f"\t\t\t\t{i}"
			if type(i) is Label:
				return f"{i}"
			return f"\t{i}"
		body = '\n'.join(map(f, self.instrs))
		return f"{self.name}({self.parameterInfo}):\n{body}"

class IRProg:
	def __init__(self, iRFunctions:[IRFunc], iRGlobals:[IRGlobal]):
		self.functions = iRFunctions
		self.globals = iRGlobals

	def __str__(self):
		globs = "\n".join(map(str, self.globals))
		functions = "\n\n".join(map(str, self.functions))
		res = "========Globs:\n" + globs
		res += "\n\n========Funcs:\n" + functions
		return res


class IREmitter:
	def __init__(self):
		self.globals = []
		self.functions = []
		self.curName = None
		self.curParameterInfo = None
		self.curInstrs = []

	def __call__(self, irs:[IRInstr]):
		self.emit(irs)

	def emit(self, irs:[IRInstr]):
		self.curInstrs += irs

	def getIR(self):
		return IRProg(self.functions, self.globals)

	def enterFuntion(self, name:str, parameterInfo:ParameterInfo):
		self.curName = name
		self.curParameterInfo = parameterInfo
		self.curInstrs = []

	def exitFunction(self):
		self.functions.append(IRFunc(self.curName, self.curParameterInfo, self.curInstrs))

	def emitGlobal(self, globalInfo:GlobalInfo):
		assert globalInfo.variable.offset == None
		self.globals += [IRGlobal(globalInfo.variable.identifier, globalInfo.size, globalInfo.init)]
