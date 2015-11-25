package net.spicesoftware.image.rgba;

import net.spicesoftware.api.image.rgba.CachedRGBA32Image;
import net.spicesoftware.api.image.rgba.EditableRGBA32Image;
import net.spicesoftware.api.decoration.fill.RGBA32Color;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.api.util.vector.Vector2i;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * @since 2015/03/20
 */
public final class SpiceEditableRGBA32Image extends SpiceRGBAInt32Image implements EditableRGBA32Image {

    public SpiceEditableRGBA32Image(Vector2i vector2i) {
        super(vector2i);
    }

    public SpiceEditableRGBA32Image(Vector2i vector2i, int backgroundColor) {
        super(vector2i, backgroundColor);
    }

    public SpiceEditableRGBA32Image(Vector2i vector2i, @Size(min = 1) int[] data) {
        super(vector2i, data);
    }

    public SpiceEditableRGBA32Image(@Min(1) int width, @Min(1) int height) {
        super(width, height);
    }

    public SpiceEditableRGBA32Image(@Min(1) int width, @Min(1) int height, int backgroundColor) {
        super(width, height, backgroundColor);
    }

    public SpiceEditableRGBA32Image(@Min(1) int width, @Min(1) int height, @Size(min = 1) int[] data) {
        super(width, height, data);
    }

    @Override
    public void setColor(@Min(0) int x, @Min(0) int y, @Min(0) @Max(0xFFFFFF) int color, @Min(0) @Max(0xFF) int transparent) {
        validatePosition(x, y);
        if (color < 0 || color > 0xFFFFFF)
            throw new IllegalArgumentException();
        if (transparent < 0 || transparent > 0xFF)
            throw new IllegalArgumentException();

        this.data[width * y + x] = color << 8 + transparent;
    }

    @Override
    public void setColor(Vector2i position, @Min(0) @Max(0xFFFFFF) int color, @Min(0) @Max(0xFF) int transparent) {
        setColor(position.x, position.y, color, transparent);
    }

    @Override
    public void setColor(@Min(0) int x, @Min(0) int y, @Min(0) @Max(0xFFFFFFFF) long color) {
        validatePosition(x, y);
        if (color < 0 || color > 0xFFFFFFFF)
            throw new IllegalArgumentException();

        this.data[width * y + x] = (int) color;
    }

    @Override
    public void setColor(Vector2i position, @Min(0) @Max(0xFFFFFFFF) long color) {
        setColor(position.x, position.y, color);
    }

    @Override
    public void setColor(@Min(0) int x, @Min(0) int y, @Min(-2147483648) @Max(2147483647) int color) {
        validatePosition(x, y);
        this.data[width * y + x] = color;
    }

    @Override
    public void setColor(Vector2i position, @Min(-2147483648) @Max(2147483647) int color) {
        setColor(position.x, position.y, color);
    }

    @Override
    public void setColor(@Min(0) int x, @Min(0) int y, RGBA32Color color) {
        validatePosition(x, y);
        this.data[width * y + x] = color.toRGBA32Int();
    }

    @Override
    public void setColor(Vector2i position, RGBA32Color color) {
        setColor(position.x, position.y, color);
    }

    @Override
    public CachedRGBA32Image makeImage() {
        return new SpiceCachedRGBA32Image(width, height, data);
    }

    @Override
    public EditableRGBA32Image copyDeeply() {
        return new SpiceEditableRGBA32Image(width, height, data);
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}
