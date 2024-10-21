package proj.TeamNull.UMLdevkit.utilities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class Commands {

  private HashMap<String, CommandAction> commands;  // Stores commands
  private HashMap<String, CommandDefinition> commandDefinitions;  // Stores command definitions (types and descriptions)
  private String commandsFilePath = "src/main/resources/proj/TeamNull/UMLdevkit/commands.json";  // Path to JSON file
  private Gson gson;

  // Constructor
  public Commands() {
    this.commands = new HashMap<>();  // Initialize the commands HashMap
    this.commandDefinitions = new HashMap<>();  // Initialize the command definitions HashMap
    this.gson = new Gson();
    loadCommands();  // Load commands from JSON
    addHelpCommand();  // Add help command
  }

  // Method to load commands from the JSON file
  public void loadCommands() {
    System.out.println("Loading commands from: " + commandsFilePath);
    try (FileReader reader = new FileReader(commandsFilePath)) {
      Type commandMapType = new TypeToken<HashMap<String, CommandDefinition>>() {}.getType();
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
  private class CommandDefinition {
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
    System.out.println("- exit: exit the program at any time");
  }

  // Fetch a command by name
  public CommandAction getCommand(String commandKey) {
    return commands.getOrDefault(commandKey, null);  // Return null if the command doesn't exist
  }
}
