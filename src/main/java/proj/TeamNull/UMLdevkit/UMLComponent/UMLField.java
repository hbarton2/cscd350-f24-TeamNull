package proj.TeamNull.UMLdevkit.UMLComponent;

/**
 * UMLField extends UMLComponent. Represents a Field in a class.
 */

public class UMLField extends UMLComponent {


    public UMLField(String name) {
        super(name);
    }


    @Override
    public void add(UMLComponent component) {
        throw new UnsupportedOperationException("Cannot add components to a field.");
    }

    @Override
    public void remove(UMLComponent component) {
        throw new UnsupportedOperationException("Cannot remove components from a field.");
    }

    @Override
    public UMLComponent getChild(String name) {
        throw new UnsupportedOperationException("No child components in a field.");
    }
}

