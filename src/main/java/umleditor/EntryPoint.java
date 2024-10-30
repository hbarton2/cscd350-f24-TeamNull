package umleditor;

/*
 * This is the Main entry for both Sprint 1 and 2 comment out if your working with your correct packages
 */

import java.util.Scanner;
import umleditor.sprint1.utilities.Display;
import umleditor.sprint2.view.AppStart;

public class EntryPoint {

  public static void main(String[] args) {
    boolean answer = true;
    Scanner scanner = new Scanner(System.in);

    while (answer) {
      System.out.print("Do you want to use GUI UML editor? (yes/y or no/n): ");
      String input = scanner.nextLine().toLowerCase();

      if (input.equals("yes") || input.equals("y")) {
        answer = false;
        AppStart.main(args);  // Sprint 2 Launch Codes
      } else if (input.equals("no") || input.equals("n")) {
        answer = false;
        Display startingApplication = new Display(); // Sprint 1 Launch Codes
        startingApplication.start();  // Sprint 1 Launch Codes
      } else {
        System.out.println("Please enter a valid command.");
      }
    }

    scanner.close();
  }
}
