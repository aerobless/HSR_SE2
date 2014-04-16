package calculator.syntax;

import calculator.EvaluationException;
import calculator.VariableContext;

public class Assignment implements SyntaxNode {
	private Designator designator;
	private Expression expression;
	
	public Assignment(Designator designator, Expression expression) {
		this.designator = designator;
		this.expression = expression;
	}
	
	public Designator getDesignator() {
		return designator;
	}
	
	public Expression getExpression() {
		return expression;
	}

	/* (non-Javadoc)
	 * @see calculator.syntax.SyntaxNode#accept(calculator.VariableContext, calculator.syntax.ExpressionVisitor)
	 */
	@Override
	public int accept(VariableContext aMemory, ExpressionVisitor aV)
			throws EvaluationException {
		// TODO Auto-generated method stub
		return 0;
	}
}
