package umleditor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import umleditor.controller.utilities.Functions;

public class MethodRenameController {

    @FXML
    private TextField className;
    @FXML
    private TextField currentMethod;
    @FXML
    private TextField newMethod;
    @FXML
    private TextArea methodRenameTextArea;

    @FXML
    void renameMethodOnClick(ActionEvent event) {

        Functions.renameMethod(className.getText(), currentMethod.getText(), newMethod.getText());

        methodRenameTextArea.setEditable(false);
        methodRenameTextArea.appendText("Method name: ' " + currentMethod.getText() + "' changed to '" + newMethod.getText() + " '\n");

        className.clear();
        currentMethod.clear();
        newMethod.clear();
    }

}