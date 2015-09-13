package net.spicesoftware.image.rgb;

import net.spicesoftware.api.image.rgb.CachedRGB24Image;
import net.spicesoftware.api.util.vector.Vector2i;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Arrays;

/**
 * @since 2015/03/19
 */
public final class SpiceCachedRGB24Image extends SpiceRGBInt24Image implements CachedRGB24Image {

    public SpiceCachedRGB24Image(Vector2i vector2i) {
        super(vector2i);
    }

    public SpiceCachedRGB24Image(Vector2i vector2i, @Min(0) @Max(0xFFFFFF) int backgroundColor) {
        super(vector2i, backgroundColor);
    }

    public SpiceCachedRGB24Image(Vector2i vector2i, @Size(min = 1) int[] data) {
        super(vector2i, data);
    }

    public SpiceCachedRGB24Image(@Min(1) int width, @Min(1) int height) {
        super(width, height);
    }

    public SpiceCachedRGB24Image(@Min(1) int width, @Min(1) int height, @Min(0) @Max(0xFFFFFF) int backgroundColor) {
        super(width, height, backgroundColor);
    }

    public SpiceCachedRGB24Image(@Min(1) int width, @Min(1) int height, @Size(min = 1) int[] data) {
        super(width, height, Arrays.copyOf(data, data.length));
    }

    @Override
    public SpiceCachedRGB24Image copyDeeply() {
        return new SpiceCachedRGB24Image(width, height, data);
    }
}
