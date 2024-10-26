package proj.TeamNull.UMLdevkit.utilities;

import java.util.ArrayList;

/**
 * This ListAllUMLClasses represents the function that list all the UMLCLasses with details
 * It has one method that process the array list that is passed on to it.
 */

public class ListAllUMLClasses {
/**
 * It processes an array list of UML Classes, where each UML class is represented by a list
 * containing the class name, fields, and methods
 *
 * Preconditions, checks and displays a message to the user if array list passed on to it is empty
 * If the list is not empty, it will print class name, follow by field names and method names for each class in the list.
 */
    public void displayClassDetails(ArrayList<ArrayList<Object>> allClasses) {

        if (allClasses == null) {
            System.out.println("The UML Class List is empty\n");
            return;
        }
        System.out.println("\nBelow is class details:");
        System.out.println("----------------------------------------");

        // Loops through array list
        for (int i = 0; i < allClasses.size(); i++) {
            ArrayList<Object> classData = allClasses.get(i);
            System.out.println("\nClass " + (i + 1) + ":");
            System.out.println("Class Name: " + classData.get(0));
            System.out.println("Fields: " + classData.get(1));
            System.out.println("Methods: " + classData.get(2));
        }
        System.out.println("----------------------------------------");
    } // End of method
} // End of class