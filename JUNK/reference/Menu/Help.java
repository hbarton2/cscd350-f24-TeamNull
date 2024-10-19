package proj.TeamNull.UMLdevkit.reference.Menu;

import java.util.Scanner;

public class Help {

  public enum HelpType {
    METHOD(1),
    FIELD(2),
    PARAMETER(3),
    CLASS(4),
    DISPLAY(5),
    GENERAL(6);

    private final int menuChoice;

    HelpType(int menuChoice) {
      this.menuChoice = menuChoice;
    }

    public static HelpType fromInt(int menuChoice) {
      for (HelpType type : HelpType.values()) {
        if (type.menuChoice == menuChoice) {
          return type;
        }
      }
      return null;
    }
  }


  public static String getHelp(HelpType type) {
    if (type == null) {
      return "Invalid help type.";
    }

    switch (type) {
      case METHOD:
        return "To access any method commands you must be in the Method Menu\n" +
          " " +
          "\nAdd: Enter a valid class name of the class you wish to add to, then enter a valid method name and parameters"
          +
          "\nRemove: Enter the class name of the method you wish to remove, then enter method name"
          +
          "\nRename: This function is in development";
      case FIELD:
        return "Fields in UML represent attributes of a class. Each field has a name and a type, " +
          " and no two fields in the same class can have the same name." +
          "\n" +
          "\n Add: Enter class name of the class you wish to add to, enter valid field name and type"
          +
          "\n Remove: Enter class name of the class you wish to remove from, enter field name" +
          "\n Rename: This function is in development";
      case PARAMETER:
        return
          "Parameters in UML represent inputs to methods. Each parameter has a name and a type, " +
            "and no two parameters in the same method can have the same name." +
            "\n" +
            "\n Add: Enter class name and the method name where you want to add parameter, enter name and type"
            +
            "\n Remove: Enter class name and the method name where you want to remove parameter, enter parameter name"
            +
            "\n Rename: This function is in development";
      case CLASS:
        return
          "Classes in UML represent blueprints for objects. Classes can have fields, methods, and relationships. "
            + "No two classes can have the same name.\n" +
            "\n Add: Enter unique class name and select if you wish to add any methods/parameters" +
            "\n Remove: Enter name of class you wish to remove" +
            "\n Rename: Enter class name you wish to rename, enter the new name you want to change it to";
      case DISPLAY:
        return "Displays in UML help visualize the structure and relationships between classes, "
          + "including their fields and methods.\n" +
          "\n Display Single: enter class name of the class you want to display" +
          "\n Display All: Displays all current classes and relationship between them";
      case GENERAL:
        return
          "UML (Unified Modeling Language) is a standardized visual language used to describe and model software systems. "
            + "It helps in representing the structure and behavior of systems.";
      default:
        return "Invalid help type.";
    }
  }

  public static void printHelpMenu() {
    Scanner sc = new Scanner(System.in);

    System.out.println("+-----------------------------+");
    System.out.println("|       Help Menu             |");
    System.out.println("+-----------------------------+");
    System.out.println("| 1. Methods                  |");
    System.out.println("| 2. Fields                   |");
    System.out.println("| 3. Parameters               |");
    System.out.println("| 4. Classes                  |");
    System.out.println("| 5. Displays                 |");
    System.out.println("| 6. General                  |");
    System.out.println("| 7. Exit                     |");
    System.out.println("+-----------------------------+");
    System.out.print("Enter your choice: ");
    processHelpMenuInput();


  }

  private static void processHelpMenuInput() {
    Scanner sc = new Scanner(System.in);

    int choice = sc.nextInt();
    HelpType type = HelpType.fromInt(choice);
    String helpInfo = getHelp(type);
    System.out.println(helpInfo);
  }
}