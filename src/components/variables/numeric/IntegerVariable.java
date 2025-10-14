package components.variables.numeric;

public class IntegerVariable extends NumericVariable {
    public static final int MAX_VAL = Integer.MAX_VALUE;
    public static final int MIN_VAL = Integer.MIN_VALUE;
    private int value;

    public IntegerVariable(String name) {
        this.name = name;
    }

    public IntegerVariable(String name, int value) {
        this(name);
        this.value = value;
    }

    @Override
    protected void setValue(Number value) {
        this.value = (int) value;
    }

    @Override
    protected Number val() {
        return value;
    }

    @Override
    public String toString() {
        return "IntegerVariable{" +
                "value=" + value +
                ", value=" + value +
                ", name='" + name + '\'' +
                ", scope=" + scope +
                '}';
    }
}
