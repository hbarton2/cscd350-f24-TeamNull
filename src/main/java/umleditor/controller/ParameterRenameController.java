package umleditor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import umleditor.controller.utilities.Functions;

public class ParameterRenameController {


    @FXML
    private TextField className;

    @FXML
    private TextField currentField;

    @FXML
    private TextField newField;

    @FXML
    private TextArea renameParTextArea;

    @FXML
    void renameParOnClick(ActionEvent event) {
        if(className.getText().isEmpty()) {
            renameParTextArea.setStyle("-fx-text-fill: red;");
            renameParTextArea.appendText("Please enter an existing class name\n");
        }
        if(currentField.getText().isEmpty()) {
            renameParTextArea.setStyle("-fx-text-fill: red;");
            renameParTextArea.appendText("Please enter a current parameter you want to change\n");
        }
        Functions.renameAttribute(className.getText(), currentField.getText(), newField.getText());
        System.out.printf("Rename parameter: %s\n", currentField.getText());
    }
}