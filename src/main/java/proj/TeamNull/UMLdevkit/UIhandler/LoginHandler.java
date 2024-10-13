package proj.TeamNull.UMLdevkit.UIhandler;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import proj.TeamNull.UMLdevkit.EntryPoint;

public class LoginHandler {

  @FXML
  private TextField usernameField;

  @FXML
  private PasswordField passwordField;

  @FXML
  private Button loginButton;

  @FXML
  private Button cancelButton;

  @FXML
  private Button loginErrorMessage;

  public void loginButtonAction(ActionEvent event) throws IOException {
    String username = usernameField.getText();
    String password = passwordField.getText();

    if (username.isEmpty() || password.isEmpty() || username.isBlank() || password.isBlank()) {
      loginErrorMessage.setVisible(true);
      loginErrorMessage.setText("Username and Password are required");
    } else if (!username.equals("admin") && !password.equals("password")) {
      loginErrorMessage.setVisible(true);
      loginErrorMessage.setText("Username and Password are incorrect");
    } else if (username.equals("admin") && password.equals("password")) {
      Stage stage = (Stage) loginButton.getScene().getWindow();
      FXMLLoader fxmlLoader = new FXMLLoader(
        EntryPoint.class.getResource("MainOption.fxml"));
      Scene scene = new Scene(fxmlLoader.load(), 800, 600);
      stage.setTitle("Unified Modeling Language Software Development Kit - Launch Options");
      stage.setScene(scene);
      stage.show();
    }
  }

  public void cancelButtonAction(ActionEvent event) {
    Stage stage = (Stage) cancelButton.getScene().getWindow();
    stage.close();
  }
}
