package proj.TeamNull.UMLdevkit.reference.UMLComponent;

/**
 * UMLParameter is a composite of Method. Represents a Parameter in a Method.
 * A UMLParameter should not be able to exist without being in a UMLMethod
 * UML Parameter only has a constructor that will create a UMLParameter object with a name and a type
 * UMLParameters cannot be in the same method and have the same name
 * TODO add change name and change type methods
 *
 */
public class UMLParameter{

  private String name;
  private String type;
  public UMLParameter(String name, String type) {
    this.name = name;
    this.type = type;
  }

/**
 * Accessor method that retrieves Param 'name'.
 * **/
  public String getName() {
    return this.name;
  }

  /**
   * Accessor method that retrieves Param 'type'.
   * **/
  public String getType(){
    return this.type;
  }

}