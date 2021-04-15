# Generated from MiniDecafExpr.g4 by ANTLR 4.8
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .MiniDecafExprParser import MiniDecafExprParser
else:
    from MiniDecafExprParser import MiniDecafExprParser

# This class defines a complete listener for a parse tree produced by MiniDecafExprParser.
class MiniDecafExprListener(ParseTreeListener):

    # Enter a parse tree produced by MiniDecafExprParser#program.
    def enterProgram(self, ctx:MiniDecafExprParser.ProgramContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#program.
    def exitProgram(self, ctx:MiniDecafExprParser.ProgramContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#functionExternal.
    def enterFunctionExternal(self, ctx:MiniDecafExprParser.FunctionExternalContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#functionExternal.
    def exitFunctionExternal(self, ctx:MiniDecafExprParser.FunctionExternalContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#declarationExternal.
    def enterDeclarationExternal(self, ctx:MiniDecafExprParser.DeclarationExternalContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#declarationExternal.
    def exitDeclarationExternal(self, ctx:MiniDecafExprParser.DeclarationExternalContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#functionDefine.
    def enterFunctionDefine(self, ctx:MiniDecafExprParser.FunctionDefineContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#functionDefine.
    def exitFunctionDefine(self, ctx:MiniDecafExprParser.FunctionDefineContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#functionDeclaration.
    def enterFunctionDeclaration(self, ctx:MiniDecafExprParser.FunctionDeclarationContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#functionDeclaration.
    def exitFunctionDeclaration(self, ctx:MiniDecafExprParser.FunctionDeclarationContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#pointerType.
    def enterPointerType(self, ctx:MiniDecafExprParser.PointerTypeContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#pointerType.
    def exitPointerType(self, ctx:MiniDecafExprParser.PointerTypeContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#intType.
    def enterIntType(self, ctx:MiniDecafExprParser.IntTypeContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#intType.
    def exitIntType(self, ctx:MiniDecafExprParser.IntTypeContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#parameterList.
    def enterParameterList(self, ctx:MiniDecafExprParser.ParameterListContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#parameterList.
    def exitParameterList(self, ctx:MiniDecafExprParser.ParameterListContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#declaration.
    def enterDeclaration(self, ctx:MiniDecafExprParser.DeclarationContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#declaration.
    def exitDeclaration(self, ctx:MiniDecafExprParser.DeclarationContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#block.
    def enterBlock(self, ctx:MiniDecafExprParser.BlockContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#block.
    def exitBlock(self, ctx:MiniDecafExprParser.BlockContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#blockItemStatement.
    def enterBlockItemStatement(self, ctx:MiniDecafExprParser.BlockItemStatementContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#blockItemStatement.
    def exitBlockItemStatement(self, ctx:MiniDecafExprParser.BlockItemStatementContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#blockItemDeclaration.
    def enterBlockItemDeclaration(self, ctx:MiniDecafExprParser.BlockItemDeclarationContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#blockItemDeclaration.
    def exitBlockItemDeclaration(self, ctx:MiniDecafExprParser.BlockItemDeclarationContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#returnStatement.
    def enterReturnStatement(self, ctx:MiniDecafExprParser.ReturnStatementContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#returnStatement.
    def exitReturnStatement(self, ctx:MiniDecafExprParser.ReturnStatementContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#expressionStatement.
    def enterExpressionStatement(self, ctx:MiniDecafExprParser.ExpressionStatementContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#expressionStatement.
    def exitExpressionStatement(self, ctx:MiniDecafExprParser.ExpressionStatementContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#blankStatement.
    def enterBlankStatement(self, ctx:MiniDecafExprParser.BlankStatementContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#blankStatement.
    def exitBlankStatement(self, ctx:MiniDecafExprParser.BlankStatementContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#ifStatement.
    def enterIfStatement(self, ctx:MiniDecafExprParser.IfStatementContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#ifStatement.
    def exitIfStatement(self, ctx:MiniDecafExprParser.IfStatementContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#blockStatement.
    def enterBlockStatement(self, ctx:MiniDecafExprParser.BlockStatementContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#blockStatement.
    def exitBlockStatement(self, ctx:MiniDecafExprParser.BlockStatementContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#forDeclarationStatement.
    def enterForDeclarationStatement(self, ctx:MiniDecafExprParser.ForDeclarationStatementContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#forDeclarationStatement.
    def exitForDeclarationStatement(self, ctx:MiniDecafExprParser.ForDeclarationStatementContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#forStatement.
    def enterForStatement(self, ctx:MiniDecafExprParser.ForStatementContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#forStatement.
    def exitForStatement(self, ctx:MiniDecafExprParser.ForStatementContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#whileStatement.
    def enterWhileStatement(self, ctx:MiniDecafExprParser.WhileStatementContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#whileStatement.
    def exitWhileStatement(self, ctx:MiniDecafExprParser.WhileStatementContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#doWhileStatement.
    def enterDoWhileStatement(self, ctx:MiniDecafExprParser.DoWhileStatementContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#doWhileStatement.
    def exitDoWhileStatement(self, ctx:MiniDecafExprParser.DoWhileStatementContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#breakStatement.
    def enterBreakStatement(self, ctx:MiniDecafExprParser.BreakStatementContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#breakStatement.
    def exitBreakStatement(self, ctx:MiniDecafExprParser.BreakStatementContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#continueStatement.
    def enterContinueStatement(self, ctx:MiniDecafExprParser.ContinueStatementContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#continueStatement.
    def exitContinueStatement(self, ctx:MiniDecafExprParser.ContinueStatementContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#expression.
    def enterExpression(self, ctx:MiniDecafExprParser.ExpressionContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#expression.
    def exitExpression(self, ctx:MiniDecafExprParser.ExpressionContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#tAssign.
    def enterTAssign(self, ctx:MiniDecafExprParser.TAssignContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#tAssign.
    def exitTAssign(self, ctx:MiniDecafExprParser.TAssignContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#cAssign.
    def enterCAssign(self, ctx:MiniDecafExprParser.CAssignContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#cAssign.
    def exitCAssign(self, ctx:MiniDecafExprParser.CAssignContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#tConditional.
    def enterTConditional(self, ctx:MiniDecafExprParser.TConditionalContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#tConditional.
    def exitTConditional(self, ctx:MiniDecafExprParser.TConditionalContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#cConditional.
    def enterCConditional(self, ctx:MiniDecafExprParser.CConditionalContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#cConditional.
    def exitCConditional(self, ctx:MiniDecafExprParser.CConditionalContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#tLogical_or.
    def enterTLogical_or(self, ctx:MiniDecafExprParser.TLogical_orContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#tLogical_or.
    def exitTLogical_or(self, ctx:MiniDecafExprParser.TLogical_orContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#cLogical_or.
    def enterCLogical_or(self, ctx:MiniDecafExprParser.CLogical_orContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#cLogical_or.
    def exitCLogical_or(self, ctx:MiniDecafExprParser.CLogical_orContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#tLogical_and.
    def enterTLogical_and(self, ctx:MiniDecafExprParser.TLogical_andContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#tLogical_and.
    def exitTLogical_and(self, ctx:MiniDecafExprParser.TLogical_andContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#cLogical_and.
    def enterCLogical_and(self, ctx:MiniDecafExprParser.CLogical_andContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#cLogical_and.
    def exitCLogical_and(self, ctx:MiniDecafExprParser.CLogical_andContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#tBit_or.
    def enterTBit_or(self, ctx:MiniDecafExprParser.TBit_orContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#tBit_or.
    def exitTBit_or(self, ctx:MiniDecafExprParser.TBit_orContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#cBit_or.
    def enterCBit_or(self, ctx:MiniDecafExprParser.CBit_orContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#cBit_or.
    def exitCBit_or(self, ctx:MiniDecafExprParser.CBit_orContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#tBit_xor.
    def enterTBit_xor(self, ctx:MiniDecafExprParser.TBit_xorContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#tBit_xor.
    def exitTBit_xor(self, ctx:MiniDecafExprParser.TBit_xorContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#cBit_xor.
    def enterCBit_xor(self, ctx:MiniDecafExprParser.CBit_xorContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#cBit_xor.
    def exitCBit_xor(self, ctx:MiniDecafExprParser.CBit_xorContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#cBit_and.
    def enterCBit_and(self, ctx:MiniDecafExprParser.CBit_andContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#cBit_and.
    def exitCBit_and(self, ctx:MiniDecafExprParser.CBit_andContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#tBit_and.
    def enterTBit_and(self, ctx:MiniDecafExprParser.TBit_andContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#tBit_and.
    def exitTBit_and(self, ctx:MiniDecafExprParser.TBit_andContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#cEqual.
    def enterCEqual(self, ctx:MiniDecafExprParser.CEqualContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#cEqual.
    def exitCEqual(self, ctx:MiniDecafExprParser.CEqualContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#tEqual.
    def enterTEqual(self, ctx:MiniDecafExprParser.TEqualContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#tEqual.
    def exitTEqual(self, ctx:MiniDecafExprParser.TEqualContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#cRelational.
    def enterCRelational(self, ctx:MiniDecafExprParser.CRelationalContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#cRelational.
    def exitCRelational(self, ctx:MiniDecafExprParser.CRelationalContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#tRelational.
    def enterTRelational(self, ctx:MiniDecafExprParser.TRelationalContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#tRelational.
    def exitTRelational(self, ctx:MiniDecafExprParser.TRelationalContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#cAdd.
    def enterCAdd(self, ctx:MiniDecafExprParser.CAddContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#cAdd.
    def exitCAdd(self, ctx:MiniDecafExprParser.CAddContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#tAdd.
    def enterTAdd(self, ctx:MiniDecafExprParser.TAddContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#tAdd.
    def exitTAdd(self, ctx:MiniDecafExprParser.TAddContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#tMultiply.
    def enterTMultiply(self, ctx:MiniDecafExprParser.TMultiplyContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#tMultiply.
    def exitTMultiply(self, ctx:MiniDecafExprParser.TMultiplyContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#cMultiply.
    def enterCMultiply(self, ctx:MiniDecafExprParser.CMultiplyContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#cMultiply.
    def exitCMultiply(self, ctx:MiniDecafExprParser.CMultiplyContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#tCast.
    def enterTCast(self, ctx:MiniDecafExprParser.TCastContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#tCast.
    def exitTCast(self, ctx:MiniDecafExprParser.TCastContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#cCast.
    def enterCCast(self, ctx:MiniDecafExprParser.CCastContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#cCast.
    def exitCCast(self, ctx:MiniDecafExprParser.CCastContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#tUnary.
    def enterTUnary(self, ctx:MiniDecafExprParser.TUnaryContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#tUnary.
    def exitTUnary(self, ctx:MiniDecafExprParser.TUnaryContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#cUnary.
    def enterCUnary(self, ctx:MiniDecafExprParser.CUnaryContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#cUnary.
    def exitCUnary(self, ctx:MiniDecafExprParser.CUnaryContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#postfixArray.
    def enterPostfixArray(self, ctx:MiniDecafExprParser.PostfixArrayContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#postfixArray.
    def exitPostfixArray(self, ctx:MiniDecafExprParser.PostfixArrayContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#postfixCall.
    def enterPostfixCall(self, ctx:MiniDecafExprParser.PostfixCallContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#postfixCall.
    def exitPostfixCall(self, ctx:MiniDecafExprParser.PostfixCallContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#tPostfix.
    def enterTPostfix(self, ctx:MiniDecafExprParser.TPostfixContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#tPostfix.
    def exitTPostfix(self, ctx:MiniDecafExprParser.TPostfixContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#argumentList.
    def enterArgumentList(self, ctx:MiniDecafExprParser.ArgumentListContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#argumentList.
    def exitArgumentList(self, ctx:MiniDecafExprParser.ArgumentListContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#atomInteger.
    def enterAtomInteger(self, ctx:MiniDecafExprParser.AtomIntegerContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#atomInteger.
    def exitAtomInteger(self, ctx:MiniDecafExprParser.AtomIntegerContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#atomIdentifier.
    def enterAtomIdentifier(self, ctx:MiniDecafExprParser.AtomIdentifierContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#atomIdentifier.
    def exitAtomIdentifier(self, ctx:MiniDecafExprParser.AtomIdentifierContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#atomParen.
    def enterAtomParen(self, ctx:MiniDecafExprParser.AtomParenContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#atomParen.
    def exitAtomParen(self, ctx:MiniDecafExprParser.AtomParenContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#addOperator.
    def enterAddOperator(self, ctx:MiniDecafExprParser.AddOperatorContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#addOperator.
    def exitAddOperator(self, ctx:MiniDecafExprParser.AddOperatorContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#multiplyOperator.
    def enterMultiplyOperator(self, ctx:MiniDecafExprParser.MultiplyOperatorContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#multiplyOperator.
    def exitMultiplyOperator(self, ctx:MiniDecafExprParser.MultiplyOperatorContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#equalOperator.
    def enterEqualOperator(self, ctx:MiniDecafExprParser.EqualOperatorContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#equalOperator.
    def exitEqualOperator(self, ctx:MiniDecafExprParser.EqualOperatorContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#unaryOperator.
    def enterUnaryOperator(self, ctx:MiniDecafExprParser.UnaryOperatorContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#unaryOperator.
    def exitUnaryOperator(self, ctx:MiniDecafExprParser.UnaryOperatorContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#relationalOperator.
    def enterRelationalOperator(self, ctx:MiniDecafExprParser.RelationalOperatorContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#relationalOperator.
    def exitRelationalOperator(self, ctx:MiniDecafExprParser.RelationalOperatorContext):
        pass


    # Enter a parse tree produced by MiniDecafExprParser#assignOperator.
    def enterAssignOperator(self, ctx:MiniDecafExprParser.AssignOperatorContext):
        pass

    # Exit a parse tree produced by MiniDecafExprParser#assignOperator.
    def exitAssignOperator(self, ctx:MiniDecafExprParser.AssignOperatorContext):
        pass



del MiniDecafExprParser