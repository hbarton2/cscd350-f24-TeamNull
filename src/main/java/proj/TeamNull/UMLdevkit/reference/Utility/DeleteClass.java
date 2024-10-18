package proj.TeamNull.UMLdevkit.reference.Utility;

import proj.TeamNull.UMLdevkit.Storage;
import java.util.ArrayList;

public class DeleteClass {
    // Assuming storage is a singleton instance
    private static Storage storage = Storage.getInstance();

    // Method to delete a class by its name
    public static void deleteClassByName(ArrayList<Object> storageList, String classNameToDelete) {
        if (storageList == null || storageList.isEmpty()) {
            System.out.println("There are no classes in the list.");
            return;
        }

        boolean classFound = false;

        // Iterate through the list to find the class by its name
        for (int i = 0; i < storageList.size(); i++) {
            // Ensure the object is an ArrayList before casting
            if (storageList.get(i) instanceof ArrayList) {
                ArrayList<Object> classData = (ArrayList<Object>) storageList.get(i);
                String className = (String) classData.get(0); // Class name is stored at index 0

                if (className.equalsIgnoreCase(classNameToDelete)) {
                    storageList.remove(i); // Remove the class from the list
                    System.out.println("\nClass '" + classNameToDelete + "' deleted successfully.\n");
                    classFound = true;
                    break; // Exit loop after deleting the class
                }
            }
        }

        if (!classFound) {
            System.out.println("Class '" + classNameToDelete + "' not found.");
        }
    }
}