package umleditor.sprint2.view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import umleditor.sprint1.utilities.Functions;

public class UMLNode extends Pane {

  private String className, fieldName, fieldType, methodName, methodType, parameterName, parameterType, relationship;
  private double offsetX;
  private double offsetY;
  private final String straightLine = "\n-----------------------------------------\n";
  private static final double DEFAULT_WIDTH = 200;  // Increased width by 50 pixels
  private static final double DEFAULT_HEIGHT = 200;
  private static final double NODE_SPACING = 220;
  private static double baseX = 200;
  private static double baseY = 200;
  private static int nodeCounter = 0;

  private final Label classLabel;
  private final Rectangle background;

  // Constructor
  public UMLNode(String className) {
    this.className = className != null ? className : "Default Class Name";
    this.fieldName = "Default Field Name";
    this.fieldType = "Default Field Type";
    this.methodName = "Default Method Name";
    this.methodType = "Default Method Type";
    this.parameterName = "Default Parameter Name";
    this.parameterType = "Default Parameter Type";
    this.relationship = "Default Relationship";

    // Create and style label for node content
    classLabel = new Label(formatNodeContent());
    classLabel.setStyle("-fx-font-weight: bold;");
    classLabel.setWrapText(true);
    classLabel.setFont(new Font("Arial", 12));
    classLabel.setTextAlignment(TextAlignment.LEFT); // Left align text

    // Create background rectangle for node with rounded edges
    background = new Rectangle(DEFAULT_WIDTH, DEFAULT_HEIGHT);
   // background.setFill(Color.LIGHTGREEN);
    background.setFill(Color.LIGHTBLUE);
    background.setStroke(Color.BLACK);
    background.setArcWidth(10);
    background.setArcHeight(10);

    // Set padding and add background and label
    this.setPadding(new Insets(10));
    this.getChildren().addAll(background, classLabel);
    setPrefSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

    // Position based on the node counter and pattern
    setPositionAutomatically();

    // Event handlers for dragging
    this.setOnMousePressed(event -> {
      offsetX = event.getSceneX() - getLayoutX();
      offsetY = event.getSceneY() - getLayoutY();
    });
    this.setOnMouseDragged(event -> {
      setLayoutX(event.getSceneX() - offsetX);
      setLayoutY(event.getSceneY() - offsetY);
    });
  }

  // Positions nodes in a clockwise pattern around the starting position
  public void setPositionAutomatically() {
    double x = baseX;
    double y = baseY;

    switch (nodeCounter % 4) {
      case 0: // First node or every 4th node - start position
        break;
      case 1: // Move right
        x += NODE_SPACING;
        break;
      case 2: // Move down
        y += NODE_SPACING;
        break;
      case 3: // Move left of the start position
        x -= NODE_SPACING;
        break;
    }

    setLayoutX(x);
    setLayoutY(y);
    nodeCounter++;
  }

  public void setClassName(String className) {

    Functions.createClass(className);// sets class name in UMLClass

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

  public void setFieldType(String fieldType) {
    this.fieldType = fieldType;
    updateLabel();
  }

  public String getFieldType() {
    return fieldType;
  }

  public void setMethodName(String methodName) {
    this.methodName = methodName;
    updateLabel();
  }

  public String getMethodName() {
    return methodName;
  }

  public void setMethodType(String methodType) {
    this.methodType = methodType;
    updateLabel();
  }

  public String getMethodType() {
    return methodType;
  }

  public void setParameterName(String parameterName) {
    this.parameterName = parameterName;
    updateLabel();
  }

  public String getParameterName() {
    return parameterName;
  }

  public void setParameterType(String parameterType) {
    this.parameterType = parameterType;
    updateLabel();
  }

  public String getParameterType() {
    return parameterType;
  }

  public void setRelationship(String relationship) {
    this.relationship = relationship;
    updateLabel();
  }

  public String getRelationship() {
    return relationship;
  }

  // Formats the content to be displayed in the node, green class box
  private String formatNodeContent() {
    return
            "Class Name:  " +  getClassName() + straightLine +
            "Field type:  " +  getFieldType() + " " +
            "\nField name:  " +  getFieldName() + straightLine +
            "\nMethod type:  " + getMethodType() + " " +
            "\nMethod name:  " + getMethodName() +
            "\nParameter: (" + getParameterType() + " " + getParameterName() + ")" + straightLine +
            "Relationship:  " + getRelationship();
  }
/**
// Formats the content to be displayed in the node, green class box
private String formatNodeContent() {
  return
            "                      " + getClassName() + straightLine +
            " + " + getFieldName() +  " : " +   getFieldType()  + straightLine +
            " + " + getMethodName() + " ( " + getParameterType() + " " + getParameterName() + " ) "+
            " : "   +    getMethodType() +
            straightLine +
            "Relationship: " + getRelationship();
}
*/

  // Updates the label text with the formatted node content
  private void updateLabel() {
    classLabel.setText(formatNodeContent());
    adjustNodeSize();
  }

  // Adjust node size based on content, ensuring it fits the text neatly
  private void adjustNodeSize() {
    double labelHeight = classLabel.getHeight();
    double labelWidth = classLabel.getWidth();
    setPrefSize(Math.max(DEFAULT_WIDTH, labelWidth + 20), Math.max(DEFAULT_HEIGHT, labelHeight + 20));
    background.setWidth(Math.max(DEFAULT_WIDTH, labelWidth + 20));
    background.setHeight(Math.max(DEFAULT_HEIGHT, labelHeight + 20));
  }

  // Displays an error message in red
  public void showError(String errorMessage) {
    Label errorLabel = new Label(errorMessage);
    errorLabel.setTextFill(Color.RED);
    errorLabel.setStyle("-fx-font-weight: bold; -fx-background-color: white;");
    errorLabel.setFont(new Font("Arial", 12));
    this.getChildren().setAll(background, errorLabel);
  }
}
