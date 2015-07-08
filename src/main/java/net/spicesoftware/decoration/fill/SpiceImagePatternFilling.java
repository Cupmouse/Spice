package net.spicesoftware.decoration.fill;

import net.spicesoftware.api.decoration.fill.ImagePatternFilling;
import net.spicesoftware.api.image.Image;
import net.spicesoftware.api.util.vector.Vector2i;

/**
 * @since 2015/07/08
 */
public class SpiceImagePatternFilling extends SpicePatternFilling implements ImagePatternFilling {

    private Image image;
    private int offsetX;
    private int offsetY;

    public SpiceImagePatternFilling(Image image, int offsetX, int offsetY) {
        this.image = image;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public SpiceImagePatternFilling(Image image, Vector2i offset) {
        this.image = image;
        this.offsetX = offset.x;
        this.offsetY = offset.y;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public Vector2i getOffset() {
        return new Vector2i(offsetX, offsetY);
    }

    @Override
    public int getOffsetX() {
        return offsetX;
    }

    @Override
    public int getOffsetY() {
        return offsetY;
    }

    @Override
    public SpiceImagePatternFilling copyDeeply() {
        return new SpiceImagePatternFilling(image.copyDeeply(), offsetX, offsetY);
    }
}
