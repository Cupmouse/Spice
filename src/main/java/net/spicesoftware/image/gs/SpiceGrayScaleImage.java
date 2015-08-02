package net.spicesoftware.image.gs;

import net.spicesoftware.api.image.gs.GrayScaleImage;
import net.spicesoftware.api.image.rgb.CachedRGBImage;
import net.spicesoftware.api.image.rgba.CachedRGBAImage;
import net.spicesoftware.api.util.decoration.fill.color.GrayScaleColor;
import net.spicesoftware.api.util.vector.Vector2i;
import net.spicesoftware.image.SpiceImage;
import net.spicesoftware.image.rgba.SpiceCachedRGBAImage;

import javax.validation.constraints.Min;
import java.util.Arrays;

/**
 * @since 2015/03/19
 */
public abstract class SpiceGrayScaleImage extends SpiceImage implements GrayScaleImage {

    protected final byte[] data;

    public SpiceGrayScaleImage(@Min(0) int width, @Min(0) int height) throws IllegalArgumentException {
        super(width, height);
        this.data = new byte[width * height];
    }

    public SpiceGrayScaleImage(@Min(0) int width, @Min(0) int height, byte backgroundColor) throws IllegalArgumentException {
        super(width, height);

        // 背景画像だけの画像のデータを作成
        this.data = new byte[width * height];
        Arrays.fill(data, backgroundColor);
    }

    public SpiceGrayScaleImage(@Min(0) int width, @Min(0) int height, byte[] data) throws IllegalArgumentException {
        super(width, height);
        if (data.length != width * height)
            throw new IllegalArgumentException();

        this.data = data;
    }

    @Override
    public final GrayScaleColor getColorAt(@Min(0) int x, @Min(0) int y) {
        validatePosition(x, y);
        return new GrayScaleColor(data[width * y + x] & 0xFF);
    }

    @Override
    public final GrayScaleColor getColorAt(Vector2i position) {
        return getColorAt(position);
    }

    @Override
    public final int getColorIntAt(@Min(0) int x, @Min(0) int y) {
        validatePosition(x, y);
        return data[width * y + x] & 0xFF;
    }

    @Override
    public final int getColorIntAt(Vector2i position) {
        return getColorIntAt(position.x, position.y);
    }

    @Override
    public final int getColorByteAt(@Min(0) int x, @Min(0) int y) {
        validatePosition(x, y);
        return data[width * y + x];
    }

    @Override
    public final int getColorByteAt(Vector2i position) {
        return getColorByteAt(position.x, position.y);
    }

    @Override
    public final byte[] getData() {
        return data;
    }

    @Override
    public final CachedRGBImage toRGBImage() {
        return null;
    }

    @Override
    public final CachedRGBAImage toRGBAImage() {
        int[] rgba = new int[width * height];
        for (int pos = 0; pos < data.length; pos++) {
            int whiteness = data[pos] & 0xFF;
            rgba[pos] = whiteness << 24 | whiteness << 16 | whiteness << 8 | 0xFF;
        }
        return new SpiceCachedRGBAImage(width, height, rgba);
    }
}
