import sys
from copy import deepcopy

INT_BYTES = 4

MAX_INT = 2**(INT_BYTES*8-1) - 1
MIN_INT = -2**(INT_BYTES*8-1)

class MiniDecafError(Exception):
	def __init__(self, *args, **kwargs):
		super().__init__(*args, *kwargs)


class MiniDecafLocatedError(MiniDecafError):
	def __init__(self, ctx, msg:str):
		self.msg = msg
		self.locatedMsg = f"input:{ctx.start.line},{ctx.start.column}: {msg}"

	def __str__(self):
		return self.locatedMsg


class MiniDecafTypeError(MiniDecafLocatedError):
	def __init__(self, ctx, msg:str):
		self.msg = msg
		self.locatedMsg = f"input:{ctx.start.line},{ctx.start.column}: {msg}"

	def __str__(self):
		return self.locatedMsg


class stacked_dict:
	def __init__(self):
		self._s = [{}]
		self._d = [{}]

	def __getitem__(self, key):
		return self._s[-1][key]

	def __setitem__(self, key, value):
		self._d[-1][key] = self._s[-1][key] = value

	def __contains__(self, key):
		return key in self._s[-1]

	def __len__(self):
		return len(self._s[-1])

	def push(self):
		self._s.append(deepcopy(self._s[-1]))
		self._d.append({})

	def pop(self):
		assert len(self._s) > 1
		self._s.pop()
		self._d.pop()

	def peek(self, last=0):
		return self._d[-1-last]


def text(x):
	if type(x) is str:
		return x
	if x is not None:
		return str(x.getText())


def flatten(l):
	r = []
	for i in l:
		if type(i) is list:
			r += flatten(i)
		else:
			r += [i]
	return r


def incOrInit(d:dict, key, init=0):
	if key in d:
		d[key] += 1
	else:
		d[key] = init


def noOp(*args, **kwargs):
	pass


def listFind(f, l):
	for i, v in enumerate(l):
		if f(v):
			return i, v
	return None


def safeEval(s:str):
	from ast import literal_eval
	return literal_eval(s)


def prod(l):
	s = 1
	for i in l:
		s *= i
	return s


def expandIterableKey(d:list):
	d2 = {}
	for (keys, val) in d:
		for key in keys:
			d2[key] = val
	return d2


unaryOps = ['-', '!', '~', '&', '*']
unaryOpStrs = ["neg", 'lnot', "not", "addrof", "deref"]
strOfUnaryOp = {o: s for (o, s) in zip(unaryOps, unaryOpStrs)}

arithOps = ['+', '-', '*', '/', '%']
eqOps = ["==", "!="]
relOps = ["<", "<=", ">", ">="]
eqrelOps = eqOps + relOps
logicOps = ["&&", "||"]
bitOps = ["&", "|", "^"]
logicbitOps = logicOps + bitOps
binaryOps = arithOps + eqOps + relOps + logicOps + bitOps
binaryOpStrs = ["add", "sub", "mul", "div", "rem", "eq", "ne", "lt", "le", "gt", "ge", "land", "lor"]
strOfBinaryOp = {o: s for (o, s) in zip(binaryOps, binaryOpStrs)}

branchOps = ["br", "beqz", "bnez", "beq", "bne"]
