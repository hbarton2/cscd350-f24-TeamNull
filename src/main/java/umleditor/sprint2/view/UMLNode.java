package umleditor.sprint2.view;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UMLNode extends Pane {

  private double offsetX;
  private double offsetY;
  private String className, fieldName, methodName, parameterName, relationship;
  private final String straightLine = "\n-------------------------------------\n";
  private static final double DEFAULT_WIDTH = 200;
  private static final double DEFAULT_HEIGHT = 200;
  private static final double NODE_SPACING = 20;
  private static double lastX = 100;
  private static double lastY = 100;

  // Constructor
  public UMLNode(String className) {
    this.className = className != null ? className : "Default Class Name";
    this.fieldName = "Default Field Name";
    this.methodName = "Default Method Name";
    this.parameterName = "Default Parameter Name";
    this.relationship = "Default Relationship";

    // Create label to display node information
    Label classLabel = new Label(createNode());
    classLabel.setStyle("-fx-font-weight: bold;");

    // Create a background rectangle for the node
    Rectangle background = new Rectangle(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    background.setFill(Color.LIGHTGREEN);
    background.setStroke(Color.BLACK);
    background.setArcWidth(10);
    background.setArcHeight(10);

    // Set padding and add background and label
    this.setPadding(new Insets(10));
    this.getChildren().addAll(background, classLabel);
    setPrefSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

    // Set initial position based on last node position
    setLayoutX(lastX);
    setLayoutY(lastY);
    // Use a listener to update the position after being added to the scene
    this.sceneProperty().addListener((obs, oldScene, newScene) -> {
      if (newScene != null) {
        updateLastPosition(newScene.getWidth());
      }
    });

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

  // Updates the last position for the next node
  private void updateLastPosition(double sceneWidth) {
    lastX += DEFAULT_WIDTH + NODE_SPACING;
    if (lastX + DEFAULT_WIDTH > sceneWidth) {
      lastX = 100;
      lastY += DEFAULT_HEIGHT + NODE_SPACING;
    }
  }

  public void setClassName(String className) {
    this.className = className;
    updateLabel();
  }

  public String getClassName() {
    return className;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
    updateLabel();
  }

  public String getFieldName() {
    return fieldName;
  }

  public void setMethodName(String methodName) {
    this.methodName = methodName;
    updateLabel();
  }

  public String getMethodName() {
    return methodName;
  }

  public void setParameterName(String parameterName) {
    this.parameterName = parameterName;
    updateLabel();
  }

  public String getParameterName() {
    return parameterName;
  }

  public void setRelationship(String relationship) {
    this.relationship = relationship;
    updateLabel();
  }

  public String getRelationship() {
    return relationship;
  }

  // Formats node content for display
  private String createNode() {
    return "\n Class Name: " + getClassName() + straightLine +
      " Field Name: " + getFieldName() + straightLine +
      " Method Name: " + getMethodName() +
      "\n Parameter: ( " + getParameterName() + " )" + straightLine +
      " Relationship: " + getRelationship();
  }

  // Updates the label text with the latest createNode output
  private void updateLabel() {
    if (!getChildren().isEmpty() && getChildren().get(1) instanceof Label) {
      Label label = (Label) getChildren().get(1);
      label.setText(createNode());
      adjustNodeSize();
    }
  }

  // Adjusts node size based on content
  private void adjustNodeSize() {
    double labelHeight = ((Label) getChildren().get(1)).getHeight();
    double labelWidth = ((Label) getChildren().get(1)).getWidth();
    setPrefSize(Math.max(DEFAULT_WIDTH, labelWidth + 20), Math.max(DEFAULT_HEIGHT, labelHeight + 20));
  }

  // Displays an error message in red
  public void showError(String errorMessage) {
    Label errorLabel = new Label(errorMessage);
    errorLabel.setTextFill(Color.RED);
    errorLabel.setStyle("-fx-font-weight: bold; -fx-background-color: white;");
    this.getChildren().clear();
    this.getChildren().add(errorLabel);
  }
}
