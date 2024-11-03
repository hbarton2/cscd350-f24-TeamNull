package umleditor.sprint1.utilities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

import umleditor.sprint1.uml.MethodSignature;
import umleditor.sprint1.uml.UMLClass;
import umleditor.sprint1.uml.UMLRelationshipType;

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

  // Add method to a class with method name
  public static void addMethod(String className, String methodName) {
    if (Storage.classExists(className)) {
      UMLClass umlClass = Storage.getUMLClasses().get(className);  // Fetch class from storage

      // Check for duplicates
      if (umlClass.methodExists(methodName)) {
        System.out.println("Error: Method " + methodName +
           " already exists in class " + className + ".");
      } else {
        umlClass.addMethod(methodName);
      }
    } else {
      System.out.println("Error: Class " + className + " does not exist.");
    }
  }

  // Remove a method from a class (including overloads)
  public static void removeMethod(String className, String methodName) {
    if (Storage.classExists(className)) {
      UMLClass umlClass = Storage.getUMLClasses().get(className);  // Fetch class from storage

      // Check if method exists before attempting removal
      if (umlClass.methodExists(methodName)) {
        umlClass.removeMethod(methodName);
      } else {
        System.out.println("Error: Method " + methodName + " does not exist in class " + className + ".");
      }
    } else {
      System.out.println("Error: Class " + className + " does not exist.");
    }
  }

  // Add or update a relationship in a class
  public static void addRelationship(String className, int relationshipType) {
    if (Storage.classExists(className)) {
      UMLClass umlClass = Storage.getUMLClasses().get(className);  // Fetch class from storage
      UMLRelationshipType type = getRelationshipType(relationshipType);
      if (type != null) {
        umlClass.addOrUpdateRelationship(type);
      } else {
        System.out.println("Error: Invalid relationship type.");
      }
    } else {
      System.out.println("Error: Class " + className + " does not exist.");
    }
  }

  // Remove a relationship from a class
  public static void removeRelationship(String className) {
    if (Storage.classExists(className)) {
      UMLClass umlClass = Storage.getUMLClasses().get(className);  // Fetch class from storage
      umlClass.removeRelationship();
    } else {
      System.out.println("Error: Class " + className + " does not exist.");
    }
  }

  // Helper method to get relationship type by number
  private static UMLRelationshipType getRelationshipType(int number) {
    return switch (number) {
      case 1 -> UMLRelationshipType.ASSOCIATION;
      case 2 -> UMLRelationshipType.AGGREGATION;
      case 3 -> UMLRelationshipType.COMPOSITION;
      case 4 -> UMLRelationshipType.INHERITANCE;
      default -> null;
    };
  }

  public static void addParam(String className, String methodName, String newParamName, String paramType){
    if (Storage.classExists(className)) {
      UMLClass umlClass = Storage.getUMLClasses().get(className);  // Fetch class from storage

      if (umlClass.methodExists(methodName)) {
        MethodSignature method = umlClass.findMethod(methodName);
        method.addParam(newParamName, paramType);
        System.out.println("Param " + newParamName + " added to method " + methodName + ".");
      } else {
        System.out.println("Error: Method " + methodName + " does not exist in class " + className + ".");
      }
    } else {
      System.out.println("Error: Class " + className + " does not exist.");
    }
  }

  public static void removeParam(String className, String methodName, String paramName){
    if (Storage.classExists(className)) {
      UMLClass umlClass = Storage.getUMLClasses().get(className);

      if (umlClass.methodExists(methodName)) {
        MethodSignature method = umlClass.findMethod(methodName);
        method.removeParam(paramName);
        System.out.println("Param " + paramName + " removed from method " + methodName + ".");
      }
      else{
        System.out.println("Error: Method " + methodName + " with parameter '" + paramName
        + "' does not exist in class " + className + ".");
      }
    }
    else{
      System.out.println("Error: Class " + className + " does not exist.");
    }
  }

  public static void listClasses(String type) {
    switch (type) {
      case "lsa":
        listAllClassDetails();  // List all classes with details
        break;
      case "lsc":
        listClassNamesOnly();   // List class names only
        break;
      case "lsr":
        listClassesWithRelationships();  // List classes with relationships
        break;
      default:
        System.out.println("Error: Invalid list type.");
    }
  }

  // List all class details including attributes and methods
  private static void listAllClassDetails() {
    if (Storage.getUMLClasses().isEmpty()) {
      System.out.println("No classes created.");
      return;
    }
    System.out.println("Classes with attributes and methods:");
    for (UMLClass umlClass : Storage.getUMLClasses().values()) {
      System.out.println("Class: " + umlClass.getClassName());
      System.out.println("Fields: " + umlClass.getAttributes());
      umlClass.displayMethods();  // Show methods and overloads
      System.out.println();
    }
  }

  // List only class names
  private static void listClassNamesOnly() {
    if (Storage.getUMLClasses().isEmpty()) {
      System.out.println("No classes created.");
      return;
    }
    System.out.println("Classes:");
    for (String className : Storage.getUMLClasses().keySet()) {
      System.out.println("- " + className);
    }
  }

  // List classes that have relationships
  private static void listClassesWithRelationships() {
    if (Storage.getUMLClasses().isEmpty()) {
      System.out.println("No classes created.");
      return;
    }
    System.out.println("Classes with relationships:");
    for (UMLClass umlClass : Storage.getUMLClasses().values()) {
      if (!umlClass.getRelationships().isEmpty()) {
        System.out.println("Class: " + umlClass.getClassName());
        System.out.println("Relationships: " + umlClass.getRelationships());
        System.out.println();
      }
    }
  }

  // Save current progress to a file
  public static void saveProgress(String filename) {
    try {
      // Directory path to save the file
      String directoryPath = "src/main/resources/sprint1/hdd";
      File dir = new File(directoryPath);

      // Create directory if it doesn't exist
      if (!dir.exists()) {
        dir.mkdirs();
      }

      // Convert the UMLClasses to JSON and save
      Gson gson = new Gson();
      String json = gson.toJson(Storage.getUMLClasses());

      FileWriter writer = new FileWriter(directoryPath + "/" + filename);
      writer.write(json);
      writer.close();
      System.out.println("Progress saved to " + directoryPath + "/" + filename + ".");
    } catch (IOException e) {
      System.out.println("Error: Could not save progress to " + filename + ".");
    }
  }

  // Load progress from a file
  public static void loadProgress(String filename) {
    try {
      // Directory path to load the file
      String directoryPath = "src/main/resources/sprint1/hdd";
      File file = new File(directoryPath + "/" + filename);

      // Check if file exists
      if (!file.exists()) {
        System.out.println("Error: File " + filename + " does not exist.");
        return;
      }

      // Read the JSON from the file and update UMLClasses
      Gson gson = new Gson();
      FileReader reader = new FileReader(file);

      Type type = new TypeToken<HashMap<String, UMLClass>>() {
      }.getType();
      HashMap<String, UMLClass> loadedClasses = gson.fromJson(reader, type);
      Storage.setUMLClasses(loadedClasses);

      reader.close();
      System.out.println("Progress loaded from " + directoryPath + "/" + filename + ".");
    } catch (IOException e) {
      System.out.println("Error: Could not load progress from " + filename + ".");
    }
  }

  // Clear all progress (UML classes)
  public static void clearProgress() {
    Storage.clearUMLClasses();
    System.out.println("All progress has been cleared.");
  }

  // Method to rename an attribute
  public static void renameAttribute(String className, String oldAttribute, String newAttribute) {
    if (Storage.classExists(className)) {
      UMLClass umlClass = Storage.getUMLClasses().get(className);
      umlClass.renameAttribute(oldAttribute, newAttribute);
    } else {
      System.out.println("Error: Class " + className + " does not exist.");
    }
  }

  // Method to rename a method
  public static void renameMethod(String className, String oldMethodName, String newMethodName) {
    if (Storage.classExists(className)) {
      UMLClass umlClass = Storage.getUMLClasses().get(className);
      umlClass.renameMethod(oldMethodName, newMethodName);
    } else {
      System.out.println("Error: Class " + className + " does not exist.");
    }
  }

  public static void exit() {
    System.exit(0);
  }
}