package umleditor;

/*
 * This is the Main entry for both Sprint 1 and 2 comment out if your working with your correct packages
 */

import umleditor.sprint1.utilities.Display;
import umleditor.sprint2.view.AppStart;

public class EntryPoint {

  public static void main(String[] args) {

    /*
    Sprint 1 Launch Codes
     */
    Display startingApplication = new Display();
    startingApplication.start();

    /*
    Sprint 2 Launch Codes
     */
    AppStart.main(args);
  }
}
