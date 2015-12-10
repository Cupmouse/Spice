package net.spicesoftware.gui.common.colorselector;

import net.spicesoftware.api.decoration.fill.RGB24Color;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @since 2015/08/02
 */
public class SpiceRGB24ColorSelectorSquarePanel1D extends javax.swing.JPanel {
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    private BufferedImage image;
    private int pointerY;

    public SpiceRGB24ColorSelectorSquarePanel1D() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(30, 256));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setPointerY(int pointerY) {
        if (pointerY < 0) {
            pointerY = 0;
        } else if (pointerY > getHeight() - 1) {
            pointerY = getHeight() - 1;
        }
        this.pointerY = pointerY;
        repaint();
    }

    public int getPointerY() {
        return pointerY;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        Graphics2D g2 = (Graphics2D) graphics;

        for (int x = 0; x < 30; x++) {
            g2.drawImage(image, null, x, 0);
        }

        // 線
        Color oppositeColor = new Color(RGB24Color.oppositeInt(image.getRGB(0, pointerY) & 0xFFFFFF));

        g2.setColor(oppositeColor);
        g2.drawLine(0, pointerY, 29, pointerY);

        // 三角形
        int triangleSize = 5;
        int[] triangleY = {pointerY - triangleSize, pointerY, pointerY + triangleSize};
        g2.fillPolygon(new int[] {0, triangleSize, 0}, triangleY, 3);
        g2.fillPolygon(new int[] {30, 30 - triangleSize, 30}, triangleY, 3);
    }

    public static int getYPosByHue(int hue) {
        return 0xFF - (hue * 0xFF) / 360;
    }

    public static int getHueByYPos(int y) {
        return 360 - (y * 360) / 0xFF;
    }
}
