package net.spicesoftware.resource;

import net.spicesoftware.api.item.ItemShape;
import net.spicesoftware.api.resource.ResourceShape;
import net.spicesoftware.item.SpiceItemShape;

/**
 * @since 2015/04/15
 */
public class SpiceResourceShape extends SpiceResource implements ResourceShape {

    @Override
    public ResourceShape copyDeeply() {
        return new SpiceResourceShape();
    }

    @Override
    public ItemShape createNewItem() {
        return new SpiceItemShape();
    }
}
