// Generated from C:/Users/tiago/ISEP/semestre4-pi/sem4pi-23-24-2da1/jobs4u.backoffice/src/main/java/interview/InterviewTemplate.g4 by ANTLR 4.13.1
package interview;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link InterviewTemplateVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
@SuppressWarnings("CheckReturnValue")
public class InterviewTemplateBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements InterviewTemplateVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitStart(InterviewTemplateParser.StartContext ctx) { return visitChildren(ctx); }
}