package net.spicesoftware.image.gs;

import net.spicesoftware.api.image.gs.EditableGrayScaleImage;
import net.spicesoftware.api.util.decoration.fill.color.GrayScaleColor;
import net.spicesoftware.api.util.vector.Vector2i;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @since 2015/03/19
 */
public final class SpiceEditableGrayScaleImage extends SpiceGrayScaleImage implements EditableGrayScaleImage {

    public SpiceEditableGrayScaleImage(@Min(0) int width, @Min(0) int height) throws IllegalArgumentException {
        super(width, height);
    }

    public SpiceEditableGrayScaleImage(@Min(0) int width, @Min(0) int height, byte backgroundColor) throws IllegalArgumentException {
        super(width, height, backgroundColor);
    }

    public SpiceEditableGrayScaleImage(@Min(0) int width, @Min(0) int height, byte[] data) throws IllegalArgumentException {
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
    public void setColor(@Min(0) int x, @Min(0) int y, GrayScaleColor color) {
        validatePosition(x, y);
        this.data[width * y + x] = (byte) color.w;
    }

    @Override
    public void setColor(Vector2i position, GrayScaleColor color) {
        setColor(position.x, position.y, color);
    }

    @Override
    public SpiceCachedGrayScaleImage makeImage() {
        return new SpiceCachedGrayScaleImage(width, height, data);
    }

    @Override
    public SpiceEditableGrayScaleImage copyDeeply() {
        return new SpiceEditableGrayScaleImage(width, height, data);
    }
}
