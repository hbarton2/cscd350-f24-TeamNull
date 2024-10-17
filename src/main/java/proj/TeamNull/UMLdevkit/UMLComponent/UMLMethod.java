package proj.TeamNull.UMLdevkit.UMLComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * UMLMethod extends UMLComponent. Represents a Method in a class.
 * <p>
 * Method currently intended to create an instance of a method and add to it using
 * parameter objects
 * private list parameters holds all parameter objects that are within this method
 * Constructor call required the name of the method and a list of all parameters that will be inside of it
 * add and remove methods are to add or remove an already created parameter object to the parameter list
 * <p>
 * Methods can be in the same class and have the same name but must not have the same parameters
 * <p>
 *TODO as of right now we have no way of creating a parameter object within this class,
 * add a method that will create them using user input then call add() function
 */
public class UMLMethod extends UMLComponent {

  private List<UMLComponent> parameters = new ArrayList<>(); // Method can have parameters

  public UMLMethod(String name, List<UMLComponent> parameters) {
    super(name);
  }

  @Override
  public void add(UMLComponent component) {
    if (component instanceof UMLParameter && !parameters.contains(component)) {
      parameters.add(component);
    } else {
      throw new IllegalArgumentException("Invalid or duplicate parameter.");
    }
  }


  @Override
  public void remove(UMLComponent component) {
    parameters.remove(component);
  }


  @Override
  public UMLComponent getChild(String name) {
    return parameters.stream()
      .filter(param -> param.getName().equals(name))
      .findFirst()
      .orElse(null);
  }


  // Additional UMLMethod-specific methods
  public List<UMLComponent> getParameters() {
    return parameters;
  }
}

