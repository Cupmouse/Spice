package net.spicesoftware.style;

import net.spicesoftware.api.ParameterEssentialBuilder;
import net.spicesoftware.api.decoration.fill.DecorationFilling;
import net.spicesoftware.api.style.StrokeStyle;
import net.spicesoftware.api.style.TextStyle;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.api.util.ToString;

import javax.xml.soap.Text;

import static net.spicesoftware.api.util.Validate.nullNot;

/**
 * @since 2015/08/14
 */
public final class SpiceTextStyleBuilder implements TextStyle.Builder {

    @ToString
    private StrokeStyle outline;
    @ToString
    private DecorationFilling filling;

    /**
     * {@link SpiceTextStyle}のアウトラインの{@link SpiceStrokeStyle}を設定します。
     *
     * @param outline テキストスタイルに設定するアウトラインのスタイル
     */
    @Override
    public SpiceTextStyleBuilder outline(StrokeStyle outline) {
        this.outline = outline;
        return this;
    }

    /**
     * {@link SpiceTextStyle}の文字の{@link DecorationFilling}を設定します。
     *
     * @param filling テキストスタイルに設定する文字のデコレーション
     */
    @Override
    public SpiceTextStyleBuilder fill(DecorationFilling filling) {
        nullNot(filling);
        this.filling = filling;
        return this;
    }

    @Override
    public SpiceTextStyle build() {
        return new SpiceTextStyle(outline, filling);
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}