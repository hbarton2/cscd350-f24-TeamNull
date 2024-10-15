package proj.TeamNull.UMLdevkkit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.jupiter.api.Timeout;
import proj.TeamNull.UMLdevkit.DemoOnly.Person;


public class DemoTest<module> {

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

  @Test
  public void testGsonSerializationAndDeserialization() {

    // Create a new Gson instance
    Gson gson = new Gson();

    // Create a sample Person object
    Person person = new Person("John Doe", 30, "New York");

    // Serialize the Person object to JSON
    String json = gson.toJson(person);
    System.out.println("Serialized JSON: " + json);

    // Deserialize the JSON back to a Person object
    Person deserializedPerson = gson.fromJson(json, Person.class);

    // Assert that the original and deserialized Person objects are equal
    assertNotNull(deserializedPerson);
    assertEquals(person.getName(), deserializedPerson.getName());
    assertEquals(person.getAge(), deserializedPerson.getAge());
    assertEquals(person.getCity(), deserializedPerson.getCity());
  }
}