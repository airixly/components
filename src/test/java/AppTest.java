import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AppTest {

    @Test
    public void testAssertArrayEquals() {
        byte[] expected = "trial".getBytes();
        byte[] actual = "trial".getBytes();
        org.junit.Assert.assertArrayEquals("failure - byte arrays not same", expected, actual);
    }

    @Test
    public void testAssertFalse() {
        org.junit.Assert.assertFalse("failure - should be false", 1==2);
    }
}