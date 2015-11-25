package net.spicesoftware.decoration.fill.gradient;

import net.spicesoftware.api.decoration.fill.Color;
import net.spicesoftware.api.decoration.fill.gradient.ColorStopGradientFilling;
import net.spicesoftware.api.decoration.fill.gradient.ColorStopGradientFillingBuilder;
import net.spicesoftware.api.util.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.Map;

import static net.spicesoftware.api.util.Validate.nullNot;
import static net.spicesoftware.api.util.Validate.rangeIn;

public abstract class SpiceColorStopGradientFillingBuilder<C extends Color, T extends ColorStopGradientFilling<C>> implements ColorStopGradientFillingBuilder<C, T> {

    @ToString
    protected final Map<Integer, C> colorStopMap = new HashMap<>();
    @ToString
    protected boolean repeating;

    protected SpiceColorStopGradientFillingBuilder() {
    }

    @Override
    public SpiceColorStopGradientFillingBuilder<C, T> repeating(boolean repeating) {
        this.repeating = repeating;
        return this;
    }

    @Override
    public SpiceColorStopGradientFillingBuilder<C, T> colorStopAt(@Min(0) @Max(999) int i, C color) {
        rangeIn(i, 0, 999);
        nullNot(color);
        colorStopMap.put(i, color);
        return this;
    }

    @Override
    public SpiceColorStopGradientFillingBuilder<C, T> repeat() {
        this.repeating = true;
        return this;
    }
}