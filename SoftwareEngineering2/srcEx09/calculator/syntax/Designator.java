package calculator.syntax;

import calculator.EvaluationException;
import calculator.VariableContext;

public class Designator implements Expression {
	private String identifier;
	
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
	public int interpret(VariableContext aMemory) throws EvaluationException {
		try {
			return aMemory.get(identifier);
		} catch (Exception anEx) {
			throw new EvaluationException(anEx.getMessage());
		}
	}
}
