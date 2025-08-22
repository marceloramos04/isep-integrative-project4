// Generated from C:/Users/rafa1/Documents/untitled/src/main/antlr/US2003.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link US2003Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface US2003Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link US2003Parser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(US2003Parser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2003Parser#candidate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCandidate(US2003Parser.CandidateContext ctx);
}