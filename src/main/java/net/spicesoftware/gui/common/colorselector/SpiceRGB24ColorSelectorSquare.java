package net.spicesoftware.gui.common.colorselector;

import net.spicesoftware.api.decoration.fill.HSV360Color;
import net.spicesoftware.api.decoration.fill.RGB24Color;
import net.spicesoftware.api.gui.common.colorpicker.RGB24ColorSelectorSquare;

import java.awt.image.BufferedImage;

/**
 * @author Cupmouse
 */
public class SpiceRGB24ColorSelectorSquare extends javax.swing.JPanel implements RGB24ColorSelectorSquare {
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private net.spicesoftware.gui.common.colorselector.SpiceRGB24ColorSelectorSquarePanel1D d1;
    private net.spicesoftware.gui.common.colorselector.SpiceRGB24ColorSelectorSquarePanel2D d2;
    private javax.swing.JPanel panelBorder1D;
    private javax.swing.JPanel panelBorder2D;
    // End of variables declaration//GEN-END:variables
    private final SpiceDialogRGB24ColorPicker colorPicker;

    private boolean d2Dragging;
    private boolean d1Dragging;
    private LockedElement lockedElement;

    public SpiceRGB24ColorSelectorSquare(SpiceDialogRGB24ColorPicker colorPicker) {
        this.colorPicker = colorPicker;
        initComponents();
        setLockedElement(LockedElement.H);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder2D = new javax.swing.JPanel();
        d2 = new net.spicesoftware.gui.common.colorselector.SpiceRGB24ColorSelectorSquarePanel2D();
        panelBorder1D = new javax.swing.JPanel();
        d1 = new net.spicesoftware.gui.common.colorselector.SpiceRGB24ColorSelectorSquarePanel1D();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        panelBorder2D.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        panelBorder2D.setLayout(new javax.swing.BoxLayout(panelBorder2D, javax.swing.BoxLayout.LINE_AXIS));

        d2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                d2MouseDragged(evt);
            }
        });
        d2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                d2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                d2MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout d2Layout = new javax.swing.GroupLayout(d2);
        d2.setLayout(d2Layout);
        d2Layout.setHorizontalGroup(
            d2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );
        d2Layout.setVerticalGroup(
            d2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );

        panelBorder2D.add(d2);

        add(panelBorder2D);

        panelBorder1D.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        panelBorder1D.setLayout(new javax.swing.BoxLayout(panelBorder1D, javax.swing.BoxLayout.LINE_AXIS));

        d1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                d1MouseDragged(evt);
            }
        });
        d1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                d1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                d1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout d1Layout = new javax.swing.GroupLayout(d1);
        d1.setLayout(d1Layout);
        d1Layout.setHorizontalGroup(
            d1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );
        d1Layout.setVerticalGroup(
            d1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );

        panelBorder1D.add(d1);

        add(panelBorder1D);
    }// </editor-fold>//GEN-END:initComponents

    private void d2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d2MousePressed
        d2Dragging = true;
        d2MouseDragged(evt);
    }//GEN-LAST:event_d2MousePressed

    private void d2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d2MouseReleased
        d2Dragging = false;
    }//GEN-LAST:event_d2MouseReleased

    private void d1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1MousePressed
        d1Dragging = true;
        d1MouseDragged(evt);
    }//GEN-LAST:event_d1MousePressed

    private void d1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1MouseReleased
        d1Dragging = false;
    }//GEN-LAST:event_d1MouseReleased

    private void d2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d2MouseDragged
        if (d2Dragging) {
            d2.setPointer(evt.getX(), evt.getY());
            renderAndSet1D(lockedElement);
            d1.repaint();
        }
    }//GEN-LAST:event_d2MouseDragged

    private void d1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1MouseDragged
        if (d1Dragging) {
            d1.setPointerY(evt.getY());
            renderAndSet2D(lockedElement);
            d2.repaint();
        }
    }//GEN-LAST:event_d1MouseDragged

    @Override
    public LockedElement getLockedElement() {
        return lockedElement;
    }

    @Override
    public void setLockedElement(LockedElement lockedElement) {
        this.lockedElement = lockedElement;

        switch (lockedElement) {
            case H:
                colorPicker.radioButtonH.setSelected(true);
                break;
            case S:
                colorPicker.radioButtonS.setSelected(true);
                break;
            case V:
                colorPicker.radioButtonV.setSelected(true);
                break;
            case R:
                break;
            case G:
                break;
            case B:
                break;
        }
        renderAndSet1D(lockedElement);
        renderAndSet2D(lockedElement);
        d1.repaint();
        d2.repaint();
    }

    private void renderAndSet1D(LockedElement lockedElement) {
        BufferedImage bufferedImage = new BufferedImage(1, 256, BufferedImage.TYPE_INT_RGB);

        switch (lockedElement) {
            case H:
                for (int y = 0; y < 256; y++) {
                    bufferedImage.setRGB(0, y, HSV360Color.toRGB24Int((y * 360) / 0xFF, d2.getPointerX(), 0xFF - d2.getPointerY()));
                }
                break;
            case S:
                for (int y = 0; y < 256; y++) {
                    bufferedImage.setRGB(0, y, HSV360Color.toRGB24Int((d2.getPointerX() * 360) / 0xFF, y, 0xFF - d2.getPointerY()));
                }
                break;
            case V:
                for (int y = 0; y < 256; y++) {
                    bufferedImage.setRGB(0, 0xFF - y, HSV360Color.toRGB24Int((d2.getPointerX() * 360) / 0xFF, 0xFF - d2.getPointerY(), y));
                }
                break;
            case R:
                break;
            case G:
                break;
            case B:
                break;
        }

        d1.setImage(bufferedImage);
    }

    private void renderAndSet2D(LockedElement lockedElement) {
        BufferedImage bufferedImage = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);

        switch (lockedElement) {
            case H:
                for (short x = 0; x < 256; x++) {
                    for (short y = 0; y < 256; y++) {
                        bufferedImage.setRGB(x, 0xFF - y, HSV360Color.toRGB24Int((360 * d1.getPointerY()) / 0xFF, x, y));
                    }
                }
                break;
            case S:
                for (short x = 0; x < 256; x++) {
                    for (short y = 0; y < 256; y++) {
                        bufferedImage.setRGB(x, y, HSV360Color.toRGB24Int((360 * x) / 0xFF, d1.getPointerY(), 0xFF - y));
                    }
                }
                break;
            case V:
                for (short x = 0; x < 256; x++) {
                    for (short y = 0; y < 256; y++) {
                        bufferedImage.setRGB(x, y, HSV360Color.toRGB24Int((360 * x) / 0xFF, 0xFF - y, 0xFF - d2.getPointerY()));
                    }
                }
                break;
            case R:
                break;
            case G:
                break;
            case B:
                break;
        }

        d2.setImage(bufferedImage);
    }

    @Override
    public RGB24Color getSelectedColor() {
        return null;
    }

    @Override
    public void setSelectedColor(RGB24Color rgb24Color) {

    }
}
