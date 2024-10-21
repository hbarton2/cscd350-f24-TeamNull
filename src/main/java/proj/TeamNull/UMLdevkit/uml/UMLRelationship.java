package proj.TeamNull.UMLdevkit.uml;

public class UMLRelationship {

  private UMLRelationshipType type;

  // Constructor
  public UMLRelationship(UMLRelationshipType type) {
    this.type = type;
  }

  // Getter for relationship type
  public UMLRelationshipType getType() {
    return type;
  }

  // Setter for relationship type
  public void setType(UMLRelationshipType type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return type.name();
  }
}
