package net.spicesoftware.marker;

import net.spicesoftware.api.marker.Marker;

import java.util.Optional;

/**
 * @since 2015/04/07
 */
public class SpiceMarker implements Marker {

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
}
