// Generated from C:/Users/rafa1/Documents/untitled/src/main/antlr/US2003.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class US2003Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		JOB_OPENING=1, JOB_REQUIREMENTS=2, CANDIDATE_FIELDS=3, EXPORT_TEMPLATE=4, 
		DATA_FIELD=5, EMAIL=6, PHONE=7, EMAIL_ADDRESS=8, PHONE_NUMBER=9, STRING=10, 
		COLON=11, COMMA=12, LCURLY=13, RCURLY=14, WS=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"JOB_OPENING", "JOB_REQUIREMENTS", "CANDIDATE_FIELDS", "EXPORT_TEMPLATE", 
			"DATA_FIELD", "EMAIL", "PHONE", "EMAIL_ADDRESS", "EMAIL_PART", "PHONE_NUMBER", 
			"STRING", "COLON", "COMMA", "LCURLY", "RCURLY", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Job Opening'", "'Job Requirements'", "'Candidate Fields'", "'Export Template'", 
			"'Data Field'", null, null, null, null, null, "':'", "','", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "JOB_OPENING", "JOB_REQUIREMENTS", "CANDIDATE_FIELDS", "EXPORT_TEMPLATE", 
			"DATA_FIELD", "EMAIL", "PHONE", "EMAIL_ADDRESS", "PHONE_NUMBER", "STRING", 
			"COLON", "COMMA", "LCURLY", "RCURLY", "WS"
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


	public US2003Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "US2003.g4"; }

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
		"\u0004\u0000\u000f\u00a0\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0004\b\u0084\b\b\u000b\b"+
		"\f\b\u0085\u0001\t\u0004\t\u0089\b\t\u000b\t\f\t\u008a\u0001\n\u0004\n"+
		"\u008e\b\n\u000b\n\f\n\u008f\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0004\u000f\u009b\b\u000f"+
		"\u000b\u000f\f\u000f\u009c\u0001\u000f\u0001\u000f\u0000\u0000\u0010\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\u0000\u0013\t\u0015\n\u0017\u000b\u0019\f\u001b\r\u001d"+
		"\u000e\u001f\u000f\u0001\u0000\u0004\u0007\u0000%%++-.09AZ__az\u0001\u0000"+
		"09\u0005\u0000  ..09@Zaz\u0003\u0000\t\n\r\r  \u00a2\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000"+
		"\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000"+
		"\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000"+
		"\u0000\u0001!\u0001\u0000\u0000\u0000\u0003-\u0001\u0000\u0000\u0000\u0005"+
		">\u0001\u0000\u0000\u0000\u0007O\u0001\u0000\u0000\u0000\t_\u0001\u0000"+
		"\u0000\u0000\u000bj\u0001\u0000\u0000\u0000\rs\u0001\u0000\u0000\u0000"+
		"\u000f|\u0001\u0000\u0000\u0000\u0011\u0083\u0001\u0000\u0000\u0000\u0013"+
		"\u0088\u0001\u0000\u0000\u0000\u0015\u008d\u0001\u0000\u0000\u0000\u0017"+
		"\u0091\u0001\u0000\u0000\u0000\u0019\u0093\u0001\u0000\u0000\u0000\u001b"+
		"\u0095\u0001\u0000\u0000\u0000\u001d\u0097\u0001\u0000\u0000\u0000\u001f"+
		"\u009a\u0001\u0000\u0000\u0000!\"\u0005J\u0000\u0000\"#\u0005o\u0000\u0000"+
		"#$\u0005b\u0000\u0000$%\u0005 \u0000\u0000%&\u0005O\u0000\u0000&\'\u0005"+
		"p\u0000\u0000\'(\u0005e\u0000\u0000()\u0005n\u0000\u0000)*\u0005i\u0000"+
		"\u0000*+\u0005n\u0000\u0000+,\u0005g\u0000\u0000,\u0002\u0001\u0000\u0000"+
		"\u0000-.\u0005J\u0000\u0000./\u0005o\u0000\u0000/0\u0005b\u0000\u0000"+
		"01\u0005 \u0000\u000012\u0005R\u0000\u000023\u0005e\u0000\u000034\u0005"+
		"q\u0000\u000045\u0005u\u0000\u000056\u0005i\u0000\u000067\u0005r\u0000"+
		"\u000078\u0005e\u0000\u000089\u0005m\u0000\u00009:\u0005e\u0000\u0000"+
		":;\u0005n\u0000\u0000;<\u0005t\u0000\u0000<=\u0005s\u0000\u0000=\u0004"+
		"\u0001\u0000\u0000\u0000>?\u0005C\u0000\u0000?@\u0005a\u0000\u0000@A\u0005"+
		"n\u0000\u0000AB\u0005d\u0000\u0000BC\u0005i\u0000\u0000CD\u0005d\u0000"+
		"\u0000DE\u0005a\u0000\u0000EF\u0005t\u0000\u0000FG\u0005e\u0000\u0000"+
		"GH\u0005 \u0000\u0000HI\u0005F\u0000\u0000IJ\u0005i\u0000\u0000JK\u0005"+
		"e\u0000\u0000KL\u0005l\u0000\u0000LM\u0005d\u0000\u0000MN\u0005s\u0000"+
		"\u0000N\u0006\u0001\u0000\u0000\u0000OP\u0005E\u0000\u0000PQ\u0005x\u0000"+
		"\u0000QR\u0005p\u0000\u0000RS\u0005o\u0000\u0000ST\u0005r\u0000\u0000"+
		"TU\u0005t\u0000\u0000UV\u0005 \u0000\u0000VW\u0005T\u0000\u0000WX\u0005"+
		"e\u0000\u0000XY\u0005m\u0000\u0000YZ\u0005p\u0000\u0000Z[\u0005l\u0000"+
		"\u0000[\\\u0005a\u0000\u0000\\]\u0005t\u0000\u0000]^\u0005e\u0000\u0000"+
		"^\b\u0001\u0000\u0000\u0000_`\u0005D\u0000\u0000`a\u0005a\u0000\u0000"+
		"ab\u0005t\u0000\u0000bc\u0005a\u0000\u0000cd\u0005 \u0000\u0000de\u0005"+
		"F\u0000\u0000ef\u0005i\u0000\u0000fg\u0005e\u0000\u0000gh\u0005l\u0000"+
		"\u0000hi\u0005d\u0000\u0000i\n\u0001\u0000\u0000\u0000jk\u0005E\u0000"+
		"\u0000kl\u0005m\u0000\u0000lm\u0005a\u0000\u0000mn\u0005i\u0000\u0000"+
		"no\u0005l\u0000\u0000op\u0001\u0000\u0000\u0000pq\u0003\u0017\u000b\u0000"+
		"qr\u0003\u000f\u0007\u0000r\f\u0001\u0000\u0000\u0000st\u0005P\u0000\u0000"+
		"tu\u0005h\u0000\u0000uv\u0005o\u0000\u0000vw\u0005n\u0000\u0000wx\u0005"+
		"e\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0003\u0017\u000b\u0000z{\u0003"+
		"\u0013\t\u0000{\u000e\u0001\u0000\u0000\u0000|}\u0003\u0011\b\u0000}~"+
		"\u0005@\u0000\u0000~\u007f\u0003\u0011\b\u0000\u007f\u0080\u0005.\u0000"+
		"\u0000\u0080\u0081\u0003\u0011\b\u0000\u0081\u0010\u0001\u0000\u0000\u0000"+
		"\u0082\u0084\u0007\u0000\u0000\u0000\u0083\u0082\u0001\u0000\u0000\u0000"+
		"\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000"+
		"\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0012\u0001\u0000\u0000\u0000"+
		"\u0087\u0089\u0007\u0001\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000"+
		"\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u0014\u0001\u0000\u0000\u0000"+
		"\u008c\u008e\u0007\u0002\u0000\u0000\u008d\u008c\u0001\u0000\u0000\u0000"+
		"\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0016\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0005:\u0000\u0000\u0092\u0018\u0001\u0000\u0000\u0000\u0093"+
		"\u0094\u0005,\u0000\u0000\u0094\u001a\u0001\u0000\u0000\u0000\u0095\u0096"+
		"\u0005{\u0000\u0000\u0096\u001c\u0001\u0000\u0000\u0000\u0097\u0098\u0005"+
		"}\u0000\u0000\u0098\u001e\u0001\u0000\u0000\u0000\u0099\u009b\u0007\u0003"+
		"\u0000\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000"+
		"\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000"+
		"\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009f\u0006\u000f"+
		"\u0000\u0000\u009f \u0001\u0000\u0000\u0000\u0005\u0000\u0085\u008a\u008f"+
		"\u009c\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}