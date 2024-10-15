package proj.TeamNull.UMLdevkit.UMLComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * UMLClass extends UMLComponent. Represents class in UML Editor.
 * Will manage other components like Fields and Methods.
 */
public class UMLClass extends UMLComponent {
    private List<UMLComponent> components = new ArrayList<>();

    public UMLClass(String name, List<UMLComponent> components) {
        super(name);
        if(components != null)
            this.components.addAll(components);
    }

    @Override
    public void add(UMLComponent component) {
        if (component instanceof UMLField || component instanceof UMLMethod || component instanceof UMLRelationship) {
            if (component instanceof UMLField && components.stream().anyMatch(c -> c.getName().equals(component.getName()))) {
                throw new IllegalArgumentException("Field with name " + component.getName() + " already exists");
            }
            components.add(component);
        } else {
            throw new IllegalArgumentException("Only fields, methods, or relationships can be added to a class.");
        }
    }

    @Override
    public void remove(UMLComponent component) {
        if (component instanceof UMLField || component instanceof UMLMethod || component instanceof UMLRelationship) {
            components.remove(component);
        } else {
            throw new IllegalArgumentException("Only fields, methods, or relationships can be removed from a class.");
        }
    }

    //Still needs to check if name exists already
    public void setNewName(String newName){
        if(isValidName(newName))
            this.name = newName;
        else
            throw new IllegalArgumentException("New Name is not valid");
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

