/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.spicesoftware.gui.common.colorselector;

import net.spicesoftware.api.util.decoration.fill.color.HSV360Color;
import net.spicesoftware.api.util.decoration.fill.color.RGB24Color;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @since 2015/07/30
 */
public class SpiceRGB24ColorSelectorSquarePanel2D extends javax.swing.JPanel {
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    private BufferedImage image;
    private int pointerX;
    private int pointerY;

    public SpiceRGB24ColorSelectorSquarePanel2D() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(256, 256));

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

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setPointer(int pointerX, int pointerY) {
        if (pointerX < 0) {
            pointerX = 0;
        } else if (pointerX > getWidth() - 1) {
            pointerX = getWidth() - 1;
        }
        if (pointerY < 0) {
            pointerY = 0;
        } else if (pointerY > getHeight() - 1) {
            pointerY = getHeight() - 1;
        }
        this.pointerX = pointerX;
        this.pointerY = pointerY;
        repaint();
    }

    public void setPointerX(int pointerX) {
        if (pointerX < 0) {
            pointerX = 0;
        } else if (pointerX > getWidth() - 1) {
            pointerX = getWidth() - 1;
        }
        this.pointerX = pointerX;
        repaint();
    }

    public void setPointerY(int pointerY) {
        if (pointerY < 0) {
            pointerY = 0;
        } else if (pointerY > getHeight() - 1) {
            pointerY = getHeight() - 1;
        }
        this.pointerY = pointerY;
        repaint();
    }

    public int getPointerX() {
        return pointerX;
    }

    public int getPointerY() {
        return pointerY;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        final Graphics2D g2 = (Graphics2D) graphics;

        g2.drawImage(image, null, 0, 0);

        Color oppositeColor = new Color(RGB24Color.oppositeInt(image.getRGB(pointerX, pointerY) & 0xFFFFFF));
        g2.setColor(oppositeColor);

        int crossSize = 4;
        g2.drawLine(pointerX - crossSize, pointerY, pointerX + crossSize, pointerY);
        g2.drawLine(pointerX, pointerY - crossSize, pointerX, pointerY + crossSize);
    }
}
