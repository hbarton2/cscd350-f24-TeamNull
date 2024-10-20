package proj.TeamNull.UMLdevkit.utilities;

import java.util.Scanner;

/**
 * Everything we need to display this class handles it.
 * - Look, Fonts, Sizes
 */
public class Display {

  private Commands commandRegistry;
  private ParsingInputs parser;
  private boolean running = true;

  public Display() {
    commandRegistry = new Commands();  // Command registry initialized from GSON
    parser = new ParsingInputs(commandRegistry);  // Parser instance
  }

  // Entry method to start the program
  public void start() {
    System.out.println("Welcome to the UML Editor!");

    // Create a single Scanner instance to reuse
    Scanner input = new Scanner(System.in);

    while (running) {
      System.out.print(">> ");
      String userInput = input.nextLine();

      // Handle exit command
      if (userInput.equalsIgnoreCase("exit")) {
        System.out.println("Exiting the UML Editor. Goodbye!");
        running = false;
        break;  // Exit the loop and terminate
      }

      // Pass the input to the parser for processing
      parser.readInput(userInput);

      // After processing, check if there was a valid command executed
      if (userInput.trim().isEmpty()) {
        System.out.println("Please enter a command.");
      }
    }

    input.close();  // Close the scanner when done
  }
}
