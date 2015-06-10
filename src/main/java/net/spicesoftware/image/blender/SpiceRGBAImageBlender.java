package net.spicesoftware.image.blender;

import net.spicesoftware.api.image.blender.RGBAImageBlender;
import net.spicesoftware.api.image.rgba.CachedRGBAImage;
import net.spicesoftware.api.util.Pair;

import javax.validation.constraints.Size;

/**
 * @since 2015/03/30
 */
public abstract class SpiceRGBAImageBlender extends SpiceImageBlender<int[], CachedRGBAImage> implements RGBAImageBlender {

    @Override
    public int[] blendData(@Size(min = 2) Pair<int[], Integer>... images) {
        int[] result = new int[images[0].a.length];
        blendData(result, images);
        return result;
    }

    @Override
    public void blendData(int[] result, @Size(min = 2) Pair<int[], Integer>... images) {
        // パラメータの画像が1個以下ならエラー
        if (images.length < 2)
            throw new IllegalArgumentException();

        final int firstImageSize = images[0].a.length;

        if (result.length != firstImageSize)
            throw new IllegalArgumentException();

        // サイズが全て同じか、指定された透明度を表すintのラッパーのインスタンスがnullでないかチェック
        for (int i = 1; i < images.length; i++) {
            // サイズが異なる画像があるのでエラー
            if (firstImageSize != images[i].a.length)
                throw new IllegalArgumentException();
            // 値が指定されていない
            if (images[i].b == null)
                throw new NullPointerException();
            // 不透明度の値が範囲に収まっていない
            if (images[i].b < 0 || images[i].b > 1000)
                throw new IllegalArgumentException();
        }
    }
}
