package net.spicesoftware.registry;

import net.spicesoftware.api.image.gs.CachedGrayScale8Image;
import net.spicesoftware.api.image.gs.EditableGrayScale8Image;
import net.spicesoftware.api.registry.ImageCreator;
import net.spicesoftware.api.decoration.fill.GrayScale8Color;
import net.spicesoftware.api.decoration.fill.RGB24Color;
import net.spicesoftware.api.decoration.fill.RGBA32Color;
import net.spicesoftware.api.util.vector.Vector2i;
import net.spicesoftware.image.gs.SpiceCachedGrayScale8Image;
import net.spicesoftware.image.gs.SpiceEditableGrayScale8Image;
import net.spicesoftware.image.rgb.SpiceCachedRGB24Image;
import net.spicesoftware.image.rgb.SpiceEditableCSRGB24Image;
import net.spicesoftware.image.rgb.SpiceEditableRGB24Image;
import net.spicesoftware.image.rgba.SpiceCachedRGBA32Image;
import net.spicesoftware.image.rgba.SpiceEditableCSRGBA32Image;
import net.spicesoftware.image.rgba.SpiceEditableRGBA32Image;

/**
 * @since 2015/11/14
 */
public final class SpiceImageCreator implements ImageCreator {

    @Override
    public CachedGrayScale8Image createCachedGrayScale8Image(int width, int height, byte[] image) throws IllegalArgumentException {
        return new SpiceCachedGrayScale8Image(width, height, image);
    }

    @Override
    public SpiceEditableGrayScale8Image createEditableGrayScale8Image(int width, int height, byte[] image) throws IllegalArgumentException {
        return new SpiceEditableGrayScale8Image(width, height, image);
    }

    @Override
    public SpiceEditableGrayScale8Image createEditableGrayScale8Image(int width, int height) throws IllegalArgumentException {
        return new SpiceEditableGrayScale8Image(width, height);
    }

    @Override
    public SpiceEditableGrayScale8Image createEditableGrayScale8Image(Vector2i size) {
        return new SpiceEditableGrayScale8Image(size.x, size.y);
    }

    @Override
    public SpiceEditableGrayScale8Image createEditableGrayScale8Image(int width, int height, byte backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableGrayScale8Image(width, height, backgroundColor);
    }

    @Override
    public SpiceEditableGrayScale8Image createEditableGrayScale8Image(Vector2i size, byte backgroundColor) {
        return new SpiceEditableGrayScale8Image(size.x, size.y, backgroundColor);
    }

    @Override
    public SpiceEditableGrayScale8Image createEditableGrayScale8Image(int width, int height, int backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableGrayScale8Image(width, height, ((byte) backgroundColor));
    }

    @Override
    public SpiceEditableGrayScale8Image createEditableGrayScale8Image(Vector2i size, int backgroundColor) {
        return new SpiceEditableGrayScale8Image(size.x, size.y, ((byte) backgroundColor));
    }

    @Override
    public SpiceEditableGrayScale8Image createEditableGrayScale8Image(int width, int height, GrayScale8Color backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableGrayScale8Image(width, height, ((byte) backgroundColor.whiteness));
    }

    @Override
    public SpiceEditableGrayScale8Image createEditableGrayScale8Image(Vector2i size, GrayScale8Color backgroundColor) {
        return new SpiceEditableGrayScale8Image(size.x, size.y, ((byte) backgroundColor.whiteness));
    }

    @Override
    public SpiceCachedRGB24Image createCachedRGB24Image(int width, int height, int[] image) throws IllegalArgumentException {
        return new SpiceCachedRGB24Image(width, height, image);
    }

    @Override
    public SpiceEditableRGB24Image createEditableRGB24Image(int width, int height, int[] image) throws IllegalArgumentException {
        return new SpiceEditableRGB24Image(width, height, image);
    }

    @Override
    public SpiceEditableRGB24Image createEditableRGB24Image(int width, int height) throws IllegalArgumentException {
        return new SpiceEditableRGB24Image(width, height);
    }

    @Override
    public SpiceEditableRGB24Image createEditableRGB24Image(Vector2i size) {
        return new SpiceEditableRGB24Image(size.x, size.y);
    }

    @Override
    public SpiceEditableRGB24Image createEditableRGB24Image(int width, int height, int backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableRGB24Image(width, height, backgroundColor);
    }

    @Override
    public SpiceEditableRGB24Image createEditableRGB24Image(Vector2i size, int backgroundColor) {
        return new SpiceEditableRGB24Image(size.x, size.y, backgroundColor);
    }

    @Override
    public SpiceEditableRGB24Image createEditableRGB24Image(int width, int height, RGB24Color backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableRGB24Image(width, height, backgroundColor.toRGB24Int());
    }

    @Override
    public SpiceEditableRGB24Image createEditableRGB24Image(Vector2i size, RGB24Color backgroundColor) {
        return new SpiceEditableRGB24Image(size.x, size.y, backgroundColor.toRGB24Int());
    }

    @Override
    public SpiceEditableCSRGB24Image createEditableCSRGB24Image(int width, int height, EditableGrayScale8Image channelR, EditableGrayScale8Image channelG, EditableGrayScale8Image channelB) throws IllegalArgumentException {
        return new SpiceEditableCSRGB24Image(width, height, channelR, channelG, channelB);
    }

    @Override
    public SpiceEditableCSRGB24Image createEditableCSRGB24Image(Vector2i size, EditableGrayScale8Image channelR, EditableGrayScale8Image channelG, EditableGrayScale8Image channelB) {
        return new SpiceEditableCSRGB24Image(size.x, size.y, channelR, channelG, channelB);
    }

    @Override
    public SpiceCachedRGBA32Image createCachedRGBA32Image(int width, int height, int[] image) throws IllegalArgumentException {
        return new SpiceCachedRGBA32Image(width, height, image);
    }

    @Override
    public SpiceEditableRGBA32Image createEditableRGBA32Image(int width, int height, int[] image) throws IllegalArgumentException {
        return new SpiceEditableRGBA32Image(width, height, image);
    }

    @Override
    public SpiceEditableRGBA32Image createEditableRGBA32Image(int width, int height) throws IllegalArgumentException {
        return new SpiceEditableRGBA32Image(width, height);
    }

    @Override
    public SpiceEditableRGBA32Image createEditableRGBA32Image(Vector2i size) {
        return new SpiceEditableRGBA32Image(size.x, size.y);
    }

    @Override
    public SpiceEditableRGBA32Image createEditableRGBA32Image(int width, int height, int backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableRGBA32Image(width, height, backgroundColor);
    }

    @Override
    public SpiceEditableRGBA32Image createEditableRGBA32Image(Vector2i size, int backgroundColor) {
        return new SpiceEditableRGBA32Image(size.x, size.y, backgroundColor);
    }

    @Override
    public SpiceEditableRGBA32Image createEditableRGBA32Image(int width, int height, long backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableRGBA32Image(width, height, ((int) backgroundColor));
    }

    @Override
    public SpiceEditableRGBA32Image createEditableRGBA32Image(Vector2i size, long backgroundColor) {
        return new SpiceEditableRGBA32Image(size.x, size.y, ((int) backgroundColor));
    }

    @Override
    public SpiceEditableRGBA32Image createEditableRGBA32Image(int width, int height, RGBA32Color backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableRGBA32Image(width, height, backgroundColor.toRGBA32Int());
    }

    @Override
    public SpiceEditableRGBA32Image createEditableRGBA32Image(Vector2i size, RGBA32Color backgroundColor) {
        return new SpiceEditableRGBA32Image(size.x, size.y, backgroundColor.toRGBA32Int());
    }

    @Override
    public SpiceEditableCSRGBA32Image createEditableCSRGBA32Image(int width, int height, EditableGrayScale8Image channelR, EditableGrayScale8Image channelG, EditableGrayScale8Image channelB, EditableGrayScale8Image channelA) throws IllegalArgumentException {
        return new SpiceEditableCSRGBA32Image(width, height, channelR, channelG, channelB, channelA);
    }

    @Override
    public SpiceEditableCSRGBA32Image createEditableCSRGBA32Image(Vector2i size, EditableGrayScale8Image channelR, EditableGrayScale8Image channelG, EditableGrayScale8Image channelB, EditableGrayScale8Image channelA) {
        return new SpiceEditableCSRGBA32Image(size.x, size.y, channelR, channelG, channelB, channelA);
    }
}
