package umleditor.controller.utilities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.TreeMap;

/**
 * All the Commands are stored here
 * Hashmap O(1) (no sort function but could be sorted by user before storage)
 * TreeMap O(log n) but balanced and sorted RBT
 */
public class Commands {

//  private final HashMap<String, CommandAction> commands;  // Stores commands
//  private final HashMap<String, CommandDefinition> commandDefinitions;  // Stores command definitions (types and descriptions)
//  private final Gson gson;
//
//  // Constructor
//  public Commands() {
//    this.commands = new HashMap<>();  // Initialize the commands HashMap
//    this.commandDefinitions = new HashMap<>();  // Initialize the command definitions HashMap
//    this.gson = new Gson();
//    loadCommands();  // Load commands from JSON
//    addHelpCommand();  // Add help command
//  }

  private final TreeMap<String, CommandAction> commands;  // Stores commands in sorted order
  private final TreeMap<String, CommandDefinition> commandDefinitions;  // Stores command definitions in sorted order
  private final Gson gson;

  // Constructor
  public Commands() {
    this.commands = new TreeMap<>();  // Initialize as TreeMap for sorted order
    this.commandDefinitions = new TreeMap<>();  // Initialize as TreeMap for sorted order
    this.gson = new Gson();
    loadCommands();  // Load commands from JSON
    addHelpCommand();  // Add help command
  }

  public void loadCommands() {
    String commandsFilePath = "/commands.json";  // Path relative to the resources directory in the JAR
    System.out.println("Loading commands from: " + commandsFilePath);

    try (InputStreamReader reader = new InputStreamReader(
      Objects.requireNonNull(getClass().getResourceAsStream(commandsFilePath)))) {
      Type commandMapType = new TypeToken<HashMap<String, CommandDefinition>>() {
      }.getType();
      HashMap<String, CommandDefinition> rawCommands = gson.fromJson(reader, commandMapType);

      for (String key : rawCommands.keySet()) {
        CommandDefinition commandDef = rawCommands.get(key);
        CommandAction command = CommandFactory.createCommand(commandDef.type);
        commands.put(key, command);  // Store the action
        commandDefinitions.put(key, commandDef);  // Store the definition with description
      }
    } catch (IOException e) {
      System.err.println("Error: Could not load commands from " + commandsFilePath);
    }
  }

  // Helper class to match the structure of each command in JSON
  private static class CommandDefinition {

    String type;
    String description;
  }

  // Add help command manually
  private void addHelpCommand() {
    commands.put("help", args -> {
      if (args.length == 0) {
        displayHelp();
      } else {
        System.out.println("Error: 'help' command does not take arguments.");
      }
    });
  }

  // Display the list of commands and their descriptions
  public void displayHelp() {
    System.out.println("Available Commands:");
    for (String command : commandDefinitions.keySet()) {
      System.out.println("- " + command + ": " + commandDefinitions.get(command).description);
    }
//    System.out.println("- exit: exit the program at any time");
  }

  // Fetch a command by name
  public CommandAction getCommand(String commandKey) {
    return commands.getOrDefault(commandKey, null);  // Return null if the command doesn't exist
  }

  //Returns list of strings of all command names
  public ArrayList<String> getAllCommandNames() {
    return new ArrayList<>(commandDefinitions.keySet());
  }
}
