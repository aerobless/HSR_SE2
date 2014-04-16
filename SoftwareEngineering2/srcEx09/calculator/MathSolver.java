package calculator;

import calculator.syntax.Assignment;
import calculator.syntax.DumpVisitor;
import calculator.syntax.EvaluationVisitor;
import calculator.syntax.SyntaxNode;



public class MathSolver {

	public String evaluate(SyntaxNode node, VariableContext context)
			throws EvaluationException {
		if (!(node instanceof Assignment)) {
			throw new EvaluationException("Unsupported statement");
		}
		Assignment assignment = (Assignment) node;
		int value = assignment.getExpression().accept(context, new EvaluationVisitor(context));
		assignment.getExpression().accept(context, new DumpVisitor(context));
		System.out.println("");
		String variableId = assignment.getDesignator().getIdentifier();
		context.assign(variableId, value);
		return variableId + " = " + value;
	}
/*
	private int evaluateExpression(Expression expression,
			VariableContext context) throws EvaluationException {
		if (expression instanceof Number) {
			return ((Number) expression).getValue();
		} else if (expression instanceof Designator) {
			return evaluateDesignator((Designator) expression, context);
		} else if (expression instanceof UnaryExpression) {
			return evaluateUnaryExpression((UnaryExpression) expression,
					context);
		} else if (expression instanceof BinaryExpression) {
			return evaluateBinaryExpression((BinaryExpression) expression,
					context);
		} else {
			throw new AssertionError("Undefined expression");
		}
	}

	private int evaluateDesignator(Designator designator,
			VariableContext context) throws EvaluationException {
		try {
			return context.get(designator.getIdentifier());
		} catch (Exception e) {
			throw new EvaluationException(e.getMessage());
		}
	}

	private int evaluateUnaryExpression(UnaryExpression expression,
			VariableContext context) throws EvaluationException {
		Operator operator = expression.getOperator();
		int value = evaluateExpression(expression.getSubExpression(), context);
		if (operator == Operator.ADD) {
			return value;
		} else if (operator == Operator.SUB) {
			return -value;
		} else {
			throw new EvaluationException("Invalid operator");
		}
	}

	private int evaluateBinaryExpression(BinaryExpression expression,
			VariableContext context) throws EvaluationException {
		Operator operator = expression.getOperator();
		int left = evaluateExpression(expression.getLeft(), context);
		int right = evaluateExpression(expression.getRight(), context);
		if (operator == Operator.ADD) {
			return left + right;
		} else if (operator == Operator.SUB) {
			return left - right;
		} else if (operator == Operator.MUL) {
			return left * right;
		} else if (operator == Operator.DIV) {
			if (right == 0) {
				throw new EvaluationException("DIV BY 0");
			}
			return left / right;
		} else if (operator == Operator.MOD) {
			if (right == 0) {
				throw new EvaluationException("MOD BY 0");
			}
			return left % right;
		} else {
			throw new EvaluationException("Invalid operator");
		}
	}*/
}
