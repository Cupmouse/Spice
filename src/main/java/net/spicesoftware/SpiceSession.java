package net.spicesoftware;

import net.spicesoftware.api.Spice;
import net.spicesoftware.api.project.Project;
import net.spicesoftware.registry.SpiceRegistry;

import java.util.Optional;

/**
 * @since 2015/03/19
 */
public final class SpiceSession implements Spice {

    public static final String SPICE_VERSION = "alpha-0.0.1";
    private static SpiceSession instance;

    private SpiceRegistry registry;
    private Project projectOpening;

    public SpiceSession() {
        instance = this;
//        this.registry = new SpiceRegistry();
    }

    public static SpiceSession getInstance() {
        return instance;
    }

    @Override
    public SpiceRegistry getRegistry() {
        return this.registry;
    }

    @Override
    public String getImplementationVersion() {
        return SPICE_VERSION;
    }

    @Override
    public Optional<Project> getProject() {
        return Optional.ofNullable(this.projectOpening);
    }

    @Override
    public void openProject(Project project) {
        this.projectOpening = project;
    }
}
