package net.spicesoftware.image.rgba;

import net.spicesoftware.api.image.rgba.CachedRGBAImage;
import net.spicesoftware.api.image.rgba.EditableRGBAImage;
import net.spicesoftware.api.util.color.RGBA32Color;
import net.spicesoftware.api.util.vector.Vector2i;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @since 2015/03/20
 */
public final class SpiceEditableRGBAImage extends SpiceRGBAIntImage implements EditableRGBAImage {

    public SpiceEditableRGBAImage(int width, int height) {
        super(width, height);
    }

    public SpiceEditableRGBAImage(int width, int height, int backgroundColor) {
        super(width, height, backgroundColor);
    }

    public SpiceEditableRGBAImage(int width, int height, int[] data) {
        super(width, height, data);
    }

    @Override
    public void setColor(@Min(0) int x, @Min(0) int y, @Min(0) @Max(0xFFFFFF) int color, @Min(0) @Max(0xFF) int transparent) {
        validPosition(x, y);
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
        validPosition(x, y);
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
        validPosition(x, y);
        this.data[width * y + x] = color;
    }

    @Override
    public void setColor(Vector2i position, @Min(-2147483648) @Max(2147483647) int color) {
        setColor(position.x, position.y, color);
    }

    @Override
    public void setColor(@Min(0) int x, @Min(0) int y, RGBA32Color color) {
        validPosition(x, y);
        this.data[width * y + x] = color.getIntValue();
    }

    @Override
    public void setColor(Vector2i position, RGBA32Color color) {
        setColor(position.x, position.y, color);
    }

    @Override
    public CachedRGBAImage makeImage() {
        return new SpiceCachedRGBAImage(width, height, data);
    }

    @Override
    public EditableRGBAImage copyDeeply() {
        return new SpiceEditableRGBAImage(width, height, data);
    }
}
