package components.token;

public class Token {
    private TokenType type;
    private int line;
    private String value;

    public Token(TokenType type, int line, String value) {
        this.type = type;
        this.line = line;
        this.value = value;
    }

    public TokenType getType() {
        return type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
