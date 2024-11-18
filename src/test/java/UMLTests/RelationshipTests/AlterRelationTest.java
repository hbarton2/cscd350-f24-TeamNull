package UMLTests.RelationshipTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import umleditor.model.uml.UMLRelationship;
import umleditor.model.uml.UMLRelationshipType;
import umleditor.model.utilities.Storage;

public class AlterRelationTest {

    /**
     * Private fields that are used for mock testing.
     * */
    private static final Storage storage = Storage.getInstance();
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
        this.mockSource = "IAmSource";
        this.mockDestination = "IAmDestination";
        this.mockRelationship = new UMLRelationship(mockSource, UMLRelationshipType.GENERALIZATION, mockDestination);
        this.storage.createClass(mockSource);
        this.storage.addClass(mockSource, storage.createClass(mockSource));
        this.storage.addClass(mockDestination, storage.createClass(mockDestination));
        this.storage.addClass(mockAnotherClass, storage.createClass(mockAnotherClass));
        this.storage.addRelation(mockRelationship);
    }

    @AfterEach
    public void tearDown(){
        this.storage.clear();
        this.mockRelationship = new UMLRelationship();
        this.mockDestination = "";
        this.mockSource = "";
    }

    /**
     * Tests to see if a specific relationship tuple has been properly changed given the 'Source Class'.
     * */
    @Test
    public void testAlterBySource(){
        int result = storage.alterBySource(mockRelationship, args);
//        assertEquals(0, result); // ensures operations was successful
//        assertTrue(storage.getRelationships().get(0).getSource().equals(mockSource)); // asserts we didn't accidentally change the source class attribute.
//        assertTrue(storage.getRelationships().get(0).getType().equals(args[0]) && storage.getRelationships().get(0).getDestination().equals(args[1])
//                ,"Data was not altered correctly."); // makes sure we actually updated the List with the new type and destination.
//
//        setUp();
//        Object[] tempArr1 = {newMockType};
//        args = tempArr1;
//        result = storage.alterBySource(mockRelationship, args);
//        assertEquals(0, result); // ensures operations was successful
//        assertTrue(storage.getRelationships().get(0).getType().equals(args[0])
//                ,"Type was not altered correctly."); // makes sure we actually updated the List with the new type.
//
//        setUp();
//        Object[] tempArr2 = {mockAnotherClass};
//        args = tempArr2;
//        result = storage.alterBySource(mockRelationship, args);
//        assertEquals(0, result); // ensures operations was successful
//        assertTrue(storage.getRelationships().get(0).getDestination().equals(args[0])
//                ,"Destination was not altered correctly."); // makes sure we actually updated the List with the new destination.
    }

    /**
     * Tests to see if a specific relationship tuple has been properly changed given the 'Destination Class'.
     * */
    @Test
    public void testAlterByDestination(){
        int result = storage.alterByDestination(mockRelationship, args);
//        assertEquals(0, result); // ensures operations was successful
//        assertTrue(storage.getRelationships().get(0).getSource().equals(mockDestination)); // asserts we didn't accidentally change the source class attribute.
//        assertTrue(storage.getRelationships().get(0).getType().equals(args[0]) && storage.getRelationships().get(0).getSource().equals(args[1])
//                ,"Data was not altered correctly."); // makes sure we actually updated the List with the new type and destination.
//
//        setUp();
//        Object[] tempArr1 = {newMockType};
//        args = tempArr1;
//        result = storage.alterByDestination(mockRelationship, args);
//        assertEquals(0, result); // ensures operations was successful
//        assertTrue(storage.getRelationships().get(0).getType().equals(args[0])
//                ,"Type was not altered correctly."); // makes sure we actually updated the List with the new type.
//
//        setUp();
//        Object[] tempArr2 = {mockAnotherClass};
//        args = tempArr2;
//        result = storage.alterByDestination(mockRelationship, args);
//        assertEquals(0, result); // ensures operations was successful
//        assertTrue(storage.getRelationships().get(0).getSource().equals(args[0])
//                ,"Destination was not altered correctly."); // makes sure we actually updated the List with the new destination.
    }

}
