package net.spicesoftware.project.resource;

import net.spicesoftware.api.project.resource.ResourceTreeFolder;
import net.spicesoftware.api.resource.Resource;
import net.spicesoftware.api.util.ResourceAlreadyExistInTreeException;

import java.util.*;

/**
 * @since 2015/04/14
 */
public class SpiceResourceTreeFolder implements ResourceTreeFolder {

    private Map<String, Resource> resourceMap = new HashMap<>();
    private Map<String, ResourceTreeFolder> foldersMap = new HashMap<>();

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
    public Resource addResourceCopyOf(Resource resource, String name) {
        Resource copiedResource = resource.copyDeeply();
        resourceMap.put(name, copiedResource);
        return copiedResource;
    }

    @Override
    public Resource addResource(Resource resource, String name) throws ResourceAlreadyExistInTreeException {
        resourceMap.put(name, resource);
        return resource;
    }

    @Override
    public void removeResource(String name) {
        resourceMap.remove(name);
    }

    @Override
    public Resource renameResourceTo(String beforeName, String afterName) {
        Resource renamed = resourceMap.remove(beforeName);
        resourceMap.put(afterName, renamed);
        return renamed;
    }

    @Override
    public Map<String, ResourceTreeFolder> getFolderMap() {
        return Collections.unmodifiableMap(foldersMap);
    }

    @Override
    public Optional<ResourceTreeFolder> getFolder(String name) {
        return Optional.ofNullable(foldersMap.get(name));
    }

    @Override
    public Optional<ResourceTreeFolder> getFolder(String... path) {
        ResourceTreeFolder currentFolder = this;
        for (int i = 0; i < path.length; i++) {
            Optional<ResourceTreeFolder> folder = currentFolder.getFolder(path[i]);

            if (!folder.isPresent()) {
                return Optional.empty();
            }

            currentFolder = folder.get();
        }

        return Optional.of(currentFolder);
    }

    @Override
    public ResourceTreeFolder createNewFolder(String name) {
        if (foldersMap.containsKey(name)) {
            throw new IllegalArgumentException();
        }
        ResourceTreeFolder newElement = new SpiceResourceTreeFolder();
        foldersMap.put(name, newElement);
        return newElement;
    }
}
