package net.spicesoftware.registry;

import net.spicesoftware.api.image.blender.property.IBPropertyDither;
import net.spicesoftware.api.image.blender.property.IBPropertyOpacity;
import net.spicesoftware.api.registry.ImageBlenderPropertyCreator;
import net.spicesoftware.image.blender.property.SpiceIBPropertyDither;
import net.spicesoftware.image.blender.property.SpiceIBPropertyOpacity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @since 2015/11/14
 */
public final class SpiceImageBlenderPropertyCreator implements ImageBlenderPropertyCreator {

    @Override
    public IBPropertyOpacity opacity(@Min(0) @Max(1000) int opacity) {
        return new SpiceIBPropertyOpacity(opacity);
    }

    @Override
    public IBPropertyDither dither(IBPropertyOpacity propertyOpacity, int seed) {
        return new SpiceIBPropertyDither(propertyOpacity, seed);
    }

    @Override
    public IBPropertyDither dither(@Min(0) @Max(1000) int opacity, int seed) {
        return new SpiceIBPropertyDither(opacity(opacity), seed);
    }
}
