package calculator.syntax;

import calculator.EvaluationException;
import calculator.VariableContext;

public class Designator implements Expression {
	String identifier;
	
	public Designator(String identifier) {
		this.identifier = identifier;
	}
	
	public String getIdentifier() {
		return identifier;
	}

	/* (non-Javadoc)
	 * @see calculator.syntax.Expression#interpret(calculator.VariableContext)
	 */
	@Override
	public int accept(VariableContext aMemory, Visitor v) throws EvaluationException {
		return v.visit(aMemory, this);
	}
}
