import sys
import argparse
from antlr4 import FileStream, CommonTokenStream, BailErrorStrategy

from .generated.MiniDecafExprLexer import MiniDecafExprLexer
from .generated.MiniDecafExprParser import MiniDecafExprParser

from .utils import *
from .ir import irGen, namespace, typeCheck
from .asm import asmGen
from .ir.namespace import NameInfo
from .ir.typer import TypeInfo


def Lexer(inputStream):
	lexer = MiniDecafExprLexer(inputStream)
	class BailErrorListener:
		def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
			raise MiniDecafError(f"lexer error at {line},{column}")
	lexer.addErrorListener(BailErrorListener())
	return CommonTokenStream(lexer)

def Parser(tokenStream):
	parser = MiniDecafExprParser(tokenStream)
	parser._errHandler = BailErrorStrategy()
	tree = parser.program() # 取得一棵以 program 为根的 AST
	return tree

def NameInfoGen(tree):
	nameVisitor = namespace.NameVisitor()
	nameVisitor.visit(tree)
	return nameVisitor.nameInfo

def TypeCheck(tree, nameInfo):
	typeInfo = typeCheck(tree, nameInfo)
	return typeInfo

def IRGen(tree, nameInfo:NameInfo, typeInfo:TypeInfo):
	ir = irGen(tree, nameInfo, typeInfo)
	return ir

def AsmGen(ir, outfile):
	if outfile is not None:
		with open(outfile, 'w') as fout:
			return asmGen(ir, fout)
	else:
		return asmGen(ir, sys.stdout)

def parseArgs(argv):
	parser = argparse.ArgumentParser(description="MiniDecaf compiler")
	parser.add_argument("infile", type=str,
					   help="the input C file")
	parser.add_argument("outfile", type=str, nargs="?",
					   help="the output assembly file")
	return parser.parse_args()

def main(argv):
	try:
		global args
		args = parseArgs(argv)

		inputStream  = FileStream(args.infile)
		tokenStream = Lexer(inputStream)
		tree = Parser(tokenStream)
		nameInfo = NameInfoGen(tree)
		typeInfo = TypeCheck(tree, nameInfo)
		ir = IRGen(tree, nameInfo, typeInfo)
		AsmGen(ir, args.outfile)

	except Exception as e:
		print(e, file=sys.stderr)
		raise e
