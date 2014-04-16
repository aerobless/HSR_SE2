package calculator.syntax;

import calculator.EvaluationException;

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

	@Override
	public int accept(ExpressionVisitor aV) throws EvaluationException {
		return 0;
	}
}
