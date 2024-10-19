package proj.TeamNull.UMLdevkit.reference.Menu;

//import static proj.TeamNull.UMLdevkit.Menu.MenuBackup.displayDisplayMenu;
//import static proj.TeamNull.UMLdevkit.Menu.MenuBackup.displayFieldMenu;
//import static proj.TeamNull.UMLdevkit.Menu.MenuBackup.displayMethodMenu;
//import static proj.TeamNull.UMLdevkit.Menu.MenuBackup.processDisplayMenuInput;
//import static proj.TeamNull.UMLdevkit.Menu.MenuBackup.processFieldMenuInput;
//import static proj.TeamNull.UMLdevkit.Menu.MenuBackup.processMethodMenuInput;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Platform;
import proj.TeamNull.UMLdevkit.reference.UMLComponent.UMLClass;
import proj.TeamNull.UMLdevkit.reference.UMLComponent.UMLComponentManager;

/**
 * Menu Class to handle user input through menu operations
 */
public class MenuAlpha {

  static Scanner sc = new Scanner(System.in);
  public static UMLComponentManager classes = new UMLComponentManager();

  public static void displayMainMenu() {
    Platform.runLater(() -> {
    System.out.println("+-----------------------------+");
    System.out.println("|       Main Menu             |");
    System.out.println("+-----------------------------+");
    System.out.println("| 1. UML Diagram Menu         |");
    System.out.println("| 2. Help                     |");
    System.out.println("| 3. About                    |");
    System.out.println("| 4. Exit                     |");
    System.out.println("+-----------------------------+");
    System.out.print("Enter your choice:  ");
    });
  }

  //  public static void processMainMenuInput(String input) {
//    switch (input) {
//      case "1":
//        System.out.println("UML Diagram: loading UML creation menu...");
//        displayUMLMenu();
//        processUMLMenuInput(sc.nextLine());
//        return;
//      case "2":
//        Help.printHelpMenu();
//        break;
//      case "3":
//        System.out.println("About: This application was built using JavaFX. ");
//        break;
//      case "4":
//        System.out.println("Exiting the menu...");
//        System.exit(0);   // Terminate the application.
//        break;
//      default:
//        System.out.println("Invalid choice. Please try again.");
//    }
//
//    displayMainMenu();  // Re-display the menu after processing input.
//    processMainMenuInput(sc.nextLine());
//  }
  public static void processMainMenuInput(String input) {
    switch (input) {
      case "1":
        displayUMLMenu();
        break;
      case "2":
        Help.printHelpMenu();
        break;
      case "3":
        System.out.println("About: This application was built using JavaFX.");
        break;
      case "4":
        System.out.println("Exiting the menu...");
        Platform.exit();  // Properly exit the JavaFX application
        break;
      default:
        System.out.println("Invalid choice. Please try again.");
        displayMainMenu();  // Redisplay the menu after invalid input
        break;
    }
  }

  //  public static void displayUMLMenu() {
//    System.out.println("+-------------------------------------+");
//    System.out.println("|            UML Menu                 |");
//    System.out.println("+-------------------------------------+");
//    System.out.println("| 1.  Class                           |");
//    System.out.println("| 2.  Field                           |");
//    System.out.println("| 3.  Method                          |");
//    System.out.println("| 4.  Display                         |");
//    System.out.println("| 5.  Save UML Diagram                |");
//    System.out.println("| 6.  Load UML Diagram                |");
//    System.out.println("| 7.  Return to Main Menu             |");
//    System.out.println("+-------------------------------------+");
//    System.out.println("Enter your choice:");
//  }
  public static void displayUMLMenu() {
    Platform.runLater(() -> {
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
    });
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
        MenuAlpha.displayMainMenu();
        MenuAlpha.processFieldMenuInput(sc.nextLine());
        return;
      case "3":
        System.out.println("Open Method menu ");
        MenuAlpha.displayMethodMenu();
        MenuAlpha.processMethodMenuInput(sc.nextLine());
        return;
      case "4":
        System.out.println("Open Display menu ");
        MenuAlpha.displayDisplayMenu();
        MenuAlpha.processDisplayMenuInput(sc.nextLine());
        return;
      case "5":
        saveJSONFile();  // Call save JSON method
        break;
      case "6":
        loadJSONFile();  // Call load JSON method
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

  public static void displayClassMenu() {
    Platform.runLater(() -> {
      System.out.println("+-------------------------------------+");
      System.out.println("|            UML Menu: Class          |");
      System.out.println("+-------------------------------------+");
      System.out.println("| 1.  Add Class                       |");
      System.out.println("| 2.  Delete Class                    |");
      System.out.println("| 3.  Rename Class                    |");
      System.out.println("| 4.  Return                          |");
      System.out.println("+-------------------------------------+");
      System.out.print("Enter your choice: ");
    });
  }

  public static void processClassMenuInput(String input) {
    switch (input) {
      case "1":
        System.out.println("Add Class: ");
        String className = sc.nextLine();
        classes.addClass(String.valueOf(new UMLClass(className))); //<-- Shane wuz here(extra param was not needed)
        System.out.println("Class added: " + className);
        break;
      case "2":
        System.out.println("Delete Class: ");
        String classToDelete = sc.nextLine();
        classes.removeClass(classToDelete);
        System.out.println("Class deleted: " + classToDelete);
        break;
      case "3":
        System.out.println("Rename Class: ");
        String oldName = sc.nextLine();
        String newName = sc.nextLine();
        classes.renameClass(oldName, newName);
        System.out.println("Class renamed from " + oldName + " to " + newName);
        break;
      case "4":
        System.out.println("Returning to UML Menu...");
        displayUMLMenu();
        processUMLMenuInput(sc.nextLine());
        return;
      default:
        System.out.println("Invalid choice. Please try again.");
        break;
    }
    displayClassMenu();  // Re-display the menu after processing input.
    processClassMenuInput(sc.nextLine());
  }

  public static void displayFieldMenu() {
    Platform.runLater(() -> {
      System.out.println("+-------------------------------------+");
      System.out.println("|            UML Menu: Field          |");
      System.out.println("+-------------------------------------+");
      System.out.println("| 1.  Add Field                       |");
      System.out.println("| 2.  Delete Field                    |");
      System.out.println("| 3.  Rename Field                    |");
      System.out.println("| 4.  Return                          |");
      System.out.println("+-------------------------------------+");
      System.out.print("Enter your choice: ");
    });
  }

  public static void processFieldMenuInput(String input) {
    switch (input) {
      case "1":
        System.out.println("Add Field: ");
        // add field method
        System.out.println("------------ run addField method -----------");
        break;
      case "2":
        System.out.println("Delete Field: ");
        // delete field method
        System.out.println("------------ run deleteField method -----------");
        break;
      case "3":
        System.out.println("Rename Field: ");
        // rename field method
        System.out.println("------------ run renameField method -----------");
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

  public static void displayMethodMenu() {
    Platform.runLater(() -> {
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
    });
  }

  public static void processMethodMenuInput(String input) {
    switch (input) {
      case "1":
        System.out.println("Add Method: ");
        // addMethod method
        System.out.println("------------ run addMethod method -----------");
        break;
      case "2":
        System.out.println("Delete Method: ");
        // deleteMethod method
        System.out.println("------------ run deleteMethod -----------");
        break;
      case "3":
        System.out.println("Rename Method: ");
        // renameMethod method
        System.out.println("------------ run renameMethod -----------");
        break;
      case "4":
        System.out.println("Add Method Parameter: ");
        // addMethodParameter method
        System.out.println("------------ run addMethodParameter method -----------");
        break;
      case "5":
        System.out.println("Remove Method Parameter: ");
        // removeMethodParameter method
        System.out.println("------------ run removeMethodParameter method -----------");
        break;
      case "6":
        System.out.println("Update Method Parameter: ");
        // updateMethodParameter method
        System.out.println("------------ run upMethod -----------");
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

  public static void displayDisplayMenu() {
    Platform.runLater(() -> {
    System.out.println("+-------------------------------------------+");
    System.out.println("|            UML Menu: Display              |");
    System.out.println("+-------------------------------------------+");
    System.out.println("| 1.  Display Single Class and Its Contents |");
    System.out.println("| 2.  Display All Classes and Contents      |");
    System.out.println("| 3.  Return                                |");
    System.out.println("+-------------------------------------------+");
    System.out.print("Enter your choice: ");
    });
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
  // Example methods for save/load JSON functionality

  /**
   * Saves the current UML data to a JSON file.
   */
  public static void saveJSONFile() {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    try (FileWriter writer = new FileWriter("uml_diagram.json")) {
      gson.toJson(classes, writer);  // Serialize UMLComponentManager to JSON
      System.out.println("Successfully saved UML diagram to uml_diagram.json");
    } catch (IOException e) {
      System.out.println("Error saving UML diagram: " + e.getMessage());
    }
  }

  /**
   * Loads the UML data from a JSON file.
   */
  public static void loadJSONFile() {
    Gson gson = new Gson();
    try (FileReader reader = new FileReader("uml_diagram.json")) {
      classes = gson.fromJson(reader,
        UMLComponentManager.class);  // Deserialize JSON to UMLComponentManager
      System.out.println("Successfully loaded UML diagram from uml_diagram.json");
    } catch (IOException e) {
      System.out.println("Error loading UML diagram: " + e.getMessage());
    }
  }
}
