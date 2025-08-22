// Generated from C:/Users/tiago/ISEP/semestre4-pi/sem4pi-23-24-2da1/jobs4u.backoffice/src/main/java/interview/InterviewTemplate.g4 by ANTLR 4.13.1
package interview;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InterviewTemplateParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InterviewTemplateVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InterviewTemplateParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(InterviewTemplateParser.StartContext ctx);
}