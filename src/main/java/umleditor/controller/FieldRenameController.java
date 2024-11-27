package umleditor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import umleditor.controller.utilities.Functions;
import umleditor.view.gui.UMLNode;
import umleditor.view.gui.UMLNodeManager;

public class FieldRenameController {

    @FXML
    private TextField className;

    @FXML
    private TextField currentField;

    @FXML
    private TextField newField;

    @FXML
    private TextArea renameFieldTextArea;

    UMLNodeManager nodeManager = UMLNodeManager.getInstance();
    UMLNode node;

    @FXML
    void renameFieldOnClick(ActionEvent event) {
        if(nodeManager.getNodeFromName(className.getText()) != null) {
            node = nodeManager.getNodeFromName(className.getText());
            Functions.renameAttribute(className.getText(),currentField.getText(),newField.getText());
            node.updateLabel();
            renameFieldTextArea.setEditable(false);
            renameFieldTextArea.appendText("Field name: ' " + currentField.getText() + "' changed to '" + newField.getText() + "\n");
        }

        className.clear();
        currentField.clear();
        newField.clear();
    }
}