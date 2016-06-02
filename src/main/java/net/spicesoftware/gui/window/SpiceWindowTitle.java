package net.spicesoftware.gui.window;

import net.spicesoftware.api.gui.window.title.WindowTitle;
import net.spicesoftware.api.gui.window.title.WindowTitleElement;
import net.spicesoftware.api.util.DeepCopyable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @since 2016/01/24
 */
public class SpiceWindowTitle implements WindowTitle {

    private final List<WindowTitleElement> titleElements = new ArrayList<>();

    protected SpiceWindowTitle(List<WindowTitleElement> copyFrom) {
        titleElements.addAll(copyFrom);
    }

    private SpiceWindowTitle() {

    }

    @Override
    public String plain() {
        StringBuilder stringBuilder = new StringBuilder();
        for (WindowTitleElement titleElement : titleElements) {
            stringBuilder.append(titleElement.plain());
        }
        return stringBuilder.toString();
    }

    @Override
    public Optional<WindowTitleElement> getElement(Object label) {
        for (WindowTitleElement titleElement : titleElements) {
            Optional<Object> titleLabel = titleElement.getLabel();
            if (titleLabel.isPresent()) {
                if (titleLabel == label) {
                    return Optional.of(titleElement);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<WindowTitleElement> getElements() {
        return Collections.unmodifiableList(titleElements);
    }

    @Override
    public WindowTitle copyDeeply() {
        SpiceWindowTitle spiceWindowTitle = new SpiceWindowTitle();
        for (WindowTitleElement titleElement : titleElements) {
            if (titleElement instanceof DeepCopyable) {
                spiceWindowTitle.titleElements.add((WindowTitleElement) ((DeepCopyable) titleElement).copyDeeply());
            }
        }
        return spiceWindowTitle;
    }
}
