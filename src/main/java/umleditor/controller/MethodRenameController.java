package umleditor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import umleditor.controller.utilities.Functions;
import umleditor.view.gui.UMLNode;
import umleditor.view.gui.UMLNodeManager;

public class MethodRenameController {

    @FXML
    private TextField className;
    @FXML
    private TextField currentMethod;
    @FXML
    private TextField newMethod;
    @FXML
    private TextArea methodRenameTextArea;

    UMLNodeManager nodeManager = UMLNodeManager.getInstance();
    UMLNode node;

    @FXML
    void renameMethodOnClick(ActionEvent event) {

        if(nodeManager.getNodeFromName(className.getText()) != null) {
            node = nodeManager.getNodeFromName(className.getText());
            Functions.renameMethod(className.getText(), currentMethod.getText(), newMethod.getText());
            node.updateLabel();
            methodRenameTextArea.setEditable(false);
            methodRenameTextArea.appendText("Method name: ' " + currentMethod.getText() + "' changed to '" + newMethod.getText() + " '\n");
        }

        className.clear();
        currentMethod.clear();
        newMethod.clear();
    }

}