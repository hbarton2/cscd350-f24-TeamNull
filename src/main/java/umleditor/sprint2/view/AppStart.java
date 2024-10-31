package umleditor.sprint2.view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Java -jar does not like to start any class with any extents
 */

public class AppStart extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("/sprint2/UMLBuilder.fxml"));
    Scene scene = new Scene(loader.load(), 900, 600);
    primaryStage.setResizable(true);
    primaryStage.setTitle("UML Editor GUI edition");
//    primaryStage.toFront();// to bring the window in front of other windows This doesn't always work
    //primaryStage.setAlwaysOnTop(true);// to bring the window in front
    primaryStage.setScene(scene);
    primaryStage.show();
    primaryStage.setIconified(true); // Minimize the window
    primaryStage.setIconified(false); // Restore it, forcing focus
  }

  public static void main(String[] args) {
    launch(args);
  }
}
