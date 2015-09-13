package net.spicesoftware.image.gs;

import net.spicesoftware.api.image.gs.GrayScale8Image;
import net.spicesoftware.api.image.rgb.CachedRGB24Image;
import net.spicesoftware.api.image.rgba.CachedRGBA32Image;
import net.spicesoftware.api.util.decoration.fill.color.GrayScale8Color;
import net.spicesoftware.api.util.vector.Vector2i;
import net.spicesoftware.image.SpiceImage;
import net.spicesoftware.image.rgb.SpiceCachedRGB24Image;
import net.spicesoftware.image.rgba.SpiceCachedRGBA32Image;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Arrays;

/**
 * @since 2015/03/19
 */
public abstract class SpiceGrayScale8Image extends SpiceImage implements GrayScale8Image {

    protected final byte[] data;

    public SpiceGrayScale8Image(Vector2i vector2i) {
        this(vector2i.x, vector2i.y);
    }

    public SpiceGrayScale8Image(Vector2i vector2i, byte backgroundColor) {
        this(vector2i.x, vector2i.y, backgroundColor);
    }

    public SpiceGrayScale8Image(Vector2i vector2i, @Size(min = 1) byte[] data) {
        this(vector2i.x, vector2i.y, data);
    }

    public SpiceGrayScale8Image(@Min(1) int width, @Min(1) int height) throws IllegalArgumentException {
        super(width, height);

        this.data = new byte[width * height];
    }

    public SpiceGrayScale8Image(@Min(1) int width, @Min(1) int height, byte backgroundColor) throws IllegalArgumentException {
        super(width, height);

        // 背景画像だけの画像のデータを作成
        this.data = new byte[width * height];
        Arrays.fill(data, backgroundColor);
    }

    public SpiceGrayScale8Image(@Min(1) int width, @Min(1) int height, @Size(min = 1) byte[] data) throws IllegalArgumentException {
        super(width, height);

        if (data.length != width * height)
            throw new IllegalArgumentException();

        this.data = data;
    }

    @Override
    public final GrayScale8Color getColorAt(@Min(0) int x, @Min(0) int y) {
        validatePosition(x, y);
        return new GrayScale8Color(data[width * y + x] & 0xFF);
    }

    @Override
    public final GrayScale8Color getColorAt(Vector2i position) {
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
}
