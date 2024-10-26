package umleditor;

/*
 * This is the Main entry for both Sprint 1 and 2 comment out if you working with your correct packages
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import umleditor.sprint1.utilities.Display;

public class EntryPoint extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/sprint2/CodeCain.fxml"));
    Scene scene = new Scene(loader.load(), 900, 600);

    primaryStage.setResizable(true);
    primaryStage.setTitle("Code Cain Demo");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {

    /*
    Sprint 1 Launch Codes
     */
    Display startingApplication = new Display();
    startingApplication.start();

    /*
    Sprint 2 Launch Codes
     */
    launch(args);
  }
}
