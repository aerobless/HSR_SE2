package calculator.syntax;

import calculator.EvaluationException;

public class DumpVisitor implements ExpressionVisitor{

	@Override
	public int visit(BinaryExpression aBinaryExpression) throws EvaluationException {
		System.out.print(aBinaryExpression.getLeft().accept(this)+","+aBinaryExpression.getOperator()+","+aBinaryExpression.getRight().accept(this));
		return 0;
	}

	@Override
	public int visit(Designator aDesignator) throws EvaluationException {
		System.out.print("des ");
		return 0;
	}

	@Override
	public int visit(Number aNumber) {
		System.out.print("num ");
		return 0;
	}

	@Override
	public int visit(UnaryExpression aUnaryExpression)
			throws EvaluationException {
		System.out.print("unex ");
		return 0;
	}	
}
