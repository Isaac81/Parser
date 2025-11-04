package components.symbol;

import components.token.TokenType;
import components.variables.Variable;

public class SymbolEntryVariable extends SymbolEntry {
    private Variable variable;

    public SymbolEntryVariable(TokenType type, String parent, Variable variable) {
        super(type, parent);
        this.variable = variable;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    @Override
    public String toString() {
        return "SymbolEntryVariable{" +
                "variable=" + variable +
                ", type=" + type +
                ", parent='" + parent + '\'' +
                '}';
    }
}
