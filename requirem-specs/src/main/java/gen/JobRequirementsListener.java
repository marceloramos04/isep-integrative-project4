// Generated from C:/Users/mcram/OneDrive - Instituto Superior de Engenharia do Porto/sem4pi-23-24-2da1/job-requirem-evaluat/src/main/java/grammars/JobRequirements.g4 by ANTLR 4.13.1
package gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JobRequirementsParser}.
 */
public interface JobRequirementsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JobRequirementsParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(JobRequirementsParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(JobRequirementsParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link JobRequirementsParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(JobRequirementsParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(JobRequirementsParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JobRequirementsParser#requirement}.
	 * @param ctx the parse tree
	 */
	void enterRequirement(JobRequirementsParser.RequirementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsParser#requirement}.
	 * @param ctx the parse tree
	 */
	void exitRequirement(JobRequirementsParser.RequirementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JobRequirementsParser#answer}.
	 * @param ctx the parse tree
	 */
	void enterAnswer(JobRequirementsParser.AnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsParser#answer}.
	 * @param ctx the parse tree
	 */
	void exitAnswer(JobRequirementsParser.AnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JobRequirementsParser#textAnswers}.
	 * @param ctx the parse tree
	 */
	void enterTextAnswers(JobRequirementsParser.TextAnswersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsParser#textAnswers}.
	 * @param ctx the parse tree
	 */
	void exitTextAnswers(JobRequirementsParser.TextAnswersContext ctx);
}