package umleditor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import umleditor.controller.utilities.Functions;
import umleditor.view.gui.UMLNode;
import umleditor.view.gui.UMLNodeManager;

public class AddParameterController{

    @FXML
    private TextField className;
    @FXML
    private TextField currentMethod;
    @FXML
    private TextField paramName;
    @FXML
    private TextField paramType;

    @FXML
    private TextArea methodRenameTextArea;

    UMLNodeManager nodeManager = UMLNodeManager.getInstance();
    UMLNode node;

    @FXML
    void AddParameterOnClick(ActionEvent event) {

        if(nodeManager.getNodeFromName(className.getText()) != null) {
            node = nodeManager.getNodeFromName(className.getText());
            Functions.addParam(className.getText(), currentMethod.getText(), paramName.getText(), paramType.getText());
            node.updateLabel();
            methodRenameTextArea.setEditable(false);
            methodRenameTextArea.appendText("Parameter name: ' " + paramName.getText() + " type:" + paramType.getText() + " Added to " + currentMethod.getText() +  " '\n");
        }

        className.clear();
        currentMethod.clear();
        paramName.clear();
        paramType.clear();
    }

}