package umleditor.sprint1.utilities;

import java.util.*;
/**
 * Everything we need to display this class handles it.
 * - Look, Fonts, Sizes
 */
public class Display {

  private final Commands commandRegistry;
  private final ParsingInputs parser;
  private final SimpleAutoComplete autoComplete;
  private boolean running = true;

  public Display() {
    commandRegistry = new Commands();  // Command registry initialized from GSON
    parser = new ParsingInputs(commandRegistry);  // Parser instance
    List<String> commandOptions = commandRegistry.getAllCommandNames(); //list of all command names
    autoComplete = new SimpleAutoComplete(commandOptions);
  }

  /**
   * while the program is running, it is calling readInputWithAutocomplete, in SimpleAutoComplete class
   * this only will take effect if the terminal is not 'dumb'. When user types keyword 'exit', loop breaks
   * and program terminates.
   */
  public void start() {
    System.out.println("Welcome to the UML Editor!");
    commandRegistry.displayHelp();

    while (running) {
      String userInput = autoComplete.readInputWithAutocomplete();

      // Handle exit command
      if (userInput.equalsIgnoreCase("exit")) {
        System.out.println("Exiting the UML Editor. Goodbye!");
        running = false;
      }
      else {
        // Pass the input to the parser for processing
        parser.readInput(userInput);
      }
    }
  }
}
