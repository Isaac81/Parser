package analyzers.context;

import components.token.Token;

import java.util.LinkedList;
import java.util.List;

public class LexicalContext {
    List<Token> tokensList;
    String line;
    int lineNumber;
    boolean isString;

    public LexicalContext() {
        tokensList = new LinkedList<>();
        line = "";
        lineNumber = 0;
        isString = false;
    }

    public List<Token> getTokensList() {
        return tokensList;
    }

    public void setTokensList(List<Token> tokensLists) {
        this.tokensList = tokensLists;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void incrementLineNumber() {
        this.lineNumber++;
    }

    public boolean isString() {
        return isString;
    }

    public void setString(boolean string) {
        isString = string;
    }

    @Override
    public String toString() {
        return "LexicalContext{" +
                "tokensLists=" + tokensList +
                ", line='" + line + '\'' +
                ", lineNumber=" + lineNumber +
                ", isString=" + isString +
                '}';
    }
}
