package proj.TeamNull.UMLdevkit.reference.Utility;

import java.util.ArrayList;

public class RenameClass {
    public static void renameClassName(ArrayList<Object> allClasses, String oldClassName, String newClassName) {
        if (allClasses == null || allClasses.size() == 0) {
            System.out.println("There are no classes in the list.");
            return;
        }
        boolean found = false; // Track if the old class name is found
        for (int i = 0; i < allClasses.size(); i++) {
            ArrayList<Object> classData = (ArrayList<Object>) allClasses.get(i);
            String className = (String) classData.get(0); // Get class name from index 0
            if (className.equalsIgnoreCase(oldClassName)) {
                classData.set(0, newClassName); // Update class name
                System.out.println("Class name changed from " + oldClassName + " to " + newClassName);
                found = true;
                break; // Exit after renaming the first match
            }
        }
        if (!found) {
            System.out.println("Class name not found.");
        }
    }
}