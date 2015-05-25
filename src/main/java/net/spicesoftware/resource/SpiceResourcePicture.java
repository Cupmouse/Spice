package net.spicesoftware.resource;

import net.spicesoftware.api.item.ItemPicture;
import net.spicesoftware.api.resource.ResourcePicture;
import net.spicesoftware.item.SpiceItemPicture;

import java.io.File;

/**
 * @since 2015/04/14
 */
public class SpiceResourcePicture extends SpiceResourceFromFile implements ResourcePicture {

    public SpiceResourcePicture(File file) {
        super(file);
    }

    @Override
    public ResourcePicture copyDeeply() {
        return new SpiceResourcePicture(file);
    }

    @Override
    public ItemPicture createNewItem() {
        return new SpiceItemPicture(this);
    }
}
