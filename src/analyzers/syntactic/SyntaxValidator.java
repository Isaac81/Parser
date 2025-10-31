package analyzers.syntactic;

import components.token.Token;
import components.variables.numeric.NumericVariable;

import java.util.List;

public interface SyntaxValidator {
    boolean isValidBooleanAssignation(List<Token> tokens, List<String> fileContent, int scope);
    boolean isValidIntegerAssignation();
    boolean isValidFloatDeclaration(List<Token> tokens, List<String> fileContent, int scope);
    boolean isValidDoubleAssignation();
    boolean isValidNumericOperation(List<Token> tokens, List<String> fileContent, int scope, NumericVariable variable);
    boolean isValidCharAssignation();
    boolean isValidStringAssignation();

}
