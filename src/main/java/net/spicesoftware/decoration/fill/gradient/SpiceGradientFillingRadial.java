package net.spicesoftware.decoration.fill.gradient;

import net.spicesoftware.api.decoration.fill.Color;
import net.spicesoftware.api.util.ToString;

import java.util.Map;

import static net.spicesoftware.api.util.Validate.nullNot;

/**
 * 円形グラデーションです。
 *
 * @since 2015/02/01
 */
public abstract class SpiceGradientFillingRadial<T extends Color> extends SpiceColorStopGradientFilling<T> {

    @ToString
    private final int centerXPos;
    @ToString
    private final int centerYPos;

    public SpiceGradientFillingRadial(Map<Integer, T> colorStopMap, boolean repeating, int centerXPos, int centerYPos) {
        super(colorStopMap, repeating);
        this.centerXPos = centerXPos;
        this.centerYPos = centerYPos;
    }

    public SpiceGradientFillingRadial(SpiceGradientFillingRadial<T> copyFrom) {
        super(copyFrom);
        this.centerXPos = copyFrom.centerXPos;
        this.centerYPos = copyFrom.centerYPos;
    }

    @Override
    public abstract SpiceGradientFillingRadial<T> copyDeeply();
}
