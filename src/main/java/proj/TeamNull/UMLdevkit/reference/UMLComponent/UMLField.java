package proj.TeamNull.UMLdevkit.reference.UMLComponent;

/**
 * UMLField extends UMLComponent. Represents a Field in a class.
 * A UMLField should not be able to exist without being in a UMLClass
 * UMLField class only has a constructor that intakes the name of the field and the field's type
 * UMLFields cannot be in the same class and have the same name
 * TODO add change field name and change field type methods
 */


public class UMLField extends UMLComponent {

  public UMLField(String name, String type) {
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

