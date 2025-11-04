package components.exceptions;

import components.exceptions.messages.ExceptionMessages;

public class BadAssignationException extends SyntaxException {
    public BadAssignationException(String message, ExceptionMessages line) {
        super(line);
        System.err.println(message);
    }
}
