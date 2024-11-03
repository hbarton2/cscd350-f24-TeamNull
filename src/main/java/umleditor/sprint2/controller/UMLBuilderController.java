package umleditor.sprint2.controller;

import java.util.List;
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

public class UMLBuilderController {

  public TextFlow classShape;
  public Button saveClass;
  public TextField fieldType;
  public TextField methodType;
  public TextField parameterType;
  public ChoiceBox relationshipChoiceBox;
  public Button saveClassBNT;

  @FXML
  private VBox fieldsBox, methodsBox, relationshipsBox;

  @FXML
  private AnchorPane viewAnchorPane;

  @FXML
  private TextField classNameField, methodName, fieldName, parameterName;

  @FXML
  private TextArea textArea;

  private final List<String> relationshipTypes = List.of("None", "Generalization", "Realization",
    "Dependency", "Association", "Aggregation", "Composition");
  private final String straightLine = "\n__________________________________";
  private int classCounter = 0;

  @FXML
  public void initialize() {
    // Initialize first relationship ChoiceBox with items
    if (!relationshipsBox.getChildren().isEmpty()) {
      HBox firstRelationshipBox = (HBox) relationshipsBox.getChildren().get(0);
      ChoiceBox<String> relationshipChoiceBox = (ChoiceBox<String>) firstRelationshipBox.getChildren()
        .get(0);
      relationshipChoiceBox.getItems().addAll(relationshipTypes);
      relationshipChoiceBox.setValue(relationshipTypes.get(0)); // Set default value
    }
  }

  @FXML
  public void createClass(ActionEvent actionEvent) {
    if (classNameField.getText().isEmpty()) {
      showWarning("Class name is required.");
      return;
    }

    UMLNode node = new UMLNode("");
    classCounter++;
    node.setClassName(classNameField.getText() + "\n Class #: " + classCounter);
    node.setFieldName(fieldName.getText());
    node.setMethodName(methodName.getText());
    node.setParameterName(parameterName.getText());

    node.setLayoutX(100);
    node.setLayoutY(100);

    viewAnchorPane.getChildren().add(node);

    textArea.setVisible(true);
    textArea.setText("Class Name:\n" + classNameField.getText() +
      straightLine + "\nField Name:\n" + fieldName.getText() +
      straightLine + "\nMethod Name:\n" + methodName.getText() +
      "\nParameters: ( " + parameterName.getText() + " )");

    resetFields();
  }

  private void showWarning(String message) {
    textArea.setVisible(true);
    textArea.setText(straightLine + "\n" + message + straightLine);
  }

  private void resetFields() {
    classNameField.clear();
    fieldName.clear();
    methodName.clear();
    parameterName.clear();

    // Remove dynamically added elements only, keeping the initial setup intact
    fieldsBox.getChildren().removeIf(node -> fieldsBox.getChildren().indexOf(node) > 0);
    methodsBox.getChildren().removeIf(node -> methodsBox.getChildren().indexOf(node) > 0);
    relationshipsBox.getChildren()
      .removeIf(node -> relationshipsBox.getChildren().indexOf(node) > 0);
  }

  @FXML
  public void deleteNode(ActionEvent actionEvent) {
    textArea.clear();
    textArea.setVisible(false);
  }

  @FXML
  public void saveClassAction(MouseEvent event) {
    // Placeholder for save functionality
  }

  @FXML
  public void addField() {
    HBox fieldBox = new HBox(5);
    TextField fieldType = new TextField();
    fieldType.setPromptText("Enter data type");

    TextField fieldName = new TextField();
    fieldName.setPromptText("Enter field name");

    Button addButton = new Button("+");
    addButton.setOnAction(e -> addField());

    Button removeButton = new Button("-");
    removeButton.setOnAction(e -> fieldsBox.getChildren().remove(fieldBox));

    fieldBox.getChildren().addAll(fieldType, fieldName, addButton, removeButton);
    fieldsBox.getChildren().add(fieldBox);
  }

  @FXML
  public void addMethod() {
    HBox methodBox = new HBox(5);

    TextField returnType = new TextField();
    returnType.setPromptText("Enter return type");

    TextField methodName = new TextField();
    methodName.setPromptText("Enter method name");

    TextField parameterType = new TextField();
    parameterType.setPromptText("Enter parameter type");

    TextField parameterName = new TextField();
    parameterName.setPromptText("Enter parameter name");

    Button addButton = new Button("+");
    addButton.setOnAction(e -> addMethod());

    Button removeButton = new Button("-");
    removeButton.setOnAction(e -> methodsBox.getChildren().remove(methodBox));

    methodBox.getChildren()
      .addAll(returnType, methodName, parameterType, parameterName, addButton, removeButton);
    methodsBox.getChildren().add(methodBox);
  }

  @FXML
  public void addRelationship() {
    HBox relationshipBox = new HBox(5);

    ChoiceBox<String> relationshipChoice = new ChoiceBox<>();
    relationshipChoice.getItems().addAll(relationshipTypes);
    relationshipChoice.setValue(relationshipTypes.get(0)); // Set default value

    Button addButton = new Button("+");
    addButton.setOnAction(e -> addRelationship());

    Button removeButton = new Button("-");
    removeButton.setOnAction(e -> relationshipsBox.getChildren().remove(relationshipBox));

    relationshipBox.getChildren().addAll(relationshipChoice, addButton, removeButton);
    relationshipsBox.getChildren().add(relationshipBox);
  }

  public void exitProgram(ActionEvent actionEvent) {
    System.exit(0);
  }

  public void saveNode(ActionEvent actionEvent) {
    textArea.setVisible(true);
    textArea.setText(straightLine + "\nSave:\n  feature is in development mode." + straightLine);
  }

  public void loadNode(ActionEvent actionEvent) {
    textArea.setVisible(true);
    textArea.setText(straightLine + "\nLoad:\n feature is in development mode." + straightLine);
  }

  public void createMockNode(ActionEvent actionEvent) {
    UMLNode node = new UMLNode("");
    node.setLayoutX(100);
    node.setLayoutY(100);
    viewAnchorPane.getChildren().add(node);
  }
}
