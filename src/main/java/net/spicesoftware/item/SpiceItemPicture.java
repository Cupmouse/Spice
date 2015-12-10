package net.spicesoftware.item;

import net.spicesoftware.api.item.ItemPicture;
import net.spicesoftware.api.resource.ResourcePicture;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.api.util.ToString;

/**
 * @since 2015/04/14
 */
public class SpiceItemPicture extends SpiceItemRenderable implements ItemPicture {

    @ToString
    private ResourcePicture resourcePicture;

    public SpiceItemPicture(ResourcePicture resourcePicture) {
        this.resourcePicture = resourcePicture;
    }

    @Override
    public ResourcePicture getResourcePicture() {
        return resourcePicture;
    }

    @Override
    public ItemPicture copyDeeply() {
        return new SpiceItemPicture(resourcePicture);
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}
