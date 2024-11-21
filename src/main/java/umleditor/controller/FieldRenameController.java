package umleditor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import umleditor.controller.utilities.Functions;

public class FieldRenameController {

    @FXML
    private TextField className;

    @FXML
    private TextField currentField;

    @FXML
    private TextField newField;

    @FXML
    private TextArea renameFieldTextArea;

    @FXML
    void renameFieldOnClick(ActionEvent event) {

        Functions.renameAttribute(className.getText(),currentField.getText(),newField.getText());
        renameFieldTextArea.setEditable(false);
        renameFieldTextArea.appendText("Field name: ' " + currentField.getText() + "' changed to '" + newField.getText() + "\n");

        className.clear();
        currentField.clear();
        newField.clear();
    }
}