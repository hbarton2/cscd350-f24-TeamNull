package umleditor.view.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import umleditor.model.utilities.MementoStorage;


import java.util.ArrayList;
import java.util.List;

public class UMLNodeManager {

    private static UMLNodeManager instance;
    public List<UMLNode> nodeList = new ArrayList<>();
    private UMLNode node;
    @FXML
    private AnchorPane anchorPane;

    //Singleton constructor
    private UMLNodeManager(){
        nodeList = new ArrayList<UMLNode>();
    }

    //public instance getter
    public static UMLNodeManager getInstance() {
        if (instance == null) {
            instance = new UMLNodeManager();
        }
        return instance;
    }

    public void addNode(UMLNode newNode) {
        nodeList.add(newNode);
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

    public void updateAllNodes(){
        for (UMLNode node : nodeList) {
            node.updateLabel();
        }
    }

    /**
     * searches for the node object with the specified name
     * @param className is the name of the node (or class it represents) to search for
     * @return node object or null if node is not found
     */
    public UMLNode getNodeFromName(String className) {
        for(UMLNode node : nodeList){
            if(node.getClassName().equals(className)){
                return node;
            }
        }
        return null;
    }
}
