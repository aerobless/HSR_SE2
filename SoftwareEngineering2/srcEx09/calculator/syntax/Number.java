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
	
	@Override
	public int accept(VariableContext aMemory, Visitor v) {
		return v.visit(aMemory, this);
	}
}