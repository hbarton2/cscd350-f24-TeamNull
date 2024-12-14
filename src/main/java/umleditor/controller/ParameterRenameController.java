package umleditor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import umleditor.controller.utilities.Functions;
import umleditor.view.gui.UMLNode;
import umleditor.view.gui.UMLNodeManager;

public class ParameterRenameController {


    @FXML
    private TextField className;

    @FXML
    private TextField currentParam;

    @FXML
    private TextField methodName;

    @FXML
    private TextField newParam;

    @FXML
    private TextArea renameParTextArea;

    UMLNodeManager nodeManager = UMLNodeManager.getInstance();
    UMLNode node;

    @FXML
    void renameParOnClick(ActionEvent event) {
        if(className.getText().isEmpty()) {
            renameParTextArea.setStyle("-fx-text-fill: red;");
            renameParTextArea.appendText("Please enter an existing class name\n");
        }
        if(currentParam.getText().isEmpty()) {
            renameParTextArea.setStyle("-fx-text-fill: red;");
            renameParTextArea.appendText("Please enter a current parameter you want to change\n");
        }

        if(nodeManager.getNodeFromName(className.getText()) != null){
            node = nodeManager.getNodeFromName(className.getText());
            Functions.renameParam(className.getText(), methodName.getText(), currentParam.getText(), newParam.getText());
            node.updateLabel();
            renameParTextArea.setEditable(false);
            renameParTextArea.appendText("Field name: ' " + currentParam.getText() + "' changed to '" + newParam.getText() + "\n");
        }

        System.out.printf("Rename parameter: %s\n", currentParam.getText());
    }
}