package umleditor.sprint2.view;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UMLNode extends Pane {

  private double offsetX;
  private double offsetY;
  private String className, fieldName, methodName, parameterName, relationship, fieldType;
  // private String fieldName;
  // private String methodName;
  // private String fieldType; // not implemented yet
  // private String parameterName;
  // private String relationship;
  private String straightLine = "\n-------------------------------------\n";

  public UMLNode(String className) {

      this.className = className != null ? className : "Default Class Name";
      this.fieldName = "Default Field Name";
      this.methodName = "Default Method Name";
      this.parameterName = "Default Parameter Name";
      this.relationship = "Default Relationship";

    // Set dimensions and initial styling
      this.setPrefSize(200, 200);
     //this.setStyle("-fx-border-color: blue; -fx-background-color: lighgreen;");
    //this.setStyle("-fx-border-color: red; -fx-background-color: lightgreen;");

      this.setStyle("-fx-border-color: red; ");

    // Create label and set text to display node information
   // Label classLabel = new Label(mockNode());

    Label classLabel = new Label(createNode());
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

 public void setRelationship(String relationship) {
    this.relationship = relationship;
    updateLabel();
 }

 public String getRelationship() {
    return relationship;
 }

    // This method makes a node by adding
    // user entered text and formats them

    // only for demo purposes.
    public String mockNode() {

        return "\nClass Name: " + getClassName() + straightLine +
                " Field Name: " +  getFieldName() + straightLine +
                " Method Name: " + getMethodName()  +
                "\n Parameter: ( " + getParameterName() +" )"+ straightLine +
                " Relationship: " + getRelationship() ;

    }

    public String createNode() {

        return "\n Class Name: " + getClassName() + straightLine +
                " Field Name: " +  getFieldName() + straightLine +
                " Method Name: " + getMethodName()  +
                "\n Parameter: ( " + getParameterName() +" )"+ straightLine +
                " Relationship: " + getRelationship() ;
    }

  // Updates the label text with the latest mockNode output
  private void updateLabel() {
    if (!getChildren().isEmpty() && getChildren().get(0) instanceof Label) {
      Label label = (Label) getChildren().get(0);
      label.setText(createNode());
    }
  }
}