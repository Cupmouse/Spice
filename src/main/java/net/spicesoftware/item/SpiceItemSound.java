package net.spicesoftware.item;

import net.spicesoftware.api.item.ItemSound;
import net.spicesoftware.api.resource.ResourceSound;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.api.util.ToString;

/**
 * @since 2015/04/20
 */
public class SpiceItemSound extends SpiceItem implements ItemSound {

    @ToString
    private ResourceSound resource;

    public SpiceItemSound(ResourceSound resource) {
        this.resource = resource;
    }

    @Override
    public ResourceSound getResourceSound() {
        return resource;
    }

    @Override
    public SpiceItemSound copyDeeply() {
        return new SpiceItemSound(resource);
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}
