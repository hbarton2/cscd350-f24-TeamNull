package proj.TeamNull.UMLdevkkit.UMLComponentTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import proj.TeamNull.UMLdevkit.reference.UMLComponent.UMLClass;
import proj.TeamNull.UMLdevkit.reference.UMLComponent.UMLRelationship;

/**
 * Tests for UMLRelationship
 */
public class UMLRelationshipTest {

  private final int TIMEOUT = 1000;

  private UMLRelationship umlRelationship;

  // Helper method to create UMLRelationship object(More than likely needs rewriting due to refactor)
  private void relationshipCreationHelper() {
    UMLClass sourceClass = new UMLClass("Person"); //<-- Shane wuz here
    UMLClass destinationClass = new UMLClass("Address");//<-- Shane wuz here
    umlRelationship = new UMLRelationship("Person-Address Association", sourceClass,
      destinationClass, "Association");
  }

  @Test(timeout = TIMEOUT)
  public void testConstructorAndGetters() {
    relationshipCreationHelper();

    // Verify that the source, destination, and type are correctly initialized
    assertEquals("Person", umlRelationship.getSource().getName());
    assertEquals("Address", umlRelationship.getDestination().getName());
    assertEquals("Association", umlRelationship.getType());
  }

  @Test(timeout = TIMEOUT)
  public void testSetType() {
    relationshipCreationHelper();

    // Set a new relationship type
    umlRelationship.setType("Inheritance");

    // Verify that the relationship type was updated
    assertEquals("Inheritance", umlRelationship.getType());
  }

  @Test(timeout = TIMEOUT)
  public void testToString() {
    relationshipCreationHelper();

    // Verify the string representation of the relationship
    String expected = "Relationship: Person-Address Association [Person -> Address] Type: Association";
    assertEquals(expected, umlRelationship.toString());
  }

  @Test(timeout = TIMEOUT)
  public void testUnsupportedAdd() {
    relationshipCreationHelper();

    // Test that add(UMLComponent) is unsupported
    assertThrows(UnsupportedOperationException.class,
      () -> umlRelationship.add(new UMLClass("NewClass")));//<-- Shane wuz here
  }

  @Test(timeout = TIMEOUT)
  public void testUnsupportedRemove() {
    relationshipCreationHelper();

    // Test that remove(UMLComponent) is unsupported
    assertThrows(UnsupportedOperationException.class,
      () -> umlRelationship.remove(new UMLClass("NewClass")));//<-- Shane wuz here
  }

  //TODO rewrite test once getChild is implemented. <-- Shane wuz here
//  @Test (timeout = TIMEOUT)
//  public void testGetChild() {
//    relationshipCreationHelper();
//
//    // Test that getChild is unsupported
//    assertThrows(UnsupportedOperationException.class, () -> umlRelationship.getChild("child"));
//  }
}
