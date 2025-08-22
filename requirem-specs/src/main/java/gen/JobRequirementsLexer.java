// Generated from C:/Users/mcram/OneDrive - Instituto Superior de Engenharia do Porto/sem4pi-23-24-2da1/job-requirem-evaluat/src/main/java/grammars/JobRequirements.g4 by ANTLR 4.13.1
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
public class JobRequirementsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, ID=4, SPECIAL_CHAR=5, INT=6, DOUBLE=7, NEWLINE=8, 
		BLANK=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "ID", "SPECIAL_CHAR", "INT", "DOUBLE", "NEWLINE", 
			"BLANK"
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
			"BLANK"
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


	public JobRequirementsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JobRequirements.g4"; }

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
		"\u0004\u0000\t<\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0004\u0003\u001b\b\u0003\u000b"+
		"\u0003\f\u0003\u001c\u0001\u0004\u0001\u0004\u0001\u0005\u0004\u0005\""+
		"\b\u0005\u000b\u0005\f\u0005#\u0001\u0006\u0004\u0006\'\b\u0006\u000b"+
		"\u0006\f\u0006(\u0001\u0006\u0001\u0006\u0004\u0006-\b\u0006\u000b\u0006"+
		"\f\u0006.\u0001\u0006\u0003\u00062\b\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0004\b7\b\b\u000b\b\f\b8\u0001\b\u0001\b\u0000\u0000\t\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0001\u0000\u0006\u0004\u0000--AZ__az\u0005\u0000\"\"\'),,"+
		"..;;\u0001\u000009\u0002\u0000,,..\u0002\u0000\n\n\r\r\u0002\u0000\t\t"+
		"  A\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0001\u0013\u0001\u0000\u0000\u0000\u0003"+
		"\u0015\u0001\u0000\u0000\u0000\u0005\u0017\u0001\u0000\u0000\u0000\u0007"+
		"\u001a\u0001\u0000\u0000\u0000\t\u001e\u0001\u0000\u0000\u0000\u000b!"+
		"\u0001\u0000\u0000\u0000\r1\u0001\u0000\u0000\u0000\u000f3\u0001\u0000"+
		"\u0000\u0000\u00116\u0001\u0000\u0000\u0000\u0013\u0014\u0005#\u0000\u0000"+
		"\u0014\u0002\u0001\u0000\u0000\u0000\u0015\u0016\u0005:\u0000\u0000\u0016"+
		"\u0004\u0001\u0000\u0000\u0000\u0017\u0018\u0005,\u0000\u0000\u0018\u0006"+
		"\u0001\u0000\u0000\u0000\u0019\u001b\u0007\u0000\u0000\u0000\u001a\u0019"+
		"\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001a"+
		"\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d\b\u0001"+
		"\u0000\u0000\u0000\u001e\u001f\u0007\u0001\u0000\u0000\u001f\n\u0001\u0000"+
		"\u0000\u0000 \"\u0007\u0002\u0000\u0000! \u0001\u0000\u0000\u0000\"#\u0001"+
		"\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000"+
		"$\f\u0001\u0000\u0000\u0000%\'\u0007\u0002\u0000\u0000&%\u0001\u0000\u0000"+
		"\u0000\'(\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000()\u0001\u0000"+
		"\u0000\u0000)*\u0001\u0000\u0000\u0000*,\u0007\u0003\u0000\u0000+-\u0007"+
		"\u0002\u0000\u0000,+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000"+
		".,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/2\u0001\u0000\u0000"+
		"\u000002\u0003\u000b\u0005\u00001&\u0001\u0000\u0000\u000010\u0001\u0000"+
		"\u0000\u00002\u000e\u0001\u0000\u0000\u000034\u0007\u0004\u0000\u0000"+
		"4\u0010\u0001\u0000\u0000\u000057\u0007\u0005\u0000\u000065\u0001\u0000"+
		"\u0000\u000078\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001"+
		"\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:;\u0006\b\u0000\u0000;\u0012"+
		"\u0001\u0000\u0000\u0000\u0007\u0000\u001c#(.18\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}