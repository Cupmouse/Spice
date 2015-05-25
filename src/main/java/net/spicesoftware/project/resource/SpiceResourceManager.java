package net.spicesoftware.project.resource;

import net.spicesoftware.api.project.resource.ResourceManager;
import net.spicesoftware.api.project.resource.ResourceTreeElement;
import net.spicesoftware.api.resource.Resource;

import java.util.Set;

/**
 * @since 2015/04/14
 */
public class SpiceResourceManager implements ResourceManager {

    private SpiceResourceTreeElement resourceTreeRoot;
    private Set<Resource> allResourceCache;

    @Override
    public ResourceTreeElement getRootResourceTree() {
        return resourceTreeRoot;
    }

    @Override
    public Set<Resource> getAllResourceInTree() {
        return allResourceCache;
    }
}
