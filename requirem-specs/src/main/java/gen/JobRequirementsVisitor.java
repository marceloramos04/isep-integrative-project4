// Generated from C:/Users/mcram/OneDrive - Instituto Superior de Engenharia do Porto/sem4pi-23-24-2da1/job-requirem-evaluat/src/main/java/grammars/JobRequirements.g4 by ANTLR 4.13.1
package gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JobRequirementsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JobRequirementsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JobRequirementsParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(JobRequirementsParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(JobRequirementsParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsParser#requirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequirement(JobRequirementsParser.RequirementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(JobRequirementsParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsParser#textAnswers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextAnswers(JobRequirementsParser.TextAnswersContext ctx);
}