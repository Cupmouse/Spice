package net.spicesoftware.image.rgba;

import net.spicesoftware.api.image.gs.CachedGrayScale8Image;
import net.spicesoftware.api.image.gs.EditableGrayScale8Image;
import net.spicesoftware.api.image.rgb.CachedRGB24Image;
import net.spicesoftware.api.image.rgba.CachedRGBA32Image;
import net.spicesoftware.api.image.rgba.EditableRGBA32Image;
import net.spicesoftware.api.util.decoration.fill.color.RGBA32Color;
import net.spicesoftware.api.util.vector.Vector2i;
import net.spicesoftware.image.gs.SpiceEditableGrayScale8Image;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Arrays;

/**
 * @since 2015/03/20
 */
public final class SpiceEditableCSRGBA32Image extends SpiceRGBA32Image implements EditableRGBA32Image {

    private EditableGrayScale8Image channelR;
    private EditableGrayScale8Image channelG;
    private EditableGrayScale8Image channelB;
    private EditableGrayScale8Image channelA;

    public SpiceEditableCSRGBA32Image(Vector2i vector2i) {
        this(vector2i.x, vector2i.y);
    }

    public SpiceEditableCSRGBA32Image(Vector2i vector2i, int backgroundColor) {
        this(vector2i.x, vector2i.y, backgroundColor);
    }

    public SpiceEditableCSRGBA32Image(Vector2i vector2i, EditableGrayScale8Image channelR, EditableGrayScale8Image channelG, EditableGrayScale8Image channelB, EditableGrayScale8Image channelA) {
        this(vector2i.x, vector2i.y, channelR, channelG, channelB, channelA);
    }

    public SpiceEditableCSRGBA32Image(@Min(1) int width, @Min(1) int height) {
        super(width, height);

        byte[] data = new byte[width * height];
        Arrays.fill(data, (byte) 0xFF);

        this.channelR = new SpiceEditableGrayScale8Image(width, height, data);
        this.channelG = channelR.copyDeeply();
        this.channelB = channelR.copyDeeply();
        this.channelA = channelR.copyDeeply();
    }

    public SpiceEditableCSRGBA32Image(@Min(1) int width, @Min(1) int height, int backgroundColor) {
        super(width, height);

        this.channelR = new SpiceEditableGrayScale8Image(width, height, (byte) (backgroundColor >>> 24));
        this.channelG = new SpiceEditableGrayScale8Image(width, height, (byte) (backgroundColor >>> 16));
        this.channelB = new SpiceEditableGrayScale8Image(width, height, (byte) (backgroundColor >>> 8));
        this.channelA = new SpiceEditableGrayScale8Image(width, height, (byte) backgroundColor);
    }

    public SpiceEditableCSRGBA32Image(@Min(1) int width, @Min(1) int height, EditableGrayScale8Image channelR, EditableGrayScale8Image channelG, EditableGrayScale8Image channelB, EditableGrayScale8Image channelA) {
        super(width, height);

        this.channelR = channelR;
        this.channelG = channelG;
        this.channelB = channelB;
        this.channelA = channelA;
    }

    @Override
    public void setColor(@Min(0) int x, @Min(0) int y, @Min(0) @Max(0xFFFFFF) int color, @Min(0) @Max(0xFF) int transparent) {
        validatePosition(x, y);
        if (color < 0 || color > 0xFFFFFF)
            throw new IllegalArgumentException();
        if (transparent < 0 || transparent > 0xFF)
            throw new IllegalArgumentException();

        this.channelR.setColor(x, y, ((byte) (color >>> 16)));
        this.channelG.setColor(x, y, ((byte) (color >>> 8)));
        this.channelB.setColor(x, y, ((byte) color));
        this.channelA.setColor(x, y, ((byte) transparent));
    }

    @Override
    public void setColor(Vector2i position, @Min(0) @Max(0xFFFFFF) int color, @Min(0) @Max(0xFF) int transparent) {
        setColor(position.x, position.y, color, transparent);
    }

    @Override
    public void setColor(@Min(0) int x, @Min(0) int y, @Min(0) @Max(0xFFFFFFFF) long color) {
        validatePosition(x, y);
        if (color < 0 || color > 0xFFFFFFFF)
            throw new IllegalArgumentException();

        this.channelR.setColor(x, y, ((byte) (color >>> 24)));
        this.channelG.setColor(x, y, ((byte) (color >>> 16)));
        this.channelB.setColor(x, y, ((byte) (color >>> 8)));
        this.channelA.setColor(x, y, ((byte) color));
    }

    @Override
    public void setColor(Vector2i position, @Min(0) @Max(0xFFFFFFFF) long color) {
        setColor(position.x, position.y, color);
    }

    @Override
    public void setColor(@Min(0) int x, @Min(0) int y, @Min(-2147483648) @Max(2147483647) int color) {
        validatePosition(x, y);
        this.channelR.setColor(x, y, ((byte) (color >>> 24)));
        this.channelG.setColor(x, y, ((byte) (color >>> 16)));
        this.channelB.setColor(x, y, ((byte) (color >>> 8)));
        this.channelA.setColor(x, y, ((byte) color));
    }

    @Override
    public void setColor(Vector2i position, @Min(-2147483648) @Max(2147483647) int color) {
        setColor(position.x, position.y, color);
    }

    @Override
    public void setColor(@Min(0) int x, @Min(0) int y, RGBA32Color color) {
        validatePosition(x, y);
        this.channelR.setColor(x, y, ((byte) color.r));
        this.channelG.setColor(x, y, ((byte) color.g));
        this.channelB.setColor(x, y, ((byte) color.b));
        this.channelA.setColor(x, y, ((byte) color.a));
    }

    @Override
    public void setColor(Vector2i position, RGBA32Color color) {
        setColor(position.x, position.y, color);
    }

    @Override
    public CachedRGBA32Image makeImage() {
        return new SpiceCachedRGBA32Image(width, height, getData());
    }

    @Override
    public RGBA32Color getColorAt(@Min(0) int x, @Min(0) int y) {
        validatePosition(x, y);
        return new RGBA32Color(channelR.getColorIntAt(x, y), channelG.getColorIntAt(x, y), channelB.getColorIntAt(x, y), channelA.getColorIntAt(x, y));
    }

    @Override
    public RGBA32Color getColorAt(Vector2i position) {
        return getColorAt(position.x, position.y);
    }

    @Override
    public long getColorLongAt(@Min(0) int x, @Min(0) int y) {
        validatePosition(x, y);
        return channelR.getColorIntAt(x, y) << 24 | channelG.getColorIntAt(x, y) << 16 | channelB.getColorIntAt(x, y) << 8 | channelA.getColorIntAt(x, y);
    }

    @Override
    public long getColorLongAt(Vector2i position) {
        return getColorLongAt(position.x, position.y);
    }

    @Override
    public int getColorIntAt(@Min(0) int x, @Min(0) int y) {
        return (int) getColorLongAt(x, y);
    }

    @Override
    public int getColorIntAt(Vector2i position) {
        return (int) getColorLongAt(position);
    }

    @Override
    public int[] getData() {
        int[] data = new int[width * height];
        byte[] rdata = channelR.getData();
        byte[] gdata = channelG.getData();
        byte[] bdata = channelB.getData();
        byte[] adata = channelA.getData();

        for (int i = 0; i < data.length; i++)
            data[i] = rdata[i] & 0xFF << 24 | gdata[i] & 0xFF << 16 | bdata[i] & 0xFF << 8 | adata[i] & 0xFF;

        return data;
    }

    @Override
    public CachedGrayScale8Image extractChannelR() {
        return channelR.makeImage();
    }

    @Override
    public CachedGrayScale8Image extractChannelG() {
        return channelG.makeImage();
    }

    @Override
    public CachedGrayScale8Image extractChannelB() {
        return channelB.makeImage();
    }

    @Override
    public CachedGrayScale8Image extractChannelA() {
        return channelA.makeImage();
    }

    @Override
    public EditableRGBA32Image copyDeeply() {
        return new SpiceEditableCSRGBA32Image(width, height, channelR.copyDeeply(), channelG.copyDeeply(), channelB.copyDeeply(), channelA.copyDeeply());
    }
}
