package umleditor.demo;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class CodeCainController {

  @FXML
  private TextField outputTextField;

  @FXML
  public void outputTextField(ActionEvent event) {
    // This method can be customized further if needed.
  }

  @FXML
  public void clickSayHello() {
    String text = "I HATE MAVEN AND I HATE JAVA!";
    outputTextField.setText(text);
  }
}
