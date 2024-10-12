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

    public UMLMethod(String name) {
        super(name);
    }

    @Override
    public void add(UMLComponent component) {
        if (component instanceof UMLParameter && !parameters.contains(component)) {
            parameters.add(component);
        } else {
            throw new IllegalArgumentException("Invalid or duplicate parameter.");
        }
    }

    @Override
    public void remove(UMLComponent component) {
        parameters.remove(component);
    }

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

