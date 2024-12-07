package umleditor.view.gui;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import umleditor.controller.utilities.Functions;
import umleditor.model.uml.MethodSignature;
import umleditor.model.uml.UMLAttribute;
import umleditor.model.uml.UMLClass;

import java.util.ArrayList;
import java.util.List;
import umleditor.controller.MovableLine;
import umleditor.model.uml.UMLRelationship;
import umleditor.model.utilities.Storage;

public class UMLNode extends Pane {
    private String className;
    private final UMLClass classObject;

    private double offsetX;
    private double offsetY;
    private static final double DEFAULT_WIDTH = 200;
    private static final double DEFAULT_HEIGHT = 200;
    private static final double NODE_SPACING_X = 220; // Horizontal spacing
    private static final double NODE_SPACING_Y = 250; // Vertical spacing
    private static final int NODES_PER_ROW = 4;
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

    public UMLNode(UMLClass classObject) {

        this.classObject = classObject;
        this.className = classObject.getClassName();

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
        // prints the x & y position of the boxes

        System.out.print(" x position is: " + x + " y position is: " + y);
        System.out.println();
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
    public void updateLabel() {
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
                "Field: " + displayFields() + STRAIGHT_LINE +
                "Method: " + displayMethods() + STRAIGHT_LINE +
                "Relationship: " + displayRelationships();
    }


    private String displayMethods() {
        List<MethodSignature> methods = classObject.getMethods();
        if (methods.isEmpty()) {
            return "-";
        }
        StringBuilder result = new StringBuilder();
        for (MethodSignature method : methods) {
            result.append(method.toString()).append("\n");
        }
        return result.toString().trim(); // Remove the trailing newline
    }


    private String displayFields(){
        List<UMLAttribute> fields = classObject.getAttributes();
        if (fields.isEmpty()) {
            return "-";
        }
        StringBuilder result = new StringBuilder();
        for (UMLAttribute field : fields) {
            result.append(field.toString()).append("\n");
        }
        return result.toString().trim(); // Remove the trailing newline
    }

    private String displayRelationships(){
        List<UMLRelationship> relationships = Storage.getInstance().getRelationships();
        if (relationships.isEmpty()) {
            return "-";
        }
        StringBuilder result = new StringBuilder();
        for (UMLRelationship relation : relationships) {
            result.append(relation.StringForNodes()).append("\n");
        }
        return result.toString().trim(); // Remove the trailing newline
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

}