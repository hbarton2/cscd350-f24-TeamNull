package proj.TeamNull.UMLdevkit.Utility;

import java.util.ArrayList;

public class DeleteClass {
    // Method to delete a class by its name
    public static void deleteClassByName(ArrayList<Object> allClasses, String classNameToDelete) {
        if (allClasses == null || allClasses.size() == 0) {
            System.out.println("There are no classes in the list.");
            return;
        }
        boolean classFound = false;
        // Iterate through the list to find the class by its name
        for (int i = 0; i < allClasses.size(); i++) {
            ArrayList<Object> classData = (ArrayList<Object>) allClasses.get(i);
            String className = (String) classData.get(0); // Class name is stored at index 0
            if (className.equalsIgnoreCase(classNameToDelete)) {
                allClasses.remove(i); // Remove the class from the list
                System.out.println("\nClass '" + classNameToDelete + "' deleted successfully.\n");
                classFound = true;
                break; // Exit loop after deleting the class
            }
        }
        if (!classFound) {
            System.out.println("Class '" + classNameToDelete + "' not found.");
        }
    }
}

