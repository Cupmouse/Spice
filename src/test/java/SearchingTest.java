import net.spicesoftware.item.SpiceItemShape;
import net.spicesoftware.item.SpiceItemVideo;
import net.spicesoftware.layer.SpiceLayer;

/**
 * @since 2015/06/20
 */
public class SearchingTest {

    public static void main(String[] args) {
        SpiceLayer spiceLayer = new SpiceLayer();
        spiceLayer.addItem(new SpiceItemShape(), 900, 5100);
        spiceLayer.addItem(new SpiceItemShape(), 20, 50);
        spiceLayer.addItem(new SpiceItemShape(), 70, 80);
        spiceLayer.addItem(new SpiceItemShape(), 120, 150);
        spiceLayer.addItem(new SpiceItemShape(), 170, 300);
        spiceLayer.addItem(new SpiceItemShape(), 500, 600);
        System.out.println(spiceLayer.getItemIndexFrameAt(75));
    }
}
