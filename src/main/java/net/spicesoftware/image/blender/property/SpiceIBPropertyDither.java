package net.spicesoftware.image.blender.property;

import net.spicesoftware.api.image.blender.property.IBPropertyDither;

/**
 * @since 2015/09/13
 */
public final class SpiceIBPropertyDither implements IBPropertyDither {

    private final int opacity;
    private final int seed;

    public SpiceIBPropertyDither(int opacity, int seed) {
        this.opacity = opacity;
        this.seed = seed;
    }

    @Override
    public int getOpacity() {
        return opacity;
    }

    @Override
    public int getSeed() {
        return seed;
    }
}
