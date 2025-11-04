package analyzers.lexical;

import analyzers.context.LexicalContext;
import components.token.Token;
import components.token.TokenType;

import java.util.*;

public class LexicalAnalyzer implements TokenValidator {
    private static boolean isComment = false;
    private static StringBuilder remainingData = new StringBuilder();
    private final Map<String, TokenType> tokenMap = new HashMap<>();
    private final Set<Character> symbolsSet = new HashSet<>() {{
        add('<');
        add('>');
        add('!');
        add('=');
        add('*');
        add('/');
        add('+');
        add('-');
    }};

    public LexicalAnalyzer() {
        initTokenMap();
    }

    private void initTokenMap() {

        tokenMap.put("if", TokenType.IF);
        tokenMap.put("elif", TokenType.ELIF);
        tokenMap.put("else", TokenType.ELSE);
        tokenMap.put("sw", TokenType.SW);
        tokenMap.put("case", TokenType.CASE);
        tokenMap.put("for", TokenType.FOR);
        tokenMap.put("while", TokenType.WHILE);
        tokenMap.put("do", TokenType.DO_WHILE);
        tokenMap.put("true", TokenType.TRUE);
        tokenMap.put("false", TokenType.FALSE);
        tokenMap.put("null", TokenType.NULL);
        tokenMap.put("or", TokenType.OR);
        tokenMap.put("and", TokenType.AND);
        tokenMap.put("not", TokenType.NOT);
        tokenMap.put("in", TokenType.IN);
        tokenMap.put("type", TokenType.TYPE);
        tokenMap.put("bool", TokenType.BOOL);
        tokenMap.put("byte", TokenType.BYTE);
        tokenMap.put("sint", TokenType.SINT);
        tokenMap.put("int", TokenType.INT);
        tokenMap.put("uint", TokenType.UINT);
        tokenMap.put("bint", TokenType.BINT);
        tokenMap.put("float", TokenType.FLOAT);
        tokenMap.put("double", TokenType.DOUBLE);
        tokenMap.put("char", TokenType.CHAR);
        tokenMap.put("str", TokenType.STR);
        tokenMap.put("void", TokenType.VOID);
        tokenMap.put("const", TokenType.CONST);
        tokenMap.put("break", TokenType.BREAK);
        tokenMap.put("pass", TokenType.PASS);
        tokenMap.put("return", TokenType.RETURN);
        tokenMap.put("is", TokenType.IS);
        tokenMap.put("len", TokenType.LEN);
        tokenMap.put("default", TokenType.DEFAULT);
        tokenMap.put(";", TokenType.SEMICOLON);
        tokenMap.put(",", TokenType.COMA);
        tokenMap.put("=", TokenType.ASSIGN);
        tokenMap.put("{", TokenType.OPEN_BRACKET);
        tokenMap.put("}", TokenType.CLOSE_BRACKET);
        tokenMap.put("(", TokenType.OPEN_PARENTHESIS);
        tokenMap.put(")", TokenType.CLOSE_PARENTHESIS);
        tokenMap.put("[", TokenType.OPEN_SQUARE_BRACKET);
        tokenMap.put("]", TokenType.CLOSE_SQUARE_BRACKET);
        tokenMap.put(".", TokenType.DOT);
        tokenMap.put("->", TokenType.ARROW);
        tokenMap.put("'", TokenType.SINGLE_QUOTE);
        tokenMap.put("\"", TokenType.DOUBLE_QUOTE);
        tokenMap.put(">", TokenType.GREATER_THAN);
        tokenMap.put(">=", TokenType.GREATER_OR_EQUALS);
        tokenMap.put("<", TokenType.LESS_THAN);
        tokenMap.put("<=", TokenType.LESS_OR_EQUALS);
        tokenMap.put("==", TokenType.EQUALS);
        tokenMap.put("!=", TokenType.DIFFERENT);
        tokenMap.put("+", TokenType.SUM);
        tokenMap.put("++", TokenType.AUTO_INCREMENT);
        tokenMap.put("+=", TokenType.ADD_ASSIGNMENT);
        tokenMap.put("-", TokenType.SUB);
        tokenMap.put("-=", TokenType.SUB_ASSIGNMENT);
        tokenMap.put("*", TokenType.MUL);
        tokenMap.put("/", TokenType.DIV);
        tokenMap.put("//", TokenType.INTEGER_DIV);
        tokenMap.put("**", TokenType.POW);
        tokenMap.put("%", TokenType.MOD);
        tokenMap.put("--", TokenType.COMMENT);
        tokenMap.put("---", TokenType.MULTILINE_COMMENT);
        tokenMap.put("\n", TokenType.LINE);
    }


    @Override
    public boolean isIdentifier(String token) {
        return token.matches("^[a-zA-Z_][a-zA-Z0-9_]*$");
    }

    @Override
    public boolean isInteger(String token) {
        return token.matches("^-?\\d+$");
    }

    @Override
    public boolean isFloat(String token) {
        return token.matches("^-?(\\d*\\.\\d+)|(\\d+\\.\\d*)$");
    }

    @Override
    public boolean isWord(String token) {
        return token.matches("^[a-z]+");
    }


    public void analyzer(LexicalContext context) {
        StringBuilder auxSB = new StringBuilder();

        if (context.getLine().isEmpty()) {
            if (isComment) {
                remainingData.append("/n");
            } else {
                context.getTokensList().addLast(new Token(TokenType.LINE, context.getLineNumber(), "/n"));
            }
        }

        for (int i = 0; i < context.getLine().length(); i++) {
            char currChar = context.getLine().charAt(i);
            if (isComment && (currChar != '-')) {
                switch (currChar) {
                    case ',' -> remainingData.append("\\comma");
                    case '"' -> remainingData.append("\\quotes");
                    default -> remainingData.append(currChar);
                }
            } else if (Character.isLetterOrDigit(currChar) || currChar == '_' || currChar == '.'
                    || (context.isString() && (currChar != '"'))) {
                auxSB.append(currChar);
            } else if (currChar == '"') {
                // Verify if the current char is the beginning or ending of a string
                if (context.isString()) {
                    auxSB.append(currChar);
                    context.getTokensList().addLast(
                            new Token(TokenType.IS_STRING, context.getLineNumber(), auxSB.toString()));
                    context.setString(false);
                } else {
                    auxSB.append(currChar);
                    context.setString(true);
                }
            } else {

                if (isIdentifier(auxSB.toString())) {
                    context.getTokensList().addLast(
                            new Token(
                                    tokenMap.getOrDefault(auxSB.toString(), TokenType.IDENTIFIER),
                                    context.getLineNumber(),
                                    auxSB.toString()));
                } else if (isFloat(auxSB.toString())) {
                    context.getTokensList().addLast(
                            new Token(TokenType.IS_FLOAT, context.getLineNumber(), auxSB.toString()));
                } else if (isInteger(auxSB.toString())) {
                    context.getTokensList().addLast(
                            new Token(TokenType.IS_INT, context.getLineNumber(), auxSB.toString()));
                }

                if (symbolsSet.contains(currChar)) {
                    i += classifier(context.getLine().substring(i), context.getTokensList(), context.getLineNumber());
                    if (context.getTokensList().getLast().getType() == TokenType.COMMENT) {
                        context.getTokensList().addLast(new Token(TokenType.IS_COMMENT, context.getLineNumber(),
                                context.getLine().substring(i + 1)));
                        break;
                    } else if (context.getTokensList().getLast().getType() == TokenType.SUB && isComment) {
                        context.getTokensList().removeLast();
                    }
                } else if (currChar != ' ') {
                    context.getTokensList().addLast(
                            new Token(
                                    tokenMap.getOrDefault(Character.toString(currChar), TokenType.DEFAULT),
                                    context.getLineNumber(),
                                    Character.toString(currChar)));
                }
                auxSB = new StringBuilder();
            }
        }

        if (!auxSB.isEmpty() && isWord(auxSB.toString())) {
            if (tokenMap.containsKey(auxSB.toString())) {
                context.getTokensList().addLast(
                        new Token(tokenMap.get(auxSB.toString()), context.getLineNumber(), auxSB.toString()));
            }
        }

        // TODO: Add else if for identifier
    }

    // TODO: replace the current params with the context
    private int classifier(String line, List<Token> tokenList, int lineNumber) {
        int len = line.length();
        int elements = 1;

        // Check if the current character is the beginning or ending of ---
        if (len > 2 && tokenMap.containsKey(line.substring(0, 3))) {
            elements = 3;
            if (isComment) {
                tokenList.addLast(new Token(TokenType.IS_COMMENT, lineNumber, remainingData.toString()));
                remainingData = new StringBuilder();
                isComment = false;
            } else {
                isComment = true;
            }
        } else if (len > 1 && tokenMap.containsKey(line.substring(0, 2))) {
            elements = 2;
        }
        tokenList.addLast(new Token(tokenMap.get(line.substring(0, elements)),
                lineNumber, line.substring(0, elements)));

        return elements - 1;
    }
}
