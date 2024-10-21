package proj.TeamNull.UMLdevkit.utilities;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class Commands {

  private HashMap<String, CommandAction> commands;  // Stores commands
  private String commandsFilePath = "src/main/resources/proj/TeamNull/UMLdevkit/commands.json";  // Path to JSON file
  private Gson gson;

  // Constructor
  public Commands() {
    this.commands = new HashMap<>();  // Initialize the commands HashMap
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
        commands.put(key, command);
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
    for (String command : commands.keySet()) {
      System.out.println("- " + command + ": " + getCommandDescription(command));
    }
  }

  private String getCommandDescription(String commandKey) {
    // You could store descriptions in the CommandDefinition and pull them from there
    switch (commandKey) {
      case "mkc":
        return "Creates a new class. Usage: mkc <class_name>";
      case "rm":
        return "Removes a class. Usage: rm <class_name>";
      case "rn":
        return "Renames a class. Usage: rn <old_class_name> <new_class_name>";
      case "help":
        return "Displays this help message.";
      default:
        return "Unknown command.";
    }
  }

  // Fetch a command by name
  public CommandAction getCommand(String commandKey) {
    return commands.getOrDefault(commandKey, null);  // Return null if the command doesn't exist
  }
}

