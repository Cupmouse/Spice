package net.spicesoftware.image.rgb;

import net.spicesoftware.api.image.gs.CachedGrayScale8Image;
import net.spicesoftware.api.image.gs.EditableGrayScale8Image;
import net.spicesoftware.api.image.rgb.EditableCSRGB24Image;
import net.spicesoftware.api.util.decoration.fill.color.RGB24Color;
import net.spicesoftware.api.util.vector.Vector2i;
import net.spicesoftware.image.gs.SpiceCachedGrayScale8Image;
import net.spicesoftware.image.gs.SpiceEditableGrayScale8Image;
import net.spicesoftware.image.rgba.SpiceCachedRGBA32Image;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @since 2015/03/20
 */
public final class SpiceEditableCSRGB24Image extends SpiceRGB24Image implements EditableCSRGB24Image {

    private EditableGrayScale8Image channelR;
    private EditableGrayScale8Image channelG;
    private EditableGrayScale8Image channelB;

    public SpiceEditableCSRGB24Image(Vector2i vector2i) {
        this(vector2i.x, vector2i.y);
    }

    public SpiceEditableCSRGB24Image(Vector2i vector2i, @Min(0) @Max(0xFFFFFF) int backgroundColor) {
        this(vector2i.x, vector2i.y, backgroundColor);
    }

    public SpiceEditableCSRGB24Image(Vector2i vector2i, EditableGrayScale8Image channelR, EditableGrayScale8Image channelG, EditableGrayScale8Image channelB) {
        this(vector2i.x, vector2i.y, channelR, channelG, channelB);
    }

    public SpiceEditableCSRGB24Image(@Min(1) int width, @Min(1) int height) {
        super(width, height);

        this.channelR = new SpiceEditableGrayScale8Image(width, height);
        this.channelG = new SpiceEditableGrayScale8Image(width, height);
        this.channelB = new SpiceEditableGrayScale8Image(width, height);
    }

    public SpiceEditableCSRGB24Image(@Min(1) int width, @Min(1) int height, @Min(0) @Max(0xFFFFFF) int backgroundColor) {
        super(width, height);

        if (backgroundColor < 0 || backgroundColor > 0xFFFFFF) {
            throw new IllegalArgumentException();
        }

        this.channelR = new SpiceEditableGrayScale8Image(width, height, (byte) (backgroundColor >>> 16));
        this.channelG = new SpiceEditableGrayScale8Image(width, height, (byte) (backgroundColor >>> 8));
        this.channelB = new SpiceEditableGrayScale8Image(width, height, (byte) (backgroundColor));
    }

    public SpiceEditableCSRGB24Image(@Min(1) int width, @Min(1) int height, EditableGrayScale8Image channelR, EditableGrayScale8Image channelG, EditableGrayScale8Image channelB) {
        super(width, height);

        Vector2i size = getSize();

        if (size.equals(channelR.getSize())) {
            throw new IllegalArgumentException();

        } else if (size.equals(channelG.getSize())) {
            throw new IllegalArgumentException();

        } else if (size.equals(channelB.getSize())) {
            throw new IllegalArgumentException();
        }

        this.channelR = channelR;
        this.channelG = channelG;
        this.channelB = channelB;
    }

    @Override
    public EditableGrayScale8Image getChannelR() {
        return channelR;
    }

    @Override
    public EditableGrayScale8Image getChannelG() {
        return channelG;
    }

    @Override
    public EditableGrayScale8Image getChannelB() {
        return channelB;
    }

    @Override
    public void setColor(@Min(0) int x, @Min(0) int y, @Min(0) @Max(0xFFFFFF) int color) {
        validatePosition(x, y);
        if (color < 0 || color > 0xFFFFFF)
            throw new IllegalArgumentException();

        channelR.setColor(x, y, (byte) (color >>> 16));
        channelG.setColor(x, y, (byte) (color >>> 8));
        channelB.setColor(x, y, (byte) color);
    }

    @Override
    public void setColor(Vector2i position, @Min(0) @Max(0xFFFFFF) int color) {
        setColor(position.x, position.y, color);
    }

    @Override
    public void setColor(@Min(0) int x, @Min(0) int y, RGB24Color color) {
        channelR.setColor(x, y, color.r);
        channelG.setColor(x, y, color.g);
        channelB.setColor(x, y, color.b);
    }

    @Override
    public void setColor(Vector2i position, RGB24Color color) {
        setColor(position.x, position.y, color);
    }

    @Override
    public SpiceCachedRGB24Image makeImage() {
        return new SpiceCachedRGB24Image(width, height, getData());
    }

    @Override
    public RGB24Color getColorAt(@Min(0) int x, @Min(0) int y) {
        validatePosition(x, y);
        return new RGB24Color(channelR.getColorIntAt(x, y), channelG.getColorIntAt(x, y), channelB.getColorIntAt(x, y));
    }

    @Override
    public RGB24Color getColorAt(Vector2i position) {
        return getColorAt(position.x, position.y);
    }

    @Override
    public int getColorIntAt(@Min(0) int x, @Min(0) int y) {
        validatePosition(x, y);
        return channelR.getColorIntAt(x, y) << 16 | channelG.getColorIntAt(x, y) << 8 | channelB.getColorIntAt(x, y);
    }

    @Override
    public int getColorIntAt(Vector2i position) {
        return getColorIntAt(position.x, position.y);
    }

    @Override
    public int[] getData() {
        int[] data = new int[width * height];
        byte[] rdata = channelR.getData();
        byte[] gdata = channelG.getData();
        byte[] bdata = channelB.getData();

        for (int i = 0; i < data.length; i++)
            data[i] = rdata[i] & 0xFF << 16 | gdata[i] & 0xFF << 8 | bdata[i] & 0xFF;

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
    public SpiceEditableCSRGB24Image copyDeeply() {
        return new SpiceEditableCSRGB24Image(width, height, channelR.copyDeeply(), channelG.copyDeeply(), channelB.copyDeeply());
    }
}
