// Generated from C:/Users/rafa1/Documents/untitled/src/main/antlr/US2003.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link US2003Parser}.
 */
public interface US2003Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link US2003Parser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(US2003Parser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link US2003Parser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(US2003Parser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link US2003Parser#candidate}.
	 * @param ctx the parse tree
	 */
	void enterCandidate(US2003Parser.CandidateContext ctx);
	/**
	 * Exit a parse tree produced by {@link US2003Parser#candidate}.
	 * @param ctx the parse tree
	 */
	void exitCandidate(US2003Parser.CandidateContext ctx);
}