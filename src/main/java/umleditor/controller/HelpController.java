package umleditor.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelpController {

    @FXML
    private TextField className;

    @FXML
    private TextArea helpTextArea;

    @FXML
    void deleteClass(ActionEvent event) {


        //helpTextArea.appendText(Functions.listClasses("lsa"));

        System.out.printf("Help button clicked");

    }

}