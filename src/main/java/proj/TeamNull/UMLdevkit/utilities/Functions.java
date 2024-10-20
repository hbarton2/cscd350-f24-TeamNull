package proj.TeamNull.UMLdevkit.utilities;

import java.util.ArrayList;
import proj.TeamNull.UMLdevkit.uml.UMLClass;

/**
 * This is where all the methods are called from
 * TODO: PLACE YOUR METHODS HERE :)
 * TODO: extends maybe refracted
 */
public class Functions {

  public static void createClass(String className) {
    if (!Storage.classExists(className)) {
      UMLClass newClass = new UMLClass(className);
      newClass.setAttributes(new ArrayList<>());  // Initialize empty attributes
      newClass.setMethods(new ArrayList<>());     // Initialize empty methods
      newClass.setRelationships(new ArrayList<>());  // Initialize empty relationships
      Storage.addClass(className, newClass);
      System.out.println("Class [" + className
        + "] created with default empty attributes, methods, and relationships.");
    } else {
      System.out.println("Class [" + className + "] already exists.");
    }
  }

  public static void removeClass(String className) {
    if (Storage.classExists(className)) {
      Storage.removeClass(className);  // Remove the class from the storage
      System.out.println("Class [" + className + "] removed.");
    } else {
      System.out.println("Error: Class [" + className + "] does not exist.");
    }
  }

  public static void renameClass(String oldName, String newName) {
    if (Storage.classExists(oldName)) {
      if (!Storage.classExists(newName)) {
        UMLClass umlClass = Storage.getUMLClasses().remove(oldName);
        Storage.addClass(newName, umlClass);
        System.out.println("Class [" + oldName + "] renamed to [" + newName + "].");
      } else {
        System.out.println("Error: Class [" + newName + "] already exists.");
      }
    } else {
      System.out.println("Error: Class [" + oldName + "] does not exist.");
    }
  }

  public static boolean classExists(String className) {
    return Storage.classExists(className);  // Check if the class exists in the storage
  }
}
