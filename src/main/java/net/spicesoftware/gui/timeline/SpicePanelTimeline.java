package net.spicesoftware.gui.timeline;

/**
 * @author Cupmouse
 * @since 2015/06/09
 */
public class SpicePanelTimeline extends javax.swing.JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollBar xScroll;
    private javax.swing.JScrollBar yScroll;
    // End of variables declaration//GEN-END:variables


    public SpicePanelTimeline() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        xScroll = new javax.swing.JScrollBar();
        yScroll = new javax.swing.JScrollBar();

        setLayout(new java.awt.BorderLayout());

        xScroll.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        add(xScroll, java.awt.BorderLayout.PAGE_END);
        add(yScroll, java.awt.BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents
}
