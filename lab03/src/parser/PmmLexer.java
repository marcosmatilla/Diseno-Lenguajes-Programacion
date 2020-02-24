// Generated from C:/Users/Marcos/Desktop/INFORMATICA/TERCERO/2/DLP/lab/DLP_1920/lab03/src/parser\Pmm.g4 by ANTLR 4.8
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PmmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, INT_CONSTANT=17, 
		REAL_CONSTANT=18, REAL=19, ID=20, CHAR_CONSTANT=21, COMMENT=22, MULTIPLE_COMMENT=23, 
		WHITE_SPACE=24, TAB=25, NEW_LINE=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "INT_CONSTANT", 
			"REAL_CONSTANT", "REAL", "ID", "CHAR_CONSTANT", "COMMENT", "MULTIPLE_COMMENT", 
			"WHITE_SPACE", "TAB", "NEW_LINE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'*'", "'/'", "'+'", "'-'", "'>'", 
			"'>='", "'<'", "'<='", "'!='", "'=='", "'&&'", "'||'", null, null, null, 
			null, null, null, null, "' '", "'\t'", "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "INT_CONSTANT", "REAL_CONSTANT", "REAL", 
			"ID", "CHAR_CONSTANT", "COMMENT", "MULTIPLE_COMMENT", "WHITE_SPACE", 
			"TAB", "NEW_LINE"
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


	public PmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Pmm.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u00cb\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\7"+
		"\22a\n\22\f\22\16\22d\13\22\5\22f\n\22\3\23\3\23\3\23\5\23k\n\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\5\23s\n\23\3\23\3\23\5\23w\n\23\3\24\5\24z\n"+
		"\24\3\24\3\24\3\24\3\24\3\24\5\24\u0081\n\24\5\24\u0083\n\24\3\25\3\25"+
		"\7\25\u0087\n\25\f\25\16\25\u008a\13\25\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u009c\n\26\f\26"+
		"\16\26\u009f\13\26\3\26\5\26\u00a2\n\26\3\27\3\27\7\27\u00a6\n\27\f\27"+
		"\16\27\u00a9\13\27\3\27\5\27\u00ac\n\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\7\30\u00b5\n\30\f\30\16\30\u00b8\13\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\4\u00a7"+
		"\u00b6\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\3\2"+
		"\t\3\2\63;\3\2\62;\4\2GGgg\5\2--//~~\3\2C|\4\2\62;C|\3\3\f\f\2\u00da\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2\59\3\2\2\2\7;\3\2"+
		"\2\2\t=\3\2\2\2\13?\3\2\2\2\rA\3\2\2\2\17C\3\2\2\2\21E\3\2\2\2\23G\3\2"+
		"\2\2\25I\3\2\2\2\27L\3\2\2\2\31N\3\2\2\2\33Q\3\2\2\2\35T\3\2\2\2\37W\3"+
		"\2\2\2!Z\3\2\2\2#e\3\2\2\2%v\3\2\2\2\'\u0082\3\2\2\2)\u0084\3\2\2\2+\u00a1"+
		"\3\2\2\2-\u00a3\3\2\2\2/\u00af\3\2\2\2\61\u00bf\3\2\2\2\63\u00c3\3\2\2"+
		"\2\65\u00c7\3\2\2\2\678\7*\2\28\4\3\2\2\29:\7+\2\2:\6\3\2\2\2;<\7]\2\2"+
		"<\b\3\2\2\2=>\7_\2\2>\n\3\2\2\2?@\7,\2\2@\f\3\2\2\2AB\7\61\2\2B\16\3\2"+
		"\2\2CD\7-\2\2D\20\3\2\2\2EF\7/\2\2F\22\3\2\2\2GH\7@\2\2H\24\3\2\2\2IJ"+
		"\7@\2\2JK\7?\2\2K\26\3\2\2\2LM\7>\2\2M\30\3\2\2\2NO\7>\2\2OP\7?\2\2P\32"+
		"\3\2\2\2QR\7#\2\2RS\7?\2\2S\34\3\2\2\2TU\7?\2\2UV\7?\2\2V\36\3\2\2\2W"+
		"X\7(\2\2XY\7(\2\2Y \3\2\2\2Z[\7~\2\2[\\\7~\2\2\\\"\3\2\2\2]f\7\62\2\2"+
		"^b\t\2\2\2_a\t\3\2\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2cf\3\2\2\2"+
		"db\3\2\2\2e]\3\2\2\2e^\3\2\2\2f$\3\2\2\2gh\5\'\24\2hj\t\4\2\2ik\t\5\2"+
		"\2ji\3\2\2\2jk\3\2\2\2kl\3\2\2\2lm\5#\22\2mw\3\2\2\2nw\5\'\24\2op\5#\22"+
		"\2pr\t\4\2\2qs\t\5\2\2rq\3\2\2\2rs\3\2\2\2st\3\2\2\2tu\5#\22\2uw\3\2\2"+
		"\2vg\3\2\2\2vn\3\2\2\2vo\3\2\2\2w&\3\2\2\2xz\5#\22\2yx\3\2\2\2yz\3\2\2"+
		"\2z{\3\2\2\2{|\7\60\2\2|\u0083\5#\22\2}~\5#\22\2~\u0080\7\60\2\2\177\u0081"+
		"\5#\22\2\u0080\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083\3\2\2\2\u0082"+
		"y\3\2\2\2\u0082}\3\2\2\2\u0083(\3\2\2\2\u0084\u0088\t\6\2\2\u0085\u0087"+
		"\t\7\2\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089*\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\7)\2\2\u008c"+
		"\u008d\13\2\2\2\u008d\u00a2\7)\2\2\u008e\u008f\7)\2\2\u008f\u0090\7^\2"+
		"\2\u0090\u0091\7p\2\2\u0091\u0092\3\2\2\2\u0092\u00a2\7)\2\2\u0093\u0094"+
		"\7)\2\2\u0094\u0095\7^\2\2\u0095\u0096\7v\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u00a2\7)\2\2\u0098\u0099\7)\2\2\u0099\u009d\7^\2\2\u009a\u009c\5#\22"+
		"\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e"+
		"\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a2\7)\2\2\u00a1"+
		"\u008b\3\2\2\2\u00a1\u008e\3\2\2\2\u00a1\u0093\3\2\2\2\u00a1\u0098\3\2"+
		"\2\2\u00a2,\3\2\2\2\u00a3\u00a7\7%\2\2\u00a4\u00a6\13\2\2\2\u00a5\u00a4"+
		"\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8"+
		"\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ac\t\b\2\2\u00ab\u00aa\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\b\27\2\2\u00ae.\3\2\2\2\u00af\u00b0"+
		"\7$\2\2\u00b0\u00b1\7$\2\2\u00b1\u00b2\7$\2\2\u00b2\u00b6\3\2\2\2\u00b3"+
		"\u00b5\13\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b7\3"+
		"\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9"+
		"\u00ba\7$\2\2\u00ba\u00bb\7$\2\2\u00bb\u00bc\7$\2\2\u00bc\u00bd\3\2\2"+
		"\2\u00bd\u00be\b\30\2\2\u00be\60\3\2\2\2\u00bf\u00c0\7\"\2\2\u00c0\u00c1"+
		"\3\2\2\2\u00c1\u00c2\b\31\2\2\u00c2\62\3\2\2\2\u00c3\u00c4\7\13\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00c6\b\32\2\2\u00c6\64\3\2\2\2\u00c7\u00c8\7\f\2"+
		"\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\b\33\2\2\u00ca\66\3\2\2\2\21\2bejr"+
		"vy\u0080\u0082\u0088\u009d\u00a1\u00a7\u00ab\u00b6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}