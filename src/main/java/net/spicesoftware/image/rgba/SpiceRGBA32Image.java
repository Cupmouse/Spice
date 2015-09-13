package net.spicesoftware.image.rgba;

import net.spicesoftware.api.image.rgba.RGBA32Image;
import net.spicesoftware.api.util.vector.Vector2i;
import net.spicesoftware.image.SpiceImage;

import javax.validation.constraints.Min;

/**
 * @since 2015/03/20
 */
public abstract class SpiceRGBA32Image extends SpiceImage implements RGBA32Image {

    public SpiceRGBA32Image(Vector2i vector2i) {
        super(vector2i);
    }

    public SpiceRGBA32Image(@Min(1) int width, @Min(1) int height) {
        super(width, height);
    }
}
