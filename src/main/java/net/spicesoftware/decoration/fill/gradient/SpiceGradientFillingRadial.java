package net.spicesoftware.decoration.fill.gradient;

import net.spicesoftware.api.decoration.fill.Color;
import net.spicesoftware.api.decoration.fill.gradient.GradientFillingRadial;
import net.spicesoftware.api.util.ToString;
import net.spicesoftware.api.util.vector.Vector2i;

import java.util.Map;

import static net.spicesoftware.api.util.Validate.nullNot;
import static net.spicesoftware.api.util.vector.Vector2i.v2i;

/**
 * 円形グラデーションです。
 *
 * @since 2015/02/01
 */
public abstract class SpiceGradientFillingRadial<T extends Color> extends SpiceColorStopGradientFilling<T> implements GradientFillingRadial<T> {

    @ToString
    private final int centerPosX;
    @ToString
    private final int centerPosY;

    protected SpiceGradientFillingRadial(Map<Integer, T> colorStopMap, boolean repeating, int centerPosX, int centerPosY) {
        super(colorStopMap, repeating);
        this.centerPosX = centerPosX;
        this.centerPosY = centerPosY;
    }

    protected SpiceGradientFillingRadial(SpiceGradientFillingRadial<T> copyFrom) {
        super(copyFrom);
        this.centerPosX = copyFrom.centerPosX;
        this.centerPosY = copyFrom.centerPosY;
    }

    @Override
    public Vector2i getRadialCenter() {
        return v2i(centerPosX, centerPosY);
    }

    @Override
    public int getRadialCenterX() {
        return centerPosX;
    }

    @Override
    public int getRadialCenterY() {
        return centerPosY;
    }

    @Override
    public abstract SpiceGradientFillingRadial<T> copyDeeply();
}
