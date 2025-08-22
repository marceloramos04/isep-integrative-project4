// Generated from C:/Users/mcram/OneDrive - Instituto Superior de Engenharia do Porto/sem4pi-23-24-2da1/job-requirem-evaluat/src/main/java/grammars/JobRequirements.g4 by ANTLR 4.13.1
package gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class JobRequirementsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, ID=4, SPECIAL_CHAR=5, INT=6, DOUBLE=7, NEWLINE=8, 
		BLANK=9;
	public static final int
		RULE_start = 0, RULE_comment = 1, RULE_requirement = 2, RULE_answer = 3, 
		RULE_textAnswers = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "comment", "requirement", "answer", "textAnswers"
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

	@Override
	public String getGrammarFileName() { return "JobRequirements.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JobRequirementsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(JobRequirementsParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(JobRequirementsParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(JobRequirementsParser.NEWLINE, i);
		}
		public List<RequirementContext> requirement() {
			return getRuleContexts(RequirementContext.class);
		}
		public RequirementContext requirement(int i) {
			return getRuleContext(RequirementContext.class,i);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsListener ) ((JobRequirementsListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsListener ) ((JobRequirementsListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsVisitor ) return ((JobRequirementsVisitor<? extends T>)visitor).visitStart(this);
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
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(13);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NEWLINE:
					{
					setState(10);
					match(NEWLINE);
					}
					break;
				case ID:
				case SPECIAL_CHAR:
					{
					setState(11);
					requirement();
					}
					break;
				case T__0:
					{
					setState(12);
					comment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 306L) != 0) );
			setState(17);
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
	public static class CommentContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(JobRequirementsParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(JobRequirementsParser.NEWLINE, i);
		}
		public List<TerminalNode> ID() { return getTokens(JobRequirementsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(JobRequirementsParser.ID, i);
		}
		public List<TerminalNode> SPECIAL_CHAR() { return getTokens(JobRequirementsParser.SPECIAL_CHAR); }
		public TerminalNode SPECIAL_CHAR(int i) {
			return getToken(JobRequirementsParser.SPECIAL_CHAR, i);
		}
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsListener ) ((JobRequirementsListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsListener ) ((JobRequirementsListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsVisitor ) return ((JobRequirementsVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_comment);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			match(T__0);
			setState(23);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(20);
					_la = _input.LA(1);
					if ( !(_la==ID || _la==SPECIAL_CHAR) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(25);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(29);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(26);
					match(NEWLINE);
					}
					} 
				}
				setState(31);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
	public static class RequirementContext extends ParserRuleContext {
		public Token descrip;
		public AnswerContext answer() {
			return getRuleContext(AnswerContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(JobRequirementsParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(JobRequirementsParser.NEWLINE, i);
		}
		public List<TerminalNode> ID() { return getTokens(JobRequirementsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(JobRequirementsParser.ID, i);
		}
		public List<TerminalNode> SPECIAL_CHAR() { return getTokens(JobRequirementsParser.SPECIAL_CHAR); }
		public TerminalNode SPECIAL_CHAR(int i) {
			return getToken(JobRequirementsParser.SPECIAL_CHAR, i);
		}
		public RequirementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requirement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsListener ) ((JobRequirementsListener)listener).enterRequirement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsListener ) ((JobRequirementsListener)listener).exitRequirement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsVisitor ) return ((JobRequirementsVisitor<? extends T>)visitor).visitRequirement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequirementContext requirement() throws RecognitionException {
		RequirementContext _localctx = new RequirementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_requirement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				((RequirementContext)_localctx).descrip = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==SPECIAL_CHAR) ) {
					((RequirementContext)_localctx).descrip = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID || _la==SPECIAL_CHAR );
			setState(37);
			match(T__1);
			setState(38);
			answer();
			setState(42);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(39);
					match(NEWLINE);
					}
					} 
				}
				setState(44);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
	public static class AnswerContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(JobRequirementsParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(JobRequirementsParser.DOUBLE, 0); }
		public TextAnswersContext textAnswers() {
			return getRuleContext(TextAnswersContext.class,0);
		}
		public AnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsListener ) ((JobRequirementsListener)listener).enterAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsListener ) ((JobRequirementsListener)listener).exitAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsVisitor ) return ((JobRequirementsVisitor<? extends T>)visitor).visitAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerContext answer() throws RecognitionException {
		AnswerContext _localctx = new AnswerContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_answer);
		try {
			setState(48);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				match(INT);
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				match(DOUBLE);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				textAnswers();
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
	public static class TextAnswersContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(JobRequirementsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(JobRequirementsParser.ID, i);
		}
		public TextAnswersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textAnswers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsListener ) ((JobRequirementsListener)listener).enterTextAnswers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JobRequirementsListener ) ((JobRequirementsListener)listener).exitTextAnswers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JobRequirementsVisitor ) return ((JobRequirementsVisitor<? extends T>)visitor).visitTextAnswers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextAnswersContext textAnswers() throws RecognitionException {
		TextAnswersContext _localctx = new TextAnswersContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_textAnswers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(ID);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(51);
				match(T__2);
				setState(52);
				match(ID);
				}
				}
				setState(57);
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

	public static final String _serializedATN =
		"\u0004\u0001\t;\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u000e\b\u0000\u000b\u0000\f"+
		"\u0000\u000f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0005\u0001"+
		"\u0016\b\u0001\n\u0001\f\u0001\u0019\t\u0001\u0001\u0001\u0005\u0001\u001c"+
		"\b\u0001\n\u0001\f\u0001\u001f\t\u0001\u0001\u0002\u0004\u0002\"\b\u0002"+
		"\u000b\u0002\f\u0002#\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		")\b\u0002\n\u0002\f\u0002,\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u00031\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"6\b\u0004\n\u0004\f\u00049\t\u0004\u0001\u0004\u0000\u0000\u0005\u0000"+
		"\u0002\u0004\u0006\b\u0000\u0001\u0001\u0000\u0004\u0005?\u0000\r\u0001"+
		"\u0000\u0000\u0000\u0002\u0013\u0001\u0000\u0000\u0000\u0004!\u0001\u0000"+
		"\u0000\u0000\u00060\u0001\u0000\u0000\u0000\b2\u0001\u0000\u0000\u0000"+
		"\n\u000e\u0005\b\u0000\u0000\u000b\u000e\u0003\u0004\u0002\u0000\f\u000e"+
		"\u0003\u0002\u0001\u0000\r\n\u0001\u0000\u0000\u0000\r\u000b\u0001\u0000"+
		"\u0000\u0000\r\f\u0001\u0000\u0000\u0000\u000e\u000f\u0001\u0000\u0000"+
		"\u0000\u000f\r\u0001\u0000\u0000\u0000\u000f\u0010\u0001\u0000\u0000\u0000"+
		"\u0010\u0011\u0001\u0000\u0000\u0000\u0011\u0012\u0005\u0000\u0000\u0001"+
		"\u0012\u0001\u0001\u0000\u0000\u0000\u0013\u0017\u0005\u0001\u0000\u0000"+
		"\u0014\u0016\u0007\u0000\u0000\u0000\u0015\u0014\u0001\u0000\u0000\u0000"+
		"\u0016\u0019\u0001\u0000\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000"+
		"\u0017\u0018\u0001\u0000\u0000\u0000\u0018\u001d\u0001\u0000\u0000\u0000"+
		"\u0019\u0017\u0001\u0000\u0000\u0000\u001a\u001c\u0005\b\u0000\u0000\u001b"+
		"\u001a\u0001\u0000\u0000\u0000\u001c\u001f\u0001\u0000\u0000\u0000\u001d"+
		"\u001b\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e"+
		"\u0003\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000 \""+
		"\u0007\u0000\u0000\u0000! \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000"+
		"\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$%\u0001\u0000"+
		"\u0000\u0000%&\u0005\u0002\u0000\u0000&*\u0003\u0006\u0003\u0000\')\u0005"+
		"\b\u0000\u0000(\'\u0001\u0000\u0000\u0000),\u0001\u0000\u0000\u0000*("+
		"\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+\u0005\u0001\u0000"+
		"\u0000\u0000,*\u0001\u0000\u0000\u0000-1\u0005\u0006\u0000\u0000.1\u0005"+
		"\u0007\u0000\u0000/1\u0003\b\u0004\u00000-\u0001\u0000\u0000\u00000.\u0001"+
		"\u0000\u0000\u00000/\u0001\u0000\u0000\u00001\u0007\u0001\u0000\u0000"+
		"\u000027\u0005\u0004\u0000\u000034\u0005\u0003\u0000\u000046\u0005\u0004"+
		"\u0000\u000053\u0001\u0000\u0000\u000069\u0001\u0000\u0000\u000075\u0001"+
		"\u0000\u0000\u000078\u0001\u0000\u0000\u00008\t\u0001\u0000\u0000\u0000"+
		"97\u0001\u0000\u0000\u0000\b\r\u000f\u0017\u001d#*07";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}