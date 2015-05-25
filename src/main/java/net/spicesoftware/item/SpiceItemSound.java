package net.spicesoftware.item;

import net.spicesoftware.api.item.ItemSound;
import net.spicesoftware.api.resource.ResourceSound;

/**
 * @since 2015/04/20
 */
public class SpiceItemSound extends SpiceItem implements ItemSound {

    private ResourceSound resource;

    public SpiceItemSound(ResourceSound resource) {
        this.resource = resource;
    }

    @Override
    public ResourceSound getResourceSound() {
        return resource;
    }

    @Override
    public ItemSound copyDeeply() {
        return new SpiceItemSound(resource);
    }
}
