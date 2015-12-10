package net.spicesoftware.decoration.fill.gradient;

import net.spicesoftware.api.decoration.fill.Color;
import net.spicesoftware.api.decoration.fill.gradient.GradientFillingRadial;
import net.spicesoftware.api.util.ToString;
import net.spicesoftware.api.util.vector.Vector2i;

import static net.spicesoftware.api.util.Validate.nullNot;

public abstract class SpiceGradientFillingRadialBuilder<C extends Color, T extends GradientFillingRadial<C>> extends SpiceColorStopGradientFillingBuilder<C, T> implements GradientFillingRadial.IBuilder<C, T> {

    @ToString
    protected int centerXPos;
    @ToString
    protected int centerYPos;

    @Override
    public SpiceGradientFillingRadialBuilder<C, T> radialCenter(int centerXPos, int centerYPos) {
        this.centerXPos = centerXPos;
        this.centerYPos = centerYPos;
        return this;
    }

    @Override
    public SpiceGradientFillingRadialBuilder<C, T> radialCenter(Vector2i centerPos) {
        nullNot(centerPos);
        radialCenter(centerPos.x, centerPos.y);
        return this;
    }
}