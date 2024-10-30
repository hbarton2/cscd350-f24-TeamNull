package umleditor.sprint2.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

/**
 * Java -jar does not like to start any class with any extents
 */

public class AppStart extends Application {
    @Override
  public void start(Stage primaryStage) throws Exception {
//    FXMLLoader loader = new FXMLLoader(getClass().getResource("/sprint2/CodeCain.fxml"));
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/sprint2/UMLBuilder.fxml"));
    Scene scene = new Scene(loader.load(), 900, 600);

    primaryStage.setResizable(true);
    primaryStage.setTitle("UML Editor GUI edition");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
//  @Override
//  public void start(Stage primaryStage) {
//    primaryStage.setTitle("Class Node Demo");
//
//    try {
//      // Debug statement to verify FXML path
//      URL fxmlUrl = getClass().getResource("/sprint2/UMLBuilder.fxml");
//      if (fxmlUrl == null) {
//        System.out.println("FXML file not found.");
//        return;
//      } else {
//        System.out.println("FXML file found at: " + fxmlUrl);
//      }
//
//      FXMLLoader loader = new FXMLLoader(fxmlUrl);
//      Scene scene = new Scene(loader.load(), 900, 600);
//      primaryStage.setScene(scene);
//      primaryStage.setResizable(true);
//      primaryStage.show();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }

  public static void main(String[] args) {
    launch(args);
  }
}
