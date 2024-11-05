# Technical Documentation
---

## Table of Contents

# Sprint 2
1. [Entry Point](#Entry Point)
2. [Controller](#Controller)
   1. [UMLBuilderController](#UMLBuilderController)
3. [Model](#Model)
4. [View](#View)
   1. [AppStart](#AppStart)
   2. [UMLNode](#UMLNode)

# Sprint 1
1. [Entry Point](#Entry Point)
2. [UML](#UML)
   1. [UMLClass](#UMLClass)
   2. [UMLClassRelationshipType](#UMLRelationshipType)
   3. [MethodSignature](#MethodSignature)
   4. [UMLRelationship](#UMLRelationship)
   5. [UMLAttribute](#UMlAttribute)
3. [utilities](#utilities)
   1. [CommandAction](#CommandAction)
   2. [CommandFactory](#CommandFactory)
   3. [Commands](#Commands)
   4. [Display](#Display)
   5. [Functions](#Functions)
   6. [ParsingInputs](#ParsingInputs)
   7. [SimpleAutoComplete](#SimpleAutoComplete)
   8. [Storage](#Storage)
4. [KnownBugs](#KnownBugs)
5. [Broken Features](#Broken Features)

---
# Controller

Directory for event handling. Listens for user to change state in the GUI, 
and informs the model and view accordingly.


## UMLBuilderController


### Overview: 
BuildController handles Node class creation for GUI

### Features: 

* **Create Class:** 
    Creates a class for user. Sets the name, field name, method name, parameters, and relationships
<p> 

* **Delete Node:** 
    Deletes a node class instance
<p> 

* **Save Class:**
    Saves a class for user
<p> 

* **Add Field:**
    Adds a field to an existent class node
<p> 

* **Add Method:** 
    Add a method to an existent class node
<p> 

* **Add Relationship:** 
    Add a relationship to classes
<p> 

* **Get Relationship:** 
    Returns the relationship
<p> 

* **Create Node:** 
    Creates a node
<p> 

* **Exit Program:** 
Exits the program for user 
<p> 

* **Create Mock Node:** 
    Creates a mock node for demonstration purposes
<p> 

* **Save Node:** 
    Saves a node state 
<p> 

* **Load Node:** 
    Loads a node state 
<p>

* **Get Class Counter:** 
    Gets counters for class
<p> 

* **Set Class Counter:** 
    Sets counters for class 
<p>

* **Populate Fields From Node:**
    Populates fields for the Node 
<p> 

* **Update Text Area:**
    Updates text in node 
<p>

---

## Model

<h3> Overview: </h3>
An adapter class. Talks to storage to retrieve and store data.

<h3> Features: </h3>
<p> Create Class Node: <br>
    Adds new node class to storage.</p>



---


## View

Directory for visualization. Requests data from Model and displays in user-friendly way for GUI.


### AppStart

<h3> Overview: </h3>
Handles launch for GUI.

<h3> Features: </h3>
<p> Start: <br>
    Creates GUI state for user. Loads and sets scene.</p>

### UMLNode

<h3> Overview: </h3>
Handles display of class creation and manipulation for user.

<h3> Features: </h3>

* **UML Node:**
    Constructs a node. Sets size, style, and defaults names for class, field, method, parameter, relationship.
<p>

* **Set/Get Class Name:** 
    Getter and setter for the class name.
<p> 

* **Set/Get Field Name:** 
    Getter and setter for field name.
<p>

* **Set/Get Method Name:** 
    Getter and setter for method name.
<p> 

* **Get Relationship:** 
    Getter for relationship.
<p>

* **Update Label:** 
    Updates label text with the latest output.
<p>

* **Set Position Automatically:**
    Positions nodes in a clockwise pattern around the starting position.
<p>

* **Format Node Content:**
  Formats the content to be displayed in the node
<p>

* **Adjust Node Size:**
  Adjust node size based on content, ensuring it fits the text neatly
<p>

* **Show Error:**
    Displays an error message in red
<p>


----
## Entry Point: 

### Overview:

Point of entry for user into UML Editor application. 

### Features:

* Displays starting application
* Runs application
  
### umleditor.EntryPoint procedure:

When running entrypoint, user will be greeted, and receive list of common commands and their usage.
Will prompt user to type command to command line, and begin editing UML Diagram.

----
# UML:

## UMLClass: 
<h3> Overview: </h3>
Handles all class objects created by the user
Name, Attributes (Fields), List of Methods, Fields, Relationships

<h3> Features: </h3>

* **Add Attributes:**
    Adds an attribute to a class
<p>

* **Create Methods:** 
    creates a new method object and adds to list of methods in this class
<p>

* **Remove Method:**
    finds method in class list and removes it by name
<p>

* **Create Fields:**
    uses name and type, to create a new UMLField object and add it to the list of fields
<p>

* **Remove Fields:**
    finds field by name and if it exists, removes from list of fields
<p>

* **Rename Method:** 
    finds method in class method list, if it exists then asks user to enter new name. Renames method if name is not already taken
<p>

* **isMethodExists:** 
    returns boolean if method name is found in method list
<p>

* **Find (Object):** 
    Methods that search the relevant list using the given name and returns the object if it exists
<p>

* **Display (Object):** 
    Display Methods, cycle through the relevant list and print to screen the information

----

## UMLRelationshipType:

### Overview: 

Enum class that contains available relationship types:

* ASSOCIATION
* AGGREGATION
* COMPOSITION
* INHERITANCE

----
## MethodSignature:
### Overview:
class holds all parameter specific methods, represents
a method object. contains:
Strings methodname and methodType
ArrayList of parameters

### Features:

* **MethodSignature Constructor:**
takes method name and method type, creates new method with
no parameters
<p>

* **addParam:**
takes in parameter name and type, creates new UMLParameter object
and adds to local parameter list
<p>

* **removeParam:**
takes in parameter name, searches through local parameter list,
if parameter with same name exists then, removes from list
<p>

* **paramExists:**
Helper method, takes in parameter name and returns if that parameter
exists in local parameter list or not.
<p>

* **toString:**
returns string of method name and all parameters, if there are no
parameters then says 'no parameters'

### UMLParameter:
#### Overview:
Nested subclass of MethodSignature,
contains fields name and type.

#### Features:
* **UMLParameter Constructor:**
takes name and type, assigns new UMLParameter object
* **toString:**
returns string in format: "name (type)"
----
## UMLRelationship
### Overview: 
UMLRelationship handles relationship construction. Relationship must have a type.

### Features: 
* **UML Relationship:** 
    Constructs a relationship object. Takes in a type.
<p>

* **Get Type:**
    Gets relationship type
<p>

* **Set Type:**
    Sets relationship type
<p>

* **To String:**
    Returns name of relationship type as string


----
## UMLAttribute

### Overview:
UMLAttribute handles attribute (field) construction. Attribute must have a name and a type.

### Features: 
* **UML Attribute:**
    Constructs an attribute (field) object
<p> 

* **Get Name:**
    Gets attribute name
<p>

* **Get Type:**
    Gets attribute type
<p> 

* **Set Type:**
    Sets attribute type
<p> 

* **Set Name:**
    Set attribute name
<p> 

* **To String:**
    Returns attribute type and name as a String




----

# Utilities:

## CommandAction:

### Overview:

Helper interface that pulls phrase from parser and attributes to a command.
Helps avoid clutter in Main entry call.


---

## CommandFactory:

### Overview:

Factory class that uses a Factory method to create commands actions based on parsed phrases from Parser.

### Features:

createCommand Method: 

Runs through cases to create a command based on command type. Options: createClass, removeClass, renameClass,
addAttribute, removeAttribute, addMethod, removeMethod, addRelationship, removeRelationship, lsa, lsc, lsr,
saveProgress, loadProgress, clearProgress. Default case prints: "Error: Unknown command type: type"


---
## Commands:

### Overview:
Stores UML Editor commands as hash table.

### Features:

* loadCommand Method:
pulls command from the Json file it is stored in, and stores it in the hash map for use

* addHelpCommand
Manually adds our help command into the hashmap
* displayHelp
Cycles through list of command definitions and prints them to the screen
* getCommand
getter method to return the command via the parameter commandKey

---

## Display:

### Overview:
Handles all display functionality.

### Features:

* Display: initializes command registry from GSON and creates parser instance.
* Start: entry method to handle start of program. Displays list of available commands and their arguments. Displays help
from the start. Creates a Scanner instance for user input handling. Formats user's terminal for clean presentation.
Handles exit command for closing UML Editor application.

---

## Functions:

### Overview:
Stores method calls for use from the menu, checks input and checks if class exists before executing class specific method calls


### Features:

* **createClass:**
Method call for creating a class, checks if class already exists if not then adds to the list
<p>

* **removeClass:**
checks if class exists if it does then removes from the class list
<p>

* **renameClass:**
takes parameters oldName and newName, checks if class exists if it does then calls objects internal renameClass method
<p>

* **addAttribute (field):**
takes parameter className and attribute, checks if class exists then calls addAttribute within the class
<p>

* **removeAttribute (field):**
  takes parameter className and attribute, checks if class exists then calls removeAttribute within the class
<p>

* **addMethod:**
takes className, methodName, and parameter. if Class does not exist or method name is taken then returns, otherwise adds method and optionally the parameter
<p>

* **removeMethod:**
takes className, methodName, and parameter. if Class does not exist or method name is taken then returns, otherwise removes method
<p>

* **addRelationship:**
Adds or updates a relationship in a class.
<p>

* **removeRelationship:**
Removes a relationship from a class
<p>

* **getRelationshipType:**
Retrieves the available relationship types: ASSOCIATION, AGGREGATION, COMPOSITION, INHERITANCE
<p>

* **listClasses:**
Contains case for list class commands, including: listAllClassDetails, listClassNamesOnly, listClassesWithRelationships
<p>

* **listAllClassDetails:**
List all class details including attributes (fields) and methods. If classes are empty, will print "No classes created."
<p>

* **listClassNamesOnly:**
List classes by name only. If classes are empty will display "No classes created."
<p>

* **listClassesWithRelationships:**
List all classes that have relationships. If classes are empty, will display "No classes created."
<p>

* **saveProgress:**
Saves progress to a JSON file.
<p>

* **loadProgress:**
Loads a progress state from a JSON file.
<p>

* **clearProgress:**
Clears user terminal of progress history.
<p>

* **addParam:**
adds a parameter to an already existing method within a class
<p>

* **removeParam:**
removes a parameter from an existing method within a class

---




## ParsingInputs:

### Overview:
Parser class handles all user input then seeks command class.

### Features:

* Fields: 
  * userInput: stores raw user input
  * commandRegistry: reference to Commands class

* readInput: Sets the user input. Receives a String and assigns to class userInput field.

* parseInput: parses the input into a command and arguments. Grabs command from the command registry. If found, executes
command, else prints: "Unknown command <command>"


---



## SimpleAutoComplete
### Overview:
SimpleAutocomplete provides basic autocomplete functionality.
It matches user input against a predefined list of options.

### Features:

* **SimpleAutoComplete Constructor:**
  Takes options command list
<p>

* **AutoComplete:**
  Returns a list of suggestions that start with the given input
<p> 




---

## Storage:

### Overview:

<p> The Storage class is a utility that manages the storage of UML class objects created by the user.</p><br>
<p> It allows for adding, removing, renaming, and checking the existence of UML classes using static methods. </p>
<p> The storage mechanism is based on a HashMap where the key is the class name (a String) and the value is a UMLClass object.</p><br>

<h3> Data Structure</h3>

<p> The class uses a private static HashMap to store all UML class objects:</p>
<p> private static HashMap<String, UMLClass> umlClasses = new HashMap<p>();</p>
<p> • Key: The name of the UML class (String).</p>
<p> • Value: The corresponding UMLClass object.</p>

<h3> Key Features: </h3>

<p> 1. Store UML Class objects: Stores and retrieves UML class objects using a HashMap.</p>
<p> 2. Add and Remove Classes: Supports adding new classes and removing existing ones.</p>
<p> 3. Check Class Existence: Provides a method to verify if a class exists in the storage. </p>
<p> 4. Rename Classes: Allows renaming an existing class.</p><br>


<h3> Methods: </h3>

<p> 1. getUMLClasses </p>

<p>public static HashMap<String, UMLClass> getUMLClasses()

<p> • Description: Returns the entire umlClasses HashMap, which contains all the UML classes currently stored. </p>
<p> • Return Type: HashMap<String, UMLClass>
<p> • Usage: To access the full collection of UML classes in storage.</p> <br>

<h3> 2. addClass(String className) </h3>

<p> public static void addClass(String className)</p>

<p> • Description: Adds a new UML class to the storage if the class name doesn’t already exist.</p>
<p> • Parameters:
<p> • className (String): The name of the class to be added. </p>

<p>• Behavior:</p>
<p> • If the class name does not already exist, a new UMLClass object is created and added to the umlClasses map.</p>
<p> • If the class name already exists, an error message is printed. </p>
<p> • Usage: To create and add a new UML class. </p> <br>


<h3> 3. removeClass(String className) </h3>

<p> public static void removeClass(String className)</p>

<p> • Description: Removes a UML class from the storage by its name.</p> <br>
<p> • Parameters:
<p> • className (String): The name of the class to be removed.</p> <br>

<p> • Behavior:</p>
<p> • Removes the class from the umlClasses map if it exists. </p>
<p> • If the class does not exist, no action is taken.</p>
<p> • Usage: To remove an existing UML class by its name.</p><br>

<h3> 4. classExists(String className) </h3>

<p> public static boolean classExists(String className)</p>

<p> • Description: Checks if a UML class with the given name exists in storage. </p> <br>
<p> • Parameters: </p>
<p> • className (String): The name of the class to check. </p>
<p> • Return Type: boolean — Returns true if the class exists, otherwise false. </p>
<p> • Usage: To verify the existence of a class in storage. </p><br>


<h3> 5. renameClass(String oldName, String newName)</h3>

<p> public static void renameClass(String oldName, String newName)</p>

<p> • Description: Renames an existing UML class by replacing the old name with a new name.</p>
<p> • Parameters:
<p> • oldName (String): The current name of the class to be renamed.</p>
<p> • newName (String): The new name to assign to the class.</p>
<p> • Behavior: </p>
<p> • If the class with oldName exists, it removes the old entry from the </p>
<p>umlClasses map and adds a new entry with newName and the same UMLClass object.</p>
<p> • If the class with oldName does not exist, an error message is printed.</p>
<p> • Usage: To rename an existing UML class in the storage.</p><br>

<h3> Error Handling </h3>

<p> • When adding a class, if the class already exists, an error message is printed: </p>
<p> "Error: Class [className] already exists." </p>
<p> • When renaming a class, if the old class name is not found, the following error message is printed: </p>
<p> "Error: Class [oldName] does not exist." </p>

---

## KnownBugs:

![img.png](img.png)

When I type a class name it saves it, I can add fields and methods to that class.
I can rename it , for example rename the class from Computer to Desktop.
Now, when I a parameter to Desktop, it shows that the parameter was added to both Computer and Desktop classes


add class relationship command:

When adding relationship, this command should also take a source and destination class to define the relationship.
Right now it only sets relationship name and type (as a string).
---


<h3> 1- Label "Class Name", shows the class name.</h3>
<p> Below Class Name label is the field for user to type class name.</p><br>

<p> 2- Label Fields shows the field that should be added to the class.</p>
<p> Below Field Name label is the field for user to type field data type.</p>
<p> and it has the Field for the user to type the Field Name for the class.</p>
<p> the plus " + " sign on the right hand side of the Field Name is the button to add more </p>
<p> field type and field name. User can add as many as user wants.</p><br>

<h3> 3- Methods label shows the fields for Method signature.</h3>
<p> Return type field if for the return type of the method</p>
<p> Method Name field is for the user to type method name</p>
<p> Parameter type field is for the user to type Parameter type, string or int etc. </p>
<p> Parameter fild is for user to type parameter field name </p>
<p> the plus " + " sign button allows user to add more method signature. </p>
<p> user can add as many method signature as needed.</p><br>

<h3> 4- Relationships label shows the dropdown for the relationship types.</h3>
<p> User cand can click on the dropdown menu and select the appropriate type of relationship for the current class.</p>
<p> There are six relationship types user can select from.</p><br>

<h3> 5- Create Class button, creates a node with all the information user has typed.</h3>

----

## Broken Features:


### MovableLine

```java
public class MovableLine {

    @FXML
    Line line;
   // Circle startPoint, endPoint;
    @FXML
    private Button add;

   @FXML
   private Circle endPoint;

    //@FXML
    //private TriangleMesh endPoint;


    @FXML
    private Circle startPoint;

    public MovableLine(Pane root) {
        createDraggableLine(root);
    }

    private void createDraggableLine(Pane root){
        // Create the line
        line = new Line(50, 50, 100, 100);
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(2);


        // Create the start and end points
        startPoint = createDraggablePoint(line.getStartX(), line.getStartY());
        endPoint = createDraggablePoint(line.getEndX(), line.getEndY());
        //endPoint = createDraggablePoint().getId("");
        // Add mouse event handlers for dragging
        startPoint.setOnMouseDragged(e -> handlePointMouseDragged(e, line, true));
        endPoint.setOnMouseDragged(e -> handlePointMouseDragged(e, line, false));

        root.getChildren().addAll(line, startPoint, endPoint);
    }

    private void handlePointMouseDragged(MouseEvent event, Line line, Boolean startPoint) {
        Circle point = (Circle) event.getSource();
        double offsetX = event.getX();
        double offsetY = event.getY();
        point.setCenterX(offsetX);
        point.setCenterY(offsetY);
        point.setLayoutX(event.getSceneX() - offsetX);
        point.setLayoutY(event.getSceneY() - offsetY);

        if (startPoint) {
            line.setStartX(offsetX);
            line.setStartY(offsetY);
        } else {
            line.setEndX(offsetX);
            line.setEndY(offsetY);
        }
    }

    private Circle createDraggablePoint(double x, double y) {
        Circle point = new Circle(x, y, 5, Color.RED);
        point.setStroke(Color.BLACK);
        point.setStrokeWidth(1);
        point.setCenterX(x);
        point.setCenterY(y);
        return point;
    }


    public void removeLineFrom(Pane root){
        root.getChildren().remove(line);
        root.getChildren().remove(startPoint);
        root.getChildren().remove(endPoint);
    }```

----


































