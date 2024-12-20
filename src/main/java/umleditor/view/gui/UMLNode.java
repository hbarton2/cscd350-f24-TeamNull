package umleditor.view.gui;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
import umleditor.model.utilities.AnchorPoint;
import umleditor.model.utilities.Storage;

public class UMLNode extends Pane {
    private String className;
    private final UMLClass classObject;

    private  Circle top;
    private Circle bottom;
    private Circle left;
    private Circle right;

    private ArrayList<AnchorPoint> anchorPoints;
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
        setAnchorPoints();

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
            //updateAnchorPoints();
        });
        //updateAnchorPoints();
    }
    /**
     * Updates the node's label and adjusts its size.
     */
    public void updateLabel() {
        if(classObject != null) {
            classLabel.setText(formatNodeContent());
            adjustNodeSize();
        }
        else
            this.setVisible(false);
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
                "Method: " + displayMethods() + STRAIGHT_LINE;
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

    private void setAnchorPoints(){
        this.anchorPoints = new ArrayList<>();

        anchorPoints.add(new AnchorPoint(this.getLayoutX() + this.DEFAULT_WIDTH / 2, this.getLayoutY() + this.DEFAULT_HEIGHT)); //bottom
        anchorPoints.add(new AnchorPoint(this.getLayoutX() + this.DEFAULT_WIDTH / 2 , this.getLayoutY())); //top
        anchorPoints.add(new AnchorPoint(this.getLayoutX(),this.getLayoutY() + this.DEFAULT_HEIGHT / 2)); //left
        anchorPoints.add(new AnchorPoint(this.getLayoutX() + this.DEFAULT_WIDTH, this.getLayoutY() + this.DEFAULT_HEIGHT / 2)); //right


        // Create circles for debugging
//        Circle bottom = new Circle(this.anchorPoints.get(0).getX(), this.anchorPoints.get(0).getY(), 5, Color.RED);
//        System.out.println("Circle x: " + this.anchorPoints.get(0).getX());
//        Circle top = new Circle(this.anchorPoints.get(1).getX(), this.anchorPoints.get(1).getY(), 5, Color.BLUE);
//        Circle right = new Circle(this.anchorPoints.get(2).getX(), this.anchorPoints.get(2).getY(), 5, Color.GREEN);
//        Circle left = new Circle(this.anchorPoints.get(3).getX(), this.anchorPoints.get(3).getY(), 5, Color.YELLOW);
//
//        this.top = top;
//        this.bottom = bottom;
//        this.left = left;
//        this.right = right;
//
//        this.getChildren().add(top);
//        this.getChildren().add(bottom);
//        this.getChildren().add(right);
//        this.getChildren().add(left);
    }


    private void updateAnchorPoints(){
        this.anchorPoints.get(0).updatePos(this.getLayoutX() + this.getWidth() / 2, this.getLayoutY() + this.getHeight());
        this.anchorPoints.get(1).updatePos(this.getLayoutX() + this.getWidth() / 2, this.getLayoutY());
        this.anchorPoints.get(2).updatePos(this.getLayoutX(),this.getLayoutY() + this.getHeight() / 2);
        this.anchorPoints.get(3).updatePos(this.getLayoutX() + this.getWidth(), this.getLayoutY() + this.getHeight() / 2);
    }

    public AnchorPoint getAnchorPoint(int i) {
        return anchorPoints.get(i);
    }

}