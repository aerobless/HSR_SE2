package calculator.syntax;

import calculator.EvaluationException;
import calculator.VariableContext;

public class UnaryExpression implements Expression {
	private Operator operator;
	private Expression subExpression;
	
	public UnaryExpression(Operator operator, Expression subExpression) {
		this.operator = operator;
		this.subExpression = subExpression;
	}
	
	public Operator getOperator() {
		return operator;
	}
	
	public Expression getSubExpression() {
		return subExpression;
	}

	/* (non-Javadoc)
	 * @see calculator.syntax.Expression#interpret(calculator.VariableContext)
	 */
	@Override
	public int interpret(VariableContext aMemory) throws EvaluationException {
		// TODO Auto-generated method stub
		if (operator == Operator.ADD) {
			return subExpression.interpret(aMemory);
		} else if (operator == Operator.SUB) {
			return -subExpression.interpret(aMemory);
		} else {
			throw new EvaluationException("Invalid operator");
		}
	}
}
