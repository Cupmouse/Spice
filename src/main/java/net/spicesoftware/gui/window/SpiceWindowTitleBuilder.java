package net.spicesoftware.gui.window;

import net.spicesoftware.api.gui.window.title.WindowTitle;
import net.spicesoftware.api.gui.window.title.WindowTitleElement;

import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

/**
 * @since 2016/01/24
 */
public class SpiceWindowTitleBuilder implements WindowTitle.Builder {

    // TODO SpiceWindowTitleのインスタンスが重複していないかチェックする
    private List<WindowTitleElement> elements = new ArrayList<>();

    @Override
    public SpiceWindowTitleBuilder insert(@Min(0) int index, WindowTitleElement titleElement) {
        elements.add(index, titleElement);
        return this;
    }

    @Override
    public SpiceWindowTitleBuilder append(WindowTitleElement titleElement) {
        elements.add(titleElement);
        return this;
    }

    @Override
    public SpiceWindowTitleBuilder remove(@Min(0) int index) throws IndexOutOfBoundsException {
        elements.remove(index);
        return this;
    }

    @Override
    public WindowTitle build() {
        return new SpiceWindowTitle(elements);
    }
}
