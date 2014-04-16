package calculator.syntax;

import calculator.EvaluationException;

public interface SyntaxNode {
	public int accept(ExpressionVisitor v) throws EvaluationException;
}