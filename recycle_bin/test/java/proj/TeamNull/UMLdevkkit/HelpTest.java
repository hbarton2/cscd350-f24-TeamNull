package proj.TeamNull.UMLdevkkit;

import static junit.framework.TestCase.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import proj.TeamNull.UMLdevkit.reference.Menu.Help;

class HelpTest {

  private Help help;

  @BeforeEach
  public void setUp() {
    help = new Help();
  }

  @Test
  public void testGetMethodHelp() {
    assertEquals("Method help info.", Help.getHelp(Help.HelpType.METHOD));
  }

  @Test
  public void testGetInvalidHelpType() {
    assertEquals("Invalid help type.", Help.getHelp(null));
  }

  @Test
  public void testGetHelpNotEmpty() {
    for (Help.HelpType type : Help.HelpType.values()) {
      String result = help.getHelp(type);
      Assertions.assertFalse(result.isEmpty(), "Help info should not be empty for type: " + type);
    }
  }

  @Test
  public void testHelpTypeFromInt() {
    assertEquals(Help.HelpType.METHOD, Help.HelpType.fromInt(1));
    assertEquals(Help.HelpType.FIELD, Help.HelpType.fromInt(2));
    assertEquals(Help.HelpType.PARAMETER, Help.HelpType.fromInt(3));
    assertEquals(Help.HelpType.CLASS, Help.HelpType.fromInt(4));
    assertEquals(Help.HelpType.DISPLAY, Help.HelpType.fromInt(5));
    assertEquals(Help.HelpType.GENERAL, Help.HelpType.fromInt(6));
    assertNull(Help.HelpType.fromInt(7));
  }
}
