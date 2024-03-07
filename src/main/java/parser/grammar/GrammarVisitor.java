// Generated from java-escape by ANTLR 4.11.1
package parser.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(GrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#grammarName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrammarName(GrammarParser.GrammarNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(GrammarParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(GrammarParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#ruleList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleList(GrammarParser.RuleListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#ruleObj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleObj(GrammarParser.RuleObjContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#branchList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchList(GrammarParser.BranchListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#branch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranch(GrammarParser.BranchContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#calcResult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalcResult(GrammarParser.CalcResultContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#elementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementList(GrammarParser.ElementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#tokenList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTokenList(GrammarParser.TokenListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToken(GrammarParser.TokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#tokenTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTokenTail(GrammarParser.TokenTailContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#additionalCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionalCode(GrammarParser.AdditionalCodeContext ctx);
}
