package net.spicesoftware.style;

import net.spicesoftware.api.decoration.fill.DecorationFilling;
import net.spicesoftware.api.style.StrokeStyle;
import net.spicesoftware.api.util.DeepCopyable;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.api.util.ToString;

import javax.validation.constraints.Min;

import static net.spicesoftware.api.util.Validate.nullNot;
import static net.spicesoftware.api.util.Validate.zeroOrPositive;

/**
 * @since 2015/12/09
 */
public final class SpiceStrokeStyle implements StrokeStyle {

    @ToString
    private final DecorationFilling filling;
    @ToString
    private final int thickness;

    public SpiceStrokeStyle(DecorationFilling filling, @Min(0) int thickness) {
        nullNot(filling);
        zeroOrPositive(thickness);
        this.filling = filling;
        this.thickness = thickness;
    }

    @Override
    public DecorationFilling getFilling() {
        return filling;
    }

    @Override
    @Min(0)
    public int getThickness() {
        return thickness;
    }

    @Override
    public SpiceStrokeStyle copyDeeply() {
        return new SpiceStrokeStyle(filling.copyDeeply(), thickness);
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}
