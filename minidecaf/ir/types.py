from ..utils import *


# abstract class
class Type:
	def __repr__(self):
		return self.__str__()

	def sizeof(self):
		raise Exception("abstract type is unsized")



# exact class
class VoidType:
	def __init__(self):
		self.base = None

	def __str__(self):
		return "void"

	def __eq__(self, target):
		return isinstance(target, VoidType)

	def sizeof(self):
		raise Exception("void type size undefined")


class IntType(Type):
	def __init__(self):
		self.base = None

	def __str__(self):
		return "int"

	def __eq__(self, target):
		return isinstance(target, IntType)

	def sizeof(self):
		return INT_BYTES


class PointerType(Type):
	def __init__(self, base:Type):
		self.base = base

	def __str__(self):
		return f"{self.base}*"

	def __eq__(self, target):
		if not isinstance(target, PointerType):
			return False
		return self.base == target.base

	def sizeof(self):
		return INT_BYTES


class ArrayType(Type):
	def __init__(self, base:Type, len:int):
		self.base = base
		self.len = len

	def __str__(self):
		return f"{self.base}[{self.len}]"

	def __eq__(self, target):
		if not isinstance(target, ArrayType):
			return False
		return self.base == target.base and self.len == target.len

	def make(base:Type, dimensions:list):
		# 套娃生成数组
		# 最内一层是int/pointer等非数组类型
		newArray = base
		for len in reversed(dimensions):
			newArray = ArrayType(newArray, len)
		return newArray

	def sizeof(self):
		return self.base.sizeof() * self.len


class NullType(IntType, PointerType):
	def __init__(self):
		pass

	def __str__(self):
		return "null"

	def __eq__(self, target):
		return isinstance(target, IntType) or isinstance(target, PointerType)



def TypeRule(f):
	"""A type rule is a function: (ctx, *inputTypes) -> {outputType | errStr | None}.
	The ctx parameter is only used for error reporting."""
	def g(ctx, *inTy):
		res = f(ctx, *inTy)
		if type(res) is str:
			raise MiniDecafTypeError(ctx, f"{f.__name__}: {res}")
		if res is None:
			raise MiniDecafTypeError(ctx, f"{f.__name__}: type error")
		return res
	g.__name__ = f.__name__ # black magic
	return g


def tryEach(name="tryEach", *fs):
	"""Combine multiple type rules `fs`, returns result the first that does not fail."""
	@TypeRule
	def g(ctx, *inTy):
		errs = []
		for f in fs:
			try:
				return f(ctx, *inTy)
			except MiniDecafTypeError as e:
				errs += [e.msg]
		return f"{name}:\n\t" + '\n\t'.join(map(str, errs))
	g.__name__ = name # black magic
	return g


@TypeRule
def conditionalRule(ctx, conditional, success, fail):
	if conditional == IntType() and success == fail:
		return success

@TypeRule
def intBinaryOperateRule(ctx, lhs, rhs):
	if lhs == IntType() and rhs == IntType():
		return IntType()
	return f"integer expected, got {lhs} and {rhs}"

@TypeRule
def intUnaryOperateRule(ctx, ty):
	if ty == IntType():
		return IntType()
	return f"integer expected, got {ty}"

@TypeRule
def pointerArithmeticRule(ctx, lhs, rhs):
	# 指针的数学运算
	if lhs == IntType() and isinstance(rhs, PointerType):
		return rhs
	if rhs == IntType() and isinstance(lhs, PointerType):
		return lhs
	return f"pointer and integer expected, got {lhs} and {rhs}"

@TypeRule
def pointerDifferentRule(ctx, lhs, rhs):
	if lhs == rhs and isinstance(rhs, PointerType):
		return IntType()
	return f"two pointers of the same type expected, got {lhs} and {rhs}"

@TypeRule
def dereferenceRule(ctx, ty):
	# 解引用
	if isinstance(ty, PointerType):
		return ty.base
	return f"pointer expected, got {ty}"

@TypeRule
def getAddressRule(ctx, ty):
	# 求地址
	if isinstance(ty, ArrayType):
		return f"cannot get address of {ty}"
	return PointerType(ty)

@TypeRule
def equalRule(ctx, lhs, rhs):
	if lhs != rhs or isinstance(lhs, ArrayType):
		return f"cannot equate {lhs} to {rhs}"
	return IntType()

@TypeRule
def relationalRule(ctx, lhs, rhs):
	if lhs != rhs:
		return f"cannot compare {lhs} to {rhs}"
	if lhs != IntType():
		return f"cannot compare {lhs}"
	return IntType()

@TypeRule
def assignRule(ctx, lhs, rhs):
	if lhs != rhs or isinstance(lhs, ArrayType):
		return f"cannot assign {rhs} to {lhs}"
	return lhs

@TypeRule
def returnRule(ctx, functionReturnType, ty):
	if functionReturnType != ty:
		return f"return {functionReturnType} expected, {ty} found"
	return VoidType()

@TypeRule
def statementConditionalRule(ctx, ty):
	if ty != IntType():
		return f"integer expected, {ty} found"
	return VoidType()


@TypeRule
def arrayRule(ctx, array, index):
	if not isinstance(array, ArrayType) and not isinstance(array, PointerType):
		return f"array/pointer expected, {array} found"
	if index != IntType():
		return f"index must be an integer, {index} found"
	return array.base
