package net.spicesoftware.image.converter;

import net.spicesoftware.api.image.CachedImage;
import net.spicesoftware.api.image.Image;
import net.spicesoftware.api.image.ImageConverter;
import net.spicesoftware.api.image.gs.CachedGrayScale8Image;
import net.spicesoftware.api.image.rgb.CachedRGB24Image;
import net.spicesoftware.api.util.vector.Vector2i;
import net.spicesoftware.image.rgb.SpiceCachedRGB24Image;

/**
 * @since 2015/09/07
 */
public class SpiceGS8RGB24ImageConverter implements ImageConverter<CachedGrayScale8Image, CachedRGB24Image> {

    @Override
    public CachedRGB24Image convert(CachedGrayScale8Image image) {
        Vector2i size = image.getSize();
        byte[] data = image.getData();

        int[] rgbData = new int[size.area()];

        for (int pos = 0; pos < data.length; pos++) {
            byte whiteness = data[pos];
            rgbData[pos] = whiteness << 16 | whiteness << 8 | whiteness;
        }

        return new SpiceCachedRGB24Image(size, rgbData);
    }
}
