package proj.TeamNull.UMLdevkkit.UMLComponentTests;

import org.junit.Test;
import proj.TeamNull.UMLdevkit.UMLComponent.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for UMLClass creation and manipulation
 */
public class UMLClassTest {

  private final int TIMEOUT = 1000;

  private UMLClass umlClass;
  private void classCreationHelper() {
    umlClass = new UMLClass("Person");
  }

  @Test (timeout = TIMEOUT)
  public void testAddField() {
    classCreationHelper();
    UMLField nameField = new UMLField("name");
    umlClass.add(nameField);

    UMLComponent retrievedField = umlClass.getChild("name");
    assertNotNull(retrievedField);
    assertEquals("name", retrievedField.getName(), "expected name is 'name");  // Verify the field name
  }

  @Test (timeout = TIMEOUT)
  public void testAddDuplicateField() {
    classCreationHelper();
    UMLField nameField1 = new UMLField("name");
    UMLField nameField2 = new UMLField("name");

    umlClass.add(nameField1);
    umlClass.add(nameField2);

    assertEquals(2, umlClass.getComponents().size(), "expected size is 2");
  }

  @Test (timeout = TIMEOUT)
  public void testAddInvalidComponent() {
    classCreationHelper();
    UMLRelationship invalidComponent = new UMLRelationship("Person-Address", umlClass, new UMLClass("Address"), "Association");

    // This should throw an exception since only fields and methods can be added
    assertThrows(IllegalArgumentException.class, () -> {
      umlClass.add(invalidComponent);
    });
  }

  @Test (timeout = TIMEOUT)
  public void testRemoveField() {
    classCreationHelper();
    UMLField nameField = new UMLField("name");
    umlClass.add(nameField);
    umlClass.remove(nameField);  // Remove the field

    UMLComponent retrievedField = umlClass.getChild("name");
    assertNull(retrievedField);  // Ensure the field was removed
  }

  @Test (timeout = TIMEOUT)
  public void testAddMethod() {
    classCreationHelper();
    UMLMethod setNameMethod = new UMLMethod("setName");
    umlClass.add(setNameMethod);

    // Retrieve and verify the added method
    UMLComponent retrievedMethod = umlClass.getChild("setName");
    assertNotNull(retrievedMethod);
    assertEquals("setName", retrievedMethod.getName(), "expected method retrieved is 'setName");
  }

  @Test (timeout = TIMEOUT)
  public void testAddRelationship() {
    classCreationHelper();
    UMLClass addressClass = new UMLClass("Address");
    UMLRelationship relationship = new UMLRelationship("Person-Address", umlClass, addressClass, "Association");
    umlClass.addRelationship(relationship);

    // Verify the relationship was added
    assertEquals(1, umlClass.getRelationships().size());
    assertTrue(umlClass.getRelationships().contains(relationship), "expected relationship is 'Association'");
  }

  @Test (timeout = TIMEOUT)
  public void testRemoveRelationship() {
    classCreationHelper();
    UMLClass addressClass = new UMLClass("Address");
    UMLRelationship relationship = new UMLRelationship("Person-Address", umlClass, addressClass, "Association");

    umlClass.addRelationship(relationship);
    umlClass.removeRelationship(relationship);

    // Verify the relationship was removed
    assertFalse(umlClass.getRelationships().contains(relationship));
  }
}
