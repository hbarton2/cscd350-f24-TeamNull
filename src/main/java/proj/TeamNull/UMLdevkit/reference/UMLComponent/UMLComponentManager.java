package proj.TeamNull.UMLdevkit.reference.UMLComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * UML Component Manager will handle creation and management of Classes
 */

public class UMLComponentManager {

  /**
   * List Containing user's classes
   */
  private List<UMLClass> classes = new ArrayList<UMLClass>();


  /**
   * Creates a class and adds it to ArrayList
   * Requires a name. Will fail if duplicate
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

    UMLClass newClass = new UMLClass(name);//<-- Shane wuz here(Extra param decremented.)
    classes.add(newClass);
    System.out.println("Class " + name + " added");
  }

  /**
   * Gets classes list
   * @return classes
   */
  public List<UMLClass> getClasses() {
    return classes;
  }

  /**
   * Retrieves class by name from list
   * @param name of class to be retrieved
   * @return class object retrieved
   */
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

  /**
   * Removes class from classes list
   * Searches list for class
   * If not found, checks if string is null
   * If not null, prints "class not found"
   * @param classToDelete
   */
  public void removeClass(String classToDelete) {
    // Find the class to remove by name, case-insensitive
    UMLClass classToRemove = classes.stream()
      .filter(umlClass -> umlClass.getName().equalsIgnoreCase(classToDelete))
      .findFirst()
      .orElse(null);

    if (classToRemove != null) {
      classes.remove(classToRemove);
      System.out.println("Class " + classToDelete + " removed");
    } else {
      System.out.println("Class " + classToDelete + " not found");
    }
  }

  /**
   * Updates the name of a class
   * Checks classes list for name to be changed,
   * if name is null, tells user class not found and returns
   * If new name exists already, informs user and returns
   * If valid, sets the new name and informs user
   * @param oldName original name of class
   * @param newName new name of class
   */
  public void renameClass(String oldName, String newName) {
    // Find the class to rename by old name, case-insensitive
    UMLClass classToRename = classes.stream()
      .filter(umlClass -> umlClass.getName().equalsIgnoreCase(oldName))
      .findFirst()
      .orElse(null);

    if (classToRename == null) {
      System.out.println("Class " + oldName + " not found.");
      return; // Class not found, exit method
    }

    // Check if new name already exists
    boolean nameExists = classes.stream()
      .anyMatch(umlClass -> umlClass.getName().equalsIgnoreCase(newName));

    if (nameExists) {
      System.out.println("Class " + newName + " already exists.");
      return; // New name already exists, exit method
    }

    // Set the new name if valid
    classToRename.setName(newName);
    System.out.println("Class " + oldName + " renamed to " + newName);
  }

}
