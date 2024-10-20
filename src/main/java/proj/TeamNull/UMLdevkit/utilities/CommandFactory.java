package proj.TeamNull.UMLdevkit.utilities;

/**
 * does this bring back 212 memories if not here something you can study upon
 * <a href="https://refactoring.guru/design-patterns/factory-method">...</a>
 */

public class CommandFactory {

  // Inner class to handle general command execution
  public static class GeneralCommandAction implements CommandAction {

    private String commandType;

    public GeneralCommandAction(String commandType) {
      this.commandType = commandType;
    }

    @Override
    public void execute(String[] args) {
      if (args.length == 2) {
        String oldName = args[0];
        String newName = args[1];

        // Check if the class exists before renaming
        if (Functions.classExists(oldName)) {
          Functions.renameClass(oldName, newName);
          System.out.println("Class " + oldName + " renamed to " + newName);
        } else {
          System.out.println("Error: Class " + oldName + " does not exist.");
        }
      } else {
        System.out.println("Error: Provide both old and new class names.");
      }
    }
  }

  // Factory method to create command actions based on type
  public static CommandAction createCommand(String type) {
    return switch (type) {
      case "CreateClassCommand", "RemoveClassCommand", "RenameClassCommand" ->
        new GeneralCommandAction(type);  // Return general command action
      default -> throw new IllegalArgumentException("Unknown command type: " + type);
    };
  }
}