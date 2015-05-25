package net.spicesoftware.image.blender;

import net.spicesoftware.api.image.CachedImage;
import net.spicesoftware.api.image.Image;
import net.spicesoftware.api.image.blender.ImageBlender;
import net.spicesoftware.api.util.Pair;

import javax.validation.constraints.Size;

/**
 * @since 2015/03/24
 */
public abstract class SpiceImageBlender<D, I extends CachedImage> implements ImageBlender<D, I> {
}
