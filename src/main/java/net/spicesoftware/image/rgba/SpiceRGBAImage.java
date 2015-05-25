package net.spicesoftware.image.rgba;

import net.spicesoftware.api.image.rgba.RGBAImage;
import net.spicesoftware.image.SpiceImage;

/**
 * @since 2015/03/20
 */
public abstract class SpiceRGBAImage extends SpiceImage implements RGBAImage {

    public SpiceRGBAImage(int width, int height) {
        super(width, height);
    }
}
