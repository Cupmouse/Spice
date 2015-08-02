package net.spicesoftware.image.rgb;

import net.spicesoftware.api.image.rgb.CachedRGBImage;
import net.spicesoftware.api.image.rgb.EditableRGBImage;
import net.spicesoftware.api.util.decoration.fill.color.RGB24Color;
import net.spicesoftware.api.util.vector.Vector2i;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @since 2015/03/19
 */
public final class SpiceEditableRGBImage extends SpiceRGBIntImage implements EditableRGBImage {

    public SpiceEditableRGBImage(int width, int height) {
        super(width, height);
    }

    public SpiceEditableRGBImage(int width, int height, int backgroundColor) {
        super(width, height, backgroundColor);
    }

    public SpiceEditableRGBImage(int width, int height, int[] data) {
        super(width, height, data);
    }

    @Override
    public void setColor(@Min(0) int x, @Min(0) int y, @Min(0) @Max(0xFFFFFF) int color) {
        validatePosition(x, y);
        if (color < 0 || color > 0xFFFFFF)
            throw new IllegalArgumentException();

        this.data[width * y + x] = color;
    }

    @Override
    public void setColor(Vector2i position, @Min(0) @Max(0xFFFFFF) int color) {
        setColor(position.x, position.y, color);
    }

    @Override
    public void setColor(@Min(0) int x, @Min(0) int y, RGB24Color color) {
        validatePosition(x, y);
        this.data[width * y + x] = color.toRGB24Int();
    }

    @Override
    public void setColor(Vector2i position, RGB24Color color) {
        setColor(position.x, position.y, color);
    }

    @Override
    public CachedRGBImage makeImage() {
        return new SpiceCachedRGBImage(width, height, data);
    }

    @Override
    public SpiceEditableRGBImage copyDeeply() {
        return new SpiceEditableRGBImage(width, height, data);
    }
}
