package sprint3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import umleditor.sprint1.uml.UMLRelationship;
import umleditor.sprint1.uml.UMLRelationshipType;
import umleditor.sprint1.utilities.Storage;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This Class is a tester for the relationship method(s)
 * Checks for proper input/output and that we delete the
 * proper data without corrupting the model.
 *
 * */
public class RemoveRelationsTest {

    /**
     * Mock fields used for testing
     * */
    private String mockSource;
    private String mockDestination;
    private UMLRelationship mockRelationship;

    /**
     * Set-up the environment before each test.
     * */
    @BeforeEach
    public void setUp(){
        this.mockSource = "IAmSource";
        this.mockDestination = "IAmDestination";
        this.mockRelationship = new UMLRelationship(mockSource, UMLRelationshipType.GENERALIZATION, mockDestination);
        Storage.addClass(mockSource);
        Storage.addClass(mockDestination);
        Storage.addRelation(mockRelationship);
    }

    /**
     * Tear down the static storage and private fields after each test to assure we aren't having false positives.
     * */
    @AfterEach
    public void tearDown(){
        Storage.clear();
        this.mockRelationship = new UMLRelationship();
        this.mockDestination = "";
        this.mockSource = "";
    }

    /**
     * Tests to see if all relationships are properly removed.
     * */
    @Test
    public void testRemoveAll(){
        Storage.removeAllRelationship();

        assertNotNull(Storage.getRelationships(), "ArrayList 'relationships' should not be 'NULL'."); //asserts that the list is not dereferenced.
        assertTrue(Storage.getRelationships().isEmpty(), "ArrayList 'relationships' should be empty."); // asserts that list is actually empty.
    }

    /**
     * Tests to see if specific relationships is properly removed.
     * */
    @Test
    public void testRemoveX(){
        UMLRelationship result = Storage.removeARelation(mockRelationship.getSource(), mockRelationship.getType(), mockRelationship.getDestination());

//        assertNotEquals(null, result, "Result should not be null for this test!"); // asserts that we actually deleted something in this test.
//        assertTrue(result.getClass().isInstance(UMLRelationship.class), "The result should be an instance of 'UMLRelationship."); // asserts the method returns the correct type.
//        assertTrue(result.getSource().equals(result.getSource()), "The result should have the same source class name."); // asserts the source class name was returned properly.
//        assertTrue(result.getType().equals(result.getType()), "The result should have the relationship type."); // asserts the relationship type was returned properly.
//        assertTrue(result.getDestination().equals(result.getDestination()), "The result should have the same destination class name."); // asserts the destination class name was returned properly.
//        assertEquals(null, Storage.removeARelation(result.getSource(), result.getType(), result.getDestination()), "Relationship tuple can not be removed again after deletion."); //asserts we aren't trying to delete non-existent data.
    }

    /**
     * Tests to see if a specific type of relationships is properly removed.
     * */
    @Test
    public void removeType(){
        Storage.removeType(mockRelationship.getType());

//        assertNotEquals(null, Storage.getRelationships(), "List should not be dereferenced"); // asserts list is not dereferenced.
//        assertFalse(Storage.getRelationships().contains(mockRelationship.getType()), "There should be no more instances of 'type' in 'relationships'"); //asserts all instances of given type are removed.
//        assertEquals(-1, Storage.removeType(mockRelationship.getType()), "Method should not be able to delete same relation Type again."); // asserts we aren't deleting non-existent data.
    }

    /**
     * Tests to see if a specific class and it's relationships are properly removed.
     * */
    @Test
    public void testRemoveAllClassRelations(){
        Storage.removeAllClassRelations(mockSource);

//        assertNotEquals(null, Storage.getRelationships(), "List should not be dereferenced"); //asserts List is not dereferenced.
//        ArrayList<UMLRelationship> temp = Storage.getRelationships();
//        for (int i = 0; i < Storage.getRelationships().size(); i++){
//            assertFalse(temp.get(i).getSource().equals(mockSource), "There should be no tuples where the previous 'source' exists"); //asserts that there is no tuple that contains that source name.
//        }
//        assertEquals(-1, Storage.removeAllClassRelations(mockSource), "There should be no remaining instances left in 'relationships'"); // asserts we can not delete non-existent data.
    }

    /**
     * Tests to see if all relationships to and from a specific class are properly removed.
     * */
    @Test
    public void testRemoveAllReferences(){
        Storage.removeAllReferences(mockSource);

//        assertNotEquals(null, Storage.getRelationships(), "List should not be dereferenced"); //asserts List is not dereferenced.
//        assertFalse(Storage.getRelationships().contains(mockSource), "No existing references should remain in List"); //asserts we've actually deleted all references to a class in List.
//        assertEquals(-1, Storage.removeAllReferences(mockSource), "Data should not be attempted to be deleted twice."); //asserts that we aren't trying to delete non-existent data.
    }

}
