package net.spicesoftware.item;

import net.spicesoftware.api.item.ItemVideo;
import net.spicesoftware.api.resource.ResourceVideo;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.api.util.ToString;

/**
 * @since 2015/04/20
 */
public class SpiceItemVideo extends SpiceItem implements ItemVideo {

    @ToString
    private ResourceVideo resource;

    public SpiceItemVideo(ResourceVideo resource) {
        this.resource = resource;
    }

    @Override
    public ResourceVideo getResourceVideo() {
        return resource;
    }

    @Override
    public SpiceItemVideo copyDeeply() {
        return new SpiceItemVideo(resource);
    }

    @Override
    public void markUpdateRender() {
        // TODO
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}
