package proj.TeamNull.UMLdevkit;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import proj.TeamNull.UMLdevkit.reference.Menu.Help;
import proj.TeamNull.UMLdevkit.reference.UMLComponent.UMLComponentManager;
import proj.TeamNull.UMLdevkit.reference.UIhandler.TerminalHandler;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
    private static Scanner sc;

    // Inject TerminalHandler instance
    public static void setTerminalHandler(TerminalHandler handler) {
        terminalHandler = handler;
    }


    /**
     * Menu of available commands.
     * First greets user on entering application,
     * then displays the available commands.
     * Prints to terminal.
     */
    public static void displayMenu(){
        String menu = "\nWelcome to UML Class Editor Project\n" +
                "\nPlease Type a Command from List of Available Commands. Press Enter and Follow On Screen Prompts" +
                "\n------------------------------------------------------------------------------------------------";
        printToTerminal(menu);
        displayCommands();
    }

    public static void displayCommands(){
        String commands =

                "\n------------------------------------------------------------------------------------------------"+
                        "\nAvailable commands are:" +
                        "\n......................."+
                        "\n\n Command                      Usage\n" +

                        "\n Create Class                 to create a new class"+
                        "\n List Class                   to display all class on the screen." +
                        "\n Rename Class                 to rename an existing class." +
                        "\n Delete Class                 to delete an existing class." +
                        "\n Help                         to display Help on commands." +
                        "\n Exit                         to close the application, or you can click on the type quit"+
                        "\n"+
                        "\n Type a command here: ";
        printToTerminal(commands);
    }

    /**
     * Handles the user commands
     * Takes the command, and calls the method to implement.
     * @param input user command
     */
    public static boolean processMenuInput(String input) {
        switch (input.toLowerCase()) {
            case "create class":
                //TODO: implement addClass method
                break;
            case "list class":
                //TODO: implement listClass method to display all classes to screen
                break;
            case "rename class":
                //TODO: implement renameClass method
                break;
            case "delete class":
                //TODO: implement deleteClass method
                break;
            case "help":
                Help.printHelpMenu();
                break;
            case "display commands":
                displayCommands();    // will only display commands to user on request for better visibility in terminal
                break;
            case ("exit"):
                System.out.println("Exiting UML Editor...");
                return false;  // indicate application should exit
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

        return true;
    }

    /**
     * startMenu method
     * While application is running it will continuously loop menu and choices
     * User choosing 'exit' command exits loop and application
     * to avoid stack overflow while running menu.
     * Moved exit condition here to avoid infinite loop.
     */
    public static void startMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        displayMenu();

        while (running) {
            String userInput = scanner.nextLine().trim();
            running = processMenuInput(userInput);  // Exit if processMenuInput returns false
        }

        // Exit the application once loop breaks
        System.exit(0);
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
