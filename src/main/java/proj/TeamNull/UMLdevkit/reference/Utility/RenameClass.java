package proj.TeamNull.UMLdevkit.reference.Utility;

import java.util.ArrayList;

/**
 *This class represent RenameClass feature
 * It takes an Arraylist of storage, list of all classes, oldClassName and newClassName as input
 *
 */
public class RenameClass {
    public void renameClassName(ArrayList<Object> storage, String oldClassName, String newClassName) {
        if (storage == null || storage.isEmpty() || oldClassName.isEmpty() || newClassName.isEmpty()) {
            System.out.println("Error class list or old class name or new class name is empty");
            return;
        }

        boolean found = false; // Track if the old class name is found
        for (Object classNameInList : storage) {
            ArrayList<Object> classData = (ArrayList<Object>) classNameInList;
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