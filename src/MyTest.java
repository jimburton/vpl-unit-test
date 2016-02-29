/**
 * Created by jb259 on 26/02/16.
 */
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class MyTest {

    @Test
    public void testOne() {
        assertTrue(true);
    }

    @Test
    public void testTwo() {
        fail("This went wrong");
    }
}
