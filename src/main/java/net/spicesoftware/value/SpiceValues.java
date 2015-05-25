package net.spicesoftware.value;

import net.spicesoftware.api.value.Value;
import net.spicesoftware.api.value.Values;

import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @since 2015/04/07
 */
public class SpiceValues implements Values {

    private Map<String, Value<?>> values = new HashMap<>();

    @Override
    public Map<String, Value<?>> getValueMap() {
        return values;
    }

    @Override
    public Optional<Value<?>> getValue(@Size(min = 1) String id) {
        return Optional.ofNullable(values.get(id));
    }

    @Override
    public Values copyDeeply() {
        SpiceValues copied = new SpiceValues();
        for (Map.Entry<String, Value<?>> entry : values.entrySet()) {
            copied.values.put(entry.getKey(), entry.getValue().copyDeeply());
        }
        return copied;
    }
}
