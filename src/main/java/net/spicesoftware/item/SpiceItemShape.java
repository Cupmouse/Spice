package net.spicesoftware.item;

import net.spicesoftware.api.item.ItemShape;
import net.spicesoftware.api.resource.ResourceShape;

/**
 * @since 2015/04/21
 */
public class SpiceItemShape extends SpiceItemRenderable implements ItemShape {

    @Override
    public ResourceShape getResourceShape() {
        return null;
    }

    @Override
    public ItemShape copyDeeply() {
        return null;
    }
}
