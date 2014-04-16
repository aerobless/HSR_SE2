package calculator.syntax;


public class Number implements Expression {
	int value;
	
	public Number(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public int accept(ExpressionVisitor v) {
		return v.visit(this);
	}
}