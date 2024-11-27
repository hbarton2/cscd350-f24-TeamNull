package umleditor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import umleditor.controller.utilities.Functions;
import umleditor.view.gui.UMLNode;
import umleditor.view.gui.UMLNodeManager;

public class DeleteFieldController {

    @FXML
    private TextField className;

    @FXML
    private TextField fieldName;

    @FXML
    private TextArea deleteFieldTextArea;
    UMLNodeManager nodeManager = UMLNodeManager.getInstance();
    UMLNode node;

    @FXML
    void deleteFieldOnClick(ActionEvent event) {
        deleteFieldTextArea.styleProperty().set("-fx-border-color: red");
        if(className.getText().isEmpty()) {
            deleteFieldTextArea.clear();
            deleteFieldTextArea.appendText("\nError: Class Name is empty\n");
        }
        if(fieldName.getText().isEmpty()) {
            deleteFieldTextArea.clear();
            deleteFieldTextArea.appendText("\nError: Field Name is empty\n");
        }
        if(Functions.getClassIfExists(className.getText()) == null){
            deleteFieldTextArea.clear();
            deleteFieldTextArea.appendText("\nClass not found\n");
        }
        else {
            node = nodeManager.getNodeFromName(className.getText());
        }
        // deleteFieldTextArea.styleProperty().set("-fx-border-color: green");
        deleteFieldTextArea.clear();
        Functions.removeAttribute(className.getText(), fieldName.getText());
        node.updateLabel();
        deleteFieldTextArea.appendText("Field name: " + fieldName.getText() + " removed from " + className.getText() + " class\n");

        className.clear();
        fieldName.clear();
        }
    }