package net.spicesoftware.decoration.fill;

import net.spicesoftware.api.image.CachedImage;
import net.spicesoftware.api.image.Image;
import net.spicesoftware.api.decoration.fill.ImagePatternFilling;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.api.util.ToString;
import net.spicesoftware.api.util.vector.Vector2i;

import static net.spicesoftware.api.util.Validate.nullNot;

/**
 * 画像の繰り返しのパターンです。
 *
 * @since 2015/01/26
 */
public final class SpiceImagePatternFilling implements ImagePatternFilling {

    @ToString
    private final CachedImage image;
    @ToString
    private final int offsetX;
    @ToString
    private final int offsetY;

    protected SpiceImagePatternFilling(CachedImage image, int offsetX, int offsetY) {
        nullNot(image);
        this.image = image;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    protected SpiceImagePatternFilling(CachedImage image, Vector2i offset) {
        nullNot(image, offset);
        this.image = image;
        this.offsetX = offset.x;
        this.offsetY = offset.y;
    }

    @Override
    public CachedImage getImage() {
        return image;
    }

    @Override
    public Vector2i getOffset() {
        return Vector2i.v2i(offsetX, offsetY);
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
    public ImagePatternFilling copyDeeply() {
        return new SpiceImagePatternFilling(image.copyDeeply(), offsetX, offsetY);
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}
