package net.spicesoftware.gui.common;


import net.spicesoftware.api.gui.common.CircularPopupMenu;
import net.spicesoftware.api.gui.common.CircularPopupMenuChoice;
import net.spicesoftware.api.util.decoration.fill.color.RGB24Color;
import net.spicesoftware.api.util.gui.GUIUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.util.*;

import static net.spicesoftware.api.gui.common.CircularPopupMenuChoice.choice;

/**
 * @since 2015/10/02
 */
public class SpiceCircularPopupMenu extends SpiceMovableUndecoratedDialog implements CircularPopupMenu {

    public static final float centerRectDiameter = 16;
    public static final float DIAMETER = 128;
    private static final float WINDOW_OPACITY = .8F;
    public static final int OVAL_STROKE_WIDTH = 2;
    private final LinkedHashMap<CircularPopupMenuChoice, Arc2D.Double> choices = new LinkedHashMap<>();
    private final Ellipse2D.Double noSelectionPoint;
    private final Ellipse2D.Double windowShape;
    private final float cancelAngle;
    private final float angle;
    private final float offset;
    private final float transformAngle = 30;
    private boolean closingRequested;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public SpiceCircularPopupMenu(java.awt.Frame parent, boolean modal, CircularPopupMenuChoice... choices) {
        super(parent, modal);

        windowShape = new Ellipse2D.Double(0, 0, DIAMETER, DIAMETER);

        cancelAngle = 360 / (choices.length + 2f);
        angle = (360 - cancelAngle) / choices.length;
        offset = 90 - cancelAngle / 2;

        for (int i = 0; i < choices.length; i++) {
            this.choices.put(choices[i], new Arc2D.Double(-1, -1, DIAMETER + 2, DIAMETER + 2, angle * i - offset, angle, Arc2D.PIE));
        }

        this.choices.put(choice("Cancel", new RGB24Color(0, 0, 255), () -> closeDialog()), new Arc2D.Double(-1, -1, DIAMETER + 2, DIAMETER + 2, 270 - cancelAngle / 2, cancelAngle, Arc2D.PIE));
        noSelectionPoint = new Ellipse2D.Double((DIAMETER - centerRectDiameter) / 2, (DIAMETER - centerRectDiameter) / 2, centerRectDiameter, centerRectDiameter);
        initComponents();

        Point location = MouseInfo.getPointerInfo().getLocation();
        setLocation((int) (location.x - DIAMETER / 2), (int) (location.y - DIAMETER / 2));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setOpacity(WINDOW_OPACITY);
        setPreferredSize(new Dimension((int) DIAMETER, (int) DIAMETER));
        setResizable(false);
        setShape(windowShape);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        closeDialog();
    }//GEN-LAST:event_formMouseExited

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        Point point = evt.getPoint();
        if (noSelectionPoint.contains(point)) {
        } else {
            choices.forEach((choice, aDouble) -> {
                if (aDouble.contains(point)) {
                    synchronized (this) {
                        if (!closingRequested) {
                            try {
                                choice.getRunnable().run();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            closeDialog();
                        }
                    }
                }
            });
        }
    }//GEN-LAST:event_formMouseMoved

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            closeDialog();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private synchronized void closeDialog() {
        if (!closingRequested) {
            EventQueue.invokeLater(() -> dispose());
            closingRequested = true;
        }
    }

    public static void main(String[] args) {
        SpiceCircularPopupMenu spiceCursorSelection =
                new SpiceCircularPopupMenu(null, false,
                        choice("1", new RGB24Color(255, 0, 0), () -> System.out.println("1")),
                        choice("2", new RGB24Color(0, 255, 0), () -> System.out.println("2")),
                        choice("3", new RGB24Color(128, 128, 0), () -> System.out.println("3")));
        EventQueue.invokeLater(() -> spiceCursorSelection.setVisible(true));
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        g2.setColor(Color.white);
        g2.fillOval(0, 0, width, height);

        g2.setStroke(new BasicStroke(OVAL_STROKE_WIDTH));

        choices.forEach((choice, shape) -> {
            g2.setColor(GUIUtil.toAWTColor(choice.getColor()));
            g2.fill(shape);
            g2.setColor(Color.white);
            g2.draw(shape);
        });

        FontMetrics fontMetrics = g2.getFontMetrics();

        int fontAscent = fontMetrics.getAscent();

        g2.setColor(Color.white);

        // 変形前のオリジナルを保持
        AffineTransform affineTransform = g2.getTransform();
        choices.forEach((choice, shape) -> {
            double stringPosAngle = shape.start + shape.extent / 2;
            int strWidth = fontMetrics.stringWidth(choice.getLabel());

            if ((90 - transformAngle / 2 < stringPosAngle && stringPosAngle < 90 + transformAngle / 2)
                    || (270 - transformAngle / 2 < stringPosAngle && stringPosAngle < 270 + transformAngle / 2)) {
                // 上下は文字の向きを変えない
                g2.setTransform(affineTransform);
                // タンジェントから文字が収まるyオフセットを求める、直径の4分1（半径の半分）以下なら、半径の半分をyオフセットとする
                double stringYOffset = Math.max((strWidth / 2) / Math.tan(Math.toRadians(shape.extent / 2)), DIAMETER / 4 - centerRectDiameter / 2);

                float strYPos;
                if (stringPosAngle < 180) {
                    // 上なら文字のDescent分空きを取る
                    strYPos = (float) (DIAMETER / 2 - stringYOffset - fontMetrics.getDescent());
                } else {
                    // 下の場合、文字の高さを考えて足しておく
                    strYPos = (float) (DIAMETER / 2 + stringYOffset + fontAscent);
                }
                // 実際に文字を描画
                g2.drawString(choice.getLabel(), (width - strWidth) / 2, strYPos);
            } else if (stringPosAngle < 90) {
                AffineTransform rotateInstance = AffineTransform.getRotateInstance(Math.toRadians(360 - stringPosAngle), DIAMETER / 2, DIAMETER / 2);
                g2.setTransform(rotateInstance);
                g2.drawString(choice.getLabel(), (3 * DIAMETER + centerRectDiameter) / 4 - strWidth / 2, DIAMETER / 2 + fontAscent / 2);
            } else {
                // 90 + transformAngle / 2 < stringPosAngle < 270 - transformAngle / 2
                AffineTransform rotateInstance = AffineTransform.getRotateInstance(Math.toRadians(180 - stringPosAngle), DIAMETER / 2, DIAMETER / 2);
                g2.setTransform(rotateInstance);
                g2.drawString(choice.getLabel(), (DIAMETER - centerRectDiameter) / 4 - strWidth / 2, DIAMETER / 2 + fontAscent / 2);
            }
        });
        // 変形前のオリジナルをリストア
        g2.setTransform(affineTransform);

        g2.setColor(Color.white);
        g2.fill(noSelectionPoint);
        g2.dispose();
    }

    @Override
    public Set<CircularPopupMenuChoice> getChoicesList() {
        return Collections.unmodifiableSet(choices.keySet());
    }
}
