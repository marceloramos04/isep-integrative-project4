// Generated from C:/Users/rafa1/Documents/untitled/src/main/antlr/US2003.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link US2003Parser}.
 */
public interface US2003Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link US2003Parser#job_opening_description}.
	 * @param ctx the parse tree
	 */
	void enterJob_opening_description(US2003Parser.Job_opening_descriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link US2003Parser#job_opening_description}.
	 * @param ctx the parse tree
	 */
	void exitJob_opening_description(US2003Parser.Job_opening_descriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link US2003Parser#job_requirements_description}.
	 * @param ctx the parse tree
	 */
	void enterJob_requirements_description(US2003Parser.Job_requirements_descriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link US2003Parser#job_requirements_description}.
	 * @param ctx the parse tree
	 */
	void exitJob_requirements_description(US2003Parser.Job_requirements_descriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link US2003Parser#job_requirement_list}.
	 * @param ctx the parse tree
	 */
	void enterJob_requirement_list(US2003Parser.Job_requirement_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link US2003Parser#job_requirement_list}.
	 * @param ctx the parse tree
	 */
	void exitJob_requirement_list(US2003Parser.Job_requirement_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link US2003Parser#job_requirement}.
	 * @param ctx the parse tree
	 */
	void enterJob_requirement(US2003Parser.Job_requirementContext ctx);
	/**
	 * Exit a parse tree produced by {@link US2003Parser#job_requirement}.
	 * @param ctx the parse tree
	 */
	void exitJob_requirement(US2003Parser.Job_requirementContext ctx);
	/**
	 * Enter a parse tree produced by {@link US2003Parser#candidate_fields_description}.
	 * @param ctx the parse tree
	 */
	void enterCandidate_fields_description(US2003Parser.Candidate_fields_descriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link US2003Parser#candidate_fields_description}.
	 * @param ctx the parse tree
	 */
	void exitCandidate_fields_description(US2003Parser.Candidate_fields_descriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link US2003Parser#candidate_field_list}.
	 * @param ctx the parse tree
	 */
	void enterCandidate_field_list(US2003Parser.Candidate_field_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link US2003Parser#candidate_field_list}.
	 * @param ctx the parse tree
	 */
	void exitCandidate_field_list(US2003Parser.Candidate_field_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link US2003Parser#candidate_field}.
	 * @param ctx the parse tree
	 */
	void enterCandidate_field(US2003Parser.Candidate_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link US2003Parser#candidate_field}.
	 * @param ctx the parse tree
	 */
	void exitCandidate_field(US2003Parser.Candidate_fieldContext ctx);
}