package net.spicesoftware.gui.common.colorselector;

import net.spicesoftware.gui.common.spinner.SpiceIntSpinner;

/**
 * @since 2015/07/06
 */
public class SpiceColorSelectorSpinner extends SpiceIntSpinner {

    public SpiceColorSelectorSpinner(String unit, int value) {
        super(unit, value);
        initMoreComponents();
    }

    public SpiceColorSelectorSpinner(int value) {
        this(null, value);
    }

    public SpiceColorSelectorSpinner() {
        this(null, 0);
    }

    private void initMoreComponents() {

    }

}
