package net.spicesoftware.gui;

import net.spicesoftware.SpiceSession;
import net.spicesoftware.api.gui.MainWindow;
import net.spicesoftware.swinggui.SwingWindow;
import net.spicesoftware.swinggui.SwingWindowSystem;

import javax.swing.*;

/**
 * @author Cupmouse
 * @since 2015/06/09
 */
public class SpiceMainWindow extends SwingWindow implements MainWindow<SwingWindowSystem> {

    private final SpiceSession session;
    private ImageIcon windowIcon;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private net.spicesoftware.gui.SpicePanelMainEffects panelEffects;
    private net.spicesoftware.gui.SpicePanelMainPreview panelPreview;
    private net.spicesoftware.gui.SpicePanelMainResource panelResource;
    private net.spicesoftware.gui.timeline.SpicePanelTimelineWrapper panelTimeline;
    // End of variables declaration//GEN-END:variables

    public SpiceMainWindow(SpiceSession session) {
        this.session = session;
        windowIcon = new ImageIcon(ClassLoader.getSystemResource("windowIcons/spiceIcon16.png"));
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelPreview = new net.spicesoftware.gui.SpicePanelMainPreview();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        panelResource = new net.spicesoftware.gui.SpicePanelMainResource(session.getProject().get().getResourceManager());
        panelEffects = new net.spicesoftware.gui.SpicePanelMainEffects();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        panelTimeline = new net.spicesoftware.gui.timeline.SpicePanelTimelineWrapper(session.getProject().get().getTimeline());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(windowIcon.getImage());
        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setResizeWeight(1.0);

        jSplitPane2.setDividerLocation(150);

        jTabbedPane1.addTab("---のプレビュー", panelPreview);

        jSplitPane2.setRightComponent(jTabbedPane1);

        jTabbedPane3.addTab("リソース", panelResource);
        jTabbedPane3.addTab("エフェクト", panelEffects);

        jSplitPane2.setLeftComponent(jTabbedPane3);

        jSplitPane1.setTopComponent(jSplitPane2);

        jTabbedPane2.addTab("---のタイムライン", panelTimeline);

        jSplitPane1.setRightComponent(jTabbedPane2);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
}
