package net.spicesoftware.resource;

import net.spicesoftware.api.item.ItemSound;
import net.spicesoftware.api.resource.ResourceSound;
import net.spicesoftware.item.SpiceItemSound;

import java.io.File;

/**
 * @since 2015/04/20
 */
public class SpiceResourceSound extends SpiceResourceFromFile implements ResourceSound {

    public SpiceResourceSound(File file) {
        super(file);
    }

    @Override
    public ResourceSound copyDeeply() {
        return new SpiceResourceSound(file);
    }

    @Override
    public ItemSound createNewItem() {
        return new SpiceItemSound(this);
    }
}
