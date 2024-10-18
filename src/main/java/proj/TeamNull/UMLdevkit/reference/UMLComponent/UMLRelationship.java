package proj.TeamNull.UMLdevkit.reference.UMLComponent;

/**
 * UMLRelationship extends UMLComponent. Represents the connection between two class objects.
 */
public class UMLRelationship extends UMLComponent {

  /* Source class in the class relationship */
  private UMLClass source;
  /* Destination class in the class relationship */
  private UMLClass destination;
  /* Stores relationship type as a string */
  private String type;

  /**
   * Relationship Constructor
   * Takes in name for relationship, source class, destination class, and relationship type.
   * @param name name to reference relationship
   * @param source source class in relationship
   * @param destination destination class in relationship
   * @param type type of relationship
   */
  public UMLRelationship(String name, UMLClass source, UMLClass destination, String type) {
    super(name);  // The relationship name could be something like "Person-Address Association"
    this.source = source;
    this.destination = destination;
    this.type = type;
  }


  /**
   * Gets relationship source
   * @return source
   */
  public UMLClass getSource() {
    return source;
  }

  /**
   * Gets relationship destination
   * @return destination
   */
  public UMLClass getDestination() {
    return destination;
  }


  /**
   * Gets type
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * Sets type
   * @param type of relationship
   */
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

  /**
   * Returns relationship as string
   * @return "Relationship: " + name + " [" + source.getName() + " -> " + destination.getName()
   *       + "] Type: " + type;
   */
  @Override
  public String toString() {
    return "Relationship: " + name + " [" + source.getName() + " -> " + destination.getName()
      + "] Type: " + type;
  }
}
