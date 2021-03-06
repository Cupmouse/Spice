package net.spicesoftware.gui.timeline;

import net.spicesoftware.api.Box;
import net.spicesoftware.api.item.Item;
import net.spicesoftware.api.layer.Layer;
import net.spicesoftware.api.util.time.FrameRanged;

import java.awt.*;
import java.util.List;

import static net.spicesoftware.api.util.Validate.nullNot;

/**
 * @author Cupmouse
 * @since 2015/09/18
 */
public class SpicePanelTimeline extends javax.swing.JPanel {
    public static final int layerHeight = 40;
    public static final int verticalLayerLine = 150;
    public static final int newLayerButtonMargin = 5;
    public static final int newLayerButtonHeight = layerHeight - 20;
    public static final int layerUpperYMargin = 20;
    private final Box box;
    private int scrollX;
    private int scrollY;
    private int timeCursorFrame;
    private int showingNewLayerButtonNo = -1;
    private boolean pressed;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public SpicePanelTimeline(Box box) {
        nullNot(box);
        this.box = box;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                formMouseWheelMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth();
        FontMetrics fontMetrics = g2.getFontMetrics();

        // ??????
        g2.setColor(Color.white);
        int height = getHeight();
        g2.fillRect(0, 0, width, height);

        int timeCursorPos = verticalLayerLine - scrollX + timeCursorFrame;
        // ????????????????????????
        g2.setColor(Color.red);
        String cursorPosString = String.valueOf(timeCursorFrame);
        g2.drawString(cursorPosString, timeCursorPos - fontMetrics.stringWidth(cursorPosString) / 2, fontMetrics.getHeight());

        // ????????????
        int timePosOnMaxX = scrollX + width - verticalLayerLine + 60;
        for (int timePos = Math.max(scrollX - 60, 0); timePos < timePosOnMaxX && timePos <= box.getDuration().getFrames(); timePos++) {
            if (timePos % 60 == 0) {
                int timeLineX = timePos - scrollX + verticalLayerLine;
                g2.setColor(Color.black);
                g2.drawLine(timeLineX, fontMetrics.getHeight(), timeLineX, layerUpperYMargin);
                String timePosString = String.valueOf(timePos);
                g2.drawString(timePosString, timeLineX - fontMetrics.stringWidth(timePosString) / 2, fontMetrics.getHeight());
                g2.setColor(Color.lightGray);
                g2.drawLine(timeLineX, layerUpperYMargin, timeLineX, height);
            }
        }

        g2.setColor(Color.white);
        // ??????????????????????????????????????????????????????
        g2.fillRect(0, 0, verticalLayerLine, height);

        // ??????????????????????????????
        g2.setColor(Color.black);
        g2.drawLine(verticalLayerLine, 0, verticalLayerLine, height);

        // ?????????????????????????????????
        g2.drawLine(0, layerUpperYMargin, width, layerUpperYMargin);


        // ?????????????????????
        List<Layer> layers = box.getLayers();
        for (int layerI = 0; layerI < layers.size(); layerI++) {
            // ?????????????????????
            g2.setColor(Color.black);
            int layerUpperLineY = layerUpperYMargin + layerI * layerHeight;
            int layerUnderLineY = layerUpperLineY + layerHeight;
            g2.drawLine(0, layerUnderLineY, width, layerUnderLineY);
            Layer layer = layers.get(layerI);

            // TODO ??????????????????????????????
            List<FrameRanged<Item>> allItems = layer.getItemInFrameRange(scrollX, scrollX + (width - verticalLayerLine));

            for (FrameRanged<Item> itemFrameRanged : allItems) {
                // TODO ??????????????????????????????
                g2.setColor(Color.red);
                // ???????????????????????????????????????????????????
                // ????????????????????????????????????????????????????????????????????? + ????????????
                int itemRectangleXPos = verticalLayerLine + (itemFrameRanged.start - scrollX) + 1;

                int itemRectangleWidth;

                if (itemRectangleXPos <= verticalLayerLine) {
                    itemRectangleXPos = verticalLayerLine + 1;
                    itemRectangleWidth = itemFrameRanged.end - scrollX + 1;
                } else {
                    itemRectangleWidth = (itemFrameRanged.end - itemFrameRanged.start) + 1;
                }


                g2.fillRect(itemRectangleXPos, layerUpperLineY + 1, itemRectangleWidth, layerHeight - 1);

                // ?????????????????????
                g2.setColor(Color.white);
                String itemName = " ItemName";
                fontMetrics.getStringBounds(itemName, g2).getWidth();
                int itemNameStringWidth = fontMetrics.stringWidth(itemName);
                g2.drawString(itemName, itemRectangleXPos, layerUpperLineY + 1 + fontMetrics.getHeight());
            }
        }

        // ?????????????????????
        if (verticalLayerLine <= timeCursorPos && timeCursorPos < width) {
            g2.setColor(Color.yellow);
            g2.drawLine(timeCursorPos, 0, timeCursorPos, height);
        }

        // ???????????????????????????
        if (showingNewLayerButtonNo != -1) {
            g2.setColor(Color.blue);
            int newLayerButtonY = layerUpperYMargin + layerHeight * showingNewLayerButtonNo - newLayerButtonHeight / 2;
            g2.fillRect(newLayerButtonMargin, newLayerButtonY, verticalLayerLine - newLayerButtonMargin * 2, newLayerButtonHeight);
            String s = " NewLayer";
            g2.setColor(Color.white);
            g2.drawString(s, (verticalLayerLine - fontMetrics.stringWidth(s)) / 2, newLayerButtonY + (newLayerButtonHeight + fontMetrics.getHeight()) / 2);
        }

        g2.dispose();
    }

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    }//GEN-LAST:event_formKeyReleased

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        showingNewLayerButtonNo = -1;
    }//GEN-LAST:event_formMouseExited

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        boolean needsRepaint = false;
        int x = evt.getX();
        int layerStartY = evt.getY() - layerUpperYMargin;
        int layerNO = (layerStartY + newLayerButtonHeight / 2) / layerHeight;
        int ya = layerStartY % layerHeight;

        // ?????????????????????????????????????????????
        if (layerNO <= box.getNumberOfLayers()
                && evt.getY() > layerUpperYMargin - newLayerButtonHeight / 2
                && newLayerButtonMargin <= x && x <= verticalLayerLine - newLayerButtonMargin
                && (ya <= newLayerButtonHeight / 2 || ya >= layerHeight - newLayerButtonHeight / 2)) {
            showingNewLayerButtonNo = layerNO;
            needsRepaint = true;
        } else {

            if (showingNewLayerButtonNo != -1) {
                showingNewLayerButtonNo = -1;
                needsRepaint = true;
            }
        }
        if (needsRepaint) {
            repaint();
        }
    }//GEN-LAST:event_formMouseMoved

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        pressed = true;
        int x = evt.getX();
        int y = evt.getY();

    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        pressed = false;
        int x = evt.getX();
        int y = evt.getY();

    }//GEN-LAST:event_formMouseReleased

    private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseWheelMoved

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int newLimeCursorFrame = scrollX - verticalLayerLine + evt.getX();
        if (newLimeCursorFrame < 0) {
            newLimeCursorFrame = 0;
        } else if (newLimeCursorFrame > box.getDuration().getFrames()) {
            newLimeCursorFrame = box.getDuration().getFrames();
        }

        if (newLimeCursorFrame != timeCursorFrame) {
            timeCursorFrame = newLimeCursorFrame;
            repaint();
        }
    }//GEN-LAST:event_formMouseDragged

    public int getScrollX() {
        return scrollX;
    }

    public void setScrollX(int scrollX) {
        this.scrollX = scrollX;
        repaint();
    }

    public int getScrollY() {
        return scrollY;
    }

    public void setScrollY(int scrollY) {
        this.scrollY = scrollY;
        repaint();
    }

    public int getTimeCursorFrame() {
        return timeCursorFrame;
    }

    public void setTimeCursorFrame(int timeCursorFrame) {
        this.timeCursorFrame = timeCursorFrame;
    }
}
