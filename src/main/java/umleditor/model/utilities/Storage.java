package umleditor.model.utilities;

import java.util.HashMap;
import umleditor.model.uml.UMLClass;

/**
 * Singleton Storage class contains the collection of all UML class objects the user creates
 * The instance is accessible through a method to add, remove, check, and rename classes
 *
 * Singleton requirements:
 *    1. private static field for storing singleton instance
 *    2. declare a public static creation method for getting singleton instance
 *    3. Implement “lazy initialization” inside the static method. It should create a new object
 *       on its first call and put it into the static field. The method should always return
 *       that instance on all subsequent calls.
 *    4. Make constructor of the class private. Static method of the class will be able to call constructor,
 *       but not other objects
 *    5. Go over program and replace all direct calls to Storage's constructor to its static creation method
 */
public class Storage {

  // single instance of the Storage. Must be declared volatile for double-check locking works correctly.
  private static volatile Storage instance;

  // HashMap to store UML classes by their name
  private static HashMap<String, UMLClass> umlClasses;

  // Private Constructor
  private Storage() {umlClasses = new HashMap<>();}


  /**
   * Public static creation method for getting singleton instance
   * Used double-checked locking (DCL) approach to prevent possible thread issues creating multiple instances
   * @return
   */
  public static Storage getInstance() {
    Storage result = instance;
    if (result != null) {   // check avoids unnecessary synchronization once instance is initialized
      return result;
    }
    synchronized (Storage.class) {  // ensures only one thread can create instance if null
      if (instance == null) {
        instance = new Storage();
      }
      return instance;
    }
  }

  // Method to return all UML classes
  public HashMap<String, UMLClass> getUMLClasses() {
    return umlClasses;
  }

  // Method to set UML classes (for loading saved progress)
  public void setUMLClasses(HashMap<String, UMLClass> loadedClasses) {
    umlClasses = loadedClasses;  // Replace current classes with loaded classes
  }

  // Method to add a new class to storage
  public void addClass(String className) {
    if (!umlClasses.containsKey(className)) {
      UMLClass newClass = new UMLClass(className);  // Create a new UMLClass object
      umlClasses.put(className, newClass);  // Add it to the storage
    } else {
      System.out.println("Error: Class " + className + " already exists.");
    }
  }

  // Method to remove a class from storage
  public void removeClass(String className) {
    umlClasses.remove(className);
  }

  // Method to check if a class exists in storage
  public boolean classExists(String className) {
    return umlClasses.containsKey(className);
  }

  // Method to rename an existing class in storage
  public void renameClass(String oldName, String newName) {
    if (umlClasses.containsKey(oldName)) {
      UMLClass umlClass = umlClasses.remove(oldName);  // Remove the old name
      umlClasses.put(newName, umlClass);  // Add the new name with the existing class data
    } else {
      System.out.println("Error: Class " + oldName + " does not exist.");
    }
  }

  // Method to clear all UML classes
  public void clearUMLClasses() {
    umlClasses.clear();  // Clear the map of UML classes
    System.out.println("All UML classes have been cleared.");
  }

  // Method to get a UMLClass by its name
  public UMLClass getClass(String className) {
    return umlClasses.get(className);
  }
}
