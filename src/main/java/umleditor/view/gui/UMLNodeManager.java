package umleditor.view.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;


import java.util.ArrayList;
import java.util.List;

public class UMLNodeManager {

    List<UMLNode> nodeList = new ArrayList<>();
    UMLNode node;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    public void addNode(ActionEvent event) {

        nodeList.add( node);
       // anchorPane.getChildren().add( node);


    }

    @FXML
    public void removeNode(ActionEvent event) {
        nodeList.remove(node);
       // anchorPane.getChildren().clear();

    }
    @FXML
    public static void printNode(ArrayList<UMLNode> nodes) {
        for (UMLNode node : nodes) {
            System.out.println(node);

        }
    }
}
