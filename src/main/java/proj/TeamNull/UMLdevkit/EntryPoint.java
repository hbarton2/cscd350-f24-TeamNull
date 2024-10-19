package proj.TeamNull.UMLdevkit;

/*
 * Version number officially moved to README.md
 */

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import proj.TeamNull.UMLdevkit.utilities.Parser;

public class EntryPoint extends Application {

  @Override
  public void start(Stage stage) throws IOException {

    FXMLLoader fxmlLoader = new FXMLLoader(
      EntryPoint.class.getResource("LoginEntryPoint.fxml"));

    Scene scene = new Scene(fxmlLoader.load(), 600, 400);
    stage.setResizable(false);
    stage.setTitle("Unified Modeling Language Software Development Kit - Login");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
//    launch();
  }
}