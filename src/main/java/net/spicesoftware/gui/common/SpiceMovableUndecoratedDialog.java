package net.spicesoftware.gui.common;

import net.spicesoftware.swinggui.SwingDialogWindow;

import javax.swing.*;
import java.awt.*;

/**
 * @since 2015/10/03
 */
public class SpiceMovableUndecoratedDialog extends SwingDialogWindow {

    private int pressedY;
    private int pressedX;

    public SpiceMovableUndecoratedDialog(Frame owner, boolean modal) {
        super(owner, modal);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
    }

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        setLocation(evt.getXOnScreen() - pressedX, evt.getYOnScreen() - pressedY);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        pressedX = evt.getX();
        pressedY = evt.getY();
    }//GEN-LAST:event_formMousePressed
}
