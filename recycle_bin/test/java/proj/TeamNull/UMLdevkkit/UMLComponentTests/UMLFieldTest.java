package proj.TeamNull.UMLdevkkit.UMLComponentTests;


import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import proj.TeamNull.UMLdevkit.reference.UMLComponent.UMLField;

/**
 * Test class for UMLField
 */
public class UMLFieldTest {

  private final int TIMEOUT = 1000;
  private UMLField umlField;

  // Helper method to initialize UMLField
  private void fieldCreationHelper() {
    umlField = new UMLField("size", "int");
  }

  @Test(timeout = TIMEOUT)
  public void testAdd() {
    fieldCreationHelper();
    UMLField nameField = new UMLField("name", "String");

    // Test that add operation throws an exception
    assertThrows(UnsupportedOperationException.class, () -> umlField.add(nameField));
  }

  @Test(timeout = TIMEOUT)
  public void testRemove() {
    fieldCreationHelper();
    UMLField nameField = new UMLField("name", "String");

    // Test that remove operation throws an exception
    assertThrows(UnsupportedOperationException.class, () -> umlField.remove(nameField));
  }

  //TODO: Rewrite test once getChild() is implemented in refactor. <-- Shane wuz here
//  @Test (timeout = TIMEOUT)
//  public void testGetChild() {
//    fieldCreationHelper();
//
//    // Test that getChild operation throws an exception
//    assertThrows(UnsupportedOperationException.class, () -> umlField.getChild("child"));
//  }
}