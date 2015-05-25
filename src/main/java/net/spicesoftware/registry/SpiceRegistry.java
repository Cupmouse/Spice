package net.spicesoftware.registry;

import net.spicesoftware.api.image.gs.EditableGrayScaleImage;
import net.spicesoftware.api.image.rgba.CachedRGBAImage;
import net.spicesoftware.api.image.rgba.EditableRGBAImage;
import net.spicesoftware.api.registry.Registry;
import net.spicesoftware.api.util.color.GrayScaleColor;
import net.spicesoftware.api.util.color.RGB24Color;
import net.spicesoftware.api.util.color.RGBA32Color;
import net.spicesoftware.api.util.vector.Vector2i;
import net.spicesoftware.image.gs.SpiceCachedGrayScaleImage;
import net.spicesoftware.image.gs.SpiceEditableGrayScaleImage;
import net.spicesoftware.image.rgb.SpiceCachedRGBImage;
import net.spicesoftware.image.rgb.SpiceEditableCSRGBImage;
import net.spicesoftware.image.rgb.SpiceEditableRGBImage;
import net.spicesoftware.image.rgba.SpiceCachedRGBAImage;
import net.spicesoftware.image.rgba.SpiceEditableCSRGBAImage;
import net.spicesoftware.image.rgba.SpiceEditableRGBAImage;

/**
 * @since 2015/03/19
 */
public abstract class SpiceRegistry implements Registry {

    @Override
    public SpiceCachedGrayScaleImage createCachedGrayScaleImage(int width, int height, byte[] image) {
        return new SpiceCachedGrayScaleImage(width, height, image);
    }

    @Override
    public SpiceEditableGrayScaleImage createNewGrayScaleImage(int width, int height, byte[] image) {
        return new SpiceEditableGrayScaleImage(width, height, image);
    }

    @Override
    public SpiceEditableGrayScaleImage createNewGrayScaleImage(int width, int height) {
        return new SpiceEditableGrayScaleImage(width, height);
    }

    @Override
    public SpiceEditableGrayScaleImage createNewGrayScaleImage(Vector2i size) {
        return new SpiceEditableGrayScaleImage(size.x, size.y);
    }

    @Override
    public SpiceEditableGrayScaleImage createNewGrayScaleImage(int width, int height, byte backgroundColor) {
        return new SpiceEditableGrayScaleImage(width, height, backgroundColor);
    }

    @Override
    public SpiceEditableGrayScaleImage createNewGrayScaleImage(Vector2i size, byte backgroundColor) {
        return new SpiceEditableGrayScaleImage(size.x, size.y, backgroundColor);
    }

    @Override
    public SpiceEditableGrayScaleImage createNewGrayScaleImage(int width, int height, int backgroundColor) {
        return new SpiceEditableGrayScaleImage(width, height, ((byte) backgroundColor));
    }

    @Override
    public SpiceEditableGrayScaleImage createNewGrayScaleImage(Vector2i size, int backgroundColor) {
        return new SpiceEditableGrayScaleImage(size.x, size.y, ((byte) backgroundColor));
    }

    @Override
    public SpiceEditableGrayScaleImage createNewGrayScaleImage(int width, int height, GrayScaleColor backgroundColor) {
        return new SpiceEditableGrayScaleImage(width, height, ((byte) backgroundColor.w));
    }

    @Override
    public SpiceEditableGrayScaleImage createNewGrayScaleImage(Vector2i size, GrayScaleColor backgroundColor) {
        return new SpiceEditableGrayScaleImage(size.x, size.y, ((byte) backgroundColor.w));
    }

    @Override
    public SpiceCachedRGBImage createCachedRGBImage(int width, int height, int[] image) {
        return new SpiceCachedRGBImage(width, height, image);
    }

    @Override
    public SpiceEditableRGBImage createNewRGBImage(int width, int height, int[] image) {
        return new SpiceEditableRGBImage(width, height, image);
    }

    @Override
    public SpiceEditableRGBImage createNewRGBImage(int width, int height) {
        return new SpiceEditableRGBImage(width, height);
    }

    @Override
    public SpiceEditableRGBImage createNewRGBImage(Vector2i size) {
        return new SpiceEditableRGBImage(size.x, size.y);
    }

    @Override
    public SpiceEditableRGBImage createNewRGBImage(int width, int height, int backgroundColor) {
        return new SpiceEditableRGBImage(width, height, backgroundColor);
    }

    @Override
    public SpiceEditableRGBImage createNewRGBImage(Vector2i size, int backgroundColor) {
        return new SpiceEditableRGBImage(size.x, size.y, backgroundColor);
    }

    @Override
    public SpiceEditableRGBImage createNewRGBImage(int width, int height, RGB24Color backgroundColor) {
        return new SpiceEditableRGBImage(width, height, backgroundColor.getIntValue());
    }

    @Override
    public SpiceEditableRGBImage createNewRGBImage(Vector2i size, RGB24Color backgroundColor) {
        return new SpiceEditableRGBImage(size.x, size.y, backgroundColor.getIntValue());
    }

    @Override
    public SpiceEditableCSRGBImage createNewCSRGBImage(int width, int height, EditableGrayScaleImage channelR, EditableGrayScaleImage channelG, EditableGrayScaleImage channelB) {
        return new SpiceEditableCSRGBImage(width, height, channelR, channelG, channelB);
    }

    @Override
    public SpiceEditableCSRGBImage createNewCSRGBImage(Vector2i size, EditableGrayScaleImage channelR, EditableGrayScaleImage channelG, EditableGrayScaleImage channelB) {
        return new SpiceEditableCSRGBImage(size.x, size.y, channelR, channelG, channelB);
    }

    @Override
    public CachedRGBAImage createCachedRGBAImage(int width, int height, int[] image) {
        return new SpiceCachedRGBAImage(width, height, image);
    }

    @Override
    public EditableRGBAImage createNewRGBAImage(int width, int height, int[] image) {
        return new SpiceEditableRGBAImage(width, height, image);
    }

    @Override
    public EditableRGBAImage createNewRGBAImage(int width, int height) {
        return new SpiceEditableRGBAImage(width, height);
    }

    @Override
    public EditableRGBAImage createNewRGBAImage(Vector2i size) {
        return new SpiceEditableRGBAImage(size.x, size.y);
    }

    @Override
    public EditableRGBAImage createNewRGBAImage(int width, int height, int backgroundColor) {
        return new SpiceEditableRGBAImage(width, height, backgroundColor);
    }

    @Override
    public EditableRGBAImage createNewRGBAImage(Vector2i size, int backgroundColor) {
        return new SpiceEditableRGBAImage(size.x, size.y, backgroundColor);
    }

    @Override
    public EditableRGBAImage createNewRGBAImage(int width, int height, long backgroundColor) {
        return new SpiceEditableRGBAImage(width, height, ((int) backgroundColor));
    }

    @Override
    public EditableRGBAImage createNewRGBAImage(Vector2i size, long backgroundColor) {
        return new SpiceEditableRGBAImage(size.x, size.y, ((int) backgroundColor));
    }

    @Override
    public EditableRGBAImage createNewRGBAImage(int width, int height, RGBA32Color backgroundColor) {
        return new SpiceEditableRGBAImage(width, height, backgroundColor.getIntValue());
    }

    @Override
    public EditableRGBAImage createNewRGBAImage(Vector2i size, RGBA32Color backgroundColor) {
        return new SpiceEditableRGBAImage(size.x, size.y, backgroundColor.getIntValue());
    }

    @Override
    public EditableRGBAImage createNewCSRGBAImage(int width, int height, EditableGrayScaleImage channelR, EditableGrayScaleImage channelG, EditableGrayScaleImage channelB, EditableGrayScaleImage channelA) {
        return new SpiceEditableCSRGBAImage(width, height, channelR, channelG, channelB, channelA);
    }

    @Override
    public EditableRGBAImage createNewCSRGBAImage(Vector2i size, EditableGrayScaleImage channelR, EditableGrayScaleImage channelG, EditableGrayScaleImage channelB, EditableGrayScaleImage channelA) {
        return new SpiceEditableCSRGBAImage(size.x, size.y, channelR, channelG, channelB, channelA);
    }
}
