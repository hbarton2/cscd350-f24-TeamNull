package proj.TeamNull.UMLdevkit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UMLClassTemplate {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Input for class name
    System.out.print("Enter class name: ");
    String className = scanner.nextLine();

    // Storing class names
    ArrayList<String> classes = new ArrayList<>();
    classes.add(className);

    // Input for attributes
    List<String> attributes = new ArrayList<>();
    System.out.println("Enter attributes (type 'done' when finished): ");
    while (true) {
      System.out.print("Attribute (format: name: Type): ");
      String attribute = scanner.nextLine();
      if (attribute.equalsIgnoreCase("done")) {
        break;
      }
      attributes.add(attribute);
    }

    // Input for methods
    List<String> methods = new ArrayList<>();
    System.out.println("Enter methods (type 'done' when finished): ");
    while (true) {
      System.out.print("Method (format: name(): ReturnType): ");
      String method = scanner.nextLine();
      if (method.equalsIgnoreCase("done")) {
        break;
      }
      methods.add(method);
    }

    // Display the UML class template
    displayClassTemplate(className, attributes, methods);


    scanner.close();
  }

  // Linear search for class name
  // Used
  public static void searchClassName(  String[] array, String key){
    if (array == null || array.length == 0) {
      System.out.println("There is nothing in the list");
      return;
    }
    boolean found = false;  // Track if the key is found
    for (int i = 0; i < array.length; i++) {

      if (array[i].equals(key)) {
        System.out.println("Found: " + array[i] + " at index " + i);
        found = true;
        break;  // Exit after finding the first match
      }
    }
    if (!found) {
      System.out.println("Class name not found.");
    }

  }//End of method

  public static void displayClassTemplate(String className, List<String> attributes,
    List<String> methods) {
    System.out.println("\n+-----------------------+");
    System.out.printf("|       %-15s      |\n", className);
    System.out.println("+-----------------------+");

    if (!attributes.isEmpty()) {
      for (String attribute : attributes) {
        System.out.printf("| - %-19s |\n", attribute);
      }
    } else {
      System.out.println("|  No attributes         |");
    }

    System.out.println("+-----------------------+");

    if (!methods.isEmpty()) {
      for (String method : methods) {
        System.out.printf("| + %-19s |\n", method);
      }
    } else {
      System.out.println("|  No methods            |");
    }

    System.out.println("+-----------------------+");
  }
}
