package net.spicesoftware.image.rgb;

import net.spicesoftware.api.image.gs.CachedGrayScaleImage;
import net.spicesoftware.api.image.rgba.CachedRGBAImage;
import net.spicesoftware.api.util.decoration.fill.color.RGB24Color;
import net.spicesoftware.api.util.vector.Vector2i;
import net.spicesoftware.image.gs.SpiceCachedGrayScaleImage;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Arrays;

/**
 * @since 2015/03/19
 */
public abstract class SpiceRGBIntImage extends SpiceRGBImage {

    protected final int[] data;

    public SpiceRGBIntImage(@Min(0) int width, @Min(0) int height) {
        super(width, height);
        this.data = new int[width * height];
    }

    public SpiceRGBIntImage(@Min(0) int width, @Min(0) int height, @Min(0) @Max(0xFFFFFF) int backgroundColor) {
        super(width, height);
        if (backgroundColor < 0 || backgroundColor > 0xFFFFFF)
            throw new IllegalArgumentException();

        // 背景画像だけの画像のデータを作成
        this.data = new int[width * height];
        Arrays.fill(data, backgroundColor);
    }

    public SpiceRGBIntImage(@Min(0) int width, @Min(0) int height, int[] data) {
        super(width, height);
        if (data.length != width * height)
            throw new IllegalArgumentException();

        // データーにありえない値が含まれているかチェック
        for (int i = 0; i < data.length; i++) {
            if (data[i] < 0 || data[i] > 0xFFFFFF) {
                throw new IllegalArgumentException();
            }
        }

        this.data = data;
    }

    @Override
    public final RGB24Color getColorAt(@Min(0) int x, @Min(0) int y) {
        validatePosition(x, y);
        return new RGB24Color(data[width * y + x]);
    }

    @Override
    public final RGB24Color getColorAt(Vector2i position) {
        return getColorAt(position.x, position.y);
    }

    @Override
    public final int getColorIntAt(@Min(0) int x, @Min(0) int y) {
        validatePosition(x, y);
        return data[width * y + x];
    }

    @Override
    public final int getColorIntAt(Vector2i position) {
        return getColorIntAt(position.x, position.y);
    }

    @Override
    public final int[] getData() {
        return data;
    }

    @Override
    public final CachedGrayScaleImage extractChannelR() {
        byte[] gsdata = new byte[data.length];
        for (int i = 0; i < data.length; i++)
            gsdata[i] = (byte) (data[i] >>> 16);
        return new SpiceCachedGrayScaleImage(width, height, gsdata);
    }

    @Override
    public final CachedGrayScaleImage extractChannelG() {
        byte[] gsdata = new byte[data.length];
        for (int i = 0; i < data.length; i++)
            gsdata[i] = (byte) (data[i] >>> 8);
        return new SpiceCachedGrayScaleImage(width, height, gsdata);
    }

    @Override
    public final CachedGrayScaleImage extractChannelB() {
        byte[] gsdata = new byte[data.length];
        for (int i = 0; i < data.length; i++)
            gsdata[i] = (byte) (data[i]);
        return new SpiceCachedGrayScaleImage(width, height, gsdata);
    }

    @Override
    public final CachedRGBAImage toRGBAImage() {
        return null;
    }

    @Override
    public final CachedGrayScaleImage toGrayScaleImage() {
        return null;
    }
}
