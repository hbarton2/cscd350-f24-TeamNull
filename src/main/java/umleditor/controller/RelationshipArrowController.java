package umleditor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import umleditor.controller.utilities.Functions;
import umleditor.model.utilities.Storage;
import umleditor.view.gui.UMLNode;

import java.util.ArrayList;
import java.util.List;

public class RelationshipArrowController {
    List<umleditor.controller.MovableLine> lines = new ArrayList<>();
    List<UMLNode> nodes = new ArrayList<>();

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextArea textArea;
    @FXML
    private TextArea textArea1;
    UMLNode node1;
    @FXML
    void addLine(ActionEvent event) {
        umleditor.controller.MovableLine newLine = new umleditor.controller.MovableLine(anchorPane);
        lines.add(newLine);

        textArea.appendText(newLine.toString());
        textArea.appendText("\nline added");
        textArea.appendText("\n\n");
        textArea.setEditable(false);
        textArea.setWrapText(true);
       // textArea.setLayoutX(14);
       // textArea.setLayoutY(14);
        textArea1.setEditable(false);
        textArea1.setWrapText(true);
        textArea1.appendText("Relationship line added");
        textArea1.appendText(node1.getClassName());


    }

    @FXML
    void removeLine(ActionEvent event) {
        try{
            if (lines.isEmpty()) {

                System.out.println("no more lines to remove\n");
            }
            MovableLine currentLine = lines.get(0);
            lines.remove(0);
            currentLine.removeLineFrom(anchorPane);

        }catch (Exception e) {
            System.out.println("No more lines to remove\n");
        }
    }
}