package calculator;

import calculator.MathLexer.LexerException;
import calculator.MathParser.ParserException;
import calculator.syntax.SyntaxNode;


public class MathSession {
	MathLexer lexer;
	MathParser parser;
	MathSolver solver;
	VariableContext memory;

	public MathSession() {
		lexer = new MathLexer();
		parser = new MathParser(lexer);
		solver = new MathSolver();
		memory = new VariableContext();
	}

	public String processCommand(String line) {
		try {
			lexer.initializeInput(line);
			SyntaxNode node = parser.parse();
			return solver.evaluate(node, memory);
		} catch (ParserException | LexerException | EvaluationException e) {
			return "ERROR " + e.getMessage();
		}
	}
}
