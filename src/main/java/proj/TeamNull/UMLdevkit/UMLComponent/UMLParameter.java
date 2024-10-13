package proj.TeamNull.UMLdevkit.UMLComponent;

/**
 * UMLParameter extends UMLComponent. Represents a Parameter in a Method.
 */
public class UMLParameter extends UMLComponent {


    public UMLParameter(String name) {
        super(name);
    }

    @Override
    public void add(UMLComponent component) {
        throw new UnsupportedOperationException("Cannot add components to a parameter.");
    }

    @Override
    public void remove(UMLComponent component) {
        throw new UnsupportedOperationException("Cannot remove components from a parameter.");
    }

    @Override
    public UMLComponent getChild(String name) {
        throw new UnsupportedOperationException("No child components in a parameter.");
    }
}
