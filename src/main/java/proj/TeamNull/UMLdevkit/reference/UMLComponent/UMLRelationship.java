package proj.TeamNull.UMLdevkit.reference.UMLComponent;

/**
 * UMLRelationship extends UMLComponent. Represents the connection between two class objects.
 */
public class UMLRelationship extends UMLComponent {

  private UMLClass source;
  private UMLClass destination;
  private String type;  // For now, we can store the type of relationship as a string


  public UMLRelationship(String name, UMLClass source, UMLClass destination, String type) {
    super(name);  // The relationship name could be something like "Person-Address Association"
    this.source = source;
    this.destination = destination;
    this.type = type;
  }


  public UMLClass getSource() {
    return source;
  }

  public UMLClass getDestination() {
    return destination;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public void add(UMLComponent component) {
    throw new UnsupportedOperationException("Cannot add components to a relationship.");
  }

  @Override
  public void remove(UMLComponent component) {
    throw new UnsupportedOperationException("Cannot remove components from a relationship.");
  }

  @Override
  public UMLComponent getChild(String name) {
    throw new UnsupportedOperationException("No child components in a relationship.");
  }

  @Override
  public String toString() {
    return "Relationship: " + name + " [" + source.getName() + " -> " + destination.getName()
      + "] Type: " + type;
  }
}
