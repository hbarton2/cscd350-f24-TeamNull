package umleditor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import umleditor.controller.utilities.Functions;
import umleditor.view.gui.UMLNode;

import java.util.List;

public class UMLBuilderController {

    @FXML
    private Button addRelationshipBTN;

    @FXML
    private TextField classNameToAddRelationship; // source class
    @FXML
    private TextField classNameToAddRelationshipdst; // destination class

    @FXML
    private HBox fldArea;
    @FXML
    private HBox pramArea;

    @FXML
    private Button field_Save_Button;

    @FXML
    private Button saveClassBNT;

    @FXML
    private ScrollPane fieldArea; // field area is the whole area with field box, drop down menu, plus and minus buttons

    @FXML
    private Label relationshipLabel;


    @FXML
    private TextField sysMessage;

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

    // Dropdown menu on home page for user to select an action
    @FXML
    private ChoiceBox<String> userSelectionDropdown;

    // List of option for user to chose on the home page
    // This needs to be of an enum class, for now just listing them here.
    private final List<String> userSelectionList = List.of(
            "Create a Class","Rename a Class", "Delete a Class",
            "Add Field (S)","Rename Field", "Delete Field",
            "Add Method (S)","Rename Method", "Delete Method",
            "Add Parameter","Rename Parameter", "Delete Parameter",
            "Add Relationship","Save File","Help");

    Node currentNode = new UMLNode("");

    @FXML
    private Button goButton;


    @FXML
    private TextField classNameToSaveField;

    @FXML
    private TextField fieldName;


    @FXML
    private TextField fileName;

    @FXML
    private Button loadButton ;



    @FXML
    private TextField classNameToSaveMethod;
    @FXML
    private TextField methodName;
    @FXML
    private TextField parameterName;

    private final String filePath = " \\cscd350-f24-TeamNull\\src\\main\\resources\\sprint1\\hdd\\";

    @FXML
    private Label fieldsLabel;
    private final List<String> dropDownChoices = List.of("Select data type","void","String","int","double","float","char", "boolean","byte", "short", "long","Arrays","Integer", "Object");

    @FXML
    private ChoiceBox<String> methodDataTypeChoice;

    @FXML
    private ChoiceBox<String> pramRetunDataTypeChoice;

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


    private final List<String> relationshipTypes = List.of("Select Type", "ASSOCIATION", "AGGREGATION",
            "COMPOSITION", "INHERITANCE", "GENERALIZATION", "REALIZATION" ,"DEPENDENCY");
    private final String straightLine = "\n__________________________________";
    private int classCounter = 0;




    @FXML
    public void initialize() {

        hideClassArea();// to hide the class label, class field and button to save class
        hideFieldArea(); // to hide the field label, field name, drop down menu, and save button
        hideRArea(); // to hide the relationship area
        hideMethodArea(); // to hide method area
        //hideFileArea();//


        // Add list of options to the dropdown menu on the home page.
        userSelectionDropdown.getItems().addAll(userSelectionList);

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


    /**
     * This method activates the functions on the home page based on user selection from the dropdown menu
     * @param event, action listener.
     * once user clicks the "Go" button after making selection, this method will execute.
     */
    @FXML
    void executeUserSelection(ActionEvent event) {

        infoBox("Option: " + userSelectionDropdown.getValue() +  ", selected.");

        switch (userSelectionDropdown.getValue()){

            case "Create a Class":
                showClassArea();
                classNameField.requestFocus();
                sysMessage.setText("Option " + userSelectionDropdown.getValue() +  " selected.");
                break;

            case "Add Field (S)":
                showFieldArea();
                classNameToSaveField.requestFocus();
                break;

            case "Add Method (S)":
                showMethodArea();
                classNameToSaveMethod.requestFocus();
                break;
            case "Add Relationship":
                showRArea();
                relationshipChoiceBox.requestFocus();
                break;
            case "Save File":
                showFileArea();
                fileName.requestFocus();
                Functions.loadProgress(fieldName.getText());

            default:
                infoBox(relationshipChoiceBox.getValue() + " is in development");


        }
        /**
        if (userSelectionDropdown.getValue().equalsIgnoreCase("Create a Class")){

            showClassArea();
            classNameField.requestFocus();
            sysMessage.setText("Option " + userSelectionDropdown.getValue() +  " selected.");

        }


        if(userSelectionDropdown.getValue().equalsIgnoreCase("Save File")){
            showFileArea();
            fileName.requestFocus();
            Functions.loadProgress(fieldName.getText());
        }

        if (userSelectionDropdown.getValue().equalsIgnoreCase("Add Field (S)")){

            showFieldArea();
            classNameToSaveField.requestFocus();
        }
        if (userSelectionDropdown.getValue().equalsIgnoreCase("Add Method (S)")){

            showMethodArea();
            classNameToSaveMethod.requestFocus();

        }
        if (userSelectionDropdown.getValue().equalsIgnoreCase("Add Relationship")){

            showRArea();
            relationshipChoiceBox.requestFocus();
        }
            */
    }



    // Warning Box
    private void showWarning(String message) {

        sysMessage.setText(message);
        sysMessage.setEditable(false);
        sysMessage.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");

    }

    // Information box
    private void infoBox(String message) {


        sysMessage.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
        sysMessage.setText(message);

       //textArea.setVisible(true);
        //textArea.setStyle("-fx-text-fill: green; -fx-font-weight: bold;"); // Red font for error box
        //textArea.setText(straightLine + "\n" + message + straightLine);
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
        Functions.clearProgress();
        node.setVisible(false);
        infoBox("All progress has been cleared.");

    }

    @FXML
    public void saveClassAction(MouseEvent event) {
        // Placeholder for save functionality
    }

    /**
     * Add or remove more Fields for user to add
     * depending on the user selection of plus or minus button, this method or removes field
     */
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
        infoBox("Saving file to " + filePath + fileName.getText() + ".json");


    }


    public void loadNode(ActionEvent actionEvent) {

       textArea.setVisible(true);
        textArea.setStyle("-fx-text-fill: black;"); // Reset to normal color
        textArea.setText(straightLine + "\nLoad:\n feature is in development mode." + straightLine);
    }


    public void createMockNode(ActionEvent actionEvent) {

        infoBox("Creating a new mock node");


        UMLNode node = new UMLNode("Sweet Class");
        node.setPositionAutomatically();

        viewAnchorPane.getChildren().add(node);
    }



    @FXML
    public void hideClassArea(){
        classNameLable.setVisible(false);
        classNameField.setVisible(false);
        saveClassName.setVisible(false);

    }

    @FXML
    public void  showClassArea(){
        classNameLable.setVisible(true);
        classNameField.setVisible(true);
        saveClassName.setVisible(true);


    }
    @FXML
    public void hideFieldArea(){
        fieldsLabel.setVisible(false);
        classNameToSaveField.setVisible(false);
       fieldName.setVisible(false);
       fieldTypeChoice.setVisible(false);
       field_Save_Button.setVisible(false);
       fieldSaveButton.setVisible(false);
       fieldArea.setVisible(false);

    }

    @FXML
    public void showFieldArea(){
        fieldsLabel.setVisible(true);
        classNameToSaveField.setVisible(true);
        fieldName.setVisible(true);
        fieldTypeChoice.setVisible(true);
        field_Save_Button.setVisible(true);
        fieldSaveButton.setVisible(true);

    }
    @FXML
    public void hideMethodArea(){

        methodLabel.setVisible(false);
        methodArea.setVisible(false);
        pramArea.setVisible(false);

    }

    @FXML
    public void showMethodArea(){
        methodLabel.setVisible(true);
        methodArea.setVisible(true);
        pramArea.setVisible(true);

    }

    @FXML
    public void hideRArea(){
        relationshipLabel.setVisible(false);
        area.setVisible(false);
    }

    @FXML
    public void showRArea(){
        relationshipLabel.setVisible(true);
        area.setVisible(true);
    }


    @FXML
    public void hideFileArea(){
        fileName.setVisible(false);
        saveClassBNT.setVisible(false);

    }

    @FXML
    public void showFileArea(){
        fileName.setVisible(true);
        saveClassBNT.setVisible(true);
    }


    UMLNode node ;

    @FXML
    void saveClassNameOnClick(ActionEvent event) {

        if (classNameField.getText().isEmpty()){
            showWarning("Class empty or duplicate !");
            return;
        }
          //  classCounter ++;
            Functions.createClass(classNameField.getText());

            node = new UMLNode(classNameField.getText());
            classNameField.setText("");

            //node.setPositionAutomatically();
            node.setPrefHeight(50);

            viewAnchorPane.getChildren().add(node);
           // node.setClassName(classNameField.getText());

            infoBox("Class name  " + classNameField.getText() + "  Saved. \n File path is: " + filePath);
            classNameField.clear();

        }



    /**
     *  This method saves field in a specific class.
     *  it requires to have a class name
     *  once class name, field name and field data type is provided
     *  it saves them and confirm with message on the screen
     * @param event, on the click of the save button
     */

    @FXML
    void saveFieldsOnClick(ActionEvent event) {

        if( classNameToSaveField.getText().isEmpty() || Functions.getClassIfExists(classNameToSaveField.getText()) == null) {
            showWarning("Class name is required !");
            classNameToSaveField.requestFocus();
            return;
        }

        node.setClassName(classNameToSaveField.getText());
        node.setFieldName(fieldName.getText());
        node.setFieldType(fieldTypeChoice.getValue());

        Functions.addAttribute(classNameToSaveField.getText(),fieldTypeChoice.getValue(),fieldName.getText());


        node.setPositionAutomatically();
        viewAnchorPane.getChildren().add(node);

        infoBox("Field name < " + fieldName.getText() + " > saved\n to < " + classNameToSaveField.getText() + " > class.\n file path is: " + filePath);

    }


    @FXML
    void saveMethodANDPram(ActionEvent event) {
        if(classNameToSaveMethod.getText().isEmpty() || Functions.getClassIfExists(classNameToSaveField.getText()) == null) {
            showWarning("Class name is required !");
            classNameToSaveMethod.requestFocus();
            return;
        }

      //  viewAnchorPane.getChildren().add(node);
        node.setClassName(classNameToSaveMethod.getText());
        node.setMethodName(methodName.getText());
        node.setMethodType(methodDataTypeChoice.getValue());

        node.setParameterName(parameterName.getText());
        node.setParameterType(pramRetunDataTypeChoice.getValue());

        //Functions.addAttribute(classNameToSaveMethod.getText(), methodDataTypeChoice.getValue(),methodName.getText());
        Functions.addAttribute(classNameToSaveMethod.getText(), "methodDataTypeChoice.getValue()",methodName.getText());
        Functions.addParam(classNameToSaveMethod.getText(), methodName.getText(),parameterName.getText(),pramRetunDataTypeChoice.getValue());

        node.setPositionAutomatically();
        viewAnchorPane.getChildren().add(node);
        // here is the section for adding node and setting it on the screen

        infoBox("Method name and return type saved.");

    }

    /**
     * This methods adds selected relationship type
     * It requires source class, destination class and relationship type
     * Once user select the type of relationship, both classes
     * it converts the selection to a numerical representation of the type
     * and saves it.
     * @param event, click of save button on the GUI
     */

    @FXML
    void addRelationshipOnClick(ActionEvent event) {
        if(relationshipChoiceBox.getValue().isEmpty()){
            showWarning("Relationship empty !");
            relationshipChoiceBox.requestFocus();
            return;
        }

        relationshipChoiceBox.requestFocus();

        int relationshipType ;
        switch (relationshipChoiceBox.getValue()){
            case "ASSOCIATION":
                relationshipType = 1;
                break;
            case "AGGREGATION":
                relationshipType = 2;
                break;
            case "COMPOSITION":
                relationshipType = 3;
                break;
            case "INHERITANCE":
                relationshipType = 4;
                break;
            case "GENERALIZATION":
                relationshipType = 5;
                break;
            case "REALIZATION":
                relationshipType = 6;
                break;
            case "DEPENDENCY":
                relationshipType = 7;
                break;
            default:
                relationshipType = 0;
                break;
        }

        Functions.addRelationship(classNameToAddRelationship.getText(), relationshipType,classNameToAddRelationshipdst.getText());
        node.setClassName(classNameToAddRelationship.getText());
        node.setRelationship(relationshipChoiceBox.getValue());

        infoBox(relationshipChoiceBox.getValue() + " added.");
    }// end of method


    /**
     * This method creates a class
     * once user types class name in the class name field box
     * and press save button, this method will save that name in Storage
     * class via Functions
     * Pre-condition. It checks the name field box first
     * if it is empty it displays a warning message
     * @param actionEvent, press of save button
     */
    @FXML
    public void createClass(ActionEvent actionEvent) {
        if (classNameField.getText().isEmpty()) {
            showWarning("Class name is required.");
            return;
        }

        Functions.createClass(classNameField.getText());

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