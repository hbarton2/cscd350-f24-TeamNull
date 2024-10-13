package proj.TeamNull.UMLdevkit.Menu;

public class Menu {

  public void displayMenu() {
    System.out.println("+-----------------------------+");
    System.out.println("|       Main Menu             |");
    System.out.println("+-----------------------------+");
    System.out.println("| 1. Help                     |");
    System.out.println("| 2. Settings                 |");
    System.out.println("| 3. About                    |");
    System.out.println("| 4. Exit                     |");
    System.out.println("+-----------------------------+");
    System.out.print("Enter your choice: ");
  }

  public void processInput(String input) {
    switch (input) {
      case "1":
        System.out.println("Help: This is a sample help message.");
        break;
      case "2":
        System.out.println("Settings: This is the settings section.");
        break;
      case "3":
        System.out.println("About: This application was built using JavaFX.");
        break;
      case "4":
        System.out.println("Exiting the menu...");
        System.exit(0);  // Terminate the application.
        break;
      default:
        System.out.println("Invalid choice. Please try again.");
    }

    displayMenu();  // Re-display the menu after processing input.
  }
}
