package umleditor.sprint2.view;

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
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/sprint2/CodeCain.fxml"));
    Scene scene = new Scene(loader.load(), 900, 600);

    primaryStage.setResizable(true);
    primaryStage.setTitle("Code Cain Demo");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args){
    launch(args);
  }
}
