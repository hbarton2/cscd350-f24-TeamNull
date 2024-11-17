package umleditor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import umleditor.controller.utilities.Functions;

public class UMLGUIUtilityController {
    @FXML
    private TextField currentClass;

    @FXML
    private TextField newClass;

    @FXML
        private Font x1;

        @FXML
        private Color x2;

        @FXML
        private Font x3;

        @FXML
        private Color x4;

    @FXML
    void perFormRename(ActionEvent event) {
        Functions.renameClass(currentClass.getText(), newClass.getText());

    }
    }


