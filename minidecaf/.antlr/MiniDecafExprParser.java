// Generated from /home/kasumi/Documents/3rdYear1/Compiler/minidecaf-2018013443/minidecaf/MiniDecafExpr.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniDecafExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, Int=5, Return=6, If=7, Else=8, For=9, 
		Do=10, While=11, Break=12, Continue=13, Lparen=14, Rparen=15, Lbrkt=16, 
		Rbrkt=17, Lbrace=18, Rbrace=19, Comma=20, Semicolon=21, Punctuator=22, 
		Add=23, Sub=24, Mul=25, Div=26, Percent=27, Exclamation=28, Tilde=29, 
		Ampersand=30, Langle=31, Rangle=32, Langle_eq=33, Rangle_eq=34, Double_eq=35, 
		Exclam_eq=36, Equal=37, Double_amp=38, Double_bar=39, Operator=40, Integer=41, 
		Whitespace=42, Identifier=43;
	public static final int
		RULE_program = 0, RULE_externalDecline = 1, RULE_function = 2, RULE_variableType = 3, 
		RULE_parameterList = 4, RULE_declaration = 5, RULE_block = 6, RULE_blockItem = 7, 
		RULE_statement = 8, RULE_expression = 9, RULE_assign = 10, RULE_conditional = 11, 
		RULE_logical_or = 12, RULE_logical_and = 13, RULE_bit_or = 14, RULE_bit_xor = 15, 
		RULE_bit_and = 16, RULE_equal = 17, RULE_relational = 18, RULE_add = 19, 
		RULE_multiply = 20, RULE_cast = 21, RULE_unary = 22, RULE_postfix = 23, 
		RULE_argumentList = 24, RULE_atom = 25, RULE_addOperator = 26, RULE_multiplyOperator = 27, 
		RULE_equalOperator = 28, RULE_unaryOperator = 29, RULE_relationalOperator = 30, 
		RULE_assignOperator = 31;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "externalDecline", "function", "variableType", "parameterList", 
			"declaration", "block", "blockItem", "statement", "expression", "assign", 
			"conditional", "logical_or", "logical_and", "bit_or", "bit_xor", "bit_and", 
			"equal", "relational", "add", "multiply", "cast", "unary", "postfix", 
			"argumentList", "atom", "addOperator", "multiplyOperator", "equalOperator", 
			"unaryOperator", "relationalOperator", "assignOperator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'?'", "':'", "'|'", "'^'", "'int'", "'return'", "'if'", "'else'", 
			"'for'", "'do'", "'while'", "'break'", "'continue'", "'('", "')'", "'['", 
			"']'", "'{'", "'}'", "','", "';'", null, "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'!'", "'~'", "'&'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", 
			"'='", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "Int", "Return", "If", "Else", "For", "Do", 
			"While", "Break", "Continue", "Lparen", "Rparen", "Lbrkt", "Rbrkt", "Lbrace", 
			"Rbrace", "Comma", "Semicolon", "Punctuator", "Add", "Sub", "Mul", "Div", 
			"Percent", "Exclamation", "Tilde", "Ampersand", "Langle", "Rangle", "Langle_eq", 
			"Rangle_eq", "Double_eq", "Exclam_eq", "Equal", "Double_amp", "Double_bar", 
			"Operator", "Integer", "Whitespace", "Identifier"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MiniDecafExpr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniDecafExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MiniDecafExprParser.EOF, 0); }
		public List<ExternalDeclineContext> externalDecline() {
			return getRuleContexts(ExternalDeclineContext.class);
		}
		public ExternalDeclineContext externalDecline(int i) {
			return getRuleContext(ExternalDeclineContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(64);
				externalDecline();
				}
				}
				setState(67); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Int );
			setState(69);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExternalDeclineContext extends ParserRuleContext {
		public ExternalDeclineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_externalDecline; }
	 
		public ExternalDeclineContext() { }
		public void copyFrom(ExternalDeclineContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclarationExternalContext extends ExternalDeclineContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(MiniDecafExprParser.Semicolon, 0); }
		public DeclarationExternalContext(ExternalDeclineContext ctx) { copyFrom(ctx); }
	}
	public static class FunctionExternalContext extends ExternalDeclineContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FunctionExternalContext(ExternalDeclineContext ctx) { copyFrom(ctx); }
	}

	public final ExternalDeclineContext externalDecline() throws RecognitionException {
		ExternalDeclineContext _localctx = new ExternalDeclineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_externalDecline);
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new FunctionExternalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				function();
				}
				break;
			case 2:
				_localctx = new DeclarationExternalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				declaration();
				setState(73);
				match(Semicolon);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	 
		public FunctionContext() { }
		public void copyFrom(FunctionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunctionDefineContext extends FunctionContext {
		public VariableTypeContext variableType() {
			return getRuleContext(VariableTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MiniDecafExprParser.Identifier, 0); }
		public TerminalNode Lparen() { return getToken(MiniDecafExprParser.Lparen, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TerminalNode Rparen() { return getToken(MiniDecafExprParser.Rparen, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionDefineContext(FunctionContext ctx) { copyFrom(ctx); }
	}
	public static class FunctionDeclarationContext extends FunctionContext {
		public VariableTypeContext variableType() {
			return getRuleContext(VariableTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MiniDecafExprParser.Identifier, 0); }
		public TerminalNode Lparen() { return getToken(MiniDecafExprParser.Lparen, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TerminalNode Rparen() { return getToken(MiniDecafExprParser.Rparen, 0); }
		public TerminalNode Semicolon() { return getToken(MiniDecafExprParser.Semicolon, 0); }
		public FunctionDeclarationContext(FunctionContext ctx) { copyFrom(ctx); }
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function);
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new FunctionDefineContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				variableType(0);
				setState(78);
				match(Identifier);
				setState(79);
				match(Lparen);
				setState(80);
				parameterList();
				setState(81);
				match(Rparen);
				setState(82);
				block();
				}
				break;
			case 2:
				_localctx = new FunctionDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				variableType(0);
				setState(85);
				match(Identifier);
				setState(86);
				match(Lparen);
				setState(87);
				parameterList();
				setState(88);
				match(Rparen);
				setState(89);
				match(Semicolon);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableTypeContext extends ParserRuleContext {
		public VariableTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableType; }
	 
		public VariableTypeContext() { }
		public void copyFrom(VariableTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PointerTypeContext extends VariableTypeContext {
		public VariableTypeContext variableType() {
			return getRuleContext(VariableTypeContext.class,0);
		}
		public TerminalNode Mul() { return getToken(MiniDecafExprParser.Mul, 0); }
		public PointerTypeContext(VariableTypeContext ctx) { copyFrom(ctx); }
	}
	public static class IntTypeContext extends VariableTypeContext {
		public TerminalNode Int() { return getToken(MiniDecafExprParser.Int, 0); }
		public IntTypeContext(VariableTypeContext ctx) { copyFrom(ctx); }
	}

	public final VariableTypeContext variableType() throws RecognitionException {
		return variableType(0);
	}

	private VariableTypeContext variableType(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VariableTypeContext _localctx = new VariableTypeContext(_ctx, _parentState);
		VariableTypeContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_variableType, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new IntTypeContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(94);
			match(Int);
			}
			_ctx.stop = _input.LT(-1);
			setState(100);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PointerTypeContext(new VariableTypeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_variableType);
					setState(96);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(97);
					match(Mul);
					}
					} 
				}
				setState(102);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ParameterListContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MiniDecafExprParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MiniDecafExprParser.Comma, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Int) {
				{
				setState(103);
				declaration();
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(104);
					match(Comma);
					setState(105);
					declaration();
					}
					}
					setState(110);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public VariableTypeContext variableType() {
			return getRuleContext(VariableTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MiniDecafExprParser.Identifier, 0); }
		public List<TerminalNode> Lbrkt() { return getTokens(MiniDecafExprParser.Lbrkt); }
		public TerminalNode Lbrkt(int i) {
			return getToken(MiniDecafExprParser.Lbrkt, i);
		}
		public List<TerminalNode> Integer() { return getTokens(MiniDecafExprParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(MiniDecafExprParser.Integer, i);
		}
		public List<TerminalNode> Rbrkt() { return getTokens(MiniDecafExprParser.Rbrkt); }
		public TerminalNode Rbrkt(int i) {
			return getToken(MiniDecafExprParser.Rbrkt, i);
		}
		public TerminalNode Equal() { return getToken(MiniDecafExprParser.Equal, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			variableType(0);
			setState(114);
			match(Identifier);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Lbrkt) {
				{
				{
				setState(115);
				match(Lbrkt);
				setState(116);
				match(Integer);
				setState(117);
				match(Rbrkt);
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Equal) {
				{
				setState(123);
				match(Equal);
				setState(124);
				expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode Lbrace() { return getToken(MiniDecafExprParser.Lbrace, 0); }
		public TerminalNode Rbrace() { return getToken(MiniDecafExprParser.Rbrace, 0); }
		public List<BlockItemContext> blockItem() {
			return getRuleContexts(BlockItemContext.class);
		}
		public BlockItemContext blockItem(int i) {
			return getRuleContext(BlockItemContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(Lbrace);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Return) | (1L << If) | (1L << For) | (1L << Do) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Lparen) | (1L << Lbrace) | (1L << Semicolon) | (1L << Sub) | (1L << Mul) | (1L << Exclamation) | (1L << Tilde) | (1L << Ampersand) | (1L << Integer) | (1L << Identifier))) != 0)) {
				{
				{
				setState(128);
				blockItem();
				}
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(134);
			match(Rbrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockItemContext extends ParserRuleContext {
		public BlockItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItem; }
	 
		public BlockItemContext() { }
		public void copyFrom(BlockItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BlockItemStatementContext extends BlockItemContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockItemStatementContext(BlockItemContext ctx) { copyFrom(ctx); }
	}
	public static class BlockItemDeclarationContext extends BlockItemContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(MiniDecafExprParser.Semicolon, 0); }
		public BlockItemDeclarationContext(BlockItemContext ctx) { copyFrom(ctx); }
	}

	public final BlockItemContext blockItem() throws RecognitionException {
		BlockItemContext _localctx = new BlockItemContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_blockItem);
		try {
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Return:
			case If:
			case For:
			case Do:
			case While:
			case Break:
			case Continue:
			case Lparen:
			case Lbrace:
			case Semicolon:
			case Sub:
			case Mul:
			case Exclamation:
			case Tilde:
			case Ampersand:
			case Integer:
			case Identifier:
				_localctx = new BlockItemStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				statement();
				}
				break;
			case Int:
				_localctx = new BlockItemDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				declaration();
				setState(138);
				match(Semicolon);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WhileStatementContext extends StatementContext {
		public TerminalNode While() { return getToken(MiniDecafExprParser.While, 0); }
		public TerminalNode Lparen() { return getToken(MiniDecafExprParser.Lparen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Rparen() { return getToken(MiniDecafExprParser.Rparen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class BlockStatementContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class BlankStatementContext extends StatementContext {
		public TerminalNode Semicolon() { return getToken(MiniDecafExprParser.Semicolon, 0); }
		public BlankStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ForDeclarationStatementContext extends StatementContext {
		public DeclarationContext init;
		public ExpressionContext ctrl;
		public ExpressionContext post;
		public TerminalNode For() { return getToken(MiniDecafExprParser.For, 0); }
		public TerminalNode Lparen() { return getToken(MiniDecafExprParser.Lparen, 0); }
		public List<TerminalNode> Semicolon() { return getTokens(MiniDecafExprParser.Semicolon); }
		public TerminalNode Semicolon(int i) {
			return getToken(MiniDecafExprParser.Semicolon, i);
		}
		public TerminalNode Rparen() { return getToken(MiniDecafExprParser.Rparen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForDeclarationStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ForStatementContext extends StatementContext {
		public ExpressionContext init;
		public ExpressionContext ctrl;
		public ExpressionContext post;
		public TerminalNode For() { return getToken(MiniDecafExprParser.For, 0); }
		public TerminalNode Lparen() { return getToken(MiniDecafExprParser.Lparen, 0); }
		public List<TerminalNode> Semicolon() { return getTokens(MiniDecafExprParser.Semicolon); }
		public TerminalNode Semicolon(int i) {
			return getToken(MiniDecafExprParser.Semicolon, i);
		}
		public TerminalNode Rparen() { return getToken(MiniDecafExprParser.Rparen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class BreakStatementContext extends StatementContext {
		public TerminalNode Break() { return getToken(MiniDecafExprParser.Break, 0); }
		public TerminalNode Semicolon() { return getToken(MiniDecafExprParser.Semicolon, 0); }
		public BreakStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ExpressionStatementContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(MiniDecafExprParser.Semicolon, 0); }
		public ExpressionStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class DoWhileStatementContext extends StatementContext {
		public TerminalNode Do() { return getToken(MiniDecafExprParser.Do, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode While() { return getToken(MiniDecafExprParser.While, 0); }
		public TerminalNode Lparen() { return getToken(MiniDecafExprParser.Lparen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Rparen() { return getToken(MiniDecafExprParser.Rparen, 0); }
		public TerminalNode Semicolon() { return getToken(MiniDecafExprParser.Semicolon, 0); }
		public DoWhileStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ContinueStatementContext extends StatementContext {
		public TerminalNode Continue() { return getToken(MiniDecafExprParser.Continue, 0); }
		public TerminalNode Semicolon() { return getToken(MiniDecafExprParser.Semicolon, 0); }
		public ContinueStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ReturnStatementContext extends StatementContext {
		public TerminalNode Return() { return getToken(MiniDecafExprParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(MiniDecafExprParser.Semicolon, 0); }
		public ReturnStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class IfStatementContext extends StatementContext {
		public StatementContext thenStatement;
		public StatementContext elseStatement;
		public TerminalNode If() { return getToken(MiniDecafExprParser.If, 0); }
		public TerminalNode Lparen() { return getToken(MiniDecafExprParser.Lparen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Rparen() { return getToken(MiniDecafExprParser.Rparen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(MiniDecafExprParser.Else, 0); }
		public IfStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		int _la;
		try {
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				match(Return);
				setState(143);
				expression();
				setState(144);
				match(Semicolon);
				}
				break;
			case 2:
				_localctx = new ExpressionStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				expression();
				setState(147);
				match(Semicolon);
				}
				break;
			case 3:
				_localctx = new BlankStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
				match(Semicolon);
				}
				break;
			case 4:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(150);
				match(If);
				setState(151);
				match(Lparen);
				setState(152);
				expression();
				setState(153);
				match(Rparen);
				setState(154);
				((IfStatementContext)_localctx).thenStatement = statement();
				setState(157);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(155);
					match(Else);
					setState(156);
					((IfStatementContext)_localctx).elseStatement = statement();
					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new BlockStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(159);
				block();
				}
				break;
			case 6:
				_localctx = new ForDeclarationStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(160);
				match(For);
				setState(161);
				match(Lparen);
				setState(162);
				((ForDeclarationStatementContext)_localctx).init = declaration();
				setState(163);
				match(Semicolon);
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Lparen) | (1L << Sub) | (1L << Mul) | (1L << Exclamation) | (1L << Tilde) | (1L << Ampersand) | (1L << Integer) | (1L << Identifier))) != 0)) {
					{
					setState(164);
					((ForDeclarationStatementContext)_localctx).ctrl = expression();
					}
				}

				setState(167);
				match(Semicolon);
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Lparen) | (1L << Sub) | (1L << Mul) | (1L << Exclamation) | (1L << Tilde) | (1L << Ampersand) | (1L << Integer) | (1L << Identifier))) != 0)) {
					{
					setState(168);
					((ForDeclarationStatementContext)_localctx).post = expression();
					}
				}

				setState(171);
				match(Rparen);
				setState(172);
				statement();
				}
				break;
			case 7:
				_localctx = new ForStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(174);
				match(For);
				setState(175);
				match(Lparen);
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Lparen) | (1L << Sub) | (1L << Mul) | (1L << Exclamation) | (1L << Tilde) | (1L << Ampersand) | (1L << Integer) | (1L << Identifier))) != 0)) {
					{
					setState(176);
					((ForStatementContext)_localctx).init = expression();
					}
				}

				setState(179);
				match(Semicolon);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Lparen) | (1L << Sub) | (1L << Mul) | (1L << Exclamation) | (1L << Tilde) | (1L << Ampersand) | (1L << Integer) | (1L << Identifier))) != 0)) {
					{
					setState(180);
					((ForStatementContext)_localctx).ctrl = expression();
					}
				}

				setState(183);
				match(Semicolon);
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Lparen) | (1L << Sub) | (1L << Mul) | (1L << Exclamation) | (1L << Tilde) | (1L << Ampersand) | (1L << Integer) | (1L << Identifier))) != 0)) {
					{
					setState(184);
					((ForStatementContext)_localctx).post = expression();
					}
				}

				setState(187);
				match(Rparen);
				setState(188);
				statement();
				}
				break;
			case 8:
				_localctx = new WhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(189);
				match(While);
				setState(190);
				match(Lparen);
				setState(191);
				expression();
				setState(192);
				match(Rparen);
				setState(193);
				statement();
				}
				break;
			case 9:
				_localctx = new DoWhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(195);
				match(Do);
				setState(196);
				statement();
				setState(197);
				match(While);
				setState(198);
				match(Lparen);
				setState(199);
				expression();
				setState(200);
				match(Rparen);
				setState(201);
				match(Semicolon);
				}
				break;
			case 10:
				_localctx = new BreakStatementContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(203);
				match(Break);
				setState(204);
				match(Semicolon);
				}
				break;
			case 11:
				_localctx = new ContinueStatementContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(205);
				match(Continue);
				setState(206);
				match(Semicolon);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			assign();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
	 
		public AssignContext() { }
		public void copyFrom(AssignContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TAssignContext extends AssignContext {
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public TAssignContext(AssignContext ctx) { copyFrom(ctx); }
	}
	public static class CAssignContext extends AssignContext {
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public AssignOperatorContext assignOperator() {
			return getRuleContext(AssignOperatorContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public CAssignContext(AssignContext ctx) { copyFrom(ctx); }
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assign);
		try {
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new TAssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				conditional();
				}
				break;
			case 2:
				_localctx = new CAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
				unary();
				setState(213);
				assignOperator();
				setState(214);
				assign();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalContext extends ParserRuleContext {
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
	 
		public ConditionalContext() { }
		public void copyFrom(ConditionalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TConditionalContext extends ConditionalContext {
		public Logical_orContext logical_or() {
			return getRuleContext(Logical_orContext.class,0);
		}
		public TConditionalContext(ConditionalContext ctx) { copyFrom(ctx); }
	}
	public static class CConditionalContext extends ConditionalContext {
		public Logical_orContext logical_or() {
			return getRuleContext(Logical_orContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public CConditionalContext(ConditionalContext ctx) { copyFrom(ctx); }
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_conditional);
		try {
			setState(225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new TConditionalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				logical_or(0);
				}
				break;
			case 2:
				_localctx = new CConditionalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				logical_or(0);
				setState(220);
				match(T__0);
				setState(221);
				expression();
				setState(222);
				match(T__1);
				setState(223);
				conditional();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Logical_orContext extends ParserRuleContext {
		public Logical_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_or; }
	 
		public Logical_orContext() { }
		public void copyFrom(Logical_orContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TLogical_orContext extends Logical_orContext {
		public Logical_andContext logical_and() {
			return getRuleContext(Logical_andContext.class,0);
		}
		public TLogical_orContext(Logical_orContext ctx) { copyFrom(ctx); }
	}
	public static class CLogical_orContext extends Logical_orContext {
		public Logical_orContext logical_or() {
			return getRuleContext(Logical_orContext.class,0);
		}
		public TerminalNode Double_bar() { return getToken(MiniDecafExprParser.Double_bar, 0); }
		public Logical_andContext logical_and() {
			return getRuleContext(Logical_andContext.class,0);
		}
		public CLogical_orContext(Logical_orContext ctx) { copyFrom(ctx); }
	}

	public final Logical_orContext logical_or() throws RecognitionException {
		return logical_or(0);
	}

	private Logical_orContext logical_or(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Logical_orContext _localctx = new Logical_orContext(_ctx, _parentState);
		Logical_orContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_logical_or, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TLogical_orContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(228);
			logical_and(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(235);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CLogical_orContext(new Logical_orContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_logical_or);
					setState(230);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(231);
					match(Double_bar);
					setState(232);
					logical_and(0);
					}
					} 
				}
				setState(237);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Logical_andContext extends ParserRuleContext {
		public Logical_andContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_and; }
	 
		public Logical_andContext() { }
		public void copyFrom(Logical_andContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TLogical_andContext extends Logical_andContext {
		public Bit_orContext bit_or() {
			return getRuleContext(Bit_orContext.class,0);
		}
		public TLogical_andContext(Logical_andContext ctx) { copyFrom(ctx); }
	}
	public static class CLogical_andContext extends Logical_andContext {
		public Logical_andContext logical_and() {
			return getRuleContext(Logical_andContext.class,0);
		}
		public TerminalNode Double_amp() { return getToken(MiniDecafExprParser.Double_amp, 0); }
		public Bit_orContext bit_or() {
			return getRuleContext(Bit_orContext.class,0);
		}
		public CLogical_andContext(Logical_andContext ctx) { copyFrom(ctx); }
	}

	public final Logical_andContext logical_and() throws RecognitionException {
		return logical_and(0);
	}

	private Logical_andContext logical_and(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Logical_andContext _localctx = new Logical_andContext(_ctx, _parentState);
		Logical_andContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_logical_and, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TLogical_andContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(239);
			bit_or(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(246);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CLogical_andContext(new Logical_andContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_logical_and);
					setState(241);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(242);
					match(Double_amp);
					setState(243);
					bit_or(0);
					}
					} 
				}
				setState(248);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Bit_orContext extends ParserRuleContext {
		public Bit_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bit_or; }
	 
		public Bit_orContext() { }
		public void copyFrom(Bit_orContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TBit_orContext extends Bit_orContext {
		public Bit_xorContext bit_xor() {
			return getRuleContext(Bit_xorContext.class,0);
		}
		public TBit_orContext(Bit_orContext ctx) { copyFrom(ctx); }
	}
	public static class CBit_orContext extends Bit_orContext {
		public Bit_orContext bit_or() {
			return getRuleContext(Bit_orContext.class,0);
		}
		public Bit_xorContext bit_xor() {
			return getRuleContext(Bit_xorContext.class,0);
		}
		public CBit_orContext(Bit_orContext ctx) { copyFrom(ctx); }
	}

	public final Bit_orContext bit_or() throws RecognitionException {
		return bit_or(0);
	}

	private Bit_orContext bit_or(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Bit_orContext _localctx = new Bit_orContext(_ctx, _parentState);
		Bit_orContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_bit_or, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TBit_orContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(250);
			bit_xor(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(257);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CBit_orContext(new Bit_orContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_bit_or);
					setState(252);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(253);
					match(T__2);
					setState(254);
					bit_xor(0);
					}
					} 
				}
				setState(259);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Bit_xorContext extends ParserRuleContext {
		public Bit_xorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bit_xor; }
	 
		public Bit_xorContext() { }
		public void copyFrom(Bit_xorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TBit_xorContext extends Bit_xorContext {
		public Bit_andContext bit_and() {
			return getRuleContext(Bit_andContext.class,0);
		}
		public TBit_xorContext(Bit_xorContext ctx) { copyFrom(ctx); }
	}
	public static class CBit_xorContext extends Bit_xorContext {
		public Bit_xorContext bit_xor() {
			return getRuleContext(Bit_xorContext.class,0);
		}
		public Bit_andContext bit_and() {
			return getRuleContext(Bit_andContext.class,0);
		}
		public CBit_xorContext(Bit_xorContext ctx) { copyFrom(ctx); }
	}

	public final Bit_xorContext bit_xor() throws RecognitionException {
		return bit_xor(0);
	}

	private Bit_xorContext bit_xor(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Bit_xorContext _localctx = new Bit_xorContext(_ctx, _parentState);
		Bit_xorContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_bit_xor, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TBit_xorContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(261);
			bit_and(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(268);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CBit_xorContext(new Bit_xorContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_bit_xor);
					setState(263);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(264);
					match(T__3);
					setState(265);
					bit_and(0);
					}
					} 
				}
				setState(270);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Bit_andContext extends ParserRuleContext {
		public Bit_andContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bit_and; }
	 
		public Bit_andContext() { }
		public void copyFrom(Bit_andContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CBit_andContext extends Bit_andContext {
		public Bit_andContext bit_and() {
			return getRuleContext(Bit_andContext.class,0);
		}
		public TerminalNode Ampersand() { return getToken(MiniDecafExprParser.Ampersand, 0); }
		public EqualContext equal() {
			return getRuleContext(EqualContext.class,0);
		}
		public CBit_andContext(Bit_andContext ctx) { copyFrom(ctx); }
	}
	public static class TBit_andContext extends Bit_andContext {
		public EqualContext equal() {
			return getRuleContext(EqualContext.class,0);
		}
		public TBit_andContext(Bit_andContext ctx) { copyFrom(ctx); }
	}

	public final Bit_andContext bit_and() throws RecognitionException {
		return bit_and(0);
	}

	private Bit_andContext bit_and(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Bit_andContext _localctx = new Bit_andContext(_ctx, _parentState);
		Bit_andContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_bit_and, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TBit_andContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(272);
			equal(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(279);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CBit_andContext(new Bit_andContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_bit_and);
					setState(274);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(275);
					match(Ampersand);
					setState(276);
					equal(0);
					}
					} 
				}
				setState(281);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqualContext extends ParserRuleContext {
		public EqualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equal; }
	 
		public EqualContext() { }
		public void copyFrom(EqualContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CEqualContext extends EqualContext {
		public EqualContext equal() {
			return getRuleContext(EqualContext.class,0);
		}
		public EqualOperatorContext equalOperator() {
			return getRuleContext(EqualOperatorContext.class,0);
		}
		public RelationalContext relational() {
			return getRuleContext(RelationalContext.class,0);
		}
		public CEqualContext(EqualContext ctx) { copyFrom(ctx); }
	}
	public static class TEqualContext extends EqualContext {
		public RelationalContext relational() {
			return getRuleContext(RelationalContext.class,0);
		}
		public TEqualContext(EqualContext ctx) { copyFrom(ctx); }
	}

	public final EqualContext equal() throws RecognitionException {
		return equal(0);
	}

	private EqualContext equal(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualContext _localctx = new EqualContext(_ctx, _parentState);
		EqualContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_equal, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TEqualContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(283);
			relational(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(291);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CEqualContext(new EqualContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_equal);
					setState(285);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(286);
					equalOperator();
					setState(287);
					relational(0);
					}
					} 
				}
				setState(293);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RelationalContext extends ParserRuleContext {
		public RelationalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational; }
	 
		public RelationalContext() { }
		public void copyFrom(RelationalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CRelationalContext extends RelationalContext {
		public RelationalContext relational() {
			return getRuleContext(RelationalContext.class,0);
		}
		public RelationalOperatorContext relationalOperator() {
			return getRuleContext(RelationalOperatorContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public CRelationalContext(RelationalContext ctx) { copyFrom(ctx); }
	}
	public static class TRelationalContext extends RelationalContext {
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public TRelationalContext(RelationalContext ctx) { copyFrom(ctx); }
	}

	public final RelationalContext relational() throws RecognitionException {
		return relational(0);
	}

	private RelationalContext relational(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationalContext _localctx = new RelationalContext(_ctx, _parentState);
		RelationalContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_relational, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TRelationalContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(295);
			add(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(303);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CRelationalContext(new RelationalContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_relational);
					setState(297);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(298);
					relationalOperator();
					setState(299);
					add(0);
					}
					} 
				}
				setState(305);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AddContext extends ParserRuleContext {
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
	 
		public AddContext() { }
		public void copyFrom(AddContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CAddContext extends AddContext {
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public AddOperatorContext addOperator() {
			return getRuleContext(AddOperatorContext.class,0);
		}
		public MultiplyContext multiply() {
			return getRuleContext(MultiplyContext.class,0);
		}
		public CAddContext(AddContext ctx) { copyFrom(ctx); }
	}
	public static class TAddContext extends AddContext {
		public MultiplyContext multiply() {
			return getRuleContext(MultiplyContext.class,0);
		}
		public TAddContext(AddContext ctx) { copyFrom(ctx); }
	}

	public final AddContext add() throws RecognitionException {
		return add(0);
	}

	private AddContext add(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddContext _localctx = new AddContext(_ctx, _parentState);
		AddContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_add, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TAddContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(307);
			multiply(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(315);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CAddContext(new AddContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_add);
					setState(309);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(310);
					addOperator();
					setState(311);
					multiply(0);
					}
					} 
				}
				setState(317);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MultiplyContext extends ParserRuleContext {
		public MultiplyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiply; }
	 
		public MultiplyContext() { }
		public void copyFrom(MultiplyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TMultiplyContext extends MultiplyContext {
		public CastContext cast() {
			return getRuleContext(CastContext.class,0);
		}
		public TMultiplyContext(MultiplyContext ctx) { copyFrom(ctx); }
	}
	public static class CMultiplyContext extends MultiplyContext {
		public MultiplyContext multiply() {
			return getRuleContext(MultiplyContext.class,0);
		}
		public MultiplyOperatorContext multiplyOperator() {
			return getRuleContext(MultiplyOperatorContext.class,0);
		}
		public CastContext cast() {
			return getRuleContext(CastContext.class,0);
		}
		public CMultiplyContext(MultiplyContext ctx) { copyFrom(ctx); }
	}

	public final MultiplyContext multiply() throws RecognitionException {
		return multiply(0);
	}

	private MultiplyContext multiply(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplyContext _localctx = new MultiplyContext(_ctx, _parentState);
		MultiplyContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_multiply, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TMultiplyContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(319);
			cast();
			}
			_ctx.stop = _input.LT(-1);
			setState(327);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CMultiplyContext(new MultiplyContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_multiply);
					setState(321);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(322);
					multiplyOperator();
					setState(323);
					cast();
					}
					} 
				}
				setState(329);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CastContext extends ParserRuleContext {
		public CastContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast; }
	 
		public CastContext() { }
		public void copyFrom(CastContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TCastContext extends CastContext {
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public TCastContext(CastContext ctx) { copyFrom(ctx); }
	}
	public static class CCastContext extends CastContext {
		public TerminalNode Lparen() { return getToken(MiniDecafExprParser.Lparen, 0); }
		public VariableTypeContext variableType() {
			return getRuleContext(VariableTypeContext.class,0);
		}
		public TerminalNode Rparen() { return getToken(MiniDecafExprParser.Rparen, 0); }
		public CastContext cast() {
			return getRuleContext(CastContext.class,0);
		}
		public CCastContext(CastContext ctx) { copyFrom(ctx); }
	}

	public final CastContext cast() throws RecognitionException {
		CastContext _localctx = new CastContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_cast);
		try {
			setState(336);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new TCastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(330);
				unary();
				}
				break;
			case 2:
				_localctx = new CCastContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(331);
				match(Lparen);
				setState(332);
				variableType(0);
				setState(333);
				match(Rparen);
				setState(334);
				cast();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryContext extends ParserRuleContext {
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
	 
		public UnaryContext() { }
		public void copyFrom(UnaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TUnaryContext extends UnaryContext {
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public TUnaryContext(UnaryContext ctx) { copyFrom(ctx); }
	}
	public static class CUnaryContext extends UnaryContext {
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public CastContext cast() {
			return getRuleContext(CastContext.class,0);
		}
		public CUnaryContext(UnaryContext ctx) { copyFrom(ctx); }
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_unary);
		try {
			setState(342);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Lparen:
			case Integer:
			case Identifier:
				_localctx = new TUnaryContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(338);
				postfix(0);
				}
				break;
			case Sub:
			case Mul:
			case Exclamation:
			case Tilde:
			case Ampersand:
				_localctx = new CUnaryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(339);
				unaryOperator();
				setState(340);
				cast();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixContext extends ParserRuleContext {
		public PostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix; }
	 
		public PostfixContext() { }
		public void copyFrom(PostfixContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PostfixArrayContext extends PostfixContext {
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public TerminalNode Lbrkt() { return getToken(MiniDecafExprParser.Lbrkt, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Rbrkt() { return getToken(MiniDecafExprParser.Rbrkt, 0); }
		public PostfixArrayContext(PostfixContext ctx) { copyFrom(ctx); }
	}
	public static class PostfixCallContext extends PostfixContext {
		public TerminalNode Identifier() { return getToken(MiniDecafExprParser.Identifier, 0); }
		public TerminalNode Lparen() { return getToken(MiniDecafExprParser.Lparen, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public TerminalNode Rparen() { return getToken(MiniDecafExprParser.Rparen, 0); }
		public PostfixCallContext(PostfixContext ctx) { copyFrom(ctx); }
	}
	public static class TPostfixContext extends PostfixContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TPostfixContext(PostfixContext ctx) { copyFrom(ctx); }
	}

	public final PostfixContext postfix() throws RecognitionException {
		return postfix(0);
	}

	private PostfixContext postfix(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PostfixContext _localctx = new PostfixContext(_ctx, _parentState);
		PostfixContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_postfix, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				_localctx = new TPostfixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(345);
				atom();
				}
				break;
			case 2:
				{
				_localctx = new PostfixCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(346);
				match(Identifier);
				setState(347);
				match(Lparen);
				setState(348);
				argumentList();
				setState(349);
				match(Rparen);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(360);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PostfixArrayContext(new PostfixContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_postfix);
					setState(353);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(354);
					match(Lbrkt);
					setState(355);
					expression();
					setState(356);
					match(Rbrkt);
					}
					} 
				}
				setState(362);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArgumentListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MiniDecafExprParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MiniDecafExprParser.Comma, i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Lparen) | (1L << Sub) | (1L << Mul) | (1L << Exclamation) | (1L << Tilde) | (1L << Ampersand) | (1L << Integer) | (1L << Identifier))) != 0)) {
				{
				setState(363);
				expression();
				setState(368);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(364);
					match(Comma);
					setState(365);
					expression();
					}
					}
					setState(370);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AtomIdentifierContext extends AtomContext {
		public TerminalNode Identifier() { return getToken(MiniDecafExprParser.Identifier, 0); }
		public AtomIdentifierContext(AtomContext ctx) { copyFrom(ctx); }
	}
	public static class AtomIntegerContext extends AtomContext {
		public TerminalNode Integer() { return getToken(MiniDecafExprParser.Integer, 0); }
		public AtomIntegerContext(AtomContext ctx) { copyFrom(ctx); }
	}
	public static class AtomParenContext extends AtomContext {
		public TerminalNode Lparen() { return getToken(MiniDecafExprParser.Lparen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Rparen() { return getToken(MiniDecafExprParser.Rparen, 0); }
		public AtomParenContext(AtomContext ctx) { copyFrom(ctx); }
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_atom);
		try {
			setState(379);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Integer:
				_localctx = new AtomIntegerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(373);
				match(Integer);
				}
				break;
			case Identifier:
				_localctx = new AtomIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(374);
				match(Identifier);
				}
				break;
			case Lparen:
				_localctx = new AtomParenContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(375);
				match(Lparen);
				setState(376);
				expression();
				setState(377);
				match(Rparen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddOperatorContext extends ParserRuleContext {
		public TerminalNode Add() { return getToken(MiniDecafExprParser.Add, 0); }
		public TerminalNode Sub() { return getToken(MiniDecafExprParser.Sub, 0); }
		public AddOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOperator; }
	}

	public final AddOperatorContext addOperator() throws RecognitionException {
		AddOperatorContext _localctx = new AddOperatorContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_addOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			_la = _input.LA(1);
			if ( !(_la==Add || _la==Sub) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplyOperatorContext extends ParserRuleContext {
		public TerminalNode Mul() { return getToken(MiniDecafExprParser.Mul, 0); }
		public TerminalNode Div() { return getToken(MiniDecafExprParser.Div, 0); }
		public TerminalNode Percent() { return getToken(MiniDecafExprParser.Percent, 0); }
		public MultiplyOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplyOperator; }
	}

	public final MultiplyOperatorContext multiplyOperator() throws RecognitionException {
		MultiplyOperatorContext _localctx = new MultiplyOperatorContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_multiplyOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mul) | (1L << Div) | (1L << Percent))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualOperatorContext extends ParserRuleContext {
		public TerminalNode Double_eq() { return getToken(MiniDecafExprParser.Double_eq, 0); }
		public TerminalNode Exclam_eq() { return getToken(MiniDecafExprParser.Exclam_eq, 0); }
		public EqualOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalOperator; }
	}

	public final EqualOperatorContext equalOperator() throws RecognitionException {
		EqualOperatorContext _localctx = new EqualOperatorContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_equalOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			_la = _input.LA(1);
			if ( !(_la==Double_eq || _la==Exclam_eq) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryOperatorContext extends ParserRuleContext {
		public TerminalNode Sub() { return getToken(MiniDecafExprParser.Sub, 0); }
		public TerminalNode Exclamation() { return getToken(MiniDecafExprParser.Exclamation, 0); }
		public TerminalNode Tilde() { return getToken(MiniDecafExprParser.Tilde, 0); }
		public TerminalNode Mul() { return getToken(MiniDecafExprParser.Mul, 0); }
		public TerminalNode Ampersand() { return getToken(MiniDecafExprParser.Ampersand, 0); }
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Sub) | (1L << Mul) | (1L << Exclamation) | (1L << Tilde) | (1L << Ampersand))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalOperatorContext extends ParserRuleContext {
		public TerminalNode Langle() { return getToken(MiniDecafExprParser.Langle, 0); }
		public TerminalNode Rangle() { return getToken(MiniDecafExprParser.Rangle, 0); }
		public TerminalNode Langle_eq() { return getToken(MiniDecafExprParser.Langle_eq, 0); }
		public TerminalNode Rangle_eq() { return getToken(MiniDecafExprParser.Rangle_eq, 0); }
		public RelationalOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalOperator; }
	}

	public final RelationalOperatorContext relationalOperator() throws RecognitionException {
		RelationalOperatorContext _localctx = new RelationalOperatorContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_relationalOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Langle) | (1L << Rangle) | (1L << Langle_eq) | (1L << Rangle_eq))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignOperatorContext extends ParserRuleContext {
		public TerminalNode Equal() { return getToken(MiniDecafExprParser.Equal, 0); }
		public AssignOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignOperator; }
	}

	public final AssignOperatorContext assignOperator() throws RecognitionException {
		AssignOperatorContext _localctx = new AssignOperatorContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_assignOperator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			match(Equal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return variableType_sempred((VariableTypeContext)_localctx, predIndex);
		case 12:
			return logical_or_sempred((Logical_orContext)_localctx, predIndex);
		case 13:
			return logical_and_sempred((Logical_andContext)_localctx, predIndex);
		case 14:
			return bit_or_sempred((Bit_orContext)_localctx, predIndex);
		case 15:
			return bit_xor_sempred((Bit_xorContext)_localctx, predIndex);
		case 16:
			return bit_and_sempred((Bit_andContext)_localctx, predIndex);
		case 17:
			return equal_sempred((EqualContext)_localctx, predIndex);
		case 18:
			return relational_sempred((RelationalContext)_localctx, predIndex);
		case 19:
			return add_sempred((AddContext)_localctx, predIndex);
		case 20:
			return multiply_sempred((MultiplyContext)_localctx, predIndex);
		case 23:
			return postfix_sempred((PostfixContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean variableType_sempred(VariableTypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logical_or_sempred(Logical_orContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logical_and_sempred(Logical_andContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean bit_or_sempred(Bit_orContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean bit_xor_sempred(Bit_xorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean bit_and_sempred(Bit_andContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equal_sempred(EqualContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relational_sempred(RelationalContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean add_sempred(AddContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiply_sempred(MultiplyContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean postfix_sempred(PostfixContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u018c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\6\2D\n\2\r\2\16\2E\3\2\3\2\3\3\3\3\3\3\3\3\5\3N\n\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4^\n\4\3\5\3\5\3\5\3"+
		"\5\3\5\7\5e\n\5\f\5\16\5h\13\5\3\6\3\6\3\6\7\6m\n\6\f\6\16\6p\13\6\5\6"+
		"r\n\6\3\7\3\7\3\7\3\7\3\7\7\7y\n\7\f\7\16\7|\13\7\3\7\3\7\5\7\u0080\n"+
		"\7\3\b\3\b\7\b\u0084\n\b\f\b\16\b\u0087\13\b\3\b\3\b\3\t\3\t\3\t\3\t\5"+
		"\t\u008f\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\5\n\u00a0\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a8\n\n\3\n\3\n\5\n\u00ac"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00b4\n\n\3\n\3\n\5\n\u00b8\n\n\3\n\3"+
		"\n\5\n\u00bc\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00d2\n\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\5\f\u00db\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00e4\n\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\7\16\u00ec\n\16\f\16\16\16\u00ef\13\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\7\17\u00f7\n\17\f\17\16\17\u00fa\13\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\7\20\u0102\n\20\f\20\16\20\u0105\13\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\7\21\u010d\n\21\f\21\16\21\u0110\13\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\7\22\u0118\n\22\f\22\16\22\u011b\13\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\7\23\u0124\n\23\f\23\16\23\u0127\13\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\7\24\u0130\n\24\f\24\16\24\u0133\13\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u013c\n\25\f\25\16\25\u013f\13\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u0148\n\26\f\26\16\26\u014b\13"+
		"\26\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0153\n\27\3\30\3\30\3\30\3\30"+
		"\5\30\u0159\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0162\n\31\3"+
		"\31\3\31\3\31\3\31\3\31\7\31\u0169\n\31\f\31\16\31\u016c\13\31\3\32\3"+
		"\32\3\32\7\32\u0171\n\32\f\32\16\32\u0174\13\32\5\32\u0176\n\32\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\5\33\u017e\n\33\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3!\3!\3!\2\r\b\32\34\36 \"$&(*\60\"\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@\2\7\3\2\31\32\3\2\33\35"+
		"\3\2%&\4\2\32\33\36 \3\2!$\2\u0198\2C\3\2\2\2\4M\3\2\2\2\6]\3\2\2\2\b"+
		"_\3\2\2\2\nq\3\2\2\2\fs\3\2\2\2\16\u0081\3\2\2\2\20\u008e\3\2\2\2\22\u00d1"+
		"\3\2\2\2\24\u00d3\3\2\2\2\26\u00da\3\2\2\2\30\u00e3\3\2\2\2\32\u00e5\3"+
		"\2\2\2\34\u00f0\3\2\2\2\36\u00fb\3\2\2\2 \u0106\3\2\2\2\"\u0111\3\2\2"+
		"\2$\u011c\3\2\2\2&\u0128\3\2\2\2(\u0134\3\2\2\2*\u0140\3\2\2\2,\u0152"+
		"\3\2\2\2.\u0158\3\2\2\2\60\u0161\3\2\2\2\62\u0175\3\2\2\2\64\u017d\3\2"+
		"\2\2\66\u017f\3\2\2\28\u0181\3\2\2\2:\u0183\3\2\2\2<\u0185\3\2\2\2>\u0187"+
		"\3\2\2\2@\u0189\3\2\2\2BD\5\4\3\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2"+
		"\2\2FG\3\2\2\2GH\7\2\2\3H\3\3\2\2\2IN\5\6\4\2JK\5\f\7\2KL\7\27\2\2LN\3"+
		"\2\2\2MI\3\2\2\2MJ\3\2\2\2N\5\3\2\2\2OP\5\b\5\2PQ\7-\2\2QR\7\20\2\2RS"+
		"\5\n\6\2ST\7\21\2\2TU\5\16\b\2U^\3\2\2\2VW\5\b\5\2WX\7-\2\2XY\7\20\2\2"+
		"YZ\5\n\6\2Z[\7\21\2\2[\\\7\27\2\2\\^\3\2\2\2]O\3\2\2\2]V\3\2\2\2^\7\3"+
		"\2\2\2_`\b\5\1\2`a\7\7\2\2af\3\2\2\2bc\f\3\2\2ce\7\33\2\2db\3\2\2\2eh"+
		"\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\t\3\2\2\2hf\3\2\2\2in\5\f\7\2jk\7\26\2\2"+
		"km\5\f\7\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2or\3\2\2\2pn\3\2\2\2"+
		"qi\3\2\2\2qr\3\2\2\2r\13\3\2\2\2st\5\b\5\2tz\7-\2\2uv\7\22\2\2vw\7+\2"+
		"\2wy\7\23\2\2xu\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\177\3\2\2\2|z\3"+
		"\2\2\2}~\7\'\2\2~\u0080\5\24\13\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"\r\3\2\2\2\u0081\u0085\7\24\2\2\u0082\u0084\5\20\t\2\u0083\u0082\3\2\2"+
		"\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0088"+
		"\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u0089\7\25\2\2\u0089\17\3\2\2\2\u008a"+
		"\u008f\5\22\n\2\u008b\u008c\5\f\7\2\u008c\u008d\7\27\2\2\u008d\u008f\3"+
		"\2\2\2\u008e\u008a\3\2\2\2\u008e\u008b\3\2\2\2\u008f\21\3\2\2\2\u0090"+
		"\u0091\7\b\2\2\u0091\u0092\5\24\13\2\u0092\u0093\7\27\2\2\u0093\u00d2"+
		"\3\2\2\2\u0094\u0095\5\24\13\2\u0095\u0096\7\27\2\2\u0096\u00d2\3\2\2"+
		"\2\u0097\u00d2\7\27\2\2\u0098\u0099\7\t\2\2\u0099\u009a\7\20\2\2\u009a"+
		"\u009b\5\24\13\2\u009b\u009c\7\21\2\2\u009c\u009f\5\22\n\2\u009d\u009e"+
		"\7\n\2\2\u009e\u00a0\5\22\n\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2"+
		"\u00a0\u00d2\3\2\2\2\u00a1\u00d2\5\16\b\2\u00a2\u00a3\7\13\2\2\u00a3\u00a4"+
		"\7\20\2\2\u00a4\u00a5\5\f\7\2\u00a5\u00a7\7\27\2\2\u00a6\u00a8\5\24\13"+
		"\2\u00a7\u00a6\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab"+
		"\7\27\2\2\u00aa\u00ac\5\24\13\2\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3\2\2"+
		"\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7\21\2\2\u00ae\u00af\5\22\n\2\u00af"+
		"\u00d2\3\2\2\2\u00b0\u00b1\7\13\2\2\u00b1\u00b3\7\20\2\2\u00b2\u00b4\5"+
		"\24\13\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"\u00b7\7\27\2\2\u00b6\u00b8\5\24\13\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8"+
		"\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bb\7\27\2\2\u00ba\u00bc\5\24\13"+
		"\2\u00bb\u00ba\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be"+
		"\7\21\2\2\u00be\u00d2\5\22\n\2\u00bf\u00c0\7\r\2\2\u00c0\u00c1\7\20\2"+
		"\2\u00c1\u00c2\5\24\13\2\u00c2\u00c3\7\21\2\2\u00c3\u00c4\5\22\n\2\u00c4"+
		"\u00d2\3\2\2\2\u00c5\u00c6\7\f\2\2\u00c6\u00c7\5\22\n\2\u00c7\u00c8\7"+
		"\r\2\2\u00c8\u00c9\7\20\2\2\u00c9\u00ca\5\24\13\2\u00ca\u00cb\7\21\2\2"+
		"\u00cb\u00cc\7\27\2\2\u00cc\u00d2\3\2\2\2\u00cd\u00ce\7\16\2\2\u00ce\u00d2"+
		"\7\27\2\2\u00cf\u00d0\7\17\2\2\u00d0\u00d2\7\27\2\2\u00d1\u0090\3\2\2"+
		"\2\u00d1\u0094\3\2\2\2\u00d1\u0097\3\2\2\2\u00d1\u0098\3\2\2\2\u00d1\u00a1"+
		"\3\2\2\2\u00d1\u00a2\3\2\2\2\u00d1\u00b0\3\2\2\2\u00d1\u00bf\3\2\2\2\u00d1"+
		"\u00c5\3\2\2\2\u00d1\u00cd\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\23\3\2\2"+
		"\2\u00d3\u00d4\5\26\f\2\u00d4\25\3\2\2\2\u00d5\u00db\5\30\r\2\u00d6\u00d7"+
		"\5.\30\2\u00d7\u00d8\5@!\2\u00d8\u00d9\5\26\f\2\u00d9\u00db\3\2\2\2\u00da"+
		"\u00d5\3\2\2\2\u00da\u00d6\3\2\2\2\u00db\27\3\2\2\2\u00dc\u00e4\5\32\16"+
		"\2\u00dd\u00de\5\32\16\2\u00de\u00df\7\3\2\2\u00df\u00e0\5\24\13\2\u00e0"+
		"\u00e1\7\4\2\2\u00e1\u00e2\5\30\r\2\u00e2\u00e4\3\2\2\2\u00e3\u00dc\3"+
		"\2\2\2\u00e3\u00dd\3\2\2\2\u00e4\31\3\2\2\2\u00e5\u00e6\b\16\1\2\u00e6"+
		"\u00e7\5\34\17\2\u00e7\u00ed\3\2\2\2\u00e8\u00e9\f\3\2\2\u00e9\u00ea\7"+
		")\2\2\u00ea\u00ec\5\34\17\2\u00eb\u00e8\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed"+
		"\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\33\3\2\2\2\u00ef\u00ed\3\2\2"+
		"\2\u00f0\u00f1\b\17\1\2\u00f1\u00f2\5\36\20\2\u00f2\u00f8\3\2\2\2\u00f3"+
		"\u00f4\f\3\2\2\u00f4\u00f5\7(\2\2\u00f5\u00f7\5\36\20\2\u00f6\u00f3\3"+
		"\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9"+
		"\35\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fc\b\20\1\2\u00fc\u00fd\5 \21"+
		"\2\u00fd\u0103\3\2\2\2\u00fe\u00ff\f\3\2\2\u00ff\u0100\7\5\2\2\u0100\u0102"+
		"\5 \21\2\u0101\u00fe\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2\2\2\u0103"+
		"\u0104\3\2\2\2\u0104\37\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0107\b\21\1"+
		"\2\u0107\u0108\5\"\22\2\u0108\u010e\3\2\2\2\u0109\u010a\f\3\2\2\u010a"+
		"\u010b\7\6\2\2\u010b\u010d\5\"\22\2\u010c\u0109\3\2\2\2\u010d\u0110\3"+
		"\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f!\3\2\2\2\u0110\u010e"+
		"\3\2\2\2\u0111\u0112\b\22\1\2\u0112\u0113\5$\23\2\u0113\u0119\3\2\2\2"+
		"\u0114\u0115\f\3\2\2\u0115\u0116\7 \2\2\u0116\u0118\5$\23\2\u0117\u0114"+
		"\3\2\2\2\u0118\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a"+
		"#\3\2\2\2\u011b\u0119\3\2\2\2\u011c\u011d\b\23\1\2\u011d\u011e\5&\24\2"+
		"\u011e\u0125\3\2\2\2\u011f\u0120\f\3\2\2\u0120\u0121\5:\36\2\u0121\u0122"+
		"\5&\24\2\u0122\u0124\3\2\2\2\u0123\u011f\3\2\2\2\u0124\u0127\3\2\2\2\u0125"+
		"\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126%\3\2\2\2\u0127\u0125\3\2\2\2"+
		"\u0128\u0129\b\24\1\2\u0129\u012a\5(\25\2\u012a\u0131\3\2\2\2\u012b\u012c"+
		"\f\3\2\2\u012c\u012d\5> \2\u012d\u012e\5(\25\2\u012e\u0130\3\2\2\2\u012f"+
		"\u012b\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2"+
		"\2\2\u0132\'\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0135\b\25\1\2\u0135\u0136"+
		"\5*\26\2\u0136\u013d\3\2\2\2\u0137\u0138\f\3\2\2\u0138\u0139\5\66\34\2"+
		"\u0139\u013a\5*\26\2\u013a\u013c\3\2\2\2\u013b\u0137\3\2\2\2\u013c\u013f"+
		"\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e)\3\2\2\2\u013f"+
		"\u013d\3\2\2\2\u0140\u0141\b\26\1\2\u0141\u0142\5,\27\2\u0142\u0149\3"+
		"\2\2\2\u0143\u0144\f\3\2\2\u0144\u0145\58\35\2\u0145\u0146\5,\27\2\u0146"+
		"\u0148\3\2\2\2\u0147\u0143\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147\3\2"+
		"\2\2\u0149\u014a\3\2\2\2\u014a+\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u0153"+
		"\5.\30\2\u014d\u014e\7\20\2\2\u014e\u014f\5\b\5\2\u014f\u0150\7\21\2\2"+
		"\u0150\u0151\5,\27\2\u0151\u0153\3\2\2\2\u0152\u014c\3\2\2\2\u0152\u014d"+
		"\3\2\2\2\u0153-\3\2\2\2\u0154\u0159\5\60\31\2\u0155\u0156\5<\37\2\u0156"+
		"\u0157\5,\27\2\u0157\u0159\3\2\2\2\u0158\u0154\3\2\2\2\u0158\u0155\3\2"+
		"\2\2\u0159/\3\2\2\2\u015a\u015b\b\31\1\2\u015b\u0162\5\64\33\2\u015c\u015d"+
		"\7-\2\2\u015d\u015e\7\20\2\2\u015e\u015f\5\62\32\2\u015f\u0160\7\21\2"+
		"\2\u0160\u0162\3\2\2\2\u0161\u015a\3\2\2\2\u0161\u015c\3\2\2\2\u0162\u016a"+
		"\3\2\2\2\u0163\u0164\f\4\2\2\u0164\u0165\7\22\2\2\u0165\u0166\5\24\13"+
		"\2\u0166\u0167\7\23\2\2\u0167\u0169\3\2\2\2\u0168\u0163\3\2\2\2\u0169"+
		"\u016c\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\61\3\2\2"+
		"\2\u016c\u016a\3\2\2\2\u016d\u0172\5\24\13\2\u016e\u016f\7\26\2\2\u016f"+
		"\u0171\5\24\13\2\u0170\u016e\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3"+
		"\2\2\2\u0172\u0173\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172\3\2\2\2\u0175"+
		"\u016d\3\2\2\2\u0175\u0176\3\2\2\2\u0176\63\3\2\2\2\u0177\u017e\7+\2\2"+
		"\u0178\u017e\7-\2\2\u0179\u017a\7\20\2\2\u017a\u017b\5\24\13\2\u017b\u017c"+
		"\7\21\2\2\u017c\u017e\3\2\2\2\u017d\u0177\3\2\2\2\u017d\u0178\3\2\2\2"+
		"\u017d\u0179\3\2\2\2\u017e\65\3\2\2\2\u017f\u0180\t\2\2\2\u0180\67\3\2"+
		"\2\2\u0181\u0182\t\3\2\2\u01829\3\2\2\2\u0183\u0184\t\4\2\2\u0184;\3\2"+
		"\2\2\u0185\u0186\t\5\2\2\u0186=\3\2\2\2\u0187\u0188\t\6\2\2\u0188?\3\2"+
		"\2\2\u0189\u018a\7\'\2\2\u018aA\3\2\2\2%EM]fnqz\177\u0085\u008e\u009f"+
		"\u00a7\u00ab\u00b3\u00b7\u00bb\u00d1\u00da\u00e3\u00ed\u00f8\u0103\u010e"+
		"\u0119\u0125\u0131\u013d\u0149\u0152\u0158\u0161\u016a\u0172\u0175\u017d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}