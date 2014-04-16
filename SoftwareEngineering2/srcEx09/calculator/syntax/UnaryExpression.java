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
		return accept(aMemory, new Visitor());
	}

	/* (non-Javadoc)
	 * @see calculator.syntax.Expression#interpret(calculator.VariableContext)
	 */
	@Override
	public int accept(VariableContext aMemory, Visitor v) throws EvaluationException {
		// TODO Auto-generated method stub
		if (operator == Operator.ADD) {
			return subExpression.accept(aMemory, new Visitor());
		} else if (operator == Operator.SUB) {
			return -subExpression.accept(aMemory, new Visitor());
		} else {
			throw new EvaluationException("Invalid operator");
		}
	}
}
