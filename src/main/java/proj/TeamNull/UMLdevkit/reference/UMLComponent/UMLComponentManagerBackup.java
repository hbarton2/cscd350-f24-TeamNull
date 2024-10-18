package proj.TeamNull.UMLdevkit.reference.UMLComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * UML Component Manager will handle creation and management of Classes
 */

public class UMLComponentManagerBackup {

  /**
   * List Containing user's classes
   */
  private List<UMLClass> classes = new ArrayList<UMLClass>();


  /**
   * Creates a class and adds it to ArrayList Requires a name. Will fail if duplicate
   *
   * @param name class to be added
   */
  public void addClass(String name) {
    // check for duplicate class, case-insensitive
    boolean exists = classes.stream()
      .anyMatch(umlClass -> umlClass.getName().equalsIgnoreCase(name));
    if (exists) {
      System.out.println("Class " + name + " already exists");
      return;     // return if class already exists
    }

    UMLClass newClass = new UMLClass(name, null);
    classes.add(newClass);
    System.out.println("Class " + name + " added");
  }

  public List<UMLClass> getClasses() {
    return classes;
  }

  public UMLClass getClassByName(String name) {
    return classes.stream()
      .filter(umlClass -> umlClass.getName().equals(name))
      .findFirst()
      .orElse(null);
  }

  //Still needs to check if name exists already
  public void setNewName(String newName) {
    //if(isValidName(newName))
    //this.name = newName;
    //else
    //  throw new IllegalArgumentException("New Name is not valid");
  }

}
