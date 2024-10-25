package proj.TeamNull.UMLdevkit.utilities;


public class GeneralCommandAction implements CommandAction {

  private final String actionType;

  public GeneralCommandAction(String actionType) {
    this.actionType = actionType;
  }

  @Override
  public void execute(String[] args) {
    switch (actionType) {
      case "CreateClassCommand":
        if (args.length > 0) {
          String className = args[0];
          Functions.createClass(className);
        } else {
          System.out.println("Error: Class name not provided.");
        }
        break;

      case "RemoveClassCommand":
        if (args.length > 0) {
          String className = args[0];
          Functions.removeClass(className);
        } else {
          System.out.println("Error: Class name not provided.");
        }
        break;

      case "RenameClassCommand":
        if (args.length == 2) {
          String oldName = args[0];
          String newName = args[1];
          Functions.renameClass(oldName, newName);
        } else {
          System.out.println("Error: Provide both old and new class names.");
        }
        break;

      default:
        System.out.println("Unknown command action: " + actionType);
    }
  }
}
