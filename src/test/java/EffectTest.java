import net.spicesoftware.api.image.blender.ImageBlender;
import net.spicesoftware.api.image.blender.property.IBPropertyOpacity;
import net.spicesoftware.api.image.rgba.CachedRGBA32Image;
import net.spicesoftware.api.image.rgba.RGBA32Image;
import net.spicesoftware.image.blender.SpiceRGBALightenImageBlender;
import net.spicesoftware.image.effect.SpiceRGBA32IEBlur;
import net.spicesoftware.image.effect.SpiceRGBA32IENegative;
import net.spicesoftware.image.rgba.SpiceCachedRGBA32Image;
import net.spicesoftware.image.rgba.SpiceEditableRGBA32Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.stream.IntStream;

/**
 * @since 2015/03/25
 */
// TODO
public class EffectTest extends JFrame {

    private static EffectTest frame;
    private static SpiceCachedRGBA32Image i1;
    private static SpiceCachedRGBA32Image i2;
    private static SpiceCachedRGBA32Image i3;
    private static RGBA32Image ir;
    private static SpiceCachedRGBA32Image i4;

    public static void main(String[] args) {
        i1 = load(new File("src/test/resource/test2a.png"));

        System.out.println(i1.width + " : " + i1.height);

//        i1 = new SpiceEditableRGBA32Image(1920, 1080, (int) 0xff00007FL);
        i2 = new SpiceCachedRGBA32Image(i1.width, i1.height, (int) (0x00ff00ffL));
        i3 = new SpiceCachedRGBA32Image(i1.width, i1.height, (int) (0x807f00ffL));
        i4 = new SpiceCachedRGBA32Image(i1.width, i1.height, (int) (0xffffffffL));

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        long starts = System.currentTimeMillis();
        ImageBlender<CachedRGBA32Image, IBPropertyOpacity> rgbaImageBlender = new SpiceRGBALightenImageBlender();
        SpiceRGBA32IEBlur effectGaussianBlur = new SpiceRGBA32IEBlur();
        effectGaussianBlur.setConstant(10);
        SpiceRGBA32IENegative effectNegative = new SpiceRGBA32IENegative();
        IntStream.range(0, 3).forEach(i -> ir = effectGaussianBlur.apply(i1));
        System.out.println(System.currentTimeMillis() - starts);

        frame = new EffectTest();
        frame.setVisible(true);
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(i1.getColorAt(e.getX(), e.getY()));
                System.out.println(i3.getColorAt(e.getX(), e.getY()));
                System.out.println(ir.getColorAt(e.getX(), e.getY()));
                System.out.println();
            }
        });
        frame.pack();
    }

    private static SpiceCachedRGBA32Image load(File file) {
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[] data1 = new int[bi.getWidth() * bi.getHeight()];
        for (int y = 0; y < bi.getHeight(); y++) {
            for (int x = 0; x < bi.getWidth(); x++) {
                int rgb = bi.getRGB(x, y);
                data1[y * bi.getWidth() + x] = rgb << 8 | rgb >>> 24;
            }
        }

        return new SpiceCachedRGBA32Image(bi.getWidth(), bi.getHeight(), data1);
    }

    private void drawPoint(Graphics graphics, int color, int x, int y) {
        graphics.setColor(new Color(color >>> 24 & 0xFF, color >>> 16 & 0xFF, color >>> 8 & 0xFF, color & 0xFF));
        graphics.drawLine(x, y, x, y);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(0, 0, getWidth(), getHeight());
        int[] data = ir.getData();
        for (int i = 0; i < data.length; i++) {
            int x = i % ir.getWidth();
            int y = i / ir.getWidth();
            drawPoint(g, data[i], x, y);
        }
//        g.drawImage(bi1, 0, 0, this);
    }
}
