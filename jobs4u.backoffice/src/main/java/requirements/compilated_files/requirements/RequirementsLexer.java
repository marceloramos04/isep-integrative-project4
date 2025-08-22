// Generated from C:/Users/tiago/ISEP/semestre4-pi/sem4pi-23-24-2da1/jobs4u.backoffice/src/main/java/requirements/Requirements.g4 by ANTLR 4.13.1
package requirements;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class RequirementsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, ID=4, SPECIAL_CHAR=5, INT=6, DOUBLE=7, NEWLINE=8, 
		ENDLINE=9, BLANK=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "ID", "SPECIAL_CHAR", "INT", "DOUBLE", "NEWLINE", 
			"ENDLINE", "BLANK"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'#'", "':'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "ID", "SPECIAL_CHAR", "INT", "DOUBLE", "NEWLINE", 
			"ENDLINE", "BLANK"
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


	public RequirementsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Requirements.g4"; }

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
		"\u0004\u0000\nF\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0004\u0003\u001d"+
		"\b\u0003\u000b\u0003\f\u0003\u001e\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0004\u0005$\b\u0005\u000b\u0005\f\u0005%\u0001\u0006\u0004\u0006)\b"+
		"\u0006\u000b\u0006\f\u0006*\u0001\u0006\u0001\u0006\u0004\u0006/\b\u0006"+
		"\u000b\u0006\f\u00060\u0001\u0006\u0003\u00064\b\u0006\u0001\u0007\u0003"+
		"\u00077\b\u0007\u0001\u0007\u0004\u0007:\b\u0007\u000b\u0007\f\u0007;"+
		"\u0001\b\u0001\b\u0001\t\u0004\tA\b\t\u000b\t\f\tB\u0001\t\u0001\t\u0000"+
		"\u0000\n\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0001\u0000\u0005\u0004\u0000-"+
		"-AZ__az\u0005\u0000\"\"\'),,..;;\u0001\u000009\u0002\u0000,,..\u0002\u0000"+
		"\t\t  M\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0001"+
		"\u0015\u0001\u0000\u0000\u0000\u0003\u0017\u0001\u0000\u0000\u0000\u0005"+
		"\u0019\u0001\u0000\u0000\u0000\u0007\u001c\u0001\u0000\u0000\u0000\t "+
		"\u0001\u0000\u0000\u0000\u000b#\u0001\u0000\u0000\u0000\r3\u0001\u0000"+
		"\u0000\u0000\u000f9\u0001\u0000\u0000\u0000\u0011=\u0001\u0000\u0000\u0000"+
		"\u0013@\u0001\u0000\u0000\u0000\u0015\u0016\u0005#\u0000\u0000\u0016\u0002"+
		"\u0001\u0000\u0000\u0000\u0017\u0018\u0005:\u0000\u0000\u0018\u0004\u0001"+
		"\u0000\u0000\u0000\u0019\u001a\u0005,\u0000\u0000\u001a\u0006\u0001\u0000"+
		"\u0000\u0000\u001b\u001d\u0007\u0000\u0000\u0000\u001c\u001b\u0001\u0000"+
		"\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000"+
		"\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f\b\u0001\u0000\u0000"+
		"\u0000 !\u0007\u0001\u0000\u0000!\n\u0001\u0000\u0000\u0000\"$\u0007\u0002"+
		"\u0000\u0000#\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%#\u0001"+
		"\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&\f\u0001\u0000\u0000\u0000"+
		"\')\u0007\u0002\u0000\u0000(\'\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000"+
		"\u0000*(\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+,\u0001\u0000"+
		"\u0000\u0000,.\u0007\u0003\u0000\u0000-/\u0007\u0002\u0000\u0000.-\u0001"+
		"\u0000\u0000\u0000/0\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u0000"+
		"01\u0001\u0000\u0000\u000014\u0001\u0000\u0000\u000024\u0003\u000b\u0005"+
		"\u00003(\u0001\u0000\u0000\u000032\u0001\u0000\u0000\u00004\u000e\u0001"+
		"\u0000\u0000\u000057\u0005\r\u0000\u000065\u0001\u0000\u0000\u000067\u0001"+
		"\u0000\u0000\u000078\u0001\u0000\u0000\u00008:\u0005\n\u0000\u000096\u0001"+
		"\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000"+
		";<\u0001\u0000\u0000\u0000<\u0010\u0001\u0000\u0000\u0000=>\u0003\u000f"+
		"\u0007\u0000>\u0012\u0001\u0000\u0000\u0000?A\u0007\u0004\u0000\u0000"+
		"@?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000"+
		"\u0000BC\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DE\u0006\t\u0000"+
		"\u0000E\u0014\u0001\u0000\u0000\u0000\t\u0000\u001e%*036;B\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}