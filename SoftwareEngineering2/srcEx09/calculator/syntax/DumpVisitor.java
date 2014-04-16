package calculator.syntax;

import calculator.EvaluationException;
import calculator.VariableContext;

public class DumpVisitor implements ExpressionVisitor{
	VariableContext memory;
	
	public DumpVisitor(VariableContext aMemory) {
		super();
		memory = aMemory;
	}

	@Override
	public int visit(BinaryExpression aBinaryExpression) throws EvaluationException {
		Operator operator = aBinaryExpression.getOperator();
		if (operator == Operator.ADD) {
			System.out.print(aBinaryExpression.left.accept(memory, this) +", ADD,"+ aBinaryExpression.right.accept(memory, this));
		} else if (operator == Operator.SUB) {
			System.out.print(aBinaryExpression.left.accept(memory, this) +", SUB,"+ aBinaryExpression.right.accept(memory, this));
		} else if (operator == Operator.MUL) {
			System.out.print(aBinaryExpression.left.accept(memory, this) +", MUL,"+ aBinaryExpression.right.accept(memory, this));
		} else if (operator == Operator.DIV) {
			if (aBinaryExpression.right.accept(memory, this) == 0) {
				throw new EvaluationException("DIV BY 0");
			}
			return aBinaryExpression.left.accept(memory, this) / aBinaryExpression.right.accept(memory, this);
		} else if (operator == Operator.MOD) {
			if (aBinaryExpression.right.accept(memory, this) == 0) {
				throw new EvaluationException("MOD BY 0");
			}
			return aBinaryExpression.left.accept(memory, this) % aBinaryExpression.right.accept(memory, this);
		} else {
			throw new EvaluationException("Invalid operator");
		}
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
