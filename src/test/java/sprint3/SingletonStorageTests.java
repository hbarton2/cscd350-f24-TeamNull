package sprint3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import umleditor.controller.utilities.Functions;
import umleditor.model.utilities.Storage;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests for checking singleton instance of Storage
 */
public class SingletonStorageTests {


    private Storage storage;

    @Test
    public void testSingletonInstanceIsSame(){
        Storage instance1 = Storage.getInstance();
        Storage instance2 = Storage.getInstance();

        // Assert that both instances are the same
        assertSame(instance1, instance2, "Both instances are the same");
    }

    @Test
    public void testSingletonInstanceNotNull(){
        Storage instance = Storage.getInstance();
        assertNotNull(instance, "Instance should not be null");
    }

}
