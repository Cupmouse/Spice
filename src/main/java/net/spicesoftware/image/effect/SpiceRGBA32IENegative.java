package net.spicesoftware.image.effect;

import net.spicesoftware.api.image.effect.ImageEffect;
import net.spicesoftware.api.image.rgba.CachedRGBA32Image;
import net.spicesoftware.image.rgba.SpiceCachedRGBA32Image;

/**
 * @since 2015/05/08
 */
public class SpiceRGBA32IENegative implements ImageEffect<CachedRGBA32Image> {

    @Override
    public CachedRGBA32Image apply(CachedRGBA32Image image) {
        int width = image.getWidth();
        int height = image.getHeight();

        int[] data = image.getData();

        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException();
        if (width * height != data.length) {
            throw new IllegalArgumentException();
        }

        int[] applied = new int[width * height];

        for (int pos = 0; pos < data.length; pos++) {
            applied[pos] = data[pos] ^ 0xFFFFFF00;
        }

        return new SpiceCachedRGBA32Image(width, height, applied);
    }
}
