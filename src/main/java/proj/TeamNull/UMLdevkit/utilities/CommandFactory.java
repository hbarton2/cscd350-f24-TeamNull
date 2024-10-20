package proj.TeamNull.UMLdevkit.utilities;

/**
 * does this bring back 212 memories if not here something you can study upon
 * <a href="https://refactoring.guru/design-patterns/factory-method">...</a>
 */

public class CommandFactory {

  // Factory method to create command actions based on the command type
  public static CommandAction createCommand(String type) {
    if (type == null || type.isEmpty()) {
      System.out.println("Error: Command type cannot be null or empty.");
      return null;
    }

    switch (type) {
      case "createClass":
        return args -> {
          if (args.length == 1) {
            Functions.createClass(args[0]);
          } else {
            System.out.println("Error: Incorrect number of arguments for creating a class.");
          }
        };

      case "removeClass":
        return args -> {
          if (args.length == 1) {
            Functions.removeClass(args[0]);
          } else {
            System.out.println("Error: Incorrect number of arguments for removing a class.");
          }
        };

      case "renameClass":
        return args -> {
          if (args.length == 2) {
            Functions.renameClass(args[0], args[1]);
          } else {
            System.out.println("Error: Provide both old and new class names.");
          }
        };

      default:
        System.out.println("Error: Unknown command type: " + type);
        return null;  // Return null if the command type doesn't match anything known
    }
  }
}