package net.spicesoftware.item;

import net.spicesoftware.api.item.StaticItem;
import net.spicesoftware.marker.SpiceMarkers;
import net.spicesoftware.value.SpiceValues;

/**
 * @since 2015/04/07
 */
public abstract class SpiceStaticItem implements StaticItem {

    private SpiceValues values;
    private SpiceMarkers markers;

    public SpiceStaticItem() {
        this.values = new SpiceValues();
        this.markers = new SpiceMarkers();
    }

    @Override
    public SpiceValues getValues() {
        return values;
    }

    @Override
    public SpiceMarkers getMarkers() {
        return markers;
    }
}
