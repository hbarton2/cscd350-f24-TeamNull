package proj.TeamNull.UMLdevkit.UMLComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * UMLMethod extends UMLComponent. Represents a Method in a class.
 * It can have Parameters managed as child components.
 *
 */
public class UMLMethod extends UMLComponent {
    private List<UMLComponent> parameters = new ArrayList<>(); // Method can have parameters

    /**
     * Method Constructor
     * @param name  name of method
     */
    public UMLMethod(String name) {
        super(name);
    }

    /**
     * Add component to method (only parameters)
     * @param component parameter to be added
     */
    @Override
    public void add(UMLComponent component) {
        if (component instanceof UMLParameter && !parameters.contains(component)) {
            parameters.add(component);
        } else {
            throw new IllegalArgumentException("Invalid or duplicate parameter.");
        }
    }

    /**
     * Remove component from method
     * @param component parameter to be removed
     */
    @Override
    public void remove(UMLComponent component) {
        parameters.remove(component);
    }

    /**
     * Gets child (parameter) from method
     * @param name of child to be retrieved
     * @return parameters
     */
    @Override
    public UMLComponent getChild(String name) {
        return parameters.stream()
                .filter(param -> param.getName().equals(name))
                .findFirst()
                .orElse(null);
    }


    // Additional UMLMethod-specific methods
    public List<UMLComponent> getParameters() {
        return parameters;
    }
}

