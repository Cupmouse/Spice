package net.spicesoftware.resource;

import net.spicesoftware.api.item.ItemShape;
import net.spicesoftware.api.resource.ResourceShape;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.item.SpiceItemShape;

/**
 * @since 2015/04/15
 */
public final class SpiceResourceShape extends SpiceResource implements ResourceShape {

    @Override
    public ResourceShape copyDeeply() {
        return new SpiceResourceShape();
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}
