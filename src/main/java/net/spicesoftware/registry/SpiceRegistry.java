package net.spicesoftware.registry;

import net.spicesoftware.api.Builder;
import net.spicesoftware.api.gui.window.WindowSystem;
import net.spicesoftware.api.image.CachedImage;
import net.spicesoftware.api.image.Image;
import net.spicesoftware.api.image.ImageConverter;
import net.spicesoftware.api.image.blender.ImageBlender;
import net.spicesoftware.api.image.blender.property.ImageBlenderProperty;
import net.spicesoftware.api.registry.ImageCreator;
import net.spicesoftware.api.registry.Registry;
import net.spicesoftware.api.render.Renderable;
import net.spicesoftware.api.render.Renderer;
import net.spicesoftware.api.util.AlreadyRegisteredException;
import net.spicesoftware.api.util.Pair;
import net.spicesoftware.api.value.Interpolator;

import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @since 2015/03/19
 */
public final class SpiceRegistry implements Registry {

    private final ImageCreator imageCreator = new SpiceImageCreator();

    private final Map<Class<? extends Builder>, Supplier<? extends Builder>> builders = new HashMap<>();

    private final Map<Class<? extends WindowSystem>, WindowSystem> windowSystemMap = new HashMap<>();
    private final Map<Class, Map<String, Interpolator>> interpolators = new HashMap<>();
    private final Map<Pair<Class<? extends CachedImage>, Class<? extends ImageBlenderProperty>>, Map<String, ImageBlender>> imageBlenders = new HashMap<>();
    private final Map<Pair<Class, Class>, Map<String, ImageConverter>> imageConverters = new HashMap<>();
//    private final Map<Pair<Class, Class>, Map<String, ImageConverter>> imageConverters = new HashMap<>();

    @Override
    public <WS extends WindowSystem<WS>> Optional<WS> getWindowSystem(Class<WS> windowSystemClass) {
        return Optional.ofNullable(((WS) windowSystemMap.get(windowSystemClass)));
    }

    @Override
    public <WS extends WindowSystem<WS>> void registerWindowSystem(Class<WS> windowSystemClass, WS windowSystem) throws AlreadyRegisteredException {
        if (windowSystemMap.containsKey(windowSystemClass)) {
            throw new AlreadyRegisteredException();
        }
        windowSystemMap.put(windowSystemClass, windowSystem);
    }


    @Override
    public <T extends Builder> T createBuilder(Class<T> clazz) throws IllegalStateException {
        return ((Supplier<T>) builders.get(clazz)).get();
    }

    @Override
    public <T extends Builder> void registerBuilder(Class<T> clazz, Supplier<T> builderSupplier) throws AlreadyRegisteredException {
        if (builders.containsKey(clazz)) {
            throw new AlreadyRegisteredException();
        }

        // TODO 重複チェック（Supplierが毎回同じインスタンスを返していないかチェック）
        builders.put(clazz, builderSupplier);
    }

    @Override
    public <T extends Builder> Supplier<T> unregisterBuilder(Class<T> clazz) throws IllegalArgumentException {
        if (!builders.containsKey(clazz)) {
            throw new IllegalArgumentException();
        }

        return (Supplier<T>) builders.remove(clazz);
    }

    @Override
    public boolean isRegisteredBuilder(Class<? extends Builder> clazz) {
        return builders.containsKey(clazz);
    }

    @Override
    public ImageCreator getImageCreator() {
        return imageCreator;
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
    public <I extends CachedImage, B extends ImageBlenderProperty> void registerImageBlender(Class<I> clazzI, Class<B> clazzB, @Size(min = 1) String id, ImageBlender<I, B> imageBlender) throws AlreadyRegisteredException {
        Pair pair = Pair.of(clazzI, clazzB);

        Map<String, ImageBlender> classImageBlenders = imageBlenders.get(pair);

        if (classImageBlenders != null) {
            if (classImageBlenders.containsKey(id)) {
                throw new AlreadyRegisteredException();
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
