package net.spicesoftware.image.converter;

import net.spicesoftware.api.image.ImageConverter;
import net.spicesoftware.api.image.gs.GrayScale8Image;
import net.spicesoftware.api.image.rgba.CachedRGBA32Image;
import net.spicesoftware.api.util.vector.Vector2i;
import net.spicesoftware.image.rgba.SpiceCachedRGBA32Image;

/**
 * @since 2015/09/07
 */
public class SpiceGS8RGBA32ImageConverter implements ImageConverter<GrayScale8Image,CachedRGBA32Image> {

    @Override
    public CachedRGBA32Image convert(GrayScale8Image image) {
        Vector2i size = image.getSize();
        byte[] data = image.getData();

        int[] rgbaData = new int[size.area()];

        for (int pos = 0; pos < data.length; pos++) {
            int whiteness = data[pos] & 0xFF;
            rgbaData[pos] = whiteness << 24 | whiteness << 16 | whiteness << 8 | 0xFF;
        }
        return new SpiceCachedRGBA32Image(size, rgbaData);
    }
}
