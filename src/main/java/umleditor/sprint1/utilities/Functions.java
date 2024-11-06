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

  private static final String TEMP_FILENAME = "temp_save.json";
  private static final String STORAGE_DIRECTORY = "src/main/resources/sprint1/hdd";

  // Method to create a new class
  public static void createClass(String className) {
    if (!Storage.classExists(className)) {
      Storage.addClass(className);
      System.out.println("Class " + className + " created.");
      saveProgress(TEMP_FILENAME); // Auto-save to temporary storage
    } else {
      System.out.println("Error: Class " + className + " already exists.");
    }
  }

  // Method to remove a class
  public static void removeClass(String className) {
    if (Storage.classExists(className)) {
      Storage.removeClass(className);
      System.out.println("Class " + className + " removed.");
      saveProgress(TEMP_FILENAME); // Auto-save to temporary storage
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
        saveProgress(TEMP_FILENAME); // Auto-save to temporary storage
      } else {
        System.out.println("Error: Class " + newName + " already exists.");
      }
    } else {
      System.out.println("Error: Class " + oldName + " does not exist.");
    }
  }

  // Add or update an attribute in a class
  public static void addAttribute(String className, String attributeType, String attributeName) {
    UMLClass umlClass = getClassIfExists(className);
    if (umlClass != null) {
      umlClass.addAttribute(attributeName, attributeType);
      saveProgress(TEMP_FILENAME); // Auto-save
    }
  }

  // Remove an attribute from a class
  public static void removeAttribute(String className, String attributeName) {
    UMLClass umlClass = getClassIfExists(className);
    if (umlClass != null) {
      umlClass.removeAttribute(attributeName);
      saveProgress(TEMP_FILENAME); // Auto-save
    }
  }

  // Rename an attribute in a class
  public static void renameAttribute(String className, String oldAttribute, String newAttribute) {
    UMLClass umlClass = getClassIfExists(className);
    if (umlClass != null) {
      umlClass.renameAttribute(oldAttribute, newAttribute);
      saveProgress(TEMP_FILENAME); // Auto-save
    }
  }

  // Add or update a method in a class
  public static void addMethod(String className, String methodType, String methodName) {
    UMLClass umlClass = getClassIfExists(className);
    if (umlClass != null) {
      if (!umlClass.methodExists(methodName)) {
        umlClass.addMethod(methodName, methodType);
        saveProgress(TEMP_FILENAME); // Auto-save
      } else {
        System.out.println("Error: Method " + methodName + " already exists in class " + className + ".");
      }
    }
  }

  // Remove a method from a class
  public static void removeMethod(String className, String methodName) {
    UMLClass umlClass = getClassIfExists(className);
    if (umlClass != null && umlClass.methodExists(methodName)) {
      umlClass.removeMethod(methodName);
      saveProgress(TEMP_FILENAME); // Auto-save
    } else {
      System.out.println("Error: Method " + methodName + " does not exist in class " + className + ".");
    }
  }

  // Rename a method in a class
  public static void renameMethod(String className, String oldMethodName, String newMethodName) {
    UMLClass umlClass = getClassIfExists(className);
    if (umlClass != null) {
      umlClass.renameMethod(oldMethodName, newMethodName);
      saveProgress(TEMP_FILENAME); // Auto-save
    }
  }

  // Add or update a relationship in a class
  public static int addRelationship(String className, int relationshipType, String destClass) {
    if (Storage.getUMLClasses().size() <= 1 || className.equals(destClass)){
      return 1;
    }
    UMLClass umlClass = getClassIfExists(className);
    UMLRelationshipType type = getRelationshipType(relationshipType);
    if (umlClass != null && type != null) {
      umlClass.addOrUpdateRelationship(type);
      saveProgress(TEMP_FILENAME); // Auto-save
    }
    return 0;
  }

  // Remove a relationship from a class
  public static void removeRelationship(String className) {
    UMLClass umlClass = getClassIfExists(className);
    if (umlClass != null) {
      umlClass.removeRelationship();
      saveProgress(TEMP_FILENAME); // Auto-save
    }
  }

  // Add a parameter to a method in a class
  public static void addParam(String className, String methodName, String newParamName, String paramType) {
    MethodSignature method = getMethodIfExists(className, methodName);
    if (method != null) {
      method.addParam(newParamName, paramType);
      saveProgress(TEMP_FILENAME); // Auto-save
    }
  }

  // Remove a parameter from a method in a class
  public static void removeParam(String className, String methodName, String paramName) {
    MethodSignature method = getMethodIfExists(className, methodName);
    if (method != null) {
      method.removeParam(paramName);
      saveProgress(TEMP_FILENAME); // Auto-save
    }
  }

  // List all classes, only names or only relationships
  public static void listClasses(String type) {
    switch (type) {
      case "lsa":
        listAllClassDetails();
        break;
      case "lsc":
        listClassNamesOnly();
        break;
      case "lsr":
        listClassesWithRelationships();
        break;
      default:
        System.out.println("Error: Invalid list type.");
    }
  }

  // Helper methods for listing details, names, and relationships
  private static void listAllClassDetails() {
    if (Storage.getUMLClasses().isEmpty()) {
      System.out.println("No classes created.");
      return;
    }
    for (UMLClass umlClass : Storage.getUMLClasses().values()) {
      System.out.println("Class: " + umlClass.getClassName());
      System.out.println("Fields: " + umlClass.getAttributes());
      umlClass.displayMethods();
      System.out.println();
    }
  }

  private static void listClassNamesOnly() {
    if (Storage.getUMLClasses().isEmpty()) {
      System.out.println("No classes created.");
      return;
    }
    for (String className : Storage.getUMLClasses().keySet()) {
      System.out.println("- " + className);
    }
  }

  private static void listClassesWithRelationships() {
    if (Storage.getUMLClasses().isEmpty()) {
      System.out.println("No classes created.");
      return;
    }
    for (UMLClass umlClass : Storage.getUMLClasses().values()) {
      if (!umlClass.getRelationships().isEmpty()) {
        System.out.println("Class: " + umlClass.getClassName());
        System.out.println("Relationships: " + umlClass.getRelationships());
        System.out.println();
      }
    }
  }

  // Helper to find UMLClass if it exists
  private static UMLClass getClassIfExists(String className) {
    if (Storage.classExists(className)) {
      return Storage.getUMLClasses().get(className);
    } else {
      System.out.println("Error: Class " + className + " does not exist.");
      return null;
    }
  }

  // Helper to find MethodSignature if it exists in a class
  private static MethodSignature getMethodIfExists(String className, String methodName) {
    UMLClass umlClass = getClassIfExists(className);
    if (umlClass != null && umlClass.methodExists(methodName)) {
      return umlClass.findMethod(methodName);
    } else {
      System.out.println("Error: Method " + methodName + " does not exist in class " + className + ".");
      return null;
    }
  }

  // Save progress to a file or temporary if no filename is provided
  public static void saveProgress(String filename) {
    try {
      File dir = new File(STORAGE_DIRECTORY);
      if (!dir.exists()) {
        dir.mkdirs();
      }

      Gson gson = new Gson();
      String json = gson.toJson(Storage.getUMLClasses());

      try (FileWriter writer = new FileWriter(new File(STORAGE_DIRECTORY, filename))) {
        writer.write(json);
        System.out.println("Progress saved to " + STORAGE_DIRECTORY + "/" + filename + ".");
      }
    } catch (IOException e) {
      System.out.println("Error: Could not save progress to " + filename + ".");
    }
  }

  // Load progress from a file or temporary if no filename is provided
  public static void loadProgress(String filename) {
    File file = new File(STORAGE_DIRECTORY, filename);
    if (!file.exists()) {
      System.out.println("Error: File " + filename + " does not exist.");
      return;
    }

    try (FileReader reader = new FileReader(file)) {
      Type type = new TypeToken<HashMap<String, UMLClass>>() {}.getType();
      HashMap<String, UMLClass> loadedClasses = new Gson().fromJson(reader, type);
      Storage.setUMLClasses(loadedClasses);
      System.out.println("Progress loaded from " + STORAGE_DIRECTORY + "/" + filename + ".");
    } catch (IOException e) {
      System.out.println("Error: Could not load progress from " + filename + ".");
    }
  }

  // Clear all classes from Storage
  public static void clearProgress() {
    Storage.clearUMLClasses();
    System.out.println("All progress has been cleared.");
  }

  // Helper method to map integer to UMLRelationshipType
  private static UMLRelationshipType getRelationshipType(int number) {
    return switch (number) {
      case 1 -> UMLRelationshipType.ASSOCIATION;
      case 2 -> UMLRelationshipType.AGGREGATION;
      case 3 -> UMLRelationshipType.COMPOSITION;
      case 4 -> UMLRelationshipType.INHERITANCE;
      case 5 -> UMLRelationshipType.GENERALIZATION;
      case 6 -> UMLRelationshipType.REALIZATION;
      case 7 -> UMLRelationshipType.DEPENDENCY;
      default -> null;
    };
  }

  public static void exit() {
    System.exit(0);
  }
}
