package proj.TeamNull.UMLdevkkit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
}
