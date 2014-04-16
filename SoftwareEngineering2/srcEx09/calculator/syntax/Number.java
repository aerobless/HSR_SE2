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
		return value;
	}
}