package net.spicesoftware.layer;

import net.spicesoftware.api.item.StaticItem;
import net.spicesoftware.api.layer.StaticField;
import net.spicesoftware.api.value.HasValues;
import net.spicesoftware.api.value.Values;

import javax.validation.constraints.Min;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @since 2015/03/21
 */
public class SpiceStaticField implements StaticField, HasValues {

    private LinkedList<StaticItem> items;

    @Override
    public List<StaticItem> getAllStaticItems() {
        return Collections.unmodifiableList(this.items);
    }

    @Override
    public int getNumberOfStaticItems() {
        return items.size();
    }

    @Override
    public StaticItem getStaticItem(@Min(0) int index) throws IndexOutOfBoundsException {
        return items.get(index);
    }

    @Override
    public void addStaticItemFirst(StaticItem staticItem) {
        items.addFirst(staticItem);
    }

    @Override
    public int addStaticItemLast(StaticItem staticItem) {
        items.addLast(staticItem);
        return items.size() - 1;
    }

    @Override
    public void insertStaticItem(StaticItem staticItem, @Min(0) int index) throws IndexOutOfBoundsException {
        items.add(index, staticItem);
    }

    @Override
    public void removeFirstStaticItem() throws NoSuchElementException {
        items.removeFirst();
    }

    @Override
    public void removeLastStaticItem() throws NoSuchElementException {
        items.removeLast();
    }

    @Override
    public void removeStaticItem(@Min(0) int index) throws IndexOutOfBoundsException {
        items.remove(index);
    }

    @Override
    public Values getValues() {
        return null;
    }

    @Override
    public SpiceStaticField copyDeeply() {
        SpiceStaticField copied = new SpiceStaticField();
        return copied;
    }

}
