package net.spicesoftware.image.blender.property;

import net.spicesoftware.api.image.blender.property.IBPropertyOpacity;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.api.util.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @since 2015/09/13
 */
public final class SpiceIBPropertyOpacity implements IBPropertyOpacity {

    @ToString
    private final int opacity;

    public SpiceIBPropertyOpacity(@Min(0) @Max(1000) int opacity) {
        this.opacity = opacity;
    }

    @Override
    public int getOpacity() {
        return opacity;
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}
