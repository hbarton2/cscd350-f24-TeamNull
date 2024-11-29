package umleditor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import umleditor.controller.utilities.Functions;
import umleditor.model.utilities.Storage;
import umleditor.view.gui.UMLNode;
import java.util.ArrayList;
import java.util.List;


public class RelationshipArrowController {
    List<umleditor.controller.MovableLine> lines = new ArrayList<>();
    List<UMLNode> nodesList = new ArrayList<>();
    private final List<String> relationshipTypes = List.of("Select type", "ASSOCIATION", "AGGREGATION",
            "COMPOSITION", "INHERITANCE", "GENERALIZATION", "REALIZATION", "DEPENDENCY");
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ChoiceBox<String> relationshipChoiceBox;
    @FXML
    private TextField srcClass;
    @FXML
    private TextField destClass;

    @FXML
    private AnchorPane viewAnchorPane;

    @FXML
    public void initialize() {
        relationshipChoiceBox.getItems().addAll(relationshipTypes);
        relationshipChoiceBox.setValue(relationshipTypes.get(0));
    }

    UMLNode srcNode;
    UMLNode destNode;


    @FXML
    void addLine(ActionEvent event) {
        if (relationshipChoiceBox.getValue().isEmpty()) {
            relationshipChoiceBox.requestFocus();
            return;
        }

        // int relationshipTypeNum = Integer.parseInt(relationshipChoiceBox.getValue()) ;
        int relationshipType;

        switch (relationshipChoiceBox.getValue()) {
            case "ASSOCIATION":
                relationshipType = 1;
                break;
            case "AGGREGATION":
                relationshipType = 2;
                break;
            case "COMPOSITION":
                relationshipType = 3;
                break;
            case "INHERITANCE":
                relationshipType = 4;
                break;
            case "GENERALIZATION":
                relationshipType = 5;
                break;
            case "REALIZATION":
                relationshipType = 6;
                break;
            case "DEPENDENCY":
                relationshipType = 7;
                break;
            default:
                relationshipType = 0;
                break;
        }

        Functions.addRelationship(srcClass.getText(), relationshipType,destClass.getText());

        srcNode = new UMLNode(Storage.getInstance().getClassObject(srcClass.getText()));
        viewAnchorPane.getChildren().add(srcNode);
        srcNode.setLayoutX(10);
        srcNode.setLayoutY(0);

        destNode = new UMLNode(Storage.getInstance().getClassObject(destClass.getText()));
        viewAnchorPane.getChildren().add(destNode);
        destNode.setLayoutX(450);
        destNode.setLayoutY(0);

        MovableLine newLine = new umleditor.controller.MovableLine(anchorPane);
        lines.add(newLine);

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


    @FXML
    void saveAsImage(ActionEvent event) {
        //Code to call ImageController

       System.out.println("Save image button clicked\n");
    }
}