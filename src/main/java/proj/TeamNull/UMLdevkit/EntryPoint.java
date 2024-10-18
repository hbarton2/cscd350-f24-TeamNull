package proj.TeamNull.UMLdevkit;

/*
 * Version number officially moved to README.md
 */

import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static proj.TeamNull.UMLdevkit.reference.Menu.Menu.*;

public class EntryPoint extends Application {

  @Override
  public void start(Stage stage) throws IOException {

    FXMLLoader fxmlLoader = new FXMLLoader(
      EntryPoint.class.getResource("LoginEntryPoint.fxml"));

    Scene scene = new Scene(fxmlLoader.load(), 600, 400);//new Scene(fxmlLoader.load(), 320, 240);
//    stage.setScene(new Scene(root, 600, 400));
    //stage.initStyle(StageStyle.UNDECORATED); // this will remove the window to window borderless
    stage.setResizable(false);  // This disables window resizing
    stage.setTitle("Unified Modeling Language Software Development Kit - Login");
    stage.setScene(scene);
    stage.show();
  }

  /**
   * Start Menu Here!
   */
  public static void main(String[] args) {

    // start command-line menu
    startMenu();

//    launch();

  }
}