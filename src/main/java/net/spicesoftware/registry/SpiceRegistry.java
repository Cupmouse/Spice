package net.spicesoftware.registry;

import net.spicesoftware.api.image.CachedImage;
import net.spicesoftware.api.image.Image;
import net.spicesoftware.api.image.ImageConverter;
import net.spicesoftware.api.image.blender.ImageBlender;
import net.spicesoftware.api.image.gs.EditableGrayScaleImage;
import net.spicesoftware.api.image.rgba.CachedRGBAImage;
import net.spicesoftware.api.image.rgba.EditableRGBAImage;
import net.spicesoftware.api.registry.Registry;
import net.spicesoftware.api.render.Renderable;
import net.spicesoftware.api.render.Renderer;
import net.spicesoftware.api.resource.builder.ResourceImageBuilder;
import net.spicesoftware.api.resource.builder.ResourceShapeBuilder;
import net.spicesoftware.api.resource.builder.ResourceSoundBuilder;
import net.spicesoftware.api.resource.builder.ResourceVideoBuilder;
import net.spicesoftware.api.util.*;
import net.spicesoftware.api.util.color.GrayScaleColor;
import net.spicesoftware.api.util.color.RGB24Color;
import net.spicesoftware.api.util.color.RGBA32Color;
import net.spicesoftware.api.util.vector.Vector2i;
import net.spicesoftware.api.value.Interpolator;
import net.spicesoftware.image.gs.SpiceCachedGrayScaleImage;
import net.spicesoftware.image.gs.SpiceEditableGrayScaleImage;
import net.spicesoftware.image.rgb.SpiceCachedRGBImage;
import net.spicesoftware.image.rgb.SpiceEditableCSRGBImage;
import net.spicesoftware.image.rgb.SpiceEditableRGBImage;
import net.spicesoftware.image.rgba.SpiceCachedRGBAImage;
import net.spicesoftware.image.rgba.SpiceEditableCSRGBAImage;
import net.spicesoftware.image.rgba.SpiceEditableRGBAImage;

import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @since 2015/03/19
 */
public class SpiceRegistry implements Registry {

    private final Map<Class, Map<String, Interpolator>> interpolators = new HashMap<>();
    private final Map<Class, Map<String, ImageBlender>> imageBlenders = new HashMap<>();
    private final Map<Pair<Class, Class>, Map<String, ImageConverter>> imageConverters = new HashMap<>();

    @Override
    public <T extends Image> void addImage(Class<T> image) {

    }

    @Override
    public SpiceCachedGrayScaleImage createCachedGrayScaleImage(int width, int height, byte[] image) throws IllegalArgumentException {
        return new SpiceCachedGrayScaleImage(width, height, image);
    }

    @Override
    public SpiceEditableGrayScaleImage createNewGrayScaleImage(int width, int height, byte[] image) throws IllegalArgumentException {
        return new SpiceEditableGrayScaleImage(width, height, image);
    }

    @Override
    public SpiceEditableGrayScaleImage createNewGrayScaleImage(int width, int height) throws IllegalArgumentException {
        return new SpiceEditableGrayScaleImage(width, height);
    }

    @Override
    public SpiceEditableGrayScaleImage createNewGrayScaleImage(Vector2i size) {
        return new SpiceEditableGrayScaleImage(size.x, size.y);
    }

    @Override
    public SpiceEditableGrayScaleImage createNewGrayScaleImage(int width, int height, byte backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableGrayScaleImage(width, height, backgroundColor);
    }

    @Override
    public SpiceEditableGrayScaleImage createNewGrayScaleImage(Vector2i size, byte backgroundColor) {
        return new SpiceEditableGrayScaleImage(size.x, size.y, backgroundColor);
    }

    @Override
    public SpiceEditableGrayScaleImage createNewGrayScaleImage(int width, int height, int backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableGrayScaleImage(width, height, ((byte) backgroundColor));
    }

    @Override
    public SpiceEditableGrayScaleImage createNewGrayScaleImage(Vector2i size, int backgroundColor) {
        return new SpiceEditableGrayScaleImage(size.x, size.y, ((byte) backgroundColor));
    }

    @Override
    public SpiceEditableGrayScaleImage createNewGrayScaleImage(int width, int height, GrayScaleColor backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableGrayScaleImage(width, height, ((byte) backgroundColor.w));
    }

    @Override
    public SpiceEditableGrayScaleImage createNewGrayScaleImage(Vector2i size, GrayScaleColor backgroundColor) {
        return new SpiceEditableGrayScaleImage(size.x, size.y, ((byte) backgroundColor.w));
    }

    @Override
    public SpiceCachedRGBImage createCachedRGBImage(int width, int height, int[] image) throws IllegalArgumentException {
        return new SpiceCachedRGBImage(width, height, image);
    }

    @Override
    public SpiceEditableRGBImage createNewRGBImage(int width, int height, int[] image) throws IllegalArgumentException {
        return new SpiceEditableRGBImage(width, height, image);
    }

    @Override
    public SpiceEditableRGBImage createNewRGBImage(int width, int height) throws IllegalArgumentException {
        return new SpiceEditableRGBImage(width, height);
    }

    @Override
    public SpiceEditableRGBImage createNewRGBImage(Vector2i size) {
        return new SpiceEditableRGBImage(size.x, size.y);
    }

    @Override
    public SpiceEditableRGBImage createNewRGBImage(int width, int height, int backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableRGBImage(width, height, backgroundColor);
    }

    @Override
    public SpiceEditableRGBImage createNewRGBImage(Vector2i size, int backgroundColor) {
        return new SpiceEditableRGBImage(size.x, size.y, backgroundColor);
    }

    @Override
    public SpiceEditableRGBImage createNewRGBImage(int width, int height, RGB24Color backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableRGBImage(width, height, backgroundColor.getIntValue());
    }

    @Override
    public SpiceEditableRGBImage createNewRGBImage(Vector2i size, RGB24Color backgroundColor) {
        return new SpiceEditableRGBImage(size.x, size.y, backgroundColor.getIntValue());
    }

    @Override
    public SpiceEditableCSRGBImage createNewCSRGBImage(int width, int height, EditableGrayScaleImage channelR, EditableGrayScaleImage channelG, EditableGrayScaleImage channelB) throws IllegalArgumentException {
        return new SpiceEditableCSRGBImage(width, height, channelR, channelG, channelB);
    }

    @Override
    public SpiceEditableCSRGBImage createNewCSRGBImage(Vector2i size, EditableGrayScaleImage channelR, EditableGrayScaleImage channelG, EditableGrayScaleImage channelB) {
        return new SpiceEditableCSRGBImage(size.x, size.y, channelR, channelG, channelB);
    }

    @Override
    public CachedRGBAImage createCachedRGBAImage(int width, int height, int[] image) throws IllegalArgumentException {
        return new SpiceCachedRGBAImage(width, height, image);
    }

    @Override
    public EditableRGBAImage createNewRGBAImage(int width, int height, int[] image) throws IllegalArgumentException {
        return new SpiceEditableRGBAImage(width, height, image);
    }

    @Override
    public EditableRGBAImage createNewRGBAImage(int width, int height) throws IllegalArgumentException {
        return new SpiceEditableRGBAImage(width, height);
    }

    @Override
    public EditableRGBAImage createNewRGBAImage(Vector2i size) {
        return new SpiceEditableRGBAImage(size.x, size.y);
    }

    @Override
    public EditableRGBAImage createNewRGBAImage(int width, int height, int backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableRGBAImage(width, height, backgroundColor);
    }

    @Override
    public EditableRGBAImage createNewRGBAImage(Vector2i size, int backgroundColor) {
        return new SpiceEditableRGBAImage(size.x, size.y, backgroundColor);
    }

    @Override
    public EditableRGBAImage createNewRGBAImage(int width, int height, long backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableRGBAImage(width, height, ((int) backgroundColor));
    }

    @Override
    public EditableRGBAImage createNewRGBAImage(Vector2i size, long backgroundColor) {
        return new SpiceEditableRGBAImage(size.x, size.y, ((int) backgroundColor));
    }

    @Override
    public EditableRGBAImage createNewRGBAImage(int width, int height, RGBA32Color backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableRGBAImage(width, height, backgroundColor.getIntValue());
    }

    @Override
    public EditableRGBAImage createNewRGBAImage(Vector2i size, RGBA32Color backgroundColor) {
        return new SpiceEditableRGBAImage(size.x, size.y, backgroundColor.getIntValue());
    }

    @Override
    public EditableRGBAImage createNewCSRGBAImage(int width, int height, EditableGrayScaleImage channelR, EditableGrayScaleImage channelG, EditableGrayScaleImage channelB, EditableGrayScaleImage channelA) throws IllegalArgumentException {
        return new SpiceEditableCSRGBAImage(width, height, channelR, channelG, channelB, channelA);
    }

    @Override
    public EditableRGBAImage createNewCSRGBAImage(Vector2i size, EditableGrayScaleImage channelR, EditableGrayScaleImage channelG, EditableGrayScaleImage channelB, EditableGrayScaleImage channelA) {
        return new SpiceEditableCSRGBAImage(size.x, size.y, channelR, channelG, channelB, channelA);
    }

    @Override
    public ResourceImageBuilder getResourceImageBuilder() {
        // TODO
        return null;
    }

    @Override
    public ResourceShapeBuilder getResourceShapeBuilder() {
        // TODO
        return null;
    }

    @Override
    public ResourceSoundBuilder getResourceSoundBuilder() {
        // TODO
        return null;
    }

    @Override
    public ResourceVideoBuilder getResourceVideoBuilder() {
        // TODO
        return null;
    }

    @Override
    public <T> void registerInterpolator(Class<T> clazz, @Size(min = 1) String id, Interpolator<T> interpolator) throws AlreadyRegisteredException {
        Map<String, Interpolator> classInterpolators;

        if ((classInterpolators = interpolators.get(clazz)) == null) {
            interpolators.put(clazz, classInterpolators = new HashMap<>());
        }

        if (classInterpolators.containsKey(id)) {
            throw new IllegalStateException();
        }

        classInterpolators.put(id, interpolator);
    }

    @Override
    public <T> Optional<Interpolator<T>> getInterpolatorOf(Class<T> clazz, @Size(min = 1) String id) {
        Map<String, Interpolator> classInterpolators = interpolators.get(clazz);

        if (classInterpolators == null) {
            return null;
        }

        return Optional.ofNullable(classInterpolators.get(id));
    }

    @Override
    public <T> Optional<String> getInterpolatorsId(Class<T> clazz, Interpolator<T> interpolator) throws NotRegisteredInterpolatorException {
        Map<String, Interpolator> classInterpolators = interpolators.get(clazz);

        if (classInterpolators == null) {
            return Optional.empty();
        }

        for (Map.Entry<String, Interpolator> entry : classInterpolators.entrySet()) {
            if (entry.getValue() == interpolator) {
                return Optional.of(entry.getKey());
            }
        }

        return Optional.empty();
    }

    @Override
    public <T> boolean isRegisteredInterpolator(Class<T> clazz, Interpolator<T> interpolator) {
        return getInterpolatorsId(clazz, interpolator).isPresent();
    }

    @Override
    public <I extends CachedImage> void registerImageBlender(Class<I> clazz, @Size(min = 1) String id, ImageBlender<?, I> imageBlender) throws AlreadyRegisteredException {
        Map<String, ImageBlender> classImageBlenders = imageBlenders.get(clazz);

        if (classImageBlenders == null) {
            imageBlenders.put(clazz, classImageBlenders = new HashMap<>());
        }

        if (imageBlenders.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        classImageBlenders.put(id, imageBlender);
    }

    @Override
    public <I extends CachedImage> Optional<ImageBlender<?, I>> getImageBlender(Class<I> clazz, @Size(min = 1) String id) {
        Map<String, ImageBlender> classImageBlenders = imageBlenders.get(clazz);

        if (classImageBlenders == null) {
            throw new IllegalArgumentException();
        }

        return Optional.ofNullable(classImageBlenders.get(id));
    }

    @Override
    public <I extends CachedImage> Optional<String> getImageBlendersId(Class<I> clazz, ImageBlender<?, I> imageBlender) throws NotRegisteredImageBlenderException {
        Map<String, ImageBlender> classImageBlenders = imageBlenders.get(clazz);

        if (classImageBlenders == null) {
            return Optional.empty();
        }

        for (Map.Entry<String, ImageBlender> entry : classImageBlenders.entrySet()) {
            if (entry.getValue() == imageBlender) {
                return Optional.of(entry.getKey());
            }
        }

        return Optional.empty();
    }

    @Override
    public <I extends CachedImage> boolean isRegisteredImageBlender(Class<I> clazz, ImageBlender<?, I> imageBlender) {
        return getImageBlendersId(clazz, imageBlender).isPresent();
    }

    @Override
    public <I extends Image, O extends CachedImage> void registerImageConverter(Class<I> inputImageClass, Class<O> outputImageClass, @Size(min = 1) String id, ImageConverter<I, O> imageConverter) throws AlreadyRegisteredException {
        Map<String, ImageConverter> classImageConverter = imageConverters.get(Pair.of(inputImageClass, outputImageClass));

        if (classImageConverter == null) {
            classImageConverter = new HashMap<>();
        }

        if (classImageConverter.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        classImageConverter.put(id, imageConverter);
    }

    @Override
    public <I extends Image, O extends CachedImage> Optional<ImageConverter<I, O>> getImageConverter(Class<I> inputImageClass, Class<O> outputImageClass, @Size(min = 1) String id) {
        Map<String, ImageConverter> classImageConverter = imageConverters.get(Pair.of(inputImageClass, outputImageClass));

        if (classImageConverter == null) {
            return Optional.empty();
        }

        return Optional.ofNullable(classImageConverter.get(id));
    }

    @Override
    public <I extends Image, O extends CachedImage> Optional<String> getImageConvertersId(Class<I> inputImageClass, Class<O> outputImageClass, ImageConverter<I, O> imageConverter) throws NotRegisteredImageConverterException {
        Map<String, ImageConverter> classImageConverter = imageConverters.get(Pair.of(inputImageClass, outputImageClass));

        if (classImageConverter == null) {
            return Optional.empty();
        }

        for (Map.Entry<String, ImageConverter> entry : classImageConverter.entrySet()) {
            if (entry.getValue() == imageConverter) {
                return Optional.of(entry.getKey());
            }
        }

        return Optional.empty();
    }

    @Override
    public <I extends Image, O extends CachedImage> boolean isRegisteredImageConverter(Class<I> inputImageClass, Class<O> outputImageClass, ImageConverter<I, O> imageConverter) {
        return getImageConvertersId(inputImageClass, outputImageClass, imageConverter).isPresent();
    }

    @Override
    public <T extends Renderable, I extends Image> Optional<Renderer<T, I>> getRendererOf(Class<T> renderableClass, Class<I> imageClass) {
        // TODO
        return null;
    }

    @Override
    public void setRenderer(Renderer renderer) {
        // TODO
    }

}
