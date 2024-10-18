package proj.TeamNull.UMLdevkkit;

import org.junit.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {

    @Test
    @Timeout(1)
    public void timeOutDemo() {
        int[] numbers = new int[200]; // reduced size for "toaster" machines
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 10) {
                numbers[i] = 0;
            }
        }
    }



    @Test
    public void testPrintNullString() {
        String name = null;

        assertNull(name);
    }

    @Test
    @Timeout(5)
    public void test() {
        var expected = true;
        var actual = expected;
    }


}
