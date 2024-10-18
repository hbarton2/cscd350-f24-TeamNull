package proj.TeamNull.UMLdevkit.reference.Menu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Platform;
import proj.TeamNull.UMLdevkit.reference.UMLComponent.UMLComponentManager;
import proj.TeamNull.UMLdevkit.reference.UIhandler.TerminalHandler;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Menu Class to handle user input through menu operations
 * Class should have very little logic implemented, almost all high level logic should be handled by method calls
 * outside of this class.
 * <p>
 * TODO Refactor menu to be command line, list commands, user types in command they wish to execute.
 */
public class Menu {

  private static UMLComponentManager classes = new UMLComponentManager();
  private static TerminalHandler terminalHandler;  // Instance of TerminalHandler

  // Inject TerminalHandler instance
  public static void setTerminalHandler(TerminalHandler handler) {
    terminalHandler = handler;
  }

  public static void displayMainMenu() {
    String menu = "+-----------------------------+\n" +
      "|       Main Menu             |\n" +
      "+-----------------------------+\n" +
      "| 1. UML Diagram Menu         |\n" +
      "| 2. Help                     |\n" +
      "| 3. About                    |\n" +
      "| 4. Exit                     |\n" +
      "+-----------------------------+\n" +
      "Enter your choice: ";
    printToTerminal(menu);
  }

  
  public static void processMainMenuInput(String input) {
    switch (input) {
      case "1":
        displayUMLMenu();
        break;
      case "2":
        printToTerminal("Help Menu: This application is used to create UML Diagrams.");
        break;
      case "3":
        printToTerminal("About: This application was built using JavaFX.");
        break;
      case "4":
        printToTerminal("Exiting the menu...");
        Platform.exit();  // Properly exit the JavaFX application
        break;
      default:
        printToTerminal("Invalid choice. Please try again.");
        displayMainMenu();  // Redisplay the menu after invalid input
        break;
    }
  }

  public static void displayUMLMenu() {
    String umlMenu = "+-------------------------------------+\n" +
      "|            UML Menu                 |\n" +
      "+-------------------------------------+\n" +
      "| 1.  Class                           |\n" +
      "| 2.  Field                           |\n" +
      "| 3.  Method                          |\n" +
      "| 4.  Display                         |\n" +
      "| 5.  Save UML Diagram                |\n" +
      "| 6.  Load UML Diagram                |\n" +
      "| 7.  Return to Main Menu             |\n" +
      "+-------------------------------------+\n" +
      "Enter your choice: ";
    printToTerminal(umlMenu);

    // Wait for the user's input and call processUMLMenuInput()
    terminalHandler.waitForInput(Menu::processUMLMenuInput);  // Capture the input in processUMLMenuInput
  }

  public static void processUMLMenuInput(String input) {
    switch (input) {
      case "1":
        displayClassMenu();
        break;
      case "2":
        displayFieldMenu();
        break;
      case "3":
        displayMethodMenu();
        break;
      case "4":
        displayDisplayMenu();
        break;
      case "5":
        saveJSONFile();  // Call save JSON method
        break;
      case "6":
        loadJSONFile();  // Call load JSON method
        break;
      case "7":
        displayMainMenu();
        break;
      default:
        printToTerminal("Invalid choice. Please try again.");
        displayUMLMenu();  // Re-display the menu after processing input
        break;
    }
  }

  public static void displayClassMenu() {
    String classMenu = "+-------------------------------------+\n" +
      "|            UML Menu: Class          |\n" +
      "+-------------------------------------+\n" +
      "| 1.  Add Class                       |\n" +
      "| 2.  Delete Class                    |\n" +
      "| 3.  Rename Class                    |\n" +
      "| 4.  Return                          |\n" +
      "+-------------------------------------+\n" +
      "Enter your choice: ";
    printToTerminal(classMenu);
    // Wait for user input and pass it to processClassMenuInput
    terminalHandler.waitForInput(Menu::processClassMenuInput);
  }

  public static void processClassMenuInput(String input) {
    switch (input) {
      case "1":
        printToTerminal("Enter class name to add: ");
        terminalHandler.waitForInput(className -> {
          classes.addClass(className);
          printToTerminal("Class added: " + className);
          displayClassMenu();  // Redisplay the menu
        });
        break;
      case "2":
        printToTerminal("Enter class name to delete: ");
        terminalHandler.waitForInput(className -> {
          classes.removeClass(className);
          printToTerminal("Class deleted: " + className);
          displayClassMenu();  // Redisplay the menu
        });
        break;
      case "3":
        printToTerminal("Enter old class name: ");
        terminalHandler.waitForInput(oldName -> {
          printToTerminal("Enter new class name: ");
          terminalHandler.waitForInput(newName -> {
            classes.renameClass(oldName, newName);
            printToTerminal("Class renamed from " + oldName + " to " + newName);
            displayClassMenu();  // Redisplay the menu
          });
        });
        break;
      case "4":
        displayUMLMenu();  // Return to UML menu
        break;
      default:
        printToTerminal("Invalid choice. Please try again.");
        displayClassMenu();  // Redisplay the menu
        break;
    }
  }

  public static void displayFieldMenu() {
    String fieldMenu = "+-------------------------------------+\n" +
      "|            UML Menu: Field          |\n" +
      "+-------------------------------------+\n" +
      "| 1.  Add Field                       |\n" +
      "| 2.  Delete Field                    |\n" +
      "| 3.  Rename Field                    |\n" +
      "| 4.  Return                          |\n" +
      "+-------------------------------------+\n" +
      "Enter your choice: ";
    printToTerminal(fieldMenu);
    // Wait for user input and pass it to processFieldMenuInput
    terminalHandler.waitForInput(Menu::processFieldMenuInput);
  }

  public static void processFieldMenuInput(String input) {
    switch (input) {
      case "1":
        printToTerminal("Add Field: ");
        printToTerminal("------------ run addField method -----------");
        break;
      case "2":
        printToTerminal("Delete Field: ");
        printToTerminal("------------ run deleteField method -----------");
        break;
      case "3":
        printToTerminal("Rename Field: ");
        printToTerminal("------------ run renameField method -----------");
        break;
      case "4":
        printToTerminal("Returning to UML Menu...");
        displayUMLMenu();  // Return to UML menu
        break;
      default:
        printToTerminal("Invalid choice. Please try again.");
        displayFieldMenu();  // Redisplay the menu
        break;
    }
  }

  public static void displayMethodMenu() {
    String methodMenu = "+-------------------------------------+\n" +
      "|            UML Menu: Method         |\n" +
      "+-------------------------------------+\n" +
      "| 1.  Add Method                      |\n" +
      "| 2.  Delete Method                   |\n" +
      "| 3.  Rename Method                   |\n" +
      "| 4.  Add Method Parameter            |\n" +
      "| 5.  Remove Method Parameter         |\n" +
      "| 6.  Update Method Parameter         |\n" +
      "| 7.  Return                          |\n" +
      "+-------------------------------------+\n" +
      "Enter your choice: ";
    printToTerminal(methodMenu);
    // Wait for user input and pass it to processMethodMenuInput
    terminalHandler.waitForInput(Menu::processMethodMenuInput);
  }

  public static void processMethodMenuInput(String input) {
    switch (input) {
      case "1":
        printToTerminal("Add Method: ");
        printToTerminal("------------ run addMethod method -----------");
        break;
      case "2":
        printToTerminal("Delete Method: ");
        printToTerminal("------------ run deleteMethod method -----------");
        break;
      case "3":
        printToTerminal("Rename Method: ");
        printToTerminal("------------ run renameMethod method -----------");
        break;
      case "4":
        printToTerminal("Add Method Parameter: ");
        printToTerminal("------------ run addMethodParameter method -----------");
        break;
      case "5":
        printToTerminal("Remove Method Parameter: ");
        printToTerminal("------------ run removeMethodParameter method -----------");
        break;
      case "6":
        printToTerminal("Update Method Parameter: ");
        printToTerminal("------------ run updateMethodParameter method -----------");
        break;
      case "7":
        printToTerminal("Returning to UML Menu...");
        displayUMLMenu();  // Return to UML menu
        break;
      default:
        printToTerminal("Invalid choice. Please try again.");
        displayMethodMenu();  // Redisplay the menu
        break;
    }
  }

  public static void displayDisplayMenu() {
    String displayMenu = "+-------------------------------------------+\n" +
      "|            UML Menu: Display              |\n" +
      "+-------------------------------------------+\n" +
      "| 1.  Display Single Class and Its Contents |\n" +
      "| 2.  Display All Classes and Contents      |\n" +
      "| 3.  Return                                |\n" +
      "+-------------------------------------------+\n" +
      "Enter your choice: ";
    printToTerminal(displayMenu);
    // Wait for user input and pass it to processDisplayMenuInput
    terminalHandler.waitForInput(Menu::processDisplayMenuInput);
  }

  public static void processDisplayMenuInput(String input) {
    switch (input) {
      case "1":
        printToTerminal("Display Single Class and Its Contents: ");
        // single class display method
        break;
      case "2":
        printToTerminal("Display All Classes and Contents: ");
        // display all classes and contents method
        break;
      case "3":
        printToTerminal("Returning to UML Menu...");
        displayUMLMenu();  // Return to UML menu
        break;
      default:
        printToTerminal("Invalid choice. Please try again.");
        displayDisplayMenu();  // Redisplay the menu
        break;
    }
  }

  // Example methods for save/load JSON functionality
  public static void saveJSONFile() {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    try (FileWriter writer = new FileWriter("uml_diagram.json")) {
      gson.toJson(classes, writer);  // Serialize UMLComponentManager to JSON
      printToTerminal("Successfully saved UML diagram to uml_diagram.json");
    } catch (IOException e) {
      printToTerminal("Error saving UML diagram: " + e.getMessage());
    }
  }

  public static void loadJSONFile() {
    Gson gson = new Gson();
    try (FileReader reader = new FileReader("uml_diagram.json")) {
      classes = gson.fromJson(reader, UMLComponentManager.class);  // Deserialize JSON to UMLComponentManager
      printToTerminal("Successfully loaded UML diagram from uml_diagram.json");
    } catch (IOException e) {
      printToTerminal("Error loading UML diagram: " + e.getMessage());
    }
  }

  // Utility method to print to terminal
  private static void printToTerminal(String message) {
    if (terminalHandler != null) {
      terminalHandler.printToTerminal(message);  // Output to JavaFX TextArea via TerminalHandler
    } else {
      System.out.println(message);  // Fallback to console if terminalHandler is not set
    }
  }
}
