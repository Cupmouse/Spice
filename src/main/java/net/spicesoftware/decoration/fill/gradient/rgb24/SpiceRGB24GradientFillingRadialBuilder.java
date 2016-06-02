package net.spicesoftware.decoration.fill.gradient.rgb24;

import net.spicesoftware.api.ParameterEssentialBuilder;
import net.spicesoftware.api.decoration.fill.RGB24Color;
import net.spicesoftware.api.decoration.fill.gradient.rgb24.RGB24GradientFillingRadial;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.api.util.vector.Vector2i;
import net.spicesoftware.decoration.fill.gradient.SpiceGradientFillingRadialBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @since 2015/11/15
 */
public final class SpiceRGB24GradientFillingRadialBuilder extends SpiceGradientFillingRadialBuilder<RGB24Color, RGB24GradientFillingRadial> implements RGB24GradientFillingRadial.Builder {

    @Override
    public SpiceRGB24GradientFillingRadialBuilder radialCenter(int centerXPos, int centerYPos) {
        super.radialCenter(centerXPos, centerYPos);
        return this;
    }

    @Override
    public SpiceRGB24GradientFillingRadialBuilder radialCenter(Vector2i centerPos) {
        super.radialCenter(centerPos);
        return this;
    }

    @Override
    public SpiceRGB24GradientFillingRadialBuilder repeating(boolean repeating) {
        super.repeating(repeating);
        return this;
    }

    @Override
    public SpiceRGB24GradientFillingRadialBuilder colorStopAt(@Min(0) @Max(999) int i, RGB24Color color) {
        super.colorStopAt(i, color);
        return this;
    }

    @Override
    public SpiceRGB24GradientFillingRadialBuilder repeat() {
        super.repeat();
        return this;
    }

    @Override
    public SpiceRGB24GradientFillingRadial build() {
        return new SpiceRGB24GradientFillingRadial(colorStopMap, repeating, centerXPos, centerYPos);
    }

    @Override
    public SpiceRGB24GradientFillingRadialBuilder from(RGB24GradientFillingRadial copy) {
        radialCenter(copy.getRadialCenter());
        super.from(copy);
        return this;
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}
