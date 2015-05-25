package net.spicesoftware.plugin;

import net.spicesoftware.api.plugin.PluginContainer;
import net.spicesoftware.api.plugin.PluginManager;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * @since 2015/04/20
 */
public class SpicePluginManager implements PluginManager {

    private Map<String, SpicePluginContainer> pluginContainers;
    private Set<PluginContainer> pluginContainersSet;

    @Override
    public Set<PluginContainer> getPlugins() {
        return Collections.unmodifiableSet(pluginContainersSet);
    }

    @Override
    public Optional<PluginContainer> getPlugin(String id) {
        return Optional.ofNullable(pluginContainers.get(id));
    }
}
