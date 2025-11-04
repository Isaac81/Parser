package components.variables.character;

import components.variables.Variable;

public class CharacterVariable extends Variable {
    char value;

    public CharacterVariable(String name, String scope) {
        this.name = name;
        this.scope = scope;
    }

    public CharacterVariable(String name, String scope, char value) {
        this(name, scope);
        this.value = value;
    }

    public char val() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CharacterVariable{" +
                "value=" + value +
                ", name='" + name + '\'' +
                ", scope=" + scope +
                '}';
    }
}
