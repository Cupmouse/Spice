package net.spicesoftware.marker;

import net.spicesoftware.api.marker.Marker;
import net.spicesoftware.api.marker.Markers;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.api.util.ToString;

import javax.validation.constraints.Min;
import java.util.*;

/**
 * @since 2015/04/07
 */
public class SpiceMarkers implements Markers {

    @ToString
    private TreeMap<Integer, Marker> markers = new TreeMap<>();

    @Override
    public Map<Integer, Marker> getMarkerMap() {
        return Collections.unmodifiableMap(markers);
    }

    @Override
    public int getNumberOfMarkers() {
        return markers.size();
    }

    @Override
    public Optional<Marker> getMarkerAt(@Min(0) int frame) {
        return Optional.ofNullable(markers.get(frame));
    }

    @Override
    public SpiceMarker addMarkerAt(@Min(0) int frame) {
        SpiceMarker marker = new SpiceMarker();
        markers.put(frame, marker);
        return marker;
    }

    @Override
    public void removeMarkerAt(@Min(0) int frame) {
        markers.remove(frame);
    }

    @Override
    public SpiceMarkers copyDeeply() {
        SpiceMarkers copied = new SpiceMarkers();
        for (Map.Entry<Integer, Marker> entry : markers.entrySet()) {
            copied.markers.put(entry.getKey(), entry.getValue().copyDeeply());
        }
        return copied;
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}
