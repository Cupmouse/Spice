package net.spicesoftware.image;

import net.spicesoftware.api.image.Image;
import net.spicesoftware.api.util.vector.Vector2i;

/**
 * @since 2015/03/19
 */
public abstract class SpiceImage implements Image {

    public final int width;
    public final int height;

    public SpiceImage(int width, int height) {
        this.width = width;
        this.height = height;
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException();
    }

    protected void validatePosition(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height)
            throw new IllegalArgumentException();
    }

    @Override
    public Vector2i getSize() {
        return new Vector2i(width, height);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
