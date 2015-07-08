package net.spicesoftware.image.rgba;

import net.spicesoftware.api.image.gs.CachedGrayScaleImage;
import net.spicesoftware.api.image.rgb.CachedRGBImage;
import net.spicesoftware.api.util.decoration.fill.color.RGBA32Color;
import net.spicesoftware.api.util.vector.Vector2i;
import net.spicesoftware.image.gs.SpiceCachedGrayScaleImage;

import javax.validation.constraints.Min;
import java.util.Arrays;

/**
 * @since 2015/03/20
 */
public abstract class SpiceRGBAIntImage extends SpiceRGBAImage {

    protected final int[] data;

    public SpiceRGBAIntImage(@Min(0) int width, @Min(0) int height) {
        super(width, height);
        // 画像のデータを作成（0x00000000なので、透明）
        this.data = new int[width * height];
    }

    public SpiceRGBAIntImage(@Min(0) int width, @Min(0) int height, int backgroundColor) {
        super(width, height);

        // 背景画像だけの画像のデータを作成
        this.data = new int[width * height];
        Arrays.fill(data, backgroundColor);
    }

    public SpiceRGBAIntImage(@Min(0) int width, @Min(0) int height, int[] data) {
        super(width, height);
        if (data.length != width * height)
            throw new IllegalArgumentException();

        this.data = data;
    }

    @Override
    public final RGBA32Color getColorAt(@Min(0) int x, @Min(0) int y) {
        return new RGBA32Color(data[width * y + x]);
    }

    @Override
    public final RGBA32Color getColorAt(Vector2i position) {
        return new RGBA32Color(data[width * position.x + position.y]);
    }

    @Override
    public final long getColorLongAt(@Min(0) int x, @Min(0) int y) {
        return data[width * y + x] & 0xFFFFFFFFL;
    }

    @Override
    public final long getColorLongAt(Vector2i position) {
        return data[width * position.x + position.y] & 0xFFFFFFFFL;
    }

    @Override
    public final int getColorIntAt(@Min(0) int x, @Min(0) int y) {
        return data[width * y + x];
    }

    @Override
    public final int getColorIntAt(Vector2i position) {
        return data[width * position.x + position.y];
    }

    @Override
    public final int[] getData() {
        return data;
    }

    @Override
    public final CachedGrayScaleImage extractChannelR() {
        byte[] gsdata = new byte[data.length];
        for (int i = 0; i < data.length; i++)
            gsdata[i] = (byte) (data[i] >>> 24);
        return new SpiceCachedGrayScaleImage(width, height, gsdata);
    }

    @Override
    public final CachedGrayScaleImage extractChannelG() {
        byte[] gsdata = new byte[data.length];
        for (int i = 0; i < data.length; i++)
            gsdata[i] = (byte) (data[i] >>> 16);
        return new SpiceCachedGrayScaleImage(width, height, gsdata);
    }

    @Override
    public final CachedGrayScaleImage extractChannelB() {
        byte[] gsdata = new byte[data.length];
        for (int i = 0; i < data.length; i++)
            gsdata[i] = (byte) (data[i] >>> 8);
        return new SpiceCachedGrayScaleImage(width, height, gsdata);
    }

    @Override
    public final CachedGrayScaleImage extractChannelA() {
        byte[] gsdata = new byte[data.length];
        for (int i = 0; i < data.length; i++)
            gsdata[i] = (byte) (data[i]);
        return new SpiceCachedGrayScaleImage(width, height, gsdata);
    }

    @Override
    public final CachedRGBImage toRGBImage() {
        return null;
    }

    @Override
    public final CachedGrayScaleImage toGrayScaleImage() {
        return null;
    }
}
