package net.spicesoftware.plugin;

import net.spicesoftware.api.plugin.Plugin;
import net.spicesoftware.api.plugin.PluginContainer;

import java.util.Optional;

/**
 * @since 2015/04/20
 */
public class SpicePluginContainer implements PluginContainer {

    private final String name;
    private final String id;
    private final String[] pluginIdsDepend;
    private final String spiceAPIVersionDepend;
    private Plugin instance;
    private boolean initialized;
    private boolean enabled;

    public SpicePluginContainer(String name, String id, String[] pluginIdsDepend, String spiceAPIVersionDepend) {
        this.name = name;
        this.id = id;
        this.pluginIdsDepend = pluginIdsDepend;
        this.spiceAPIVersionDepend = spiceAPIVersionDepend;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public String[] getPluginIDsDepend() {
        return pluginIdsDepend;
    }

    @Override
    public String getSpiceAPIVersionDepend() {
        return spiceAPIVersionDepend;
    }

    @Override
    public Optional<Plugin> getInstance() {
        return Optional.ofNullable(instance);
    }

    @Override
    public boolean isInitialized() {
        return initialized;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public boolean isCompatible() {
        // TODO
        return false;
    }
}