package proj.TeamNull.UMLdevkkit;

import com.google.gson.Gson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Timeout;
import proj.TeamNull.UMLdevkit.DemoOnly.Person;
import proj.TeamNull.UMLdevkit.Menu.Menu;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

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
