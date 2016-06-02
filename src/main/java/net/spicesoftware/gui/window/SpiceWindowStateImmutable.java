package net.spicesoftware.gui.window;

import net.spicesoftware.api.gui.window.WindowStateImmutable;
import net.spicesoftware.api.gui.window.location.WindowLocation;
import net.spicesoftware.api.gui.window.title.WindowTitle;
import net.spicesoftware.api.util.vector.Vector2i;

/**
 * @since 2016/01/24
 */
public class SpiceWindowStateImmutable implements WindowStateImmutable {

    private WindowTitle windowTitle;
    private WindowLocation location;
    private Vector2i maximumSize;
    private Vector2i minimumSize;
    private Vector2i size;
    private boolean sizeFixed;
    private boolean visibility;

    protected SpiceWindowStateImmutable(WindowTitle windowTitle, WindowLocation location, Vector2i maximumSize, Vector2i minimumSize, Vector2i size, boolean sizeFixed, boolean visibility) {
        this.windowTitle = windowTitle;
        this.location = location;
        this.maximumSize = maximumSize;
        this.minimumSize = minimumSize;
        this.size = size;
        this.sizeFixed = sizeFixed;
        this.visibility = visibility;
    }

    @Override
    public WindowTitle getTitle() {
        return windowTitle;
    }

    @Override
    public WindowLocation getLocation() {
        return location;
    }

    @Override
    public Vector2i getMaximumSize() {
        return maximumSize;
    }

    @Override
    public Vector2i getMinimumSize() {
        return minimumSize;
    }

    @Override
    public Vector2i getSize() {
        return size;
    }

    @Override
    public boolean isSizeFixed() {
        return sizeFixed;
    }

    @Override
    public boolean isVisible() {
        return visibility;
    }
}
