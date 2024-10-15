package proj.TeamNull.UMLdevkkit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import proj.TeamNull.UMLdevkit.Menu.Help;

public class HelpTest {
    private Help help;

    @Before
    public void setUp() {
        help = new Help();
    }

    @Test
    public void testGetMethodHelp() {
        assertEquals("Method help info.", help.getHelp(Help.HelpType.METHOD));
    }

    @Test
    public void testGetInvalidHelpType() {
        assertEquals("Invalid help type.", help.getHelp(null));
    }

    @Test
    public void testGetHelpNotEmpty() {
        for (Help.HelpType type : Help.HelpType.values()) {
            String result = help.getHelp(type);
            assertFalse("Help info should not be empty for type: " + type, result.isEmpty());
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
