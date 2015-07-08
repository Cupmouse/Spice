package net.spicesoftware.decoration.fill;

import net.spicesoftware.api.decoration.fill.PatternFilling;

/**
 * @since 2015/07/08
 */
public abstract class SpicePatternFilling extends SpiceDecorationFilling implements PatternFilling {

    @Override
    public abstract SpicePatternFilling copyDeeply();
}
