// Generated from C:/Users/tiago/ISEP/semestre4-pi/sem4pi-23-24-2da1/jobs4u.backoffice/src/main/java/requirements/Requirements.g4 by ANTLR 4.13.1
package requirements;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RequirementsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RequirementsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RequirementsParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(RequirementsParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(RequirementsParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsParser#requirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequirement(RequirementsParser.RequirementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsParser#int_answer_requirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_answer_requirement(RequirementsParser.Int_answer_requirementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsParser#double_answer_requirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDouble_answer_requirement(RequirementsParser.Double_answer_requirementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsParser#single_option_requirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_option_requirement(RequirementsParser.Single_option_requirementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsParser#multiple_options_requirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_options_requirement(RequirementsParser.Multiple_options_requirementContext ctx);
}