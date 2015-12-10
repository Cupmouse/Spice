package net.spicesoftware.item;

import net.spicesoftware.api.item.ItemShape;
import net.spicesoftware.api.resource.ResourceShape;
import net.spicesoftware.api.util.ReflectionToString;

/**
 * @since 2015/04/21
 */
public class SpiceItemShape extends SpiceItemRenderable implements ItemShape {

    @Override
    public ResourceShape getResourceShape() {
        return null;
    }

    @Override
    public SpiceItemShape copyDeeply() {
        return new SpiceItemShape();
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}
