package net.spicesoftware.image.blender.property;

import net.spicesoftware.api.image.blender.property.IBPropertyDither;
import net.spicesoftware.api.image.blender.property.IBPropertyOpacity;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.api.util.ToString;
import net.spicesoftware.api.util.Validate;

/**
 * @since 2015/09/13
 */
public final class SpiceIBPropertyDither implements IBPropertyDither {

    @ToString
    private final IBPropertyOpacity opacityProperty;
    @ToString
    private final int seed;

    public SpiceIBPropertyDither(IBPropertyOpacity opacityProperty, int seed) {
        Validate.nullNot(opacityProperty);
        this.opacityProperty = opacityProperty;
        this.seed = seed;
    }

    @Override
    public IBPropertyOpacity getOpacityProperty() {
        return opacityProperty;
    }

    @Override
    public int getSeed() {
        return seed;
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}
