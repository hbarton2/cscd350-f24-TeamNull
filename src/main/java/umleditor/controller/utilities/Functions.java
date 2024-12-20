package umleditor.controller.utilities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.ArrayList;
import umleditor.model.uml.MethodSignature;
import umleditor.model.uml.UMLClass;
import umleditor.model.uml.UMLRelationship;
import umleditor.model.uml.UMLRelationshipType;
import umleditor.model.utilities.MementoSaveData;
import umleditor.model.utilities.MementoStorage;
import umleditor.model.utilities.Storage;

public class Functions {

  private static final String TEMP_FILENAME = "temp_save.json";
  private static final String STORAGE_DIRECTORY = "src/main/resources/sprint1/hdd";
  private static final Storage store = Storage.getInstance();
  private static final MementoStorage memStore = MementoStorage.getInstance();

  // Singleton instance of Storage
  private static final Storage storage = Storage.getInstance();

  // Method to create a new class
  public static void createClass(String className) {
    if (!storage.classExists(className)) {
      UMLClass newClass = storage.createClass(className);
      storage.addClass(className, newClass);
      memStore.saveState(newClass.saveToMemento(storage.classExists(className)));
      System.out.println("Class " + className + " created.");
    } else {
      System.out.println("Error: Class " + className + " already exists.");
    }
  }

  // Method to remove a class
  public static void removeClass(String className) {
    if (storage.classExists(className)) {

      // Get the class to be removed
      UMLClass classToRemove = storage.getClassObject(className);
      storage.removeClass(className);
      memStore.saveState(classToRemove.saveToMemento(storage.classExists(className)));
      System.out.println("Class " + className + " removed.");
    } else {
      System.out.println("Error: Class " + className + " does not exist.");
    }
  }

  // Method to rename a class
  public static void renameClass(String oldName, String newName) {
    if (storage.classExists(oldName)) {
      UMLClass umlClass = storage.getClassObject(oldName);
      if (!storage.classExists(newName)) {
        storage.renameClass(oldName, newName);
        memStore.saveState(umlClass.saveToMemento(storage.classExists(newName)));
        System.out.println("Class " + oldName + " renamed to " + newName + ".");
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
      memStore.saveState(umlClass.saveToMemento(storage.classExists(className)));
    }
  }

  // Remove an attribute from a class
  public static void removeAttribute(String className, String attributeName) {
    UMLClass umlClass = getClassIfExists(className);
    if (umlClass != null) {
      umlClass.removeAttribute(attributeName);
      memStore.saveState(umlClass.saveToMemento(storage.classExists(className)));
    }
  }

  // Rename an attribute in a class
  public static void renameAttribute(String className, String oldAttribute, String newAttribute) {
    UMLClass umlClass = getClassIfExists(className);
    if (umlClass != null) {
      umlClass.renameAttribute(oldAttribute, newAttribute);
      memStore.saveState(umlClass.saveToMemento(storage.classExists(className)));
    }
  }

  // Add or update a method in a class
  public static void addMethod(String className, String methodType, String methodName) {
    UMLClass umlClass = getClassIfExists(className);
    if (umlClass != null) {
      if (!umlClass.methodExists(methodName)) {
        umlClass.addMethod(methodName, methodType);
        memStore.saveState(umlClass.saveToMemento(storage.classExists(className)));
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
      memStore.saveState(umlClass.saveToMemento(storage.classExists(className)));
    } else {
      System.out.println("Error: Method " + methodName + " does not exist in class " + className + ".");
    }
  }

  // Rename a method in a class
  public static void renameMethod(String className, String oldMethodName, String newMethodName) {
    UMLClass umlClass = getClassIfExists(className);
    if (umlClass != null) {
      umlClass.renameMethod(oldMethodName, newMethodName);
      memStore.saveState(umlClass.saveToMemento(storage.classExists(className)));
    }
  }

  // Add or update a relationship in a class
  public static int addRelationship(String className, int relationshipType, String destClass) {
    if (storage.getUMLClasses().size() <= 1 || className.equals(destClass)){
      System.out.println("Can not create relation to single class or 'self', please try again.");
      return 1;
    }
    UMLClass umlClass = getClassIfExists(className);
    UMLRelationshipType type = getRelationshipType(relationshipType);
    if (umlClass != null && type != null) {
      storage.addRelation(new UMLRelationship(className, type, destClass));
//      saveProgress(TEMP_FILENAME); // Auto-save
      return 0;
    }
    return 1;
  }

  // Remove a relationship from a class
  public static void removeRelationship(String className) {
    UMLClass umlClass = getClassIfExists(className);
    if (umlClass != null) {
      umlClass.removeRelationship();
    }
  }

  // Add a parameter to a method in a class
  public static void addParam(String className, String methodName, String newParamName, String paramType) {
    if(storage.classExists(className)) {
      UMLClass umlClass = storage.getClassObject(className);
      MethodSignature method = getMethodIfExists(className, methodName);
      if (method != null) {
        method.addParam(newParamName, paramType);
        memStore.saveState(umlClass.saveToMemento(storage.classExists(className)));
      }
    }
  }

  // Remove a parameter from a method in a class
  public static void removeParam(String className, String methodName, String paramName) {
      if(storage.classExists(className)) {
        UMLClass umlClass = storage.getClassObject(className);
      MethodSignature method = getMethodIfExists(className, methodName);
      if (method != null) {
        method.removeParam(paramName);
        memStore.saveState(umlClass.saveToMemento(storage.classExists(className)));
      }
    }
  }

  //Rename Parameter in already existing method
  public static void renameParam(String className, String methodName, String oldParam, String newParam){
    if(storage.classExists(className)) {
      UMLClass umlClass = storage.getClassObject(className);
      MethodSignature method = getMethodIfExists(className, methodName);
      if (method != null) {
        MethodSignature.UMLParameter param = method.getParam(oldParam);
        if(param != null) {
          param.renameParam(newParam);
          memStore.saveState(umlClass.saveToMemento(storage.classExists(className)));
        }
      }
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
    if (storage.getUMLClasses().isEmpty()) {
      System.out.println("No classes created.");
      return;
    }
    for (UMLClass umlClass : storage.getUMLClasses().values()) {
      System.out.println("Class: " + umlClass.getClassName());
      umlClass.displayAttributes();
      umlClass.displayMethods();
      System.out.println();
    }
  }

  private static void listClassNamesOnly() {
    if (storage.getUMLClasses().isEmpty()) {
      System.out.println("No classes created.");
      return;
    }
    for (String className : storage.getUMLClasses().keySet()) {
      System.out.println("- " + className);
    }
  }

  private static void listClassesWithRelationships() {
    if (storage.getUMLClasses().isEmpty()) {
      System.out.println("No classes created.");
      return;
    }
    for (UMLRelationship relation : storage.getRelationships()) {
      if (!storage.getRelationships().isEmpty()) {
        System.out.println(relation);
      }
    }
  }

  // Helper to find UMLClass if it exists
  public static UMLClass getClassIfExists(String className) {
    if (storage.classExists(className)) {
      return storage.getUMLClasses().get(className);
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
    String fileName;
    if (filename.endsWith(".json")) {
      fileName = filename;
    } else {
      fileName = filename + ".json";
    }
    String printOutName = fileName;

    try {
      FileWriter writer = getFileWriter(fileName);
      writer.close();

      System.out.println("Progress saved to " + STORAGE_DIRECTORY + "/" + printOutName + ".");
    } catch (IOException e) {
      System.out.println("Error: Could not save progress to " + printOutName + ".");
    }
  }

  //Helper method for reading in the file
  private static FileWriter getFileWriter(String fileName) throws IOException {
    File dir = new File(STORAGE_DIRECTORY);
    if (!dir.exists()) {
      dir.mkdirs();
    }

    // Wrap classes and relationships in a container
    Gson gson = new Gson();
    MementoSaveData mementoSaveData = new MementoSaveData(storage.getUMLClasses(), storage.getRelationships());

    // Serialize the container to JSON
    String json = gson.toJson(mementoSaveData);

    // Write the JSON to the file
    FileWriter writer = new FileWriter(new File(STORAGE_DIRECTORY, fileName));
    writer.write(json);
    return writer;
  }

  // Load progress from a file or temporary if no filename is provided
  public static void loadProgress(String filename) {
    String fileName;
    if (filename.endsWith(".json")) {
      fileName = filename;
    } else {
      fileName = filename + ".json";
    }
    String printOutName = fileName;

    File file = new File(STORAGE_DIRECTORY, fileName);

    if (!file.exists()) {
      System.out.println("Error: File " + printOutName + " does not exist.");
      return;
    }

    try {
      // Read the JSON from the file
      FileReader reader = new FileReader(file);

      // Deserialize the JSON into the container
      Gson gson = new Gson();
      Type saveDataType = new TypeToken<MementoSaveData>() {}.getType();
      MementoSaveData mementoSaveData = gson.fromJson(reader, saveDataType);

      // Extract classes and relationships from the container
      storage.setUMLClasses(mementoSaveData.getClasses());
      Storage.setRelationships(mementoSaveData.getRelationships());

      System.out.println("Progress loaded from " + STORAGE_DIRECTORY + "/" + printOutName + ".");
    } catch (IOException e) {
      System.out.println("Error: Could not load progress from " + printOutName + ".");
    }
  }

  // Clear all classes from Storage
  public static void clearProgress() {
    storage.clearUMLClasses();
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

  /**
   * Reverts the last action performed by the user using the undo stack.
   * Retrieves the last memento, restores the state, and moves it to the redo stack.
   */
  public static void undo() {
    if (memStore.canUndo()) {
      // Perform the undo operation
      UMLClass.Memento previousState = memStore.undo();
      if (previousState != null) {
        UMLClass affectedClass = storage.getClassObject(previousState.getClassName());
        affectedClass.restoreFromMemento(previousState);
        System.out.println("Last action reverted: Class " + previousState.getClassName() + " restored.");
      } else {
        System.out.println("Undo failed: No state to revert.");
      }
    } else {
      System.out.println("No actions to undo.");
    }
  }

  /**
   * Restores the most recently undone action using the redo stack.
   * Retrieves the last memento from the redo stack, restores the state, and moves it to the undo stack.
   */
  public static void redo() {
    if (memStore.canRedo()) {
      // Perform the redo operation
      UMLClass.Memento redoneState = memStore.redo();
      if (redoneState != null) {
        UMLClass affectedClass = storage.getClassObject(redoneState.getClassName());
        affectedClass.restoreFromMemento(redoneState);
        System.out.println("Last undone action restored: Class " + redoneState.getClassName() + " redone.");
      } else {
        System.out.println("Redo failed: No state to restore.");
      }
    } else {
      System.out.println("No actions to redo.");
    }
  }

  public static void exit() {
    System.exit(0);
  }
}
