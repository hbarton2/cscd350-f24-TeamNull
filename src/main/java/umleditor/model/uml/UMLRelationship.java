package umleditor.model.uml;

public class UMLRelationship {

  private String source;
  private UMLRelationshipType type;
  private String destination;

  // Constructor
  public  UMLRelationship(){}
  public UMLRelationship(UMLRelationshipType type) {
    this.type = type;
  }
  public UMLRelationship(UMLRelationshipType type, String destination){
    this.type = type;
    this.destination = destination;
  }

  public UMLRelationship(String source, UMLRelationshipType type, String destination){
    this.source = source;
    this.type = type;
    this.destination = destination;
  }

  //copy constructor
  public UMLRelationship(UMLRelationship other){
    this.source = other.source;
    this.type = other.type;
    this.destination = other.destination;
  }

  // Getter for relationship type
  public UMLRelationshipType getType() {
    return type;
  }

  // Setter for relationship type
  public void setType(UMLRelationshipType type) {
    this.type = type;
  }

  /**
   * Returns the name of the destination class.
   * */
  public String getDestination() {
    return this.destination;
  }

  /**
   * Changes the name of the destination class.
   * @param destination The new destination Class name.
   * */
  public void setDestination(String destination) {
    this.destination = destination;
  }

  /**
   * Gets the name of the source class.
   * */
  public String getSource() {
    return this.source;
  }

  /**
   * Changes the name of the source class.
   * @param source The new source Class name.
   * */
  public void setSource(String source) {
    this.source = source;
  }

  /**
   * Prints-out the source, type, and destination class.
   * */
  @Override
  public String toString() {
    return "Class: " +  this.source + " \r\n" +  this.type.name() + " --> " +  this.destination;
  }
}
