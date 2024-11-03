package umleditor.sprint2.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import umleditor.sprint1.utilities.Functions;
import umleditor.sprint2.view.UMLNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Random;

public class UMLBuilderController {
  @FXML private VBox fieldsBox, methodsBox, relationshipsBox;
  @FXML private AnchorPane viewAnchorPane;
  @FXML private TextField classNameField, methodName,fieldName, parameterName ;
  @FXML private Button saveClassBNT;
  @FXML private TextArea textArea;
  @FXML private Button saveClass;
  @FXML private String straightLine = "\n__________________________________";
  @FXML int classCounter = 0;

    @FXML
    public void createClass(ActionEvent actionEvent) {

        if (classNameField.getText().isEmpty() || fieldName.getText().isEmpty() || parameterName.getText().isEmpty()) {
            textArea.setVisible(true);
            textArea.setText(straightLine + "\nNot enough user data is provided \n please fill out the fields" + straightLine);
            return;
        }

        UMLNode node = new UMLNode("");

        classCounter ++; // counting number of classes created

        node.setClassName(classNameField.getText() + "\n Class #: " + classCounter );
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
                straightLine + "\nRelationship:\n" + relationshipChoiceBox.getSelectionModel().getSelectedItem() );

        // Optionally clear fields after saving
        classNameField.clear();
        fieldName.clear();
        methodName.clear();
        parameterName.clear();
    }

    public void deleteNode(ActionEvent actionEvent) {

      textArea.clear();
      textArea.setVisible(false);

    // need to set the content of the node to clear
  }

  public void saveClassAction(MouseEvent event) {
    // Implementation for save class action
  }

  @FXML
  public void addField() {
    HBox fieldBox = new HBox(5);
    TextField field = new TextField();
    field.setPromptText("Enter field");

    field.setId(fieldName.getText());

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
    HBox relationshipBox = new HBox(5);
    ChoiceBox<String> relationshipChoiceBox = new ChoiceBox<>();
  @FXML
  public void addRelationship() {
    //HBox relationshipBox = new HBox(5);
    //ChoiceBox<String> relationshipChoiceBox = new ChoiceBox<>();
    relationshipChoiceBox.getItems().addAll("Inheritance", "Association", "Aggregation", "Composition");
    Button addButton = new Button("+");
    addButton.setOnAction(e -> addRelationship());
    relationshipBox.getChildren().addAll(relationshipChoiceBox, addButton);
    relationshipsBox.getChildren().add(relationshipBox);
  }

  @FXML
  public String getRelationship(){
      return getRelationship();
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