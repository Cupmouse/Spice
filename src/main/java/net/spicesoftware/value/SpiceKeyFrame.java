package net.spicesoftware.value;

import net.spicesoftware.SpiceSession;
import net.spicesoftware.api.util.DeepCopyable;
import net.spicesoftware.api.util.NotRegisteredInRegistryException;
import net.spicesoftware.api.value.Interpolator;
import net.spicesoftware.api.value.KeyFrame;

import java.util.Optional;

/**
 * @since 2015/04/08
 */
public class SpiceKeyFrame<T extends DeepCopyable> implements KeyFrame<T> {

    private Interpolator<T> interpolator;
    private T value;

    public SpiceKeyFrame(Interpolator<T> interpolator, T value) throws NotRegisteredInRegistryException {
        this.interpolator = interpolator;
        this.value = value;
    }

    @Override
    public Interpolator<T> getInterpolator() {
        return interpolator;
    }

    @Override
    public void setInterpolator(Class<T> clazz, String id) throws NotRegisteredInRegistryException {
        Optional<Interpolator<T>> interpolator = SpiceSession.getInstance().getRegistry().getInterpolatorOf(clazz, id);

        if (!interpolator.isPresent()) {
            throw new NotRegisteredInRegistryException();
        }

        this.interpolator = interpolator.get();
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public SpiceKeyFrame<T> copyDeeply() {
        return new SpiceKeyFrame<>(interpolator, (T) value.copyDeeply());
    }
}
