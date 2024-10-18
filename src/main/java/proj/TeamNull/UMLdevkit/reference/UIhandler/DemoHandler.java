package proj.TeamNull.UMLdevkit.reference.UIhandler;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DemoHandler {

  @FXML
  private Label welcomeText;

  @FXML
  protected void onHelloButtonClick() {
    welcomeText.setText("Welcome to JavaFX Void!");
  }
}