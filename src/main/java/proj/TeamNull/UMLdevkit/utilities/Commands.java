package proj.TeamNull.UMLdevkit.utilities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Stores UML commands and integrates GSON for loading commands from JSON
 */
public class Commands {

  private HashMap<String, CommandAction> commands;
  private String commandsFilePath;
  private Gson gson;

  // Default constructor: uses the original file path
  public Commands() {
    this("commands.json");  // Load from classpath
  }

  // Constructor that allows custom file path (useful for testing)
  public Commands(String commandsFilePath) {
    this.commandsFilePath = commandsFilePath;
    commands = new HashMap<>();
    gson = new Gson();
    loadCommands();  // Load commands from JSON
  }

  // Method to load commands from the JSON file
  public void loadCommands() {
    try (InputStream inputStream = getClass().getClassLoader()
      .getResourceAsStream(commandsFilePath);
      InputStreamReader reader = new InputStreamReader(inputStream)) {

      Type commandMapType = new TypeToken<HashMap<String, HashMap<String, String>>>() {
      }.getType();
      HashMap<String, HashMap<String, String>> rawCommands = gson.fromJson(reader, commandMapType);

      for (String key : rawCommands.keySet()) {
        String type = rawCommands.get(key).get("type");
        CommandAction command = CommandFactory.createCommand(type);
        commands.put(key, command);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Fetch a command by name
  public CommandAction getCommand(String commandKey) {
    return commands.getOrDefault(commandKey, null);
  }
}
