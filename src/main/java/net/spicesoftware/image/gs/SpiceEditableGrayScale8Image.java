package net.spicesoftware.image.gs;

import net.spicesoftware.api.image.gs.EditableGrayScale8Image;
import net.spicesoftware.api.decoration.fill.GrayScale8Color;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.api.util.vector.Vector2i;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * @since 2015/03/19
 */
public final class SpiceEditableGrayScale8Image extends SpiceGrayScale8Image implements EditableGrayScale8Image {

    public SpiceEditableGrayScale8Image(Vector2i vector2i) {
        super(vector2i);
    }

    public SpiceEditableGrayScale8Image(Vector2i vector2i, byte backgroundColor) {
        super(vector2i, backgroundColor);
    }

    public SpiceEditableGrayScale8Image(Vector2i vector2i, @Size(min = 1) byte[] data) {
        super(vector2i, data);
    }

    public SpiceEditableGrayScale8Image(@Min(1) int width, @Min(1) int height) throws IllegalArgumentException {
        super(width, height);
    }

    public SpiceEditableGrayScale8Image(@Min(1) int width, @Min(1) int height, byte backgroundColor) throws IllegalArgumentException {
        super(width, height, backgroundColor);
    }

    public SpiceEditableGrayScale8Image(@Min(1) int width, @Min(1) int height, @Size(min = 1) byte[] data) throws IllegalArgumentException {
        super(width, height, data);
    }

    @Override
    public void setColor(@Min(0) int x, @Min(0) int y, @Min(0) @Max(0xFF) int color) {
        validatePosition(x, y);
        if (color < 0 || color > 0xFF)
            throw new IllegalArgumentException();

        this.data[width * y + x] = (byte) color;
    }

    @Override
    public void setColor(Vector2i position, @Min(0) @Max(0xFF) int color) {
        setColor(position.x, position.y, color);
    }

    @Override
    public void setColor(@Min(0) int x, @Min(0) int y, @Min(-128) @Max(127) byte color) {
        validatePosition(x, y);
        this.data[width * y + x] = color;
    }

    @Override
    public void setColor(Vector2i position, @Min(-128) @Max(127) byte color) {
        setColor(position.x, position.y, color);
    }

    @Override
    public void setColor(@Min(0) int x, @Min(0) int y, GrayScale8Color color) {
        validatePosition(x, y);
        this.data[width * y + x] = (byte) color.whiteness;
    }

    @Override
    public void setColor(Vector2i position, GrayScale8Color color) {
        setColor(position.x, position.y, color);
    }

    @Override
    public SpiceCachedGrayScale8Image makeImage() {
        return new SpiceCachedGrayScale8Image(width, height, data);
    }

    @Override
    public SpiceEditableGrayScale8Image copyDeeply() {
        return new SpiceEditableGrayScale8Image(width, height, data);
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}
