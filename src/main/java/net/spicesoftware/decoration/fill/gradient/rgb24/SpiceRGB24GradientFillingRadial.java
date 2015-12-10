package net.spicesoftware.decoration.fill.gradient.rgb24;

import net.spicesoftware.api.decoration.fill.RGB24Color;
import net.spicesoftware.api.decoration.fill.gradient.rgb24.RGB24GradientFillingRadial;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.decoration.fill.gradient.SpiceGradientFillingRadial;

import java.util.Map;

/**
 * @since 2015/07/08
 */
public final class SpiceRGB24GradientFillingRadial extends SpiceGradientFillingRadial<RGB24Color> implements RGB24GradientFillingRadial {

    protected SpiceRGB24GradientFillingRadial(Map<Integer, RGB24Color> colorStopMap, boolean repeating, int centerXPos, int centerYPos) {
        super(colorStopMap, repeating, centerXPos, centerYPos);
    }

    protected SpiceRGB24GradientFillingRadial(SpiceGradientFillingRadial<RGB24Color> copyFrom) {
        super(copyFrom);
    }

    @Override
    public SpiceRGB24GradientFillingRadial copyDeeply() {
        return new SpiceRGB24GradientFillingRadial(this);
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}
