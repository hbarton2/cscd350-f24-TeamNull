package umleditor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import umleditor.controller.utilities.Functions;

public class SaveFileController {

    @FXML
    private TextField fileName;

    @FXML
    private Button saveButton;

    @FXML
    private TextArea saveTextArea;

    @FXML
    void saveFileOnClick(ActionEvent event) {
        if(fileName.getText().isEmpty()) {
            saveTextArea.setText("Please enter a file name");
        }
        else {
            Functions.saveProgress(fileName.getText());
            saveTextArea.setText("File saved successfully");
        }
    }

}
