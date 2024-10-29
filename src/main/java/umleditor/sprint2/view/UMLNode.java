package umleditor.sprint2.view;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class UMLNode extends Pane {
  private double offsetX;
  private double offsetY;

  public UMLNode(String className) {
    // Set dimensions and initial styling
    this.setPrefSize(150, 100);
    this.setStyle("-fx-border-color: black; -fx-background-color: lightblue;");

    Label classLabel = new Label(className);
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
}
