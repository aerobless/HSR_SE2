package calculator.syntax;

import calculator.EvaluationException;
import calculator.VariableContext;


public class Visitor {

	public int visit(VariableContext aMemory, BinaryExpression aBinaryExpression) throws EvaluationException {
		Operator operator = aBinaryExpression.getOperator();
		if (operator == Operator.ADD) {
			return aBinaryExpression.left.accept(aMemory, new Visitor()) + aBinaryExpression.right.accept(aMemory, new Visitor());
		} else if (operator == Operator.SUB) {
			return aBinaryExpression.left.accept(aMemory, new Visitor()) - aBinaryExpression.right.accept(aMemory, new Visitor());
		} else if (operator == Operator.MUL) {
			return aBinaryExpression.left.accept(aMemory, new Visitor()) * aBinaryExpression.right.accept(aMemory, new Visitor());
		} else if (operator == Operator.DIV) {
			if (aBinaryExpression.right.accept(aMemory, new Visitor()) == 0) {
				throw new EvaluationException("DIV BY 0");
			}
			return aBinaryExpression.left.accept(aMemory, new Visitor()) / aBinaryExpression.right.accept(aMemory, new Visitor());
		} else if (operator == Operator.MOD) {
			if (aBinaryExpression.right.accept(aMemory, new Visitor()) == 0) {
				throw new EvaluationException("MOD BY 0");
			}
			return aBinaryExpression.left.accept(aMemory, new Visitor()) % aBinaryExpression.right.accept(aMemory, new Visitor());
		} else {
			throw new EvaluationException("Invalid operator");
		}
	}

	public int visit(VariableContext aMemory, Designator aDesignator) throws EvaluationException {
		try {
			return aMemory.get(aDesignator.identifier);
		} catch (Exception anEx) {
			throw new EvaluationException(anEx.getMessage());
		}
	}

	public int visit(VariableContext aMemory, Number aNumber) {
		return aNumber.value;
	}

	public int visit(VariableContext aMemory, UnaryExpression aUnaryExpression) throws EvaluationException {
		// TODO Auto-generated method stub
		if (aUnaryExpression.operator == Operator.ADD) {
			return aUnaryExpression.subExpression.accept(aMemory, new Visitor());
		} else if (aUnaryExpression.operator == Operator.SUB) {
			return -aUnaryExpression.subExpression.accept(aMemory, new Visitor());
		} else {
			throw new EvaluationException("Invalid operator");
		}
	}
}
