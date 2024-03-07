// Generated from java-escape by ANTLR 4.11.1
package parser.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, WS=8, REGEX=9, 
		CODE=10, NOT_WS=11;
	public static final int
		RULE_start = 0, RULE_grammarName = 1, RULE_typeName = 2, RULE_header = 3, 
		RULE_ruleList = 4, RULE_ruleObj = 5, RULE_branchList = 6, RULE_branch = 7, 
		RULE_calcResult = 8, RULE_elementList = 9, RULE_tokenList = 10, RULE_token = 11, 
		RULE_tokenTail = 12, RULE_additionalCode = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "grammarName", "typeName", "header", "ruleList", "ruleObj", 
			"branchList", "branch", "calcResult", "elementList", "tokenList", "token", 
			"tokenTail", "additionalCode"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'grammar'", "';'", "'type'", "'@header'", "'|'", "':'", "'-> skip'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "WS", "REGEX", "CODE", 
			"NOT_WS"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public GrammarNameContext gn;
		public TypeNameContext grammarType;
		public HeaderContext headerList;
		public RuleListContext rules;
		public TokenListContext tokens;
		public AdditionalCodeContext codePart;
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public GrammarNameContext grammarName() {
			return getRuleContext(GrammarNameContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public RuleListContext ruleList() {
			return getRuleContext(RuleListContext.class,0);
		}
		public TokenListContext tokenList() {
			return getRuleContext(TokenListContext.class,0);
		}
		public AdditionalCodeContext additionalCode() {
			return getRuleContext(AdditionalCodeContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			((StartContext)_localctx).gn = grammarName();
			setState(29);
			((StartContext)_localctx).grammarType = typeName();
			setState(30);
			((StartContext)_localctx).headerList = header();
			setState(31);
			((StartContext)_localctx).rules = ruleList();
			setState(32);
			((StartContext)_localctx).tokens = tokenList();
			setState(33);
			((StartContext)_localctx).codePart = additionalCode();
			setState(34);
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
	public static class GrammarNameContext extends ParserRuleContext {
		public Token name;
		public TerminalNode NOT_WS() { return getToken(GrammarParser.NOT_WS, 0); }
		public GrammarNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grammarName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterGrammarName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitGrammarName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitGrammarName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GrammarNameContext grammarName() throws RecognitionException {
		GrammarNameContext _localctx = new GrammarNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_grammarName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(T__0);
			setState(37);
			((GrammarNameContext)_localctx).name = match(NOT_WS);
			setState(38);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeNameContext extends ParserRuleContext {
		public Token name;
		public TerminalNode CODE() { return getToken(GrammarParser.CODE, 0); }
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_typeName);
		try {
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				match(T__2);
				setState(41);
				((TypeNameContext)_localctx).name = match(CODE);
				setState(42);
				match(T__1);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
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
	public static class HeaderContext extends ParserRuleContext {
		public Token headers;
		public TerminalNode CODE() { return getToken(GrammarParser.CODE, 0); }
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__3);
			setState(47);
			((HeaderContext)_localctx).headers = match(CODE);
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
	public static class RuleListContext extends ParserRuleContext {
		public RuleObjContext rule_;
		public RuleListContext tail;
		public RuleObjContext ruleObj() {
			return getRuleContext(RuleObjContext.class,0);
		}
		public RuleListContext ruleList() {
			return getRuleContext(RuleListContext.class,0);
		}
		public RuleListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterRuleList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitRuleList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitRuleList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleListContext ruleList() throws RecognitionException {
		RuleListContext _localctx = new RuleListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ruleList);
		try {
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				((RuleListContext)_localctx).rule_ = ruleObj();
				setState(50);
				((RuleListContext)_localctx).tail = ruleList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
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
	public static class RuleObjContext extends ParserRuleContext {
		public Token name;
		public BranchListContext branches;
		public TerminalNode NOT_WS() { return getToken(GrammarParser.NOT_WS, 0); }
		public BranchListContext branchList() {
			return getRuleContext(BranchListContext.class,0);
		}
		public RuleObjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleObj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterRuleObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitRuleObj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitRuleObj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleObjContext ruleObj() throws RecognitionException {
		RuleObjContext _localctx = new RuleObjContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ruleObj);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			((RuleObjContext)_localctx).name = match(NOT_WS);
			setState(56);
			((RuleObjContext)_localctx).branches = branchList();
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
	public static class BranchListContext extends ParserRuleContext {
		public BranchContext headBranch;
		public BranchListContext tail;
		public BranchContext branch() {
			return getRuleContext(BranchContext.class,0);
		}
		public BranchListContext branchList() {
			return getRuleContext(BranchListContext.class,0);
		}
		public BranchListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBranchList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBranchList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitBranchList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchListContext branchList() throws RecognitionException {
		BranchListContext _localctx = new BranchListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_branchList);
		try {
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(T__4);
				setState(59);
				((BranchListContext)_localctx).headBranch = branch();
				setState(60);
				((BranchListContext)_localctx).tail = branchList();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				match(T__1);
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
	public static class BranchContext extends ParserRuleContext {
		public ElementListContext elements;
		public CalcResultContext calculation;
		public ElementListContext elementList() {
			return getRuleContext(ElementListContext.class,0);
		}
		public CalcResultContext calcResult() {
			return getRuleContext(CalcResultContext.class,0);
		}
		public BranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBranch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBranch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchContext branch() throws RecognitionException {
		BranchContext _localctx = new BranchContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_branch);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				((BranchContext)_localctx).elements = elementList();
				setState(66);
				((BranchContext)_localctx).calculation = calcResult();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				((BranchContext)_localctx).calculation = calcResult();
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
	public static class CalcResultContext extends ParserRuleContext {
		public Token val;
		public TerminalNode CODE() { return getToken(GrammarParser.CODE, 0); }
		public CalcResultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calcResult; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCalcResult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCalcResult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitCalcResult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalcResultContext calcResult() throws RecognitionException {
		CalcResultContext _localctx = new CalcResultContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_calcResult);
		try {
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CODE:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				((CalcResultContext)_localctx).val = match(CODE);
				}
				break;
			case T__1:
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
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
	public static class ElementListContext extends ParserRuleContext {
		public Token headElement;
		public ElementListContext tail;
		public TerminalNode NOT_WS() { return getToken(GrammarParser.NOT_WS, 0); }
		public ElementListContext elementList() {
			return getRuleContext(ElementListContext.class,0);
		}
		public ElementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterElementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitElementList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitElementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementListContext elementList() throws RecognitionException {
		ElementListContext _localctx = new ElementListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_elementList);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT_WS:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				((ElementListContext)_localctx).headElement = match(NOT_WS);
				setState(76);
				((ElementListContext)_localctx).tail = elementList();
				}
				break;
			case T__1:
			case T__4:
			case CODE:
				enterOuterAlt(_localctx, 2);
				{
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
	public static class TokenListContext extends ParserRuleContext {
		public TokenContext headToken;
		public TokenListContext tail;
		public TokenContext token() {
			return getRuleContext(TokenContext.class,0);
		}
		public TokenListContext tokenList() {
			return getRuleContext(TokenListContext.class,0);
		}
		public TokenListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokenList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTokenList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTokenList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitTokenList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TokenListContext tokenList() throws RecognitionException {
		TokenListContext _localctx = new TokenListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tokenList);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT_WS:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				((TokenListContext)_localctx).headToken = token();
				setState(81);
				((TokenListContext)_localctx).tail = tokenList();
				}
				break;
			case EOF:
			case REGEX:
				enterOuterAlt(_localctx, 2);
				{
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
	public static class TokenContext extends ParserRuleContext {
		public Token name;
		public Token regex;
		public TokenTailContext tail;
		public TerminalNode NOT_WS() { return getToken(GrammarParser.NOT_WS, 0); }
		public TerminalNode REGEX() { return getToken(GrammarParser.REGEX, 0); }
		public TokenTailContext tokenTail() {
			return getRuleContext(TokenTailContext.class,0);
		}
		public TokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitToken(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitToken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TokenContext token() throws RecognitionException {
		TokenContext _localctx = new TokenContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_token);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			((TokenContext)_localctx).name = match(NOT_WS);
			setState(87);
			match(T__5);
			setState(88);
			((TokenContext)_localctx).regex = match(REGEX);
			setState(89);
			((TokenContext)_localctx).tail = tokenTail();
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
	public static class TokenTailContext extends ParserRuleContext {
		public Token val;
		public CalcResultContext calculation;
		public CalcResultContext calcResult() {
			return getRuleContext(CalcResultContext.class,0);
		}
		public TokenTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokenTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTokenTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTokenTail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitTokenTail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TokenTailContext tokenTail() throws RecognitionException {
		TokenTailContext _localctx = new TokenTailContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tokenTail);
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				((TokenTailContext)_localctx).val = match(T__6);
				setState(92);
				((TokenTailContext)_localctx).calculation = calcResult();
				setState(93);
				match(T__1);
				}
				break;
			case T__1:
			case CODE:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				((TokenTailContext)_localctx).calculation = calcResult();
				setState(96);
				((TokenTailContext)_localctx).val = match(T__1);
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
	public static class AdditionalCodeContext extends ParserRuleContext {
		public Token code;
		public TerminalNode REGEX() { return getToken(GrammarParser.REGEX, 0); }
		public AdditionalCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additionalCode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAdditionalCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAdditionalCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAdditionalCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditionalCodeContext additionalCode() throws RecognitionException {
		AdditionalCodeContext _localctx = new AdditionalCodeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_additionalCode);
		try {
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REGEX:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				((AdditionalCodeContext)_localctx).code = match(REGEX);
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
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
		"\u0004\u0001\u000bi\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002-\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u00046\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006@\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007F\b\u0007\u0001\b\u0001\b\u0003\bJ\b\b\u0001\t"+
		"\u0001\t\u0001\t\u0003\tO\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n"+
		"U\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\fc\b\f\u0001"+
		"\r\u0001\r\u0003\rg\b\r\u0001\r\u0000\u0000\u000e\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0000c\u0000\u001c"+
		"\u0001\u0000\u0000\u0000\u0002$\u0001\u0000\u0000\u0000\u0004,\u0001\u0000"+
		"\u0000\u0000\u0006.\u0001\u0000\u0000\u0000\b5\u0001\u0000\u0000\u0000"+
		"\n7\u0001\u0000\u0000\u0000\f?\u0001\u0000\u0000\u0000\u000eE\u0001\u0000"+
		"\u0000\u0000\u0010I\u0001\u0000\u0000\u0000\u0012N\u0001\u0000\u0000\u0000"+
		"\u0014T\u0001\u0000\u0000\u0000\u0016V\u0001\u0000\u0000\u0000\u0018b"+
		"\u0001\u0000\u0000\u0000\u001af\u0001\u0000\u0000\u0000\u001c\u001d\u0003"+
		"\u0002\u0001\u0000\u001d\u001e\u0003\u0004\u0002\u0000\u001e\u001f\u0003"+
		"\u0006\u0003\u0000\u001f \u0003\b\u0004\u0000 !\u0003\u0014\n\u0000!\""+
		"\u0003\u001a\r\u0000\"#\u0005\u0000\u0000\u0001#\u0001\u0001\u0000\u0000"+
		"\u0000$%\u0005\u0001\u0000\u0000%&\u0005\u000b\u0000\u0000&\'\u0005\u0002"+
		"\u0000\u0000\'\u0003\u0001\u0000\u0000\u0000()\u0005\u0003\u0000\u0000"+
		")*\u0005\n\u0000\u0000*-\u0005\u0002\u0000\u0000+-\u0001\u0000\u0000\u0000"+
		",(\u0001\u0000\u0000\u0000,+\u0001\u0000\u0000\u0000-\u0005\u0001\u0000"+
		"\u0000\u0000./\u0005\u0004\u0000\u0000/0\u0005\n\u0000\u00000\u0007\u0001"+
		"\u0000\u0000\u000012\u0003\n\u0005\u000023\u0003\b\u0004\u000036\u0001"+
		"\u0000\u0000\u000046\u0001\u0000\u0000\u000051\u0001\u0000\u0000\u0000"+
		"54\u0001\u0000\u0000\u00006\t\u0001\u0000\u0000\u000078\u0005\u000b\u0000"+
		"\u000089\u0003\f\u0006\u00009\u000b\u0001\u0000\u0000\u0000:;\u0005\u0005"+
		"\u0000\u0000;<\u0003\u000e\u0007\u0000<=\u0003\f\u0006\u0000=@\u0001\u0000"+
		"\u0000\u0000>@\u0005\u0002\u0000\u0000?:\u0001\u0000\u0000\u0000?>\u0001"+
		"\u0000\u0000\u0000@\r\u0001\u0000\u0000\u0000AB\u0003\u0012\t\u0000BC"+
		"\u0003\u0010\b\u0000CF\u0001\u0000\u0000\u0000DF\u0003\u0010\b\u0000E"+
		"A\u0001\u0000\u0000\u0000ED\u0001\u0000\u0000\u0000F\u000f\u0001\u0000"+
		"\u0000\u0000GJ\u0005\n\u0000\u0000HJ\u0001\u0000\u0000\u0000IG\u0001\u0000"+
		"\u0000\u0000IH\u0001\u0000\u0000\u0000J\u0011\u0001\u0000\u0000\u0000"+
		"KL\u0005\u000b\u0000\u0000LO\u0003\u0012\t\u0000MO\u0001\u0000\u0000\u0000"+
		"NK\u0001\u0000\u0000\u0000NM\u0001\u0000\u0000\u0000O\u0013\u0001\u0000"+
		"\u0000\u0000PQ\u0003\u0016\u000b\u0000QR\u0003\u0014\n\u0000RU\u0001\u0000"+
		"\u0000\u0000SU\u0001\u0000\u0000\u0000TP\u0001\u0000\u0000\u0000TS\u0001"+
		"\u0000\u0000\u0000U\u0015\u0001\u0000\u0000\u0000VW\u0005\u000b\u0000"+
		"\u0000WX\u0005\u0006\u0000\u0000XY\u0005\t\u0000\u0000YZ\u0003\u0018\f"+
		"\u0000Z\u0017\u0001\u0000\u0000\u0000[\\\u0005\u0007\u0000\u0000\\]\u0003"+
		"\u0010\b\u0000]^\u0005\u0002\u0000\u0000^c\u0001\u0000\u0000\u0000_`\u0003"+
		"\u0010\b\u0000`a\u0005\u0002\u0000\u0000ac\u0001\u0000\u0000\u0000b[\u0001"+
		"\u0000\u0000\u0000b_\u0001\u0000\u0000\u0000c\u0019\u0001\u0000\u0000"+
		"\u0000dg\u0005\t\u0000\u0000eg\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000"+
		"\u0000fe\u0001\u0000\u0000\u0000g\u001b\u0001\u0000\u0000\u0000\t,5?E"+
		"INTbf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
