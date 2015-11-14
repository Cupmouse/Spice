package net.spicesoftware.project.resource;

import net.spicesoftware.api.project.resource.ResourceManager;
import net.spicesoftware.api.project.resource.ResourceTreeFolder;
import net.spicesoftware.api.resource.Resource;

import java.util.Collections;
import java.util.Set;

/**
 * @since 2015/04/14
 */
public class SpiceResourceManager implements ResourceManager {

    private SpiceResourceTreeFolder resourceTreeRoot;
    private Set<Resource> allResourceCache;

    public SpiceResourceManager() {
        this.resourceTreeRoot = new SpiceResourceTreeFolder();
    }

    @Override
    public ResourceTreeFolder getRootOfResourceTree() {
        return resourceTreeRoot;
    }

    @Override
    public Set<Resource> getAllResourcesInTree() {
        return Collections.unmodifiableSet(allResourceCache);
    }
}
