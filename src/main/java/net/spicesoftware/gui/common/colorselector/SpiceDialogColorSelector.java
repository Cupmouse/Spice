package net.spicesoftware.gui.common.colorselector;

import net.spicesoftware.api.gui.common.colorpicker.DialogColorSelector;
import net.spicesoftware.api.gui.common.colorpicker.RGB24ColorSelector;

import javax.swing.*;
import java.awt.event.ItemEvent;

/**
 * @since 2015/07/04
 */
public class SpiceDialogColorSelector extends javax.swing.JDialog implements DialogColorSelector {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonOK;
    private javax.swing.JPanel colorPreview;
    private net.spicesoftware.gui.common.SpiceCopyableLabel copyableLabelColorHex;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelButtons;
    private javax.swing.JPanel panelColorHistroy;
    private javax.swing.JPanel panelColorInfo;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelGroupColorHistory;
    private javax.swing.JPanel panelSide;
    private javax.swing.JScrollPane scrollPaneColorHistory;
    private net.spicesoftware.gui.common.colorselector.SpiceRGB24ColorSelectorSquare spiceColorSelectorSquare;
    private net.spicesoftware.gui.common.spinner.SpiceIntSpinner spinnerB;
    private net.spicesoftware.gui.common.spinner.SpiceIntSpinner spinnerB1;
    private net.spicesoftware.gui.common.spinner.SpiceIntSpinner spinnerB2;
    private net.spicesoftware.gui.common.spinner.SpiceIntSpinner spinnerG;
    private net.spicesoftware.gui.common.spinner.SpiceIntSpinner spinnerG1;
    private net.spicesoftware.gui.common.spinner.SpiceIntSpinner spinnerG2;
    private net.spicesoftware.gui.common.spinner.SpiceIntSpinner spinnerR;
    private net.spicesoftware.gui.common.spinner.SpiceIntSpinner spinnerR1;
    private net.spicesoftware.gui.common.spinner.SpiceIntSpinner spinnerR2;
    private javax.swing.JToggleButton toggleButtonColorInfo;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form SpiceColorSelector
     */
    public SpiceDialogColorSelector(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
//        setMinimumSize(getSize());
    }

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SpiceDialogColorSelector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpiceDialogColorSelector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpiceDialogColorSelector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpiceDialogColorSelector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SpiceDialogColorSelector dialog = new SpiceDialogColorSelector(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelButtons = new javax.swing.JPanel();
        buttonOK = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        toggleButtonColorInfo = new javax.swing.JToggleButton();
        panelContent = new javax.swing.JPanel();
        spiceColorSelectorSquare = new net.spicesoftware.gui.common.colorselector.SpiceRGB24ColorSelectorSquare();
        panelSide = new javax.swing.JPanel();
        panelColorInfo = new javax.swing.JPanel();
        colorPreview = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        spinnerR = new net.spicesoftware.gui.common.spinner.SpiceIntSpinner();
        jRadioButton2 = new javax.swing.JRadioButton();
        spinnerG = new net.spicesoftware.gui.common.spinner.SpiceIntSpinner();
        jRadioButton3 = new javax.swing.JRadioButton();
        spinnerB = new net.spicesoftware.gui.common.spinner.SpiceIntSpinner();
        jRadioButton4 = new javax.swing.JRadioButton();
        spinnerR1 = new net.spicesoftware.gui.common.spinner.SpiceIntSpinner();
        jRadioButton5 = new javax.swing.JRadioButton();
        spinnerG1 = new net.spicesoftware.gui.common.spinner.SpiceIntSpinner();
        jRadioButton6 = new javax.swing.JRadioButton();
        spinnerB1 = new net.spicesoftware.gui.common.spinner.SpiceIntSpinner();
        jRadioButton7 = new javax.swing.JRadioButton();
        spinnerR2 = new net.spicesoftware.gui.common.spinner.SpiceIntSpinner();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        spinnerG2 = new net.spicesoftware.gui.common.spinner.SpiceIntSpinner();
        spinnerB2 = new net.spicesoftware.gui.common.spinner.SpiceIntSpinner();
        copyableLabelColorHex = new net.spicesoftware.gui.common.SpiceCopyableLabel();
        panelGroupColorHistory = new javax.swing.JPanel();
        scrollPaneColorHistory = new javax.swing.JScrollPane();
        panelColorHistroy = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("色の選択");
        setAlwaysOnTop(true);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        panelButtons.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        buttonOK.setMnemonic('A');
        buttonOK.setText("決定(A)");
        panelButtons.add(buttonOK);

        buttonCancel.setMnemonic('C');
        buttonCancel.setText("キャンセル(C)");
        panelButtons.add(buttonCancel);

        toggleButtonColorInfo.setMnemonic('D');
        toggleButtonColorInfo.setText("詳細(D)");
        toggleButtonColorInfo.setToolTipText("");
        toggleButtonColorInfo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                toggleButtonColorInfoItemStateChanged(evt);
            }
        });
        panelButtons.add(toggleButtonColorInfo);

        getContentPane().add(panelButtons, java.awt.BorderLayout.PAGE_END);

        panelContent.setLayout(new java.awt.GridBagLayout());

        spiceColorSelectorSquare.setMinimumSize(getPreferredSize());
        panelContent.add(spiceColorSelectorSquare, new java.awt.GridBagConstraints());

        panelSide.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelSide.setMinimumSize(getPreferredSize());
        panelSide.setPreferredSize(new java.awt.Dimension(150, 256));
        panelSide.setLayout(new java.awt.BorderLayout());

        panelColorInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("色"));
        panelColorInfo.setLayout(new java.awt.GridBagLayout());

        colorPreview.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        colorPreview.setMinimumSize(getPreferredSize());
        colorPreview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                colorPreviewMouseClicked(evt);
            }
        });
        colorPreview.setLayout(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panelColorInfo.add(colorPreview, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("H");
        jRadioButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1, new java.awt.GridBagConstraints());

        spinnerR.setBigModifier(2.0F);
        spinnerR.setDefaultModifier(0.2F);
        spinnerR.setMaxValue(100);
        spinnerR.setMinValue(0);
        spinnerR.setSmallModifier(0.05F);
        spinnerR.setUnit("D");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel1.add(spinnerR, gridBagConstraints);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("S");
        jRadioButton2.setToolTipText("");
        jRadioButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel1.add(jRadioButton2, gridBagConstraints);

        spinnerG.setBigModifier(2.0F);
        spinnerG.setDefaultModifier(0.2F);
        spinnerG.setMaxValue(255);
        spinnerG.setMinValue(0);
        spinnerG.setSmallModifier(0.05F);
        spinnerG.setUnit("%");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel1.add(spinnerG, gridBagConstraints);

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("V");
        jRadioButton3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        jPanel1.add(jRadioButton3, gridBagConstraints);

        spinnerB.setBigModifier(2.0F);
        spinnerB.setDefaultModifier(0.2F);
        spinnerB.setMaxValue(255);
        spinnerB.setMinValue(0);
        spinnerB.setSmallModifier(0.05F);
        spinnerB.setUnit("%");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel1.add(spinnerB, gridBagConstraints);

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("R");
        jRadioButton4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        jPanel1.add(jRadioButton4, gridBagConstraints);

        spinnerR1.setBigModifier(2.0F);
        spinnerR1.setDefaultModifier(0.2F);
        spinnerR1.setMaxValue(255);
        spinnerR1.setMinValue(0);
        spinnerR1.setSmallModifier(0.05F);
        spinnerR1.setUnit("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel1.add(spinnerR1, gridBagConstraints);

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setText("G");
        jRadioButton5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        jPanel1.add(jRadioButton5, gridBagConstraints);

        spinnerG1.setBigModifier(2.0F);
        spinnerG1.setDefaultModifier(0.2F);
        spinnerG1.setMaxValue(255);
        spinnerG1.setMinValue(0);
        spinnerG1.setSmallModifier(0.05F);
        spinnerG1.setUnit("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel1.add(spinnerG1, gridBagConstraints);

        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setText("B");
        jRadioButton6.setToolTipText("");
        jRadioButton6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        jPanel1.add(jRadioButton6, gridBagConstraints);

        spinnerB1.setBigModifier(2.0F);
        spinnerB1.setDefaultModifier(0.2F);
        spinnerB1.setMaxValue(255);
        spinnerB1.setMinValue(0);
        spinnerB1.setSmallModifier(0.05F);
        spinnerB1.setUnit("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel1.add(spinnerB1, gridBagConstraints);

        buttonGroup1.add(jRadioButton7);
        jRadioButton7.setText("L");
        jRadioButton7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        jPanel1.add(jRadioButton7, gridBagConstraints);

        spinnerR2.setBigModifier(2.0F);
        spinnerR2.setDefaultModifier(0.2F);
        spinnerR2.setEnabled(false);
        spinnerR2.setMaxValue(255);
        spinnerR2.setMinValue(0);
        spinnerR2.setSmallModifier(0.05F);
        spinnerR2.setUnit("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel1.add(spinnerR2, gridBagConstraints);

        buttonGroup1.add(jRadioButton8);
        jRadioButton8.setText("b");
        jRadioButton8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        jPanel1.add(jRadioButton8, gridBagConstraints);

        buttonGroup1.add(jRadioButton9);
        jRadioButton9.setText("a");
        jRadioButton9.setToolTipText("");
        jRadioButton9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton9ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        jPanel1.add(jRadioButton9, gridBagConstraints);

        spinnerG2.setBigModifier(2.0F);
        spinnerG2.setDefaultModifier(0.2F);
        spinnerG2.setEnabled(false);
        spinnerG2.setMaxValue(255);
        spinnerG2.setMinValue(0);
        spinnerG2.setSmallModifier(0.05F);
        spinnerG2.setUnit("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel1.add(spinnerG2, gridBagConstraints);

        spinnerB2.setBigModifier(2.0F);
        spinnerB2.setDefaultModifier(0.2F);
        spinnerB2.setEnabled(false);
        spinnerB2.setMaxValue(255);
        spinnerB2.setMinValue(0);
        spinnerB2.setSmallModifier(0.05F);
        spinnerB2.setUnit("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel1.add(spinnerB2, gridBagConstraints);

        jTabbedPane1.addTab("tab1", jPanel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panelColorInfo.add(jTabbedPane1, gridBagConstraints);

        copyableLabelColorHex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyableLabelColorHex.setText("#XXXXXX");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        panelColorInfo.add(copyableLabelColorHex, gridBagConstraints);

        panelSide.add(panelColorInfo, java.awt.BorderLayout.CENTER);

        panelGroupColorHistory.setBorder(javax.swing.BorderFactory.createTitledBorder("履歴"));
        panelGroupColorHistory.setMinimumSize(getPreferredSize());
        panelGroupColorHistory.setPreferredSize(new java.awt.Dimension(12, 50));
        panelGroupColorHistory.setLayout(new java.awt.BorderLayout());

        scrollPaneColorHistory.setBorder(null);
        scrollPaneColorHistory.setViewportView(panelColorHistroy);

        panelGroupColorHistory.add(scrollPaneColorHistory, java.awt.BorderLayout.CENTER);

        panelSide.add(panelGroupColorHistory, java.awt.BorderLayout.SOUTH);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panelContent.add(panelSide, gridBagConstraints);

        getContentPane().add(panelContent, java.awt.BorderLayout.CENTER);

        jMenu1.setText("選択方法");
        jMenu1.setToolTipText("");

        jRadioButtonMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, 0));
        jRadioButtonMenuItem1.setMnemonic('S');
        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("スクエアピッカー");
        jMenu1.add(jRadioButtonMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void toggleButtonColorInfoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_toggleButtonColorInfoItemStateChanged
        panelSide.setVisible(evt.getStateChange() == ItemEvent.SELECTED);

        pack();
//        Insets insets = getInsets();
//
//        int minimWidth = panelContent.getPreferredSize().width + insets.left + insets.right;
//
//        Dimension frameSize = getSize();
//        if (frameSize.width < minimWidth) {
//            frameSize.width = minimWidth;
//            setSize(frameSize);
//        }
//
//        Dimension newMinimumSize = getMinimumSize();
//        newMinimumSize.width = minimWidth;
//        setMinimumSize(newMinimumSize);
    }//GEN-LAST:event_toggleButtonColorInfoItemStateChanged

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    }//GEN-LAST:event_formMouseClicked

    private void colorPreviewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorPreviewMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_colorPreviewMouseClicked

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void jRadioButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton9ActionPerformed

    @Override
    public RGB24ColorSelector getSelector() {
        return spiceColorSelectorSquare;
    }
}
