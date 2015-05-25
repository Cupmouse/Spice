package net.spicesoftware.image.gs;

import net.spicesoftware.api.image.gs.CachedGrayScaleImage;

import javax.validation.constraints.Min;
import java.util.Arrays;

/**
 * @since 2015/03/19
 */
public final class SpiceCachedGrayScaleImage extends SpiceGrayScaleImage implements CachedGrayScaleImage {

    public SpiceCachedGrayScaleImage(@Min(0) int width, @Min(0) int height) throws IllegalArgumentException {
        super(width, height);
    }

    public SpiceCachedGrayScaleImage(@Min(0) int width, @Min(0) int height, byte backgroundColor) throws IllegalArgumentException {
        super(width, height, backgroundColor);
    }

    public SpiceCachedGrayScaleImage(@Min(0) int width, @Min(0) int height, byte[] data) throws IllegalArgumentException {
        super(width, height, Arrays.copyOf(data, data.length));
    }

    @Override
    public SpiceCachedGrayScaleImage copyDeeply() {
        return new SpiceCachedGrayScaleImage(width, height, data);
    }
}
