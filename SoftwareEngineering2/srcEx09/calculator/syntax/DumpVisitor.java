package calculator.syntax;

import calculator.EvaluationException;

public class DumpVisitor implements ExpressionVisitor{

	@Override
	public int visit(BinaryExpression aBinaryExpression) throws EvaluationException {
		System.out.print(" BINEXP ["+aBinaryExpression.getLeft().accept(this)+","+aBinaryExpression.getOperator()+","+aBinaryExpression.getRight().accept(this)+"]");
		return 0;
	}

	@Override
	public int visit(Designator aDesignator) throws EvaluationException {
		System.out.print("DESIG ["+aDesignator.getIdentifier()+"],");
		return 0;
	}

	@Override
	public int visit(Number aNumber) {
		return aNumber.value;
	}

	@Override
	public int visit(UnaryExpression aUnaryExpression)throws EvaluationException {
		System.out.print("UNEX ["+aUnaryExpression.getSubExpression().accept(this)+"]");
		return 0;
	}

	@Override
	public int visit(Assignment aAssignment) throws EvaluationException {
		System.out.print("ASSIGN [");
		aAssignment.getDesignator().accept(this);
		aAssignment.getExpression().accept(this);
		System.out.print("]");
		return 0;
	}	
}
