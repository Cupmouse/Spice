package net.spicesoftware.image.rgb;

import net.spicesoftware.api.image.rgb.RGB24Image;
import net.spicesoftware.image.SpiceImage;

import javax.validation.constraints.Min;

/**
 * @since 2015/03/20
 */
public abstract class SpiceRGB24Image extends SpiceImage implements RGB24Image {

    public SpiceRGB24Image(@Min(1) int width, @Min(1) int height) {
        super(width, height);
    }
}
