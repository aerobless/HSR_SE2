package calculator.syntax;

import calculator.EvaluationException;

public interface ExpressionVisitor {
	public int visit(BinaryExpression aBinaryExpression) throws EvaluationException;
	public int visit(Designator aDesignator) throws EvaluationException;
	public int visit(Number aNumber);
	public int visit(UnaryExpression aUnaryExpression) throws EvaluationException;
	public int visit(Assignment aAssignment) throws EvaluationException;
}
