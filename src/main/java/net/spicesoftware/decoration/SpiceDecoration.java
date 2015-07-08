package net.spicesoftware.decoration;

import net.spicesoftware.api.decoration.Decoration;

/**
 * @since 2015/07/08
 */
public abstract class SpiceDecoration implements Decoration {

    @Override
    public abstract SpiceDecoration copyDeeply();
}
