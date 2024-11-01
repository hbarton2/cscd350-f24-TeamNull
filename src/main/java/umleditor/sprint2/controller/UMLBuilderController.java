package umleditor.sprint2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import umleditor.sprint2.view.UMLNode;

public class UMLBuilderController {

  @FXML
  private VBox fieldsBox, methodsBox, relationshipsBox;
  @FXML
  private AnchorPane viewAnchorPane;
  @FXML
  private TextField classNameField;

  @FXML
  private TextField methodName;

  @FXML
  private TextField fieldName;
  @FXML
  private Button saveClassBNT;



  @FXML
  private TextArea textArea;
  //************* practice area below the line

  private String straigthLine = "\n____________________________________";

  @FXML
    public void createClass(ActionEvent actionEvent){

    textArea.setText("Class Name:\n" + classNameField.getText() + straigthLine +
                      "\nField Name: \n" + fieldName.getText() + straigthLine +
                      "\nMethod Name: \n" + methodName.getText() + straigthLine +
                      "\nRelationship: \n" );
    classNameField.clear();
    fieldName.clear();
    methodName.clear();

  }


  public void deleteNode(ActionEvent actionEvent) {
    textArea.clear();
  }
  public void saveClassAction(MouseEvent event) {

  }








  //************* practice area above the line
  @FXML
  public void addField() {
    HBox fieldBox = new HBox(5);
    TextField field = new TextField();
    field.setPromptText("Enter field");
    Button addButton = new Button("+");
    addButton.setOnAction(e -> addField());
    fieldBox.getChildren().addAll(field, addButton);
    fieldsBox.getChildren().add(fieldBox);
  }

  @FXML
  public void addMethod() {
    HBox methodBox = new HBox(5);
    TextField method = new TextField();
    method.setPromptText("Enter method");
    TextField parameters = new TextField();
    parameters.setPromptText("Enter parameters");
    Button addButton = new Button("+");
    addButton.setOnAction(e -> addMethod());
    methodBox.getChildren().addAll(method, parameters, addButton);
    methodsBox.getChildren().add(methodBox);
  }

  @FXML
  public void addRelationship() {
    HBox relationshipBox = new HBox(5);
    ChoiceBox<String> relationshipChoiceBox = new ChoiceBox<>();
    relationshipChoiceBox.getItems().addAll("Inheritance", "Association", "Aggregation", "Composition");
    Button addButton = new Button("+");
    addButton.setOnAction(e -> addRelationship());
    relationshipBox.getChildren().addAll(relationshipChoiceBox, addButton);
    relationshipsBox.getChildren().add(relationshipBox);
  }

  @FXML
  public void createNode() {
    // Collect information from fields
    String className = classNameField.getText();

    // TODO: Gather fields, methods, and relationships from fieldsBox, methodsBox, and relationshipsBox

    // Mock create node - add it to `viewAnchorPane`
    // Add your UMLNode creation logic here
  }

  public void exitProgram(ActionEvent actionEvent) {
    System.exit(0);
  }

  public void createMockNode(ActionEvent actionEvent) {
    UMLNode node = new UMLNode("");

    // Set initial position for the node, for example
    node.setLayoutX(100);  // Adjust X position as needed
    node.setLayoutY(100);  // Adjust Y position as needed

    // Add the node to the AnchorPane to display it
    viewAnchorPane.getChildren().add(node);
  }


  public void saveNode(ActionEvent actionEvent) {
  }

  public void loadNode(ActionEvent actionEvent) {
  }
/**
  public void deleteNode(ActionEvent actionEvent) {
  }

*/
}
