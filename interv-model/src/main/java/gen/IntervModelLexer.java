// Generated from C:/Users/mcram/OneDrive - Instituto Superior de Engenharia do Porto/sem4pi-23-24-2da1/interv-model/src/main/java/IntervModel.g4 by ANTLR 4.13.1
package gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class IntervModelLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, QUESTION_ID=3, ANSWER_ID=4, DATE=5, RANGE=6, TIME=7, INDEX=8, 
		DOUBLE=9, INT=10, DIGIT=11, TEXT=12, ALL_CHAR=13, YEAR=14, MONTH=15, DAY=16, 
		DATE_SEPARATOR=17, HOUR=18, MINUTE=19, NEWLINE=20, BLANK=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "QUESTION_ID", "ANSWER_ID", "DATE", "RANGE", "TIME", 
			"INDEX", "DOUBLE", "INT", "DIGIT", "TEXT", "ALL_CHAR", "YEAR", "MONTH", 
			"DAY", "DATE_SEPARATOR", "HOUR", "MINUTE", "NEWLINE", "BLANK"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'#'", "','", "'Q:'", "'A:'", null, null, null, null, null, null, 
			null, null, null, null, null, null, "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "QUESTION_ID", "ANSWER_ID", "DATE", "RANGE", "TIME", 
			"INDEX", "DOUBLE", "INT", "DIGIT", "TEXT", "ALL_CHAR", "YEAR", "MONTH", 
			"DAY", "DATE_SEPARATOR", "HOUR", "MINUTE", "NEWLINE", "BLANK"
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


	public IntervModelLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IntervModel.g4"; }

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
		"\u0004\u0000\u0015\u0087\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0004\tL\b\t\u000b\t\f\tM\u0001\n\u0001\n\u0001\u000b\u0004\u000bS"+
		"\b\u000b\u000b\u000b\f\u000bT\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000eb\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000fj\b\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011t\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003"+
		"\u0012z\b\u0012\u0001\u0013\u0003\u0013}\b\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0004\u0014\u0082\b\u0014\u000b\u0014\f\u0014\u0083\u0001"+
		"\u0014\u0001\u0014\u0000\u0000\u0015\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012"+
		"%\u0013\'\u0014)\u0015\u0001\u0000\n\u0002\u0000,,..\u0001\u000009\u0003"+
		"\u0000\t\n\r\r  \u0001\u000019\u0001\u000002\u0001\u000012\u0001\u0000"+
		"01\u0001\u000004\u0001\u000005\u0002\u0000\t\t  \u0090\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'"+
		"\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0001+\u0001\u0000"+
		"\u0000\u0000\u0003-\u0001\u0000\u0000\u0000\u0005/\u0001\u0000\u0000\u0000"+
		"\u00072\u0001\u0000\u0000\u0000\t5\u0001\u0000\u0000\u0000\u000b;\u0001"+
		"\u0000\u0000\u0000\r?\u0001\u0000\u0000\u0000\u000fC\u0001\u0000\u0000"+
		"\u0000\u0011F\u0001\u0000\u0000\u0000\u0013K\u0001\u0000\u0000\u0000\u0015"+
		"O\u0001\u0000\u0000\u0000\u0017R\u0001\u0000\u0000\u0000\u0019V\u0001"+
		"\u0000\u0000\u0000\u001bX\u0001\u0000\u0000\u0000\u001da\u0001\u0000\u0000"+
		"\u0000\u001fi\u0001\u0000\u0000\u0000!k\u0001\u0000\u0000\u0000#s\u0001"+
		"\u0000\u0000\u0000%y\u0001\u0000\u0000\u0000\'|\u0001\u0000\u0000\u0000"+
		")\u0081\u0001\u0000\u0000\u0000+,\u0005#\u0000\u0000,\u0002\u0001\u0000"+
		"\u0000\u0000-.\u0005,\u0000\u0000.\u0004\u0001\u0000\u0000\u0000/0\u0005"+
		"Q\u0000\u000001\u0005:\u0000\u00001\u0006\u0001\u0000\u0000\u000023\u0005"+
		"A\u0000\u000034\u0005:\u0000\u00004\b\u0001\u0000\u0000\u000056\u0003"+
		"\u001f\u000f\u000067\u0003!\u0010\u000078\u0003\u001d\u000e\u000089\u0003"+
		"!\u0010\u00009:\u0003\u001b\r\u0000:\n\u0001\u0000\u0000\u0000;<\u0003"+
		"\u0013\t\u0000<=\u0005-\u0000\u0000=>\u0003\u0013\t\u0000>\f\u0001\u0000"+
		"\u0000\u0000?@\u0003#\u0011\u0000@A\u0005:\u0000\u0000AB\u0003%\u0012"+
		"\u0000B\u000e\u0001\u0000\u0000\u0000CD\u0003\u0013\t\u0000DE\u0005.\u0000"+
		"\u0000E\u0010\u0001\u0000\u0000\u0000FG\u0003\u0013\t\u0000GH\u0007\u0000"+
		"\u0000\u0000HI\u0003\u0013\t\u0000I\u0012\u0001\u0000\u0000\u0000JL\u0003"+
		"\u0015\n\u0000KJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MK\u0001"+
		"\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000N\u0014\u0001\u0000\u0000"+
		"\u0000OP\u0007\u0001\u0000\u0000P\u0016\u0001\u0000\u0000\u0000QS\u0003"+
		"\u0019\f\u0000RQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TR\u0001"+
		"\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000U\u0018\u0001\u0000\u0000"+
		"\u0000VW\b\u0002\u0000\u0000W\u001a\u0001\u0000\u0000\u0000XY\u0003\u0015"+
		"\n\u0000YZ\u0003\u0015\n\u0000Z[\u0003\u0015\n\u0000[\\\u0003\u0015\n"+
		"\u0000\\\u001c\u0001\u0000\u0000\u0000]^\u00050\u0000\u0000^b\u0007\u0003"+
		"\u0000\u0000_`\u00051\u0000\u0000`b\u0007\u0004\u0000\u0000a]\u0001\u0000"+
		"\u0000\u0000a_\u0001\u0000\u0000\u0000b\u001e\u0001\u0000\u0000\u0000"+
		"cd\u00050\u0000\u0000dj\u0007\u0003\u0000\u0000ef\u0007\u0005\u0000\u0000"+
		"fj\u0007\u0001\u0000\u0000gh\u00053\u0000\u0000hj\u0007\u0006\u0000\u0000"+
		"ic\u0001\u0000\u0000\u0000ie\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000"+
		"\u0000j \u0001\u0000\u0000\u0000kl\u0005/\u0000\u0000l\"\u0001\u0000\u0000"+
		"\u0000mn\u00050\u0000\u0000nt\u0003\u0015\n\u0000op\u00051\u0000\u0000"+
		"pt\u0003\u0015\n\u0000qr\u00052\u0000\u0000rt\u0007\u0007\u0000\u0000"+
		"sm\u0001\u0000\u0000\u0000so\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000"+
		"\u0000t$\u0001\u0000\u0000\u0000uv\u0007\b\u0000\u0000vz\u0003\u0015\n"+
		"\u0000wx\u00056\u0000\u0000xz\u00050\u0000\u0000yu\u0001\u0000\u0000\u0000"+
		"yw\u0001\u0000\u0000\u0000z&\u0001\u0000\u0000\u0000{}\u0005\r\u0000\u0000"+
		"|{\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000"+
		"\u0000~\u007f\u0005\n\u0000\u0000\u007f(\u0001\u0000\u0000\u0000\u0080"+
		"\u0082\u0007\t\u0000\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0086"+
		"\u0006\u0014\u0000\u0000\u0086*\u0001\u0000\u0000\u0000\t\u0000MTaisy"+
		"|\u0083\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}