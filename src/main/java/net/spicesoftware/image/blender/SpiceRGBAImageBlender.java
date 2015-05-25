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
        // �p�����[�^�̉摜��1�ȉ��Ȃ�G���[
        if (images.length < 2)
            throw new IllegalArgumentException();

        final int firstImageSize = images[0].a.length;

        if (result.length != firstImageSize)
            throw new IllegalArgumentException();

        // �T�C�Y���S�ē������A�w�肳�ꂽ�����x��\��int�̃��b�p�[�̃C���X�^���X��null�łȂ����`�F�b�N
        for (int i = 1; i < images.length; i++) {
            // �T�C�Y���قȂ�摜������̂ŃG���[
            if (firstImageSize != images[i].a.length)
                throw new IllegalArgumentException();
            // �l���w�肳��Ă��Ȃ�
            if (images[i].b == null)
                throw new NullPointerException();
            // �s�����x�̒l���͈͂Ɏ��܂��Ă��Ȃ�
            if (images[i].b < 0 || images[i].b > 1000)
                throw new IllegalArgumentException();
        }
    }
}
