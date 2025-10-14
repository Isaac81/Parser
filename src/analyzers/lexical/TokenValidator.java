package analyzers.lexical;

public interface TokenValidator {
    boolean isIdentifier(String token);
    boolean isInteger(String token);
    boolean isFloat(String token);
    boolean isWord(String token);
}
