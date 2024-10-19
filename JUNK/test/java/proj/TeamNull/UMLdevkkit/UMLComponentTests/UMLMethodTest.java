package proj.TeamNull.UMLdevkkit.UMLComponentTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.Test;
import proj.TeamNull.UMLdevkit.reference.UMLComponent.UMLMethod;
import proj.TeamNull.UMLdevkit.reference.UMLComponent.UMLParameter;

/**
 * Test class for UMLMethod
 */
public class UMLMethodTest<module> {

  private final int TIMEOUT = 1000;

  private UMLMethod umlMethod;

  // Helper method to create UMLMethod object
  private void methodCreationHelper() {
    umlMethod = new UMLMethod("calculate", null);
  }

  @Test(timeout = TIMEOUT)
  public void testAddParameter() {
    methodCreationHelper();

    UMLParameter param1 = new UMLParameter("x", "int");
    UMLParameter param2 = new UMLParameter("y", "int");

    // Add parameters to the method
    umlMethod.add(param1);
    umlMethod.add(param2);

    // Get the list of parameters and verify
    List<UMLParameter> parameters = umlMethod.getParameters();
    assertEquals(2, parameters.size());
    assertEquals("x", parameters.get(0).getName());
    assertEquals("y", parameters.get(1).getName());
  }

  @Test(timeout = TIMEOUT)
  public void testAddDuplicateParameter() {
    methodCreationHelper();

    UMLParameter param1 = new UMLParameter("x", "int");

    // Add parameter once
    umlMethod.add(param1);

    // Try to add the same parameter again and expect an IllegalArgumentException
    Exception exception = assertThrows(IllegalArgumentException.class, () -> umlMethod.add(param1));
    assertEquals("Invalid or duplicate parameter.", exception.getMessage());
  }

  @Test(timeout = TIMEOUT)
  public void testRemoveParameter() {
    methodCreationHelper();

    UMLParameter param1 = new UMLParameter("x", "int");
    UMLParameter param2 = new UMLParameter("y", "int");

    // Add parameters to the method
    umlMethod.add(param1);
    umlMethod.add(param2);

    // Remove a parameter
    umlMethod.remove(param1);

    // Verify that the parameter was removed
    List<UMLParameter> parameters = umlMethod.getParameters(); // <-- Changed this because Param is now a composite of Method
    assertEquals(1, parameters.size());
    assertEquals("y", parameters.get(0).getName());
  }
//TODO Rewrite these tests to work with current refactor.

//  @Test (timeout = TIMEOUT)
//  public void testGetChild() {
//    methodCreationHelper();
//
//    UMLParameter param1 = new UMLParameter("x", "int");
//
//    // Add a parameter
//    umlMethod.add(param1);
//
//    // Retrieve the parameter by name
//    UMLComponent retrievedParam = umlMethod.getChild("x");
//
//    assertNotNull(retrievedParam);
//    assertEquals("x", retrievedParam.getName());
//  }

//  @Test (timeout = TIMEOUT)
//  public void testGetChildNonExistent() {
//    methodCreationHelper();
//
//    // Try to get a parameter that doesn't exist
//    UMLComponent retrievedParam = umlMethod.getChild("nonExistentParam");
//
//    assertNull(retrievedParam);
//  }

}