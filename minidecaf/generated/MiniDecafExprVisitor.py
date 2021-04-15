# Generated from MiniDecafExpr.g4 by ANTLR 4.8
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .MiniDecafExprParser import MiniDecafExprParser
else:
    from MiniDecafExprParser import MiniDecafExprParser

# This class defines a complete generic visitor for a parse tree produced by MiniDecafExprParser.

class MiniDecafExprVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by MiniDecafExprParser#program.
    def visitProgram(self, ctx:MiniDecafExprParser.ProgramContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#functionExternal.
    def visitFunctionExternal(self, ctx:MiniDecafExprParser.FunctionExternalContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#declarationExternal.
    def visitDeclarationExternal(self, ctx:MiniDecafExprParser.DeclarationExternalContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#functionDefine.
    def visitFunctionDefine(self, ctx:MiniDecafExprParser.FunctionDefineContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#functionDeclaration.
    def visitFunctionDeclaration(self, ctx:MiniDecafExprParser.FunctionDeclarationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#pointerType.
    def visitPointerType(self, ctx:MiniDecafExprParser.PointerTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#intType.
    def visitIntType(self, ctx:MiniDecafExprParser.IntTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#parameterList.
    def visitParameterList(self, ctx:MiniDecafExprParser.ParameterListContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#declaration.
    def visitDeclaration(self, ctx:MiniDecafExprParser.DeclarationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#block.
    def visitBlock(self, ctx:MiniDecafExprParser.BlockContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#blockItemStatement.
    def visitBlockItemStatement(self, ctx:MiniDecafExprParser.BlockItemStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#blockItemDeclaration.
    def visitBlockItemDeclaration(self, ctx:MiniDecafExprParser.BlockItemDeclarationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#returnStatement.
    def visitReturnStatement(self, ctx:MiniDecafExprParser.ReturnStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#expressionStatement.
    def visitExpressionStatement(self, ctx:MiniDecafExprParser.ExpressionStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#blankStatement.
    def visitBlankStatement(self, ctx:MiniDecafExprParser.BlankStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#ifStatement.
    def visitIfStatement(self, ctx:MiniDecafExprParser.IfStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#blockStatement.
    def visitBlockStatement(self, ctx:MiniDecafExprParser.BlockStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#forDeclarationStatement.
    def visitForDeclarationStatement(self, ctx:MiniDecafExprParser.ForDeclarationStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#forStatement.
    def visitForStatement(self, ctx:MiniDecafExprParser.ForStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#whileStatement.
    def visitWhileStatement(self, ctx:MiniDecafExprParser.WhileStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#doWhileStatement.
    def visitDoWhileStatement(self, ctx:MiniDecafExprParser.DoWhileStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#breakStatement.
    def visitBreakStatement(self, ctx:MiniDecafExprParser.BreakStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#continueStatement.
    def visitContinueStatement(self, ctx:MiniDecafExprParser.ContinueStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#expression.
    def visitExpression(self, ctx:MiniDecafExprParser.ExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#tAssign.
    def visitTAssign(self, ctx:MiniDecafExprParser.TAssignContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#cAssign.
    def visitCAssign(self, ctx:MiniDecafExprParser.CAssignContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#tConditional.
    def visitTConditional(self, ctx:MiniDecafExprParser.TConditionalContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#cConditional.
    def visitCConditional(self, ctx:MiniDecafExprParser.CConditionalContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#tLogical_or.
    def visitTLogical_or(self, ctx:MiniDecafExprParser.TLogical_orContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#cLogical_or.
    def visitCLogical_or(self, ctx:MiniDecafExprParser.CLogical_orContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#tLogical_and.
    def visitTLogical_and(self, ctx:MiniDecafExprParser.TLogical_andContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#cLogical_and.
    def visitCLogical_and(self, ctx:MiniDecafExprParser.CLogical_andContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#tBit_or.
    def visitTBit_or(self, ctx:MiniDecafExprParser.TBit_orContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#cBit_or.
    def visitCBit_or(self, ctx:MiniDecafExprParser.CBit_orContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#tBit_xor.
    def visitTBit_xor(self, ctx:MiniDecafExprParser.TBit_xorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#cBit_xor.
    def visitCBit_xor(self, ctx:MiniDecafExprParser.CBit_xorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#cBit_and.
    def visitCBit_and(self, ctx:MiniDecafExprParser.CBit_andContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#tBit_and.
    def visitTBit_and(self, ctx:MiniDecafExprParser.TBit_andContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#cEqual.
    def visitCEqual(self, ctx:MiniDecafExprParser.CEqualContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#tEqual.
    def visitTEqual(self, ctx:MiniDecafExprParser.TEqualContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#cRelational.
    def visitCRelational(self, ctx:MiniDecafExprParser.CRelationalContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#tRelational.
    def visitTRelational(self, ctx:MiniDecafExprParser.TRelationalContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#cAdd.
    def visitCAdd(self, ctx:MiniDecafExprParser.CAddContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#tAdd.
    def visitTAdd(self, ctx:MiniDecafExprParser.TAddContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#tMultiply.
    def visitTMultiply(self, ctx:MiniDecafExprParser.TMultiplyContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#cMultiply.
    def visitCMultiply(self, ctx:MiniDecafExprParser.CMultiplyContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#tCast.
    def visitTCast(self, ctx:MiniDecafExprParser.TCastContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#cCast.
    def visitCCast(self, ctx:MiniDecafExprParser.CCastContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#tUnary.
    def visitTUnary(self, ctx:MiniDecafExprParser.TUnaryContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#cUnary.
    def visitCUnary(self, ctx:MiniDecafExprParser.CUnaryContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#postfixArray.
    def visitPostfixArray(self, ctx:MiniDecafExprParser.PostfixArrayContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#postfixCall.
    def visitPostfixCall(self, ctx:MiniDecafExprParser.PostfixCallContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#tPostfix.
    def visitTPostfix(self, ctx:MiniDecafExprParser.TPostfixContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#argumentList.
    def visitArgumentList(self, ctx:MiniDecafExprParser.ArgumentListContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#atomInteger.
    def visitAtomInteger(self, ctx:MiniDecafExprParser.AtomIntegerContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#atomIdentifier.
    def visitAtomIdentifier(self, ctx:MiniDecafExprParser.AtomIdentifierContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#atomParen.
    def visitAtomParen(self, ctx:MiniDecafExprParser.AtomParenContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#addOperator.
    def visitAddOperator(self, ctx:MiniDecafExprParser.AddOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#multiplyOperator.
    def visitMultiplyOperator(self, ctx:MiniDecafExprParser.MultiplyOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#equalOperator.
    def visitEqualOperator(self, ctx:MiniDecafExprParser.EqualOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#unaryOperator.
    def visitUnaryOperator(self, ctx:MiniDecafExprParser.UnaryOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#relationalOperator.
    def visitRelationalOperator(self, ctx:MiniDecafExprParser.RelationalOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafExprParser#assignOperator.
    def visitAssignOperator(self, ctx:MiniDecafExprParser.AssignOperatorContext):
        return self.visitChildren(ctx)



del MiniDecafExprParser