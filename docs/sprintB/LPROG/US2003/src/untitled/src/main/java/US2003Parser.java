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
		JOB_OPENING=1, JOB_REQUIREMENTS=2, CANDIDATE_FIELDS=3, EXPORT_TEMPLATE=4, 
		DATA_FIELD=5, EMAIL=6, PHONE=7, EMAIL_ADDRESS=8, PHONE_NUMBER=9, STRING=10, 
		COLON=11, COMMA=12, LCURLY=13, RCURLY=14, WS=15;
	public static final int
		RULE_job_opening_description = 0, RULE_job_requirements_description = 1, 
		RULE_job_requirement_list = 2, RULE_job_requirement = 3, RULE_candidate_fields_description = 4, 
		RULE_candidate_field_list = 5, RULE_candidate_field = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"job_opening_description", "job_requirements_description", "job_requirement_list", 
			"job_requirement", "candidate_fields_description", "candidate_field_list", 
			"candidate_field"
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
	public static class Job_opening_descriptionContext extends ParserRuleContext {
		public TerminalNode JOB_OPENING() { return getToken(US2003Parser.JOB_OPENING, 0); }
		public TerminalNode LCURLY() { return getToken(US2003Parser.LCURLY, 0); }
		public Job_requirements_descriptionContext job_requirements_description() {
			return getRuleContext(Job_requirements_descriptionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(US2003Parser.COMMA, 0); }
		public Candidate_fields_descriptionContext candidate_fields_description() {
			return getRuleContext(Candidate_fields_descriptionContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(US2003Parser.RCURLY, 0); }
		public Job_opening_descriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_job_opening_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2003Listener ) ((US2003Listener)listener).enterJob_opening_description(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2003Listener ) ((US2003Listener)listener).exitJob_opening_description(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2003Visitor ) return ((US2003Visitor<? extends T>)visitor).visitJob_opening_description(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Job_opening_descriptionContext job_opening_description() throws RecognitionException {
		Job_opening_descriptionContext _localctx = new Job_opening_descriptionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_job_opening_description);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			match(JOB_OPENING);
			setState(15);
			match(LCURLY);
			setState(16);
			job_requirements_description();
			setState(17);
			match(COMMA);
			setState(18);
			candidate_fields_description();
			setState(19);
			match(RCURLY);
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
	public static class Job_requirements_descriptionContext extends ParserRuleContext {
		public TerminalNode JOB_REQUIREMENTS() { return getToken(US2003Parser.JOB_REQUIREMENTS, 0); }
		public TerminalNode LCURLY() { return getToken(US2003Parser.LCURLY, 0); }
		public Job_requirement_listContext job_requirement_list() {
			return getRuleContext(Job_requirement_listContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(US2003Parser.RCURLY, 0); }
		public Job_requirements_descriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_job_requirements_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2003Listener ) ((US2003Listener)listener).enterJob_requirements_description(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2003Listener ) ((US2003Listener)listener).exitJob_requirements_description(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2003Visitor ) return ((US2003Visitor<? extends T>)visitor).visitJob_requirements_description(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Job_requirements_descriptionContext job_requirements_description() throws RecognitionException {
		Job_requirements_descriptionContext _localctx = new Job_requirements_descriptionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_job_requirements_description);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			match(JOB_REQUIREMENTS);
			setState(22);
			match(LCURLY);
			setState(23);
			job_requirement_list();
			setState(24);
			match(RCURLY);
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
	public static class Job_requirement_listContext extends ParserRuleContext {
		public List<Job_requirementContext> job_requirement() {
			return getRuleContexts(Job_requirementContext.class);
		}
		public Job_requirementContext job_requirement(int i) {
			return getRuleContext(Job_requirementContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(US2003Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(US2003Parser.COMMA, i);
		}
		public Job_requirement_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_job_requirement_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2003Listener ) ((US2003Listener)listener).enterJob_requirement_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2003Listener ) ((US2003Listener)listener).exitJob_requirement_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2003Visitor ) return ((US2003Visitor<? extends T>)visitor).visitJob_requirement_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Job_requirement_listContext job_requirement_list() throws RecognitionException {
		Job_requirement_listContext _localctx = new Job_requirement_listContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_job_requirement_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			job_requirement();
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(27);
				match(COMMA);
				setState(28);
				job_requirement();
				}
				}
				setState(33);
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
	public static class Job_requirementContext extends ParserRuleContext {
		public TerminalNode DATA_FIELD() { return getToken(US2003Parser.DATA_FIELD, 0); }
		public TerminalNode COLON() { return getToken(US2003Parser.COLON, 0); }
		public TerminalNode STRING() { return getToken(US2003Parser.STRING, 0); }
		public Job_requirementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_job_requirement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2003Listener ) ((US2003Listener)listener).enterJob_requirement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2003Listener ) ((US2003Listener)listener).exitJob_requirement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2003Visitor ) return ((US2003Visitor<? extends T>)visitor).visitJob_requirement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Job_requirementContext job_requirement() throws RecognitionException {
		Job_requirementContext _localctx = new Job_requirementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_job_requirement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(DATA_FIELD);
			setState(35);
			match(COLON);
			setState(36);
			match(STRING);
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
	public static class Candidate_fields_descriptionContext extends ParserRuleContext {
		public TerminalNode CANDIDATE_FIELDS() { return getToken(US2003Parser.CANDIDATE_FIELDS, 0); }
		public TerminalNode LCURLY() { return getToken(US2003Parser.LCURLY, 0); }
		public Candidate_field_listContext candidate_field_list() {
			return getRuleContext(Candidate_field_listContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(US2003Parser.RCURLY, 0); }
		public Candidate_fields_descriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_candidate_fields_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2003Listener ) ((US2003Listener)listener).enterCandidate_fields_description(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2003Listener ) ((US2003Listener)listener).exitCandidate_fields_description(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2003Visitor ) return ((US2003Visitor<? extends T>)visitor).visitCandidate_fields_description(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Candidate_fields_descriptionContext candidate_fields_description() throws RecognitionException {
		Candidate_fields_descriptionContext _localctx = new Candidate_fields_descriptionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_candidate_fields_description);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(CANDIDATE_FIELDS);
			setState(39);
			match(LCURLY);
			setState(40);
			candidate_field_list();
			setState(41);
			match(RCURLY);
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
	public static class Candidate_field_listContext extends ParserRuleContext {
		public List<Candidate_fieldContext> candidate_field() {
			return getRuleContexts(Candidate_fieldContext.class);
		}
		public Candidate_fieldContext candidate_field(int i) {
			return getRuleContext(Candidate_fieldContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(US2003Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(US2003Parser.COMMA, i);
		}
		public Candidate_field_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_candidate_field_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2003Listener ) ((US2003Listener)listener).enterCandidate_field_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2003Listener ) ((US2003Listener)listener).exitCandidate_field_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2003Visitor ) return ((US2003Visitor<? extends T>)visitor).visitCandidate_field_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Candidate_field_listContext candidate_field_list() throws RecognitionException {
		Candidate_field_listContext _localctx = new Candidate_field_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_candidate_field_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			candidate_field();
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(44);
				match(COMMA);
				setState(45);
				candidate_field();
				}
				}
				setState(50);
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
	public static class Candidate_fieldContext extends ParserRuleContext {
		public TerminalNode DATA_FIELD() { return getToken(US2003Parser.DATA_FIELD, 0); }
		public TerminalNode COLON() { return getToken(US2003Parser.COLON, 0); }
		public TerminalNode STRING() { return getToken(US2003Parser.STRING, 0); }
		public TerminalNode EMAIL() { return getToken(US2003Parser.EMAIL, 0); }
		public TerminalNode PHONE() { return getToken(US2003Parser.PHONE, 0); }
		public Candidate_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_candidate_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2003Listener ) ((US2003Listener)listener).enterCandidate_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2003Listener ) ((US2003Listener)listener).exitCandidate_field(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2003Visitor ) return ((US2003Visitor<? extends T>)visitor).visitCandidate_field(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Candidate_fieldContext candidate_field() throws RecognitionException {
		Candidate_fieldContext _localctx = new Candidate_fieldContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_candidate_field);
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATA_FIELD:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				match(DATA_FIELD);
				setState(52);
				match(COLON);
				setState(53);
				match(STRING);
				}
				break;
			case EMAIL:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(EMAIL);
				}
				break;
			case PHONE:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				match(PHONE);
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

	public static final String _serializedATN =
		"\u0004\u0001\u000f;\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002\u001e\b\u0002\n\u0002\f\u0002!\t\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"/\b\u0005\n\u0005\f\u00052\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u00069\b\u0006\u0001\u0006\u0000\u0000"+
		"\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000\u00007\u0000\u000e\u0001\u0000"+
		"\u0000\u0000\u0002\u0015\u0001\u0000\u0000\u0000\u0004\u001a\u0001\u0000"+
		"\u0000\u0000\u0006\"\u0001\u0000\u0000\u0000\b&\u0001\u0000\u0000\u0000"+
		"\n+\u0001\u0000\u0000\u0000\f8\u0001\u0000\u0000\u0000\u000e\u000f\u0005"+
		"\u0001\u0000\u0000\u000f\u0010\u0005\r\u0000\u0000\u0010\u0011\u0003\u0002"+
		"\u0001\u0000\u0011\u0012\u0005\f\u0000\u0000\u0012\u0013\u0003\b\u0004"+
		"\u0000\u0013\u0014\u0005\u000e\u0000\u0000\u0014\u0001\u0001\u0000\u0000"+
		"\u0000\u0015\u0016\u0005\u0002\u0000\u0000\u0016\u0017\u0005\r\u0000\u0000"+
		"\u0017\u0018\u0003\u0004\u0002\u0000\u0018\u0019\u0005\u000e\u0000\u0000"+
		"\u0019\u0003\u0001\u0000\u0000\u0000\u001a\u001f\u0003\u0006\u0003\u0000"+
		"\u001b\u001c\u0005\f\u0000\u0000\u001c\u001e\u0003\u0006\u0003\u0000\u001d"+
		"\u001b\u0001\u0000\u0000\u0000\u001e!\u0001\u0000\u0000\u0000\u001f\u001d"+
		"\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \u0005\u0001\u0000"+
		"\u0000\u0000!\u001f\u0001\u0000\u0000\u0000\"#\u0005\u0005\u0000\u0000"+
		"#$\u0005\u000b\u0000\u0000$%\u0005\n\u0000\u0000%\u0007\u0001\u0000\u0000"+
		"\u0000&\'\u0005\u0003\u0000\u0000\'(\u0005\r\u0000\u0000()\u0003\n\u0005"+
		"\u0000)*\u0005\u000e\u0000\u0000*\t\u0001\u0000\u0000\u0000+0\u0003\f"+
		"\u0006\u0000,-\u0005\f\u0000\u0000-/\u0003\f\u0006\u0000.,\u0001\u0000"+
		"\u0000\u0000/2\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u000001\u0001"+
		"\u0000\u0000\u00001\u000b\u0001\u0000\u0000\u000020\u0001\u0000\u0000"+
		"\u000034\u0005\u0005\u0000\u000045\u0005\u000b\u0000\u000059\u0005\n\u0000"+
		"\u000069\u0005\u0006\u0000\u000079\u0005\u0007\u0000\u000083\u0001\u0000"+
		"\u0000\u000086\u0001\u0000\u0000\u000087\u0001\u0000\u0000\u00009\r\u0001"+
		"\u0000\u0000\u0000\u0003\u001f08";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}