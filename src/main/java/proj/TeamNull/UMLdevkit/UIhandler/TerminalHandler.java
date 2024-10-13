package proj.TeamNull.UMLdevkit.UIhandler;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.PrintStream;
import java.util.Scanner;
import proj.TeamNull.UMLdevkit.Menu.Menu;

public class TerminalHandler {

  @FXML
  private TextArea terminalOutput;

  @FXML
  private TextField terminalInput;

  private final PrintStream standardOut;
  private final Menu menu;

  public TerminalHandler() {
    standardOut = System.out;
    menu = new Menu();  // Initialize the Menu class.
  }

  @FXML
  public void initialize() {
    redirectSystemOut();
    startMenu();  // Start the menu immediately.
  }

  @FXML
  private void handleTerminalInput() {
    String input = terminalInput.getText();
    if (!input.isBlank()) {
      System.out.println("User: " + input);  // Print user input to terminal.
      terminalInput.clear();  // Clear the input field.

      menu.processInput(input);  // Send input to the menu for processing.
    }
  }

  private void redirectSystemOut() {
    PrintStream customOut = new PrintStream(System.out) {
      @Override
      public void println(String message) {
        standardOut.println(message);  // Print to IDE console.
        updateTerminalOutput(message);  // Update JavaFX terminal.
      }
    };

    System.setOut(customOut);
    System.setErr(customOut);
  }

  private void updateTerminalOutput(String message) {
    Platform.runLater(() -> terminalOutput.appendText(message + "\n"));
  }

  private void startMenu() {
    // Launch the menu in a new thread.
    new Thread(() -> {
      Scanner scanner = new Scanner(System.in);
      menu.displayMenu();  // Display the initial menu.

      while (scanner.hasNextLine()) {
        String input = scanner.nextLine();
        menu.processInput(input);  // Handle input via the Menu class.
      }
    }).start();
  }
}
