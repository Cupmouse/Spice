package net.spicesoftware.decoration.fill;

import net.spicesoftware.api.decoration.fill.DecorationFilling;
import net.spicesoftware.decoration.SpiceDecoration;

/**
 * @since 2015/07/08
 */
public abstract class SpiceDecorationFilling extends SpiceDecoration implements DecorationFilling {

    @Override
    public abstract SpiceDecorationFilling copyDeeply();
}
