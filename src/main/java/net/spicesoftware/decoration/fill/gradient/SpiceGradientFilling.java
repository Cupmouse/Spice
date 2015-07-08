package net.spicesoftware.decoration.fill.gradient;

import net.spicesoftware.api.decoration.fill.Color;
import net.spicesoftware.api.decoration.fill.gradient.GradientFilling;
import net.spicesoftware.decoration.fill.SpiceDecorationFilling;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @since 2015/07/08
 */
public abstract class SpiceGradientFilling<T extends Color> extends SpiceDecorationFilling implements GradientFilling<T> {

    public boolean repeat;
    private Map<Integer, T> colorStopMap = new HashMap<Integer, T>();

    public SpiceGradientFilling(T firstColor, int firstColorPos, T secondColor, int secondColorPos, boolean repeat) {
        this.repeat = repeat;
    }

    public SpiceGradientFilling(T firstColor, int firstColorPos, T secondColor, int secondColorPos) {
        this(firstColor, firstColorPos, secondColor, secondColorPos, false);
    }

    protected SpiceGradientFilling() {
    }

    @Override
    public Map<Integer, T> getColorStopMap() {
        return Collections.unmodifiableMap(colorStopMap);
    }

    @Override
    public Optional<T> getColorStopAt(@Min(0) @Max(999) int i) {
        return Optional.ofNullable(colorStopMap.get(i));
    }

    @Override
    public void setColorStopAt(@Min(0) @Max(999) int i, T color) {
        colorStopMap.put(i, color);
    }

    @Override
    public void removeColorStopAt(@Min(0) @Max(999) int i) {
        colorStopMap.remove(i);
    }

    @Override
    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    @Override
    public void repeat() {
        this.repeat = true;
    }

    @Override
    public boolean isRepeating() {
        return repeat;
    }

    @Override
    public abstract SpiceGradientFilling<T> copyDeeply();

    public void copyDeeply(SpiceGradientFilling newGradientFilling) {
        for (Map.Entry<Integer, T> entry : colorStopMap.entrySet()) {
            newGradientFilling.colorStopMap.put(entry.getKey(), entry.getValue().copyDeeply());
        }
    }
}
