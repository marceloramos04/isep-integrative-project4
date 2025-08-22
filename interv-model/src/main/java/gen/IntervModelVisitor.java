// Generated from C:/Users/mcram/OneDrive - Instituto Superior de Engenharia do Porto/sem4pi-23-24-2da1/interv-model/src/main/java/IntervModel.g4 by ANTLR 4.13.1
package gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link IntervModelParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface IntervModelVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link IntervModelParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(IntervModelParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link IntervModelParser#entry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntry(IntervModelParser.EntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link IntervModelParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(IntervModelParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link IntervModelParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(IntervModelParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IntervModelParser#questionDescrip}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionDescrip(IntervModelParser.QuestionDescripContext ctx);
	/**
	 * Visit a parse tree produced by {@link IntervModelParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(IntervModelParser.OptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IntervModelParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(IntervModelParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link IntervModelParser#answer_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer_value(IntervModelParser.Answer_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link IntervModelParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(IntervModelParser.SentenceContext ctx);
}