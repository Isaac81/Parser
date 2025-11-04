package components.exceptions;

import components.exceptions.messages.ExceptionMessages;

public class ExistingIdentifierException extends SyntaxException {
    public ExistingIdentifierException(String message, ExceptionMessages line) {
        super(line);
        System.err.println(message);
    }
}
