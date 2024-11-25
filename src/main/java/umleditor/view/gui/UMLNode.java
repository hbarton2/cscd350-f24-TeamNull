package umleditor.view.gui;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import umleditor.controller.utilities.Functions;

import javax.sound.sampled.Control;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;

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
 // private final TextArea testArea;
  private Line relationshipLine;
  private final Rectangle background;
  private static final String STRAIGHT_LINE = "\n-----------------------------------------\n";
  /**
   * Constructor for UMLNode.
   * Initializes a new UMLNode with a default or specified class name.
   */

  public UMLNode(String className) {
    this.className = (className != null) ? className : "Default Class Name";

     // this.testArea = testArea;
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
    relationshipLine = null;

    enableDragging();

  }
/**
  public UMLNode( TextArea testArea) {
    this.className = (className != null) ? className : "Default Class Name";
      this.testArea = testArea;
      // this.testArea = testArea;
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
 */
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
    relationshipLine = new Line() {
      /**
       * Obtains the {@code Line.Info} object describing this line.
       *
       * @return description of the line
       */
      @Override
      public Info getLineInfo() {
        return null;
      }

      /**
       * Opens the line, indicating that it should acquire any required system
       * resources and become operational. If this operation succeeds, the line is
       * marked as open, and an {@code OPEN} event is dispatched to the line's
       * listeners.
       * <p>
       * Note that some lines, once closed, cannot be reopened. Attempts to reopen
       * such a line will always result in an {@code LineUnavailableException}.
       * <p>
       * Some types of lines have configurable properties that may affect resource
       * allocation. For example, a {@code DataLine} must be opened with a
       * particular format and buffer size. Such lines should provide a mechanism
       * for configuring these properties, such as an additional {@code open}
       * method or methods which allow an application to specify the desired
       * settings.
       * <p>
       * This method takes no arguments, and opens the line with the current
       * settings. For {@link SourceDataLine} and {@link TargetDataLine} objects,
       * this means that the line is opened with default settings. For a
       * {@link Clip}, however, the buffer size is determined when data is loaded.
       * Since this method does not allow the application to specify any data to
       * load, an {@code IllegalArgumentException} is thrown. Therefore, you
       * should instead use one of the {@code open} methods provided in the
       * {@code Clip} interface to load data into the {@code Clip}.
       * <p>
       * For {@code DataLine}'s, if the {@code DataLine.Info} object which was
       * used to retrieve the line, specifies at least one fully qualified audio
       * format, the last one will be used as the default format.
       *
       * @throws IllegalArgumentException if this method is called on a Clip
       *                                  instance
       * @throws LineUnavailableException if the line cannot be opened due to
       *                                  resource restrictions
       * @throws SecurityException        if the line cannot be opened due to security
       *                                  restrictions
       * @see #close
       * @see #isOpen
       * @see LineEvent
       * @see DataLine
       * @see Clip#open(AudioFormat, byte[], int, int)
       * @see Clip#open(AudioInputStream)
       */
      @Override
      public void open() throws LineUnavailableException {
        int length = relationship.length();
      }

      /**
       * Closes the line, indicating that any system resources in use by the line
       * can be released. If this operation succeeds, the line is marked closed
       * and a {@code CLOSE} event is dispatched to the line's listeners.
       *
       * @throws SecurityException if the line cannot be closed due to security
       *                           restrictions
       * @see #open
       * @see #isOpen
       * @see LineEvent
       */
      @Override
      public void close() {
        relationship.endsWith("end of line");
      }

      /**
       * Indicates whether the line is open, meaning that it has reserved system
       * resources and is operational, although it might not currently be playing
       * or capturing sound.
       *
       * @return {@code true} if the line is open, otherwise {@code false}
       * @see #open()
       * @see #close()
       */
      @Override
      public boolean isOpen() {
        return false;
      }

      /**
       * Obtains the set of controls associated with this line. Some controls may
       * only be available when the line is open. If there are no controls, this
       * method returns an array of length 0.
       *
       * @return the array of controls
       * @see #getControl
       */
      @Override
      public Control[] getControls() {
        return new Control[0];
      }

      /**
       * Indicates whether the line supports a control of the specified type. Some
       * controls may only be available when the line is open.
       *
       * @param control the type of the control for which support is queried
       * @return {@code true} if at least one control of the specified type is
       * supported, otherwise {@code false}
       */
      @Override
      public boolean isControlSupported(Control.Type control) {
        return false;
      }

      /**
       * Obtains a control of the specified type, if there is any. Some controls
       * may only be available when the line is open.
       *
       * @param control the type of the requested control
       * @return a control of the specified type
       * @throws IllegalArgumentException if a control of the specified type is
       *                                  not supported
       * @see #getControls
       * @see #isControlSupported(Control.Type control)
       */
      @Override
      public Control getControl(Control.Type control) {
        return null;
      }

      /**
       * Adds a listener to this line. Whenever the line's status changes, the
       * listener's {@code update()} method is called with a {@code LineEvent}
       * object that describes the change.
       *
       * @param listener the object to add as a listener to this line
       * @see #removeLineListener
       * @see LineListener#update
       * @see LineEvent
       */
      @Override
      public void addLineListener(LineListener listener) {
          setLayoutX(baseX);
          setLayoutY(baseY);
      }

      /**
       * Removes the specified listener from this line's list of listeners.
       *
       * @param listener listener to remove
       * @see #addLineListener
       */
      @Override
      public void removeLineListener(LineListener listener) {

      }
    };
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
            "Method: " + getMethodType() + " "   + getMethodName() + " ( " + getParameterName() + ") : " +
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
  /**
  public void showError(String errorMessage) {
    Label errorLabel = new Label(errorMessage);
    errorLabel.setTextFill(Color.RED);
    errorLabel.setStyle("-fx-font-weight: bold; -fx-background-color: white;");
    errorLabel.setFont(new Font("Arial", 12));
    this.getChildren().setAll(background, errorLabel);
  }
  */
}