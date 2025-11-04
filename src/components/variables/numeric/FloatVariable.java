package components.variables.numeric;

public class FloatVariable extends NumericVariable {
    float value;

    public FloatVariable(String scope) {
        this.scope = scope;
    }

    public FloatVariable(String scope, String name) {
        this(scope);
        this.name = name;
    }

    public FloatVariable(String scope, String name, float value) {
        this(scope, name);
        this.value = value;
    }

    @Override
    protected void setValue(Number value) {
        this.value = (float) value;
    }

    @Override
    protected Number val() {
        return this.value;
    }

    @Override
    public String toString() {
        return "FloatVariable{" +
                "value=" + value +
                ", value=" + value +
                ", name='" + name + '\'' +
                ", scope=" + scope +
                '}';
    }
}
