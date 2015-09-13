package net.spicesoftware.image.blender;

import net.spicesoftware.api.image.blender.property.IBPropertyOpacity;
import net.spicesoftware.api.image.rgba.CachedRGBA32Image;
import net.spicesoftware.api.util.Pair;
import net.spicesoftware.image.rgba.SpiceCachedRGBA32Image;

import javax.validation.constraints.Size;

/**
 * @since 2015/03/24
 */
public final class SpiceRGBANormalImageBlender extends SpiceRGBAImageBlender<CachedRGBA32Image, IBPropertyOpacity> {

    @Override
    public CachedRGBA32Image blendImage(@Size(min = 2) Pair<CachedRGBA32Image, IBPropertyOpacity>... images) {
        checkParam(images);

        // 1ピクセルごとに計算していく


        int width = images[0].a.getWidth();
        int height = images[0].a.getHeight();

        int length = width * height;
        int noimages = images.length;

        int[][] imagesData = new int[noimages][];
        int[] result = new int[length];
        int rs, gs, bs, as, rgba, ar, ad, t;

        // メソッドを毎回呼ぶとオーバーヘッドが発生するので配列に入れておく
        for (int i = 0; i < images.length; i++) {
            imagesData[i] = images[i].a.getData();
        }

        for (int pos = 0; pos < length; pos++) {
            rs = gs = bs = as = 0;

            for (int i = 0; i < noimages; i++) {
                rgba = imagesData[i][pos];
                ad = ((rgba & 0xFF) * images[i].b.getOpacity()) / 1000;

                if (ad != 0) {
                    // 不透明度を計算する
                    // Ar = As + (0xFF - As) * (Ad / 0xFF)
                    ar = as + ((0xFF - as) * ad) / 0xFF;
                    // 計算結果が0の場合
                    if (ar == 0) {
                        rs = gs = bs = 0;
                    } else {
                        // 色を計算する
                        // Cr = (Cs * (As / 0xFF) + (Cd * ((0xFF - As) / 0xFF) * (Ad / 0xFF)) / (Ar / 0xFF)
                        // Cr = (Cs * As + (Cd * (0xFF - As) * Ad) / 0xFF) / Ar
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
    }
}
