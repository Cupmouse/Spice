package net.spicesoftware.gui.preview;

import javax.swing.*;

/**
 * @author Cupmouse
 * @since 2015/06/09
 */
public class SpicePanelPreviewInterface extends JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBackFrame;
    private javax.swing.JButton buttonNextFrame;
    private javax.swing.JButton buttonPause;
    private javax.swing.JButton buttonPlay;
    private javax.swing.JButton buttonPlayBackward;
    private javax.swing.JButton buttonStop;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    // End of variables declaration//GEN-END:variables

    public SpicePanelPreviewInterface() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPlayBackward = new javax.swing.JButton();
        buttonPlay = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        buttonPause = new javax.swing.JButton();
        buttonStop = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        buttonBackFrame = new javax.swing.JButton();
        buttonNextFrame = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        buttonPlayBackward.setText("<");
        add(buttonPlayBackward, new java.awt.GridBagConstraints());

        buttonPlay.setText(">");
        add(buttonPlay, new java.awt.GridBagConstraints());
        add(filler1, new java.awt.GridBagConstraints());

        buttonPause.setText("||");
        add(buttonPause, new java.awt.GridBagConstraints());

        buttonStop.setText("[]");
        buttonStop.setToolTipText("");
        add(buttonStop, new java.awt.GridBagConstraints());
        add(filler2, new java.awt.GridBagConstraints());

        buttonBackFrame.setText("<1F");
        add(buttonBackFrame, new java.awt.GridBagConstraints());

        buttonNextFrame.setText("1F>");
        buttonNextFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextFrameActionPerformed(evt);
            }
        });
        add(buttonNextFrame, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNextFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonNextFrameActionPerformed
}
