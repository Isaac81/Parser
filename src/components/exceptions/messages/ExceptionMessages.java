package components.exceptions.messages;

public enum ExceptionMessages {
    INVALID_FLOAT_VALUE ("It is not a valid float value."),
    EXISTING_IDENTIFIER ("Identifier already exists.");

    private final String description;

    ExceptionMessages(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
