package proj.TeamNull.UMLdevkit.utilities;

import proj.TeamNull.UMLdevkit.uml.UMLClass;

public class Functions {

  // Method to create a new class
  public static void createClass(String className) {
    if (!Storage.classExists(className)) {
      Storage.addClass(className);
      System.out.println("Class " + className + " created.");
    } else {
      System.out.println("Error: Class " + className + " already exists.");
    }
  }

  // Method to remove a class
  public static void removeClass(String className) {
    if (Storage.classExists(className)) {
      Storage.removeClass(className);
      System.out.println("Class " + className + " removed.");
    } else {
      System.out.println("Error: Class " + className + " does not exist.");
    }
  }

  // Method to rename a class
  public static void renameClass(String oldName, String newName) {
    if (Storage.classExists(oldName)) {
      if (!Storage.classExists(newName)) {
        Storage.renameClass(oldName, newName);
        System.out.println("Class " + oldName + " renamed to " + newName + ".");
      } else {
        System.out.println("Error: Class " + newName + " already exists.");
      }
    } else {
      System.out.println("Error: Class " + oldName + " does not exist.");
    }
  }

  // Add attribute to a class
  public static void addAttribute(String className, String attribute) {
    if (Storage.classExists(className)) {
      UMLClass umlClass = Storage.getUMLClasses().get(className);  // Fetch class from storage
      umlClass.addAttribute(attribute);
    } else {
      System.out.println("Error: Class " + className + " does not exist.");
    }
  }

  // Remove an attribute from a class
  public static void removeAttribute(String className, String attribute) {
    if (Storage.classExists(className)) {
      UMLClass umlClass = Storage.getUMLClasses().get(className);  // Fetch class from storage
      umlClass.removeAttribute(attribute);
    } else {
      System.out.println("Error: Class " + className + " does not exist.");
    }
  }

  // Add method to a class with method name and optional parameter (handling overloading)
  public static void addMethod(String className, String methodName, String parameter) {
    if (Storage.classExists(className)) {
      UMLClass umlClass = Storage.getUMLClasses().get(className);  // Fetch class from storage

      // Check for duplicates
      if (umlClass.methodExists(methodName, parameter)) {
        System.out.println("Error: Method " + methodName + " with parameter '" + parameter + "' already exists in class " + className + ".");
      } else {
        umlClass.addMethod(methodName, parameter);
        System.out.println("Method " + methodName + " with parameter '" + parameter + "' added to class " + className + ".");
      }
    } else {
      System.out.println("Error: Class " + className + " does not exist.");
    }
  }

  // Remove a method from a class (including overloads)
  public static void removeMethod(String className, String methodName, String parameter) {
    if (Storage.classExists(className)) {
      UMLClass umlClass = Storage.getUMLClasses().get(className);  // Fetch class from storage

      // Check if method exists before attempting removal
      if (umlClass.methodExists(methodName, parameter)) {
        umlClass.removeMethod(methodName, parameter);
        System.out.println("Method " + methodName + " with parameter '" + parameter + "' removed from class " + className + ".");
      } else {
        System.out.println("Error: Method " + methodName + " with parameter '" + parameter + "' does not exist in class " + className + ".");
      }
    } else {
      System.out.println("Error: Class " + className + " does not exist.");
    }
  }
}
