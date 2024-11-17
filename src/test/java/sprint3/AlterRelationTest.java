package sprint3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import umleditor.sprint1.uml.UMLRelationship;
import umleditor.sprint1.uml.UMLRelationshipType;
import umleditor.sprint1.utilities.Storage;

import static org.junit.jupiter.api.Assertions.*;

public class AlterRelationTest {

    /**
     * Private fields that are used for mock testing.
     * */
    private String mockSource;
    private String mockDestination;
    private UMLRelationship mockRelationship;
    private String mockAnotherClass = "IAmAnotherMockClass";
    private UMLRelationshipType newMockType = UMLRelationshipType.INHERITANCE;
    private  Object[] args = {newMockType, mockAnotherClass};

    /**
     * Sets up the environment for testing
     * */
    @BeforeEach
    public void setUp(){
        mockSource = "IAmSource";
        mockDestination = "IAmDestination";
        mockRelationship = new UMLRelationship(mockSource, UMLRelationshipType.GENERALIZATION, mockDestination);
        Storage.addClass(mockSource);
        Storage.addClass(mockDestination);
        Storage.addClass(mockAnotherClass);
        Storage.addRelation(mockRelationship);
    }

    @AfterEach
    public void tearDown(){
        Storage.clear();
        this.mockRelationship = new UMLRelationship();
        this.mockDestination = "";
        this.mockSource = "";
    }

    /**
     * Tests to see if a specific relationship tuple has been properly changed given the 'Source Class'.
     * */
    @Test
    public void testAlterBySource(){
//        int result = Storage.alterBySource(mockRelationship, args);
//        assertEquals(0, result); // ensures operations was successful
//        assertTrue(Storage.getRelationships().get(0).getSource().equals(mockSource)); // asserts we didn't accidentally change the source class attribute.
//        assertTrue(Storage.getRelationships().get(0).getType().equals(args[0]) && Storage.getRelationships().get(0).getDestination().equals(args[1])
//                ,"Data was not altered correctly."); // makes sure we actually updated the List with the new type and destination.
//
//        setUp();
//        Object[] tempArr1 = {newMockType};
//        args = tempArr1;
//        result = Storage.alterBySource(mockRelationship, args);
//        assertEquals(0, result); // ensures operations was successful
//        assertTrue(Storage.getRelationships().get(0).getType().equals(args[0])
//                ,"Type was not altered correctly."); // makes sure we actually updated the List with the new type.
//
//        setUp();
//        Object[] tempArr2 = {mockAnotherClass};
//        args = tempArr2;
//        result = Storage.alterBySource(mockRelationship, args);
//        assertEquals(0, result); // ensures operations was successful
//        assertTrue(Storage.getRelationships().get(0).getDestination().equals(args[0])
//                ,"Destination was not altered correctly."); // makes sure we actually updated the List with the new destination.
    }

    /**
     * Tests to see if a specific relationship tuple has been properly changed given the 'Destination Class'.
     * */
    @Test
    public void testAlterByDestination(){
//        int result = Storage.alterByDestination(mockRelationship, args);
//        assertEquals(0, result); // ensures operations was successful
//        assertTrue(Storage.getRelationships().get(0).getSource().equals(mockDestination)); // asserts we didn't accidentally change the source class attribute.
//        assertTrue(Storage.getRelationships().get(0).getType().equals(args[0]) && Storage.getRelationships().get(0).getSource().equals(args[1])
//                ,"Data was not altered correctly."); // makes sure we actually updated the List with the new type and destination.
//
//        setUp();
//        Object[] tempArr1 = {newMockType};
//        args = tempArr1;
//        result = Storage.alterByDestination(mockRelationship, args);
//        assertEquals(0, result); // ensures operations was successful
//        assertTrue(Storage.getRelationships().get(0).getType().equals(args[0])
//                ,"Type was not altered correctly."); // makes sure we actually updated the List with the new type.
//
//        setUp();
//        Object[] tempArr2 = {mockAnotherClass};
//        args = tempArr2;
//        result = Storage.alterByDestination(mockRelationship, args);
//        assertEquals(0, result); // ensures operations was successful
//        assertTrue(Storage.getRelationships().get(0).getSource().equals(args[0])
//                ,"Destination was not altered correctly."); // makes sure we actually updated the List with the new destination.
    }

}
