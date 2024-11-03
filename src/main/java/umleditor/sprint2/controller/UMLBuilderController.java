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
import javafx.scene.text.TextFlow;
import umleditor.sprint2.view.UMLNode;

/**
 * UMLBuilderController handles Node creation for GUI
 */
public class UMLBuilderController {

  public TextFlow classShape;

  @FXML
  private VBox fieldsBox, methodsBox, relationshipsBox;

  @FXML
  private AnchorPane viewAnchorPane;

  @FXML
  private TextField classNameField, methodName, fieldName, parameterName;

  @FXML
  private Button saveClassBNT;

  @FXML
  private TextArea textArea;

  @FXML
  private ChoiceBox<String> relationshipChoiceBox;

  private final String straightLine = "\n__________________________________";
  private int classCounter = 0;

  @FXML
  public void initialize() {
    // Initialize choice box items for relationships
    relationshipChoiceBox.getItems().addAll("Inheritance", "Association", "Aggregation", "Composition");

    // Add initial field and method for UI consistency (optional)
    addField();
    addMethod();
    addRelationship();
  }

  @FXML
  public void createClass(ActionEvent actionEvent) {
    // Check if required fields are filled
    if (classNameField.getText().isEmpty()) {
      showWarning("Class name is required.");
      return;
    }

    UMLNode node = new UMLNode("");
    classCounter++; // Count number of classes created

    node.setClassName(classNameField.getText() + "\n Class #: " + classCounter);
    node.setFieldName(fieldName.getText());
    node.setMethodName(methodName.getText());
    node.setParameterName(parameterName.getText());
    node.setRelationship(relationshipChoiceBox.getSelectionModel().getSelectedItem());

    // Set initial position for the node
    node.setLayoutX(100); // Adjust X position as needed
    node.setLayoutY(100); // Adjust Y position as needed

    // Add the node to the AnchorPane to display it
    viewAnchorPane.getChildren().add(node);

    // Display details in the TextArea
    textArea.setVisible(true);
    textArea.setText("Class Name:\n" + classNameField.getText() +
      straightLine + "\nField Name:\n" + fieldName.getText() +
      straightLine + "\nMethod Name:\n" + methodName.getText() +
      "\nParameters: ( " + parameterName.getText() + " )" +
      straightLine + "\nRelationship:\n" + relationshipChoiceBox.getSelectionModel().getSelectedItem());

    // Clear fields after saving
    clearFields();
  }

  private void showWarning(String message) {
    textArea.setVisible(true);
    textArea.setText(straightLine + "\n" + message + straightLine);
  }

  private void clearFields() {
    classNameField.clear();
    fieldName.clear();
    methodName.clear();
    parameterName.clear();
  }

  @FXML
  public void deleteNode(ActionEvent actionEvent) {
    textArea.clear();
    textArea.setVisible(false);
    // Additional logic to delete a specific node, if needed
  }

  @FXML
  public void saveClassAction(MouseEvent event) {
    // Implementation for save class action, if necessary
  }

  // Add a new field with a "-" button for deletion
  @FXML
  public void addField() {
    HBox fieldBox = new HBox(5);
    TextField field = new TextField();
    field.setPromptText("Enter field");

    Button addButton = new Button("+");
    addButton.setOnAction(e -> addField());

    Button removeButton = new Button("-");
    removeButton.setOnAction(e -> fieldsBox.getChildren().remove(fieldBox));

    fieldBox.getChildren().addAll(field, addButton, removeButton);
    fieldsBox.getChildren().add(fieldBox);
  }

  // Add a new method with a "-" button for deletion
  @FXML
  public void addMethod() {
    HBox methodBox = new HBox(5);
    TextField method = new TextField();
    method.setPromptText("Enter method");

    TextField parameters = new TextField();
    parameters.setPromptText("Enter parameters");

    Button addButton = new Button("+");
    addButton.setOnAction(e -> addMethod());

    Button removeButton = new Button("-");
    removeButton.setOnAction(e -> methodsBox.getChildren().remove(methodBox));

    methodBox.getChildren().addAll(method, parameters, addButton, removeButton);
    methodsBox.getChildren().add(methodBox);
  }

  // Add a new relationship with a "-" button for deletion
  @FXML
  public void addRelationship() {
    HBox relationshipBox = new HBox(5);
    ChoiceBox<String> relationshipChoice = new ChoiceBox<>();
    relationshipChoice.getItems().addAll("Inheritance", "Association", "Aggregation", "Composition");

    Button addButton = new Button("+");
    addButton.setOnAction(e -> addRelationship());

    Button removeButton = new Button("-");
    removeButton.setOnAction(e -> relationshipsBox.getChildren().remove(relationshipBox));

    relationshipBox.getChildren().addAll(relationshipChoice, addButton, removeButton);
    relationshipsBox.getChildren().add(relationshipBox);
  }

  @FXML
  public String getRelationship() {
    return relationshipChoiceBox.getSelectionModel().getSelectedItem();
  }

  @FXML
  public void createNode() {
    String className = classNameField.getText();
    // Additional node creation logic, if necessary
  }

  public void exitProgram(ActionEvent actionEvent) {
    System.exit(0);
  }

  public void createMockNode(ActionEvent actionEvent) {
    UMLNode node = new UMLNode("");
    node.setLayoutX(100);
    node.setLayoutY(100);
    viewAnchorPane.getChildren().add(node);
  }

  public void saveNode(ActionEvent actionEvent) {
    textArea.setVisible(true);
    textArea.setText(straightLine + "\nSave:\n  feature is in development mode." + straightLine);
  }

  public void loadNode(ActionEvent actionEvent) {
    textArea.setVisible(true);
    textArea.setText(straightLine + "\nLoad:\n feature is in development mode." + straightLine);
    // Load node logic here
  }
}
