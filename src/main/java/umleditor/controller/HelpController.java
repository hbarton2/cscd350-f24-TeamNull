package umleditor.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class HelpController {

    @FXML
    private TextArea helpTextArea;
    @FXML
    private Label label;

    String path = "src/main/resources/doc/HelpInstructions.txt";

    @FXML
    void helpMethod(ActionEvent event) throws IOException {

        helpTextArea.clear(); // Clear the existing text in the TextArea
        helpTextArea.setStyle("-fx-text-fill: blue;");
        helpTextArea.setFont(new Font("Bell MT", 16));
        helpTextArea.setEditable(false);

        File file = new File(path);
        if (file.exists() && file.isFile()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    helpTextArea.appendText(scanner.nextLine() + "\n");
                    helpTextArea.appendText("");
                }
            }
        } else {
            helpTextArea.appendText("Error: Help instructions file not found at path: " + path + "\n");
        }
        System.out.println("Help section requested");
    }
}