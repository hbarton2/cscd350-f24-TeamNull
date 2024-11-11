package umleditor.sprint2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import umleditor.sprint1.utilities.Functions;
import umleditor.sprint1.utilities.Storage;
import umleditor.sprint2.view.UMLNode;

import java.util.List;

public class UMLBuilderController {

    @FXML
    private ScrollPane fieldArea; // field area is the whole area with field box, drop down menu, plus and minus buttons

    @FXML
    private Label relationshipLabel;

    @FXML
    private Label bigLabelforClass;

    @FXML
    private ScrollPane area;

    @FXML
    private ScrollPane methodArea; // method area is the whole area with field box, drop down menu, plus and minus buttons
    @FXML
    private Label methodLabel; // label for method area

    @FXML
    private Button methodSaveButton;

    @FXML
    private Button saveClassName;

    @FXML
    private Label classNameLable; // Label on top of the field that shows class name

















    @FXML
    private TextField classNameToSaveField;

    @FXML
    private TextField fieldName;


    @FXML
    private TextField fileName;

















    @FXML
    private Label fieldsLabel;
    private final List<String> dropDownChoices = List.of("Select data type","void","String","int","double","float","char", "boolean","byte", "short", "long","Arrays","Integer", "Object");

    @FXML
    private ChoiceBox<String> methodDataTypeChoice;
    // private final List<String> methodDataTypeChoiceList = List.of("Select data type","Non","String","int","double","float","Object");

    @FXML
    private ChoiceBox<String> pramRetunDataTypeChoice;
    // private final List<String> pramRetunDataTypeChoiceList = List.of("Select data type","Non","String","int","double","float","Object");

    // public TextFlow classShape;
    @FXML
    public Button saveClass;

    public ChoiceBox<String> relationshipChoiceBox;

    @FXML
    private VBox fieldsBox, methodsBox, relationshipsBox;

    @FXML
    private AnchorPane viewAnchorPane;

    @FXML
    private TextField classNameField;

    @FXML
    private TextArea textArea;

    @FXML
    private ChoiceBox<String> fieldTypeChoice;

    @FXML
    private Button  fieldSaveButton;
    // private final List<String> fieldDataTypeList = List.of("Select data type","Non","String","int","double","float","Object");


    private final List<String> relationshipTypes = List.of("None", "Generalization", "Realization",
            "Dependency", "Association", "Aggregation", "Composition");
    private final String straightLine = "\n__________________________________";
    private int classCounter = 0;





    @FXML
    public void initialize() {
        // methodDataTypeChoice.getItems().addAll(methodDataTypeChoiceList); // drop down menu for user to select method data type
        methodDataTypeChoice.getItems().addAll(dropDownChoices);
        // pramRetunDataTypeChoice.getItems().addAll(pramRetunDataTypeChoiceList); // drop down menu for user to select para meter data type
        pramRetunDataTypeChoice.getItems().addAll(dropDownChoices); // drop down menu for user to select para meter data type

        // fieldTypeChoice.getItems().addAll(fieldDataTypeList); // Field Data Type dropdown menu show list of options

        fieldTypeChoice.getItems().addAll(dropDownChoices); // Field Data Type dropdown menu show list of options

        // Initialize first relationship ChoiceBox with items
        if (!relationshipsBox.getChildren().isEmpty()) {
            HBox firstRelationshipBox = (HBox) relationshipsBox.getChildren().get(0);
            ChoiceBox<String> relationshipChoiceBox = (ChoiceBox<String>) firstRelationshipBox.getChildren()
                    .get(0);
            relationshipChoiceBox.getItems().addAll(relationshipTypes);
            relationshipChoiceBox.setValue(relationshipTypes.get(0)); // Set default value
        }

    }

    // Warning Box
    private void showWarning(String message) {
        textArea.setVisible(true);
        textArea.setStyle("-fx-text-fill: red; -fx-font-weight: bold;"); // Red font for error box
        textArea.setText(straightLine + "\n" + message + straightLine);
    }


    // Information box
    private void infoBox(String message) {
        textArea.setVisible(true);
        textArea.setStyle("-fx-text-fill: green; -fx-font-weight: bold;"); // Red font for error box
        textArea.setText(straightLine + "\n" + message + straightLine);
    }

    private void resetFields() {
        // Clear the class name field and the main text area
        classNameField.clear();
        textArea.clear();
        textArea.setStyle("-fx-text-fill: black;");

        // Clear the text in all dynamically added fields and methods without removing them
        fieldsBox.getChildren().forEach(node -> {
            if (node instanceof HBox) {
                ((TextField)((HBox) node).getChildren().get(0)).clear(); // Clear field type
                ((TextField)((HBox) node).getChildren().get(1)).clear(); // Clear field name
            }
        });

        methodsBox.getChildren().forEach(node -> {
            if (node instanceof HBox) {
                ((TextField)((HBox) node).getChildren().get(0)).clear(); // Clear return type
                ((TextField)((HBox) node).getChildren().get(1)).clear(); // Clear method name
                ((TextField)((HBox) node).getChildren().get(2)).clear(); // Clear parameter type
                ((TextField)((HBox) node).getChildren().get(3)).clear(); // Clear parameter name
            }
        });

        // Clear the selection in the first relationship choice box if it exists
        relationshipsBox.getChildren().forEach(node -> {
            if (node instanceof HBox) {
                ((ChoiceBox<String>)((HBox) node).getChildren().get(0)).setValue("None"); // Reset to default
            }
        });
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


    // This method adds more Fields on the screen when user clicks the plus button
    @FXML
    public void addField() {
        HBox fieldBox = new HBox(5);
        TextField fieldType = new TextField();
        //  fieldType.setPromptText("Enter data type");


        TextField fieldName = new TextField();
        fieldName.setPromptText("Enter field name");

        //drop down for method data type
        ChoiceBox<String> fieldTypeChoice = new ChoiceBox<>();
        // fieldTypeChoice.getItems().addAll(fieldDataTypeList);
        fieldTypeChoice.getItems().addAll(dropDownChoices);

        Button fieldSaveButton = new Button("Save");



        Button addButton = new Button("+");
        addButton.setOnAction(e -> addField());  // Allows adding more fields

        //ddButton.setOnAction(e -> fieldTypeChoice.getChildren().add(fieldTypeChoice));

        Button removeButton = new Button("-");
        removeButton.setOnAction(e -> fieldsBox.getChildren().remove(fieldBox));

        fieldBox.getChildren().addAll(fieldType, fieldName,fieldTypeChoice, addButton, removeButton, fieldSaveButton);
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

        ChoiceBox<String> methodTypeChoice = new ChoiceBox<>();
        methodTypeChoice.getItems().addAll(relationshipTypes);

        Button methodSaveButton = new Button("Save");
        // Button addButton = new Button("+");

        // drop down menu for user to select parameter data type
        ChoiceBox<String> pramReturnDataTypeChoice = new ChoiceBox<>();
        // pramReturnDataTypeChoice.getItems().addAll(pramRetunDataTypeChoiceList);
        pramReturnDataTypeChoice.getItems().addAll(dropDownChoices);

        TextField parameterName = new TextField();
        parameterName.setPromptText("Enter parameter name");

        Button addButton = new Button("+");
        addButton.setOnAction(e -> addMethod());  // Allows adding more methods

        Button removeButton = new Button("-");
        removeButton.setOnAction(e -> methodsBox.getChildren().remove(methodBox));

        methodBox.getChildren().addAll(returnType, methodName, methodTypeChoice, parameterType, parameterName,pramReturnDataTypeChoice, addButton, removeButton, methodSaveButton);
        methodsBox.getChildren().add(methodBox);
    }

    @FXML
    public void addRelationship() {
        HBox relationshipBox = new HBox(5);

        ChoiceBox<String> relationshipChoice = new ChoiceBox<>();
        relationshipChoice.getItems().addAll(relationshipTypes);
        relationshipChoice.setValue(relationshipTypes.get(0)); // Set default value

        Button addButton = new Button("+");
        addButton.setOnAction(e -> addRelationship());  // Allows adding more relationships

        Button removeButton = new Button("-");
        removeButton.setOnAction(e -> relationshipsBox.getChildren().remove(relationshipBox));

        relationshipBox.getChildren().addAll(relationshipChoice, addButton, removeButton);
        relationshipsBox.getChildren().add(relationshipBox);
    }

    public void exitProgram(ActionEvent actionEvent) {
        System.exit(0);
    }


    /**
     * This method saves the progress in a file name provided by user
     * Pre-condition, it checks for the file name, if not provided shows a message on the screen
     * asking user to provide a file name.
     * Once file name is provide, it saves the file under that name and displays a message to the user
     * with the file location.
     * @param actionEvent, click on the save button
     */
    public void saveNode(ActionEvent actionEvent) {

        if(fileName.getText().isEmpty()) {
            showWarning("Please enter a file name");
            fileName.requestFocus();
            return;
        }

        Functions.saveProgress(fileName.getText());
        infoBox("Saving file to \\cscd350-f24-TeamNull\\src\\main\\resources\\sprint1\\hdd " + fileName.getText() + ".txt");

        //textArea.setVisible(true);
        //textArea.setStyle("-fx-text-fill: black;"); // Reset to normal color

        //textArea.setText(straightLine + "\nSave:\n  feature is in development mode." + straightLine);
    }


    public void loadNode(ActionEvent actionEvent) {
        textArea.setVisible(true);
        textArea.setStyle("-fx-text-fill: black;"); // Reset to normal color
        textArea.setText(straightLine + "\nLoad:\n feature is in development mode." + straightLine);
    }

    public void createMockNode(ActionEvent actionEvent) {
        UMLNode node = new UMLNode("");
        node.setPositionAutomatically();
        viewAnchorPane.getChildren().add(node);
    }


    @FXML
    public void hideFieldArea(){
        fieldArea.setVisible(false);
        fieldsLabel.setVisible(false);
        //methodArea.setVisible(false);
        //classNameLable.setVisible(false);
        //classNameField.setVisible(false);


    }
    @FXML
    public void hideMethodArea(){
        methodArea.setVisible(false);
        methodLabel.setVisible(false);
    }


    @FXML
    public void hideRArea(){
        relationshipLabel.setVisible(false);
        area.setVisible(false);
    }



    @FXML
    void saveClassNameOnClick(ActionEvent event) {
        if (classNameField.getText().isEmpty()) {
            showWarning("Class name is required !");
            return;
        }



        Functions.createClass(classNameField.getText());

        infoBox("Class name  " + classNameField.getText() + "  Saved.");
        bigLabelforClass.setText(classNameField.getText());
        classNameField.setText("");
    }


    /**
     *  This method saves field in a spicific class.
     *  it requires to have a class name
     *  once class name, field name and field data type is provided
     *  it saves them and confirm with message on the screen
     * @param event, on the click of the save button
     */

    @FXML
    void saveFieldsOnClick(ActionEvent event) {

        if(classNameToSaveField.getText().isEmpty()){
            showWarning("Class name is required !");
            classNameToSaveField.requestFocus();
            return;
        }
        Functions.addAttribute(classNameToSaveField.getText(),fieldTypeChoice.getValue(),fieldName.getText());
        infoBox("Field name < " + fieldName.getText() + " > saved\n to < " + classNameToSaveField.getText() + " > class.");

    }



















    @FXML
    public void createClass(ActionEvent actionEvent) {
        if (classNameField.getText().isEmpty()) {
            showWarning("Class name is required.");
            return;
        }


        Functions.createClass(classNameField.getText());
        hideFieldArea();
        hideMethodArea();
        hideRArea();

        System.out.println("Save class button clicked  ");
/**
 // Collect data from the first available dynamic field, method, and relationship
 String fieldType = fieldsBox.getChildren().isEmpty() ? "" :
 ((TextField)((HBox) fieldsBox.getChildren().get(0)).getChildren().get(0)).getText();
 String fieldName = fieldsBox.getChildren().isEmpty() ? "" :
 ((TextField)((HBox) fieldsBox.getChildren().get(0)).getChildren().get(1)).getText();
 String methodType = methodsBox.getChildren().isEmpty() ? "" :
 ((TextField)((HBox) methodsBox.getChildren().get(0)).getChildren().get(0)).getText();
 String methodName = methodsBox.getChildren().isEmpty() ? "" :
 ((TextField)((HBox) methodsBox.getChildren().get(0)).getChildren().get(1)).getText();
 String parameterType = methodsBox.getChildren().isEmpty() ? "" :
 ((TextField)((HBox) methodsBox.getChildren().get(0)).getChildren().get(2)).getText();
 String parameterName = methodsBox.getChildren().isEmpty() ? "" :
 ((TextField)((HBox) methodsBox.getChildren().get(0)).getChildren().get(3)).getText();
 String relationship = relationshipsBox.getChildren().isEmpty() ? "None" :
 ((ChoiceBox<String>)((HBox) relationshipsBox.getChildren().get(0)).getChildren().get(0)).getValue();

 /**
 //***************************************************************************************My Work Area
 // take the text from class name field and set it as class name.
 Functions.createClass(classNameField.getText());
 Functions.addAttribute(classNameField.getText(),"String",fieldName);
 //Functions.addRelationship(classNameField.getText(), relationshipChoiceBox.getItems().get(1));
 Functions.addMethod(classNameField.getText(),fieldTypeChoice.getValue(),methodName);
 Functions.saveProgress(classNameField.getText());
 */
        //********************************************************************* end of work area
/*
    // Create the UML node with the collected data
    // This is the green class box that appears on the screen
    UMLNode node = new UMLNode(classNameField.getText());
    node.setFieldName(fieldName);
    node.setFieldType(fieldTypeChoice.getValue() ); //
    // node.setFieldType(fieldType);
    node.setMethodName(methodName);
    node.setMethodType(methodType);
    node.setParameterName(parameterName);
    node.setParameterType(parameterType);
    node.setRelationship(relationship);

    node.setPositionAutomatically();
    node.setOnMouseClicked(e -> populateFieldsFromNode(node)); // Add click listener for field population
    viewAnchorPane.getChildren().add(node);

   // updateTextArea(node);
    resetFields(); // Clears only the necessary fields, preserving dynamic elements
    */

    }

    /**
     private void updateTextArea(UMLNode node) {
     textArea.setVisible(true);
     textArea.setStyle("-fx-text-fill: black;"); // Reset to normal color for details
     textArea.setText(
     "Class Name:\n" + node.getClassName() +
     straightLine + "\nField Name:\n" + node.getFieldName() +
     straightLine + "\nMethod Name:\n" + node.getMethodName() +
     "\nParameters: (" + node.getParameterName() + ")" +
     straightLine + "\nRelationship:\n" + node.getRelationship()
     );
     }*/

    private void populateFieldsFromNode(UMLNode node) {
        classNameField.setText(node.getClassName());

        fieldsBox.getChildren().clear();
        methodsBox.getChildren().clear();
        relationshipsBox.getChildren().clear();

        addField(); // Add a new field box to populate
        ((TextField)((HBox) fieldsBox.getChildren().get(0)).getChildren().get(0)).setText(node.getFieldType());
        ((TextField)((HBox) fieldsBox.getChildren().get(0)).getChildren().get(1)).setText(node.getFieldName());

        addMethod(); // Add a new method box to populate
        ((TextField)((HBox) methodsBox.getChildren().get(0)).getChildren().get(0)).setText(node.getMethodType());
        ((TextField)((HBox) methodsBox.getChildren().get(0)).getChildren().get(1)).setText(node.getMethodName());
        ((TextField)((HBox) methodsBox.getChildren().get(0)).getChildren().get(2)).setText(node.getParameterType());
        ((TextField)((HBox) methodsBox.getChildren().get(0)).getChildren().get(3)).setText(node.getParameterName());

        addRelationship(); // Add a new relationship box to populate
        ((ChoiceBox<String>)((HBox) relationshipsBox.getChildren().get(0)).getChildren().get(0)).setValue(node.getRelationship());
    }


    // Getters and setters for classCounter
    public int getClassCounter() {
        return classCounter;
    }

    public void setClassCounter(int classCounter) {
        this.classCounter = classCounter;
    }
}