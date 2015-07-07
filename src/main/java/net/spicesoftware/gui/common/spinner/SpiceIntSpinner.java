package net.spicesoftware.gui.common.spinner;

import net.spicesoftware.api.gui.common.spinner.IntSpinner;
import net.spicesoftware.api.util.gui.GUIUtil;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

/**
 * @since 2015/07/04
 */
public class SpiceIntSpinner extends SpiceSpinner implements IntSpinner {

    private int draggingStartValue;
    private int maxValue = Integer.MAX_VALUE;
    private int minValue = Integer.MIN_VALUE;
    private int value;
    private float modifier;
    private float defaultModifier = 1;
    private float bigModifier = 10;
    private float smallModifier = 0.1F;

    public SpiceIntSpinner(String unit, int value) {
        super(unit);
        setValue(value);
    }

    public SpiceIntSpinner(int value) {
        this(null, value);
    }

    public SpiceIntSpinner() {
        this(null, 0);
    }

    @Override
    protected void putValueToTextField() {
        textField.setText(Integer.toString(value));
    }

    @Override
    protected void setValueFromTextField() {
        try {
            setValue(Integer.valueOf(textField.getText()));
        } catch (NumberFormatException e) {
            GUIUtil.playSystemWarningSound();
        }
    }

    @Override
    protected void putValueToLabelValue() {
        label.setText(Integer.toString(value));
    }

    @Override
    protected int labelMouseDragged(MouseEvent evt) {
        int deltaPos = super.labelMouseDragged(evt);
        setValue(draggingStartValue + ((int) (deltaPos * modifier)));
        return deltaPos;
    }

    @Override
    protected void labelMousePressed(MouseEvent evt) {
        super.labelMousePressed(evt);
        draggingStartValue = value;
        if (evt.getButton() == MouseEvent.BUTTON1) {
            modifier = defaultModifier;
        } else if (evt.getButton() == MouseEvent.BUTTON2) {
            modifier = bigModifier;
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            modifier = smallModifier;
        }
    }

    @Override
    protected void labelMouseWheelMoved(MouseWheelEvent e) {
        super.labelMouseWheelMoved(e);
        if (!dragging) {
            setValue(getValue() + e.getWheelRotation());
        }
    }

    @Override
    protected void labelKeyPressed(KeyEvent evt) {
        super.labelKeyPressed(evt);
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_LEFT) {
            setValue(value - 1);
        } else if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            setValue(value + 1);
        }
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        if (value > maxValue) {
            this.value = maxValue;
        } else if (value < minValue) {
            this.value = minValue;
        } else {
            this.value = value;
        }
        putValueToLabelValue();
        callOnValueChanged();
    }

    @Override
    public int getMaxValue() {
        return maxValue;
    }

    @Override
    public void setMaxValue(int maxValue) {
        if (maxValue < minValue) {
            throw new IllegalArgumentException();
        }
        this.maxValue = maxValue;
        if (value > maxValue) {
            setValue(maxValue);
        }
    }

    @Override
    public void disableMaxValue() {
        this.maxValue = Integer.MAX_VALUE;
    }

    @Override
    public int getMinValue() {
        return minValue;
    }

    @Override
    public void setMinValue(int minValue) {
        if (minValue > maxValue) {
            throw new IllegalArgumentException();
        }
        this.minValue = minValue;
        if (value < minValue) {
            setValue(minValue);
        }
    }

    @Override
    public void disableMinValue() {
        this.minValue = Integer.MIN_VALUE;
    }

    @Override
    public float getSmallModifier() {
        return smallModifier;
    }

    @Override
    public void setSmallModifier(float smallModifier) {
        this.smallModifier = smallModifier;
    }

    @Override
    public float getBigModifier() {
        return bigModifier;
    }

    @Override
    public void setBigModifier(float bigModifier) {
        this.bigModifier = bigModifier;
    }

    @Override
    public float getDefaultModifier() {
        return defaultModifier;
    }

    @Override
    public void setDefaultModifier(float defaultModifier) {
        this.defaultModifier = defaultModifier;
    }
}
