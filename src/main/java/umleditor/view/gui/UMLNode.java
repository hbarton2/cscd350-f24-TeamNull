package umleditor.view.gui;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import umleditor.controller.utilities.Functions;
public class UMLNode extends Pane {
  private String className;
  private String fieldName;
  private String fieldType;
  private String methodName;
  private String methodType;
  private String parameterName;
  private String parameterType;
  private String relationship;
  private double offsetX;
  private double offsetY;
  private static final double DEFAULT_WIDTH = 200;
  private static final double DEFAULT_HEIGHT = 200;
  private static final double NODE_SPACING_X = 220; // Horizontal spacing
  private static final double NODE_SPACING_Y = 250; // Vertical spacing
  private static final int NODES_PER_ROW = 3;
  private static double baseX = 0;
  private static double baseY = 0;
  private static int nodeCounter = 0;
  private final Label classLabel;
  private final Rectangle background;
  private static final String STRAIGHT_LINE = "\n-----------------------------------------\n";
  /**
   * Constructor for UMLNode.
   * Initializes a new UMLNode with a default or specified class name.
   */
  public UMLNode(String className) {
    this.className = (className != null) ? className : "Default Class Name";
    this.fieldName = "";
    this.fieldType = "";
    this.methodName = "";
    this.methodType = "";
    this.parameterName = "";
    this.parameterType = "";
    this.relationship = "";
    // Initialize and style label
    classLabel = new Label(formatNodeContent());
    classLabel.setStyle("-fx-font-weight: bold;");
    classLabel.setWrapText(true);
    classLabel.setFont(new Font("Arial", 12));
    classLabel.setTextAlignment(TextAlignment.LEFT);
    // Initialize and style background rectangle
    background = new Rectangle(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    background.setFill(Color.LIGHTBLUE);
    background.setStroke(Color.BLACK);
    background.setArcWidth(10);
    background.setArcHeight(10);
    // Add background and label to the pane
    this.setPadding(new Insets(10));
    this.getChildren().addAll(background, classLabel);
    setPrefSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    // Automatically position the node
    setPositionAutomatically();
    // Add dragging functionality
    enableDragging();
  }
  /**
   * Automatically positions nodes in two rows of three.
   */
  private void setPositionAutomatically() {
    int row = nodeCounter / NODES_PER_ROW; // Determine the row index
    int col = nodeCounter % NODES_PER_ROW; // Determine the column index
    double x = baseX + col * NODE_SPACING_X; // Horizontal position
    double y = baseY + row * NODE_SPACING_Y; // Vertical position
    setLayoutX(x);
    setLayoutY(y);
    nodeCounter++;
  }
  /**
   * Enables dragging functionality for the UMLNode.
   */
  private void enableDragging() {
    this.setOnMousePressed(event -> {
      offsetX = event.getSceneX() - getLayoutX();
      offsetY = event.getSceneY() - getLayoutY();
    });
    this.setOnMouseDragged(event -> {
      setLayoutX(event.getSceneX() - offsetX);
      setLayoutY(event.getSceneY() - offsetY);
    });
  }
  /**
   * Updates the node's label and adjusts its size.
   */
  private void updateLabel() {
    classLabel.setText(formatNodeContent());
    adjustNodeSize();
  }
  /**
   * Adjusts the size of the node to fit its content.
   */
  private void adjustNodeSize() {
    double labelHeight = classLabel.getHeight();
    double labelWidth = classLabel.getWidth();
    double newWidth = Math.max(DEFAULT_WIDTH, labelWidth + 20);
    double newHeight = Math.max(DEFAULT_HEIGHT, labelHeight + 20);
    setPrefSize(newWidth, newHeight);
    background.setWidth(newWidth);
    background.setHeight(newHeight);
  }
  /**
   * Formats the content displayed in the node.
   */
  private String formatNodeContent() {
    return "Class Name: " + getClassName() + STRAIGHT_LINE +
            "Fields:\n " + getFieldName() + "   " + getFieldType() + STRAIGHT_LINE +
            "Method: " + getMethodName() + " (" + getMethodType() + " " + getParameterName() + ") : " +
            getParameterType() + STRAIGHT_LINE +
            "Relationship: " + getRelationship();
  }

  // Setters and Getters
  public void setClassName(String className) {
    Functions.createClass(className); // Set class in UMLClass
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
  /**
   * Displays an error message in red on the node.
   */
  public void showError(String errorMessage) {
    Label errorLabel = new Label(errorMessage);
    errorLabel.setTextFill(Color.RED);
    errorLabel.setStyle("-fx-font-weight: bold; -fx-background-color: white;");
    errorLabel.setFont(new Font("Arial", 12));
    this.getChildren().setAll(background, errorLabel);
  }
}