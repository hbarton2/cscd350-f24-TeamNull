package umleditor.model.utilities;

import umleditor.controller.utilities.CommandAction;
import umleditor.controller.utilities.Functions;

/**
 * CommandFactory class to create and handle various command actions.
 */

public class CommandFactory {

  // Factory method to create command actions based on the command type
  public static CommandAction createCommand(String type) {
    if (type == null || type.isEmpty()) {
      System.out.println("Error: Command type cannot be null or empty.");
      return null;
    }

    return switch (type) {
      case "createClass" -> args -> {
        if (args.length == 1) {
          Functions.createClass(args[0]);
        } else {
          System.out.println("Error: Incorrect number of arguments for creating a class.");
        }
      };
      case "removeClass" -> args -> {
        if (args.length == 1) {
          Functions.removeClass(args[0]);
        } else {
          System.out.println("Error: Incorrect number of arguments for removing a class.");
        }
      };
      case "renameClass" -> args -> {
        if (args.length == 2) {
          Functions.renameClass(args[0], args[1]);
        } else {
          System.out.println("Error: Provide both old and new class names.");
        }
      };
      case "addAttribute" -> args -> {
        if (args.length == 3) {
          Functions.addAttribute(args[0], args[1], args[2]);
        } else {
          System.out.println("Error: Provide class name, field type, and field name.");
        }
      };
      case "removeAttribute" -> args -> {
        if (args.length == 2) {
          Functions.removeAttribute(args[0], args[1]);
        } else {
          System.out.println("Error: Provide class name and field name.");
        }
      };
      case "addMethod" -> args -> {
        if (args.length == 3) {
          Functions.addMethod(args[0], args[1], args[2]);
        } else {
          System.out.println("Error: Provide class name, method name, and method type.");
        }
      };
      case "removeMethod" -> args -> {
        if (args.length == 2) {
          Functions.removeMethod(args[0], args[1]);
        } else {
          System.out.println("Error: Provide class name and method name.");
        }
      };
      case "addRelationship" -> args -> {
        if (args.length == 3) {
          try {
            int relationshipType = Integer.parseInt(args[1]);
            Functions.addRelationship(args[0], relationshipType, args[2]);
          } catch (NumberFormatException e) {
            System.out.println("Error: Relationship type must be an integer (1-4).");
          }
        } else {
          System.out.println("Error: Provide source class name, relationship type, and destination class name");
        }
      };
      case "removeRelationship" -> args -> {
        if (args.length == 1) {
          Functions.removeRelationship(args[0]);
        } else {
          System.out.println("Error: Provide class name to remove the relationship.");
        }
      };

      // List all classes with details
      case "lsa" -> args -> {
        if (args.length == 0) {
          Functions.listClasses("lsa");
        } else {
          System.out.println("Error: 'lsa' command does not take any arguments.");
        }
      };

      // List only class names
      case "lsc" -> args -> {
        if (args.length == 0) {
          Functions.listClasses("lsc");
        } else {
          System.out.println("Error: 'lsc' command does not take any arguments.");
        }
      };

      // List classes that have relationships
      case "lsr" -> args -> {
        if (args.length == 0) {
          Functions.listClasses("lsr");
        } else {
          System.out.println("Error: 'lsr' command does not take any arguments.");
        }
      };
      case "saveProgress" -> args -> {
        if (args.length == 1) {
          Functions.saveProgress(args[0]);  // Save progress with the given filename
        } else {
          System.out.println("Error: Provide a filename for saving progress.");
        }
      };
      case "loadProgress" -> args -> {
        if (args.length == 1) {
          Functions.loadProgress(args[0]);  // Load progress from the given filename
        } else {
          System.out.println("Error: Provide a filename for loading progress.");
        }
      };
      case "clearProgress" -> args -> {
        if (args.length == 0) {
          Functions.clearProgress();  // Clear all progress
        } else {
          System.out.println("Error: 'clear' command does not take any arguments.");
        }
      };
      case "renameAttribute" -> args -> {
        if (args.length == 3) {
          Functions.renameAttribute(args[0], args[1], args[2]);
        } else {
          System.out.println(
                  "Error: Provide class name, old attribute name, and new attribute name.");
        }
      };
      case "renameMethod" -> args -> {
        if (args.length == 3) {
          Functions.renameMethod(args[0], args[1], args[2]);
        } else {
          System.out.println(
                  "Error: Provide class name, old method name, new method name.");
        }
      };
      case "addParam" -> args -> {
        if (args.length == 4) {
          Functions.addParam(args[0], args[1], args[2], args[3]);
        } else {
          System.out.println(
                  "Error: Provide class name, method name, parameter, new parameter name, and new parameter type.");
        }
      };
      case "removeParam" -> args -> {
        if (args.length == 3) {
          Functions.removeParam(args[0], args[1], args[2]);
        } else{
        System.out.println("Error: Provide class name, method, and parameter.");
      }
    };
      case "exitProgram" -> args -> {
        if (args.length == 0) {
          Functions.exit();
        } else {
          System.out.println("Error: 'exit' command does not take any arguments.");
        }
      };
      case "undo" -> args -> {
        if (args.length == 0) {
          Functions.undo();
        } else {
          System.out.println("Error: 'undo' command does not take any arguments.");
        }
      };
      case "redo" -> args -> {
        if (args.length == 0) {
          Functions.redo();
        } else {
          System.out.println("Error: 'redo' command does not take any arguments.");
        }
      };
      default -> {
        System.out.println("Error: Unknown command type: " + type);
        yield null;
      }
    };
  }
}
