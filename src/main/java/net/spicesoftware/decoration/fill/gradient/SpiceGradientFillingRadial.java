package net.spicesoftware.decoration.fill.gradient;

import net.spicesoftware.api.decoration.fill.Color;
import net.spicesoftware.api.decoration.fill.gradient.GradientFillingRadial;

/**
 * @since 2015/07/08
 */
public abstract class SpiceGradientFillingRadial<T extends Color> extends SpiceGradientFilling<T> implements GradientFillingRadial<T> {

    public SpiceGradientFillingRadial(T firstColor, int firstColorPos, T secondColor, int secondColorPos, boolean repeat) {
        super(firstColor, firstColorPos, secondColor, secondColorPos, repeat);
    }

    public SpiceGradientFillingRadial(T firstColor, int firstColorPos, T secondColor, int secondColorPos) {
        super(firstColor, firstColorPos, secondColor, secondColorPos, false);
    }

    protected SpiceGradientFillingRadial() {
    }

    @Override
    public abstract SpiceGradientFillingRadial<T> copyDeeply();
}
