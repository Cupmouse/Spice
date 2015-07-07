/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package net.spicesoftware.gui.common.colorselector;

import net.spicesoftware.api.gui.common.colorpicker.RGB24ColorSelectorSquare;
import net.spicesoftware.api.gui.common.spinner.IntSpinner;
import net.spicesoftware.api.util.color.RGB24Color;

/**
 * @author Cupmouse
 */
public class SpiceRGB24ColorSelectorSquare extends javax.swing.JPanel implements RGB24ColorSelectorSquare {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel1D;
    private javax.swing.JPanel panel2D;
    private javax.swing.JPanel panelBorder1D;
    private javax.swing.JPanel panelBorder2D;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form SpiceColorSelectorSquare
     */
    public SpiceRGB24ColorSelectorSquare() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder2D = new javax.swing.JPanel();
        panel2D = new javax.swing.JPanel();
        panelBorder1D = new javax.swing.JPanel();
        panel1D = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        panelBorder2D.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        panelBorder2D.setLayout(new javax.swing.BoxLayout(panelBorder2D, javax.swing.BoxLayout.LINE_AXIS));

        panel2D.setPreferredSize(new java.awt.Dimension(256, 256));

        javax.swing.GroupLayout panel2DLayout = new javax.swing.GroupLayout(panel2D);
        panel2D.setLayout(panel2DLayout);
        panel2DLayout.setHorizontalGroup(
                panel2DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 303, Short.MAX_VALUE)
        );
        panel2DLayout.setVerticalGroup(
                panel2DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 286, Short.MAX_VALUE)
        );

        panelBorder2D.add(panel2D);

        add(panelBorder2D);

        panelBorder1D.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        panelBorder1D.setLayout(new javax.swing.BoxLayout(panelBorder1D, javax.swing.BoxLayout.LINE_AXIS));

        panel1D.setPreferredSize(new java.awt.Dimension(30, 256));

        javax.swing.GroupLayout panel1DLayout = new javax.swing.GroupLayout(panel1D);
        panel1D.setLayout(panel1DLayout);
        panel1DLayout.setHorizontalGroup(
                panel1DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 78, Short.MAX_VALUE)
        );
        panel1DLayout.setVerticalGroup(
                panel1DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 286, Short.MAX_VALUE)
        );

        panelBorder1D.add(panel1D);

        add(panelBorder1D);
    }// </editor-fold>//GEN-END:initComponents


    // TODO implement
    @Override
    public IntSpinner getIntSpinnerH() {
        return null;
    }

    @Override
    public IntSpinner getIntSpinnerS() {
        return null;
    }

    @Override
    public IntSpinner getIntSpinnerV() {
        return null;
    }

    @Override
    public IntSpinner getIntSpinnerR() {
        return null;
    }

    @Override
    public IntSpinner getIntSpinnerG() {
        return null;
    }

    @Override
    public IntSpinner getIntSpinnerB() {
        return null;
    }

    @Override
    public LockedElement getLockedElement() {
        return null;
    }

    @Override
    public void setLockedElement(LockedElement element) {

    }

    @Override
    public RGB24Color getSelectedColor() {
        return null;
    }

    @Override
    public void setSelectedColor(RGB24Color rgb24Color) {

    }
}
