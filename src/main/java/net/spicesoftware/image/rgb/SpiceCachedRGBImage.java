package net.spicesoftware.image.rgb;

import net.spicesoftware.api.image.rgb.CachedRGBImage;

import java.util.Arrays;

/**
 * @since 2015/03/19
 */
public final class SpiceCachedRGBImage extends SpiceRGBIntImage implements CachedRGBImage {

    public SpiceCachedRGBImage(int width, int height) {
        super(width, height);
    }

    public SpiceCachedRGBImage(int width, int height, int backgroundColor) {
        super(width, height, backgroundColor);
    }

    public SpiceCachedRGBImage(int width, int height, int[] data) {
        super(width, height, Arrays.copyOf(data, data.length));
    }

    @Override
    public SpiceCachedRGBImage copyDeeply() {
        return new SpiceCachedRGBImage(width, height, data);
    }
}
