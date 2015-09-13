package net.spicesoftware.registry;

import net.spicesoftware.api.image.CachedImage;
import net.spicesoftware.api.image.Image;
import net.spicesoftware.api.image.ImageConverter;
import net.spicesoftware.api.image.blender.ImageBlender;
import net.spicesoftware.api.image.blender.property.ImageBlenderProperty;
import net.spicesoftware.api.image.gs.EditableGrayScale8Image;
import net.spicesoftware.api.image.rgba.CachedRGBA32Image;
import net.spicesoftware.api.image.rgba.EditableRGBA32Image;
import net.spicesoftware.api.registry.Registry;
import net.spicesoftware.api.render.Renderable;
import net.spicesoftware.api.render.Renderer;
import net.spicesoftware.api.resource.builder.ResourceImageBuilder;
import net.spicesoftware.api.resource.builder.ResourceShapeBuilder;
import net.spicesoftware.api.resource.builder.ResourceSoundBuilder;
import net.spicesoftware.api.resource.builder.ResourceVideoBuilder;
import net.spicesoftware.api.util.AlreadyRegisteredInRegistryException;
import net.spicesoftware.api.util.NotRegisteredInRegistryException;
import net.spicesoftware.api.util.Pair;
import net.spicesoftware.api.util.decoration.fill.color.GrayScale8Color;
import net.spicesoftware.api.util.decoration.fill.color.RGB24Color;
import net.spicesoftware.api.util.decoration.fill.color.RGBA32Color;
import net.spicesoftware.api.util.vector.Vector2i;
import net.spicesoftware.api.value.Interpolator;
import net.spicesoftware.image.gs.SpiceCachedGrayScale8Image;
import net.spicesoftware.image.gs.SpiceEditableGrayScale8Image;
import net.spicesoftware.image.rgb.SpiceCachedRGB24Image;
import net.spicesoftware.image.rgb.SpiceEditableCSRGB24Image;
import net.spicesoftware.image.rgb.SpiceEditableRGB24Image;
import net.spicesoftware.image.rgba.SpiceCachedRGBA32Image;
import net.spicesoftware.image.rgba.SpiceEditableCSRGBA32Image;
import net.spicesoftware.image.rgba.SpiceEditableRGBA32Image;

import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @since 2015/03/19
 */
public class SpiceRegistry implements Registry {

    private final Map<Class, Map<String, Interpolator>> interpolators = new HashMap<>();
    private final Map<Pair<Class<? extends CachedImage>, Class<? extends ImageBlenderProperty>>, Map<String, ImageBlender>> imageBlenders = new HashMap<>();
    private final Map<Pair<Class, Class>, Map<String, ImageConverter>> imageConverters = new HashMap<>();

    @Override
    public <T extends Image> void addImage(Class<T> image) {

    }

    @Override
    public SpiceCachedGrayScale8Image createCachedGrayScaleImage(int width, int height, byte[] image) throws IllegalArgumentException {
        return new SpiceCachedGrayScale8Image(width, height, image);
    }

    @Override
    public SpiceEditableGrayScale8Image createNewGrayScaleImage(int width, int height, byte[] image) throws IllegalArgumentException {
        return new SpiceEditableGrayScale8Image(width, height, image);
    }

    @Override
    public SpiceEditableGrayScale8Image createNewGrayScaleImage(int width, int height) throws IllegalArgumentException {
        return new SpiceEditableGrayScale8Image(width, height);
    }

    @Override
    public SpiceEditableGrayScale8Image createNewGrayScaleImage(Vector2i size) {
        return new SpiceEditableGrayScale8Image(size.x, size.y);
    }

    @Override
    public SpiceEditableGrayScale8Image createNewGrayScaleImage(int width, int height, byte backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableGrayScale8Image(width, height, backgroundColor);
    }

    @Override
    public SpiceEditableGrayScale8Image createNewGrayScaleImage(Vector2i size, byte backgroundColor) {
        return new SpiceEditableGrayScale8Image(size.x, size.y, backgroundColor);
    }

    @Override
    public SpiceEditableGrayScale8Image createNewGrayScaleImage(int width, int height, int backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableGrayScale8Image(width, height, ((byte) backgroundColor));
    }

    @Override
    public SpiceEditableGrayScale8Image createNewGrayScaleImage(Vector2i size, int backgroundColor) {
        return new SpiceEditableGrayScale8Image(size.x, size.y, ((byte) backgroundColor));
    }

    @Override
    public SpiceEditableGrayScale8Image createNewGrayScaleImage(int width, int height, GrayScale8Color backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableGrayScale8Image(width, height, ((byte) backgroundColor.w));
    }

    @Override
    public SpiceEditableGrayScale8Image createNewGrayScaleImage(Vector2i size, GrayScale8Color backgroundColor) {
        return new SpiceEditableGrayScale8Image(size.x, size.y, ((byte) backgroundColor.w));
    }

    @Override
    public SpiceCachedRGB24Image createCachedRGBImage(int width, int height, int[] image) throws IllegalArgumentException {
        return new SpiceCachedRGB24Image(width, height, image);
    }

    @Override
    public SpiceEditableRGB24Image createNewRGBImage(int width, int height, int[] image) throws IllegalArgumentException {
        return new SpiceEditableRGB24Image(width, height, image);
    }

    @Override
    public SpiceEditableRGB24Image createNewRGBImage(int width, int height) throws IllegalArgumentException {
        return new SpiceEditableRGB24Image(width, height);
    }

    @Override
    public SpiceEditableRGB24Image createNewRGBImage(Vector2i size) {
        return new SpiceEditableRGB24Image(size.x, size.y);
    }

    @Override
    public SpiceEditableRGB24Image createNewRGBImage(int width, int height, int backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableRGB24Image(width, height, backgroundColor);
    }

    @Override
    public SpiceEditableRGB24Image createNewRGBImage(Vector2i size, int backgroundColor) {
        return new SpiceEditableRGB24Image(size.x, size.y, backgroundColor);
    }

    @Override
    public SpiceEditableRGB24Image createNewRGBImage(int width, int height, RGB24Color backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableRGB24Image(width, height, backgroundColor.toRGB24Int());
    }

    @Override
    public SpiceEditableRGB24Image createNewRGBImage(Vector2i size, RGB24Color backgroundColor) {
        return new SpiceEditableRGB24Image(size.x, size.y, backgroundColor.toRGB24Int());
    }

    @Override
    public SpiceEditableCSRGB24Image createNewCSRGBImage(int width, int height, EditableGrayScale8Image channelR, EditableGrayScale8Image channelG, EditableGrayScale8Image channelB) throws IllegalArgumentException {
        return new SpiceEditableCSRGB24Image(width, height, channelR, channelG, channelB);
    }

    @Override
    public SpiceEditableCSRGB24Image createNewCSRGBImage(Vector2i size, EditableGrayScale8Image channelR, EditableGrayScale8Image channelG, EditableGrayScale8Image channelB) {
        return new SpiceEditableCSRGB24Image(size.x, size.y, channelR, channelG, channelB);
    }

    @Override
    public CachedRGBA32Image createCachedRGBAImage(int width, int height, int[] image) throws IllegalArgumentException {
        return new SpiceCachedRGBA32Image(width, height, image);
    }

    @Override
    public EditableRGBA32Image createNewRGBAImage(int width, int height, int[] image) throws IllegalArgumentException {
        return new SpiceEditableRGBA32Image(width, height, image);
    }

    @Override
    public EditableRGBA32Image createNewRGBAImage(int width, int height) throws IllegalArgumentException {
        return new SpiceEditableRGBA32Image(width, height);
    }

    @Override
    public EditableRGBA32Image createNewRGBAImage(Vector2i size) {
        return new SpiceEditableRGBA32Image(size.x, size.y);
    }

    @Override
    public EditableRGBA32Image createNewRGBAImage(int width, int height, int backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableRGBA32Image(width, height, backgroundColor);
    }

    @Override
    public EditableRGBA32Image createNewRGBAImage(Vector2i size, int backgroundColor) {
        return new SpiceEditableRGBA32Image(size.x, size.y, backgroundColor);
    }

    @Override
    public EditableRGBA32Image createNewRGBAImage(int width, int height, long backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableRGBA32Image(width, height, ((int) backgroundColor));
    }

    @Override
    public EditableRGBA32Image createNewRGBAImage(Vector2i size, long backgroundColor) {
        return new SpiceEditableRGBA32Image(size.x, size.y, ((int) backgroundColor));
    }

    @Override
    public EditableRGBA32Image createNewRGBAImage(int width, int height, RGBA32Color backgroundColor) throws IllegalArgumentException {
        return new SpiceEditableRGBA32Image(width, height, backgroundColor.toRGBA32Int());
    }

    @Override
    public EditableRGBA32Image createNewRGBAImage(Vector2i size, RGBA32Color backgroundColor) {
        return new SpiceEditableRGBA32Image(size.x, size.y, backgroundColor.toRGBA32Int());
    }

    @Override
    public EditableRGBA32Image createNewCSRGBAImage(int width, int height, EditableGrayScale8Image channelR, EditableGrayScale8Image channelG, EditableGrayScale8Image channelB, EditableGrayScale8Image channelA) throws IllegalArgumentException {
        return new SpiceEditableCSRGBA32Image(width, height, channelR, channelG, channelB, channelA);
    }

    @Override
    public EditableRGBA32Image createNewCSRGBAImage(Vector2i size, EditableGrayScale8Image channelR, EditableGrayScale8Image channelG, EditableGrayScale8Image channelB, EditableGrayScale8Image channelA) {
        return new SpiceEditableCSRGBA32Image(size.x, size.y, channelR, channelG, channelB, channelA);
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
    public <T> void registerInterpolator(Class<T> clazz, @Size(min = 1) String id, Interpolator<T> interpolator) throws AlreadyRegisteredInRegistryException {
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
    public <T> Optional<String> getInterpolatorsId(Class<T> clazz, Interpolator<T> interpolator) {
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
    public <I extends CachedImage, B extends ImageBlenderProperty> void registerImageBlender(Class<I> clazzI, Class<B> clazzB, @Size(min = 1) String id, ImageBlender<I, B> imageBlender) throws AlreadyRegisteredInRegistryException {
        Pair pair = Pair.of(clazzI, clazzB);

        Map<String, ImageBlender> classImageBlenders = imageBlenders.get(pair);

        if (classImageBlenders != null) {
            if (classImageBlenders.containsKey(id)) {
                throw new AlreadyRegisteredInRegistryException();
            }
        } else {
            imageBlenders.put(pair, classImageBlenders = new HashMap<>());
        }

        classImageBlenders.put(id, imageBlender);
    }

    @Override
    public <I extends CachedImage, B extends ImageBlenderProperty> Optional<ImageBlender<I, B>> getImageBlender(Class<I> clazzI, Class<B> clazzB, @Size(min = 1) String id) {
        Map<String, ImageBlender> classImageBlenders = imageBlenders.get(Pair.of(clazzI, clazzB));

        if (classImageBlenders == null) {
            return Optional.empty();
        }

        return Optional.ofNullable(classImageBlenders.get(id));
    }

    @Override
    public <I extends CachedImage, B extends ImageBlenderProperty> Optional<String> getImageBlendersId(Class<I> clazzI, Class<B> clazzB, ImageBlender<I, B> imageBlender) {
        Map<String, ImageBlender> classImageBlenders = imageBlenders.get(Pair.of(clazzI, clazzB));

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
    public <I extends CachedImage, B extends ImageBlenderProperty> boolean isRegisteredImageBlender(Class<I> clazzI, Class<B> clazzB, ImageBlender<I, B> imageBlender) {
        return getImageBlendersId(clazzI, clazzB, imageBlender).isPresent();
    }

    @Override
    public <I extends Image, O extends CachedImage> void registerImageConverter(Class<I> inputImageClass, Class<O> outputImageClass, @Size(min = 1) String id, ImageConverter<I, O> imageConverter) throws AlreadyRegisteredInRegistryException {
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
    public <I extends Image, O extends CachedImage> Optional<String> getImageConvertersId(Class<I> inputImageClass, Class<O> outputImageClass, ImageConverter<I, O> imageConverter) {
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
