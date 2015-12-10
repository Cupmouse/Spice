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
public class SpiceDialog extends JDialog implements Window {

    public SpiceDialog() {
    }

    public SpiceDialog(Frame owner) {
        super(owner);
    }

    public SpiceDialog(Frame owner, boolean modal) {
        super(owner, modal);
    }

    public SpiceDialog(Frame owner, String title) {
        super(owner, title);
    }

    public SpiceDialog(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
    }

    public SpiceDialog(Frame owner, String title, boolean modal, GraphicsConfiguration gc) {
        super(owner, title, modal, gc);
    }

    public SpiceDialog(Dialog owner) {
        super(owner);
    }

    public SpiceDialog(Dialog owner, boolean modal) {
        super(owner, modal);
    }

    public SpiceDialog(Dialog owner, String title) {
        super(owner, title);
    }

    public SpiceDialog(Dialog owner, String title, boolean modal) {
        super(owner, title, modal);
    }

    public SpiceDialog(Dialog owner, String title, boolean modal, GraphicsConfiguration gc) {
        super(owner, title, modal, gc);
    }

    public SpiceDialog(java.awt.Window owner) {
        super(owner);
    }

    public SpiceDialog(java.awt.Window owner, ModalityType modalityType) {
        super(owner, modalityType);
    }

    public SpiceDialog(java.awt.Window owner, String title) {
        super(owner, title);
    }

    public SpiceDialog(java.awt.Window owner, String title, ModalityType modalityType) {
        super(owner, title, modalityType);
    }

    public SpiceDialog(java.awt.Window owner, String title, ModalityType modalityType, GraphicsConfiguration gc) {
        super(owner, title, modalityType, gc);
    }

    @Override
    public Optional<WindowTitle> getDefaultTitle() {
        return null;
    }

    @Override
    public Vector2i getDefaultSize() {
        return null;
    }
}
