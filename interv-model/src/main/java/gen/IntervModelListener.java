// Generated from C:/Users/mcram/OneDrive - Instituto Superior de Engenharia do Porto/sem4pi-23-24-2da1/interv-model/src/main/java/IntervModel.g4 by ANTLR 4.13.1
package gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IntervModelParser}.
 */
public interface IntervModelListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IntervModelParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(IntervModelParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link IntervModelParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(IntervModelParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link IntervModelParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterEntry(IntervModelParser.EntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link IntervModelParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitEntry(IntervModelParser.EntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link IntervModelParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(IntervModelParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link IntervModelParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(IntervModelParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link IntervModelParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(IntervModelParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IntervModelParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(IntervModelParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IntervModelParser#questionDescrip}.
	 * @param ctx the parse tree
	 */
	void enterQuestionDescrip(IntervModelParser.QuestionDescripContext ctx);
	/**
	 * Exit a parse tree produced by {@link IntervModelParser#questionDescrip}.
	 * @param ctx the parse tree
	 */
	void exitQuestionDescrip(IntervModelParser.QuestionDescripContext ctx);
	/**
	 * Enter a parse tree produced by {@link IntervModelParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(IntervModelParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IntervModelParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(IntervModelParser.OptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IntervModelParser#answer}.
	 * @param ctx the parse tree
	 */
	void enterAnswer(IntervModelParser.AnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link IntervModelParser#answer}.
	 * @param ctx the parse tree
	 */
	void exitAnswer(IntervModelParser.AnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link IntervModelParser#answer_value}.
	 * @param ctx the parse tree
	 */
	void enterAnswer_value(IntervModelParser.Answer_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link IntervModelParser#answer_value}.
	 * @param ctx the parse tree
	 */
	void exitAnswer_value(IntervModelParser.Answer_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link IntervModelParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(IntervModelParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link IntervModelParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(IntervModelParser.SentenceContext ctx);
}