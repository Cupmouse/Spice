package net.spicesoftware.value;

import net.spicesoftware.SpiceSession;
import net.spicesoftware.api.util.DeepCopyable;
import net.spicesoftware.api.util.NotRegisteredInterpolatorException;
import net.spicesoftware.api.value.Interpolator;
import net.spicesoftware.api.value.KeyFrame;

/**
 * @since 2015/04/08
 */
public class SpiceKeyFrame<T extends DeepCopyable> implements KeyFrame<T> {

    private Interpolator<T> interpolator;
    private T value;

    public SpiceKeyFrame(Interpolator<T> interpolator, T value) throws NotRegisteredInterpolatorException {
        setInterpolator(interpolator);
        this.value = value;
    }

    @Override
    public Interpolator<T> getInterpolator() {
        return interpolator;
    }

    @Override
    public void setInterpolator(Interpolator<T> interpolator) throws NotRegisteredInterpolatorException {
        if (!SpiceSession.getInstance().getRegistry().isRegisteredIntepolator(interpolator)) {
            throw new NotRegisteredInterpolatorException();
        }
        this.interpolator = interpolator;
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
