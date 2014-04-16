package calculator.syntax;

import calculator.EvaluationException;
import calculator.VariableContext;

public class DumpVisitor implements ExpressionVisitor{
	
	public DumpVisitor(VariableContext aContext) {
		// TODO Auto-generated constructor stub
	}


	@Override
	public int visit(BinaryExpression aBinaryExpression)
			throws EvaluationException {
		System.out.print("binex ");
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
