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
  }

  // Method to load commands from the JSON file
//  public void loadCommands() {
//    System.out.println("Loading commands from: " + commandsFilePath);
//    try (FileReader reader = new FileReader(commandsFilePath)) {
//      Type commandMapType = new TypeToken<HashMap<String, HashMap<String, String>>>() {
//      }.getType();
//      HashMap<String, HashMap<String, String>> rawCommands = gson.fromJson(reader, commandMapType);
//
//      for (String commandKey : rawCommands.keySet()) {
//        String commandType = rawCommands.get(commandKey).get("action");
//        CommandAction commandAction = CommandFactory.createCommand(commandType);
//
//        // Ensure commandAction is not null before putting it in the map
//        if (commandAction != null) {
//          commands.put(commandKey, commandAction);
//        } else {
//          System.err.println("Error: No command found for " + commandKey);
//        }
//      }
//    } catch (IOException e) {
//      System.err.println("Error: Could not load commands from " + commandsFilePath);
//    }
//  }
  // Method to load commands from the JSON file
  // Method to load commands from the JSON file
  public void loadCommands() {
    System.out.println("Loading commands from: " + commandsFilePath);
    try (FileReader reader = new FileReader(commandsFilePath)) {
      // Define the type that matches the structure of the JSON
      Type commandMapType = new TypeToken<HashMap<String, HashMap<String, HashMap<String, String>>>>(){}.getType();
      HashMap<String, HashMap<String, HashMap<String, String>>> rawCommands = gson.fromJson(reader, commandMapType);

      // Access the "commands" section of the JSON
      HashMap<String, HashMap<String, String>> commandsData = rawCommands.get("commands");

      for (String key : commandsData.keySet()) {
        String type = commandsData.get(key).get("type");
        if (type != null && !type.isEmpty()) {
          CommandAction command = CommandFactory.createCommand(type);
          commands.put(key, command);
        } else {
          System.out.println("Error: Command type is null or empty for key: " + key);
        }
      }
    } catch (IOException e) {
      System.err.println("Error: Could not load commands from " + commandsFilePath);
    } catch (JsonSyntaxException e) {
      e.printStackTrace();
      System.err.println("Error: JSON structure is invalid or doesn't match the expected format.");
    }
  }



  // Fetch a command by name
  public CommandAction getCommand(String commandKey) {
    return commands.getOrDefault(commandKey,
      args -> System.out.println("Unknown command: " + commandKey));
  }
}
