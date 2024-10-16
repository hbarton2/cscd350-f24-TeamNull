package proj.TeamNull.UMLdevkkit.UMLComponentTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import proj.TeamNull.UMLdevkit.UMLComponent.UMLComponentManager;



import static org.junit.jupiter.api.Assertions.*;

public class UMLComponentManagerTest {

    private final int TIMEOUT = 1000;

    private UMLComponentManager manager;


    @Before
    public void setUp() {
        manager = new UMLComponentManager();  // Initialize before each test
    }


    @Test (timeout = TIMEOUT)
    public void testAddClass(){

        manager.addClass("TestClass");

        boolean exists = manager.getClasses().stream()
                .anyMatch(umlClass -> umlClass.getName().equalsIgnoreCase("TestClass"));

        assertTrue(exists);
    }

    @Test (timeout = TIMEOUT)
    public void testAddDuplicateClass(){

        manager.addClass("TestClass");
        // add duplicate class. Should print error but not exit
        manager.addClass("TestClass");

        long count = manager.getClasses().stream()
                .filter(umlClass -> umlClass.getName().equalsIgnoreCase("TestClass"))
                .count();

        // Assert that only one instance exists
        assertEquals(1, count);
    }



    /*
  @Test (timeout = TIMEOUT)
  public void testSetNewName() {
    UMLClass umlClass = new UMLClass("OldName", null);
    umlClass.setNewName("NewName");
    assertEquals("NewName", umlClass.getName(), "The name should be updated to 'NewName'");
  }

   */

    @After
    public void tearDown() {
        manager = null;  // clean up if necessary
    }

}
