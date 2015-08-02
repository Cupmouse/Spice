package net.spicesoftware.project;

import net.spicesoftware.SpiceBox;
import net.spicesoftware.api.project.TimelineRoot;
import net.spicesoftware.api.util.decoration.fill.color.RGBA32Color;

/**
 * @since 2015/03/21
 */
public class SpiceTimelineRoot extends SpiceBox implements TimelineRoot {

    private SpiceTimelineRoot(SpiceTimelineRoot copyFrom) {
        super(copyFrom);
    }

    public SpiceTimelineRoot(int width, int height) {
        super(width, height);
    }

    public SpiceTimelineRoot(int width, int height, RGBA32Color backgroundColor) {
        super(width, height, backgroundColor);
    }

    @Override
    public SpiceTimelineRoot copyDeeply() {
        return new SpiceTimelineRoot(this);
    }
}
