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
	 * Visit a parse tree produced by {@link US2003Parser#job_opening_description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJob_opening_description(US2003Parser.Job_opening_descriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2003Parser#job_requirements_description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJob_requirements_description(US2003Parser.Job_requirements_descriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2003Parser#job_requirement_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJob_requirement_list(US2003Parser.Job_requirement_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2003Parser#job_requirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJob_requirement(US2003Parser.Job_requirementContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2003Parser#candidate_fields_description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCandidate_fields_description(US2003Parser.Candidate_fields_descriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2003Parser#candidate_field_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCandidate_field_list(US2003Parser.Candidate_field_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2003Parser#candidate_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCandidate_field(US2003Parser.Candidate_fieldContext ctx);
}