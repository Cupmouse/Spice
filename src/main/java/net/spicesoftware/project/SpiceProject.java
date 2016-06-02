package net.spicesoftware.project;

import net.spicesoftware.SpiceSession;
import net.spicesoftware.api.Spice;
import net.spicesoftware.api.project.Project;
import net.spicesoftware.api.project.TimelineRoot;
import net.spicesoftware.api.util.ToString;
import net.spicesoftware.api.util.time.FrameTime;
import net.spicesoftware.project.resource.SpiceResourceManager;

import javax.validation.constraints.Size;
import java.time.ZonedDateTime;

import static net.spicesoftware.api.util.Validate.nullNot;

/**
 * @since 2015/03/21
 */
public final class SpiceProject implements Project {

    // TODO 読み込み
    @ToString
    private String name;
    @ToString
    private ZonedDateTime createdDate;
    @ToString
    private SpiceTimelineRoot timeline;
    @ToString
    private SpiceResourceManager resourceManager;

    public SpiceProject() throws NullPointerException {
        this.resourceManager = new SpiceResourceManager();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(@Size(min = 1) String name) {
        this.name = name;
    }

    @Override
    public ZonedDateTime getCreatedDate() {
        return this.createdDate;
    }

    @Override
    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public TimelineRoot createAndSetNewTimeline(int width, int height, FrameTime duration) throws IllegalArgumentException, IllegalStateException, NullPointerException {
        return this.timeline = new SpiceTimelineRoot(width, height, duration);
    }

    @Override
    public TimelineRoot getTimeline() {
        return timeline;
    }

    @Override
    public void resetTimeline() {
        nullNot(timeline);
        this.timeline = new SpiceTimelineRoot(timeline.getWidth(), timeline.getHeight(), timeline.getDuration());
    }

    @Override
    public SpiceResourceManager getResourceManager() {
        return resourceManager;
    }
}
