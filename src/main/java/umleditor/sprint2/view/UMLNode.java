package umleditor.sprint2.view;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class UMLNode extends Pane {

  private double offsetX;
  private double offsetY;

  public UMLNode(String className) {
    // Set dimensions and initial styling
    this.setPrefSize(250, 150);
    this.setStyle("-fx-border-color: black; -fx-background-color: lightgreen;");

    Label classLabel = new Label(mockNode());

//    Label classLabel = new Label(Display.class.getName());
    classLabel.setStyle("-fx-font-weight: bold;");
    this.getChildren().add(classLabel);

    // Add event handlers for dragging
    this.setOnMousePressed(event -> {
      offsetX = event.getSceneX() - getLayoutX();
      offsetY = event.getSceneY() - getLayoutY();
    });

    this.setOnMouseDragged(event -> {
      setLayoutX(event.getSceneX() - offsetX);
      setLayoutY(event.getSceneY() - offsetY);
    });
  }


  private String mockNode() {
    return """
      Bus\r
      String Color\r
      Engine model\r
      void driveCar(String driver)\r
      void openDoor()\r 
      Composition\r
      """;
  }
}
