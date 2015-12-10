package net.spicesoftware.gui;

import net.spicesoftware.api.gui.Window;
import net.spicesoftware.api.gui.WindowTitle;
import net.spicesoftware.api.util.vector.Vector2i;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

/**
 * @since 2015/11/25
 */
public class SpiceWindow extends JFrame implements Window {

    private WindowTitle defaultTitle;
    private Vector2i defaultSize = Vector2i.ZERO;

    public SpiceWindow(WindowTitle defaultTitle, Vector2i defaultSize) throws HeadlessException {
        this.defaultTitle = defaultTitle;
        this.defaultSize = defaultSize;
    }

    public SpiceWindow(GraphicsConfiguration gc, WindowTitle defaultTitle, Vector2i defaultSize) {
        super(gc);
        this.defaultTitle = defaultTitle;
        this.defaultSize = defaultSize;
    }

    public SpiceWindow(String title, WindowTitle defaultTitle, Vector2i defaultSize) throws HeadlessException {
        super(title);
        this.defaultTitle = defaultTitle;
        this.defaultSize = defaultSize;
    }

    public SpiceWindow(String title, GraphicsConfiguration gc, WindowTitle defaultTitle, Vector2i defaultSize) {
        super(title, gc);
        this.defaultTitle = defaultTitle;
        this.defaultSize = defaultSize;
    }

    @Override
    public Optional<WindowTitle> getDefaultTitle() {
        return Optional.ofNullable(defaultTitle);
    }

    @Override
    public Vector2i getDefaultSize() {
        return defaultSize;
    }
}
