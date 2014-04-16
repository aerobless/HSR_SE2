package calculator.syntax;

import calculator.EvaluationException;
import calculator.VariableContext;

public interface Expression extends SyntaxNode {
	public int interpret(VariableContext memory) throws EvaluationException;
}