package net.spicesoftware;

import net.spicesoftware.api.layer.Layer;
import net.spicesoftware.api.project.Project;
import net.spicesoftware.api.project.TimelineRoot;
import net.spicesoftware.api.util.time.FrameTime;
import net.spicesoftware.gui.SpiceMainFrame;
import net.spicesoftware.gui.SpiceStartSplash;
import net.spicesoftware.item.SpiceItemShape;
import net.spicesoftware.project.SpiceProject;

import java.awt.*;
import java.io.IOException;

/**
 * @since 2015/09/15
 */
public final class StartMain {

    public static void main(String[] args) {
        try {
            SpiceStartSplash spiceStartSplash = new SpiceStartSplash();
            EventQueue.invokeLater(() -> spiceStartSplash.setVisible(true));

            SpiceSession spiceSession = new SpiceSession();
            SpiceProject project = new SpiceProject(spiceSession);
            spiceSession.openProject(project);

            TimelineRoot newTimeline = project.createAndSetNewTimeline(500, 500, FrameTime.of(500, 60f));

            Layer layer = newTimeline.addLastNewLayer();
            layer.addItemDuration(new SpiceItemShape(), 0, 100);
            layer.addItemDuration(new SpiceItemShape(), 150, 170);

            SpiceMainFrame spiceMainFrame = new SpiceMainFrame(spiceSession);
            EventQueue.invokeLater(() -> spiceMainFrame.setVisible(true));
            EventQueue.invokeLater(() -> spiceStartSplash.setVisible(false));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
