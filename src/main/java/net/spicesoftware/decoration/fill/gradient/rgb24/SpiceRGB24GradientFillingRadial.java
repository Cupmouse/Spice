package net.spicesoftware.decoration.fill.gradient.rgb24;

import net.spicesoftware.api.decoration.fill.gradient.rgb24.RGB24GradientFillingRadial;
import net.spicesoftware.api.util.color.RGB24Color;
import net.spicesoftware.decoration.fill.gradient.SpiceGradientFillingRadial;

/**
 * @since 2015/07/08
 */
public final class SpiceRGB24GradientFillingRadial extends SpiceGradientFillingRadial<RGB24Color> implements RGB24GradientFillingRadial {

    public SpiceRGB24GradientFillingRadial(RGB24Color firstColor, int firstColorPos, RGB24Color secondColor, int secondColorPos, boolean repeat) {
        super(firstColor, firstColorPos, secondColor, secondColorPos, repeat);
    }

    public SpiceRGB24GradientFillingRadial(RGB24Color firstColor, int firstColorPos, RGB24Color secondColor, int secondColorPos) {
        super(firstColor, firstColorPos, secondColor, secondColorPos, false);
    }

    protected SpiceRGB24GradientFillingRadial() {
    }

    @Override
    public SpiceRGB24GradientFillingRadial copyDeeply() {
        SpiceRGB24GradientFillingRadial newOne = new SpiceRGB24GradientFillingRadial();
        copyDeeply(newOne);
        return newOne;
    }
}
