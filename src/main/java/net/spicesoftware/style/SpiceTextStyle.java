package net.spicesoftware.style;

import net.spicesoftware.api.decoration.fill.DecorationFilling;
import net.spicesoftware.api.style.StrokeStyle;
import net.spicesoftware.api.style.TextStyle;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.api.util.ToString;

import javax.annotation.Nullable;
import java.util.Optional;

import static net.spicesoftware.api.util.Validate.nullNot;

/**
 * テキストのスタイルを保持します。
 * イミュータブルクラスです。
 *
 * @since 2015/01/26
 */
public final class SpiceTextStyle implements TextStyle {

    @ToString
    private final StrokeStyle outline;
    @ToString
    private final DecorationFilling filling;

    protected SpiceTextStyle(@Nullable StrokeStyle outline, DecorationFilling filling) {
        nullNot(filling);
        this.outline = outline;
        this.filling = filling;
    }

    /**
     * この{@code SpiceTextStyle}のアウトラインの{@link SpiceStrokeStyle}を返します。
     *
     * @return このテキストスタイルのアウトラインのスタイル
     */
    @Override
    public Optional<StrokeStyle> getOutline() {
        return Optional.ofNullable(outline);
    }

    /**
     * アウトラインが存在する、縁取られているかを真偽値で返します。
     *
     * @return アウトラインが存在するか
     */
    @Override
    public boolean isOutlined() {
        return outline != null;
    }

    /**
     * この{@code SpiceTextStyle}の文字の{@link DecorationFilling}を返します。
     *
     * @return このテキストスタイルの文字のデコレーション
     */
    @Override
    public DecorationFilling getFilling() {
        return filling;
    }

    @Override
    public SpiceTextStyle copyDeeply() {
        return new SpiceTextStyle(outline == null ? null : outline.copyDeeply(), filling.copyDeeply());
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}
