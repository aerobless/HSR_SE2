package calculator.syntax;

import calculator.VariableContext;

public class Number implements Expression {
	private int value;
	
	public Number(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see calculator.syntax.Expression#interpret(calculator.VariableContext)
	 */
	@Override
	public int interpret(VariableContext aMemory) {
		return accept(aMemory, new Visitor());
	}

	/* (non-Javadoc)
	 * @see calculator.syntax.Expression#interpret(calculator.VariableContext)
	 */
	@Override
	public int accept(VariableContext aMemory, Visitor v) {
		return value;
	}
}