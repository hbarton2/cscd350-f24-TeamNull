package UMLTests.RelationshipTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import umleditor.model.uml.UMLRelationship;
import umleditor.model.uml.UMLRelationshipType;
import umleditor.model.utilities.Storage;

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
    private static final Storage storage = Storage.getInstance();
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
        storage.addClass(mockSource, storage.createClass(mockSource));
        storage.addClass(mockDestination, storage.createClass(mockDestination));
        storage.addRelation(mockRelationship);
    }

    /**
     * Tear down the static storage and private fields after each test to assure we aren't having false positives.
     * */
    @AfterEach
    public void tearDown(){
        storage.clear();
        this.mockRelationship = new UMLRelationship();
        this.mockDestination = "";
        this.mockSource = "";
    }

    /**
     * Tests to see if all relationships are properly removed.
     * */
    @Test
    public void testRemoveAll(){
        storage.removeAllRelationship();

        assertNotNull(storage.getRelationships(), "ArrayList 'relationships' should not be 'NULL'."); //asserts that the list is not dereferenced.
        assertTrue(storage.getRelationships().isEmpty(), "ArrayList 'relationships' should be empty."); // asserts that list is actually empty.
    }

    /**
     * Tests to see if specific relationships is properly removed.
     * */
    @Test
    public void testRemoveX(){
        // Test to see if we check the src/type & dest is empty or not
        assertEquals(null, storage.removeARelation("", mockRelationship.getType(), mockRelationship.getDestination()), "The results should be 'NULL'.");
        assertEquals(null, storage.removeARelation(mockRelationship.getSource(), null, mockRelationship.getDestination()),"The results should be 'NULL'.");
        assertEquals(null, storage.removeARelation("", mockRelationship.getType(), ""), "The results should be 'NULL'.");

        // actually removing from the List
        UMLRelationship result = storage.removeARelation(mockRelationship.getSource(), mockRelationship.getType(), mockRelationship.getDestination());

        assertNotEquals(null, result, "Result should not be null for this test!"); // asserts that we actually deleted something in this test.

        /** This is because of some weird Java behaviour. 'isInstance()' only returns true if an instantiated object is the same
         * instance of a relationship, not if it's the same class Object. So we have to return an instance of UMLRelationship,
         * not the class type. I know, it's stupid.
         * */
        assertTrue(result.getClass().isInstance(new UMLRelationship()), "The result should be an instance of 'UMLRelationship."); // asserts the method returns the correct type.
        //The rest of the tests
        assertTrue(result.getSource().equals(mockSource), "The result should have the same source class name."); // asserts the source class name was returned properly.
        assertTrue(result.getType().equals(UMLRelationshipType.GENERALIZATION), "The result should have the relationship type."); // asserts the relationship type was returned properly.
        assertTrue(result.getDestination().equals(mockDestination), "The result should have the same destination class name."); // asserts the destination class name was returned properly.
        assertEquals(null, storage.removeARelation(result.getSource(), result.getType(), result.getDestination()), "Relationship tuple can not be removed again after deletion."); //asserts we aren't trying to delete non-existent data.
    }

    /**
     * Tests to see if a specific type of relationships is properly removed.
     * */
    @Test
    public void removeType(){
        assertEquals(-1, storage.removeType(null), "Return for this call should be '-1'.");
        assertEquals(0, storage.removeType(UMLRelationshipType.INHERITANCE), "Result should be '0' either error occurred or 'Inheritance' existed when it shouldn't.");
        storage.removeType(mockRelationship.getType());

        assertNotEquals(null, storage.getRelationships(), "List should not be dereferenced"); // asserts list is not dereferenced.
        assertFalse(storage.getRelationships().contains(mockRelationship.getType()), "There should be no more instances of 'type' in 'relationships'."); //asserts all instances of given type are removed.
        assertEquals(-1, storage.removeType(mockRelationship.getType()), "Method should not be able to delete same relation Type again."); // asserts we aren't deleting non-existent data.
    }

    /**
     * Tests to see if a specific class and it's relationships are properly removed.
     * */
    @Test
    public void testRemoveAllClassRelations(){
        assertEquals(-1, storage.removeAllClassRelations(""));
        assertEquals(0, storage.removeAllClassRelations("Jerry"));
        storage.removeAllClassRelations(mockSource);

        //This is here just so the loop below actually runs through the List
        storage.addRelation(new UMLRelationship("Mori", UMLRelationshipType.INHERITANCE, "Povich"));
        storage.addRelation(new UMLRelationship("Mori", UMLRelationshipType.ASSOCIATION, "Father"));

        assertNotEquals(null, storage.getRelationships(), "List should not be dereferenced."); //asserts List is not dereferenced.
        //Runs through the list and maks sure the original 'mock' was deleted.
        ArrayList<UMLRelationship> temp = storage.getRelationships();
        for (int i = 0; i < storage.getRelationships().size(); i++){
            assertFalse(temp.get(i).getSource().equals(mockSource), "There should be no tuples where the previous 'source' exists."); //asserts that there is no tuple that contains that source name.
        }

        storage.removeAllRelationship();
        assertEquals(-1, storage.removeAllClassRelations(mockSource), "There should be no remaining instances left in 'relationships'."); // asserts we can not delete non-existent data.
    }

    /**
     * Tests to see if all relationships to and from a specific class are properly removed.
     * */
    @Test
    public void testRemoveAllReferences(){
        assertEquals(-1, storage.removeAllReferences(""), "Param can not be empty!");
        assertEquals(0, storage.removeAllReferences("SteveHarvey"), "Class name should not exist in the mock List.");

        storage.addRelation(new UMLRelationship(mockSource, UMLRelationshipType.AGGREGATION, mockDestination));
        storage.addRelation(new UMLRelationship(mockDestination, UMLRelationshipType.DEPENDENCY, mockSource));
        storage.removeAllReferences(mockSource);

        assertNotEquals(null, storage.getRelationships(), "List should not be dereferenced"); //asserts List is not dereferenced.
        assertFalse(storage.getRelationships().contains(mockSource), "No existing references should remain in List"); //asserts we've actually deleted all references to a class in List.
        assertEquals(-1, storage.removeAllReferences(mockSource), "Data should not be attempted to be deleted twice."); //asserts that we aren't trying to delete non-existent data.
    }

}

