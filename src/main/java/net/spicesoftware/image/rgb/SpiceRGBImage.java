package net.spicesoftware.image.rgb;

import net.spicesoftware.api.image.rgb.RGBImage;
import net.spicesoftware.image.SpiceImage;

/**
 * @since 2015/03/20
 */
public abstract class SpiceRGBImage extends SpiceImage implements RGBImage {

    public SpiceRGBImage(int width, int height) {
        super(width, height);
    }
}
