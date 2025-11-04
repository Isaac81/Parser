package components.variables.string;

import components.variables.Variable;

public class StringVariable extends Variable {
    String value;

    public StringVariable(String name, String scope) {
        this.name = name;
        this.scope = scope;
    }

    public StringVariable(String name, String scope, String value) {
        this(name, scope);
        this.value = value;
    }

    public String val() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "StringVariable{" +
                "value='" + value + '\'' +
                ", name='" + name + '\'' +
                ", scope=" + scope +
                '}';
    }
}
