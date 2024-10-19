package proj.TeamNull.UMLdevkit.utilities;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Stores UML commands as hash table
 */
public class Commands {

  /**
   * Hashmap< key , value >
   *   Key = parsed user input into known commands
   *   value = function/method call from Function class
   */
  private HashMap<String, String> commands;

  Commands() {
    commands = new HashMap<>();
  }

  //TODO: store command names somewhere. Somewhere between Parser and ActionHandler

  //TODO:
}
