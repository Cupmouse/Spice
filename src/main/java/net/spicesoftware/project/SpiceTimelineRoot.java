package net.spicesoftware.project;

import net.spicesoftware.SpiceBox;
import net.spicesoftware.api.project.TimelineRoot;
import net.spicesoftware.api.util.decoration.fill.color.RGBA32Color;
import net.spicesoftware.api.util.time.FrameTime;

/**
 * @since 2015/03/21
 */
public class SpiceTimelineRoot extends SpiceBox implements TimelineRoot {

    private SpiceTimelineRoot(SpiceTimelineRoot copyFrom) throws NullPointerException {
        super(copyFrom);
    }

    public SpiceTimelineRoot(int width, int height, FrameTime duration) throws IllegalArgumentException, NullPointerException {
        super(width, height, duration);
    }

    public SpiceTimelineRoot(int width, int height, FrameTime duration, RGBA32Color backgroundColor) throws IllegalArgumentException, NullPointerException {
        super(width, height, duration, backgroundColor);
    }

    @Override
    public SpiceTimelineRoot copyDeeply() {
        return new SpiceTimelineRoot(this);
    }
}
