// Syntax in EBNF:
// ---------------
// Integer = Digit { Digit }.
// Identifier = Letter { Letter | Digit }.
// Digit = "0" .. "9".
// Letter = "A" .. "Z" | "a" .. "z".
// ---------------
// White spaces for separating numbers and identifiers.
// Other white spaces are ignored.

package calculator;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;

import calculator.lexer.EndSymbol;
import calculator.lexer.IdentifierSymbol;
import calculator.lexer.IntegerSymbol;
import calculator.lexer.LexicalSymbol;
import calculator.lexer.TokenSymbol;
import calculator.lexer.TokenType;

public class MathLexer {
	private StringReader reader;
	private char current;
	private boolean endOfStream;
	
	//Flyweight Symbols
	private EndSymbol endSymobl = new EndSymbol();
	private HashMap<String, IdentifierSymbol> identifiers = new HashMap<String, IdentifierSymbol>();
	private HashMap<Integer, IntegerSymbol> integers = new HashMap<Integer, IntegerSymbol>();
	private HashMap<TokenType, TokenSymbol> tokens = new HashMap<TokenType, TokenSymbol>();

	public MathLexer() {
		endOfStream = false;
	}

	public void initializeInput(String inputLine) throws LexerException {
		endOfStream = false;
		reader = new StringReader(inputLine);
		nextChar();
	}

	public LexicalSymbol nextSymbol() throws LexerException {
		skipBlanks();
		if (endOfStream) {
			return endSymobl;
		} else if (isLetter(current)) {
			String identifier = readIdentifer();
			if(!identifiers.containsKey(identifier)){
				identifiers.put(identifier, new IdentifierSymbol(identifier));
			}
			return identifiers.get(identifier);
		} else if (isDigit(current)) {
			int integerValue = readInteger();
			if(!integers.containsKey(integerValue)){
				integers.put(integerValue, new IntegerSymbol(integerValue));
			}
			return integers.get(integerValue);
		} else {
			TokenType tokenType = readTokenType();
			if(!tokens.containsKey(tokenType)){
				tokens.put(tokenType, new TokenSymbol(tokenType));
			}
			return tokens.get(tokenType);
		}
	}

	private TokenType readTokenType() throws LexerException {
		TokenType type;
		switch (current) {
		case '=':
			type = TokenType.EQUAL_SIGN;
			break;
		case '(':
			type = TokenType.OPEN_PARENTHESIS;
			break;
		case ')':
			type = TokenType.CLOSE_PARENTHESIS;
			break;
		case '+':
			type = TokenType.PLUS_SIGN;
			break;
		case '-':
			type = TokenType.HYPHEN_SIGN;
			break;
		case '*':
			type = TokenType.ASTERISK_SIGN;
			break;
		case '/':
			type = TokenType.SLASH_SIGN;
			break;
		case '%':
			type = TokenType.PERCENTAGE_SIGN;
			break;
		default:
			throw new LexerException("Unsupported symbol " + current);
		}
		nextChar();
		return type;
	}

	private String readIdentifer() throws LexerException {
		String identifier = "";
		if (!isLetter(current)) {
			throw new AssertionError("No identifier");
		}
		identifier += current;
		nextChar();
		while (isLetter(current) || isDigit(current)) {
			identifier += current;
			nextChar();
		}
		return identifier;
	}

	private int readInteger() throws LexerException {
		int value = 0;
		if (!isDigit(current)) {
			throw new AssertionError("No integer");
		}
		value += getDigit(current);
		nextChar();
		while (isDigit(current)) {
			value *= 10;
			value += getDigit(current);
			nextChar();
		}
		return value;
	}

	private boolean isLetter(char value) {
		return (value >= 'A' && value <= 'Z') || (value >= 'a' && value <= 'z');
	}

	private int getDigit(char value) {
		return current - '0';
	}

	private boolean isDigit(char value) {
		return value >= '0' && value <= '9';
	}

	private void skipBlanks() throws LexerException {
		while (!endOfStream && current <= ' ') {
			nextChar();
		}
	}

	private void nextChar() throws LexerException {
		if (endOfStream) {
			throw new AssertionError();
		}
		int value;
		try {
			value = reader.read();
		} catch (IOException e) {
			throw new LexerException("IO exception");
		}
		if (value >= 0) {
			current = (char) value;
		} else {
			endOfStream = true;
			reader = null;
			current = 0x0;
		}
	}

	public class LexerException extends Exception {
		private static final long serialVersionUID = 3783220412595334021L;

		public LexerException(String message) {
			super(message);
		}
	}
}
