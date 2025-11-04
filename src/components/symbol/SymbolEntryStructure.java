package components.symbol;

import components.token.TokenType;

import java.util.HashSet;
import java.util.Set;

public class SymbolEntryStructure extends SymbolEntry{
    private Set<String> variables;

    public SymbolEntryStructure(TokenType type, String parent) {
        super(type, parent);
        this.variables = new HashSet<>();
    }

    public SymbolEntryStructure(TokenType type, String parent, Set<String> variables) {
        this(type, parent);
        this.variables = variables;
    }

    public Set<String> getVariables() {
        return variables;
    }

    public void setVariables(Set<String> variables) {
        this.variables = variables;
    }

    @Override
    public String toString() {
        return "SymbolEntryStructure{" +
                "variables=" + variables +
                ", type=" + type +
                ", parent='" + parent + '\'' +
                '}';
    }
}
