package proj.TeamNull.UMLdevkit.utilities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import proj.TeamNull.UMLdevkit.uml.UMLClass;

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

  // Method to save progress
  public static void saveProgress(String filename) {
    try {
      // Specify the directory path
      String directoryPath = "src/main/resources/proj/TeamNull/UMLdevkit/hdd";
      File dir = new File(directoryPath);

      // Create directory if it doesn't exist
      if (!dir.exists()) {
        dir.mkdirs();
      }

      // Save progress to a file inside the directory
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

  // Method to load progress
  public static void loadProgress(String filename) {
    try {
      // Specify the directory path
      String directoryPath = "src/main/resources/proj/TeamNull/UMLdevkit/hdd";
      File file = new File(directoryPath + "/" + filename);

      // Check if file exists before loading
      if (!file.exists()) {
        System.out.println("Error: File " + filename + " does not exist.");
        return;
      }

      // Load progress from the file
      Gson gson = new Gson();
      FileReader reader = new FileReader(file);

      Type type = new TypeToken<HashMap<String, UMLClass>>() {
      }.getType();
      HashMap<String, UMLClass> loadedClasses = gson.fromJson(reader, type);
      Storage.setUMLClasses(loadedClasses);  // Update storage with loaded classes

      reader.close();
      System.out.println("Progress loaded from " + directoryPath + "/" + filename + ".");
    } catch (IOException e) {
      System.out.println("Error: Could not load progress from " + filename + ".");
    }
  }
}
