// Generated from C:/Users/tiago/ISEP/semestre4-pi/sem4pi-23-24-2da1/jobs4u.backoffice/src/main/java/interview/InterviewTemplate.g4 by ANTLR 4.13.1
package interview;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class InterviewTemplateParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		QUESTION=1, TEXT=2, YES=3, NO=4, WS=5;
	public static final int
		RULE_start = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"start"
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

	@Override
	public String getGrammarFileName() { return "InterviewTemplate.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public InterviewTemplateParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(InterviewTemplateParser.EOF, 0); }
		public List<TerminalNode> QUESTION() { return getTokens(InterviewTemplateParser.QUESTION); }
		public TerminalNode QUESTION(int i) {
			return getToken(InterviewTemplateParser.QUESTION, i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewTemplateListener ) ((InterviewTemplateListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewTemplateListener ) ((InterviewTemplateListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewTemplateVisitor ) return ((InterviewTemplateVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2);
				match(QUESTION);
				}
				}
				setState(5); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==QUESTION );
			setState(7);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0005\n\u0002\u0000\u0007\u0000\u0001\u0000\u0004\u0000\u0004"+
		"\b\u0000\u000b\u0000\f\u0000\u0005\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0000\u0000\u0001\u0000\u0000\u0000\t\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0002\u0004\u0005\u0001\u0000\u0000\u0003\u0002\u0001\u0000\u0000\u0000"+
		"\u0004\u0005\u0001\u0000\u0000\u0000\u0005\u0003\u0001\u0000\u0000\u0000"+
		"\u0005\u0006\u0001\u0000\u0000\u0000\u0006\u0007\u0001\u0000\u0000\u0000"+
		"\u0007\b\u0005\u0000\u0000\u0001\b\u0001\u0001\u0000\u0000\u0000\u0001"+
		"\u0005";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}