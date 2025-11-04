package components.exceptions;

import components.exceptions.messages.ExceptionMessages;

public class InvalidDeclarationException extends SyntaxException {
    public InvalidDeclarationException(ExceptionMessages message) {
        super(message);
    }
}
