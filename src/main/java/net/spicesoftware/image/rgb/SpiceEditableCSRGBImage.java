package net.spicesoftware.image.rgb;

import net.spicesoftware.SpiceSession;
import net.spicesoftware.api.image.gs.CachedGrayScaleImage;
import net.spicesoftware.api.image.gs.EditableGrayScaleImage;
import net.spicesoftware.api.image.rgb.EditableCSRGBImage;
import net.spicesoftware.api.util.color.RGB24Color;
import net.spicesoftware.api.util.vector.Vector2i;
import net.spicesoftware.image.gs.SpiceCachedGrayScaleImage;
import net.spicesoftware.image.rgba.SpiceCachedRGBAImage;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @since 2015/03/20
 */
public final class SpiceEditableCSRGBImage extends SpiceRGBImage implements EditableCSRGBImage {

    private EditableGrayScaleImage channelR;
    private EditableGrayScaleImage channelG;
    private EditableGrayScaleImage channelB;

    public SpiceEditableCSRGBImage(int width, int height) {
        super(width, height);

        this.channelR = SpiceSession.getInstance().getRegistry().createNewGrayScaleImage(width, height);
        this.channelG = channelR.copyDeeply();
        this.channelB = channelR.copyDeeply();
    }

    public SpiceEditableCSRGBImage(int width, int height, EditableGrayScaleImage channelR, EditableGrayScaleImage channelG, EditableGrayScaleImage channelB) {
        super(width, height);

        if (channelR.getWidth() != width || channelR.getHeight() != height)
            throw new IllegalArgumentException();
        if (channelG.getWidth() != width || channelG.getHeight() != height)
            throw new IllegalArgumentException();
        if (channelB.getWidth() != width || channelB.getHeight() != height)
            throw new IllegalArgumentException();

        this.channelR = channelR;
        this.channelG = channelG;
        this.channelB = channelB;
    }

    @Override
    public EditableGrayScaleImage getChannelR() {
        return channelR;
    }

    @Override
    public EditableGrayScaleImage getChannelG() {
        return channelG;
    }

    @Override
    public EditableGrayScaleImage getChannelB() {
        return channelB;
    }

    @Override
    public void setColor(@Min(0) int x, @Min(0) int y, @Min(0) @Max(0xFFFFFF) int color) {
        validPosition(x, y);
        if (color < 0 || color > 0xFFFFFF)
            throw new IllegalArgumentException();

        channelR.setColor(x, y, (byte) (color >>> 16));
        channelG.setColor(x, y, (byte) (color >>> 8));
        channelB.setColor(x, y, ((byte) color));
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
    public SpiceCachedRGBImage makeImage() {
        return new SpiceCachedRGBImage(width, height, getData());
    }

    @Override
    public RGB24Color getColorAt(@Min(0) int x, @Min(0) int y) {
        validPosition(x, y);
        return new RGB24Color(channelR.getColorIntAt(x, y), channelG.getColorIntAt(x, y), channelB.getColorIntAt(x, y));
    }

    @Override
    public RGB24Color getColorAt(Vector2i position) {
        return getColorAt(position.x, position.y);
    }

    @Override
    public int getColorIntAt(@Min(0) int x, @Min(0) int y) {
        validPosition(x, y);
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
    public SpiceCachedRGBAImage toRGBAImage() {
        return null;
    }

    @Override
    public SpiceCachedGrayScaleImage toGrayScaleImage() {
        return null;
    }

    @Override
    public SpiceEditableCSRGBImage copyDeeply() {
        return new SpiceEditableCSRGBImage(width, height, channelR.copyDeeply(), channelG.copyDeeply(), channelB.copyDeeply());
    }
}
