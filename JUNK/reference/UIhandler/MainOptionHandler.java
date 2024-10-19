package proj.TeamNull.UMLdevkit.reference.UIhandler;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import proj.TeamNull.UMLdevkit.EntryPoint;

public class MainOptionHandler {

  public void handleCloseAction(ActionEvent actionEvent) {
    // Close the window logic
    Stage stage = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
    stage.close();
  }

  public void fileMenuSignOut(ActionEvent event) throws IOException {
    // Get the current stage (window)
    Stage stage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();

    // Load the login screen FXML
    FXMLLoader fxmlLoader = new FXMLLoader(EntryPoint.class.getResource("LoginEntryPoint.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 600, 400);

    // Set the scene to the login screen and configure the stage
    stage.setScene(scene);
    stage.setTitle("Unified Modeling Language Software Development Kit - Login");
    stage.setResizable(false);  // Disable window resizing
    stage.show();
  }

  /*
    Below is menu items action
   */

//  @FXML
//  private Button entryE6B;
//
//  @FXML
//  private Button entryWeather;
//
//  @FXML
//  private Button entryFlightPlan;
//
//  @FXML
//  private Button entryRecords;

  public void setEntryTerminalAction(ActionEvent event) throws IOException {
    Stage stage = new Stage();
    FXMLLoader fxmlLoader = new FXMLLoader(EntryPoint.class.getResource("Terminal.fxml"));

    if (fxmlLoader.getLocation() == null) {
      System.out.println("Terminal.fxml not found!");
      return;
    }

    Scene scene = new Scene(fxmlLoader.load(), 600, 400);
    stage.setScene(scene);
    stage.setTitle("Unified Modeling Language Software Development Kit - Terminal");
    stage.setResizable(false);
    stage.show();
  }

  public void setEntryGUIAction(ActionEvent actionEvent) {
  }

  public void setEntryFlightPlanAction(ActionEvent actionEvent) {
  }

  public void setEntryRecordsAction(ActionEvent actionEvent) {
  }
}
