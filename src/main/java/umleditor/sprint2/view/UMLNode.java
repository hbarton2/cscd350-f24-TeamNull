package umleditor.sprint2.view;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
public class UMLNode extends Pane {

  private double offsetX;
  private double offsetY;
  private String className;
  private String fieldName;
  private String methodName;
  private String fieldType; // not implemented yet
  private String parameterName;


  public UMLNode(String className) {
    this.className = className != null ? className : "Default Class Name";
    this.fieldName = "Default Field Name";
    this.methodName = "Default Method Name";
    this.parameterName = "Default Parameter Name";
    // Set dimensions and initial styling
    this.setPrefSize(250, 150);
    this.setStyle("-fx-border-color: black; -fx-background-color: lightgreen;");
    // Create label and set text to display node information
    Label classLabel = new Label(mockNode());
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

  public String mockNode() {
    return "\nClass Name: " + getClassName() + "\nField Name: " + getFieldName() +
            "\nMethod Name: " + getMethodName() + "\nParameter Name: " + getParameterName();
  }
  // Updates the label text with the latest mockNode output
  private void updateLabel() {
    if (!getChildren().isEmpty() && getChildren().get(0) instanceof Label) {
      Label label = (Label) getChildren().get(0);
      label.setText(mockNode());
    }
  }
}