package umleditor.view;

import javafx.application.Application;
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
    Scene scene = new Scene(loader.load());
    primaryStage.setResizable(true);
    primaryStage.setTitle("UML Editor GUI edition");
    primaryStage.setScene(scene);
    primaryStage.show();
    primaryStage.setIconified(true); // Minimize the window
    primaryStage.setIconified(false); // Restore it, forcing focus


  }

  public static void main(String[] args) {
    launch(args);
  }
}
