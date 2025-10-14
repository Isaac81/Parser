package components.variables.bool;

import components.variables.Variable;

public class BooleanVariable extends Variable {
    boolean value;

    public BooleanVariable(String name, int scope) {
        this.name = name;
        this.scope = scope;
        this.value = false;
    }

    public BooleanVariable(String name, int scope, boolean value) {
        this(name, scope);
        this.value = value;
    }

    public boolean val() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BooleanVariable{" +
                "value=" + value +
                ", name='" + name + '\'' +
                ", scope=" + scope +
                '}';
    }
}
