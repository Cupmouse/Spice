package net.spicesoftware.project.resource;

import net.spicesoftware.api.project.resource.ResourceTreeFolder;
import net.spicesoftware.api.resource.Resource;
import net.spicesoftware.api.util.ResourceAlreadyExistInTreeException;
import net.spicesoftware.api.util.ReflectionToString;
import net.spicesoftware.api.util.ToString;
import net.spicesoftware.api.util.Validate;

import java.util.*;

/**
 * @since 2015/04/14
 */
public class SpiceResourceTreeFolder implements ResourceTreeFolder {

    @ToString
    private SpiceResourceManager resourceManager;
    @ToString
    private Map<String, Resource> resourceMap = new HashMap<>();
    @ToString
    private Map<String, SpiceResourceTreeFolder> folderMap = new HashMap<>();

    public SpiceResourceTreeFolder(SpiceResourceManager resourceManager) {
        this.resourceManager = resourceManager;
    }

    @Override
    public Map<String, Resource> getResourceMap() {
        return Collections.unmodifiableMap(resourceMap);
    }

    @Override
    public Optional<Resource> getResource(String name) {
        return Optional.ofNullable(resourceMap.get(name));
    }

    @Override
    public Optional<Resource> getResource(String... path) {
        Optional<ResourceTreeFolder> folderOptional = getFolder(Arrays.copyOf(path, path.length - 1));
        if (folderOptional.isPresent()) {
            return folderOptional.get().getResource(path[path.length - 1]);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Resource addResource(Resource resource, String name) throws ResourceAlreadyExistInTreeException {
        if (resourceMap.containsKey(name)) {
            throw new ResourceAlreadyExistInTreeException();
        }
        resourceMap.put(name, resource);
        return resource;
    }

    @Override
    public void removeResource(String name) {
        resourceMap.remove(name);
    }

    @Override
    public Resource renameResourceTo(String beforeName, String afterName) throws IllegalArgumentException {
        Validate.truE(resourceMap.containsKey(beforeName));
        Validate.falsE(resourceMap.containsKey(afterName));
        Resource removed = resourceMap.remove(beforeName);
        resourceMap.put(afterName, removed);
        return removed;
    }

    @Override
    public Map<String, ResourceTreeFolder> getFolderMap() {
        return Collections.unmodifiableMap(folderMap);
    }

    @Override
    public Optional<ResourceTreeFolder> getFolder(String name) {
        return Optional.ofNullable(folderMap.get(name));
    }

    @Override
    public Optional<ResourceTreeFolder> getFolder(String... path) {
        // TODO 一個づつ配列を前から消してバケツリレーもありじゃないか
        SpiceResourceTreeFolder currentPos = this;

        for (int i = 0; i < path.length; i++) {
            currentPos = currentPos.folderMap.get(path[i]);

            if (currentPos == null) {
                return Optional.empty();
            }
        }

        return Optional.of(currentPos);
    }

    @Override
    public ResourceTreeFolder createNewFolder(String name) {
        if (folderMap.containsKey(name)) {
            throw new IllegalArgumentException();
        }
        SpiceResourceTreeFolder created = new SpiceResourceTreeFolder(resourceManager);
        folderMap.put(name, created);
        return created;
    }

    @Override
    public String toString() {
        return ReflectionToString.rts(this);
    }
}
