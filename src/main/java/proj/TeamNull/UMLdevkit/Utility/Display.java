package proj.TeamNull.UMLdevkit.Utility;

import java.util.ArrayList;

/*
 * This method takes arraylist as parameter
 * checks array list to see if it is empty
 * returns the details
 */
public class Display {
    // Method to display all class with details
    public static void display(ArrayList<Object> allClasses) {
        if (allClasses.isEmpty()) {
            System.out.println("No data to display");
        } else {

            System.out.println("\nBelow is classes details:");
            System.out.println("----------------------------------------");

            for (int i = 0; i < allClasses.size(); i++) {
                ArrayList<Object> classData = (ArrayList<Object>) allClasses.get(i);
                System.out.println("\nClass " + (i + 1) + ":");
                System.out.println("Class Name: " + classData.get(0));
                System.out.println("Fields: " + classData.get(1));
                System.out.println("Methods: " + classData.get(2));
            }
            System.out.println("----------------------------------------");

        }
    }
}