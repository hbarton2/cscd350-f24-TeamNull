package proj.TeamNull.UMLdevkit.Menu;
import proj.TeamNull.UMLdevkit.UMLComponent.UMLComponentManager;

import java.util.Scanner;

/**
 * Menu Class to handle user input through menu operations
 */
public class Menu {

  static Scanner sc = new Scanner(System.in);
  public static UMLComponentManager classes;

  public static void displayMainMenu() {
    System.out.println("+-----------------------------+");
    System.out.println("|       Main Menu             |");
    System.out.println("+-----------------------------+");
    System.out.println("| 1. UML Diagram Menu         |");
    System.out.println("| 2. Help                     |");
    System.out.println("| 3. About                    |");
    System.out.println("| 4. Exit                     |");
    System.out.println("+-----------------------------+");
    System.out.print("Enter your choice:  ");
  }

  public static void processMainMenuInput(String input) {
    switch (input) {
      case "1":
        System.out.println("UML Diagram: loading UML creation menu...");
        displayUMLMenu();
        processUMLMenuInput(sc.nextLine());
        return;
      case "2":
        Help.printHelpMenu();
        break;
      case "3":
        //TODO: address about statement. Should this say more?
        System.out.println("About: This application was built using JavaFX.");
        break;
      case "4":
        System.out.println("Exiting the menu...");
        System.exit(0);   // Terminate the application.
        break;
      default:
        System.out.println("Invalid choice. Please try again.");
    }

    displayMainMenu();  // Re-display the menu after processing input.
    processMainMenuInput(sc.nextLine());
  }

  public static void displayUMLMenu(){
    System.out.println("+-------------------------------------+");
    System.out.println("|            UML Menu                 |");
    System.out.println("+-------------------------------------+");
    System.out.println("| 1.  Class                           |");
    System.out.println("| 2.  Field                           |");
    System.out.println("| 3.  Method                          |");
    System.out.println("| 4.  Display                         |");
    System.out.println("| 5.  Save UML Diagram                |");
    System.out.println("| 6.  Load UML Diagram                |");
    System.out.println("| 7.  Return to Main Menu             |");
    System.out.println("+-------------------------------------+");
    System.out.println("Enter your choice:");
  }

  public static void processUMLMenuInput(String input) {
    switch (input) {
      case "1":
        System.out.println("Open Class menu ");
        displayClassMenu();
        processClassMenuInput(sc.nextLine());
        return; // return after handling submenus
      case "2":
        System.out.println("Open Field menu ");
        displayFieldMenu();
        processFieldMenuInput(sc.nextLine());
        return;
      case "3":
        System.out.println("Open Method menu ");
        displayMethodMenu();
        processMethodMenuInput(sc.nextLine());
        return;
      case "4":
        System.out.println("open Display menu ");
        displayDisplayMenu();
        processDisplayMenuInput(sc.nextLine());
        return;
      case "5":
        System.out.println("Save to JSON file");
        break;
      case "6":
        System.out.println("Load from JSON file");
        break;
      case "7":
        System.out.println("Returning to Main Menu...");
        displayMainMenu();
        processMainMenuInput(sc.nextLine());
        return;
      default:
        System.out.println("Invalid choice. Please try again.");
        break;
    }

    displayUMLMenu();  // Re-display the menu after processing input.
    processUMLMenuInput(sc.nextLine());
  }

  public static void displayClassMenu(){
    System.out.println("+-------------------------------------+");
    System.out.println("|            UML Menu: Class          |");
    System.out.println("+-------------------------------------+");
    System.out.println("| 1.  Add Class                       |");
    System.out.println("| 2.  Delete Class                    |");
    System.out.println("| 3.  Rename Class                    |");
    System.out.println("| 4.  Add Class Relationship          |");
    System.out.println("| 5.  Remove Class Relationship       |");
    System.out.println("| 6.  Return                          |");
    System.out.println("+-------------------------------------+");
    System.out.print("Enter your choice: ");
  }

  public static void processClassMenuInput(String input) {
    switch (input) {
      case "1":
        System.out.println("Add Class: ");
        // add class method
        classes.addClass(sc.nextLine());
        break;
      case "2":
        System.out.println("Delete Class: ");
        // delete class method
        break;
      case "3":
        System.out.println("Rename Class: ");
        // rename class method
        break;
      case "4":
        System.out.println("Add Class Relationship: ");
        // add class relationship method
        break;
      case "5":
        System.out.println("Remove Class Relationship: ");
        // delete class relationship method
        break;
      case "6":
        System.out.println("Returning to UML Menu...");
        displayUMLMenu();
        processUMLMenuInput(sc.nextLine());   // return to Main Menu
        return;
      default:
        System.out.println("Invalid choice. Please try again.");
        break;
    }
    displayClassMenu();  // Re-display the menu after processing input.
    processClassMenuInput(sc.nextLine());
  }

  public static void displayFieldMenu(){
    System.out.println("+-------------------------------------+");
    System.out.println("|            UML Menu: Field          |");
    System.out.println("+-------------------------------------+");
    System.out.println("| 1.  Add Field                       |");
    System.out.println("| 2.  Delete Field                    |");
    System.out.println("| 3.  Rename Field                    |");
    System.out.println("| 4.  Return                          |");
    System.out.println("+-------------------------------------+");
    System.out.print("Enter your choice: ");
  }

  public static void processFieldMenuInput(String input) {
    switch (input) {
      case "1":
        System.out.println("Add Field: ");
        // add field method
        break;
      case "2":
        System.out.println("Delete Field: ");
        // delete field method
        break;
      case "3":
        System.out.println("Rename Field: ");
        // rename field method
        break;
      case "4":
        System.out.println("Returning to UML Menu...");
        displayUMLMenu();
        processUMLMenuInput(sc.nextLine());   // return to Main Menu
        return;
      default:
        System.out.println("Invalid choice. Please try again.");
        break;
    }
    displayFieldMenu();  // Re-display the menu after processing input.
    processFieldMenuInput(sc.nextLine());
  }

  public static void displayMethodMenu(){
    System.out.println("+-------------------------------------+");
    System.out.println("|            UML Menu: Method         |");
    System.out.println("+-------------------------------------+");
    System.out.println("| 1.  Add Method                      |");
    System.out.println("| 2.  Delete Method                   |");
    System.out.println("| 3.  Rename Method                   |");
    System.out.println("| 4.  Add Method Parameter            |");
    System.out.println("| 5.  Remove Method Parameter         |");
    System.out.println("| 6.  Update Method Parameter         |");
    System.out.println("| 7.  Return                          |");
    System.out.println("+-------------------------------------+");
    System.out.print("Enter your choice: ");
  }

  public static void processMethodMenuInput(String input) {
    switch (input) {
      case "1":
        System.out.println("Add Method: ");
        // addMethod method
        break;
      case "2":
        System.out.println("Delete Method: ");
        // deleteMethod method
        break;
      case "3":
        System.out.println("Rename Method: ");
        // renameMethod method
        break;
      case "4":
        System.out.println("Add Method Parameter: ");
        // addMethodParameter method
        break;
      case "5":
        System.out.println("Remove Method Parameter: ");
        // removeMethodParameter method
        break;
      case "6":
        System.out.println("Update Method Parameter: ");
        // updateMethodParameter method
        break;
      case "7":
        System.out.println("Returning to UML Menu...");
        displayUMLMenu();
        processUMLMenuInput(sc.nextLine());   // return to Main Menu
        return;
      default:
        System.out.println("Invalid choice. Please try again.");
        break;
    }
    displayMethodMenu();  // Re-display the menu after processing input.
    processMethodMenuInput(sc.nextLine());
  }

  public static void displayDisplayMenu(){
    System.out.println("+-------------------------------------------+");
    System.out.println("|            UML Menu: Display              |");
    System.out.println("+-------------------------------------------+");
    System.out.println("| 1.  Display Single Class and Its Contents |");
    System.out.println("| 2.  Display All Classes and Contents      |");
    System.out.println("| 3.  Return                                |");
    System.out.println("+-------------------------------------------+");
    System.out.print("Enter your choice: ");
  }

  public static void processDisplayMenuInput(String input) {
    switch (input) {
      case "1":
        System.out.println("Display Single Class and Its Contents: ");
        // single class display method
        break;
      case "2":
        System.out.println("Display All Classes and Contents: ");
        // display all classes and contents method
        break;
      case "3":
        System.out.println("Returning to UML Menu...");
        displayUMLMenu();
        processUMLMenuInput(sc.nextLine());   // return to Main Menu
        return;
      default:
        System.out.println("Invalid choice. Please try again.");
        break;
    }
    displayDisplayMenu();  // Re-display the menu after processing input.
    processDisplayMenuInput(sc.nextLine());
  }

}
