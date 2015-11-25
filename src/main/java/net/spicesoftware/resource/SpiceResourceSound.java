package net.spicesoftware.resource;

import net.spicesoftware.api.item.ItemSound;
import net.spicesoftware.api.resource.ResourceSound;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.item.SpiceItemSound;

import java.io.File;

/**
 * @since 2015/04/20
 */
public final class SpiceResourceSound extends SpiceResourceFromFile implements ResourceSound {

    public SpiceResourceSound(File file) {
        super(file);
    }

    @Override
    public ResourceSound copyDeeply() {
        return new SpiceResourceSound(file);
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}
