// Generated from C:/Users/rafa1/Documents/untitled/src/main/antlr/US2003.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class US2003Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, ID=6, NAME=7, PHONE_NUMBER=8, 
		EMAIL=9;
	public static final int
		RULE_file = 0, RULE_candidate = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "candidate"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'ID:'", "'\\n'", "'Name:'", "'Phone_Number:'", "'Email:'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "ID", "NAME", "PHONE_NUMBER", "EMAIL"
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
	public String getGrammarFileName() { return "US2003.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public US2003Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(US2003Parser.EOF, 0); }
		public List<CandidateContext> candidate() {
			return getRuleContexts(CandidateContext.class);
		}
		public CandidateContext candidate(int i) {
			return getRuleContext(CandidateContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2003Listener ) ((US2003Listener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2003Listener ) ((US2003Listener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2003Visitor ) return ((US2003Visitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(5); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(4);
				candidate();
				}
				}
				setState(7); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(9);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CandidateContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(US2003Parser.ID, 0); }
		public TerminalNode NAME() { return getToken(US2003Parser.NAME, 0); }
		public TerminalNode PHONE_NUMBER() { return getToken(US2003Parser.PHONE_NUMBER, 0); }
		public TerminalNode EMAIL() { return getToken(US2003Parser.EMAIL, 0); }
		public CandidateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_candidate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2003Listener ) ((US2003Listener)listener).enterCandidate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2003Listener ) ((US2003Listener)listener).exitCandidate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2003Visitor ) return ((US2003Visitor<? extends T>)visitor).visitCandidate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CandidateContext candidate() throws RecognitionException {
		CandidateContext _localctx = new CandidateContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_candidate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			match(T__0);
			setState(12);
			match(ID);
			setState(13);
			match(T__1);
			setState(14);
			match(T__2);
			setState(15);
			match(NAME);
			setState(16);
			match(T__1);
			setState(17);
			match(T__3);
			setState(18);
			match(PHONE_NUMBER);
			setState(19);
			match(T__1);
			setState(20);
			match(T__4);
			setState(21);
			match(EMAIL);
			setState(22);
			match(T__1);
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
		"\u0004\u0001\t\u0019\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0001"+
		"\u0000\u0004\u0000\u0006\b\u0000\u000b\u0000\f\u0000\u0007\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0002\u0000\u0002\u0000"+
		"\u0000\u0017\u0000\u0005\u0001\u0000\u0000\u0000\u0002\u000b\u0001\u0000"+
		"\u0000\u0000\u0004\u0006\u0003\u0002\u0001\u0000\u0005\u0004\u0001\u0000"+
		"\u0000\u0000\u0006\u0007\u0001\u0000\u0000\u0000\u0007\u0005\u0001\u0000"+
		"\u0000\u0000\u0007\b\u0001\u0000\u0000\u0000\b\t\u0001\u0000\u0000\u0000"+
		"\t\n\u0005\u0000\u0000\u0001\n\u0001\u0001\u0000\u0000\u0000\u000b\f\u0005"+
		"\u0001\u0000\u0000\f\r\u0005\u0006\u0000\u0000\r\u000e\u0005\u0002\u0000"+
		"\u0000\u000e\u000f\u0005\u0003\u0000\u0000\u000f\u0010\u0005\u0007\u0000"+
		"\u0000\u0010\u0011\u0005\u0002\u0000\u0000\u0011\u0012\u0005\u0004\u0000"+
		"\u0000\u0012\u0013\u0005\b\u0000\u0000\u0013\u0014\u0005\u0002\u0000\u0000"+
		"\u0014\u0015\u0005\u0005\u0000\u0000\u0015\u0016\u0005\t\u0000\u0000\u0016"+
		"\u0017\u0005\u0002\u0000\u0000\u0017\u0003\u0001\u0000\u0000\u0000\u0001"+
		"\u0007";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}