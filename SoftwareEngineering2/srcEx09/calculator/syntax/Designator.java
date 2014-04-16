package calculator.syntax;

import calculator.EvaluationException;

public class Designator implements Expression {
	String identifier;
	
	public Designator(String identifier) {
		this.identifier = identifier;
	}
	
	public String getIdentifier() {
		return identifier;
	}

	@Override
	public int accept(ExpressionVisitor v) throws EvaluationException {
		return v.visit(this);
	}
}
