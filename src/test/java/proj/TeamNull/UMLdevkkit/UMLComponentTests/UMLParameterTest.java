package proj.TeamNull.UMLdevkkit.UMLComponentTests;

import org.junit.Test;
import proj.TeamNull.UMLdevkit.UMLComponent.UMLParameter;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Class for UMLParameter
 * @param <module>
 */
public class UMLParameterTest<module> {

  private final int TIMEOUT = 1000;
  private UMLParameter umlParameter;

  @Test (timeout = TIMEOUT)
  public void testAdd() {

    UMLParameter parameter = new UMLParameter("int");

    // Test that add operation throws an exception
    assertThrows(UnsupportedOperationException.class, () -> umlParameter.add(parameter));
  }

  @Test (timeout = TIMEOUT)
  public void testRemove() {

    UMLParameter parameter = new UMLParameter("int");

    // Test that remove operation throws an exception
    assertThrows(UnsupportedOperationException.class, () -> umlParameter.remove(parameter));
  }

  @Test (timeout = TIMEOUT)
  public void testGetChild() {

    // Test that getChild operation throws an exception
    assertThrows(UnsupportedOperationException.class, () -> umlParameter.getChild("child"));
  }
}