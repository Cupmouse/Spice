package net.spicesoftware;

import net.spicesoftware.api.Box;
import net.spicesoftware.api.layer.Layer;
import net.spicesoftware.api.layer.StaticField;
import net.spicesoftware.api.util.decoration.fill.color.RGBA32Color;
import net.spicesoftware.api.util.time.FrameTime;
import net.spicesoftware.api.util.vector.Vector2i;
import net.spicesoftware.layer.SpiceLayer;
import net.spicesoftware.layer.SpiceStaticField;

import javax.validation.constraints.Min;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static net.spicesoftware.api.util.Validate.nullNot;
import static net.spicesoftware.api.util.Validate.positive;

/**
 * @since 2015/03/21
 */
public abstract class SpiceBox implements Box {

    private int width;
    private int height;
    private FrameTime duration;
    private RGBA32Color backgroundColor;
    private StaticField staticField;
    private LinkedList<Layer> layers = new LinkedList<>();

    protected SpiceBox(SpiceBox copyFrom) throws NullPointerException {
        nullNot(copyFrom);
        width = copyFrom.width;
        height = copyFrom.height;
        staticField = copyFrom.staticField.copyDeeply();
        backgroundColor = copyFrom.backgroundColor;
        layers.addAll(copyFrom.layers.stream().map(Layer::copyDeeply).collect(Collectors.toList()));
    }

    public SpiceBox(int width, int height, FrameTime duration) throws IllegalArgumentException, NullPointerException {
        this(width, height, duration, new RGBA32Color(0, 0, 0, 0));
    }

    public SpiceBox(int width, int height, FrameTime duration, RGBA32Color backgroundColor) throws IllegalArgumentException, NullPointerException {
        positive(width, height);
        nullNot(duration, backgroundColor);
        this.width = width;
        this.height = height;
        this.duration = duration;
        this.backgroundColor = backgroundColor;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public Vector2i getSize() {
        return new Vector2i(width, height);
    }

    @Override
    public void setSize(Vector2i size) {
        setSize(size.x, size.y);
    }

    @Override
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public FrameTime getDuration() {
        return duration;
    }

    @Override
    public void setDuration(FrameTime duration) {
        this.duration = duration;
    }

    @Override
    public RGBA32Color getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public List<Layer> getLayers() {
        return Collections.unmodifiableList(layers);
    }

    @Override
    public int getNumberOfLayers() {
        return layers.size();
    }

    @Override
    public Layer getLayer(@Min(0) int index) throws IndexOutOfBoundsException {
        return layers.get(index);
    }

    @Override
    public Layer addLastNewLayer() {
        SpiceLayer layer = new SpiceLayer();
        layers.addLast(layer);
        return layer;
    }

    @Override
    public Layer addFirstNewLayer() {
        SpiceLayer layer = new SpiceLayer();
        layers.addFirst(layer);
        return layer;
    }

    @Override
    public Layer insertNewLayer(@Min(0) int index) throws IndexOutOfBoundsException {
        SpiceLayer layer = new SpiceLayer();
        layers.add(index, layer);
        return layer;
    }

    @Override
    public void removeLayer(@Min(0) int index) throws IndexOutOfBoundsException {
        layers.remove(index);
    }

    @Override
    public void removeFirstLayer() throws IllegalStateException {
        layers.removeFirst();
    }

    @Override
    public void removeLastLayer() throws IllegalStateException {
        layers.removeLast();
    }

    @Override
    public void removeAllLayer() {
        layers.clear();
    }

    @Override
    public StaticField getStaticField() {
        return staticField;
    }

    @Override
    public void resetStaticField() {
        this.staticField = new SpiceStaticField();
    }

    @Override
    public abstract SpiceBox copyDeeply();
}
