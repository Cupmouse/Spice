package net.spicesoftware.resource;

import net.spicesoftware.api.item.ItemVideo;
import net.spicesoftware.api.resource.ResourceVideo;
import net.spicesoftware.item.SpiceItemVideo;

import java.io.File;

/**
 * @since 2015/04/20
 */
public class SpiceResourceVideo extends SpiceResourceFromFile implements ResourceVideo {

    public SpiceResourceVideo(File file) {
        super(file);
    }

    @Override
    public ResourceVideo copyDeeply() {
        return new SpiceResourceVideo(file);
    }

    @Override
    public ItemVideo createNewItem() {
        return new SpiceItemVideo(this);
    }
}
