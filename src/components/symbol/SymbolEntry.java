package components.symbol;

import components.token.TokenType;

public class SymbolEntry {
    protected TokenType type;
    protected String parent;

    public SymbolEntry(TokenType type, String parent) {
        this.type = type;
        this.parent = parent;
    }

    public TokenType getType() {
        return type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
