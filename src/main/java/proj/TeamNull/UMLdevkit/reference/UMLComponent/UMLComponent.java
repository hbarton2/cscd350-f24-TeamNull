package proj.TeamNull.UMLdevkit.reference.UMLComponent;

import java.lang.reflect.Type;

/**
 * UMLComponent abstract class that provides interface for components of UML Editor:
 * - UMLClasses, UMLFields, UMLMethods, UMLParameter, UMLRelationships
 */
public abstract class UMLComponent {

  /* Name of UML component */
  protected String name;

  /**
   * Constructor
   * Creates a UMLComponent Object
   * @param name name of component
   */
  public UMLComponent(String name) {
    if (name.isEmpty() || name == null){
      throw new IllegalArgumentException("Error, can not leave name as empty or null!");
    }
    this.name = name;
  }

  /**
   * Gets name
   * @return component's name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Sets component name
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  // Basic operations that subclasses can override

  /**
   * Abstact method
   * Adds a child component to this UML component
   * @param component what component will be added
   */
  public abstract void add(Object component);

  /**
   * Abstract method
   * Removes a child component from this component
   * @param component to be removed
   */
  public abstract void remove(Object component);

//  /**
//   * Gets the child component of this component
//   * @param name of component to be retrieved
//   * @return
//   */
//  public abstract UMLComponent getChild(String name);

  // Other common operations

  /**
   * Checks if name input is valid
   * Requirements:
   *    - not null
   *    - length is between 1-50
   *    - cannot be @
   *    - cannot be blank
   * @param name
   * @return
   */
  public boolean isValidName(String name) {
    // You can add logic for name validation
    if (name == null) {
      return false;
    }
    if (name.length() > 50 || name.length() <= 1) {
      return false;
    }
    if (name.charAt(0) == '@') {
      return false;
    }
    return !name.isBlank();
  } 
}
