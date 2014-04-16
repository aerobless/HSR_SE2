package calculator.syntax;

import calculator.VariableContext;

public class Number implements Expression {
	int value;
	
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
	public int accept(VariableContext aMemory, Visitor v) {
		return v.visit(aMemory, this);
	}
}