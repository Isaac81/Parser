package components.exceptions;

import components.exceptions.messages.ExceptionMessages;

public class SyntaxException extends RuntimeException {
    public SyntaxException(ExceptionMessages message) {
        super(message.getDescription());
    }
}
