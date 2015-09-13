package net.spicesoftware.image.blender;

import net.spicesoftware.api.image.blender.ImageBlender;
import net.spicesoftware.api.image.blender.property.IBPropertyDitherRGBA32;
import net.spicesoftware.api.image.rgba.CachedRGBA32Image;
import net.spicesoftware.api.util.Pair;
import net.spicesoftware.api.util.vector.Vector2i;
import net.spicesoftware.image.rgba.SpiceCachedRGBA32Image;

import javax.validation.constraints.Size;
import java.util.Random;

/**
 * @since 2015/03/31
 */
public class SpiceRGBA32DitherImageBlender extends SpiceRGBAImageBlender<CachedRGBA32Image, IBPropertyDitherRGBA32> {

    @Override
    public CachedRGBA32Image blendImage(@Size(min = 2) Pair<CachedRGBA32Image, IBPropertyDitherRGBA32>... images) {
        Vector2i size = images[0].a.getSize();

        int rgba, a, rnd;
        Random random;

        int[] data;
        int[] result = new int[size.area()];

        for (int i = images.length - 1; i >= 0; i--) {
            random = new Random(images[i].b.getSeed() + i);
            random.nextInt();
            data = images[i].a.getData();

            for (int pos = 0; pos < size.area(); pos++) {
                rgba = data[pos];
                a = ((rgba & 0xFF) * images[i].b.getOpacity()) / 1000;

                // スキップする場合でも乱数は生成する
                rnd = random.nextInt(0xFF);
                if (a == 0) {
                    // 透明なのでスキップ
                } else if (rnd < a) {
                    // この画像の色に変更
                    result[pos] = rgba | 0xFF;
                }
            }
        }

        return new SpiceCachedRGBA32Image(size, result);
    }
}
