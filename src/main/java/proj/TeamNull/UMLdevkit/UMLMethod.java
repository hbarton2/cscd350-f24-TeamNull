package proj.TeamNull.UMLdevkit;


import java.util.ArrayList;

/**
 * UML Method represents a method within a class object contains fields name and list of
 * UMLParameter objects
 */


public class UMLMethod {

  private String name;
  private ArrayList<UMLParameter> parameters;

  public UMLMethod(String name) {
    this.name = name;
    this.parameters = new ArrayList<>();
    createParameter();
  }

  /**
   * UML Parameter, private class only can be accessed by the method that it is a part of
   * <p>
   * TODO: create change name and change type functions
   */
  private class UMLParameter {

    private String name;
    private String type;

    private UMLParameter(String name, String type) {
      this.name = name;
      this.type = type;
    }

  }

  //TODO prompt for user input and create parameter object and add to parameters list
  private void createParameter() {
    UMLParameter param = new UMLParameter(name, "String");
    parameters.add(param);
    System.out.println("Added parameter " + param.name + " with type " + param.type);

  }

  public String getName() {
    return this.name;
  }
}