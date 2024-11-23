package UtilTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import umleditor.controller.utilities.Functions;
import umleditor.model.uml.UMLClass;
import umleditor.model.utilities.MementoStorage;

public class MementoTests {

    private MementoStorage stacks;

    @BeforeEach
    public void setUp() {
        stacks = MementoStorage.getInstance();
        stacks.clearHistory();
    }

    @Test
    public void testMemento() {
        Assertions.assertNotNull(stacks);
    }

    @Test
    public void testClearHistory(){
        stacks.saveState(null);
        stacks.clearHistory();
        Assertions.assertFalse(stacks.canUndo());
    }
}
