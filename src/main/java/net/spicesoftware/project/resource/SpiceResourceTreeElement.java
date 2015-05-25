package net.spicesoftware.project.resource;

import net.spicesoftware.api.project.resource.ResourceTreeElement;
import net.spicesoftware.api.resource.Resource;
import net.spicesoftware.api.util.ResourceAlreadyExistInTreeException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @since 2015/04/14
 */
public class SpiceResourceTreeElement implements ResourceTreeElement {

    private Map<String, Resource> map = new HashMap<>();
    private Map<String, ResourceTreeElement> childMap;

    @Override
    public Map<String, Resource> getResourceMap() {
        return Collections.unmodifiableMap(map);
    }

    @Override
    public Optional<Resource> getResource(String name) {
        return Optional.ofNullable(map.get(name));
    }

    @Override
    public Resource addResourceCopyOf(Resource resource, String name) {
        Resource copiedResource = resource.copyDeeply();
        map.put(name, copiedResource);
        return copiedResource;
    }

    @Override
    public Resource addResource(Resource resource, String name) throws ResourceAlreadyExistInTreeException {
        map.put(name, resource);
        return resource;
    }

    @Override
    public void removeResource(String name) {
        map.remove(name);
    }

    @Override
    public Resource renameResourceTo(String beforeName, String afterName) {
        Resource renamed = map.remove(beforeName);
        map.put(afterName, renamed);
        return renamed;
    }

    @Override
    public Map<String, ResourceTreeElement> getChildElementMap() {
        return Collections.unmodifiableMap(childMap);
    }

    @Override
    public Optional<ResourceTreeElement> getChildElement(String name) {
        return Optional.ofNullable(childMap.get(name));
    }

    @Override
    public ResourceTreeElement createChildElement(String name) {
        if (childMap.containsKey(name)) {
            throw new IllegalArgumentException();
        }
        ResourceTreeElement newElement = new SpiceResourceTreeElement();
        childMap.put(name, newElement);
        return newElement;
    }
}
