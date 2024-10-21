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
      Storage.renameClass(oldName, newName);
      System.out.println("Class " + oldName + " renamed to " + newName + ".");
    } else {
      System.out.println("Error: Class " + oldName + " does not exist.");
    }
  }

  // Add attribute to a class
  public static void addAttribute(String className, String attribute) {
    if (Storage.classExists(className)) {
      UMLClass umlClass = Storage.getUMLClasses().get(className);
      umlClass.addAttribute(attribute);
//      System.out.println("Attribute " + attribute + " added to class " + className + ".");
    } else {
//      System.out.println("Error: Class " + className + " does not exist.");
    }
  }

  // Add method to a class
//  public static void addMethod(String className, String method) {
//    if (Storage.classExists(className)) {
//      UMLClass umlClass = Storage.getUMLClasses().get(className);
//      umlClass.addMethod(method);
////      System.out.println("Method " + method + " added to class " + className + ".");
//    } else {
////      System.out.println("Error: Class " + className + " does not exist.");
//    }
//  }
  // Add method to a class with method name and optional parameter
  public static void addMethod(String className, String methodName, String parameter) {
    if (Storage.classExists(className)) {
      UMLClass umlClass = Storage.getUMLClasses().get(className);

      // Check for duplicates
      if (umlClass.methodExists(methodName, parameter)) {
        System.out.println("Error: Method " + methodName + " with parameter '" + parameter + "' already exists in class " + className + ".");
      } else {
        umlClass.addMethod(methodName, parameter);
//        System.out.println("Method " + methodName + " with parameter '" + parameter + "' added to class " + className + ".");
      }
    } else {
      System.out.println("Error: Class " + className + " does not exist.");
    }
  }
}
