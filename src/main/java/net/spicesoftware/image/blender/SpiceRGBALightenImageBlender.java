package net.spicesoftware.image.blender;

import net.spicesoftware.api.image.blender.property.IBPropertyOpacity;
import net.spicesoftware.api.image.rgba.CachedRGBA32Image;
import net.spicesoftware.api.util.Pair;
import net.spicesoftware.api.util.vector.Vector2i;
import net.spicesoftware.image.rgba.SpiceCachedRGBA32Image;
import net.spicesoftware.image.rgba.SpiceRGBA32Image;

import javax.validation.constraints.Size;

/**
 * @since 2015/03/31
 */
public class SpiceRGBALightenImageBlender extends SpiceRGBAImageBlender<CachedRGBA32Image, IBPropertyOpacity> {

    @Override
    public CachedRGBA32Image blendImage(@Size(min = 2) Pair<CachedRGBA32Image, IBPropertyOpacity>... images) {
        checkParam(images);

        int width = images[0].a.getWidth();
        int height = images[0].a.getHeight();

        int length = width * height;
        int noimages = images.length;


        // 事前コピー
        int[][] imagesData = new int[noimages][];

        for (int i = 0; i < images.length; i++) {
            imagesData[i] = images[i].a.getData();
        }

        int[] result = new int[length];

        int firgba, r, g, b, a, rgba, rf, gf, bf, af;
        int rs, gs, bs, as, ar, ad, t;

        for (int pos = 0; pos < length; pos++) {
            rs = gs = bs = as = 0;

            for (int i = 0; i < noimages; i++) {
                int[] data = imagesData[i];

                rgba = data[pos];
                ad = ((rgba & 0xFF) * images[i].b.getOpacity()) / 1000;

                if (ad != 0) {
                    ar = as + ((0xFF - as) * ad) / 0xFF;
                    if (ar == 0) {
                        rs = gs = bs = 0;
                    } else {
                        t = (0xFF - as) * ad;
                        rs = (rs * as + ((rgba >>> 24 & 0xFF) * t) / 0xFF) / ar;
                        gs = (gs * as + ((rgba >>> 16 & 0xFF) * t) / 0xFF) / ar;
                        bs = (bs * as + ((rgba >>> 8 & 0xFF) * t) / 0xFF) / ar;
                    }
                    as = ar;
                }
            }
            result[pos] = rs << 24 | gs << 16 | bs << 8 | as;
        }

        return new SpiceCachedRGBA32Image(width, height, result);

        // 透明度なし
//        for (int pos = 0; pos < length; pos++) {
//            firgba = images[0].a[pos];
//            a = ((firgba & 0xFF) * images[0].b) / 1000;
//            r = ((firgba >>> 24 & 0xFF) * a) / 0xFF;
//            g = ((firgba >>> 16 & 0xFF) * a) / 0xFF;
//            b = ((firgba >>> 8 & 0xFF) * a) / 0xFF;
//
//            for (int i = 0; i < noimages; i++) {
//                rgba = images[i].a[pos];
//                af = ((rgba & 0xFF) * images[i].b) / 1000;
//                rf = ((rgba >>> 24 & 0xFF) * af) / 0xFF;
//                gf = ((rgba >>> 16 & 0xFF) * af) / 0xFF;
//                bf = ((rgba >>> 8 & 0xFF) * af) / 0xFF;
//                r = (r > rf) ? r : rf;
//                g = (g > gf) ? g : gf;
//                b = (b > bf) ? b : bf;
//                a = af + ((0xFF - af) * a) / 0xFF;
//            }
//
//            result[pos] = r << 24 | g << 16 | b << 8 | a;
//        }
    }
}
