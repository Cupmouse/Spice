package net.spicesoftware.image.rgba;

import net.spicesoftware.api.image.gs.CachedGrayScale8Image;
import net.spicesoftware.api.decoration.fill.RGBA32Color;
import net.spicesoftware.api.util.ToString;
import net.spicesoftware.api.util.vector.Vector2i;
import net.spicesoftware.image.gs.SpiceCachedGrayScale8Image;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Arrays;

/**
 * @since 2015/03/20
 */
public abstract class SpiceRGBAInt32Image extends SpiceRGBA32Image {

    @ToString
    protected final int[] data;

    public SpiceRGBAInt32Image(Vector2i vector2i) {
        this(vector2i.x, vector2i.y);
    }

    public SpiceRGBAInt32Image(Vector2i vector2i, int backgroundColor) {
        this(vector2i.x, vector2i.y, backgroundColor);
    }

    public SpiceRGBAInt32Image(Vector2i vector2i, @Size(min = 1) int[] data) {
        this(vector2i.x, vector2i.y, data);
    }

    public SpiceRGBAInt32Image(@Min(1) int width, @Min(1) int height) {
        super(width, height);

        // 画像のデータを作成（0x00000000なので、透明）
        this.data = new int[width * height];
    }

    public SpiceRGBAInt32Image(@Min(1) int width, @Min(1) int height, int backgroundColor) {
        super(width, height);

        // 背景画像だけの画像のデータを作成
        this.data = new int[width * height];
        Arrays.fill(data, backgroundColor);
    }

    public SpiceRGBAInt32Image(@Min(1) int width, @Min(1) int height, @Size(min = 1) int[] data) {
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
    public final CachedGrayScale8Image extractChannelR() {
        byte[] gsdata = new byte[data.length];
        for (int i = 0; i < data.length; i++)
            gsdata[i] = (byte) (data[i] >>> 24);
        return new SpiceCachedGrayScale8Image(width, height, gsdata);
    }

    @Override
    public final CachedGrayScale8Image extractChannelG() {
        byte[] gsdata = new byte[data.length];
        for (int i = 0; i < data.length; i++)
            gsdata[i] = (byte) (data[i] >>> 16);
        return new SpiceCachedGrayScale8Image(width, height, gsdata);
    }

    @Override
    public final CachedGrayScale8Image extractChannelB() {
        byte[] gsdata = new byte[data.length];
        for (int i = 0; i < data.length; i++)
            gsdata[i] = (byte) (data[i] >>> 8);
        return new SpiceCachedGrayScale8Image(width, height, gsdata);
    }

    @Override
    public final CachedGrayScale8Image extractChannelA() {
        byte[] gsdata = new byte[data.length];
        for (int i = 0; i < data.length; i++)
            gsdata[i] = (byte) (data[i]);
        return new SpiceCachedGrayScale8Image(width, height, gsdata);
    }
}
