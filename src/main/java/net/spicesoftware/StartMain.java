package net.spicesoftware;

import net.spicesoftware.api.SpiceStatic;
import net.spicesoftware.api.decoration.fill.ImagePatternFilling;
import net.spicesoftware.api.decoration.fill.gradient.rgb24.RGB24GradientFillingLinear;
import net.spicesoftware.api.decoration.fill.gradient.rgb24.RGB24GradientFillingRadial;
import net.spicesoftware.api.gui.MainWindow;
import net.spicesoftware.api.gui.window.WindowStateImmutable;
import net.spicesoftware.api.gui.window.title.WindowTitle;
import net.spicesoftware.api.image.gs.EditableGrayScale8Image;
import net.spicesoftware.api.image.rgb.EditableCSRGB24Image;
import net.spicesoftware.api.image.rgb.EditableRGB24Image;
import net.spicesoftware.api.image.rgba.EditableCSRGBA32Image;
import net.spicesoftware.api.image.rgba.EditableRGBA32Image;
import net.spicesoftware.api.layer.Layer;
import net.spicesoftware.api.project.TimelineRoot;
import net.spicesoftware.api.style.StrokeStyle;
import net.spicesoftware.api.style.TextStyle;
import net.spicesoftware.api.util.time.FrameTime;
import net.spicesoftware.decoration.fill.SpiceImagePatternFillingBuilder;
import net.spicesoftware.decoration.fill.gradient.rgb24.SpiceRGB24GradientFillingLinearBuilder;
import net.spicesoftware.decoration.fill.gradient.rgb24.SpiceRGB24GradientFillingRadialBuilder;
import net.spicesoftware.gui.SpiceMainWindow;
import net.spicesoftware.gui.SpiceStartSplash;
import net.spicesoftware.gui.window.SpiceWindowStateImmutable;
import net.spicesoftware.gui.window.SpiceWindowStateImmutableBuilder;
import net.spicesoftware.gui.window.SpiceWindowTitleBuilder;
import net.spicesoftware.image.gs.SpiceEditableGrayScale8Image;
import net.spicesoftware.item.SpiceItemShape;
import net.spicesoftware.project.SpiceProject;
import net.spicesoftware.registry.SpiceRegistry;
import net.spicesoftware.style.SpiceStrokeStyleBuilder;
import net.spicesoftware.style.SpiceTextStyleBuilder;
import net.spicesoftware.swinggui.SwingWindowDispatcher;
import net.spicesoftware.swinggui.SwingWindowSystem;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Field;

import static net.spicesoftware.api.gui.window.WindowStateImmutable.state;

/**
 * @since 2015/09/15
 */
public final class StartMain {

    public static void main(String[] args) {
        try {
            SpiceStartSplash spiceStartSplash = new SpiceStartSplash();
            EventQueue.invokeLater(() -> spiceStartSplash.setVisible(true));

            SpiceSession spiceSession = new SpiceSession();
            Field spiceField = SpiceStatic.class.getDeclaredField("spice");
            spiceField.setAccessible(true);
            spiceField.set(null, spiceSession);
            spiceField.setAccessible(false);

            SpiceRegistry registry = spiceSession.getRegistry();

            registry.registerBuilder(RGB24GradientFillingLinear.Builder.class, SpiceRGB24GradientFillingLinearBuilder::new);
            registry.registerBuilder(RGB24GradientFillingRadial.Builder.class, SpiceRGB24GradientFillingRadialBuilder::new);
            registry.registerBuilder(ImagePatternFilling.Builder.class, SpiceImagePatternFillingBuilder::new);
            registry.registerBuilder(WindowTitle.Builder.class, SpiceWindowTitleBuilder::new);
            // TODO
//            registry.registerBuilder(IBPropertyDither.Builder.class, SpiceIBPropertyDither.Builder::new);
//            registry.registerBuilder(IBPropertyOpacity.Builder.class, SpiceIBPropertyDither.Builder::new);
            registry.registerBuilder(StrokeStyle.Builder.class, SpiceStrokeStyleBuilder::new);
            registry.registerBuilder(TextStyle.Builder.class, SpiceTextStyleBuilder::new);

            registry.registerBuilder(WindowStateImmutable.Builder.class, SpiceWindowStateImmutableBuilder::new);



            SpiceProject project = new SpiceProject();

            TimelineRoot newTimeline = project.createAndSetNewTimeline(500, 500, FrameTime.of(500, 60f));

            Layer layer = newTimeline.addLastNewLayer();
            layer.addItemDuration(new SpiceItemShape(), 0, 100);
            layer.addItemDuration(new SpiceItemShape(), 150, 170);

            spiceSession.openProject(project);


            SwingWindowSystem windowSystem = new SwingWindowSystem();
            registry.registerWindowSystem(SwingWindowSystem.class, windowSystem);

            SwingWindowDispatcher dispatcher = windowSystem.getDispatcher();
            dispatcher.registerWindowSupplier(MainWindow.class, () -> new SpiceMainWindow(spiceSession), state().visibility(true).build());

            SpiceMainWindow spiceMainWindow = new SpiceMainWindow(spiceSession);
            dispatcher.dispense(spiceMainWindow);

            EventQueue.invokeLater(spiceStartSplash::dispose);
        } catch (IOException e) {
            e.printStackTrace();

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
