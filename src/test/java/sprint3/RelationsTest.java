package sprint3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import umleditor.model.uml.UMLClass;
import umleditor.model.uml.UMLRelationshipType;
import umleditor.controller.utilities.Functions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This Class is a tester for the relationship method(s)
 * Checks for proper input/output and that we can not add any
 * invalid types to be passed or processed.
 * Also checks for deletion of tests.
 *
 * */
public class RelationsTest {

    //The mock class we are testing
    private UMLClass mock;

    /**
     * A simple set-up method before we run each test.
     * */
    @BeforeEach
    public void setUp() {
        mock = new UMLClass("I am Mock!");
    }

    /**
     * Ensures when we add a relation type that it actually exists and is not null
     * */
    @Test
    public void testAddRelationNotEmpty(){
        mock.addOrUpdateRelationship(UMLRelationshipType.INHERITANCE);


        assertFalse(mock.getRelationships().isEmpty(), "ArrayList is empty!"); //makes sure the ArrayList is not empty.
        assertFalse(mock.getRelationships().get(0).equals(null), "Param added is NULL!"); // makes sure we didn't add 'null' to the arrayList.
        assertTrue(mock.getRelationships().size() == 1, "Size is not properly updated!"); //ensures the size is properly incremented.

    }

    /**
     * Ensures we add an 'Inheritance' type
     * */
    @Test
    public void testAddInheritance(){
        mock.addOrUpdateRelationship(UMLRelationshipType.INHERITANCE);

        //deprecated printout tests
//        System.out.println(mock.getRelationships().get(0).getType().hashCode());
//        System.out.println(UMLRelationshipType.INHERITANCE.hashCode());

        // Checks for Type == INHERITANCE
        assertEquals(mock.getRelationships().get(0).getType(), UMLRelationshipType.INHERITANCE, "UMLRelationshipType miss-match: for --> Inheritance");
    }

    /**
     * Ensures we add an 'Association' type
     * */
    @Test
    public void testAddAssociation(){
        mock.addOrUpdateRelationship(UMLRelationshipType.ASSOCIATION);

        //Checks for Type == ASSOCIATION
        assertEquals(mock.getRelationships().get(0).getType(), UMLRelationshipType.ASSOCIATION, "UMLRelationshipType miss-match: for --> Association");
    }

    /**
     * Ensures we add an 'Aggregation' type
     * */
    @Test
    public void testAddAggregate(){
        mock.addOrUpdateRelationship(UMLRelationshipType.AGGREGATION);

        //Checks for Type == AGGREGATION
        assertEquals(mock.getRelationships().get(0).getType(), UMLRelationshipType.AGGREGATION, "UMLRelationshipType miss-match: for --> Aggregation");
    }

    /**
     * Ensures we add an 'Composition' type
     * */
    @Test
    public void testAddComposite(){
        mock.addOrUpdateRelationship(UMLRelationshipType.COMPOSITION);

        //Checks for Type == COMPOSITION
        assertEquals(mock.getRelationships().get(0).getType(), UMLRelationshipType.COMPOSITION, "UMLRelationshipType miss-match: for --> Composition");
    }

    /**
     * Ensures we add an 'Generalization' type
     * */
    @Test
    public void testAddGeneral(){
        mock.addOrUpdateRelationship(UMLRelationshipType.GENERALIZATION);

        //Checks for Type == GENERALIZATION
        assertEquals(mock.getRelationships().get(0).getType(), UMLRelationshipType.GENERALIZATION, "UMLRelationshipType miss-match: for --> Generalization");
    }

    /**
     * Ensures we add an 'Realization' type
     * */
    @Test
    public void testAddRealized(){
        mock.addOrUpdateRelationship(UMLRelationshipType.REALIZATION);

        //Checks for Type == REALIZATION
        assertEquals(mock.getRelationships().get(0).getType(), UMLRelationshipType.REALIZATION, "UMLRelationshipType miss-match: for --> Realization");
    }

    /**
     * Ensures we add an 'Dependency' type
     * */
    @Test
    public void testAddDependant(){
        mock.addOrUpdateRelationship(UMLRelationshipType.DEPENDENCY);

        //Checks for Type == DEPENDENCY
        assertEquals(mock.getRelationships().get(0).getType(), UMLRelationshipType.DEPENDENCY, "UMLRelationshipType miss-match: for --> Dependency");
    }

    /**
     * Can not add relationship with only 1 existing class
     *  ###This test is SUPPOSED to fail
     * */
    @Test
    public void noAddWithOneClass(){
        Functions.createClass("IAmAMock");
        assertEquals(Functions.addRelationship("IAmMock", 1, "DestClass"), 0, "Unexpected return value"); //set to zero to induce fail state

    }

    /**
     * Class cannot have a relationship with itself no matter how lonely it is
     */
    @Test
    public void relationshipWithMyself(){
        Functions.createClass("NewMock");
        Functions.createClass("AnotherMock");   //another mock because you need at least two classes to make a relation
        assertEquals(Functions.addRelationship("NewMock", 1, "NewMock"), 1, "Unexpected return value");
    }

    /**
     * A class can not have duplicate relations
     * */
    @Test
    public void DuplicateRelation(){
        Functions.createClass("NewMock");
        Functions.createClass("AnotherMock");
        Functions.addRelationship("NewMock", 1, "AnotherMock");
        assertEquals(Functions.addRelationship("NewMock", 1, "AnotherMock"), 0, "Unexpected return value"); // <-- supposed to fail(for now)
    }
}
