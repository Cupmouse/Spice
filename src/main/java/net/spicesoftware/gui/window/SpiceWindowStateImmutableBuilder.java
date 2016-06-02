package net.spicesoftware.gui.window;

import net.spicesoftware.api.gui.window.WindowStateImmutable;
import net.spicesoftware.api.gui.window.location.WindowLocation;
import net.spicesoftware.api.gui.window.title.WindowTitle;
import net.spicesoftware.api.util.vector.Vector2i;

/**
 * @since 2016/01/24
 */
public class SpiceWindowStateImmutableBuilder implements SpiceWindowStateImmutable.Builder {

    private WindowTitle windowTitle;
    private WindowLocation location;
    private Vector2i maximumSize;
    private Vector2i minimumSize;
    private Vector2i size;
    private boolean sizeFixed;
    private boolean visibility;

    @Override
    public WindowStateImmutable.Builder title(WindowTitle windowTitle) {
        this.windowTitle = windowTitle;
        return this;
    }

    @Override
    public WindowStateImmutable.Builder location(WindowLocation location) {
        this.location = location;
        return this;
    }

    @Override
    public WindowStateImmutable.Builder maxSize(Vector2i maxSize) {
        this.maximumSize = maxSize;
        return this;
    }

    @Override
    public WindowStateImmutable.Builder minSize(Vector2i minSize) {
        this.minimumSize = minSize;
        return this;
    }

    @Override
    public WindowStateImmutable.Builder size(Vector2i size) {
        this.size = size;
        return this;
    }

    @Override
    public WindowStateImmutable.Builder sizeFixed() {
        this.sizeFixed = true;
        return this;
    }

    @Override
    public WindowStateImmutable.Builder sizeFixed(boolean sizeFixed) {
        this.sizeFixed = sizeFixed;
        return this;
    }

    @Override
    public WindowStateImmutable.Builder invisible() {
        this.visibility = false;
        return this;
    }

    @Override
    public WindowStateImmutable.Builder visibility(boolean visibility) {
        this.visibility = visibility;
        return this;
    }

    @Override
    public WindowStateImmutable build() {
        return new SpiceWindowStateImmutable(windowTitle, location, maximumSize, minimumSize, size, sizeFixed, visibility);
    }
}
