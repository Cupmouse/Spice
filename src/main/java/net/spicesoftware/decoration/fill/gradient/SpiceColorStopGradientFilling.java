package net.spicesoftware.decoration.fill.gradient;

import net.spicesoftware.api.decoration.fill.Color;
import net.spicesoftware.api.decoration.fill.gradient.ColorStopGradientFilling;
import net.spicesoftware.api.util.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static net.spicesoftware.api.util.Validate.nullNot;
import static net.spicesoftware.api.util.Validate.rangeIn;

/**
 * グラデーションの塗りつぶしです。
 * <p>
 * グラデーションのキーとなる色(中間色)を、0を最小、999を最大として配置します。
 * キーの間の色を補完することで、グラデーションになります。
 *
 * @see SpiceGradientFillingLinear
 * @see SpiceGradientFillingRadial
 * @since 2015/01/27
 */
public abstract class SpiceColorStopGradientFilling<T extends Color> implements ColorStopGradientFilling<T> {

    @ToString
    private final Map<Integer, T> colorStopMap;
    @ToString
    private final boolean repeat;

    protected SpiceColorStopGradientFilling(Map<Integer, T> colorStopMap, boolean repeating) {
        nullNot(colorStopMap);
        this.colorStopMap = Collections.unmodifiableMap(colorStopMap);
        this.repeat = repeating;
    }

    protected SpiceColorStopGradientFilling(SpiceColorStopGradientFilling<T> copyFrom) {
        nullNot(copyFrom);
        this.colorStopMap = Collections.unmodifiableMap(new HashMap<>(copyFrom.colorStopMap));
        this.repeat = copyFrom.repeat;
    }

    @Override
    public Map<Integer, T> getColorStopMap() {
        return colorStopMap;
    }

    @Override
    public Optional<T> getColorStopAt(@Min(0) @Max(999) int i) {
        rangeIn(i, 0, 999);
        return Optional.ofNullable(colorStopMap.get(i));
    }

    @Override
    public boolean isRepeating() {
        return repeat;
    }

    @Override
    public abstract SpiceColorStopGradientFilling<T> copyDeeply();

//    protected static abstract class ColorStopGradientFillingBasicFactory<T extends Color> {
//
//        protected ColorStopGradientFillingBasicFactory() {
//        }
//
//        public SpiceColorStopGradientFilling<T> twoColor(T firstColor, int firstColorPos, T secondColor, int secondColorPos, boolean repeating) {
//            if (firstColorPos < 0 || firstColorPos > 999 || secondColorPos < 0 || secondColorPos > 999) {
//                throw new IllegalArgumentException();
//            }
//            if (firstColor == null || secondColor == null) {
//                throw new NullPointerException();
//            }
//            Map<Integer, T> colorStopMap = new HashMap<>();
//            colorStopMap.put(firstColorPos, firstColor);
//            colorStopMap.put(secondColorPos, secondColor);
//            return createNew(Collections.unmodifiableMap(colorStopMap), repeating);
//        }
//
//        public SpiceColorStopGradientFilling<T> twoColor(T firstColor, int firstColorPos, T secondColor, int secondColorPos) {
//            return twoColor(firstColor, firstColorPos, secondColor, secondColorPos, false);
//        }
//
//        public SpiceColorStopGradientFilling<T> twoColor(T firstColor, T secondColor, boolean repeating) {
//            return twoColor(firstColor, 0, secondColor, 999, repeating);
//        }
//
//        public SpiceColorStopGradientFilling<T> twoColor(T firstColor, T secondColor) {
//            return twoColor(firstColor, secondColor, false);
//        }
//
//        public abstract SpiceColorStopGradientFilling<T> createNew(Map<Integer, T> colorStopMap, boolean repeating);
//    }


}
