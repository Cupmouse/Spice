package net.spicesoftware.decoration.fill.gradient.rgb24;

import net.spicesoftware.api.decoration.fill.gradient.rgb24.RGB24GradientFillingLinear;
import net.spicesoftware.api.util.color.RGB24Color;
import net.spicesoftware.decoration.fill.gradient.SpiceGradientFillingLinear;

/**
 * @since 2015/07/08
 */
public final class SpiceRGB24GradientFillingLinear extends SpiceGradientFillingLinear<RGB24Color> implements RGB24GradientFillingLinear {

    public SpiceRGB24GradientFillingLinear(RGB24Color firstColor, int firstColorPos, RGB24Color secondColor, int secondColorPos, boolean repeat) {
        super(firstColor, firstColorPos, secondColor, secondColorPos, repeat);
    }

    public SpiceRGB24GradientFillingLinear(RGB24Color firstColor, int firstColorPos, RGB24Color secondColor, int secondColorPos) {
        super(firstColor, firstColorPos, secondColor, secondColorPos);
    }

    protected SpiceRGB24GradientFillingLinear() {
    }

    @Override
    public SpiceRGB24GradientFillingLinear copyDeeply() {
        SpiceRGB24GradientFillingLinear newOne = new SpiceRGB24GradientFillingLinear();
        copyDeeply(newOne);
        return newOne;
    }
}
