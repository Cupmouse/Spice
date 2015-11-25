package net.spicesoftware.resource;

import net.spicesoftware.api.resource.ResourceFromFile;
import net.spicesoftware.api.util.ToString;

import java.io.File;

/**
 * @since 2015/04/14
 */
public abstract class SpiceResourceFromFile extends SpiceResource implements ResourceFromFile {

    @ToString
    protected File file;

    public SpiceResourceFromFile(File file) {
        this.file = file;
    }

    @Override
    public File getFile() {
        return file;
    }
}
