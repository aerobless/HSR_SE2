package calculator.syntax;

import calculator.EvaluationException;

public class UnaryExpression implements Expression {
	Operator operator;
	Expression subExpression;
	
	public UnaryExpression(Operator operator, Expression subExpression) {
		this.operator = operator;
		this.subExpression = subExpression;
	}
	
	public Operator getOperator() {
		return operator;
	}
	
	public Expression getSubExpression() {
		return subExpression;
	}

	@Override
	public int accept(ExpressionVisitor v) throws EvaluationException {
		return v.visit(this);
	}
}
