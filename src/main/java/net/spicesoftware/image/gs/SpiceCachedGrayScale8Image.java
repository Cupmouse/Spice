package net.spicesoftware.image.gs;

import net.spicesoftware.api.image.gs.CachedGrayScale8Image;
import net.spicesoftware.api.util.vector.Vector2i;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Arrays;

/**
 * @since 2015/03/19
 */
public final class SpiceCachedGrayScale8Image extends SpiceGrayScale8Image implements CachedGrayScale8Image {

    public SpiceCachedGrayScale8Image(Vector2i vector2i) {
        super(vector2i);
    }

    public SpiceCachedGrayScale8Image(Vector2i vector2i, byte backgroundColor) {
        super(vector2i, backgroundColor);
    }

    public SpiceCachedGrayScale8Image(Vector2i vector2i, @Size(min = 1) byte[] data) {
        super(vector2i, data);
    }

    public SpiceCachedGrayScale8Image(@Min(1) int width, @Min(1) int height) throws IllegalArgumentException {
        super(width, height);
    }

    public SpiceCachedGrayScale8Image(@Min(1) int width, @Min(1) int height, byte backgroundColor) throws IllegalArgumentException {
        super(width, height, backgroundColor);
    }

    public SpiceCachedGrayScale8Image(@Min(1) int width, @Min(1) int height, @Size(min = 1) byte[] data) throws IllegalArgumentException {
        super(width, height, Arrays.copyOf(data, data.length));
    }

    @Override
    public SpiceCachedGrayScale8Image copyDeeply() {
        return new SpiceCachedGrayScale8Image(width, height, data);
    }
}
