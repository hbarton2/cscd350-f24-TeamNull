package umleditor.view.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIDisplay {

    /**
     * Opens the "Help Utility" window using a JavaFX stage.
     *
     * This method attempts to load the "Help.fxml" file located in the
     * `/sprint2/` directory and displays it in a new window. If the
     * loading process fails, an error message is printed to the console,
     * and the exception's stack trace is logged for debugging purposes.
     */
    public void help() {
        try {
            // Load the Help.fxml file
            FXMLLoader helpSceneLoader = new FXMLLoader(getClass().getResource("/sprint2/Help.fxml"));
            Parent root = helpSceneLoader.load();

            // Create a new stage and set its title and scene
            Stage stage = new Stage();
            stage.setTitle("Help Utility");
            stage.setScene(new Scene(root));
            stage.show();


        } catch (Exception e) {
            // Print error message to the console
            System.out.println("Loading Help Utility failed");
            // Log the exception's stack trace for debugging
            e.printStackTrace();
        }
    }
}
