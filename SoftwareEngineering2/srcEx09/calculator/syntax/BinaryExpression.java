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
		return accept(aMemory, new Visitor());
	}

	/* (non-Javadoc)
	 * @see calculator.syntax.Expression#interpret(calculator.VariableContext)
	 */
	@Override
	public int accept(VariableContext aMemory, Visitor v) throws EvaluationException {
		Operator operator = this.getOperator();
		//int left = evaluateExpression(this.getLeft(), aMemory);
		//int right = evaluateExpression(this.getRight(), aMemory);
		if (operator == Operator.ADD) {
			return left.accept(aMemory, new Visitor()) + right.accept(aMemory, new Visitor());
		} else if (operator == Operator.SUB) {
			return left.accept(aMemory, new Visitor()) - right.accept(aMemory, new Visitor());
		} else if (operator == Operator.MUL) {
			return left.accept(aMemory, new Visitor()) * right.accept(aMemory, new Visitor());
		} else if (operator == Operator.DIV) {
			if (right.accept(aMemory, new Visitor()) == 0) {
				throw new EvaluationException("DIV BY 0");
			}
			return left.accept(aMemory, new Visitor()) / right.accept(aMemory, new Visitor());
		} else if (operator == Operator.MOD) {
			if (right.accept(aMemory, new Visitor()) == 0) {
				throw new EvaluationException("MOD BY 0");
			}
			return left.accept(aMemory, new Visitor()) % right.accept(aMemory, new Visitor());
		} else {
			throw new EvaluationException("Invalid operator");
		}
	}
}
