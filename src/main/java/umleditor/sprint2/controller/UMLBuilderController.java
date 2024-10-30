package umleditor.sprint2.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import umleditor.sprint1.uml.UMLClass;
import umleditor.sprint2.model.Model;
import umleditor.sprint2.view.UMLNode;
import java.util.logging.Logger;

public class UMLBuilderController {
  private static final Logger logger = Logger.getLogger(UMLBuilderController.class.getName());

  @FXML
  private AnchorPane viewAnchorPane; // Now referencing AnchorPane instead of VBox

  public void addUMLNode(String className) {
    UMLNode umlNode = new UMLNode(className);
    umlNode.setLayoutX(10); // Set starting position
    umlNode.setLayoutY(10);
    viewAnchorPane.getChildren().add(umlNode); // Add to AnchorPane for freeform positioning
  }

  @FXML
  public void handleAddNode() {
    addUMLNode(UMLNodeBuilder()); // Sample class name
  }

  private String UMLNodeBuilder(){
    Model tempModel = new Model();

    return tempModel.createClassNode("Jimmy REALLY HATES JAVA") + "\r\n" + "JAVA CHITTY FIELDS" + "\r\n" + "TONY HATES JAVA TOO" + "\r\n";
  }

  @FXML
  public void exitProgram() {
    System.exit(0);
  }

}
