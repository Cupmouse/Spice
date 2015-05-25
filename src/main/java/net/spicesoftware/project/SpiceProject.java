package net.spicesoftware.project;

import net.spicesoftware.SpiceSession;
import net.spicesoftware.api.Spice;
import net.spicesoftware.api.project.Project;
import net.spicesoftware.api.project.TimelineRoot;
import net.spicesoftware.project.resource.SpiceResourceManager;

import javax.validation.constraints.Size;
import java.time.ZonedDateTime;

/**
 * @since 2015/03/21
 */
public class SpiceProject implements Project {

    private final SpiceSession spiceSession;
    private String name;
    private ZonedDateTime createdDate;
    private SpiceTimelineRoot timeline;

    public SpiceProject(SpiceSession spiceSession) {
        this.spiceSession = spiceSession;
    }

    @Override
    public Spice getSpice() {
        return spiceSession;
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
    public TimelineRoot getTimeline() {
        return timeline;
    }

    @Override
    public void resetTimeline() {

    }

    @Override
    public SpiceResourceManager getResourceManager() {
        return null;
    }
}
