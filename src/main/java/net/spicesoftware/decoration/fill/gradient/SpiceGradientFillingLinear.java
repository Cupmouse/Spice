package net.spicesoftware.decoration.fill.gradient;

import net.spicesoftware.api.decoration.fill.Color;

import java.util.Map;

/**
 * 円形グラデーションです。
 *
 * @since 2015/02/01
 */

public abstract class SpiceGradientFillingLinear<T extends Color> extends SpiceColorStopGradientFilling<T> {

    protected SpiceGradientFillingLinear(Map<Integer, T> colorStopMap, boolean repeating) {
        super(colorStopMap, repeating);
    }

    protected SpiceGradientFillingLinear(SpiceGradientFillingLinear<T> copyFrom) {
        super(copyFrom);
    }

    @Override
    public abstract SpiceGradientFillingLinear<T> copyDeeply();
}
