package net.spicesoftware.image.rgb;

import net.spicesoftware.api.image.rgb.CachedRGB24Image;
import net.spicesoftware.api.image.rgb.EditableRGB24Image;
import net.spicesoftware.api.util.decoration.fill.color.RGB24Color;
import net.spicesoftware.api.util.vector.Vector2i;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * @since 2015/03/19
 */
public final class SpiceEditableRGB24Image extends SpiceRGBInt24Image implements EditableRGB24Image {

    public SpiceEditableRGB24Image(Vector2i vector2i) {
        super(vector2i);
    }

    public SpiceEditableRGB24Image(Vector2i vector2i, @Min(0) @Max(0xFFFFFF) int backgroundColor) {
        super(vector2i, backgroundColor);
    }

    public SpiceEditableRGB24Image(Vector2i vector2i, @Size(min = 1) int[] data) {
        super(vector2i, data);
    }

    public SpiceEditableRGB24Image(@Min(1) int width, @Min(1) int height) {
        super(width, height);
    }

    public SpiceEditableRGB24Image(@Min(1) int width, @Min(1) int height, @Min(0) @Max(0xFFFFFF) int backgroundColor) {
        super(width, height, backgroundColor);
    }

    public SpiceEditableRGB24Image(@Min(1) int width, @Min(1) int height, @Size(min = 1) int[] data) {
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
    public CachedRGB24Image makeImage() {
        return new SpiceCachedRGB24Image(width, height, data);
    }

    @Override
    public SpiceEditableRGB24Image copyDeeply() {
        return new SpiceEditableRGB24Image(width, height, data);
    }
}
