package proj.TeamNull.UMLdevkit.utilities;

public class ParsingInputs {

  private String userInput;  // Store raw input
  private final Commands commandRegistry;  // Reference to Commands class

  // Constructor
  public ParsingInputs(Commands commandRegistry) {
    this.commandRegistry = commandRegistry;  // Use the passed Commands object
  }

  // Method to set the user input
  public void readInput(String input) {
    if (input == null || input.equals("")) {
      System.out.println("Please enter a command.");
      return;
    }
    this.userInput = input;
    parseInput();  // Trigger parsing when input is received
  }

  // Step 1: Parse the input into a command and arguments
  public void parseInput() {
    String[] tokens = userInput.split("\\s+");
    String commandKey = tokens[0];  // First token is the command (e.g., 'mkc')
    String[] args = new String[tokens.length - 1];
    System.arraycopy(tokens, 1, args, 0, args.length);  // Extract arguments

    CommandAction command = commandRegistry.getCommand(commandKey);

    if (command != null) {
      command.execute(args);  // Execute the command with arguments
    } else {
      System.out.println("Unknown command: " + commandKey);
    }
  }
}