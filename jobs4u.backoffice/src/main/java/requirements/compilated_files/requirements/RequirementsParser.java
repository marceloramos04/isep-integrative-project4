// Generated from C:/Users/tiago/ISEP/semestre4-pi/sem4pi-23-24-2da1/jobs4u.backoffice/src/main/java/requirements/Requirements.g4 by ANTLR 4.13.1
package requirements;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class RequirementsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, ID=4, SPECIAL_CHAR=5, INT=6, DOUBLE=7, NEWLINE=8, 
		ENDLINE=9, BLANK=10;
	public static final int
		RULE_start = 0, RULE_comment = 1, RULE_requirement = 2, RULE_int_answer_requirement = 3, 
		RULE_double_answer_requirement = 4, RULE_single_option_requirement = 5, 
		RULE_multiple_options_requirement = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "comment", "requirement", "int_answer_requirement", "double_answer_requirement", 
			"single_option_requirement", "multiple_options_requirement"
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

	@Override
	public String getGrammarFileName() { return "Requirements.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RequirementsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(RequirementsParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(RequirementsParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RequirementsParser.NEWLINE, i);
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
			if ( listener instanceof RequirementsListener ) ((RequirementsListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementsListener ) ((RequirementsListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementsVisitor ) return ((RequirementsVisitor<? extends T>)visitor).visitStart(this);
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
			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(17);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NEWLINE:
					{
					setState(14);
					match(NEWLINE);
					}
					break;
				case ID:
				case SPECIAL_CHAR:
					{
					setState(15);
					requirement();
					}
					break;
				case T__0:
					{
					setState(16);
					comment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(19); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 306L) != 0) );
			setState(21);
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
		public TerminalNode ENDLINE() { return getToken(RequirementsParser.ENDLINE, 0); }
		public List<TerminalNode> ID() { return getTokens(RequirementsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RequirementsParser.ID, i);
		}
		public List<TerminalNode> SPECIAL_CHAR() { return getTokens(RequirementsParser.SPECIAL_CHAR); }
		public TerminalNode SPECIAL_CHAR(int i) {
			return getToken(RequirementsParser.SPECIAL_CHAR, i);
		}
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementsListener ) ((RequirementsListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementsListener ) ((RequirementsListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementsVisitor ) return ((RequirementsVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_comment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			match(T__0);
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID || _la==SPECIAL_CHAR) {
				{
				{
				setState(24);
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
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(30);
			match(ENDLINE);
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
		public Int_answer_requirementContext int_answer_requirement() {
			return getRuleContext(Int_answer_requirementContext.class,0);
		}
		public Double_answer_requirementContext double_answer_requirement() {
			return getRuleContext(Double_answer_requirementContext.class,0);
		}
		public Single_option_requirementContext single_option_requirement() {
			return getRuleContext(Single_option_requirementContext.class,0);
		}
		public Multiple_options_requirementContext multiple_options_requirement() {
			return getRuleContext(Multiple_options_requirementContext.class,0);
		}
		public RequirementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requirement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementsListener ) ((RequirementsListener)listener).enterRequirement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementsListener ) ((RequirementsListener)listener).exitRequirement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementsVisitor ) return ((RequirementsVisitor<? extends T>)visitor).visitRequirement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequirementContext requirement() throws RecognitionException {
		RequirementContext _localctx = new RequirementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_requirement);
		try {
			setState(36);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				int_answer_requirement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				double_answer_requirement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				single_option_requirement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(35);
				multiple_options_requirement();
				}
				break;
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
	public static class Int_answer_requirementContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(RequirementsParser.INT, 0); }
		public TerminalNode ENDLINE() { return getToken(RequirementsParser.ENDLINE, 0); }
		public List<TerminalNode> ID() { return getTokens(RequirementsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RequirementsParser.ID, i);
		}
		public List<TerminalNode> SPECIAL_CHAR() { return getTokens(RequirementsParser.SPECIAL_CHAR); }
		public TerminalNode SPECIAL_CHAR(int i) {
			return getToken(RequirementsParser.SPECIAL_CHAR, i);
		}
		public Int_answer_requirementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_answer_requirement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementsListener ) ((RequirementsListener)listener).enterInt_answer_requirement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementsListener ) ((RequirementsListener)listener).exitInt_answer_requirement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementsVisitor ) return ((RequirementsVisitor<? extends T>)visitor).visitInt_answer_requirement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Int_answer_requirementContext int_answer_requirement() throws RecognitionException {
		Int_answer_requirementContext _localctx = new Int_answer_requirementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_int_answer_requirement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38);
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
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID || _la==SPECIAL_CHAR );
			setState(43);
			match(T__1);
			setState(44);
			match(INT);
			setState(45);
			match(ENDLINE);
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
	public static class Double_answer_requirementContext extends ParserRuleContext {
		public TerminalNode DOUBLE() { return getToken(RequirementsParser.DOUBLE, 0); }
		public TerminalNode ENDLINE() { return getToken(RequirementsParser.ENDLINE, 0); }
		public List<TerminalNode> ID() { return getTokens(RequirementsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RequirementsParser.ID, i);
		}
		public List<TerminalNode> SPECIAL_CHAR() { return getTokens(RequirementsParser.SPECIAL_CHAR); }
		public TerminalNode SPECIAL_CHAR(int i) {
			return getToken(RequirementsParser.SPECIAL_CHAR, i);
		}
		public Double_answer_requirementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_double_answer_requirement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementsListener ) ((RequirementsListener)listener).enterDouble_answer_requirement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementsListener ) ((RequirementsListener)listener).exitDouble_answer_requirement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementsVisitor ) return ((RequirementsVisitor<? extends T>)visitor).visitDouble_answer_requirement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Double_answer_requirementContext double_answer_requirement() throws RecognitionException {
		Double_answer_requirementContext _localctx = new Double_answer_requirementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_double_answer_requirement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(47);
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
				setState(50); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID || _la==SPECIAL_CHAR );
			setState(52);
			match(T__1);
			setState(53);
			match(DOUBLE);
			setState(54);
			match(ENDLINE);
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
	public static class Single_option_requirementContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(RequirementsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RequirementsParser.ID, i);
		}
		public TerminalNode ENDLINE() { return getToken(RequirementsParser.ENDLINE, 0); }
		public List<TerminalNode> SPECIAL_CHAR() { return getTokens(RequirementsParser.SPECIAL_CHAR); }
		public TerminalNode SPECIAL_CHAR(int i) {
			return getToken(RequirementsParser.SPECIAL_CHAR, i);
		}
		public Single_option_requirementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_option_requirement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementsListener ) ((RequirementsListener)listener).enterSingle_option_requirement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementsListener ) ((RequirementsListener)listener).exitSingle_option_requirement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementsVisitor ) return ((RequirementsVisitor<? extends T>)visitor).visitSingle_option_requirement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_option_requirementContext single_option_requirement() throws RecognitionException {
		Single_option_requirementContext _localctx = new Single_option_requirementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_single_option_requirement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(56);
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
				setState(59); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID || _la==SPECIAL_CHAR );
			setState(61);
			match(T__1);
			setState(62);
			match(ID);
			setState(63);
			match(ENDLINE);
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
	public static class Multiple_options_requirementContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(RequirementsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RequirementsParser.ID, i);
		}
		public TerminalNode ENDLINE() { return getToken(RequirementsParser.ENDLINE, 0); }
		public List<TerminalNode> SPECIAL_CHAR() { return getTokens(RequirementsParser.SPECIAL_CHAR); }
		public TerminalNode SPECIAL_CHAR(int i) {
			return getToken(RequirementsParser.SPECIAL_CHAR, i);
		}
		public Multiple_options_requirementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_options_requirement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementsListener ) ((RequirementsListener)listener).enterMultiple_options_requirement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementsListener ) ((RequirementsListener)listener).exitMultiple_options_requirement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementsVisitor ) return ((RequirementsVisitor<? extends T>)visitor).visitMultiple_options_requirement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_options_requirementContext multiple_options_requirement() throws RecognitionException {
		Multiple_options_requirementContext _localctx = new Multiple_options_requirementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_multiple_options_requirement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(65);
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
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID || _la==SPECIAL_CHAR );
			setState(70);
			match(T__1);
			setState(71);
			match(ID);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(72);
					match(T__2);
					}
					}
					setState(75); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__2 );
				setState(77);
				match(ID);
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83);
			match(ENDLINE);
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
		"\u0004\u0001\nV\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0004\u0000\u0012\b\u0000\u000b\u0000\f\u0000\u0013\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0005\u0001\u001a\b\u0001\n\u0001"+
		"\f\u0001\u001d\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002%\b\u0002\u0001\u0003\u0004\u0003"+
		"(\b\u0003\u000b\u0003\f\u0003)\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0004\u00041\b\u0004\u000b\u0004\f\u00042\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0004\u0005:\b\u0005"+
		"\u000b\u0005\f\u0005;\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0004\u0006C\b\u0006\u000b\u0006\f\u0006D\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0004\u0006J\b\u0006\u000b\u0006\f\u0006K\u0001\u0006"+
		"\u0005\u0006O\b\u0006\n\u0006\f\u0006R\t\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0000\u0000\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000\u0001"+
		"\u0001\u0000\u0004\u0005[\u0000\u0011\u0001\u0000\u0000\u0000\u0002\u0017"+
		"\u0001\u0000\u0000\u0000\u0004$\u0001\u0000\u0000\u0000\u0006\'\u0001"+
		"\u0000\u0000\u0000\b0\u0001\u0000\u0000\u0000\n9\u0001\u0000\u0000\u0000"+
		"\fB\u0001\u0000\u0000\u0000\u000e\u0012\u0005\b\u0000\u0000\u000f\u0012"+
		"\u0003\u0004\u0002\u0000\u0010\u0012\u0003\u0002\u0001\u0000\u0011\u000e"+
		"\u0001\u0000\u0000\u0000\u0011\u000f\u0001\u0000\u0000\u0000\u0011\u0010"+
		"\u0001\u0000\u0000\u0000\u0012\u0013\u0001\u0000\u0000\u0000\u0013\u0011"+
		"\u0001\u0000\u0000\u0000\u0013\u0014\u0001\u0000\u0000\u0000\u0014\u0015"+
		"\u0001\u0000\u0000\u0000\u0015\u0016\u0005\u0000\u0000\u0001\u0016\u0001"+
		"\u0001\u0000\u0000\u0000\u0017\u001b\u0005\u0001\u0000\u0000\u0018\u001a"+
		"\u0007\u0000\u0000\u0000\u0019\u0018\u0001\u0000\u0000\u0000\u001a\u001d"+
		"\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001b\u001c"+
		"\u0001\u0000\u0000\u0000\u001c\u001e\u0001\u0000\u0000\u0000\u001d\u001b"+
		"\u0001\u0000\u0000\u0000\u001e\u001f\u0005\t\u0000\u0000\u001f\u0003\u0001"+
		"\u0000\u0000\u0000 %\u0003\u0006\u0003\u0000!%\u0003\b\u0004\u0000\"%"+
		"\u0003\n\u0005\u0000#%\u0003\f\u0006\u0000$ \u0001\u0000\u0000\u0000$"+
		"!\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000$#\u0001\u0000\u0000"+
		"\u0000%\u0005\u0001\u0000\u0000\u0000&(\u0007\u0000\u0000\u0000\'&\u0001"+
		"\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000"+
		")*\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+,\u0005\u0002\u0000"+
		"\u0000,-\u0005\u0006\u0000\u0000-.\u0005\t\u0000\u0000.\u0007\u0001\u0000"+
		"\u0000\u0000/1\u0007\u0000\u0000\u00000/\u0001\u0000\u0000\u000012\u0001"+
		"\u0000\u0000\u000020\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u0000"+
		"34\u0001\u0000\u0000\u000045\u0005\u0002\u0000\u000056\u0005\u0007\u0000"+
		"\u000067\u0005\t\u0000\u00007\t\u0001\u0000\u0000\u00008:\u0007\u0000"+
		"\u0000\u000098\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;9\u0001"+
		"\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000"+
		"=>\u0005\u0002\u0000\u0000>?\u0005\u0004\u0000\u0000?@\u0005\t\u0000\u0000"+
		"@\u000b\u0001\u0000\u0000\u0000AC\u0007\u0000\u0000\u0000BA\u0001\u0000"+
		"\u0000\u0000CD\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001"+
		"\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FG\u0005\u0002\u0000\u0000"+
		"GP\u0005\u0004\u0000\u0000HJ\u0005\u0003\u0000\u0000IH\u0001\u0000\u0000"+
		"\u0000JK\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000"+
		"\u0000\u0000LM\u0001\u0000\u0000\u0000MO\u0005\u0004\u0000\u0000NI\u0001"+
		"\u0000\u0000\u0000OR\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000"+
		"PQ\u0001\u0000\u0000\u0000QS\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000"+
		"\u0000ST\u0005\t\u0000\u0000T\r\u0001\u0000\u0000\u0000\n\u0011\u0013"+
		"\u001b$)2;DKP";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}