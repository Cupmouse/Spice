package net.spicesoftware.value;

import net.spicesoftware.api.util.DeepCopyable;
import net.spicesoftware.api.util.NotRegisteredInRegistryException;
import net.spicesoftware.api.util.Pair;
import net.spicesoftware.api.value.Interpolator;
import net.spicesoftware.api.value.KeyFramedValue;

import javax.validation.constraints.Min;
import java.util.*;

/**
 * @since 2015/04/07
 */
public class SpiceKeyFramedValue<T extends DeepCopyable> implements KeyFramedValue<T> {

    private List<Pair<Integer, SpiceKeyFrame<T>>> keyFrames = new ArrayList<>();

    private int getIndexAffectFirst(int frame) {
        Pair<Integer, SpiceKeyFrame<T>> firstEntry = keyFrames.get(0);
        Pair<Integer, SpiceKeyFrame<T>> lastEntry = keyFrames.get(keyFrames.size() - 1);

        // 最初に範囲外か確認する
        if (firstEntry.a >= frame) {
            return 0;
        } else if (lastEntry.a <= frame) {
            return keyFrames.size();
        }

        int left = 0, right = keyFrames.size() - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            int index = keyFrames.get(mid).a;

            if (index == frame) {
                return mid;
            } else if (right - left == 1) {
                return left;
            } else if (frame < index) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    @Override
    public Map<Integer, SpiceKeyFrame<T>> getKeyFrameMap() {
        Map<Integer, SpiceKeyFrame<T>> map = new HashMap<>();
        for (Pair<Integer, SpiceKeyFrame<T>> keyFrame : keyFrames) {
            map.put(keyFrame.a, keyFrame.b);
        }
        return Collections.unmodifiableMap(map);
    }

    @Override
    public int getNumberOfKeyFrames() {
        return keyFrames.size();
    }

    @Override
    public Pair<Integer, SpiceKeyFrame<T>> addKeyFrameAt(@Min(0) int frame, Interpolator<T> interpolator, T value) throws NotRegisteredInRegistryException {
        int index = keyFrames.size() == 0 ? 0 : getIndexAffectFirst(frame) + 1;
        SpiceKeyFrame<T> newKeyframe = new SpiceKeyFrame<>(interpolator, value);
        keyFrames.add(index, Pair.of(frame, newKeyframe));
        return Pair.of(index, newKeyframe);
    }

    @Override
    public Optional<SpiceKeyFrame<T>> getKeyFrameAt(@Min(0) int frame) {
        int nearestIndex = getKeyframeIndexNearest(frame);
        return nearestIndex == frame ? Optional.of(keyFrames.get(nearestIndex).b) : Optional.<SpiceKeyFrame<T>>empty();
    }

    @Override
    public void removeKeyFrameAt(@Min(0) int frame) {
        int nearestIndex = getKeyframeIndexNearest(frame);
        if (nearestIndex == frame) {
            keyFrames.remove(getKeyframeIndexNearest(frame));
        }
    }

    private int getKeyframeIndexNearest(int frame) {
        int indexAffectFirst = getIndexAffectFirst(frame);

        if (indexAffectFirst == 0 || indexAffectFirst == keyFrames.size() - 1) {
            return indexAffectFirst;
        } else {
            int firstKeyframeFrame = keyFrames.get(indexAffectFirst).a;
            int secondKeyframeFrame = keyFrames.get(indexAffectFirst + 1).a;
            return frame - firstKeyframeFrame < secondKeyframeFrame - frame ? indexAffectFirst : indexAffectFirst + 1;
        }
    }

    @Override
    public SpiceKeyFramedValue<T> copyDeeply() {
        return new SpiceKeyFramedValue<>();
    }

    @Override
    public T getValueAt(@Min(0) int frame) {
        int indexAffectFirst = getIndexAffectFirst(frame);

        // 末端か始端ならその値を返す
        if (indexAffectFirst == 0 || indexAffectFirst == keyFrames.size() - 1) {
            Pair<Integer, SpiceKeyFrame<T>> keyFrame = keyFrames.get(indexAffectFirst);
            return keyFrame.b.getValue();
        } else {
            // 2つ影響するキーフレームが存在するなら計算して返す
            Pair<Integer, SpiceKeyFrame<T>> firstKeyFrame = keyFrames.get(indexAffectFirst);
            Pair<Integer, SpiceKeyFrame<T>> secondKeyFrame = keyFrames.get(indexAffectFirst + 1);
            return firstKeyFrame.b.getInterpolator().calculate(firstKeyFrame.a, secondKeyFrame.a, firstKeyFrame.b.getValue(), secondKeyFrame.b.getValue(), frame);
        }
    }
}
