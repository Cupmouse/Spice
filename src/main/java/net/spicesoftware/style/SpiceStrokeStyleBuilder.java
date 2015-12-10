package net.spicesoftware.style;

import net.spicesoftware.api.decoration.fill.DecorationFilling;
import net.spicesoftware.api.style.StrokeStyle;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.api.util.ToString;

import javax.validation.constraints.Min;

import static net.spicesoftware.api.util.Validate.nullNot;
import static net.spicesoftware.api.util.Validate.zeroOrPositive;

/**
 * @since 2015/08/14
 */
public final class SpiceStrokeStyleBuilder implements StrokeStyle.Builder {

    @ToString
    private DecorationFilling filling;
    @ToString
    private int thickness = 1;

    /**
     * {@link SpiceStrokeStyle}の{@link DecorationFilling}を設定します。
     *
     * @param filling 線スタイルに設定する塗りつぶし
     */
    @Override
    public void fill(DecorationFilling filling) {
        nullNot(filling);
        this.filling = filling;
    }

    /**
     * {@link SpiceStrokeStyle}の線の太さを設定します。
     *
     * @param thickness 線スタイルに設定する線の太さ、0以上
     * @throws IllegalArgumentException 線の太さを0未満に設定しようとした時
     */
    @Override
    public void thickness(@Min(0) int thickness) throws IllegalArgumentException {
        zeroOrPositive(thickness);
        this.thickness = thickness;
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }

    @Override
    public StrokeStyle build() {
        return new SpiceStrokeStyle(filling, thickness);
    }
}