package proj.TeamNull.UMLdevkit.reference.UIhandler;

import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import proj.TeamNull.UMLdevkit.reference.Menu.Menu;

/**
 * @class This class launches the terminal and utilize JSON to store input data
 */

public class TerminalHandlerAlpha {

  @FXML
  private TextArea terminalOutput;

  @FXML
  private TextField terminalInput;

  private final Gson gson;

  public TerminalHandlerAlpha() {
    this.gson = new Gson();  // Initialize Gson instance
    Menu menu = new Menu();  // Initialize the Menu class
  }

  @FXML
  public void initialize() {
    displayInitialMenu();
  }

  @FXML
  private void handleTerminalInput() {
    String input = terminalInput.getText().trim();

    if (!input.isEmpty()) {
      terminalInput.clear();  // Clear the input field
      printToTerminal("User: " + input);

      // Serialize the input to JSON and print it to the terminal
      String jsonInput = gson.toJson(input);
      printToTerminal("JSON Input: " + jsonInput);

      // Run the menu processing in a background thread
      new Thread(() -> {
        // Pass the input to the menu for processing
        Menu.processMainMenuInput(input);

        // After processing, you may need to update the terminal output or display the next menu.
        // Ensure UI updates are done on the JavaFX Application Thread.
        Platform.runLater(() -> {
          printToTerminal("Menu processing completed.");
          Menu.displayMainMenu();
        });
      }).start();
    }
  }


  private void displayInitialMenu() {
    Platform.runLater(Menu::displayMainMenu);
  }

  private void printToTerminal(String message) {
    Platform.runLater(() -> terminalOutput.appendText(message + "\n"));
  }
}
