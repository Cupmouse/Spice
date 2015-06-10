package net.spicesoftware.image.blender;

import net.spicesoftware.api.image.blender.RGBADitherImageBlender;
import net.spicesoftware.api.util.Pair;

import javax.validation.constraints.Size;
import java.util.Random;

/**
 * @since 2015/03/31
 */
public class SpiceRGBADitherImageBlender extends SpiceRGBAImageBlender implements RGBADitherImageBlender {

    @Override
    public void blendData(int[] result, @Size(min = 2) Pair<int[], Integer>... images) {
        blendData(result, 0, images);
    }

    @Override
    public void blendData(int[] result, int seed, @Size(min = 2) Pair<int[], Integer>... images) {
        super.blendData(result, images);

        int rgba, a, rnd;
        Random random;
        int[] image;

        for (int i = images.length - 1; i >= 0; i--) {
            random = new Random(seed + i);
            random.nextInt();
            image = images[i].a;

            for (int pos = 0; pos < images[0].a.length; pos++) {
                rgba = image[pos];
                a = ((rgba & 0xFF) * images[i].b) / 1000;

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
    }
}
