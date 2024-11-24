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
        classTextArea.setStyle("-fx-text-fill: red;");
        classTextArea.clear();
        String oldClassName = currentClassName.getText();
        String newClassNameText = newClassName.getText();
        // Check if either class name is empty
        if (oldClassName.isEmpty() || newClassNameText.isEmpty()) {
            classTextArea.appendText("Class names cannot be empty!\n");
            return;
        }
        // Check if old and new class names are the same
        if (oldClassName.equals(newClassNameText)) {
            classTextArea.appendText("Both old and new class names are the same!\n");
            return;
        }
        // Check if the old class name exists
        if (Functions.getClassIfExists(oldClassName) == null) {
            classTextArea.appendText("Class '" + oldClassName + "' not found!\n");
            return;
        }
        // Rename the class
        Functions.renameClass(oldClassName, newClassNameText);
        classTextArea.setStyle("-fx-text-fill: green;");
        classTextArea.setEditable(false);
        classTextArea.appendText("Class name '" + oldClassName + "' changed to '" + newClassNameText + "'.\n");
        // Clear the text fields
        currentClassName.clear();
        newClassName.clear();
    }
}