package net.spicesoftware.decoration.fill.gradient.rgb24;

import net.spicesoftware.api.decoration.fill.RGB24Color;
import net.spicesoftware.api.decoration.fill.gradient.rgb24.RGB24GradientFillingLinear;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.decoration.fill.gradient.SpiceGradientFillingLinear;

import java.util.Map;

/**
 * @since 2015/07/08
 */
public final class SpiceRGB24GradientFillingLinear extends SpiceGradientFillingLinear<RGB24Color> implements RGB24GradientFillingLinear {

    protected SpiceRGB24GradientFillingLinear(Map<Integer, RGB24Color> colorStopMap, boolean repeating) {
        super(colorStopMap, repeating);
    }

    protected SpiceRGB24GradientFillingLinear(SpiceGradientFillingLinear<RGB24Color> copyFrom) {
        super(copyFrom);
    }

    @Override
    public SpiceRGB24GradientFillingLinear copyDeeply() {
        return new SpiceRGB24GradientFillingLinear(this);
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}
