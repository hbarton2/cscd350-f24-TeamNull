package umleditor.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import umleditor.controller.utilities.Functions;
public class DeleteClassController {
    @FXML
    private ListView<String> listView;
    @FXML
    private TextField className;
    @FXML
    private TextArea deleteClass;
    @FXML
    void deleteClass(ActionEvent event) {
        // Set the text area to non-editable and apply initial styles
        deleteClass.setEditable(false);
        deleteClass.setFont(new Font("Arial", 20));
        String classNameText = className.getText().trim();
        // Check if className is empty
        if (classNameText.isEmpty()) {
            deleteClass.setStyle("-fx-text-fill: red;");
            deleteClass.clear();
            deleteClass.appendText("Please type a class name to delete.\n");
            return;
        }
        // Check if the class exists
        if (Functions.getClassIfExists(classNameText) == null) {
            deleteClass.setStyle("-fx-text-fill: red;");
            deleteClass.clear();
            deleteClass.appendText("Class name: '" + classNameText + "' not found.\n");
            return;
        }
        // Proceed with class deletion
        Functions.removeClass(classNameText);
        deleteClass.clear();
        deleteClass.setStyle("-fx-text-fill: green;");
        deleteClass.appendText("Class name: '" + classNameText + "' has been successfully deleted.\n");
        // Clear the input field
        className.clear();
    }
}