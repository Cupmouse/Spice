package net.spicesoftware.image.rgba;

import net.spicesoftware.api.image.gs.CachedGrayScaleImage;
import net.spicesoftware.api.image.gs.EditableGrayScaleImage;
import net.spicesoftware.api.image.rgb.CachedRGBImage;
import net.spicesoftware.api.image.rgba.CachedRGBAImage;
import net.spicesoftware.api.image.rgba.EditableRGBAImage;
import net.spicesoftware.api.util.decoration.fill.color.RGBA32Color;
import net.spicesoftware.api.util.vector.Vector2i;
import net.spicesoftware.image.gs.SpiceEditableGrayScaleImage;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Arrays;

/**
 * @since 2015/03/20
 */
public final class SpiceEditableCSRGBAImage extends SpiceRGBAImage implements EditableRGBAImage {

    private EditableGrayScaleImage channelR;
    private EditableGrayScaleImage channelG;
    private EditableGrayScaleImage channelB;
    private EditableGrayScaleImage channelA;

    public SpiceEditableCSRGBAImage(int width, int height) {
        super(width, height);
        byte[] data = new byte[width * height];
        Arrays.fill(data, (byte) 0xFF);

        this.channelR = new SpiceEditableGrayScaleImage(width, height, data);
        this.channelG = channelR.copyDeeply();
        this.channelB = channelR.copyDeeply();
        this.channelA = channelR.copyDeeply();
    }

    public SpiceEditableCSRGBAImage(int width, int height, int backgroundColor) {
        super(width, height);
        byte[] datar = new byte[width * height], datag = new byte[width * height], datab = new byte[width * height], dataa = new byte[width * height];

        Arrays.fill(datar, (byte) (backgroundColor >>> 24));
        this.channelR = new SpiceEditableGrayScaleImage(width, height, datar);
        Arrays.fill(datag, (byte) (backgroundColor >>> 16));
        this.channelG = new SpiceEditableGrayScaleImage(width, height, datag);
        Arrays.fill(datab, (byte) (backgroundColor >>> 8));
        this.channelB = new SpiceEditableGrayScaleImage(width, height, datab);
        Arrays.fill(dataa, (byte) backgroundColor);
        this.channelA = new SpiceEditableGrayScaleImage(width, height, dataa);
    }

    public SpiceEditableCSRGBAImage(int width, int height, EditableGrayScaleImage channelR, EditableGrayScaleImage channelG, EditableGrayScaleImage channelB, EditableGrayScaleImage channelA) {
        super(width, height);
        this.channelR = channelR;
        this.channelG = channelG;
        this.channelB = channelB;
        this.channelA = channelA;
    }

    @Override
    public void setColor(@Min(0) int x, @Min(0) int y, @Min(0) @Max(0xFFFFFF) int color, @Min(0) @Max(0xFF) int transparent) {
        validPosition(x, y);
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
        validPosition(x, y);
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
        validPosition(x, y);
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
        validPosition(x, y);
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
    public CachedRGBAImage makeImage() {
        return new SpiceCachedRGBAImage(width, height, getData());
    }

    @Override
    public RGBA32Color getColorAt(@Min(0) int x, @Min(0) int y) {
        validPosition(x, y);
        return new RGBA32Color(channelR.getColorIntAt(x, y), channelG.getColorIntAt(x, y), channelB.getColorIntAt(x, y), channelA.getColorIntAt(x, y));
    }

    @Override
    public RGBA32Color getColorAt(Vector2i position) {
        return getColorAt(position.x, position.y);
    }

    @Override
    public long getColorLongAt(@Min(0) int x, @Min(0) int y) {
        validPosition(x, y);
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
    public CachedGrayScaleImage extractChannelR() {
        return channelR.makeImage();
    }

    @Override
    public CachedGrayScaleImage extractChannelG() {
        return channelG.makeImage();
    }

    @Override
    public CachedGrayScaleImage extractChannelB() {
        return channelB.makeImage();
    }

    @Override
    public CachedGrayScaleImage extractChannelA() {
        return channelA.makeImage();
    }

    @Override
    public CachedRGBImage toRGBImage() {
        return null;
    }

    @Override
    public CachedGrayScaleImage toGrayScaleImage() {
        return null;
    }

    @Override
    public EditableRGBAImage copyDeeply() {
        return new SpiceEditableCSRGBAImage(width, height, channelR.copyDeeply(), channelG.copyDeeply(), channelB.copyDeeply(), channelA.copyDeeply());
    }
}
