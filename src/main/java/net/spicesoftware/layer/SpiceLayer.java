package net.spicesoftware.layer;

import net.spicesoftware.api.image.blender.ImageBlender;
import net.spicesoftware.api.item.Item;
import net.spicesoftware.api.layer.Layer;
import net.spicesoftware.api.util.NotRegisteredInRegistryException;
import net.spicesoftware.api.util.Pair;
import net.spicesoftware.api.util.Validate;
import net.spicesoftware.api.util.time.FrameRanged;

import javax.validation.constraints.Min;
import java.util.*;

import static net.spicesoftware.api.util.Validate.*;

/**
 * @since 2015/03/21
 */
public class SpiceLayer implements Layer {

    private List<FrameRanged<Item>> items = new ArrayList<>();

    @Override
    public List<FrameRanged<Item>> getAllItems() {
        return Collections.unmodifiableList(this.items);
    }

    @Override
    public int getNumberOfItems() {
        return items.size();
    }

    private List<FrameRanged<Item>> getItemInFrameRange(Pair<Integer, Integer> indexFromNearest, Pair<Integer, Integer> indexToNearest) {
        // 指定フレームに一番近いフレームを持つアイテムを探し、それから範囲にあるアイテムのインデックスを求める

        // アイテムとアイテムの空白の空間に指定開始フレームがある場合
        if (indexFromNearest.b == -1) {
            // 指定開始フレームより大きい開始フレームのアイテムはない（指定開始フレームがどのアイテムよりも一番右にある）、当てはまるアイテムは存在しない
            return Collections.emptyList();
        }

        // アイテムとアイテムの空白の空間に指定終了フレームがある場合
        if (indexToNearest.a == -1) {
            // 指定終了フレームより小さい終了フレームのアイテムはない（指定終了フレームがどのアイテムよりも一番左にある）、当てはまるアイテムは存在しない
            return Collections.emptyList();
        }

        return Collections.unmodifiableList(items.subList(indexFromNearest.b, indexToNearest.a));
    }

    @Override
    public List<FrameRanged<Item>> getItemInFrameRange(@Min(0) int frameFrom, @Min(0) int frameTo) {
        return getItemInFrameRange(getItemNearestIndexFrameAt(frameFrom), getItemNearestIndexFrameAt(frameTo));
    }

    @Override
    public List<FrameRanged<Item>> getItemInIndexRange(@Min(0) int indexFrom, @Min(0) int indexTo) throws IndexOutOfBoundsException {
        return Collections.unmodifiableList(items.subList(indexFrom, indexTo));
    }

    @Override
    public Pair<Integer, Integer> getItemNearestIndexFrameAt(@Min(0) int frame) {
        zeroOrPositive(frame);

        if (items.size() == 0) {
            return Pair.of(-1, -1);
        }

        int maxPos = items.size() - 1;
        // あるかないかわかっていない、捜索範囲の左
        int left = 0;
        // あるかないかわかっていない、捜索範囲の右
        int right = maxPos;

        while (true) {
            int pos = (left + right) / 2;

            FrameRanged<Item> itemFrameRanged = items.get(pos);

            if (frame < itemFrameRanged.start) {
                // アイテムの開始フレーム位置が指定フレームより大きい（アイテムが右側にある）

                // -----FRAME-[ITEM]-------------
                if (left == right) {
                    if (right == 0) {
                        // フレーム位置が一番左のアイテムよりもっと左にある
                        // -----FRAME-[ITEM]-------------
                        return Pair.of(-1, 0);
                    } else {
                        // フレーム位置がアイテム同士に挟まれている
                        // (ITEM)FRAME-[ITEM]------------
                        return Pair.of(pos - 1, pos);
                    }
                }
                right = pos - 1;
            } else if (itemFrameRanged.end < frame) {
                // アイテムの終了フレーム位置が指定フレームより小さい（アイテムが左側にある）

                // ------------[ITEM]-FRAME------
                if (left == right) {
                    if (left == maxPos) {
                        // フレーム位置が一番右のアイテムよりもっと右にある
                        // ------------[ITEM]-FRAME------
                        return Pair.of(maxPos, -1);
                    } else {
                        // フレーム位置がアイテム同士に挟まれている
                        // ------------[ITEM]-FRAME(ITEM)
                        return Pair.of(pos, pos + 1);
                    }
                }
                left = pos + 1;
            } else {
                // itemFrameRanged.start <= frame && frame <= itemFrameRanged.endと等価
                // 与えられたフレームがアイテム上にある
                // -------[IT|FRAME|EM]------
                return Pair.of(pos, pos);
            }
        }

        // 探してみたが当てはまるものはなかったので捜索内で一番当てはまったインデックス番号を返す
//        return Pair.of(left, right);


//        if (frame < 0) {
//            throw new IllegalArgumentException();
//        }
//        if (items.size() == 0) {
//            return Pair.of(-1, -1);
//        }
//
//        int left = 0;
//        int right = items.size() - 1;
//
//        int pos = right / 2;
//        int lastPos = -1;
//        FrameRanged<Item> itemFrameRanged;
//
//        do {
//            itemFrameRanged = items.get(pos);
//
//            if (itemFrameRanged.start > frame) {
//                right = pos - 1;
//                pos = left + (pos - left) / 2;
//            } else if (itemFrameRanged.end < frame) {
//                left = pos + 1;
//                pos = pos + (right - pos) / 2;
//            } else {
//                return Pair.of(pos, pos);
//            }
//            lastPos = pos;
//            // 捜索範囲がなくなったなら抜ける
//        } while (left != right);
//
//        // 捜索範囲がなくなってwhileを抜けた場合
//        if (left == right) {
//            if (right == 0) {
//                // 開始フレームが一番小さいアイテムにも当てはまらなかったので、一番近い左側のアイテムはない
//                left = -1;
//            } else if (left == items.size() - 1) {
//                // 終了フレームが一番大きいアイテムにも当てはまらなかったので、一番近い右側のアイテムはない
//                right = -1;
//            }
//        }
//
//        // 探してみたが当てはまるものはなかったので捜索内で一番当てはまったインデックス番号を返す
//        return Pair.of(left, right);
    }

    @Override
    public int getItemIndexFrameAt(@Min(0) int frame) {
        Pair<Integer, Integer> itemNearestIndexFrameAt = getItemNearestIndexFrameAt(frame);
        if (itemNearestIndexFrameAt.a == itemNearestIndexFrameAt.b) {
            return itemNearestIndexFrameAt.a;
        }
        return -1;
    }

    @Override
    public Optional<FrameRanged<Item>> getItemFrameAt(@Min(0) int frame) {
        int index = getItemIndexFrameAt(frame);
        return index == -1 ? Optional.empty() : Optional.of(items.get(index));
    }

    @Override
    public FrameRanged<Item> getItemIndexAt(@Min(0) int index) throws IndexOutOfBoundsException {
        return items.get(index);
    }

    @Override
    public int addItem(Item item, @Min(0) int frameFrom, @Min(0) int frameTo) throws IllegalArgumentException {
        nullNot(item);
        zeroOrPositive(frameFrom);
        zeroOrPositive(frameTo);
        smaller(frameFrom, frameTo);

        Pair<Integer, Integer> indexFromNearest = getItemNearestIndexFrameAt(frameFrom);
        Pair<Integer, Integer> indexToNearest = getItemNearestIndexFrameAt(frameTo);

        if (!indexFromNearest.equals(indexToNearest)) {
            throw new IllegalArgumentException();
        }

        items.add(indexFromNearest.a + 1, new FrameRanged<>(item, frameFrom, frameTo));
        return items.size() - 1;
    }

    @Override
    public int addItemDuration(Item item, @Min(0) int frameStart, @Min(0) int frameDuration) {
        return addItem(item, frameStart, frameStart + frameDuration);
    }

    @Override
    public void removeItemByIndex(@Min(0) int index) throws IndexOutOfBoundsException {
        items.remove(index);
    }

    @Override
    public ImageBlender getBlender() {
        return null;
    }

    @Override
    public void setBlender(ImageBlender blender) throws NotRegisteredInRegistryException {

    }

    @Override
    public Layer copyDeeply() {
        SpiceLayer spiceLayer = new SpiceLayer();

        for (FrameRanged<Item> item : items) {
            spiceLayer.items.add(item.copyDeeply());
        }

        return spiceLayer;
    }
}
