package proj.TeamNull.UMLdevkkit.UMLComponentTests;

import org.junit.Test;
import proj.TeamNull.UMLdevkit.UMLComponent.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for UMLClass creation and manipulation
 */
public class UMLClassTest {

  private final int TIMEOUT = 1000;

  private UMLClass umlClass;
  private void classCreationHelper() {
    umlClass = new UMLClass("Person", null);
  }

  @Test (timeout = TIMEOUT)
  public void testAddField() {
    classCreationHelper();
    UMLField nameField = new UMLField("name", "int");
    umlClass.add(nameField);

    UMLComponent retrievedField = umlClass.getChild("name");
    assertNotNull(retrievedField);
    assertEquals("name", retrievedField.getName(), "expected Field name is 'name");  // Verify the field name
  }

  @Test (timeout = TIMEOUT)
  public void testAddDuplicateField() {
    classCreationHelper();
    UMLField nameField1 = new UMLField("name", "String");
    UMLField nameField2 = new UMLField("name", "String");
    umlClass.add(nameField1);
    assertThrows(IllegalArgumentException.class, () -> umlClass.add(nameField2));
  }


  @Test (timeout = TIMEOUT)
  public void testAddInvalidComponent() {
    classCreationHelper();
    UMLParameter invalidComponent = new UMLParameter("x","int");

    // This should throw an exception since only fields and methods can be added
    assertThrows(IllegalArgumentException.class, () -> {
      umlClass.add(invalidComponent);
    });
  }

  @Test (timeout = TIMEOUT)
  public void testRemoveField() {
    classCreationHelper();
    UMLField nameField = new UMLField("name", "String");
    umlClass.add(nameField);
    umlClass.remove(nameField);  // Remove the field

    UMLComponent retrievedField = umlClass.getChild("name");
    assertNull(retrievedField);  // Ensure the field was removed
  }

  @Test (timeout = TIMEOUT)
  public void testAddMethod() {
    classCreationHelper();
    UMLMethod setNameMethod = new UMLMethod("setName", null);
    umlClass.add(setNameMethod);

    // Retrieve and verify the added method
    UMLComponent retrievedMethod = umlClass.getChild("setName");
    assertNotNull(retrievedMethod);
    assertEquals("setName", retrievedMethod.getName(), "expected method retrieved is 'setName");
  }

  @Test (timeout = TIMEOUT)
  public void testRemoveMethod() {
    classCreationHelper();
    UMLMethod nameMethod = new UMLMethod("name", null);
    umlClass.add(nameMethod);
    umlClass.remove(nameMethod);

    UMLComponent retrievedMethod = umlClass.getChild("name");
    assertNull(retrievedMethod);
  }

  @Test (timeout = TIMEOUT)
  public void testAddRelationship() {
    classCreationHelper();
    UMLClass addressClass = new UMLClass("Address", null);
    UMLRelationship relationship = new UMLRelationship("Person-Address", umlClass, addressClass, "Association");
    umlClass.add(relationship);
    // Verify the relationship was added
    assertEquals(1, umlClass.getComponents().size());
    assertTrue(umlClass.getComponents().contains(relationship), "expected relationship is 'Association'");
  }

  @Test (timeout = TIMEOUT)
  public void testRemoveRelationship() {
    classCreationHelper();
    UMLClass addressClass = new UMLClass("Address", null);
    UMLRelationship relationship = new UMLRelationship("Person-Address", umlClass, addressClass, "Association");
    umlClass.add(relationship);
    umlClass.remove(relationship);
    // Verify the relationship was removed
    assertFalse(umlClass.getComponents().contains(relationship));
  }

  @Test (timeout = TIMEOUT)
  public void testSetNewName() {
    UMLClass umlClass = new UMLClass("OldName", null);
    umlClass.setNewName("NewName");
    assertEquals("NewName", umlClass.getName(), "The name should be updated to 'NewName'");
  }
  @Test (timeout = TIMEOUT)
  public void testIsValidName() {
    UMLClass umlClass = new UMLClass("TestClass", null);

    // Test valid names
    assertTrue(umlClass.isValidName("ValidName"));
    assertTrue(umlClass.isValidName(" AnotherValidName "));

    // Test invalid names: null, empty, too short, too long
    assertFalse(umlClass.isValidName(null));
    assertFalse(umlClass.isValidName(""));
    assertFalse(umlClass.isValidName("  "));
    assertFalse(umlClass.isValidName("a"));
    assertFalse(umlClass.isValidName("weusedtolookupattheskyandwonderourplaceinthestarsnowwejustlookdownaandworryaboutourplaceinthedirt"));
  }


}
