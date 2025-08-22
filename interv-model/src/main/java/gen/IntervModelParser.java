// Generated from C:/Users/mcram/OneDrive - Instituto Superior de Engenharia do Porto/sem4pi-23-24-2da1/interv-model/src/main/java/IntervModel.g4 by ANTLR 4.13.1
package gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class IntervModelParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, QUESTION_ID=3, ANSWER_ID=4, DATE=5, RANGE=6, TIME=7, INDEX=8, 
		DOUBLE=9, INT=10, DIGIT=11, TEXT=12, ALL_CHAR=13, YEAR=14, MONTH=15, DAY=16, 
		DATE_SEPARATOR=17, HOUR=18, MINUTE=19, NEWLINE=20, BLANK=21;
	public static final int
		RULE_start = 0, RULE_entry = 1, RULE_comment = 2, RULE_question = 3, RULE_questionDescrip = 4, 
		RULE_option = 5, RULE_answer = 6, RULE_answer_value = 7, RULE_sentence = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "entry", "comment", "question", "questionDescrip", "option", 
			"answer", "answer_value", "sentence"
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

	@Override
	public String getGrammarFileName() { return "IntervModel.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public IntervModelParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(IntervModelParser.EOF, 0); }
		public List<EntryContext> entry() {
			return getRuleContexts(EntryContext.class);
		}
		public EntryContext entry(int i) {
			return getRuleContext(EntryContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IntervModelListener ) ((IntervModelListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IntervModelListener ) ((IntervModelListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntervModelVisitor ) return ((IntervModelVisitor<? extends T>)visitor).visitStart(this);
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
			setState(19); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(18);
				entry();
				}
				}
				setState(21); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 || _la==QUESTION_ID );
			setState(23);
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
	public static class EntryContext extends ParserRuleContext {
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public EntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IntervModelListener ) ((IntervModelListener)listener).enterEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IntervModelListener ) ((IntervModelListener)listener).exitEntry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntervModelVisitor ) return ((IntervModelVisitor<? extends T>)visitor).visitEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_entry);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(25);
				comment();
				}
			}

			setState(28);
			question();
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
	public static class CommentContext extends ParserRuleContext {
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(IntervModelParser.NEWLINE, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IntervModelListener ) ((IntervModelListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IntervModelListener ) ((IntervModelListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntervModelVisitor ) return ((IntervModelVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(T__0);
			setState(31);
			sentence();
			setState(32);
			match(NEWLINE);
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
	public static class QuestionContext extends ParserRuleContext {
		public QuestionDescripContext questionDescrip() {
			return getRuleContext(QuestionDescripContext.class,0);
		}
		public AnswerContext answer() {
			return getRuleContext(AnswerContext.class,0);
		}
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IntervModelListener ) ((IntervModelListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IntervModelListener ) ((IntervModelListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntervModelVisitor ) return ((IntervModelVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			questionDescrip();
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INDEX) {
				{
				{
				setState(35);
				option();
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			answer();
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
	public static class QuestionDescripContext extends ParserRuleContext {
		public SentenceContext descrip;
		public TerminalNode QUESTION_ID() { return getToken(IntervModelParser.QUESTION_ID, 0); }
		public TerminalNode NEWLINE() { return getToken(IntervModelParser.NEWLINE, 0); }
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public QuestionDescripContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionDescrip; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IntervModelListener ) ((IntervModelListener)listener).enterQuestionDescrip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IntervModelListener ) ((IntervModelListener)listener).exitQuestionDescrip(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntervModelVisitor ) return ((IntervModelVisitor<? extends T>)visitor).visitQuestionDescrip(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionDescripContext questionDescrip() throws RecognitionException {
		QuestionDescripContext _localctx = new QuestionDescripContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_questionDescrip);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(QUESTION_ID);
			setState(44);
			((QuestionDescripContext)_localctx).descrip = sentence();
			setState(45);
			match(NEWLINE);
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
	public static class OptionContext extends ParserRuleContext {
		public SentenceContext choice;
		public TerminalNode INDEX() { return getToken(IntervModelParser.INDEX, 0); }
		public TerminalNode NEWLINE() { return getToken(IntervModelParser.NEWLINE, 0); }
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IntervModelListener ) ((IntervModelListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IntervModelListener ) ((IntervModelListener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntervModelVisitor ) return ((IntervModelVisitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(INDEX);
			setState(48);
			((OptionContext)_localctx).choice = sentence();
			setState(49);
			match(NEWLINE);
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
	public static class AnswerContext extends ParserRuleContext {
		public Answer_valueContext answer_c;
		public TerminalNode ANSWER_ID() { return getToken(IntervModelParser.ANSWER_ID, 0); }
		public Answer_valueContext answer_value() {
			return getRuleContext(Answer_valueContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(IntervModelParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(IntervModelParser.NEWLINE, i);
		}
		public AnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IntervModelListener ) ((IntervModelListener)listener).enterAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IntervModelListener ) ((IntervModelListener)listener).exitAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntervModelVisitor ) return ((IntervModelVisitor<? extends T>)visitor).visitAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerContext answer() throws RecognitionException {
		AnswerContext _localctx = new AnswerContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(ANSWER_ID);
			setState(52);
			((AnswerContext)_localctx).answer_c = answer_value();
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(53);
				match(NEWLINE);
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class Answer_valueContext extends ParserRuleContext {
		public TerminalNode DATE() { return getToken(IntervModelParser.DATE, 0); }
		public TerminalNode RANGE() { return getToken(IntervModelParser.RANGE, 0); }
		public TerminalNode TIME() { return getToken(IntervModelParser.TIME, 0); }
		public List<TerminalNode> INT() { return getTokens(IntervModelParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(IntervModelParser.INT, i);
		}
		public TerminalNode DOUBLE() { return getToken(IntervModelParser.DOUBLE, 0); }
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public Answer_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answer_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IntervModelListener ) ((IntervModelListener)listener).enterAnswer_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IntervModelListener ) ((IntervModelListener)listener).exitAnswer_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntervModelVisitor ) return ((IntervModelVisitor<? extends T>)visitor).visitAnswer_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Answer_valueContext answer_value() throws RecognitionException {
		Answer_valueContext _localctx = new Answer_valueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_answer_value);
		int _la;
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				match(DATE);
				}
				break;
			case RANGE:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				match(RANGE);
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				match(TIME);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				match(INT);
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(63);
					match(T__1);
					setState(64);
					match(INT);
					}
					}
					setState(69);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				match(DOUBLE);
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 6);
				{
				setState(71);
				sentence();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class SentenceContext extends ParserRuleContext {
		public List<TerminalNode> TEXT() { return getTokens(IntervModelParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(IntervModelParser.TEXT, i);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IntervModelListener ) ((IntervModelListener)listener).enterSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IntervModelListener ) ((IntervModelListener)listener).exitSentence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntervModelVisitor ) return ((IntervModelVisitor<? extends T>)visitor).visitSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sentence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(74);
				match(TEXT);
				}
				}
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TEXT );
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
		"\u0004\u0001\u0015P\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0004\u0000\u0014\b\u0000\u000b\u0000\f\u0000\u0015"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0003\u0001\u001b\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0005\u0003%\b\u0003\n\u0003\f\u0003(\t\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u00067\b\u0006\n\u0006\f\u0006:\t\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007B\b\u0007"+
		"\n\u0007\f\u0007E\t\u0007\u0001\u0007\u0001\u0007\u0003\u0007I\b\u0007"+
		"\u0001\b\u0004\bL\b\b\u000b\b\f\bM\u0001\b\u0000\u0000\t\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0000\u0000Q\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0002\u001a\u0001\u0000\u0000\u0000\u0004\u001e\u0001\u0000\u0000\u0000"+
		"\u0006\"\u0001\u0000\u0000\u0000\b+\u0001\u0000\u0000\u0000\n/\u0001\u0000"+
		"\u0000\u0000\f3\u0001\u0000\u0000\u0000\u000eH\u0001\u0000\u0000\u0000"+
		"\u0010K\u0001\u0000\u0000\u0000\u0012\u0014\u0003\u0002\u0001\u0000\u0013"+
		"\u0012\u0001\u0000\u0000\u0000\u0014\u0015\u0001\u0000\u0000\u0000\u0015"+
		"\u0013\u0001\u0000\u0000\u0000\u0015\u0016\u0001\u0000\u0000\u0000\u0016"+
		"\u0017\u0001\u0000\u0000\u0000\u0017\u0018\u0005\u0000\u0000\u0001\u0018"+
		"\u0001\u0001\u0000\u0000\u0000\u0019\u001b\u0003\u0004\u0002\u0000\u001a"+
		"\u0019\u0001\u0000\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b"+
		"\u001c\u0001\u0000\u0000\u0000\u001c\u001d\u0003\u0006\u0003\u0000\u001d"+
		"\u0003\u0001\u0000\u0000\u0000\u001e\u001f\u0005\u0001\u0000\u0000\u001f"+
		" \u0003\u0010\b\u0000 !\u0005\u0014\u0000\u0000!\u0005\u0001\u0000\u0000"+
		"\u0000\"&\u0003\b\u0004\u0000#%\u0003\n\u0005\u0000$#\u0001\u0000\u0000"+
		"\u0000%(\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000"+
		"\u0000\u0000\')\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000)*\u0003"+
		"\f\u0006\u0000*\u0007\u0001\u0000\u0000\u0000+,\u0005\u0003\u0000\u0000"+
		",-\u0003\u0010\b\u0000-.\u0005\u0014\u0000\u0000.\t\u0001\u0000\u0000"+
		"\u0000/0\u0005\b\u0000\u000001\u0003\u0010\b\u000012\u0005\u0014\u0000"+
		"\u00002\u000b\u0001\u0000\u0000\u000034\u0005\u0004\u0000\u000048\u0003"+
		"\u000e\u0007\u000057\u0005\u0014\u0000\u000065\u0001\u0000\u0000\u0000"+
		"7:\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001\u0000\u0000"+
		"\u00009\r\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000;I\u0005\u0005"+
		"\u0000\u0000<I\u0005\u0006\u0000\u0000=I\u0005\u0007\u0000\u0000>C\u0005"+
		"\n\u0000\u0000?@\u0005\u0002\u0000\u0000@B\u0005\n\u0000\u0000A?\u0001"+
		"\u0000\u0000\u0000BE\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000"+
		"CD\u0001\u0000\u0000\u0000DI\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000"+
		"\u0000FI\u0005\t\u0000\u0000GI\u0003\u0010\b\u0000H;\u0001\u0000\u0000"+
		"\u0000H<\u0001\u0000\u0000\u0000H=\u0001\u0000\u0000\u0000H>\u0001\u0000"+
		"\u0000\u0000HF\u0001\u0000\u0000\u0000HG\u0001\u0000\u0000\u0000I\u000f"+
		"\u0001\u0000\u0000\u0000JL\u0005\f\u0000\u0000KJ\u0001\u0000\u0000\u0000"+
		"LM\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000"+
		"\u0000N\u0011\u0001\u0000\u0000\u0000\u0007\u0015\u001a&8CHM";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}