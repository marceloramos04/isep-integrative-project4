// Generated from C:/Users/tiago/ISEP/semestre4-pi/sem4pi-23-24-2da1/jobs4u.backoffice/src/main/java/interview/InterviewTemplate.g4 by ANTLR 4.13.1
package interview;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class InterviewTemplateLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		QUESTION=1, TEXT=2, YES=3, NO=4, WS=5;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"QUESTION", "TEXT", "YES", "NO", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "QUESTION", "TEXT", "YES", "NO", "WS"
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


	public InterviewTemplateLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "InterviewTemplate.g4"; }

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
		"\u0004\u0000\u0005?\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0003\u0000\u0019\b\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0004\u0001\u001e\b\u0001\u000b\u0001\f\u0001\u001f\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002-\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u00037\b\u0003\u0001\u0004\u0004"+
		"\u0004:\b\u0004\u000b\u0004\f\u0004;\u0001\u0004\u0001\u0004\u0000\u0000"+
		"\u0005\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u0001\u0000"+
		"\u0002\u0007\u0000!!\'\',.09??AZaz\u0003\u0000\t\n\r\r  J\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0001\u000b\u0001\u0000\u0000\u0000\u0003\u001d\u0001"+
		"\u0000\u0000\u0000\u0005,\u0001\u0000\u0000\u0000\u00076\u0001\u0000\u0000"+
		"\u0000\t9\u0001\u0000\u0000\u0000\u000b\f\u0005Q\u0000\u0000\f\r\u0005"+
		":\u0000\u0000\r\u000e\u0005 \u0000\u0000\u000e\u000f\u0001\u0000\u0000"+
		"\u0000\u000f\u0010\u0003\u0003\u0001\u0000\u0010\u0011\u0005\n\u0000\u0000"+
		"\u0011\u0012\u0005A\u0000\u0000\u0012\u0013\u0005:\u0000\u0000\u0013\u0014"+
		"\u0005 \u0000\u0000\u0014\u0018\u0001\u0000\u0000\u0000\u0015\u0019\u0003"+
		"\u0003\u0001\u0000\u0016\u0019\u0003\u0005\u0002\u0000\u0017\u0019\u0003"+
		"\u0007\u0003\u0000\u0018\u0015\u0001\u0000\u0000\u0000\u0018\u0016\u0001"+
		"\u0000\u0000\u0000\u0018\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001"+
		"\u0000\u0000\u0000\u001a\u001b\u0005\n\u0000\u0000\u001b\u0002\u0001\u0000"+
		"\u0000\u0000\u001c\u001e\u0007\u0000\u0000\u0000\u001d\u001c\u0001\u0000"+
		"\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000"+
		"\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \u0004\u0001\u0000\u0000\u0000"+
		"!\"\u0005Y\u0000\u0000\"#\u0005e\u0000\u0000#-\u0005s\u0000\u0000$-\u0005"+
		"Y\u0000\u0000%&\u0005y\u0000\u0000&\'\u0005e\u0000\u0000\'-\u0005s\u0000"+
		"\u0000(-\u0005y\u0000\u0000)*\u0005Y\u0000\u0000*+\u0005E\u0000\u0000"+
		"+-\u0005S\u0000\u0000,!\u0001\u0000\u0000\u0000,$\u0001\u0000\u0000\u0000"+
		",%\u0001\u0000\u0000\u0000,(\u0001\u0000\u0000\u0000,)\u0001\u0000\u0000"+
		"\u0000-\u0006\u0001\u0000\u0000\u0000./\u0005N\u0000\u0000/7\u0005o\u0000"+
		"\u000007\u0005N\u0000\u000012\u0005n\u0000\u000027\u0005o\u0000\u0000"+
		"37\u0005n\u0000\u000045\u0005N\u0000\u000057\u0005O\u0000\u00006.\u0001"+
		"\u0000\u0000\u000060\u0001\u0000\u0000\u000061\u0001\u0000\u0000\u0000"+
		"63\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u00007\b\u0001\u0000\u0000"+
		"\u00008:\u0007\u0001\u0000\u000098\u0001\u0000\u0000\u0000:;\u0001\u0000"+
		"\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<=\u0001"+
		"\u0000\u0000\u0000=>\u0006\u0004\u0000\u0000>\n\u0001\u0000\u0000\u0000"+
		"\u0006\u0000\u0018\u001f,6;\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}