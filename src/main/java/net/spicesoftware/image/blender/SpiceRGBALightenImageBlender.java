package net.spicesoftware.image.blender;

import net.spicesoftware.api.util.Pair;

import javax.validation.constraints.Size;

/**
 * @since 2015/03/31
 */
public class SpiceRGBALightenImageBlender extends SpiceRGBAImageBlender {

    @Override
    public void blendData(int[] result, @Size(min = 2) Pair<int[], Integer>... images) {
        super.blendData(result, images);

        int length = images[0].a.length;
        int noimages = images.length;
        int firgba, r, g, b, a, rgba, rf, gf, bf, af;
        int rs, gs, bs, as, ar, ad, t;

        // RGBAのアルファブレンディングとほとんど同じ
        for (int pos = 0; pos < length; pos++) {
            rs = gs = bs = as = 0;

            for (int i = 0; i < noimages; i++) {
                rgba = images[i].a[pos];
                ad = ((rgba & 0xFF) * images[i].b) / 1000;

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
