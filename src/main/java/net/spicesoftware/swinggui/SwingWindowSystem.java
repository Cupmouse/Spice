package net.spicesoftware.swinggui;

import net.spicesoftware.api.gui.window.WindowSystem;

/**
 * @since 2015/12/22
 */
public final class SwingWindowSystem implements WindowSystem<SwingWindowSystem> {

    private SwingWindowDispatcher dispatcher;

    public SwingWindowSystem() {
        this.dispatcher = new SwingWindowDispatcher();
    }

    @Override
    public SwingWindowDispatcher getDispatcher() {
        return dispatcher;
    }
}
