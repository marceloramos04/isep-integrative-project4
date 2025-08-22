// Generated from C:/Users/tiago/ISEP/semestre4-pi/sem4pi-23-24-2da1/jobs4u.backoffice/src/main/java/requirements/Requirements.g4 by ANTLR 4.13.1
package requirements;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RequirementsParser}.
 */
public interface RequirementsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RequirementsParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(RequirementsParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(RequirementsParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(RequirementsParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(RequirementsParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsParser#requirement}.
	 * @param ctx the parse tree
	 */
	void enterRequirement(RequirementsParser.RequirementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsParser#requirement}.
	 * @param ctx the parse tree
	 */
	void exitRequirement(RequirementsParser.RequirementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsParser#int_answer_requirement}.
	 * @param ctx the parse tree
	 */
	void enterInt_answer_requirement(RequirementsParser.Int_answer_requirementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsParser#int_answer_requirement}.
	 * @param ctx the parse tree
	 */
	void exitInt_answer_requirement(RequirementsParser.Int_answer_requirementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsParser#double_answer_requirement}.
	 * @param ctx the parse tree
	 */
	void enterDouble_answer_requirement(RequirementsParser.Double_answer_requirementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsParser#double_answer_requirement}.
	 * @param ctx the parse tree
	 */
	void exitDouble_answer_requirement(RequirementsParser.Double_answer_requirementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsParser#single_option_requirement}.
	 * @param ctx the parse tree
	 */
	void enterSingle_option_requirement(RequirementsParser.Single_option_requirementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsParser#single_option_requirement}.
	 * @param ctx the parse tree
	 */
	void exitSingle_option_requirement(RequirementsParser.Single_option_requirementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsParser#multiple_options_requirement}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_options_requirement(RequirementsParser.Multiple_options_requirementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsParser#multiple_options_requirement}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_options_requirement(RequirementsParser.Multiple_options_requirementContext ctx);
}