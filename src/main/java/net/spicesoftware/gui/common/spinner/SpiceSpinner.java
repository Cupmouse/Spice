package net.spicesoftware.gui.common.spinner;

import net.spicesoftware.api.gui.common.spinner.Spinner;
import net.spicesoftware.api.gui.common.spinner.SpinnerListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * @since 2015/07/04
 */
public abstract class SpiceSpinner extends javax.swing.JPanel implements Spinner {

    private static final Border DEFAULT_BORDER = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY);
    //    private static final Border FOCUS_BORDER = BorderFactory.createDashedBorder(Color.GRAY, 2, 2);
    //    private static final Border HORIZONTAL_BORDER = BorderFactory.createMatteBorder(0, 2, 0, 2, Color.RED);
//    private static final Border VERTICAL_BORDER = BorderFactory.createMatteBorder(2, 0, 2, 0, Color.RED);
    protected Point clickedLoc;
    protected boolean inTextMode;
    protected boolean dragging;
    protected boolean textModeFromClicking;
    protected boolean altPressed;
    protected java.util.List<SpinnerListener> spinnerListeners = new ArrayList<>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton label;
    protected javax.swing.JLabel labelUnit;
    protected javax.swing.JTextField textField;
    // End of variables declaration//GEN-END:variables

    public SpiceSpinner(String unit) {
        super();
        initComponents();
        labelUnit.setText(unit);
        Container topLevelAncestor = getTopLevelAncestor();
        if (topLevelAncestor != null) {
            topLevelAncestor.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (inTextMode) {
                        switchLabelMode();
                    }
                }
            });
        }
    }

    /**
     * Creates new form SpiceSuperSpinner
     */
    public SpiceSpinner() {
        this(null);
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        label = new javax.swing.JButton();
        textField = new javax.swing.JTextField();
        labelUnit = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        label.setText("jButton1");
        label.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        label.setContentAreaFilled(false);
        label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                if (!isEnabled()) {
                    return;
                }
                labelMouseDragged(evt);
            }
        });
        label.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (!isEnabled()) {
                    return;
                }
                labelFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (!isEnabled()) {
                    return;
                }
                labelFocusLost(evt);
            }
        });
        label.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                if (!isEnabled()) {
                    return;
                }
                labelMouseWheelMoved(evt);
            }
        });
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (!isEnabled()) {
                    return;
                }
                labelMouseEntered(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (!isEnabled()) {
                    return;
                }
                labelMousePressed(evt);
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (!isEnabled()) {
                    return;
                }
                labelMouseReleased(evt);
            }
        });
        label.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (!isEnabled()) {
                    return;
                }
                labelKeyPressed(evt);
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (!isEnabled()) {
                    return;
                }
                labelKeyReleased(evt);
            }

            public void keyTyped(java.awt.event.KeyEvent evt) {
                if (!isEnabled()) {
                    return;
                }
                labelKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        add(label, gridBagConstraints);

        textField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textField.setText("VALUE");
        textField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, java.awt.Color.lightGray));
        textField.setVisible(false);
        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (!isEnabled()) {
                    return;
                }
                textFieldFocusLost(evt);
            }
        });
        textField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!isEnabled()) {
                    return;
                }
                textFieldMouseExited(evt);
            }
        });
        textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (!isEnabled()) {
                    return;
                }
                textFieldActionPerformed(evt);
            }
        });
        textField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if (!isEnabled()) {
                    return;
                }
                textFieldKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        add(textField, gridBagConstraints);

        labelUnit.setText("unit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 0);
        add(labelUnit, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldFocusLost
        if (inTextMode) {
            switchLabelMode();
        }
    }//GEN-LAST:event_textFieldFocusLost

    private void textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldActionPerformed
        if (inTextMode) {
            switchLabelMode();
        }
    }//GEN-LAST:event_textFieldActionPerformed

    private void textFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ESCAPE) {
            switchLabelModeWithoutApplying();
        }
    }//GEN-LAST:event_textFieldKeyTyped

    private void textFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textFieldMouseExited
        if (inTextMode) {
            switchLabelMode();
        }
    }//GEN-LAST:event_textFieldMouseExited

    private void labelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_labelFocusGained
//        label.setBorder(FOCUS_BORDER);
    }//GEN-LAST:event_labelFocusGained

    protected int labelMouseDragged(MouseEvent evt) {//GEN-FIRST:event_labelMouseDragged
        this.dragging = true;
        int xMoved = evt.getX() - clickedLoc.x;
        int yMoved = evt.getY() - clickedLoc.y;
        if (Math.abs(xMoved) < Math.abs(yMoved)) {
//            jButton1.setBorder(VERTICAL_BORDER);
            return -yMoved;
        } else {
//            jButton1.setBorder(HORIZONTAL_BORDER);
            return xMoved;
        }
    }//GEN-LAST:event_labelMouseDragged

    protected void labelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMousePressed
        this.clickedLoc = evt.getPoint();
    }//GEN-LAST:event_labelMousePressed

    private void labelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMouseReleased
        if (!dragging) {
            textModeFromClicking = true;
            switchTextMode();
            dragging = false;
        } else {
            callOnValueConfirmed();
            dragging = false;
        }
    }//GEN-LAST:event_labelMouseReleased

    protected void labelMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_labelMouseWheelMoved

    }//GEN-LAST:event_labelMouseWheelMoved

    private void labelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_labelKeyTyped
        if (altPressed) {
            return;
        }

        if (evt.getKeyChar() == KeyEvent.VK_SPACE || evt.getKeyChar() == KeyEvent.VK_ENTER) {
            switchTextMode();
        } else {
            switchTextMode();
            textField.setText(String.valueOf(evt.getKeyChar()));
        }
    }//GEN-LAST:event_labelKeyTyped

    private void labelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_labelFocusLost
        label.setBorder(DEFAULT_BORDER);
    }//GEN-LAST:event_labelFocusLost

    private void labelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMouseEntered
        label.requestFocus();
    }//GEN-LAST:event_labelMouseEntered

    protected void labelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_labelKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            this.altPressed = true;
        }
    }//GEN-LAST:event_labelKeyPressed

    protected void labelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_labelKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            this.altPressed = false;
        }
    }//GEN-LAST:event_labelKeyReleased

    private void switchTextMode() {
        label.setVisible(false);
        putValueToTextField();
        textField.setVisible(true);
        inTextMode = true;
        textField.requestFocus();
        textField.selectAll();
    }

    protected abstract void putValueToTextField();

    private void switchLabelMode() {
        setValueFromTextField();
        label.setVisible(true);
        textField.setVisible(false);
        inTextMode = false;
        textModeFromClicking = false;
        callOnValueConfirmed();
    }

    private void switchLabelModeWithoutApplying() {
        label.setVisible(true);
        textField.setVisible(false);
        inTextMode = false;
        textModeFromClicking = false;
    }

    protected abstract void setValueFromTextField();

    protected abstract void putValueToLabelValue();

    public String getUnit() {
        return labelUnit.getText();
    }

    public void setUnit(String unit) {
        this.labelUnit.setText(unit);
    }

    public void setMnemonic(char mnemonic) {
        label.setMnemonic(mnemonic);
    }

    public int getMnemonic() {
        return label.getMnemonic();
    }

    public void setMnemonic(int mnemonic) {
        label.setMnemonic(mnemonic);
    }

    @Override
    public String getText() {
        return label.getText();
    }

    @Override
    public void setText(String text) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addSpinnerListener(SpinnerListener spinnerListener) {
        spinnerListeners.add(spinnerListener);
    }

    protected void callOnValueConfirmed() {
        for (SpinnerListener spinnerListener : spinnerListeners) {
            try {
                spinnerListener.onValueConfirmed(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void callOnValueChanged() {
        for (SpinnerListener spinnerListener : spinnerListeners) {
            try {
                spinnerListener.onValueChanged(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}