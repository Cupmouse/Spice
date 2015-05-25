package net.spicesoftware.image.rgba;

import net.spicesoftware.api.image.rgba.CachedRGBAImage;

/**
 * @since 2015/03/20
 */
public final class SpiceCachedRGBAImage extends SpiceRGBAIntImage implements CachedRGBAImage {

    public SpiceCachedRGBAImage(int width, int height) {
        super(width, height);
    }

    public SpiceCachedRGBAImage(int width, int height, int backgroundColor) {
        super(width, height, backgroundColor);
    }

    public SpiceCachedRGBAImage(int width, int height, int[] data) {
        super(width, height, data);
    }

    @Override
    public CachedRGBAImage copyDeeply() {
        return new SpiceCachedRGBAImage(width, height, data);
    }
}
