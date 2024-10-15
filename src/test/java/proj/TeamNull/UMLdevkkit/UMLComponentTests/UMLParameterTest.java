package proj.TeamNull.UMLdevkkit.UMLComponentTests;

import org.junit.Test;
import proj.TeamNull.UMLdevkit.UMLComponent.UMLParameter;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Class for UMLParameter
 */
public class UMLParameterTest{

  private final int TIMEOUT = 1000;
  private UMLParameter umlParameter;


  public void setUp() {
    umlParameter = new UMLParameter("param", "int");
  }

  @Test (timeout = TIMEOUT)
  public void testAdd() {
    setUp();
    UMLParameter parameter = new UMLParameter("int", "int");

    // Test that add operation throws an exception
    assertThrows(UnsupportedOperationException.class, () -> umlParameter.add(parameter));
  }

  @Test (timeout = TIMEOUT)
  public void testRemove() {
    setUp();
    UMLParameter parameter = new UMLParameter("int", "int");

    // Test that remove operation throws an exception
    assertThrows(UnsupportedOperationException.class, () -> umlParameter.remove(parameter));
  }

  @Test (timeout = TIMEOUT)
  public void testGetChild() {
    setUp();
    // Test that getChild operation throws an exception
    assertThrows(UnsupportedOperationException.class, () -> umlParameter.getChild("child"));
  }
}