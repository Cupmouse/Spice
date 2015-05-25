package net.spicesoftware.resource;

import net.spicesoftware.api.marker.Markers;
import net.spicesoftware.api.resource.Resource;
import net.spicesoftware.marker.SpiceMarkers;

/**
 * @since 2015/04/14
 */
public abstract class SpiceResource implements Resource {

    private Markers markers;

    public SpiceResource() {
        this.markers = new SpiceMarkers();
    }

    @Override
    public Markers getMarkers() {
        return markers;
    }
}
