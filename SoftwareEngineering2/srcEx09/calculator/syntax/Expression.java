package calculator.syntax;

import calculator.EvaluationException;
import calculator.VariableContext;

public interface Expression extends SyntaxNode {
	public int accept(VariableContext memory, ExpressionVisitor v) throws EvaluationException;
}