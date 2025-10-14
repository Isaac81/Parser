package analyzers.syntactic;

import components.token.Token;

import java.util.List;

public interface SyntaxValidator {
    boolean isValidBooleanAssignation(List<Token> tokens, List<String> fileContent, int scope);
    boolean isValidIntegerAssignation();
    boolean isValidFloatAssignation(List<Token> tokens, List<String> fileContent, int scope);
    boolean isValidDoubleAssignation();
    boolean isValidNumericOperation(List<Token> tokens, int scope);
    boolean isValidCharAssignation();
    boolean isValidStringAssignation();

}
