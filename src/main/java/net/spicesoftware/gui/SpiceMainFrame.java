package net.spicesoftware.gui;

import javax.swing.*;

/**
 * @author Cupmouse
 * @since 2015/06/09
 */
public class SpiceMainFrame extends JFrame {

    public SpiceMainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelPreview = new net.spicesoftware.gui.SpicePanelMainPreview();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        panelResource = new net.spicesoftware.gui.SpicePanelMainResource();
        panelEffects = new net.spicesoftware.gui.SpicePanelMainEffects();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        panelTimeline = new net.spicesoftware.gui.timeline.SpicePanelTimeline();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setResizeWeight(1.0);

        jSplitPane2.setDividerLocation(150);

        jTabbedPane1.addTab("---のプレビュー", panelPreview);

        jSplitPane2.setRightComponent(jTabbedPane1);

        jTabbedPane3.addTab("リソース", panelResource);
        jTabbedPane3.addTab("エフェクト", panelEffects);

        jSplitPane2.setLeftComponent(jTabbedPane3);

        jSplitPane1.setTopComponent(jSplitPane2);

        jTabbedPane2.addTab("---のタイムライン", panelTimeline);

        jSplitPane1.setRightComponent(jTabbedPane2);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SpiceMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpiceMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpiceMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpiceMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SpiceMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private net.spicesoftware.gui.SpicePanelMainEffects panelEffects;
    private net.spicesoftware.gui.SpicePanelMainPreview panelPreview;
    private net.spicesoftware.gui.SpicePanelMainResource panelResource;
    private net.spicesoftware.gui.timeline.SpicePanelTimeline panelTimeline;
    // End of variables declaration//GEN-END:variables
}
