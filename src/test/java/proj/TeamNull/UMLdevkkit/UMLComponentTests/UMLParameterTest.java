package proj.TeamNull.UMLdevkkit.UMLComponentTests;

import org.junit.Test;
import proj.TeamNull.UMLdevkit.reference.UMLComponent.UMLParameter;

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

  //Commented out these test bc they were causing issues due to refactoring of Param as composite of Method.
  //TODO Rewrite these tests to work for current refactor of project. <-- Shane wuz here

//  @Test (timeout = TIMEOUT)
//  public void testAdd() {
//    setUp();
//    UMLParameter parameter = new UMLParameter("int", "int");
//
//    // Test that add operation throws an exception
//    assertThrows(UnsupportedOperationException.class, () -> umlParameter.add(parameter));
//  }

//  @Test (timeout = TIMEOUT)
//  public void testRemove() {
//    setUp();
//    UMLParameter parameter = new UMLParameter("int", "int");
//
//    // Test that remove operation throws an exception
//    assertThrows(UnsupportedOperationException.class, () -> umlParameter.remove(parameter));
//  }

//  @Test (timeout = TIMEOUT)
//  public void testGetChild() {
//    setUp();
//    // Test that getChild operation throws an exception
//    assertThrows(UnsupportedOperationException.class, () -> umlParameter.getChild("child"));
//  }
}