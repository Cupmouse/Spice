package net.spicesoftware.image.effect;

import net.spicesoftware.api.image.effect.GSImageEffect;
import net.spicesoftware.api.image.effect.ImageEffect;
import net.spicesoftware.api.image.effect.RGBAImageEffect;
import net.spicesoftware.api.image.effect.RGBImageEffect;
import net.spicesoftware.api.image.rgba.RGBAImage;
import net.spicesoftware.api.util.vector.Vector2i;
import net.spicesoftware.image.rgba.SpiceCachedRGBAImage;
import net.spicesoftware.image.rgba.SpiceRGBAImage;

/**
 * @since 2015/04/22
 */
public class SpiceRGBAIEBlur implements GSImageEffect, RGBImageEffect, RGBAImageEffect {

    // root(2^32)=4096ピクセルまで。
    private int constant;

    public int[] applyNotImplemented(int width, int height, int[] data) {
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException();
        if (width * height != data.length)
            throw new IllegalArgumentException();

        int maximumConstant = Math.max(width, height) - 1;
        int constantActually;

        if (maximumConstant < constant) {
            constantActually = maximumConstant;
        } else {
            constantActually = constant;
        }

        if (constantActually == 0) {
            return data;
        }

        int[] applied = new int[width * height];

        for (int pos = 0; pos < data.length; pos++) {
            int r = 0, g = 0, b = 0, a = 0;
            int absolutePosX = pos % width;
            int absolutePosY = pos / width;

            int aboveYLength = absolutePosY < constantActually ? absolutePosY : constantActually;
            int bellowYLength = height - absolutePosY < constantActually ? height - absolutePosY - 1 : constantActually;
            int leftXLength = absolutePosX < constantActually ? absolutePosX : constantActually;
            int rightXLength = width - absolutePosX < constantActually ? width - absolutePosX - 1 : constantActually;
            int yLength = aboveYLength + 1 + bellowYLength;
            int xLength = leftXLength + 1 + rightXLength;
            System.out.println(absolutePosY + " : " + absolutePosX + " : " + aboveYLength + " : " + bellowYLength + " : " + leftXLength + " : " + rightXLength);

            int startPos = pos - aboveYLength * width - leftXLength;

            int lineStartPos = startPos;
            int areaPos;
            int lineEndPos;

            for (int line = 0; line < yLength; line++) {
                areaPos = lineStartPos;
                lineEndPos = lineStartPos + xLength;
                for (; areaPos <= lineEndPos; areaPos++) {
                    int areaPosRGBA = data[areaPos];
                    r += areaPosRGBA >>> 24;
                    g += areaPosRGBA >>> 16 & 0xFF;
                    b += areaPosRGBA >>> 8 & 0xFF;
                    a += areaPosRGBA & 0xFF;
                }
                lineStartPos += width;
            }
            r /= xLength * yLength;
            g /= xLength * yLength;
            b /= xLength * yLength;
            a /= xLength * yLength;
            applied[pos] = r << 24 | g << 16 | b << 8 | a;
        }

        return applied;
    }

    @Override
    public int[] applyRGBA(int width, int height, int[] data) {
        int[] applied = new int[width * height];

        for (int i = 0; i < data.length; i++) {
            int absolutePosX = i % width;
            int absolutePosY = i / width;
            int pixelResultR = 0;
            int pixelResultG = 0;
            int pixelResultB = 0;
            int pixelResultA = 0;

            int startX = absolutePosX - constant;
            int endX = absolutePosX + constant;
            int startY = absolutePosY - constant;
            int endY = absolutePosY + constant;

            if (startX < 0) {
                startX = 0;
            }
            if (endX > width) {
                endX = width - 1;
            }
            if (startY < 0) {
                startY = 0;
            }
            if (endY > height - 1) {
                endY = height - 1;
            }
            int pixels = 0;

            for (int x = startX; x <= endX; x++) {
                for (int y = startY; y < endY; y++) {
                    int dataChosen = data[width * y + x];
                    pixelResultR += dataChosen >>> 24;
                    pixelResultG += dataChosen >>> 16 & 0xFF;
                    pixelResultB += dataChosen >>> 8 & 0xFF;
                    pixelResultA += dataChosen & 0xFF;
                    pixels++;
                }
            }

            applied[i] = (pixelResultR / pixels) << 24 | (pixelResultG / pixels) << 16 | (pixelResultB / pixels) << 8 | (pixelResultA / pixels);
        }

        return applied;
    }

    public int getConstant() {
        return constant;
    }

    public void setConstant(int constant) throws IllegalArgumentException {
        if (constant < 0 || constant > 4096) {
            throw new IllegalArgumentException();
        }
        this.constant = constant;
    }

    @Override
    public byte[] applyGS(int width, int height, byte[] data) {
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException();
        if (width * height != data.length)
            throw new IllegalArgumentException();

        byte[] applied = new byte[width * height];

        for (int pos = 0; pos < data.length; pos++) {
            int absolutePosX = pos % width;
            int absolutePosY = pos / width;

            int startX = absolutePosX < constant ? 0 : absolutePosX - constant;
            int endX = absolutePosX + constant;
            int startY = absolutePosY < constant ? 0 : absolutePosY - constant;
            int endY = absolutePosY + constant;

            if (endX >= width) {
                endX = width - 1;
            }
            if (endY >= height) {
                endY = height - 1;
            }

            int pixelResult = 0;

            for (int x = startX; x <= endX; x++) {
                for (int y = startY; y < endY; y++) {
                    pixelResult += data[width * y + x] & 0xFF;
                }
            }

            applied[pos] = (byte) (pixelResult / ((endX - startX + 1) * (endY - startY + 1)));
        }

        return applied;
    }

    @Override
    public int[] applyRGB(int width, int height, int[] data) {
        return new int[0];
    }
}
