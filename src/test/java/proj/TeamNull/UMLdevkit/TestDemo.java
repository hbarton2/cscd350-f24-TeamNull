package proj.TeamNull.UMLdevkit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class TestDemo {

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
  @Timeout(5)  // Test will fail if it runs longer than 5 seconds
  public void assertEqualDemo() {
    var expected = 2.5;
    var actual = 2.5999999;
    var delta = 0.01;  // Specify a small delta for floating-point comparisons
    var message = "Actual value is not within the expected delta";
    assertEquals(expected, actual, delta, message);
  }

  @Test
  public void testNullPointerDemo() {
    String username = null;

    // Use assertThrows to catch the expected NullPointerException
    NullPointerException exception = assertThrows(NullPointerException.class, () -> {
      // Code that should throw the exception
      username.length();  // This will throw NullPointerException because username is null
    });

    // Verify the exception message (optional, depends on the scenario)
    assertEquals(null, exception.getMessage(), "Expected error message");
  }

  @Test
  @Timeout(5)
  public void test (){
    var expected = true;
    var actual = expected;
  }
}