package net.spicesoftware.layer;

import net.spicesoftware.api.image.blender.ImageBlender;
import net.spicesoftware.api.item.Item;
import net.spicesoftware.api.layer.Layer;
import net.spicesoftware.api.util.NotRegisteredInRegistryException;
import net.spicesoftware.api.util.time.FrameRanged;

import javax.validation.constraints.Min;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @since 2015/03/21
 */
public class SpiceLayer implements Layer {

    private List<FrameRanged<Item>> items;

    @Override
    public List<FrameRanged<Item>> getAllItems() {
        return Collections.unmodifiableList(this.items);
    }

    @Override
    public int getNumberOfItems() {
        return items.size();
    }

    @Override
    public List<FrameRanged<Item>> getItemInFrameRange(@Min(0) int frameFrom, @Min(0) int frameTo) {
        return null;
    }

    @Override
    public List<FrameRanged<Item>> getItemInIndexRange(@Min(0) int indexFrom, @Min(0) int indexTo) throws IndexOutOfBoundsException {
        return Collections.unmodifiableList(items.subList(indexFrom, indexTo));
    }

    @Override
    public int getItemIndexFrameAt(@Min(0) int frame) {
        return 0;
    }

    @Override
    public Optional<FrameRanged<Item>> getItemFrameAt(@Min(0) int frame) {
        return null;
    }

    @Override
    public FrameRanged<Item> getItemIndexAt(@Min(0) int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public int addItem(Item item, @Min(0) int frameFrom, @Min(0) int frameTo) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public int addItemDuration(Item item, @Min(0) int frameStart, @Min(0) int frameDuration) {
        return 0;
    }

    @Override
    public void removeItemByIndex(@Min(0) int index) throws IndexOutOfBoundsException {

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
        return null;
    }
}
