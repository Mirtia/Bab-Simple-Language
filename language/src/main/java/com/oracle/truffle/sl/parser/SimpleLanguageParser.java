// Generated from SimpleLanguage.g4 by ANTLR 4.9.2

// DO NOT MODIFY - generated from SimpleLanguage.g4 using "mx create-sl-parser"
package com.oracle.truffle.sl.parser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.strings.TruffleString;
import com.oracle.truffle.sl.SLLanguage;
import com.oracle.truffle.sl.nodes.SLExpressionNode;
import com.oracle.truffle.sl.nodes.SLStatementNode;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, WS=34, COMMENT=35, LINE_COMMENT=36, IDENTIFIER=37, 
		STRING_LITERAL=38, NUMERIC_LITERAL=39;
	public static final int
		RULE_simplelanguage = 0, RULE_function = 1, RULE_block = 2, RULE_statement = 3, 
		RULE_array_init = 4, RULE_for_statement = 5, RULE_pfor_statement = 6, 
		RULE_while_statement = 7, RULE_if_statement = 8, RULE_return_statement = 9, 
		RULE_expression = 10, RULE_logic_term = 11, RULE_logic_factor = 12, RULE_arithmetic = 13, 
		RULE_term = 14, RULE_factor = 15, RULE_member_expression = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"simplelanguage", "function", "block", "statement", "array_init", "for_statement", 
			"pfor_statement", "while_statement", "if_statement", "return_statement", 
			"expression", "logic_term", "logic_factor", "arithmetic", "term", "factor", 
			"member_expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'function'", "'('", "','", "')'", "'{'", "'}'", "'break'", "';'", 
			"'continue'", "'debugger'", "'for'", "'pfor'", "'='", "':'", "'while'", 
			"'if'", "'else'", "'return'", "'||'", "'&&'", "'<'", "'<='", "'>'", "'>='", 
			"'=='", "'!='", "'+'", "'-'", "'*'", "'/'", "'.'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "WS", "COMMENT", 
			"LINE_COMMENT", "IDENTIFIER", "STRING_LITERAL", "NUMERIC_LITERAL"
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
	public String getGrammarFileName() { return "SimpleLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	private SLNodeFactory factory;
	private Source source;

	private static final class BailoutErrorListener extends BaseErrorListener {
	    private final Source source;
	    BailoutErrorListener(Source source) {
	        this.source = source;
	    }
	    @Override
	    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
	        throwParseError(source, line, charPositionInLine, (Token) offendingSymbol, msg);
	    }
	}

	public void SemErr(Token token, String message) {
	    assert token != null;
	    throwParseError(source, token.getLine(), token.getCharPositionInLine(), token, message);
	}

	private static void throwParseError(Source source, int line, int charPositionInLine, Token token, String message) {
	    int col = charPositionInLine + 1;
	    String location = "-- line " + line + " col " + col + ": ";
	    int length = token == null ? 1 : Math.max(token.getStopIndex() - token.getStartIndex(), 0);
	    throw new SLParseError(source, line, col, length, String.format("Error(s) parsing script:%n" + location + message));
	}

	public static Map<TruffleString, RootCallTarget> parseSL(SLLanguage language, Source source) {
	    SimpleLanguageLexer lexer = new SimpleLanguageLexer(CharStreams.fromString(source.getCharacters().toString()));
	    SimpleLanguageParser parser = new SimpleLanguageParser(new CommonTokenStream(lexer));
	    lexer.removeErrorListeners();
	    parser.removeErrorListeners();
	    BailoutErrorListener listener = new BailoutErrorListener(source);
	    lexer.addErrorListener(listener);
	    parser.addErrorListener(listener);
	    parser.factory = new SLNodeFactory(language, source);
	    parser.source = source;
	    parser.simplelanguage();
	    return parser.factory.getAllFunctions();
	}

	public SimpleLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SimplelanguageContext extends ParserRuleContext {
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public TerminalNode EOF() { return getToken(SimpleLanguageParser.EOF, 0); }
		public SimplelanguageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simplelanguage; }
	}

	public final SimplelanguageContext simplelanguage() throws RecognitionException {
		SimplelanguageContext _localctx = new SimplelanguageContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_simplelanguage);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			function();
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(35);
				function();
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
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

	public static class FunctionContext extends ParserRuleContext {
		public Token IDENTIFIER;
		public Token s;
		public BlockContext body;
		public List<TerminalNode> IDENTIFIER() { return getTokens(SimpleLanguageParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SimpleLanguageParser.IDENTIFIER, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(T__0);
			setState(44);
			((FunctionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			setState(45);
			((FunctionContext)_localctx).s = match(T__1);
			 factory.startFunction(((FunctionContext)_localctx).IDENTIFIER, ((FunctionContext)_localctx).s); 
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(47);
				((FunctionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 factory.addFormalParameter(((FunctionContext)_localctx).IDENTIFIER); 
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(49);
					match(T__2);
					setState(50);
					((FunctionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
					 factory.addFormalParameter(((FunctionContext)_localctx).IDENTIFIER); 
					}
					}
					setState(56);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(59);
			match(T__3);
			setState(60);
			((FunctionContext)_localctx).body = block(false, null);
			 factory.finishFunction(((FunctionContext)_localctx).body.result); 
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

	public static class BlockContext extends ParserRuleContext {
		public boolean inLoop;
		public SLStatementNode step;
		public SLStatementNode result;
		public Token s;
		public StatementContext statement;
		public Token e;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public BlockContext(ParserRuleContext parent, int invokingState, boolean inLoop, SLStatementNode step) {
			super(parent, invokingState);
			this.inLoop = inLoop;
			this.step = step;
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block(boolean inLoop,SLStatementNode step) throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState(), inLoop, step);
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 factory.startBlock();
			                                                  List<SLStatementNode> body = new ArrayList<>(); 
			setState(64);
			((BlockContext)_localctx).s = match(T__4);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << IDENTIFIER) | (1L << STRING_LITERAL) | (1L << NUMERIC_LITERAL))) != 0)) {
				{
				{
				setState(65);
				((BlockContext)_localctx).statement = statement(inLoop);
				 body.add(((BlockContext)_localctx).statement.result); 
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
			((BlockContext)_localctx).e = match(T__5);
			 if (step != null) {
			                                                    body.add(step);
			                                                  }
			                                                  ((BlockContext)_localctx).result =  factory.finishBlock(body, ((BlockContext)_localctx).s.getStartIndex(), ((BlockContext)_localctx).e.getStopIndex() - ((BlockContext)_localctx).s.getStartIndex() + 1, true); 
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

	public static class StatementContext extends ParserRuleContext {
		public boolean inLoop;
		public SLStatementNode result;
		public While_statementContext while_statement;
		public For_statementContext for_statement;
		public Pfor_statementContext pfor_statement;
		public Token b;
		public Token c;
		public If_statementContext if_statement;
		public Return_statementContext return_statement;
		public ExpressionContext expression;
		public Token d;
		public While_statementContext while_statement() {
			return getRuleContext(While_statementContext.class,0);
		}
		public For_statementContext for_statement() {
			return getRuleContext(For_statementContext.class,0);
		}
		public Pfor_statementContext pfor_statement() {
			return getRuleContext(Pfor_statementContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public StatementContext(ParserRuleContext parent, int invokingState, boolean inLoop) {
			super(parent, invokingState);
			this.inLoop = inLoop;
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement(boolean inLoop) throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState(), inLoop);
		enterRule(_localctx, 6, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				{
				setState(76);
				((StatementContext)_localctx).while_statement = while_statement();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).while_statement.result; 
				}
				break;
			case T__10:
				{
				setState(79);
				((StatementContext)_localctx).for_statement = for_statement();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).for_statement.result;  
				}
				break;
			case T__11:
				{
				setState(82);
				((StatementContext)_localctx).pfor_statement = pfor_statement();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).pfor_statement.result; 
				}
				break;
			case T__6:
				{
				setState(85);
				((StatementContext)_localctx).b = match(T__6);
				 if (inLoop) { ((StatementContext)_localctx).result =  factory.createBreak(((StatementContext)_localctx).b); } else { SemErr(((StatementContext)_localctx).b, "break used outside of loop"); } 
				setState(87);
				match(T__7);
				}
				break;
			case T__8:
				{
				setState(88);
				((StatementContext)_localctx).c = match(T__8);
				 if (inLoop) { ((StatementContext)_localctx).result =  factory.createContinue(((StatementContext)_localctx).c); } else { SemErr(((StatementContext)_localctx).c, "continue used outside of loop"); } 
				setState(90);
				match(T__7);
				}
				break;
			case T__15:
				{
				setState(91);
				((StatementContext)_localctx).if_statement = if_statement(inLoop);
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).if_statement.result; 
				}
				break;
			case T__17:
				{
				setState(94);
				((StatementContext)_localctx).return_statement = return_statement();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).return_statement.result; 
				}
				break;
			case T__1:
			case IDENTIFIER:
			case STRING_LITERAL:
			case NUMERIC_LITERAL:
				{
				setState(97);
				((StatementContext)_localctx).expression = expression();
				setState(98);
				match(T__7);
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).expression.result; 
				}
				break;
			case T__9:
				{
				setState(101);
				((StatementContext)_localctx).d = match(T__9);
				 ((StatementContext)_localctx).result =  factory.createDebugger(((StatementContext)_localctx).d); 
				setState(103);
				match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Array_initContext extends ParserRuleContext {
		public SLStatementNode result;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Array_initContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_init; }
	}

	public final Array_initContext array_init() throws RecognitionException {
		Array_initContext _localctx = new Array_initContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_array_init);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__4);
			 List<SLExpressionNode> exprList = new ArrayList<SLExpressionNode>(); 
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << IDENTIFIER) | (1L << STRING_LITERAL) | (1L << NUMERIC_LITERAL))) != 0)) {
				{
				setState(108);
				((Array_initContext)_localctx).expression = expression();
				 exprList.add(((Array_initContext)_localctx).expression.result); 
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(110);
					match(T__2);
					setState(111);
					((Array_initContext)_localctx).expression = expression();
					 exprList.add(((Array_initContext)_localctx).expression.result); 
					}
					}
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(121);
			match(T__5);
			 ((Array_initContext)_localctx).result =  factory.createArray(exprList); 
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

	public static class For_statementContext extends ParserRuleContext {
		public SLStatementNode result;
		public Token f;
		public Token o;
		public ExpressionContext initialization;
		public ExpressionContext condition;
		public ExpressionContext step;
		public Token c;
		public BlockContext body;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public For_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_statement; }
	}

	public final For_statementContext for_statement() throws RecognitionException {
		For_statementContext _localctx = new For_statementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_for_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			((For_statementContext)_localctx).f = match(T__10);
			 SLStatementNode assignmentNode = null;
			                                                  SLStatementNode stepNode = null; 
			setState(126);
			((For_statementContext)_localctx).o = match(T__1);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << IDENTIFIER) | (1L << STRING_LITERAL) | (1L << NUMERIC_LITERAL))) != 0)) {
				{
				setState(127);
				((For_statementContext)_localctx).initialization = expression();
				 assignmentNode = ((For_statementContext)_localctx).initialization.result; 
				}
			}

			setState(132);
			match(T__7);
			setState(133);
			((For_statementContext)_localctx).condition = expression();
			setState(134);
			match(T__7);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << IDENTIFIER) | (1L << STRING_LITERAL) | (1L << NUMERIC_LITERAL))) != 0)) {
				{
				setState(135);
				((For_statementContext)_localctx).step = expression();
				 stepNode = ((For_statementContext)_localctx).step.result; 
				}
			}

			setState(140);
			((For_statementContext)_localctx).c = match(T__3);
			setState(141);
			((For_statementContext)_localctx).body = block(true, stepNode);
			 SLStatementNode loopNode = factory.createWhile(((For_statementContext)_localctx).f, ((For_statementContext)_localctx).condition.result, ((For_statementContext)_localctx).body.result);
			                                                  if (assignmentNode != null) {
			                                                    List<SLStatementNode> forNode = new ArrayList<>();
			                                                    forNode.add(assignmentNode);
			                                                    forNode.add(loopNode);
			                                                    ((For_statementContext)_localctx).result =  factory.finishBlock(forNode, ((For_statementContext)_localctx).o.getStartIndex(), ((For_statementContext)_localctx).body.result.getSourceEndIndex() - ((For_statementContext)_localctx).o.getStartIndex() + 1, false);
			                                                  } else {
			                                                    ((For_statementContext)_localctx).result =  loopNode;
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

	public static class Pfor_statementContext extends ParserRuleContext {
		public SLStatementNode result;
		public Token f;
		public Token o;
		public Token IDENTIFIER;
		public ArithmeticContext start;
		public ArithmeticContext end;
		public Token c;
		public BlockContext body;
		public TerminalNode IDENTIFIER() { return getToken(SimpleLanguageParser.IDENTIFIER, 0); }
		public List<ArithmeticContext> arithmetic() {
			return getRuleContexts(ArithmeticContext.class);
		}
		public ArithmeticContext arithmetic(int i) {
			return getRuleContext(ArithmeticContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Pfor_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pfor_statement; }
	}

	public final Pfor_statementContext pfor_statement() throws RecognitionException {
		Pfor_statementContext _localctx = new Pfor_statementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_pfor_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			((Pfor_statementContext)_localctx).f = match(T__11);
			setState(145);
			((Pfor_statementContext)_localctx).o = match(T__1);
			setState(146);
			((Pfor_statementContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			 SLExpressionNode assignmentName = factory.createStringLiteral(((Pfor_statementContext)_localctx).IDENTIFIER, false); 
			setState(148);
			match(T__12);
			setState(149);
			((Pfor_statementContext)_localctx).start = arithmetic();
			 SLExpressionNode assignmentNode = factory.createAssignment(assignmentName, ((Pfor_statementContext)_localctx).start.result);
			setState(151);
			match(T__13);
			setState(152);
			((Pfor_statementContext)_localctx).end = arithmetic();
			setState(153);
			((Pfor_statementContext)_localctx).c = match(T__3);
			setState(154);
			((Pfor_statementContext)_localctx).body = block(true, null);
			 SLStatementNode pfor = factory.createPFor(((Pfor_statementContext)_localctx).f, ((Pfor_statementContext)_localctx).body.result, assignmentName, ((Pfor_statementContext)_localctx).start.result, ((Pfor_statementContext)_localctx).end.result);
			                                                   List<SLStatementNode> pforNode = new ArrayList<>();
			                                                   pforNode.add(assignmentNode);
			                                                   pforNode.add(pfor);
			                                                   ((Pfor_statementContext)_localctx).result =  factory.finishBlock(pforNode, ((Pfor_statementContext)_localctx).o.getStartIndex(), ((Pfor_statementContext)_localctx).body.result.getSourceEndIndex() - ((Pfor_statementContext)_localctx).o.getStartIndex() + 1, false);
			                                                
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

	public static class While_statementContext extends ParserRuleContext {
		public SLStatementNode result;
		public Token w;
		public ExpressionContext condition;
		public BlockContext body;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public While_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_statement; }
	}

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_while_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			((While_statementContext)_localctx).w = match(T__14);
			setState(158);
			match(T__1);
			setState(159);
			((While_statementContext)_localctx).condition = expression();
			setState(160);
			match(T__3);
			setState(161);
			((While_statementContext)_localctx).body = block(true, null);
			 ((While_statementContext)_localctx).result =  factory.createWhile(((While_statementContext)_localctx).w, ((While_statementContext)_localctx).condition.result, ((While_statementContext)_localctx).body.result); 
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

	public static class If_statementContext extends ParserRuleContext {
		public boolean inLoop;
		public SLStatementNode result;
		public Token i;
		public ExpressionContext condition;
		public BlockContext then;
		public BlockContext block;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public If_statementContext(ParserRuleContext parent, int invokingState, boolean inLoop) {
			super(parent, invokingState);
			this.inLoop = inLoop;
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
	}

	public final If_statementContext if_statement(boolean inLoop) throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState(), inLoop);
		enterRule(_localctx, 16, RULE_if_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			((If_statementContext)_localctx).i = match(T__15);
			setState(165);
			match(T__1);
			setState(166);
			((If_statementContext)_localctx).condition = expression();
			setState(167);
			match(T__3);
			setState(168);
			((If_statementContext)_localctx).then = ((If_statementContext)_localctx).block = block(inLoop, null);
			 SLStatementNode elsePart = null; 
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(170);
				match(T__16);
				setState(171);
				((If_statementContext)_localctx).block = block(inLoop, null);
				 elsePart = ((If_statementContext)_localctx).block.result; 
				}
			}

			 ((If_statementContext)_localctx).result =  factory.createIf(((If_statementContext)_localctx).i, ((If_statementContext)_localctx).condition.result, ((If_statementContext)_localctx).then.result, elsePart); 
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

	public static class Return_statementContext extends ParserRuleContext {
		public SLStatementNode result;
		public Token r;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Return_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_statement; }
	}

	public final Return_statementContext return_statement() throws RecognitionException {
		Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_return_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			((Return_statementContext)_localctx).r = match(T__17);
			 SLExpressionNode value = null; 
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << IDENTIFIER) | (1L << STRING_LITERAL) | (1L << NUMERIC_LITERAL))) != 0)) {
				{
				setState(180);
				((Return_statementContext)_localctx).expression = expression();
				 value = ((Return_statementContext)_localctx).expression.result; 
				}
			}

			 ((Return_statementContext)_localctx).result =  factory.createReturn(((Return_statementContext)_localctx).r, value); 
			setState(186);
			match(T__7);
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

	public static class ExpressionContext extends ParserRuleContext {
		public SLExpressionNode result;
		public Logic_termContext logic_term;
		public Token op;
		public List<Logic_termContext> logic_term() {
			return getRuleContexts(Logic_termContext.class);
		}
		public Logic_termContext logic_term(int i) {
			return getRuleContext(Logic_termContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			((ExpressionContext)_localctx).logic_term = logic_term();
			 ((ExpressionContext)_localctx).result =  ((ExpressionContext)_localctx).logic_term.result; 
			setState(196);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(190);
					((ExpressionContext)_localctx).op = match(T__18);
					setState(191);
					((ExpressionContext)_localctx).logic_term = logic_term();
					 ((ExpressionContext)_localctx).result =  factory.createBinary(((ExpressionContext)_localctx).op, _localctx.result, ((ExpressionContext)_localctx).logic_term.result); 
					}
					} 
				}
				setState(198);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class Logic_termContext extends ParserRuleContext {
		public SLExpressionNode result;
		public Logic_factorContext logic_factor;
		public Token op;
		public List<Logic_factorContext> logic_factor() {
			return getRuleContexts(Logic_factorContext.class);
		}
		public Logic_factorContext logic_factor(int i) {
			return getRuleContext(Logic_factorContext.class,i);
		}
		public Logic_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_term; }
	}

	public final Logic_termContext logic_term() throws RecognitionException {
		Logic_termContext _localctx = new Logic_termContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_logic_term);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			((Logic_termContext)_localctx).logic_factor = logic_factor();
			 ((Logic_termContext)_localctx).result =  ((Logic_termContext)_localctx).logic_factor.result; 
			setState(207);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(201);
					((Logic_termContext)_localctx).op = match(T__19);
					setState(202);
					((Logic_termContext)_localctx).logic_factor = logic_factor();
					 ((Logic_termContext)_localctx).result =  factory.createBinary(((Logic_termContext)_localctx).op, _localctx.result, ((Logic_termContext)_localctx).logic_factor.result); 
					}
					} 
				}
				setState(209);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class Logic_factorContext extends ParserRuleContext {
		public SLExpressionNode result;
		public ArithmeticContext arithmetic;
		public Token op;
		public List<ArithmeticContext> arithmetic() {
			return getRuleContexts(ArithmeticContext.class);
		}
		public ArithmeticContext arithmetic(int i) {
			return getRuleContext(ArithmeticContext.class,i);
		}
		public Logic_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_factor; }
	}

	public final Logic_factorContext logic_factor() throws RecognitionException {
		Logic_factorContext _localctx = new Logic_factorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_logic_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			((Logic_factorContext)_localctx).arithmetic = arithmetic();
			 ((Logic_factorContext)_localctx).result =  ((Logic_factorContext)_localctx).arithmetic.result; 
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(212);
				((Logic_factorContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
					((Logic_factorContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(213);
				((Logic_factorContext)_localctx).arithmetic = arithmetic();
				 ((Logic_factorContext)_localctx).result =  factory.createBinary(((Logic_factorContext)_localctx).op, _localctx.result, ((Logic_factorContext)_localctx).arithmetic.result); 
				}
				break;
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

	public static class ArithmeticContext extends ParserRuleContext {
		public SLExpressionNode result;
		public TermContext term;
		public Token op;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public ArithmeticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic; }
	}

	public final ArithmeticContext arithmetic() throws RecognitionException {
		ArithmeticContext _localctx = new ArithmeticContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arithmetic);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			((ArithmeticContext)_localctx).term = term();
			 ((ArithmeticContext)_localctx).result =  ((ArithmeticContext)_localctx).term.result; 
			setState(226);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(220);
					((ArithmeticContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__26 || _la==T__27) ) {
						((ArithmeticContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(221);
					((ArithmeticContext)_localctx).term = term();
					 ((ArithmeticContext)_localctx).result =  factory.createBinary(((ArithmeticContext)_localctx).op, _localctx.result, ((ArithmeticContext)_localctx).term.result); 
					}
					} 
				}
				setState(228);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class TermContext extends ParserRuleContext {
		public SLExpressionNode result;
		public FactorContext factor;
		public Token op;
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_term);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			((TermContext)_localctx).factor = factor();
			 ((TermContext)_localctx).result =  ((TermContext)_localctx).factor.result; 
			setState(237);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(231);
					((TermContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__28 || _la==T__29) ) {
						((TermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(232);
					((TermContext)_localctx).factor = factor();
					 ((TermContext)_localctx).result =  factory.createBinary(((TermContext)_localctx).op, _localctx.result, ((TermContext)_localctx).factor.result); 
					}
					} 
				}
				setState(239);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class FactorContext extends ParserRuleContext {
		public SLExpressionNode result;
		public Token IDENTIFIER;
		public Member_expressionContext member_expression;
		public ExpressionContext index;
		public Token STRING_LITERAL;
		public Token NUMERIC_LITERAL;
		public Token s;
		public ExpressionContext expr;
		public Token e;
		public TerminalNode IDENTIFIER() { return getToken(SimpleLanguageParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SimpleLanguageParser.STRING_LITERAL, 0); }
		public TerminalNode NUMERIC_LITERAL() { return getToken(SimpleLanguageParser.NUMERIC_LITERAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Member_expressionContext member_expression() {
			return getRuleContext(Member_expressionContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(240);
				((FactorContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 SLExpressionNode assignmentName = factory.createStringLiteral(((FactorContext)_localctx).IDENTIFIER, false); 
				setState(255);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(242);
					((FactorContext)_localctx).member_expression = member_expression(null, null, assignmentName, null);
					 ((FactorContext)_localctx).result =  ((FactorContext)_localctx).member_expression.result; 
					}
					break;
				case 2:
					{
					setState(245);
					match(T__4);
					setState(246);
					((FactorContext)_localctx).index = expression();
					setState(247);
					match(T__5);
					setState(252);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						setState(248);
						((FactorContext)_localctx).member_expression = member_expression(null, null, assignmentName, ((FactorContext)_localctx).index.result);
						 ((FactorContext)_localctx).result =  ((FactorContext)_localctx).member_expression.result; 
						}
						break;
					case 2:
						{
						 ((FactorContext)_localctx).result = (SLExpressionNode) factory.createArrayRead(assignmentName, ((FactorContext)_localctx).index.result);
						}
						break;
					}
					}
					break;
				case 3:
					{
					 ((FactorContext)_localctx).result =  factory.createRead(assignmentName); 
					}
					break;
				}
				}
				break;
			case STRING_LITERAL:
				{
				setState(257);
				((FactorContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);
				 ((FactorContext)_localctx).result =  factory.createStringLiteral(((FactorContext)_localctx).STRING_LITERAL, true); 
				}
				break;
			case NUMERIC_LITERAL:
				{
				setState(259);
				((FactorContext)_localctx).NUMERIC_LITERAL = match(NUMERIC_LITERAL);
				 ((FactorContext)_localctx).result =  factory.createNumericLiteral(((FactorContext)_localctx).NUMERIC_LITERAL); 
				}
				break;
			case T__1:
				{
				setState(261);
				((FactorContext)_localctx).s = match(T__1);
				setState(262);
				((FactorContext)_localctx).expr = expression();
				setState(263);
				((FactorContext)_localctx).e = match(T__3);
				 ((FactorContext)_localctx).result =  factory.createParenExpression(((FactorContext)_localctx).expr.result, ((FactorContext)_localctx).s.getStartIndex(), ((FactorContext)_localctx).e.getStopIndex() - ((FactorContext)_localctx).s.getStartIndex() + 1); 
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Member_expressionContext extends ParserRuleContext {
		public SLExpressionNode r;
		public SLExpressionNode assignmentReceiver;
		public SLExpressionNode assignmentName;
		public SLExpressionNode index;
		public SLExpressionNode result;
		public ExpressionContext expression;
		public Token e;
		public Token IDENTIFIER;
		public Array_initContext array_init;
		public Member_expressionContext member_expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IDENTIFIER() { return getToken(SimpleLanguageParser.IDENTIFIER, 0); }
		public Array_initContext array_init() {
			return getRuleContext(Array_initContext.class,0);
		}
		public Member_expressionContext member_expression() {
			return getRuleContext(Member_expressionContext.class,0);
		}
		public Member_expressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Member_expressionContext(ParserRuleContext parent, int invokingState, SLExpressionNode r, SLExpressionNode assignmentReceiver, SLExpressionNode assignmentName, SLExpressionNode index) {
			super(parent, invokingState);
			this.r = r;
			this.assignmentReceiver = assignmentReceiver;
			this.assignmentName = assignmentName;
			this.index = index;
		}
		@Override public int getRuleIndex() { return RULE_member_expression; }
	}

	public final Member_expressionContext member_expression(SLExpressionNode r,SLExpressionNode assignmentReceiver,SLExpressionNode assignmentName,SLExpressionNode index) throws RecognitionException {
		Member_expressionContext _localctx = new Member_expressionContext(_ctx, getState(), r, assignmentReceiver, assignmentName, index);
		enterRule(_localctx, 32, RULE_member_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 SLExpressionNode receiver = r;
			                                                  SLExpressionNode nestedAssignmentName = null;
			                                                  
			setState(304);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(269);
				match(T__1);
				 List<SLExpressionNode> parameters = new ArrayList<>();
				                                                  if (receiver == null) {
				                                                      receiver = factory.createRead(assignmentName);
				                                                  } 
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << IDENTIFIER) | (1L << STRING_LITERAL) | (1L << NUMERIC_LITERAL))) != 0)) {
					{
					setState(271);
					((Member_expressionContext)_localctx).expression = expression();
					 parameters.add(((Member_expressionContext)_localctx).expression.result); 
					setState(279);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(273);
						match(T__2);
						setState(274);
						((Member_expressionContext)_localctx).expression = expression();
						 parameters.add(((Member_expressionContext)_localctx).expression.result); 
						}
						}
						setState(281);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(284);
				((Member_expressionContext)_localctx).e = match(T__3);
				 ((Member_expressionContext)_localctx).result =  factory.createCall(receiver, parameters, ((Member_expressionContext)_localctx).e); 
				}
				break;
			case 2:
				{
				setState(286);
				match(T__12);
				setState(287);
				((Member_expressionContext)_localctx).expression = expression();
				 if (assignmentName == null) {
				                                                      SemErr((((Member_expressionContext)_localctx).expression!=null?(((Member_expressionContext)_localctx).expression.start):null), "invalid assignment target");
				                                                  } else if (assignmentReceiver == null) {
				                                                      ((Member_expressionContext)_localctx).result =  (index != null) ? (SLExpressionNode) factory.createArrayWrite(assignmentName, index, ((Member_expressionContext)_localctx).expression.result) : factory.createAssignment(assignmentName, ((Member_expressionContext)_localctx).expression.result);
				                                                  } else {
				                                                      ((Member_expressionContext)_localctx).result =  factory.createWriteProperty(assignmentReceiver, assignmentName, ((Member_expressionContext)_localctx).expression.result);
				                                                  } 
				}
				break;
			case 3:
				{
				setState(290);
				match(T__30);
				 if (receiver == null) {
				                                                       receiver = factory.createRead(assignmentName);
				                                                  } 
				setState(292);
				((Member_expressionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 nestedAssignmentName = factory.createStringLiteral(((Member_expressionContext)_localctx).IDENTIFIER, false);
				                                                  ((Member_expressionContext)_localctx).result =  factory.createReadProperty(receiver, nestedAssignmentName); 
				}
				break;
			case 4:
				{
				setState(294);
				match(T__31);
				 if (receiver == null) {
				                                                      receiver = factory.createRead(assignmentName);
				                                                  } 
				setState(296);
				((Member_expressionContext)_localctx).expression = expression();
				 nestedAssignmentName = ((Member_expressionContext)_localctx).expression.result;
				                                                  ((Member_expressionContext)_localctx).result =  factory.createReadProperty(receiver, nestedAssignmentName); 
				setState(298);
				match(T__32);
				}
				break;
			case 5:
				{
				setState(300);
				match(T__12);
				setState(301);
				((Member_expressionContext)_localctx).array_init = array_init();
				 SLStatementNode arrayInit = ((Member_expressionContext)_localctx).array_init.result;
				                                                  ((Member_expressionContext)_localctx).result =  factory.createAssignment(assignmentName, (SLExpressionNode) arrayInit);
				                                                
				}
				break;
			}
			setState(309);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(306);
				((Member_expressionContext)_localctx).member_expression = member_expression(_localctx.result, receiver, nestedAssignmentName, index);
				 ((Member_expressionContext)_localctx).result =  ((Member_expressionContext)_localctx).member_expression.result; 
				}
				break;
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u013a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\7\3\67\n\3\f\3\16\3:\13\3\5\3<\n\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\7\4G\n\4\f\4\16\4J\13\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5k\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6u\n\6\f"+
		"\6\16\6x\13\6\5\6z\n\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0085\n"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u008d\n\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00b1\n\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\5\13\u00ba\n\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\7"+
		"\f\u00c5\n\f\f\f\16\f\u00c8\13\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00d0\n\r"+
		"\f\r\16\r\u00d3\13\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00db\n\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\7\17\u00e3\n\17\f\17\16\17\u00e6\13\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\7\20\u00ee\n\20\f\20\16\20\u00f1\13\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00ff\n\21"+
		"\3\21\5\21\u0102\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u010d\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0118\n"+
		"\22\f\22\16\22\u011b\13\22\5\22\u011d\n\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\5\22\u0133\n\22\3\22\3\22\3\22\5\22\u0138\n\22\3\22\2\2\23\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"\2\5\3\2\27\34\3\2\35\36\3\2\37 \2\u014c"+
		"\2$\3\2\2\2\4-\3\2\2\2\6A\3\2\2\2\bj\3\2\2\2\nl\3\2\2\2\f~\3\2\2\2\16"+
		"\u0092\3\2\2\2\20\u009f\3\2\2\2\22\u00a6\3\2\2\2\24\u00b4\3\2\2\2\26\u00be"+
		"\3\2\2\2\30\u00c9\3\2\2\2\32\u00d4\3\2\2\2\34\u00dc\3\2\2\2\36\u00e7\3"+
		"\2\2\2 \u010c\3\2\2\2\"\u010e\3\2\2\2$(\5\4\3\2%\'\5\4\3\2&%\3\2\2\2\'"+
		"*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+,\7\2\2\3,\3\3\2\2\2"+
		"-.\7\3\2\2./\7\'\2\2/\60\7\4\2\2\60;\b\3\1\2\61\62\7\'\2\2\628\b\3\1\2"+
		"\63\64\7\5\2\2\64\65\7\'\2\2\65\67\b\3\1\2\66\63\3\2\2\2\67:\3\2\2\28"+
		"\66\3\2\2\289\3\2\2\29<\3\2\2\2:8\3\2\2\2;\61\3\2\2\2;<\3\2\2\2<=\3\2"+
		"\2\2=>\7\6\2\2>?\5\6\4\2?@\b\3\1\2@\5\3\2\2\2AB\b\4\1\2BH\7\7\2\2CD\5"+
		"\b\5\2DE\b\4\1\2EG\3\2\2\2FC\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3"+
		"\2\2\2JH\3\2\2\2KL\7\b\2\2LM\b\4\1\2M\7\3\2\2\2NO\5\20\t\2OP\b\5\1\2P"+
		"k\3\2\2\2QR\5\f\7\2RS\b\5\1\2Sk\3\2\2\2TU\5\16\b\2UV\b\5\1\2Vk\3\2\2\2"+
		"WX\7\t\2\2XY\b\5\1\2Yk\7\n\2\2Z[\7\13\2\2[\\\b\5\1\2\\k\7\n\2\2]^\5\22"+
		"\n\2^_\b\5\1\2_k\3\2\2\2`a\5\24\13\2ab\b\5\1\2bk\3\2\2\2cd\5\26\f\2de"+
		"\7\n\2\2ef\b\5\1\2fk\3\2\2\2gh\7\f\2\2hi\b\5\1\2ik\7\n\2\2jN\3\2\2\2j"+
		"Q\3\2\2\2jT\3\2\2\2jW\3\2\2\2jZ\3\2\2\2j]\3\2\2\2j`\3\2\2\2jc\3\2\2\2"+
		"jg\3\2\2\2k\t\3\2\2\2lm\7\7\2\2my\b\6\1\2no\5\26\f\2ov\b\6\1\2pq\7\5\2"+
		"\2qr\5\26\f\2rs\b\6\1\2su\3\2\2\2tp\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2"+
		"\2\2wz\3\2\2\2xv\3\2\2\2yn\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\7\b\2\2|}\b\6"+
		"\1\2}\13\3\2\2\2~\177\7\r\2\2\177\u0080\b\7\1\2\u0080\u0084\7\4\2\2\u0081"+
		"\u0082\5\26\f\2\u0082\u0083\b\7\1\2\u0083\u0085\3\2\2\2\u0084\u0081\3"+
		"\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\7\n\2\2\u0087"+
		"\u0088\5\26\f\2\u0088\u008c\7\n\2\2\u0089\u008a\5\26\f\2\u008a\u008b\b"+
		"\7\1\2\u008b\u008d\3\2\2\2\u008c\u0089\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u008f\7\6\2\2\u008f\u0090\5\6\4\2\u0090\u0091\b\7"+
		"\1\2\u0091\r\3\2\2\2\u0092\u0093\7\16\2\2\u0093\u0094\7\4\2\2\u0094\u0095"+
		"\7\'\2\2\u0095\u0096\b\b\1\2\u0096\u0097\7\17\2\2\u0097\u0098\5\34\17"+
		"\2\u0098\u0099\b\b\1\2\u0099\u009a\7\20\2\2\u009a\u009b\5\34\17\2\u009b"+
		"\u009c\7\6\2\2\u009c\u009d\5\6\4\2\u009d\u009e\b\b\1\2\u009e\17\3\2\2"+
		"\2\u009f\u00a0\7\21\2\2\u00a0\u00a1\7\4\2\2\u00a1\u00a2\5\26\f\2\u00a2"+
		"\u00a3\7\6\2\2\u00a3\u00a4\5\6\4\2\u00a4\u00a5\b\t\1\2\u00a5\21\3\2\2"+
		"\2\u00a6\u00a7\7\22\2\2\u00a7\u00a8\7\4\2\2\u00a8\u00a9\5\26\f\2\u00a9"+
		"\u00aa\7\6\2\2\u00aa\u00ab\5\6\4\2\u00ab\u00b0\b\n\1\2\u00ac\u00ad\7\23"+
		"\2\2\u00ad\u00ae\5\6\4\2\u00ae\u00af\b\n\1\2\u00af\u00b1\3\2\2\2\u00b0"+
		"\u00ac\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\b\n"+
		"\1\2\u00b3\23\3\2\2\2\u00b4\u00b5\7\24\2\2\u00b5\u00b9\b\13\1\2\u00b6"+
		"\u00b7\5\26\f\2\u00b7\u00b8\b\13\1\2\u00b8\u00ba\3\2\2\2\u00b9\u00b6\3"+
		"\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\b\13\1\2\u00bc"+
		"\u00bd\7\n\2\2\u00bd\25\3\2\2\2\u00be\u00bf\5\30\r\2\u00bf\u00c6\b\f\1"+
		"\2\u00c0\u00c1\7\25\2\2\u00c1\u00c2\5\30\r\2\u00c2\u00c3\b\f\1\2\u00c3"+
		"\u00c5\3\2\2\2\u00c4\u00c0\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2"+
		"\2\2\u00c6\u00c7\3\2\2\2\u00c7\27\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00ca"+
		"\5\32\16\2\u00ca\u00d1\b\r\1\2\u00cb\u00cc\7\26\2\2\u00cc\u00cd\5\32\16"+
		"\2\u00cd\u00ce\b\r\1\2\u00ce\u00d0\3\2\2\2\u00cf\u00cb\3\2\2\2\u00d0\u00d3"+
		"\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\31\3\2\2\2\u00d3"+
		"\u00d1\3\2\2\2\u00d4\u00d5\5\34\17\2\u00d5\u00da\b\16\1\2\u00d6\u00d7"+
		"\t\2\2\2\u00d7\u00d8\5\34\17\2\u00d8\u00d9\b\16\1\2\u00d9\u00db\3\2\2"+
		"\2\u00da\u00d6\3\2\2\2\u00da\u00db\3\2\2\2\u00db\33\3\2\2\2\u00dc\u00dd"+
		"\5\36\20\2\u00dd\u00e4\b\17\1\2\u00de\u00df\t\3\2\2\u00df\u00e0\5\36\20"+
		"\2\u00e0\u00e1\b\17\1\2\u00e1\u00e3\3\2\2\2\u00e2\u00de\3\2\2\2\u00e3"+
		"\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\35\3\2\2"+
		"\2\u00e6\u00e4\3\2\2\2\u00e7\u00e8\5 \21\2\u00e8\u00ef\b\20\1\2\u00e9"+
		"\u00ea\t\4\2\2\u00ea\u00eb\5 \21\2\u00eb\u00ec\b\20\1\2\u00ec\u00ee\3"+
		"\2\2\2\u00ed\u00e9\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef"+
		"\u00f0\3\2\2\2\u00f0\37\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2\u00f3\7\'\2"+
		"\2\u00f3\u0101\b\21\1\2\u00f4\u00f5\5\"\22\2\u00f5\u00f6\b\21\1\2\u00f6"+
		"\u0102\3\2\2\2\u00f7\u00f8\7\7\2\2\u00f8\u00f9\5\26\f\2\u00f9\u00fe\7"+
		"\b\2\2\u00fa\u00fb\5\"\22\2\u00fb\u00fc\b\21\1\2\u00fc\u00ff\3\2\2\2\u00fd"+
		"\u00ff\b\21\1\2\u00fe\u00fa\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff\u0102\3"+
		"\2\2\2\u0100\u0102\b\21\1\2\u0101\u00f4\3\2\2\2\u0101\u00f7\3\2\2\2\u0101"+
		"\u0100\3\2\2\2\u0102\u010d\3\2\2\2\u0103\u0104\7(\2\2\u0104\u010d\b\21"+
		"\1\2\u0105\u0106\7)\2\2\u0106\u010d\b\21\1\2\u0107\u0108\7\4\2\2\u0108"+
		"\u0109\5\26\f\2\u0109\u010a\7\6\2\2\u010a\u010b\b\21\1\2\u010b\u010d\3"+
		"\2\2\2\u010c\u00f2\3\2\2\2\u010c\u0103\3\2\2\2\u010c\u0105\3\2\2\2\u010c"+
		"\u0107\3\2\2\2\u010d!\3\2\2\2\u010e\u0132\b\22\1\2\u010f\u0110\7\4\2\2"+
		"\u0110\u011c\b\22\1\2\u0111\u0112\5\26\f\2\u0112\u0119\b\22\1\2\u0113"+
		"\u0114\7\5\2\2\u0114\u0115\5\26\f\2\u0115\u0116\b\22\1\2\u0116\u0118\3"+
		"\2\2\2\u0117\u0113\3\2\2\2\u0118\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119"+
		"\u011a\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011c\u0111\3\2"+
		"\2\2\u011c\u011d\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\7\6\2\2\u011f"+
		"\u0133\b\22\1\2\u0120\u0121\7\17\2\2\u0121\u0122\5\26\f\2\u0122\u0123"+
		"\b\22\1\2\u0123\u0133\3\2\2\2\u0124\u0125\7!\2\2\u0125\u0126\b\22\1\2"+
		"\u0126\u0127\7\'\2\2\u0127\u0133\b\22\1\2\u0128\u0129\7\"\2\2\u0129\u012a"+
		"\b\22\1\2\u012a\u012b\5\26\f\2\u012b\u012c\b\22\1\2\u012c\u012d\7#\2\2"+
		"\u012d\u0133\3\2\2\2\u012e\u012f\7\17\2\2\u012f\u0130\5\n\6\2\u0130\u0131"+
		"\b\22\1\2\u0131\u0133\3\2\2\2\u0132\u010f\3\2\2\2\u0132\u0120\3\2\2\2"+
		"\u0132\u0124\3\2\2\2\u0132\u0128\3\2\2\2\u0132\u012e\3\2\2\2\u0133\u0137"+
		"\3\2\2\2\u0134\u0135\5\"\22\2\u0135\u0136\b\22\1\2\u0136\u0138\3\2\2\2"+
		"\u0137\u0134\3\2\2\2\u0137\u0138\3\2\2\2\u0138#\3\2\2\2\31(8;Hjvy\u0084"+
		"\u008c\u00b0\u00b9\u00c6\u00d1\u00da\u00e4\u00ef\u00fe\u0101\u010c\u0119"+
		"\u011c\u0132\u0137";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}