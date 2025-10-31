package analyzers.syntactic;

import components.exceptions.BadAssignationException;
import components.exceptions.messages.ExceptionMessages;
import components.exceptions.ExistingIdentifierException;
import components.token.Token;
import components.token.TokenType;
import components.variables.Variable;
import components.variables.numeric.FloatVariable;
import components.variables.numeric.NumericVariable;

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
    public boolean isValidFloatDeclaration(List<Token> tokens, List<String> fileContent, int scope) {
        Token currentToken;
        FloatVariable variable = new FloatVariable(scope);
        String error;
        int state = 0;

        while (state != 4 && !(tokens.isEmpty())) {
            currentToken = tokens.removeFirst();
            if (currentToken.getType() == TokenType.LINE){
                continue;
            }

            error = "Error on line " + currentToken.getLine() + ": ".concat(fileContent.get(currentToken.getLine() - 1));

            if ((state == 0) && (currentToken.getType() == TokenType.IDENTIFIER)) {
                if (variableNames.contains(currentToken.getValue())) {
                    throw new ExistingIdentifierException(error, ExceptionMessages.EXISTING_IDENTIFIER.getDescription());
                }
                variable.setName(currentToken.getValue());
                state = 1;
            } else if ((state == 1) && (currentToken.getType() == TokenType.ASSIGN)) {
                state = 2;
            } else if (state == 1 && (currentToken.getType() == TokenType.SEMICOLON)) {
                variables.push(variable);
                state = 4;
            } else if (state == 3 && (currentToken.getType() == TokenType.SEMICOLON)) {
                state = 4;
            } else if ((state == 2) && isValidNumericOperation(tokens, fileContent, scope, variable)) {
                state = 3;
            } else {
                throw new BadAssignationException(error, ExceptionMessages.INVALID_FLOAT_VALUE.getDescription());
            }
        }
        return state == 4;
    }

    @Override
    public boolean isValidDoubleAssignation() {
        return false;
    }

    @Override
    public boolean isValidNumericOperation(List<Token> tokens, List<String> fileContent,
                                           int scope, NumericVariable variable) {
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
                    isValidFloatDeclaration(tokens, fileContent, currentScope);
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
