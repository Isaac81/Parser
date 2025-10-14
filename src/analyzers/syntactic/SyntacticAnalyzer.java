package analyzers.syntactic;

import components.exceptions.BadAssignationException;
import components.exceptions.messages.ExceptionMessages;
import components.exceptions.ExistingIdentifierException;
import components.token.Token;
import components.token.TokenType;
import components.variables.Variable;
import components.variables.numeric.FloatVariable;

import java.util.*;

public class SyntacticAnalyzer implements SyntaxValidator {
    private Stack<Character> groupers = new Stack<>();
    private Stack<Variable> variables = new Stack<>();
    private Set<String> variableNames = new HashSet<>();

    @Override
    public boolean isValidBooleanAssignation(List<Token> tokens,  List<String> fileContent, int scope) {
        return false;
    }

    @Override
    public boolean isValidIntegerAssignation() {
        return false;
    }

    /**
     * <p>meaning of the values of variable {@code state}</p>
     * <p>{@code 0}: float
     * <p>{@code 1}: float identifier
     * <p>{@code 2}: float identifier =
     * <p>{@code 3}: float identifier = numericOperation
     * <p>{@code 4}: float identifier assign or not ;</p>
     */
    @Override
    public boolean isValidFloatAssignation(List<Token> tokens, List<String> fileContent, int scope) {
        boolean isValid = false;
        int state = 0;
        FloatVariable variable = new FloatVariable(scope);
        String error;

        while (!tokens.isEmpty() && !isValid) {
            Token currentToken = tokens.removeFirst();
            error = "Error on line " + currentToken.getLine() + ": ".concat(fileContent.get(currentToken.getLine() - 1));
            if (currentToken.getType() == TokenType.LINE) {
                continue;
            }
            if (currentToken.getType() == TokenType.IDENTIFIER && state == 0) {
                if (variableNames.contains(currentToken.getValue())) {
                    throw new ExistingIdentifierException(error, ExceptionMessages.EXISTING_IDENTIFIER.getDescription());
                }
                state = 1;
                variable.setName(currentToken.getValue());
            } else if (currentToken.getType() == TokenType.ASSIGN && state == 1) {
                state = 2;
            } else if (state == 2 && currentToken.getType() == TokenType.IS_FLOAT) {
                state = 3;
            } else if (state == 2 && currentToken.getType() != TokenType.IS_FLOAT) {
                if (isValidNumericOperation(tokens, scope)) {
                    state = 3;
                } else {
                    throw new BadAssignationException(error, ExceptionMessages.INVALID_FLOAT_VALUE.getDescription());
                }

            } else if (currentToken.getType() == TokenType.SEMICOLON &&  (state == 1 || state == 3 )) {
                state = 4;
                isValid = true;
            }
        }
        variables.push(variable);
        variableNames.add(variable.getName());

        return isValid;
    }

    @Override
    public boolean isValidDoubleAssignation() {
        return false;
    }

    @Override
    public boolean isValidNumericOperation(List<Token> tokens, int scope) {
        return false;
    }

    @Override
    public boolean isValidCharAssignation() {
        return false;
    }

    @Override
    public boolean isValidStringAssignation() {
        return false;
    }

    public void analyzer(List<Token> tokens, List<String> fileContent) {
        int currentScope = 0;
        boolean isValid = true;

        while (!tokens.isEmpty()) {
            Token currentToken = tokens.removeFirst();

            while(currentToken.getType() == TokenType.LINE) {
                currentToken = tokens.removeFirst();
            }

            switch (currentToken.getType()) {
                case TokenType.FLOAT: {
                    isValidFloatAssignation(tokens, fileContent, currentScope);
                    break;
                }
                case TokenType.INT: {

                }
                default: {

                }
            }
        }
    }

}
