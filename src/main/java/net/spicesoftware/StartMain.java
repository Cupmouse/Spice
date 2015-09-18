package net.spicesoftware;

import net.spicesoftware.gui.SpiceMainFrame;
import net.spicesoftware.gui.SpiceStartSplash;

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
            SpiceMainFrame spiceMainFrame = new SpiceMainFrame();
            EventQueue.invokeLater(() -> spiceMainFrame.setVisible(true));
            EventQueue.invokeLater(() -> spiceStartSplash.setVisible(false));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
