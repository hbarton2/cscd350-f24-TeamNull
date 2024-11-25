package umleditor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelpController {

    @FXML
    private TextField className;

    @FXML
    private TextArea helpTextArea;
    @FXML
    private TextField currentClassName;

    @FXML
    void helpMethod(ActionEvent event) {

        helpTextArea.clear();
        helpTextArea.appendText(className.getText() + "\nkeyword to search for help");

        System.out.println("Help button clicked");
    }
}