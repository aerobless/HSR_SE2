package calculator.syntax;

import calculator.EvaluationException;
import calculator.VariableContext;


public class EvaluationVisitor implements ExpressionVisitor{
	VariableContext memory;
	
	public EvaluationVisitor(VariableContext aMemory) {
		super();
		memory = aMemory;
	}

	public int visit(BinaryExpression aBinaryExpression) throws EvaluationException {
		Operator operator = aBinaryExpression.getOperator();
		if (operator == Operator.ADD) {
			return aBinaryExpression.left.accept(this) + aBinaryExpression.right.accept(this);
		} else if (operator == Operator.SUB) {
			return aBinaryExpression.left.accept(this) - aBinaryExpression.right.accept(this);
		} else if (operator == Operator.MUL) {
			return aBinaryExpression.left.accept(this) * aBinaryExpression.right.accept(this);
		} else if (operator == Operator.DIV) {
			if (aBinaryExpression.right.accept(this) == 0) {
				throw new EvaluationException("DIV BY 0");
			}
			return aBinaryExpression.left.accept(this) / aBinaryExpression.right.accept(this);
		} else if (operator == Operator.MOD) {
			if (aBinaryExpression.right.accept(this) == 0) {
				throw new EvaluationException("MOD BY 0");
			}
			return aBinaryExpression.left.accept(this) % aBinaryExpression.right.accept(this);
		} else {
			throw new EvaluationException("Invalid operator");
		}
	}

	public int visit(Designator aDesignator) throws EvaluationException {
		try {
			return memory.get(aDesignator.identifier);
		} catch (Exception anEx) {
			throw new EvaluationException(anEx.getMessage());
		}
	}

	public int visit(Number aNumber) {
		return aNumber.value;
	}

	public int visit(UnaryExpression aUnaryExpression) throws EvaluationException {
		if (aUnaryExpression.operator == Operator.ADD) {
			return aUnaryExpression.subExpression.accept(this);
		} else if (aUnaryExpression.operator == Operator.SUB) {
			return -aUnaryExpression.subExpression.accept(this);
		} else {
			throw new EvaluationException("Invalid operator");
		}
	}


	@Override
	public int visit(Assignment aAssignment) {
		return 0;
	}
}
