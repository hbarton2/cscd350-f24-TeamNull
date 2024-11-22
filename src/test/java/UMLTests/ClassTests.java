package UMLTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import umleditor.controller.utilities.Functions;
import umleditor.model.utilities.Storage;

import static org.junit.jupiter.api.Assertions.*;

public class ClassTests {

  private Storage storage;

  @BeforeEach
  public void setUp() {
    storage = Storage.getInstance();
    storage.getUMLClasses().clear();  // Reset the storage before each test
  }

  @Test
  public void testCreateClass() {
    String className = "Dog";
    Functions.createClass(className);

    // Assert that the class was created successfully
    assertTrue(storage.classExists(className), "Class should be created");
  }

  @Test
  public void testCreateClassAlreadyExistsFunctions() {
    String className = "Dog";
    Functions.createClass(className);  // First creation
    Functions.createClass(className);  // Attempt to create again

    // Assert that the class still exists and no duplicates
    assertTrue(storage.classExists(className), "Class should exist");
    assertEquals(1, storage.getUMLClasses().size(), "There should be only one instance of the class");
  }

  @Test
  public void testCreateClassAlreadyExistsStorage() {
    String className = "Dog";
    Functions.createClass(className);
    assertNull(storage.createClass(className));
  }

  @Test
  public void testRemoveClass() {
    String className = "Dog";
    Functions.createClass(className);
    Functions.removeClass(className);

    // Assert that the class was removed
    assertFalse(storage.classExists(className), "Class should be removed");
  }

  @Test
  public void testRemoveNonExistentClass() {
    String className = "Dog";
    Functions.removeClass(className);

    // Assert that removing a non-existent class doesn't cause any issues
    assertFalse(storage.classExists(className), "Class should not exist");
  }

  @Test
  public void testRenameClass() {
    String oldName = "Cat";
    String newName = "Feline";

    Functions.createClass(oldName);  // Create the original class
    Functions.renameClass(oldName, newName);

    // Assert that the class was renamed successfully
    assertFalse(storage.classExists(oldName), "Old class name should not exist");
    assertTrue(storage.classExists(newName), "New class name should exist");
  }

  @Test
  public void testRenameClassDoesNotExistStorage(){
    String oldName = "Cat";
    String newName = "Feline";

    Functions.createClass("Dog");
    storage.renameClass(oldName, newName);

    assertFalse(storage.classExists(oldName), "Old class name should not exist");
    assertTrue(storage.classExists("Dog"), "Dog class name should exist");
  }

  @Test
  public void testRenameClassAlreadyExists() {
    String oldName = "Cat";
    String newName = "Dog";

    Functions.createClass(oldName);
    Functions.createClass(newName);  // Create a class with the new name already

    // Attempt to rename to an existing class name
    Functions.renameClass(oldName, newName);

    // Assert that the original class still exists and no renaming happened
    assertTrue(storage.classExists(oldName), "Old class name should still exist");
    assertTrue(storage.classExists(newName), "New class name should exist");
  }

  @Test
  public void testRenameNonExistentClass() {
    String oldName = "Cat";
    String newName = "Feline";

    Functions.renameClass(oldName, newName);

    // Assert that nothing was renamed since the class didn't exist
    assertFalse(storage.classExists(oldName), "Old class name should not exist");
    assertFalse(storage.classExists(newName), "New class name should not exist");
  }
}
