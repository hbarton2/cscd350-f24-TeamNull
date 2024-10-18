package proj.TeamNull.UMLdevkit.reference.UIhandler;

import java.util.function.Consumer;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import proj.TeamNull.UMLdevkit.reference.Menu.Menu;

/**
 * This class launches the terminal and utilizes JSON to store input data
 */
public class TerminalHandler {

//  @FXML
//  private TextArea terminalOutput;
//
//  @FXML
//  private TextField terminalInput;
//
//  public TerminalHandler() {
//    Menu.setTerminalHandler(this);  // Pass this TerminalHandler instance to Menu
//  }
//
//  @FXML
//  public void initialize() {
//    displayInitialMenu();
//  }
//
//  @FXML
//  private void handleTerminalInput() {
//    String input = terminalInput.getText().trim();
//
//    if (!input.isEmpty()) {
//      terminalInput.clear();  // Clear the input field
//      printToTerminal("User: " + input);
//
//      // Pass the input to the menu for processing
//      Menu.processMainMenuInput(input);
//    }
//  }
//
//  private void displayInitialMenu() {
//    Menu.displayMainMenu();  // Display the main menu
//  }
//
//  // Method to print output to JavaFX terminal
//  public void printToTerminal(String message) {
//    Platform.runLater(() -> terminalOutput.appendText(message + "\n"));
//  }

  @FXML
  private TextArea terminalOutput;

  @FXML
  private TextField terminalInput;

  public TerminalHandler() {
    Menu.setTerminalHandler(this);  // Set the TerminalHandler instance in the Menu class
  }

  @FXML
  public void initialize() {
    Menu.displayMainMenu();  // Display the initial main menu in the terminal
  }

  @FXML
  private void handleTerminalInput() {
    String input = terminalInput.getText().trim();  // Get user input

    if (!input.isEmpty()) {
      terminalInput.clear();  // Clear the input field

      // Print the user input to the terminal
      printToTerminal("User: " + input);

      // Process the input in the menu (adjust according to which menu is currently active)
      Menu.processMainMenuInput(input);  // Start by processing the main menu
    }
  }

  public void printToTerminal(String message) {
    terminalOutput.appendText(message + "\n");  // Append message to the TextArea (JavaFX terminal)
  }

  public void waitForInput(Consumer<String> inputHandler) {
    terminalInput.setOnAction(event -> {
      String input = terminalInput.getText().trim();
      terminalInput.clear();  // Clear the input field
      if (!input.isEmpty()) {
        printToTerminal("User: " + input);
        inputHandler.accept(input);  // Pass the input to the provided handler method
      }
    });
  }

}
