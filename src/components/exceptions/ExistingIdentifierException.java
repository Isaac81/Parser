package components.exceptions;

public class ExistingIdentifierException extends RuntimeException {
    public ExistingIdentifierException(String message, String line) {
        super(line);
        System.err.println(message);
    }
}
