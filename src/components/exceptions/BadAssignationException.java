package components.exceptions;

public class BadAssignationException extends SyntaxException {
    public BadAssignationException(String message, String line) {
        super(line);
        System.err.println(message);
    }
}
