import net.spicesoftware.api.value.Interpolator;
import net.spicesoftware.registry.SpiceRegistry;

import javax.validation.constraints.Min;

/**
 * @since 2015/06/11
 */
public class RegistryTest {

    public static void main(String[] args) {
        SpiceRegistry spiceRegistry = new SpiceRegistry();

        spiceRegistry.registerInterpolator("test", new Interpolator<Object>() {
            @Override
            public Object calculate(@Min(0) int frameDuration, Object valueStart, Object valueEnd, @Min(0) int frameAt) throws IllegalArgumentException {
                return null;
            }

            @Override
            public Object calculate(@Min(0) int frameStart, @Min(0) int frameEnd, Object valueStart, Object valueEnd, @Min(0) int frameAt) throws IllegalArgumentException {
                return null;
            }
        });
    }
}
