package proj.TeamNull.UMLdevkit;

/*
 * Version number officially moved to README.md
 */

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import proj.TeamNull.UMLdevkit.reference.UMLComponent.UMLClass;
import proj.TeamNull.UMLdevkit.reference.UMLComponent.UMLField;

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

    System.out.println("WAZZZZZZ UPPPP! Love you guys =) see you tomorrow");
    //    Scanner scanner = new Scanner(System.in);
    //
    //    Menu.displayMainMenu();
    //    Menu.processMainMenuInput(scanner.nextLine());

    //    launch(); // <-- confused what this is doing! -kate, this is how to start JavaScenes -
    // Jimmy

    /*
     * Sample code I've written to test out the add utility.
     * It literally just creates an object, throws it into the UMLClass.add() and then prints it out.
     * This is just test code, so feel free to remove it later.(In fact, PLEASE remove it later!!!)
     * */

    UMLClass myClass = new UMLClass("Steve");
    System.out.println(myClass);
    UMLField field = new UMLField("int", "age");
    myClass.add(field);
    System.out.println(myClass);

    System.exit(0);
  }
}