package net.spicesoftware.item;

import net.spicesoftware.api.item.ItemVideo;
import net.spicesoftware.api.resource.ResourceVideo;

/**
 * @since 2015/04/20
 */
public class SpiceItemVideo extends SpiceItem implements ItemVideo {

    private ResourceVideo resource;

    public SpiceItemVideo(ResourceVideo resource) {
        this.resource = resource;
    }

    @Override
    public ResourceVideo getResourceVideo() {
        return resource;
    }

    @Override
    public ItemVideo copyDeeply() {
        return new SpiceItemVideo(resource);
    }

    @Override
    public void markUpdateRender() {
        // TODO
    }
}
