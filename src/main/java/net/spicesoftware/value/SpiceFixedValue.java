package net.spicesoftware.value;

import net.spicesoftware.api.util.DeepCopyable;
import net.spicesoftware.api.value.FixedValue;

import javax.validation.constraints.Min;

/**
 * @since 2015/04/07
 */
public class SpiceFixedValue<T extends DeepCopyable> implements FixedValue<T> {

    private T value;

    public SpiceFixedValue(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public T getValueAt(@Min(0) int frame) {
        return value;
    }

    @Override
    public SpiceFixedValue<T> copyDeeply() {
        return new SpiceFixedValue<>((T) value.copyDeeply());
    }
}
