package net.spicesoftware.gui.common;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * @since 2015/06/06
 */
public class SpiceTextField extends JTextField implements FocusListener {

    private String placeHolder;

    public SpiceTextField() {
        this(null, null, 0, null);
    }

    public SpiceTextField(String placeHolder) {
        this(null, null, 0, placeHolder);
    }

    public SpiceTextField(int columns) {
        this(null, null, columns, null);
    }

    public SpiceTextField(String text, int columns) {
        this(null, text, columns, null);
    }

    public SpiceTextField(Document doc, String text, int columns) {
        this(doc, text, columns, null);
    }

    public SpiceTextField(String text, String placeHolder) {
        this(null, text, 0, null);
    }

    public SpiceTextField(int columns, String placeHolder) {
        this(null, null, columns, placeHolder);
    }

    public SpiceTextField(String text, int columns, String placeHolder) {
        this(null, text, columns, placeHolder);
    }

    public SpiceTextField(Document doc, String text, int columns, String placeHolder) {
        super(doc, text, columns);
        this.placeHolder = placeHolder == null ? "" : placeHolder;

        addFocusListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isFocusOwner() && getDocument().getLength() == 0) {
            g.setColor(getDisabledTextColor());
            g.setFont(new Font(g.getFont().getName(), Font.ITALIC, g.getFont().getSize()));
            g.drawString(placeHolder, getInsets().left, g.getFontMetrics().getHeight());
        }
    }

    /*
    プレースホルダ
     */

    public String getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }

    /*
    FocusListener
     */

    @Override
    public void focusGained(FocusEvent e) {
        repaint();
    }

    @Override
    public void focusLost(FocusEvent e) {
        repaint();
    }
}
