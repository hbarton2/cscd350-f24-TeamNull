package proj.TeamNull.UMLdevkit.NOTUSED;

import java.util.ArrayList;

/**
 * This class represent a feature to delete class by name deleteClassByName method takes an Array
 * list of type Object and String classNameToDelete as parameter Precondition: This method first
 * check the arraylist to make it is not empty and the String classNameToDelete is not empty If
 * class name is found, it deletes it from the list then prints a confirmation message If not found
 * it returns a message on the screen
 */

public class DeleteUMLClass {

  // Method to delete a class by its name
  public static void deleteClassByName(ArrayList<Object> storageList, String classNameToDelete) {

    if (storageList == null || storageList.isEmpty() || classNameToDelete.isEmpty()) {
      System.out.println("Storage array list is empty.");
      return;
    }

    //tracks class name in the storage list
    boolean classFound = false;

    // Iterate through the list to find the class by its name
    for (int i = 0; i < storageList.size(); i++) {
      // Ensure the object is an ArrayList before casting
      if (storageList.get(i) instanceof ArrayList) {
        ArrayList<Object> classData = (ArrayList<Object>) storageList.get(i);
        String className = (String) classData.get(0); // Class name is stored at index 0

        if (className.equalsIgnoreCase(classNameToDelete)) {
          storageList.remove(i); // Remove the class from the list
          System.out.println("\nClass ' " + classNameToDelete + " ' deleted successfully.\n");
          classFound = true;
          break; // Exit loop after deleting the class
        }
      }
    }

    if (!classFound) {
      System.out.println("Class '" + classNameToDelete + "' not found.");
      System.out.println("Please make sure the exist & is spelled correctly.");
    }
  }
}