package proj.TeamNull.UMLdevkit;

import org.junit.Test;


import java.util.ArrayList;
import proj.TeamNull.UMLdevkit.NOTUSED.UMLClassRelationship;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for creating/ manipulating UMLClassRelationship objects
 */
public class UMLClassRelationshipTest {

    private final int TIMEOUT = 10000;
    private ArrayList<UMLClassRelationship> relationships;


    /**
     * Test verifies that class relationship is created correctly
     */
    @Test (timeout = TIMEOUT)
    public void createClassRelationshipTest() {
        UMLClassRelationship newRelationship = new UMLClassRelationship("name", "source", "destination", "type");
        String expected = "Relationship: name [source -> destination] Type: type";
        assertEquals(expected, newRelationship.toString());
    }

    /**
     * Test verifies class relationship is added correctly
     */
    @Test (timeout = TIMEOUT)
    public void addClassRelationshipTest() {
        UMLClassRelationship newRelationship = new UMLClassRelationship("name", "source", "destination", "type");
        relationships = new ArrayList<>();
        relationships.add(newRelationship);

        assertEquals(relationships.size(), 1, "List size is 1");
        assertEquals(relationships.get(0).toString(), newRelationship.toString());
    }

    /**
     * Test verifies class relationship removal working correctly
     * name format: "Source-Destination-Type"
     */
    @Test (timeout = TIMEOUT)
    public void removeClassRelationshipTest() {
        UMLClassRelationship relationship1 = new UMLClassRelationship("source1-destination1-type", "source1", "destination1", "type");
        UMLClassRelationship relationship2 = new UMLClassRelationship("source2-destination2-type", "source2", "destination2", "type");
        relationships = new ArrayList<>();
        relationships.add(relationship1);
        relationships.add(relationship2);


        assertEquals(relationships.size(), 2, "List size is 2");
        relationships.remove(1);
        assertEquals(relationships.size(), 1, "List size is 1");
    }

}
