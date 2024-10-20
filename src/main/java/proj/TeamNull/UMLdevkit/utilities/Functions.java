package proj.TeamNull.UMLdevkit.utilities;

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
}
