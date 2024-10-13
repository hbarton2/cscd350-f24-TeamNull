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


    public UMLClass(String name) {
        super(name);
    }


    @Override
    public void add(UMLComponent component) {
        if (component instanceof UMLField || component instanceof UMLMethod) {
            components.add(component);
        } else {
            throw new IllegalArgumentException("Only fields or methods can be added to a class.");
        }
    }

    public void addRelationship(UMLRelationship relationship) {
        if (!relationships.contains(relationship)) {
            relationships.add(relationship);
        } else {
            System.out.println("Relationship already exists.");
        }
    }

    public void removeRelationship(UMLRelationship relationship) {
        relationships.remove(relationship);
    }

    public List<UMLRelationship> getRelationships() {
        return relationships;
    }


    @Override
    public void remove(UMLComponent component) {
        components.remove(component);
    }

    @Override
    public UMLComponent getChild(String name) {
        return components.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<UMLComponent> getComponents() {
        return components;
    }
}

