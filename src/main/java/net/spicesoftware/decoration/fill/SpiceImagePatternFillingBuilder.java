package net.spicesoftware.decoration.fill;

import net.spicesoftware.api.decoration.fill.ImagePatternFilling;
import net.spicesoftware.api.image.CachedImage;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.api.util.ToString;
import net.spicesoftware.api.util.vector.Vector2i;

public final class SpiceImagePatternFillingBuilder implements ImagePatternFilling.Builder {

    @ToString
    private CachedImage image;
    @ToString
    private int offsetX;
    @ToString
    private int offsetY;

    @Override
    public SpiceImagePatternFillingBuilder image(CachedImage image) {
        this.image = image;
        return this;
    }

    @Override
    public SpiceImagePatternFillingBuilder offset(int offsetX, int offsetY) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        return this;
    }

    @Override
    public SpiceImagePatternFillingBuilder offset(Vector2i offset) {
        this.offsetX = offset.x;
        this.offsetY = offset.y;
        return this;
    }

    @Override
    public SpiceImagePatternFilling build() {
        return new SpiceImagePatternFilling(image, offsetX, offsetY);
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}