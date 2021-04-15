from ..utils import *
from ..ir.instr import *
from ..ir.visitor import *
from ..ir.namespace import *
from ..ir import *
from . import *

def Instrs(f):
	def g(*args, **kwargs):
		instrs = f(*args, *kwargs)
		return [(AsmInstr(x) if type(x) is not AsmInstr else x) for x in instrs]
	return g

@Instrs
def _push(val):
	if type(val) is int:
		# risc-v assembler supports li t1, 0xffffffff
		return [f"li t1, {val}", f"addi sp, sp, -{INT_BYTES}", f"sw t1, 0(sp)"] # push int
	else:
		return [f"addi sp, sp, -{INT_BYTES}", f"sw {val}, 0(sp)"] # push register

def push(*vals):
	return flatten(map(_push, vals))

@Instrs
def _pop(reg):
	return ([f"lw {reg}, 0(sp)"] if reg is not None else []) + [f"addi sp, sp, {INT_BYTES}"]

def pop(*regs):
	return flatten(map(_pop, regs))

@Instrs
def unary(op):
	op = {'-': "neg", '!': "seqz", '~': "not"}[op]
	return pop("t1") + [f"{op} t1, t1"] + push("t1")

@Instrs
def binary(op):
	b1 = { "+": "add", "-": "sub", "*": "mul", "/": "div", "%": "rem", "<": "slt", ">": "sgt", "|": "or", "^": "xor", "&": "and" }
	b2 = { "==": "seqz", "!=": "snez" }
	if op in b1:
		return pop("t2") + [f"lw t1, 0(sp)"] + \
			[f"{b1[op]} t1, t1, t2"] + \
			[f"sw t1, 0(sp)"]
	if op in b2:
		return pop("t2") + [f"lw t1, 0(sp)"] + \
			[f"sub t1, t1, t2", f"{b2[op]} t1, t1"] + \
			[f"sw t1, 0(sp)"]
	if op == "||":
		return pop("t2") + [f"lw t1, 0(sp)"] + \
			[f"or t1, t1, t2", f"snez t1, t1"] + \
			[f"sw t1, 0(sp)"]
	if op == "&&":
		return pop("t2") + [f"lw t1, 0(sp)"] + \
			[f"snez t2, t2", f"snez t1, t1", f"and t1, t1, t2"] + \
			[f"sw t1, 0(sp)"]
	if op == "<=":
		return pop("t2") + [f"lw t1, 0(sp)"] + \
			[f"sgt t1, t1, t2", "seqz t1, t1"] + \
			[f"sw t1, 0(sp)"]
	if op == ">=":
		return pop("t2") + [f"lw t1, 0(sp)"] + \
			[f"slt t1, t1, t2", "seqz t1, t1"] + \
			[f"sw t1, 0(sp)"]

@Instrs
def frameSlot(offset):
	return [f"addi t1, fp, {offset}"] + push("t1")

@Instrs
def load():
	return [f"lw t1, 0(sp)", f"lw t1, 0(t1)", f"sw t1, 0(sp)"]

@Instrs
def store():
	return pop("t2") + [f"lw t1, 0(sp)", f"sw t1, 0(t2)"]

@Instrs
def ret(func:str):
	return [f"beqz x0, {func}_exit"]

@Instrs
def branch(op, label:str):
	b1 = {"beqz": "beqz", "bnez": "bnez"}
	b2 = {"br": "beqz"}

	if op in b1:
		op = b1[op]
		return pop("t1") + [f"{op} t1, {label}"]

	elif op in b2:
		op = b2[op]
		return [f"{op} x0, {label}"]

def label(label_name:str):
	return [AsmLabel(f"{label_name}")]

@Instrs
def call(func:str, nParam:int):
	return [f"call {func}"] + pop(*[None]*nParam) + push("a0")

@Instrs
def globalSymbol(sym:str):
	return [f"la t1, {sym}"] + push("t1")

class RISCVAsmGen(IRVisitor):
	def __init__(self, emitter):
		self._E = emitter
		self.curFunc = None
		self.curParamInfo = None

	def visitRet(self, instr:Ret):
		self._E(ret(self.curFunc))

	def visitConst(self, instr:Const):
		self._E(push(instr.v))

	def visitUnary(self, instr:Unary):
		self._E(unary(instr.op))

	def visitBinary(self, instr:Binary):
		self._E(binary(instr.op))

	def visitFrameSlot(self, instr:FrameSlot):
		self._E(frameSlot(instr.offset))

	def visitLoad(self, instr:Load):
		self._E(load())

	def visitStore(self, instr:Store):
		self._E(store())

	def visitPop(self, instr:Pop):
		self._E(pop(None))

	def visitBranch(self, instr:Branch):
		self._E(branch(instr.op, instr.label))

	def visitLabel(self, instr:Label):
		self._E(label(instr.label))

	def visitCall(self, instr:Call):
		_, func = listFind(lambda func: func.name == instr.func, self.ir.functions)
		self._E(call(func.name, func.parameterInfo.paramNum))

	def visitGlobalSymbol(self, instr:GlobalSymbol):
		self._E(globalSymbol(instr.sym))


	def genPrologue(self, func:str, parameterInfo:ParameterInfo):
		self._E(
			[
			AsmBlank(),
			AsmDirective(".text"),
			AsmDirective(f".globl {func}"),
			AsmLabel(f"{func}")
			] +

			push("ra", "fp") + 		# save returnAddress and fp
			[
			AsmInstr("mv fp, sp"),
			
			AsmComment("copy args:")
			])
		for i in range(parameterInfo.paramNum):
			_from, _to = INT_BYTES * (i+2), -INT_BYTES * (i+1)
			self._E(
				[AsmInstr(f"lw t1, {_from}(fp)")] +
				push("t1"))

		self._E(
			[
			AsmComment("END PROLOGUE"),
			AsmBlank()
			])

	def genEpilogue(self, func:str):
		self._E(
			[
			AsmBlank(),
			AsmComment("BEGIN EPOLOGUE")
			] +
			push(0) + 
			[
			AsmLabel(f"{func}_exit"),
			AsmInstr("lw a0, 0(sp)"),	# get return value
			AsmInstr("mv sp, fp")
			] +
			pop("fp", "ra") + 			# restore fp before and return address
			[
			AsmInstr("jr ra"),			# return to PC before
			AsmBlank()
			])

	def genFunction(self, func:IRFunc):
		self.curFunc = func.name

		self.genPrologue(self.curFunc, func.parameterInfo)
		for instr in func.instrs:
			_g[type(instr)](self, instr)
		self.genEpilogue(self.curFunc)

	def genGlobal(self, glob:IRGlobal):
		if glob.init == None:
			self._E([AsmDirective(f".comm {glob.identifier}, {glob.size}, {glob.align}")])
		else:
			self._E([
				AsmDirective(".data"),
				AsmDirective(f".globl {glob.identifier}"),
				AsmDirective(f".align {glob.align}"),
				AsmDirective(f".size {glob.identifier}, {glob.size}"),
				AsmLabel(f"{glob.identifier}"),
				AsmDirective(f".quad {glob.init}")])


	def generateASM(self, ir):
		self.ir = ir
		for glob in ir.globals:
			self.genGlobal(glob)
		for function in ir.functions:
			self.genFunction(function)

_g = { 
	Comment: noOp,
	Label: RISCVAsmGen.visitLabel,
	Ret: RISCVAsmGen.visitRet, 

	Const: RISCVAsmGen.visitConst, 
	Unary: RISCVAsmGen.visitUnary, 
	Binary: RISCVAsmGen.visitBinary, 

	FrameSlot: RISCVAsmGen.visitFrameSlot, 
	Load: RISCVAsmGen.visitLoad, 
	Store: RISCVAsmGen.visitStore, 
	Pop: RISCVAsmGen.visitPop, 

	Branch: RISCVAsmGen.visitBranch,

	Call: RISCVAsmGen.visitCall,
	GlobalSymbol: RISCVAsmGen.visitGlobalSymbol
	}
