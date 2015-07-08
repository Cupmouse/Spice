package net.spicesoftware.decoration.fill.gradient;

import net.spicesoftware.api.decoration.fill.Color;
import net.spicesoftware.api.decoration.fill.gradient.GradientFillingLinear;

/**
 * @since 2015/07/08
 */
public abstract class SpiceGradientFillingLinear<T extends Color> extends SpiceGradientFilling<T> implements GradientFillingLinear<T> {

    public SpiceGradientFillingLinear(T firstColor, int firstColorPos, T secondColor, int secondColorPos, boolean repeat) {
        super(firstColor, firstColorPos, secondColor, secondColorPos, repeat);
    }

    public SpiceGradientFillingLinear(T firstColor, int firstColorPos, T secondColor, int secondColorPos) {
        super(firstColor, firstColorPos, secondColor, secondColorPos);
    }

    protected SpiceGradientFillingLinear() {
    }

    @Override
    public abstract SpiceGradientFillingLinear<T> copyDeeply();
}
