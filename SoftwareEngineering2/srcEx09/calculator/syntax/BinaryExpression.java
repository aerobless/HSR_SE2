package calculator.syntax;

import calculator.EvaluationException;
import calculator.VariableContext;

public class BinaryExpression implements Expression {
	private Expression left;
	private Operator operator;
	private Expression right;
	
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

	/* (non-Javadoc)
	 * @see calculator.syntax.Expression#interpret(calculator.VariableContext)
	 */
	@Override
	public int interpret(VariableContext aMemory) throws EvaluationException {
		Operator operator = this.getOperator();
		//int left = evaluateExpression(this.getLeft(), aMemory);
		//int right = evaluateExpression(this.getRight(), aMemory);
		if (operator == Operator.ADD) {
			return left.interpret(aMemory) + right.interpret(aMemory);
		} else if (operator == Operator.SUB) {
			return left.interpret(aMemory) - right.interpret(aMemory);
		} else if (operator == Operator.MUL) {
			return left.interpret(aMemory) * right.interpret(aMemory);
		} else if (operator == Operator.DIV) {
			if (right.interpret(aMemory) == 0) {
				throw new EvaluationException("DIV BY 0");
			}
			return left.interpret(aMemory) / right.interpret(aMemory);
		} else if (operator == Operator.MOD) {
			if (right.interpret(aMemory) == 0) {
				throw new EvaluationException("MOD BY 0");
			}
			return left.interpret(aMemory) % right.interpret(aMemory);
		} else {
			throw new EvaluationException("Invalid operator");
		}
	}
}
