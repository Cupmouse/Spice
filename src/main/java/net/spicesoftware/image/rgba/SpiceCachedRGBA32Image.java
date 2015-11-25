package net.spicesoftware.image.rgba;

import net.spicesoftware.api.image.rgba.CachedRGBA32Image;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.api.util.vector.Vector2i;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * @since 2015/03/20
 */
public final class SpiceCachedRGBA32Image extends SpiceRGBAInt32Image implements CachedRGBA32Image {

    public SpiceCachedRGBA32Image(Vector2i vector2i) {
        super(vector2i);
    }

    public SpiceCachedRGBA32Image(Vector2i vector2i, int backgroundColor) {
        super(vector2i, backgroundColor);
    }

    public SpiceCachedRGBA32Image(Vector2i vector2i, @Size(min = 1) int[] data) {
        super(vector2i, data);
    }

    public SpiceCachedRGBA32Image(@Min(1) int width, @Min(1) int height) {
        super(width, height);
    }

    public SpiceCachedRGBA32Image(@Min(1) int width, @Min(1) int height, int backgroundColor) {
        super(width, height, backgroundColor);
    }

    public SpiceCachedRGBA32Image(@Min(1) int width, @Min(1) int height, @Size(min = 1) int[] data) {
        super(width, height, data);
    }

    @Override
    public CachedRGBA32Image copyDeeply() {
        return new SpiceCachedRGBA32Image(width, height, data);
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}
