// Generated from /home/kasumi/Documents/3rdYear1/Compiler/minidecaf-2018013443/minidecaf/MiniDecafExpr.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniDecafExprLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "Int", "Return", "If", "Else", "For", 
			"Do", "While", "Break", "Continue", "Lparen", "Rparen", "Lbrkt", "Rbrkt", 
			"Lbrace", "Rbrace", "Comma", "Semicolon", "Punctuator", "Add", "Sub", 
			"Mul", "Div", "Percent", "Exclamation", "Tilde", "Ampersand", "Langle", 
			"Rangle", "Langle_eq", "Rangle_eq", "Double_eq", "Exclam_eq", "Equal", 
			"Double_amp", "Double_bar", "Operator", "Integer", "Whitespace", "Identifier", 
			"IdentLead", "WordChar", "Digit"
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


	public MiniDecafExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiniDecafExpr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u0104\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\5\27\u00af\n\27\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\""+
		"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u00ea\n)\3*\6*\u00ed\n*\r"+
		"*\16*\u00ee\3+\6+\u00f2\n+\r+\16+\u00f3\3+\3+\3,\3,\7,\u00fa\n,\f,\16"+
		",\u00fd\13,\3-\3-\3.\3.\3/\3/\2\2\60\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y\2"+
		"[\2]\2\3\2\6\5\2\13\f\17\17\"\"\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\2\u011a"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\3_\3\2\2\2\5a\3\2\2\2\7c\3\2\2\2\te\3\2\2\2\13g\3"+
		"\2\2\2\rk\3\2\2\2\17r\3\2\2\2\21u\3\2\2\2\23z\3\2\2\2\25~\3\2\2\2\27\u0081"+
		"\3\2\2\2\31\u0087\3\2\2\2\33\u008d\3\2\2\2\35\u0096\3\2\2\2\37\u0098\3"+
		"\2\2\2!\u009a\3\2\2\2#\u009c\3\2\2\2%\u009e\3\2\2\2\'\u00a0\3\2\2\2)\u00a2"+
		"\3\2\2\2+\u00a4\3\2\2\2-\u00ae\3\2\2\2/\u00b0\3\2\2\2\61\u00b2\3\2\2\2"+
		"\63\u00b4\3\2\2\2\65\u00b6\3\2\2\2\67\u00b8\3\2\2\29\u00ba\3\2\2\2;\u00bc"+
		"\3\2\2\2=\u00be\3\2\2\2?\u00c0\3\2\2\2A\u00c2\3\2\2\2C\u00c4\3\2\2\2E"+
		"\u00c7\3\2\2\2G\u00ca\3\2\2\2I\u00cd\3\2\2\2K\u00d0\3\2\2\2M\u00d2\3\2"+
		"\2\2O\u00d5\3\2\2\2Q\u00e9\3\2\2\2S\u00ec\3\2\2\2U\u00f1\3\2\2\2W\u00f7"+
		"\3\2\2\2Y\u00fe\3\2\2\2[\u0100\3\2\2\2]\u0102\3\2\2\2_`\7A\2\2`\4\3\2"+
		"\2\2ab\7<\2\2b\6\3\2\2\2cd\7~\2\2d\b\3\2\2\2ef\7`\2\2f\n\3\2\2\2gh\7k"+
		"\2\2hi\7p\2\2ij\7v\2\2j\f\3\2\2\2kl\7t\2\2lm\7g\2\2mn\7v\2\2no\7w\2\2"+
		"op\7t\2\2pq\7p\2\2q\16\3\2\2\2rs\7k\2\2st\7h\2\2t\20\3\2\2\2uv\7g\2\2"+
		"vw\7n\2\2wx\7u\2\2xy\7g\2\2y\22\3\2\2\2z{\7h\2\2{|\7q\2\2|}\7t\2\2}\24"+
		"\3\2\2\2~\177\7f\2\2\177\u0080\7q\2\2\u0080\26\3\2\2\2\u0081\u0082\7y"+
		"\2\2\u0082\u0083\7j\2\2\u0083\u0084\7k\2\2\u0084\u0085\7n\2\2\u0085\u0086"+
		"\7g\2\2\u0086\30\3\2\2\2\u0087\u0088\7d\2\2\u0088\u0089\7t\2\2\u0089\u008a"+
		"\7g\2\2\u008a\u008b\7c\2\2\u008b\u008c\7m\2\2\u008c\32\3\2\2\2\u008d\u008e"+
		"\7e\2\2\u008e\u008f\7q\2\2\u008f\u0090\7p\2\2\u0090\u0091\7v\2\2\u0091"+
		"\u0092\7k\2\2\u0092\u0093\7p\2\2\u0093\u0094\7w\2\2\u0094\u0095\7g\2\2"+
		"\u0095\34\3\2\2\2\u0096\u0097\7*\2\2\u0097\36\3\2\2\2\u0098\u0099\7+\2"+
		"\2\u0099 \3\2\2\2\u009a\u009b\7]\2\2\u009b\"\3\2\2\2\u009c\u009d\7_\2"+
		"\2\u009d$\3\2\2\2\u009e\u009f\7}\2\2\u009f&\3\2\2\2\u00a0\u00a1\7\177"+
		"\2\2\u00a1(\3\2\2\2\u00a2\u00a3\7.\2\2\u00a3*\3\2\2\2\u00a4\u00a5\7=\2"+
		"\2\u00a5,\3\2\2\2\u00a6\u00af\5\35\17\2\u00a7\u00af\5\37\20\2\u00a8\u00af"+
		"\5!\21\2\u00a9\u00af\5#\22\2\u00aa\u00af\5%\23\2\u00ab\u00af\5\'\24\2"+
		"\u00ac\u00af\5)\25\2\u00ad\u00af\5+\26\2\u00ae\u00a6\3\2\2\2\u00ae\u00a7"+
		"\3\2\2\2\u00ae\u00a8\3\2\2\2\u00ae\u00a9\3\2\2\2\u00ae\u00aa\3\2\2\2\u00ae"+
		"\u00ab\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af.\3\2\2\2"+
		"\u00b0\u00b1\7-\2\2\u00b1\60\3\2\2\2\u00b2\u00b3\7/\2\2\u00b3\62\3\2\2"+
		"\2\u00b4\u00b5\7,\2\2\u00b5\64\3\2\2\2\u00b6\u00b7\7\61\2\2\u00b7\66\3"+
		"\2\2\2\u00b8\u00b9\7\'\2\2\u00b98\3\2\2\2\u00ba\u00bb\7#\2\2\u00bb:\3"+
		"\2\2\2\u00bc\u00bd\7\u0080\2\2\u00bd<\3\2\2\2\u00be\u00bf\7(\2\2\u00bf"+
		">\3\2\2\2\u00c0\u00c1\7>\2\2\u00c1@\3\2\2\2\u00c2\u00c3\7@\2\2\u00c3B"+
		"\3\2\2\2\u00c4\u00c5\7>\2\2\u00c5\u00c6\7?\2\2\u00c6D\3\2\2\2\u00c7\u00c8"+
		"\7@\2\2\u00c8\u00c9\7?\2\2\u00c9F\3\2\2\2\u00ca\u00cb\7?\2\2\u00cb\u00cc"+
		"\7?\2\2\u00ccH\3\2\2\2\u00cd\u00ce\7#\2\2\u00ce\u00cf\7?\2\2\u00cfJ\3"+
		"\2\2\2\u00d0\u00d1\7?\2\2\u00d1L\3\2\2\2\u00d2\u00d3\7(\2\2\u00d3\u00d4"+
		"\7(\2\2\u00d4N\3\2\2\2\u00d5\u00d6\7~\2\2\u00d6\u00d7\7~\2\2\u00d7P\3"+
		"\2\2\2\u00d8\u00ea\5/\30\2\u00d9\u00ea\5\61\31\2\u00da\u00ea\5\63\32\2"+
		"\u00db\u00ea\5\65\33\2\u00dc\u00ea\5\67\34\2\u00dd\u00ea\59\35\2\u00de"+
		"\u00ea\5;\36\2\u00df\u00ea\5=\37\2\u00e0\u00ea\5? \2\u00e1\u00ea\5A!\2"+
		"\u00e2\u00ea\5C\"\2\u00e3\u00ea\5E#\2\u00e4\u00ea\5G$\2\u00e5\u00ea\5"+
		"I%\2\u00e6\u00ea\5K&\2\u00e7\u00ea\5M\'\2\u00e8\u00ea\5O(\2\u00e9\u00d8"+
		"\3\2\2\2\u00e9\u00d9\3\2\2\2\u00e9\u00da\3\2\2\2\u00e9\u00db\3\2\2\2\u00e9"+
		"\u00dc\3\2\2\2\u00e9\u00dd\3\2\2\2\u00e9\u00de\3\2\2\2\u00e9\u00df\3\2"+
		"\2\2\u00e9\u00e0\3\2\2\2\u00e9\u00e1\3\2\2\2\u00e9\u00e2\3\2\2\2\u00e9"+
		"\u00e3\3\2\2\2\u00e9\u00e4\3\2\2\2\u00e9\u00e5\3\2\2\2\u00e9\u00e6\3\2"+
		"\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00e8\3\2\2\2\u00eaR\3\2\2\2\u00eb\u00ed"+
		"\5]/\2\u00ec\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00efT\3\2\2\2\u00f0\u00f2\t\2\2\2\u00f1\u00f0\3\2\2\2"+
		"\u00f2\u00f3\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5"+
		"\3\2\2\2\u00f5\u00f6\b+\2\2\u00f6V\3\2\2\2\u00f7\u00fb\5Y-\2\u00f8\u00fa"+
		"\5[.\2\u00f9\u00f8\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb"+
		"\u00fc\3\2\2\2\u00fcX\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u00ff\t\3\2\2"+
		"\u00ffZ\3\2\2\2\u0100\u0101\t\4\2\2\u0101\\\3\2\2\2\u0102\u0103\t\5\2"+
		"\2\u0103^\3\2\2\2\b\2\u00ae\u00e9\u00ee\u00f3\u00fb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}