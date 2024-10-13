package proj.TeamNull.UMLdevkit.UMLComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * UMLClass extends UMLComponent. Represents class in UML Editor.
 * Will manage other components like Fields and Methods.
 *
 */
public class UMLClass extends UMLComponent {
    private List<UMLComponent> components = new ArrayList<>();  // Fields and methods
    private List<UMLRelationship> relationships = new ArrayList<>();  // Relationships for this class

    /**
     * Class Constructor creates class object
     * @param name class name
     */
    public UMLClass(String name) {
        super(name);
    }

    /**
     * Add Component (fields or methods) to class
     * @param component to be added
     */
    @Override
    public void add(UMLComponent component) {
        if (component instanceof UMLField || component instanceof UMLMethod) {
            components.add(component);
        } else {
            throw new IllegalArgumentException("Only fields or methods can be added to a class.");
        }
    }

    /**
     * Add Relationship to class
     * @param relationship to be added
     */
    public void addRelationship(UMLRelationship relationship) {
        if (!relationships.contains(relationship)) {
            relationships.add(relationship);
        } else {
            System.out.println("Relationship already exists.");
        }
    }

    /**
     * Remove relationship from class
     * @param relationship
     */
    public void removeRelationship(UMLRelationship relationship) {
        relationships.remove(relationship);
    }

    /**
     * Retrieve relationships of class
     * @return class relationships
     */
    public List<UMLRelationship> getRelationships() {
        return relationships;
    }

    /**
     * Remove component from class
     * @param component
     */
    @Override
    public void remove(UMLComponent component) {
        components.remove(component);
    }

    /**
     * Retrieve child of class
     * @param name child name
     * @return components of class
     */
    @Override
    public UMLComponent getChild(String name) {
        return components.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * Get components of class
     * @return components
     */
    public List<UMLComponent> getComponents() {
        return components;
    }
}

