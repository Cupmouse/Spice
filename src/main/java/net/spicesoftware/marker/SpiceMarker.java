package net.spicesoftware.marker;

import net.spicesoftware.api.marker.Marker;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.api.util.ToString;

import java.util.Optional;

/**
 * @since 2015/04/07
 */
public class SpiceMarker implements Marker {

    @ToString
    private String text;

    public SpiceMarker() {
    }

    public SpiceMarker(String text) {
        this.text = text;
    }

    @Override
    public Optional<String> getText() {
        return Optional.ofNullable(text);
    }

    @Override
    public Marker copyDeeply() {
        return new SpiceMarker(text);
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}
