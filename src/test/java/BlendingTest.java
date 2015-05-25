import net.spicesoftware.api.image.blender.RGBAImageBlender;
import net.spicesoftware.api.util.Pair;
import net.spicesoftware.image.blender.SpiceRGBALightenImageBlender;
import net.spicesoftware.image.rgba.SpiceCachedRGBAImage;
import net.spicesoftware.image.rgba.SpiceEditableRGBAImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @since 2015/03/25
 */
public class BlendingTest extends JFrame {

    private static BlendingTest frame;
    private static SpiceEditableRGBAImage i1;
    private static SpiceCachedRGBAImage i2;
    private static SpiceCachedRGBAImage i3;
    private static SpiceCachedRGBAImage ir;
    private static SpiceCachedRGBAImage i4;

    public static void main(String[] args) {
        i1 = load(new File("src/test/resource/test1a.png"));

//        i1 = new SpiceEditableRGBAImage(1920, 1080, (int) 0xff00007FL);
        i2 = new SpiceCachedRGBAImage(i1.width, i1.height, (int) (0x00ff00ffL));
        i3 = new SpiceCachedRGBAImage(i1.width, i1.height, (int) (0x807f00ffL));
        i4 = new SpiceCachedRGBAImage(i1.width, i1.height, (int) (0xffffffffL));

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        long starts = System.currentTimeMillis();
        RGBAImageBlender rgbaImageBlender = new SpiceRGBALightenImageBlender();
//        IntStream.range(0, 60).forEach(i -> ir = rgbaImageBlender.blendData(Pair.of(i1.getData(), 1000), Pair.of(i3.getData(), 1000)));
        ir = new SpiceCachedRGBAImage(i1.getWidth(), i1.getHeight(), rgbaImageBlender.blendData(Pair.of(i1.getData(), 500), Pair.of(i3.getData(), 1000)));
        System.out.println(System.currentTimeMillis() - starts);

        frame = new BlendingTest();
        frame.setVisible(true);
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) {
                    ir = new SpiceCachedRGBAImage(i1.getWidth(), i1.getHeight(), rgbaImageBlender.blendData(Pair.of(i1.getData(), e.getX()), Pair.of(i3.getData(), 1000)));
                    System.out.println("recalculated");
                } else {
                    System.out.println(i1.getColorAt(e.getX(), e.getY()));
                    System.out.println(i3.getColorAt(e.getX(), e.getY()));
                    System.out.println(ir.getColorAt(e.getX(), e.getY()));
                    System.out.println();
                }
            }
        });
        frame.pack();
    }

    private static SpiceEditableRGBAImage load(File file) {
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

        return new SpiceEditableRGBAImage(bi.getWidth(), bi.getHeight(), data1);
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
