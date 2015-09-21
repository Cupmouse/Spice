package net.spicesoftware.gui.timeline;

import net.spicesoftware.api.Box;
import net.spicesoftware.api.layer.Layer;
import net.spicesoftware.api.util.Validate;
import net.spicesoftware.item.SpiceItemShape;
import net.spicesoftware.project.SpiceTimelineRoot;

import java.awt.*;

import static net.spicesoftware.api.util.Validate.nullNot;

/**
 * @author Cupmouse
 * @since 2015/06/09
 */
public class SpicePanelTimelineWrapper extends javax.swing.JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollBar xScroll;
    private javax.swing.JScrollBar yScroll;
    // End of variables declaration//GEN-END:variables

    private final Box box;
    private final SpicePanelTimeline spicePanelTimeline;


    public SpicePanelTimelineWrapper() {
        this.box = new SpiceTimelineRoot(500, 500);
        Layer layer = box.addLastNewLayer();
        layer.addItemDuration(new SpiceItemShape(), 0, 100);
        layer.addItemDuration(new SpiceItemShape(), 150, 170);
        nullNot(box);
        initComponents();
        spicePanelTimeline = new SpicePanelTimeline(box);
        add(spicePanelTimeline, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        xScroll = new javax.swing.JScrollBar();
        yScroll = new javax.swing.JScrollBar();

        setLayout(new java.awt.BorderLayout());

        xScroll.setMaximum(1000);
        xScroll.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        xScroll.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                xScrollAdjustmentValueChanged(evt);
            }
        });
        add(xScroll, java.awt.BorderLayout.PAGE_END);

        yScroll.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                yScrollAdjustmentValueChanged(evt);
            }
        });
        add(yScroll, java.awt.BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void yScrollAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_yScrollAdjustmentValueChanged
        spicePanelTimeline.setScrollY(evt.getValue());
    }//GEN-LAST:event_yScrollAdjustmentValueChanged

    private void xScrollAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_xScrollAdjustmentValueChanged
        spicePanelTimeline.setScrollX(evt.getValue());
    }//GEN-LAST:event_xScrollAdjustmentValueChanged
}
