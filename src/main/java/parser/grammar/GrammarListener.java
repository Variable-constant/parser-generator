// Generated from java-escape by ANTLR 4.11.1
package parser.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(GrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(GrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#grammarName}.
	 * @param ctx the parse tree
	 */
	void enterGrammarName(GrammarParser.GrammarNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#grammarName}.
	 * @param ctx the parse tree
	 */
	void exitGrammarName(GrammarParser.GrammarNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(GrammarParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(GrammarParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(GrammarParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(GrammarParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#ruleList}.
	 * @param ctx the parse tree
	 */
	void enterRuleList(GrammarParser.RuleListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#ruleList}.
	 * @param ctx the parse tree
	 */
	void exitRuleList(GrammarParser.RuleListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#ruleObj}.
	 * @param ctx the parse tree
	 */
	void enterRuleObj(GrammarParser.RuleObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#ruleObj}.
	 * @param ctx the parse tree
	 */
	void exitRuleObj(GrammarParser.RuleObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#branchList}.
	 * @param ctx the parse tree
	 */
	void enterBranchList(GrammarParser.BranchListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#branchList}.
	 * @param ctx the parse tree
	 */
	void exitBranchList(GrammarParser.BranchListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#branch}.
	 * @param ctx the parse tree
	 */
	void enterBranch(GrammarParser.BranchContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#branch}.
	 * @param ctx the parse tree
	 */
	void exitBranch(GrammarParser.BranchContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#calcResult}.
	 * @param ctx the parse tree
	 */
	void enterCalcResult(GrammarParser.CalcResultContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#calcResult}.
	 * @param ctx the parse tree
	 */
	void exitCalcResult(GrammarParser.CalcResultContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#elementList}.
	 * @param ctx the parse tree
	 */
	void enterElementList(GrammarParser.ElementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#elementList}.
	 * @param ctx the parse tree
	 */
	void exitElementList(GrammarParser.ElementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#tokenList}.
	 * @param ctx the parse tree
	 */
	void enterTokenList(GrammarParser.TokenListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#tokenList}.
	 * @param ctx the parse tree
	 */
	void exitTokenList(GrammarParser.TokenListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#token}.
	 * @param ctx the parse tree
	 */
	void enterToken(GrammarParser.TokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#token}.
	 * @param ctx the parse tree
	 */
	void exitToken(GrammarParser.TokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#tokenTail}.
	 * @param ctx the parse tree
	 */
	void enterTokenTail(GrammarParser.TokenTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#tokenTail}.
	 * @param ctx the parse tree
	 */
	void exitTokenTail(GrammarParser.TokenTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#additionalCode}.
	 * @param ctx the parse tree
	 */
	void enterAdditionalCode(GrammarParser.AdditionalCodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#additionalCode}.
	 * @param ctx the parse tree
	 */
	void exitAdditionalCode(GrammarParser.AdditionalCodeContext ctx);
}
