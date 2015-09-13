package net.spicesoftware.image.blender;

import net.spicesoftware.api.image.CachedImage;
import net.spicesoftware.api.image.blender.ImageBlender;
import net.spicesoftware.api.image.blender.property.ImageBlenderProperty;
import net.spicesoftware.api.image.rgba.CachedRGBA32Image;
import net.spicesoftware.api.util.Pair;
import net.spicesoftware.api.util.vector.Vector2i;

/**
 * @since 2015/03/30
 */
public abstract class SpiceRGBAImageBlender<I extends CachedImage, B extends ImageBlenderProperty> implements ImageBlender<I, B> {

    public void checkParam(Pair<I, B>... images) {
        // パラメータの画像が1個以下ならエラー
        if (images.length <= 1)
            throw new IllegalArgumentException();

        final Vector2i firstImageSize = images[0].a.getSize();

        // サイズが全て同じか、指定された透明度を表すintのラッパーのインスタンスがnullでないかチェック
        for (int i = 1; i < images.length; i++) {
            // サイズが異なる画像があるのでエラー
            if (!firstImageSize.equals(images[i].a.getSize()))
                throw new IllegalArgumentException();
        }
    }
}
