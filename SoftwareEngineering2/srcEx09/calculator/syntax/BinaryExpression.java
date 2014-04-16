package calculator.syntax;

import calculator.EvaluationException;

public class BinaryExpression implements Expression {
	Expression left;
	private Operator operator;
	Expression right;
	
	public BinaryExpression(Expression left, Operator operator, Expression right) {
		this.left = left;
		this.operator = operator;
		this.right = right;
	}
	
	public Expression getLeft() {
		return left;
	}
	
	public Operator getOperator() {
		return operator;
	}

	public Expression getRight() {
		return right;
	}

	@Override
	public int accept(ExpressionVisitor v) throws EvaluationException {
		return v.visit(this);
	}
}
