package net.spicesoftware.decoration.fill.gradient.rgb24;

import net.spicesoftware.api.decoration.fill.RGB24Color;
import net.spicesoftware.api.decoration.fill.gradient.rgb24.RGB24GradientFillingLinear;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.decoration.fill.gradient.SpiceColorStopGradientFillingBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @since 2015/11/15
 */
public final class SpiceRGB24GradientFillingLinearBuilder extends SpiceColorStopGradientFillingBuilder<RGB24Color, RGB24GradientFillingLinear> implements RGB24GradientFillingLinear.Builder {


    protected SpiceRGB24GradientFillingLinearBuilder() {
        super();
    }

    @Override
    public SpiceRGB24GradientFillingLinearBuilder repeating(boolean repeating) {
        super.repeating(repeating);
        return this;
    }

    @Override
    public SpiceRGB24GradientFillingLinearBuilder colorStopAt(@Min(0) @Max(999) int i, RGB24Color color) {
        super.colorStopAt(i, color);
        return this;
    }

    @Override
    public SpiceRGB24GradientFillingLinearBuilder repeat() {
        super.repeat();
        return this;
    }

    @Override
    public SpiceRGB24GradientFillingLinear build() {
        return new SpiceRGB24GradientFillingLinear(colorStopMap, repeating);
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}
