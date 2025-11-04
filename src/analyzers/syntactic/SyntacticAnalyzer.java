package analyzers.syntactic;

import analyzers.context.SyntacticContext;
import components.exceptions.BadAssignationException;
import components.exceptions.ExistingIdentifierException;
import components.exceptions.InvalidDeclarationException;
import components.exceptions.messages.ExceptionMessages;
import components.token.Token;
import components.token.TokenType;
import components.variables.Variable;
import components.variables.numeric.FloatVariable;
import components.variables.numeric.NumericVariable;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SyntacticAnalyzer implements SyntaxValidator {
    private Stack<Character> groupers = new Stack<>();
    private Stack<Variable> variables = new Stack<>();
    private Set<String> variableNames = new HashSet<>();

    @Override
    public boolean isValidBooleanDeclaration(SyntacticContext context) {
        return false;
    }

    @Override
    public boolean isValidIntegerDeclaration(SyntacticContext context) {
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
    public boolean isValidFloatDeclaration(SyntacticContext context) {
        Token currentToken;
        FloatVariable variable = new FloatVariable(context.getScope());
        String error;
        int state = 0;

        while (state != 4 && !(context.getTokensList().isEmpty())) {
            currentToken = context.getTokensList().removeFirst();
            if (currentToken.getType() == TokenType.LINE) {
                continue;
            }

            error = "Error on line " + currentToken.getLine() + ": "
                    .concat(context.getFileContent().get(currentToken.getLine() - 1));

            if ((state == 0) && (currentToken.getType() == TokenType.IDENTIFIER)) {
                if (variableNames.contains(currentToken.getValue())) {
                    throw new ExistingIdentifierException(error, ExceptionMessages.EXISTING_IDENTIFIER);
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
            } else if ((state == 2) && isValidNumericOperation(context, variable)) {
                state = 3;
            } else {
                throw new BadAssignationException(error, ExceptionMessages.INVALID_FLOAT_VALUE);
            }
        }
        return state == 4;
    }

    @Override
    public boolean isValidDoubleDeclaration(SyntacticContext context) {
        return false;
    }

    @Override
    public boolean isValidNumericOperation(SyntacticContext context, NumericVariable variable) {
        return false;
    }

    @Override
    public boolean isValidCharDeclaration() {
        return false;
    }

    @Override
    public boolean isValidStringDeclaration() {
        return false;
    }

    public void analyzer(SyntacticContext context) {

        while (!context.getTokensList().isEmpty()) {
            Token currentToken = context.getTokensList().removeFirst();

            while (currentToken.getType() == TokenType.LINE) {
                currentToken = context.getTokensList().removeFirst();
            }

            switch (currentToken.getType()) {
                case TokenType.FLOAT: {
                    isValidFloatDeclaration(context);
                    // TODO: refactor the exceptions to use the a design pattern
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
