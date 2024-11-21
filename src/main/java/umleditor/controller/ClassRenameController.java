package umleditor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import umleditor.controller.utilities.Functions;

/**
 * This class represent rename class controller
 * It takes the text from currentClassName field and
 * newClass fields and pass them on to the rename class method in the Functions class
 * Sets the text area un-editable and then display d message
 * Confirming the change
 * Clears both text fields to get them ready for new text should the user have more classes to rename
 */

public class ClassRenameController {

    @FXML
    private TextField currentClassName;

    @FXML
    private TextField newClassName;

    @FXML
    private TextArea classTextArea;

    @FXML
    void renameClassOnClick(ActionEvent event) {
        Functions.renameClass(currentClassName.getText(), newClassName.getText());

        classTextArea.setEditable(false);
        classTextArea.appendText("Class name ' " + currentClassName.getText() + " ' changed to  ' " + newClassName.getText() + " '\n");

        currentClassName.clear();
        newClassName.clear();

    }
}