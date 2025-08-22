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
		T__0=1, T__1=2, T__2=3, T__3=4, ID=5, NAME=6, PHONE_NUMBER=7, EMAIL=8, 
		NEWLINE=9, WS=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "ID", "NAME", "PHONE_NUMBER", "EMAIL", 
			"NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'ID:'", "'Name:'", "'Phone_Number:'", "'Email:'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "ID", "NAME", "PHONE_NUMBER", "EMAIL", 
			"NEWLINE", "WS"
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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 6:
			PHONE_NUMBER_action((RuleContext)_localctx, actionIndex);
			break;
		case 7:
			EMAIL_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void PHONE_NUMBER_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			9
			break;
		}
	}
	private void EMAIL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			2,
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000\n\\\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0004"+
		"\u00046\b\u0004\u000b\u0004\f\u00047\u0001\u0005\u0004\u0005;\b\u0005"+
		"\u000b\u0005\f\u0005<\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0004\u0007C\b\u0007\u000b\u0007\f\u0007D\u0001\u0007\u0001\u0007\u0004"+
		"\u0007I\b\u0007\u000b\u0007\f\u0007J\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0003\bR\b\b\u0001\b\u0001\b\u0001\t\u0004\tW\b\t"+
		"\u000b\t\f\tX\u0001\t\u0001\t\u0000\u0000\n\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0001\u0000\u0005\u0001\u000009\u0002\u0000AZaz\u0007\u0000%%++-.09A"+
		"Z__az\u0004\u0000-.09AZaz\u0002\u0000\t\t  a\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0001\u0015\u0001\u0000\u0000\u0000\u0003"+
		"\u0019\u0001\u0000\u0000\u0000\u0005\u001f\u0001\u0000\u0000\u0000\u0007"+
		"-\u0001\u0000\u0000\u0000\t5\u0001\u0000\u0000\u0000\u000b:\u0001\u0000"+
		"\u0000\u0000\r>\u0001\u0000\u0000\u0000\u000fB\u0001\u0000\u0000\u0000"+
		"\u0011Q\u0001\u0000\u0000\u0000\u0013V\u0001\u0000\u0000\u0000\u0015\u0016"+
		"\u0005I\u0000\u0000\u0016\u0017\u0005D\u0000\u0000\u0017\u0018\u0005:"+
		"\u0000\u0000\u0018\u0002\u0001\u0000\u0000\u0000\u0019\u001a\u0005N\u0000"+
		"\u0000\u001a\u001b\u0005a\u0000\u0000\u001b\u001c\u0005m\u0000\u0000\u001c"+
		"\u001d\u0005e\u0000\u0000\u001d\u001e\u0005:\u0000\u0000\u001e\u0004\u0001"+
		"\u0000\u0000\u0000\u001f \u0005P\u0000\u0000 !\u0005h\u0000\u0000!\"\u0005"+
		"o\u0000\u0000\"#\u0005n\u0000\u0000#$\u0005e\u0000\u0000$%\u0005_\u0000"+
		"\u0000%&\u0005N\u0000\u0000&\'\u0005u\u0000\u0000\'(\u0005m\u0000\u0000"+
		"()\u0005b\u0000\u0000)*\u0005e\u0000\u0000*+\u0005r\u0000\u0000+,\u0005"+
		":\u0000\u0000,\u0006\u0001\u0000\u0000\u0000-.\u0005E\u0000\u0000./\u0005"+
		"m\u0000\u0000/0\u0005a\u0000\u000001\u0005i\u0000\u000012\u0005l\u0000"+
		"\u000023\u0005:\u0000\u00003\b\u0001\u0000\u0000\u000046\u0007\u0000\u0000"+
		"\u000054\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u000075\u0001\u0000"+
		"\u0000\u000078\u0001\u0000\u0000\u00008\n\u0001\u0000\u0000\u00009;\u0007"+
		"\u0001\u0000\u0000:9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000"+
		"<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=\f\u0001\u0000\u0000"+
		"\u0000>?\u0007\u0000\u0000\u0000?@\u0006\u0006\u0000\u0000@\u000e\u0001"+
		"\u0000\u0000\u0000AC\u0007\u0002\u0000\u0000BA\u0001\u0000\u0000\u0000"+
		"CD\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000"+
		"\u0000EF\u0001\u0000\u0000\u0000FH\u0005@\u0000\u0000GI\u0007\u0003\u0000"+
		"\u0000HG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JH\u0001\u0000"+
		"\u0000\u0000JK\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0005"+
		".\u0000\u0000MN\u0007\u0001\u0000\u0000NO\u0006\u0007\u0001\u0000O\u0010"+
		"\u0001\u0000\u0000\u0000PR\u0005\r\u0000\u0000QP\u0001\u0000\u0000\u0000"+
		"QR\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000ST\u0005\n\u0000\u0000"+
		"T\u0012\u0001\u0000\u0000\u0000UW\u0007\u0004\u0000\u0000VU\u0001\u0000"+
		"\u0000\u0000WX\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001"+
		"\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0006\t\u0002\u0000[\u0014"+
		"\u0001\u0000\u0000\u0000\u0007\u00007<DJQX\u0003\u0001\u0006\u0000\u0001"+
		"\u0007\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}