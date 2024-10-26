package umleditor.sprint2.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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
