package net.spicesoftware.gui;

import javax.swing.*;

/**
 * @author Cupmouse
 * @since 2015/06/09
 */
public class SpicePanelMainPreview extends JPanel {

    public SpicePanelMainPreview() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        previewInterface = new net.spicesoftware.gui.preview.SpicePanelPreviewInterface();
        preview = new net.spicesoftware.gui.preview.SpicePanelPreview();

        setLayout(new java.awt.BorderLayout());
        add(previewInterface, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout previewLayout = new javax.swing.GroupLayout(preview);
        preview.setLayout(previewLayout);
        previewLayout.setHorizontalGroup(
                previewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        previewLayout.setVerticalGroup(
                previewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 279, Short.MAX_VALUE)
        );

        add(preview, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private net.spicesoftware.gui.preview.SpicePanelPreview preview;
    private net.spicesoftware.gui.preview.SpicePanelPreviewInterface previewInterface;
    // End of variables declaration//GEN-END:variables
}
