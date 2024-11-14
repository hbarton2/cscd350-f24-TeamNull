# Technical Documentation


---

## Table of Contents
1. [Entry Point](#Entry Point)
2. [UMLClass](#UMLClass)
3. [UMLClassRelationshipType](#UMLRelationshipType)
4. [CommandAction](#CommandAction)
5. [CommandFactory](#CommandFactory)
6. [Commands](#Commands)
7. [Display](#Display)
8. [Functions](#Functions)
9. [ParsingInputs](#ParsingInputs)
10. [Storage](#Storage)
11. [KnownBugs](#KnownBugs)





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

## UMLClass: 
<h3> Overview: </h3>
Handles all class objects created by the user
Name, Attributes (Fields), List of Methods, Fields, Relationships

<h3> Features: </h3>
<p> Add Attributes: <br>
    Adds an attribute to a class</p>
<p> Create Methods: <br>
    creates a new method object and adds to list of methods in this class</p>
<p> Remove Method: <br>
    finds method in class list and removes it by name</p>
<p> Create Fields: <br>
    uses name and type, to create a new UMLField object and add it to the list of fields</p>
<p> Remove Fields: <br>
    finds field by name and if it exists, removes from list of fields</p>
<p> Rename Method: <br>
    finds method in class method list, if it exists then asks user to enter new name. Renames method if name is not already taken</p>
<p> isMethodExists: <br>
    returns boolean if method name is found in method list</p>
<p> Find (Object): <br>
    Methods that search the relevant list using the given name and returns the object if it exists </p>
<p> Display (Object): <br>
    Display Methods, cycle through the relevant list and print to screen the information </p>

----

## UMLRelationshipType:

### Overview: 

Enum class that contains available relationship types:

* ASSOCIATION
* AGGREGATION
* COMPOSITION
* INHERITANCE

---

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

* createClass:
Method call for creating a class, checks if class already exists if not then adds to the list

* removeClass:
checks if class exists if it does then removes from the class list

* renameClass:
takes parameters oldName and newName, checks if class exists if it does then calls objects internal renameClass method

* addAttribute (field):
takes parameter className and attribute, checks if class exists then calls addAttribute within the class

* removeAttribute (field):
  takes parameter className and attribute, checks if class exists then calls removeAttribute within the class

* addMethod:
takes className, methodName, and parameter. if Class does not exist or method name is taken then returns, otherwise adds method and optionally the parameter

* removeMethod:
takes className, methodName, and parameter. if Class does not exist or method name is taken then returns, otherwise removes method

* addRelationship:
Adds or updates a relationship in a class.

* removeRelationship:
Removes a relationship from a class

* getRelationshipType:
Retrieves the available relationship types: ASSOCIATION, AGGREGATION, COMPOSITION, INHERITANCE


* listClasses:
Contains case for list class commands, including: listAllClassDetails, listClassNamesOnly, listClassesWithRelationships

* listAllClassDetails:
List all class details including attributes (fields) and methods. If classes are empty, will print "No classes created."

* listClassNamesOnly:
List classes by name only. If classes are empty will display "No classes created."

* listClassesWithRelationships:
List all classes that have relationships. If classes are empty, will display "No classes created."

* saveProgress:
Saves progress to a JSON file.

* loadProgress:
Loads a progress state from a JSON file.

* clearProgress:
Clears user terminal of progress history.



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






## Storage:
<h3> Storage</h3>

### Overview:
<h3> Overview</h3>

<p> The Storage class is a utility that manages the storage of UML class objects created by the user.</p><br>
<p> It allows for adding, removing, renaming, and checking the existence of UML classes using static methods. </p>
<p> The storage mechanism is based on a HashMap where the key is the class name (a String) and the value is a UMLClass object.</p><br>

<h3> Data Structure</h3>

<p> The class uses a private static HashMap to store all UML class objects:</p>
<p> private static HashMap<String>, UMLClass> umlClasses = new HashMap<p>();</p>
<p> • Key: The name of the UML class (String).</p>
<p> • Value: The corresponding UMLClass object.</p>

<h3> Key Features: </h3>

<p> 1. Store UML Class objects: Stores and retrieves UML class objects using a HashMap.</p>
<p> 2. Add and Remove Classes: Supports adding new classes and removing existing ones.</p>
<p> 3. Check Class Existence: Provides a method to verify if a class exists in the storage. </p>
<p> 4. Rename Classes: Allows renaming an existing class.</p><br>


<h3> Methods: </h3>

<p> 1. getUMLClasses </p>

<p>public static HashMap<String>, UMLClass> getUMLClasses()

<p> • Description: Returns the entire umlClasses HashMap, which contains all the UML classes currently stored. </p>
<p> • Return Type: HashMap<String, UMLClass> </p>
<p> • Usage: To access the full collection of UML classes in storage.</p> <br>

<h3> 2. addClass(String className) </h3>

<p> public static void addClass(String className)</p>

<p> • Description: Adds a new UML class to the storage if the class name doesn’t already exist.</p>
<p> • Parameters:
<p> • classNa>me (String): The name of the class to be added. </p>

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
umlClasses map and adds a new entry with newName and the same UMLClass object.</p>
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








































