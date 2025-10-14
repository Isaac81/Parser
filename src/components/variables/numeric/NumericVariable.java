package components.variables.numeric;

import components.variables.Variable;

public abstract class NumericVariable extends Variable {
    Number value;
    protected abstract void setValue(Number value);
    protected abstract Number val();
}
