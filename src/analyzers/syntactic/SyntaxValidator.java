package analyzers.syntactic;

import analyzers.context.SyntacticContext;
import components.variables.numeric.NumericVariable;

public interface SyntaxValidator {
    boolean isValidBooleanDeclaration(SyntacticContext context);
    boolean isValidIntegerDeclaration(SyntacticContext context);
    boolean isValidFloatDeclaration(SyntacticContext context);
    boolean isValidDoubleDeclaration(SyntacticContext context);
    boolean isValidNumericOperation(SyntacticContext context, NumericVariable variable);
    boolean isValidCharDeclaration();
    boolean isValidStringDeclaration();

}
