package net.spicesoftware.image.effect;

import net.spicesoftware.api.image.effect.ImageEffect;
import net.spicesoftware.api.image.effect.RGBAImageEffect;

/**
 * @since 2015/05/08
 */
public class SpiceRGBAIENegative implements RGBAImageEffect {

    @Override
    public int[] applyRGBA(int width, int height, int[] data) {
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException();
        if (width * height != data.length) {
            throw new IllegalArgumentException();
        }

        int[] applied = new int[width * height];

        for (int pos = 0; pos < data.length; pos++) {
            applied[pos] = data[pos] ^ 0xFFFFFF00;
        }

        return applied;
    }
}
