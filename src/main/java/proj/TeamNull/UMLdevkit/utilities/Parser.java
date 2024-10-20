package proj.TeamNull.UMLdevkit.utilities;

/**
 * Deal with user Inputs all the user input get parsed here and ready for action
 */

public class Parser {

  private String userInput;  // Store raw input
  private Commands commandRegistry;  // Reference to Commands class

  // Constructor
  public Parser(Commands commandRegistry) {
    this.commandRegistry = new Commands();  // Initialize Commands from GSON
  }

  // Method to set the user input
  public void readInput(String input) {
    this.userInput = input;
  }

  // Step 1: Parse the input into a command and arguments
  public void parseInput() {
    // Split the input into command key and arguments
    String[] tokens = userInput.split("\\s+");
    String commandKey = tokens[0];  // First token is the command (e.g., 'mkc')
    String[] args = new String[tokens.length - 1];
    System.arraycopy(tokens, 1, args, 0, args.length);  // Extract arguments

    // Step 2: Get the command from the Commands class
    CommandAction command = commandRegistry.getCommand(commandKey);

    if (command != null) {
      command.execute(args);  // Execute the command with arguments
    } else {
      System.out.println("Unknown command: " + commandKey);
    }
  }
}
