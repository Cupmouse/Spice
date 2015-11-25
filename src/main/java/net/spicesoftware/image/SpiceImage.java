package net.spicesoftware.image;

import net.spicesoftware.api.image.Image;
import net.spicesoftware.api.util.ToString;
import net.spicesoftware.api.util.Validate;
import net.spicesoftware.api.util.vector.Vector2i;

/**
 * @since 2015/03/19
 */
public abstract class SpiceImage implements Image {

    @ToString
    public final int width;
    @ToString
    public final int height;

    public SpiceImage(Vector2i vector2i) {
        this(vector2i.x, vector2i.y);
    }

    public SpiceImage(int width, int height) {
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException();
        this.width = width;
        this.height = height;
    }

    protected void validatePosition(int x, int y) {
        Validate.position(width, height, x, y);
    }

    @Override
    public Vector2i getSize() {
        return Vector2i.v2i(width, height);
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
