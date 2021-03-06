package net.spicesoftware.gui.common.colorselector;

import net.spicesoftware.api.gui.common.colorpicker.DialogRGB24ColorPicker;
import net.spicesoftware.api.gui.common.colorpicker.RGB24ColorSelector;
import net.spicesoftware.api.gui.common.spinner.IntSpinner;
import net.spicesoftware.swinggui.SwingDialogWindow;
import net.spicesoftware.swinggui.SwingWindowSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

/**
 * @since 2015/07/04
 */
public class SpiceDialogRGB24ColorPicker extends SwingDialogWindow implements DialogRGB24ColorPicker<SwingWindowSystem> {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonOK;
    private javax.swing.JPanel colorPreview;
    private net.spicesoftware.gui.common.SpiceCopyableLabel copyableLabelColorHex;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JPanel panelButtons;
    private javax.swing.JPanel panelColorHistroy;
    private javax.swing.JPanel panelColorInfo;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelGroupColorHistory;
    private javax.swing.JPanel panelHSVColorValue;
    private javax.swing.JPanel panelSide;
    private javax.swing.ButtonGroup radioButtonGroup;
    protected javax.swing.JRadioButton radioButtonH;
    protected javax.swing.JRadioButton radioButtonS;
    protected javax.swing.JRadioButton radioButtonV;
    private javax.swing.JScrollPane scrollPaneColorHistory;
    private net.spicesoftware.gui.common.spinner.SpiceIntSpinner spinnerH;
    private net.spicesoftware.gui.common.spinner.SpiceIntSpinner spinnerS;
    private net.spicesoftware.gui.common.spinner.SpiceIntSpinner spinnerV;
    private javax.swing.JTabbedPane tabbedPaneColorValues;
    private javax.swing.JToggleButton toggleButtonColorInfo;
    // End of variables declaration//GEN-END:variables

    private RGB24ColorSelector colorSelector;

    /**
     * Creates new form SpiceColorSelector
     */
    public SpiceDialogRGB24ColorPicker(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // TODO ????????????
        setColorSelector(new SpiceRGB24ColorSelectorSquare(this));
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
            java.util.logging.Logger.getLogger(SpiceDialogRGB24ColorPicker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpiceDialogRGB24ColorPicker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpiceDialogRGB24ColorPicker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpiceDialogRGB24ColorPicker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SpiceDialogRGB24ColorPicker dialog = new SpiceDialogRGB24ColorPicker(new javax.swing.JFrame(), true);
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

        radioButtonGroup = new javax.swing.ButtonGroup();
        panelButtons = new javax.swing.JPanel();
        buttonOK = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        toggleButtonColorInfo = new javax.swing.JToggleButton();
        panelContent = new javax.swing.JPanel();
        panelSide = new javax.swing.JPanel();
        panelColorInfo = new javax.swing.JPanel();
        colorPreview = new javax.swing.JPanel();
        copyableLabelColorHex = new net.spicesoftware.gui.common.SpiceCopyableLabel();
        tabbedPaneColorValues = new javax.swing.JTabbedPane();
        panelHSVColorValue = new javax.swing.JPanel();
        radioButtonH = new javax.swing.JRadioButton();
        spinnerH = new net.spicesoftware.gui.common.spinner.SpiceIntSpinner();
        radioButtonS = new javax.swing.JRadioButton();
        spinnerS = new net.spicesoftware.gui.common.spinner.SpiceIntSpinner();
        radioButtonV = new javax.swing.JRadioButton();
        spinnerV = new net.spicesoftware.gui.common.spinner.SpiceIntSpinner();
        panelGroupColorHistory = new javax.swing.JPanel();
        scrollPaneColorHistory = new javax.swing.JScrollPane();
        panelColorHistroy = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("????????????");
        setAlwaysOnTop(true);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        panelButtons.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        buttonOK.setMnemonic('A');
        buttonOK.setText("??????(A)");
        panelButtons.add(buttonOK);

        buttonCancel.setMnemonic('C');
        buttonCancel.setText("???????????????(C)");
        panelButtons.add(buttonCancel);

        toggleButtonColorInfo.setMnemonic('D');
        toggleButtonColorInfo.setText("??????(D)");
        toggleButtonColorInfo.setToolTipText("");
        toggleButtonColorInfo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                toggleButtonColorInfoItemStateChanged(evt);
            }
        });
        panelButtons.add(toggleButtonColorInfo);

        getContentPane().add(panelButtons, java.awt.BorderLayout.PAGE_END);

        panelContent.setLayout(new java.awt.GridBagLayout());

        panelSide.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelSide.setMinimumSize(getPreferredSize());
        panelSide.setPreferredSize(new java.awt.Dimension(150, 256));
        panelSide.setLayout(new java.awt.BorderLayout());

        panelColorInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("???"));
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

        copyableLabelColorHex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyableLabelColorHex.setText("#XXXXXX");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        panelColorInfo.add(copyableLabelColorHex, gridBagConstraints);

        java.awt.GridBagLayout panelHSVColorValueLayout = new java.awt.GridBagLayout();
        panelHSVColorValueLayout.columnWidths = new int[] {0};
        panelHSVColorValue.setLayout(panelHSVColorValueLayout);

        radioButtonGroup.add(radioButtonH);
        radioButtonH.setText("H");
        radioButtonH.setMargin(new java.awt.Insets(0, 0, 0, 0));
        radioButtonH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonHActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(1, 2, 1, 2);
        panelHSVColorValue.add(radioButtonH, gridBagConstraints);

        spinnerH.setBigModifier(2.0F);
        spinnerH.setDefaultModifier(0.2F);
        spinnerH.setDoubleBuffered(false);
        spinnerH.setSmallModifier(0.05F);
        spinnerH.setUnit("D");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 2, 1, 2);
        panelHSVColorValue.add(spinnerH, gridBagConstraints);

        radioButtonGroup.add(radioButtonS);
        radioButtonS.setText("S");
        radioButtonS.setMargin(new java.awt.Insets(0, 0, 0, 0));
        radioButtonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonSActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(1, 2, 1, 2);
        panelHSVColorValue.add(radioButtonS, gridBagConstraints);

        spinnerS.setBigModifier(2.0F);
        spinnerS.setDefaultModifier(0.2F);
        spinnerS.setDoubleBuffered(false);
        spinnerS.setSmallModifier(0.05F);
        spinnerS.setUnit("%");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 2, 1, 2);
        panelHSVColorValue.add(spinnerS, gridBagConstraints);

        radioButtonGroup.add(radioButtonV);
        radioButtonV.setText("V");
        radioButtonV.setMargin(new java.awt.Insets(0, 0, 0, 0));
        radioButtonV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonVActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(1, 2, 1, 2);
        panelHSVColorValue.add(radioButtonV, gridBagConstraints);

        spinnerV.setBigModifier(2.0F);
        spinnerV.setDefaultModifier(0.2F);
        spinnerV.setDoubleBuffered(false);
        spinnerV.setSmallModifier(0.05F);
        spinnerV.setUnit("%");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 2, 1, 2);
        panelHSVColorValue.add(spinnerV, gridBagConstraints);

        tabbedPaneColorValues.addTab("HSV", panelHSVColorValue);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelColorInfo.add(tabbedPaneColorValues, gridBagConstraints);

        panelSide.add(panelColorInfo, java.awt.BorderLayout.CENTER);

        panelGroupColorHistory.setBorder(javax.swing.BorderFactory.createTitledBorder("??????"));
        panelGroupColorHistory.setMinimumSize(getPreferredSize());
        panelGroupColorHistory.setPreferredSize(new java.awt.Dimension(12, 50));
        panelGroupColorHistory.setLayout(new java.awt.BorderLayout());

        scrollPaneColorHistory.setBorder(null);
        scrollPaneColorHistory.setViewportView(panelColorHistroy);

        panelGroupColorHistory.add(scrollPaneColorHistory, java.awt.BorderLayout.CENTER);

        panelSide.add(panelGroupColorHistory, java.awt.BorderLayout.SOUTH);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panelContent.add(panelSide, gridBagConstraints);

        getContentPane().add(panelContent, java.awt.BorderLayout.CENTER);

        jMenu1.setText("????????????");
        jMenu1.setToolTipText("");

        jRadioButtonMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, 0));
        jRadioButtonMenuItem1.setMnemonic('S');
        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("????????????????????????");
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

    }//GEN-LAST:event_colorPreviewMouseClicked

    private void radioButtonHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonHActionPerformed
//        colorSelector.setLockedElement(RGB24ColorSelector.LockedElement.H);
    }//GEN-LAST:event_radioButtonHActionPerformed

    private void radioButtonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonSActionPerformed
//        colorSelector.setLockedElement(RGB24ColorSelector.LockedElement.S);
    }//GEN-LAST:event_radioButtonSActionPerformed

    private void radioButtonVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonVActionPerformed
//        colorSelector.setLockedElement(RGB24ColorSelector.LockedElement.V);
    }//GEN-LAST:event_radioButtonVActionPerformed

    @Override
    public IntSpinner getIntSpinnerH() {
        return spinnerH;
    }

    @Override
    public IntSpinner getIntSpinnerS() {
        return spinnerS;
    }

    @Override
    public IntSpinner getIntSpinnerV() {
        return spinnerV;
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
    public RGB24ColorSelector getSelector() {
        return colorSelector;
    }

    @Override
    public void setColorSelector(RGB24ColorSelector colorSelector) {
        if (colorSelector == null) {
            throw new NullPointerException();
        }
        this.colorSelector = colorSelector;
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        this.panelContent.add((Component) colorSelector, gridBagConstraints);
    }
}
