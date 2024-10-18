package proj.TeamNull.UMLdevkit.reference.UMLComponent;

/**
 * UMLParameter extends UMLComponent. Represents a Parameter in a Method.
 * A UMLParameter should not be able to exist without being in a UMLMethod
 * UML Parameter only has a constructor that will create a UMLParameter object with a name and a type
 * UMLParameters cannot be in the same method and have the same name
 * TODO add change name and change type methods
 *
 */
public class UMLParameter extends UMLComponent {

  public UMLParameter(String name, String type) {
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