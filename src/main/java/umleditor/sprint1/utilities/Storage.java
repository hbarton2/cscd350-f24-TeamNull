package umleditor.sprint1.utilities;

import java.util.HashMap;
import umleditor.sprint1.uml.UMLClass;

/**
 * Storage class contains the collection of all UML class objects the user creates The collection
 * 'umlClasses' is accessible through static methods to add, remove, check, and rename classes.
 */
public class Storage {

  // HashMap to store UML classes by their name
  private static HashMap<String, UMLClass> umlClasses = new HashMap<>();

  // Method to return all UML classes
  public static HashMap<String, UMLClass> getUMLClasses() {
    return umlClasses;
  }

  // Method to set UML classes (for loading saved progress)
  public static void setUMLClasses(HashMap<String, UMLClass> loadedClasses) {
    umlClasses = loadedClasses;  // Replace current classes with loaded classes
  }

  // Method to add a new class to storage
  public static void addClass(String className) {
    if (!umlClasses.containsKey(className)) {
      UMLClass newClass = new UMLClass(className);  // Create a new UMLClass object
      umlClasses.put(className, newClass);  // Add it to the storage
    } else {
      System.out.println("Error: Class " + className + " already exists.");
    }
  }

  // Method to remove a class from storage
  public static void removeClass(String className) {
    umlClasses.remove(className);
  }

  // Method to check if a class exists in storage
  public static boolean classExists(String className) {
    return umlClasses.containsKey(className);
  }

  // Method to rename an existing class in storage
  public static void renameClass(String oldName, String newName) {
    if (umlClasses.containsKey(oldName)) {
      UMLClass umlClass = umlClasses.remove(oldName);  // Remove the old name
      umlClasses.put(newName, umlClass);  // Add the new name with the existing class data
    } else {
      System.out.println("Error: Class " + oldName + " does not exist.");
    }
  }

  // Method to clear all UML classes
  public static void clearUMLClasses() {
    umlClasses.clear();  // Clear the map of UML classes
    System.out.println("All UML classes have been cleared.");
  }
}
