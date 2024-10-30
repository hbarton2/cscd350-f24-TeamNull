package umleditor.sprint2.view;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import umleditor.sprint1.uml.UMLClass;
import umleditor.sprint1.utilities.Display;
import umleditor.sprint1.utilities.Functions;

public class UMLNode extends Pane {
  private double offsetX;
  private double offsetY;

  public UMLNode(String className) {
    // Set dimensions and initial styling
    this.setPrefSize(150, 100);
    this.setStyle("-fx-border-color: black; -fx-background-color: lightgreen;");

    Label classLabel = new Label(className);

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

//  private String UMLNodeBuilder(){
//    UMLClass newClass = new UMLClass("Jimmy REALLY HATES JAVA");
//
//    return newClass.getClassName() + "\r\n" + "JAVA CHITTY FIELDS" + "\r\n" + "TONY HATES JAVA TOO" + "\r\n";
//  }
}
