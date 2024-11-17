package umleditor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.LinearGradient;
import umleditor.controller.utilities.Functions;
import umleditor.view.gui.UMLNode;

import javax.sound.sampled.Line;
import java.util.List;

public class UMLBuilderController {
   // Relationship arrow
    @FXML
    private Line relArrow ;
    @FXML
    private Line lineArrow ;
    @FXML
    private Line relLine2;

    @FXML
    private Button goButton;
    @FXML
    private Button  fieldSaveButton;
    @FXML
    private Button loadButton ;
    @FXML
    private Button delete;
    @FXML
    private Button addRelationshipBTN;
    @FXML
    private Button crateMNod;
    @FXML
    private Button saveClassBNT;
    @FXML
    private Button methodSaveButton;
    @FXML
    private Button saveClassName;
    @FXML
    public Button saveClass;

    @FXML
    private Label fieldsLabel;
    @FXML
    private Label relationshipLabel;

    @FXML
    private Label classNameLable; // Label on top of the field that shows class name
    @FXML
    private Label methodLabel; // label for method area

    @FXML
    private TextField classNameToSaveField;
    @FXML
    private TextField fieldName;
    @FXML
    private TextField fileName;
    @FXML
    private TextField classNameToSaveMethod;
    @FXML
    private TextField methodName;
    @FXML
    private TextField parameterName;

    @FXML
    private TextField lowerMsgBox;
    @FXML
    private TextField classNameToAddRelationship; // source class
    @FXML
    private TextField classNameToAddRelationshipdst; // destination class
    @FXML
    private TextField classNameField;
    @FXML
    private TextArea textArea;

    @FXML
    private HBox fldArea;
    @FXML
    private HBox pramArea;

    @FXML
    private VBox fieldsBox, methodsBox, relationshipsBox;

    // Dropdown menu on home page for user to select an action
    @FXML
    private ChoiceBox<String> userSelectionDropdown;

    @FXML
    private ChoiceBox<String> methodDataTypeChoice;

    @FXML
    private ChoiceBox<String> pramRetunDataTypeChoice;


    public ChoiceBox<String> relationshipChoiceBox;
    @FXML
    private ChoiceBox<String> fieldTypeChoice;


    @FXML
    private AnchorPane viewAnchorPane;


    //@FXML
  //  private ScrollPane fieldArea; // field area is the whole area with field box, drop down menu, plus and minus buttons

    @FXML
    private ScrollPane area;
    @FXML
    private ScrollPane methodArea; // method area is the whole area with field box, drop down menu, plus and minus buttons

    // List of option for user to chose on the home page
    // This needs to be of an enum class, for now just listing them here.
    private final List<String> userSelectionList = List.of(
            "Create a Class","Rename a Class", "Delete a Class",
            "Add Field (S)","Rename Field", "Delete Field",
            "Add Method (S)","Rename Method", "Delete Method",
            "Add Parameter","Rename Parameter", "Delete Parameter",
            "Add Relationship","Save File","Help");


    private final String filePath = " \\cscd350-f24-TeamNull\\src\\main\\resources\\sprint1\\hdd\\";


    private final List<String> dropDownChoices = List.of("Select data type","void","String","int","double","float","char", "boolean","byte", "short", "long","Arrays","Integer", "Object");

    private final List<String> relationshipTypes = List.of("Select Type", "ASSOCIATION", "AGGREGATION",
            "COMPOSITION", "INHERITANCE", "GENERALIZATION", "REALIZATION" ,"DEPENDENCY");

    private final String straightLine = "\n__________________________________";

    private int classCounter = 0;

    /**
     * This method initializes all the components when the program runs
     * At first it hides all the components, it will show the related components, like TextField, TextArea, Buttons... etc
     * When you user selects the related option from the dropdown menu on the main page and clicks on the "Go" button.
     */
    @FXML
    public void initialize() {

        hideClassArea();// to hide the class label, class field and button to save class
        hideFieldArea(); // to hide the field label, field name, drop down menu, and save button
        hideMethodArea(); // to hide method area
        hideRArea(); // to hide the relationship area
        hideFileArea();
        saveClass.setVisible(false);
        //delete.setVisible(false);
         loadButton.setVisible(false);
        // Add list of options to the dropdown menu on the home page.
        userSelectionDropdown.getItems().addAll(userSelectionList);

        // methodDataTypeChoice.getItems().addAll(methodDataTypeChoiceList); // drop down menu for user to select method data type
        methodDataTypeChoice.getItems().addAll(dropDownChoices);
        // pramRetunDataTypeChoice.getItems().addAll(pramRetunDataTypeChoiceList); // drop down menu for user to select para meter data type
        pramRetunDataTypeChoice.getItems().addAll(dropDownChoices); // drop down menu for user to select para meter data type

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
                hideFieldArea();
                hideRArea();
                hideMethodArea();
                hideFieldArea();

                showClassArea();

                classNameField.requestFocus();
                lowerMsgBox.setText("Option " + userSelectionDropdown.getValue() +  " selected.");
                break;

            case "Rename a Class":
                hideFieldArea();
                hideRArea();
                hideMethodArea();
                hideFieldArea();

                showClassArea();

                break;
            case "Add Field (S)":
                hideFieldArea();
                hideClassArea();
                hideRArea();
                hideMethodArea();

                showFieldArea();

                classNameToSaveField.requestFocus();
                break;

            case "Add Method (S)":
                hideFieldArea();
                hideClassArea();
                hideRArea();
                hideFileArea();

                showMethodArea();

                classNameToSaveMethod.requestFocus();
                break;

            case "Add Relationship":
                hideFieldArea();
                hideMethodArea();
                hideFieldArea();
                hideClassArea();

                showRArea();
                relationshipChoiceBox.requestFocus();
                break;
            case "Save File":

                hideRArea();
                hideMethodArea();
                hideFieldArea();
                hideClassArea();

                showFileArea();

                fileName.requestFocus();
                Functions.loadProgress(fieldName.getText());

            default:
                infoBox(relationshipChoiceBox.getValue() + " is in development");
        }
    }

    /**
     * This method shows "Warning" message. Text in red color when precondition of a method does not meet.
     * @param message, message is based on each method pre- or post-condition.
     */
    private void showWarning(String message) {

        lowerMsgBox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        lowerMsgBox.setText(message);
        lowerMsgBox.setEditable(false);
        lowerMsgBox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");

    }

    /**
     * This method displays a message based on user selection to either confirm or
     * inform the user action.
     * @param message, it is based on each method post condition.
     */
    private void infoBox(String message) {

        lowerMsgBox.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
        lowerMsgBox.setText(message);

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
        classNameLable.setText("");

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

        TextField fieldName = new TextField();
        fieldName.setPromptText("Enter field name");

        //drop down for method data type
        ChoiceBox<String> fieldTypeChoice = new ChoiceBox<>();
        // fieldTypeChoice.getItems().addAll(fieldDataTypeList);
        fieldTypeChoice.getItems().addAll(dropDownChoices);

        Button fieldSaveButton = new Button("Save");
        Button removeButton = new Button("-");
        removeButton.setOnAction(e -> fieldsBox.getChildren().remove(fieldBox));

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

        // drop down menu for user to select parameter data type
        ChoiceBox<String> pramReturnDataTypeChoice = new ChoiceBox<>();

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

        node = new UMLNode(node.getClassName());

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
       fieldSaveButton.setVisible(false);
      // fieldArea.setVisible(false);

    }

    @FXML
    public void showFieldArea(){
        fieldsLabel.setVisible(true);
        classNameToSaveField.setVisible(true);
        fieldName.setVisible(true);
        fieldTypeChoice.setVisible(true);
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
            showWarning("Class name empty or duplicate !");
            return;
        }

            Functions.createClass(classNameField.getText());

            node = new UMLNode(classNameField.getText());
            classNameField.setText("");

            viewAnchorPane.getChildren().add(node);


            infoBox("Class name  " + classNameField.getText() + "  Saved. \n File path is: " + filePath);


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
    // Validate class name input
    if (classNameToSaveField.getText().isEmpty()) {
        showWarning("Class name is required!");
        classNameToSaveField.requestFocus();
        return;
    }
    // Check if the class exists
    String className = classNameToSaveField.getText();
    if (node.getClassName() == null || !node.getClassName().equals(className)) {
        showWarning("Class < " + className + " > does not exist!");
        classNameToSaveField.requestFocus();
        return;
    }
    // Validate field name input
    if (fieldName.getText().isEmpty()) {
        showWarning("Field name is required!");
        fieldName.requestFocus();
        return;
    }
    // Validate field type input
    if (fieldTypeChoice.getValue() == null) {
        showWarning("Field type is required!");
        fieldTypeChoice.requestFocus();
        return;
    }
    // Add field to the class
    String fieldType = fieldTypeChoice.getValue();
    String field = fieldName.getText();
    Functions.addAttribute(className, fieldType, field);
    // Append the new field to the node's existing fields
    String existingFields = node.getFieldName();
    if (!existingFields.isEmpty()) {
        node.setFieldName(existingFields + "\n" + field + " : " + fieldType);
    } else {
        node.setFieldName(field + " : " + fieldType);
    }

    // Show confirmation message
    infoBox("Field name < " + field + " > saved\n to < " + className + " > class.\nFile path is: " + filePath);
}

    @FXML
    void saveMethodANDPram(ActionEvent event) {
        // Validate class name input
        if (classNameToSaveMethod.getText().isEmpty()) {
            showWarning("Class name is required!");
            classNameToSaveMethod.requestFocus();
            return;
        }
        String className = classNameToSaveMethod.getText();
        if (Functions.getClassIfExists(className) == null) {
            showWarning("Class < " + className + " > does not exist!");
            classNameToSaveMethod.requestFocus();
            return;
        }
        // Validate method name input
        if (methodName.getText().isEmpty()) {
            showWarning("Method name is required!");
            methodName.requestFocus();
            return;
        }
        // Validate return type input
        if (methodDataTypeChoice.getValue() == null) {
            showWarning("Method return type is required!");
            methodDataTypeChoice.requestFocus();
            return;
        }
        // Validate parameter name input
        if (parameterName.getText().isEmpty()) {
            showWarning("Parameter name is required!");
            parameterName.requestFocus();
            return;
        }
        // Validate parameter type input
        if (pramRetunDataTypeChoice.getValue() == null) {
            showWarning("Parameter type is required!");
            pramRetunDataTypeChoice.requestFocus();
            return;
        }
        // Add method and parameter to the class
        String method = methodName.getText() + " : " + methodDataTypeChoice.getValue();
        String parameter = parameterName.getText() + " : " + pramRetunDataTypeChoice.getValue();
        // Update the underlying class data
        Functions.addAttribute(className, methodDataTypeChoice.getValue(), methodName.getText());
        Functions.addParam(className, methodName.getText(), parameterName.getText(), pramRetunDataTypeChoice.getValue());
        // Append the method and parameter to the node's display
        String existingMethods = node.getMethodName();
        String existingParameters = node.getParameterName();
        if (!existingMethods.isEmpty()) {
            node.setMethodName(existingMethods + "\n" + method);
        } else {
            node.setMethodName(method);
        }
        if (!existingParameters.isEmpty()) {
            node.setParameterName(existingParameters + "\n" + parameter);
        } else {
            node.setParameterName(parameter);
        }
        // Refresh the node's display
         //node.updateLabel();
        // Show confirmation message
        infoBox("Method < " + methodName.getText() + " > and parameter < " + parameterName.getText() +
                " > saved to class < " + className + " >.");
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


      // relLine2.equals(node.getLayoutX());
       // relLine2.equals(node.getLayoutY());
        //relLine2.getControls();
/**
// Set the start and end points based on the nodes' positions
 relLine2.setStartX(startNode.getLayoutX() + startNode.getWidth() / 2); // Center of the start node
 relLine2.setStartY(startNode.getLayoutY() + startNode.getHeight() / 2); // Center of the start node
 relLine2.setEndX(endNode.getLayoutX() + endNode.getWidth() / 2); // Center of the end node
 relLine2.setEndY(endNode.getLayoutY() + endNode.getHeight() / 2); // Center of the end node
// Optionally, add the line to a parent container (e.g., Pane)

        viewAnchorPane.getChildren().add(lineArrow);
*/
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
   }

    // Getters and setters for classCounter
    public int getClassCounter() {
        return classCounter;
    }

    public void setClassCounter(int classCounter) {
        this.classCounter = classCounter;
    }
}