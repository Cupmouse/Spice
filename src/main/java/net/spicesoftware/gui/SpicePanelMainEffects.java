package net.spicesoftware.gui;

/**
 * @author Cupmouse
 * @since 2015/06/09
 */
public class SpicePanelMainEffects extends javax.swing.JPanel {

    public SpicePanelMainEffects() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        effectTree = new javax.swing.JTree();
        searchingTextField = new net.spicesoftware.gui.common.SpiceTextField();

        setLayout(new java.awt.BorderLayout());

        scrollPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scrollPane.setName(""); // NOI18N
        scrollPane.setRequestFocusEnabled(false);
        scrollPane.setViewportView(effectTree);

        add(scrollPane, java.awt.BorderLayout.CENTER);

        searchingTextField.setToolTipText("");
        searchingTextField.setPlaceHolder("検索する条件を入力...");
        add(searchingTextField, java.awt.BorderLayout.PAGE_START);
        searchingTextField.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree effectTree;
    private javax.swing.JScrollPane scrollPane;
    private net.spicesoftware.gui.common.SpiceTextField searchingTextField;
    // End of variables declaration//GEN-END:variables
}
