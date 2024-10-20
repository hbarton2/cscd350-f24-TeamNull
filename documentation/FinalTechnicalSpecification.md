# Technical Documentation

## Section guidelines (for each class of project)
* Description of class and how it works
* Features:
  * methods, fields etc it contains plus brief description
* Error Handling decriptions
* 

## Table of Contents
1. [Entry Point](#Entry Point)
2. [UMLClass](#UMLClass)
3. [UMLClassRelationship](#UMLClassRelationship)
4. [UMLField](#Field)
5. [UMLMethod](#UMLMethod)
6. [ActionHandler](#ActionHandler)
7. [Commands](#Commands)
8. [Display](#Display)
9. [Functions](#Functions)
10. [Parser](#Parser)
11. [Storage](#Storage)




----
## Entry Point: 
//TODO: UPDATE WITH WORKING ENTRYPOINT
### Overview:
Point of entry for user into UML Editor application. 
### Features:
* start() 
  * Sets the stage for application. Creates a new scene for user.
* main()
  * launches program for user

----

## UMLClass: 
<h3> Overview: </h3>
Handles all class objects created by the user
Attributes: Name, List of Methods, Fields, Relationships

<h3> Features: </h3>
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
    Methods that search the relevent list using the given name and returns the object if it exists </p>
<p> Display (Object): <br>
    Display Methods, cycle through the relevent list and print to screen the information </p>

----

## UMLClassRelationship:

### Overview:

UMLClassRelationship class represents the connection between two class objects.
Will define relationships between a source class and a destination class, and define the type of relationship.

### Features:

* Fields:
  * name: the name used to reference a relationship
  * source: the source class in the class relationship
  * destination: the destination class in the class relationship 
  * type: the type of the class relationship
* Class Relationship Constructor:

  Contructs a class relationship by taking in and assigning the relationship 
name, source class name, destination class name, and the type of relationship.

* getName: 

  Retrieves the name of the classRelationship object. 

* setName:

  Sets the name of the classRelationship object.

* getSource:

  Gets the source class of the relationship.

* setSource:

  Sets the source class of the relationship.

* getDestination:

  Gets the destination class of the relationship.

* setDestination:

  Sets the destination class of the relationship.

* getType:

  Gets the class relationship type.

* setType:

  Sets the class relationship type.

* toString:

  Overriden toString method. Creates a string for the class in the format: 
> "Relationship: name [source -> destination] type"



----
## UMLField:
### Overview:
UMLField represents a field object within a class

### Features:
<p> Get/Set Name <br>
    methods to retrieve the name field and change name field within UMLField object</p>
<p> Get/Set Type <br>
    methods to retrieve and update type field</p>

----

## UMLMethod:
### Overview:
UMLMethod represents a method within a class, has nested private class UMLParameter 
Attributes: Name and List of Parameters
### Features:
<p> UMLParameter: <br>
    Nested subclass that contains constructor for creating a parameter, has a name and a type</p>
<p> Create Parameter: <br>
    Method for creating a parameter object and adding it to the parameters list</p>
<p> Remove Parameter: <br>
    Method for checking if parameter exists in list and removing it if it does</p>
<p> Change name: <br>
    given a new name, updates the name of this method object with new name</p>>
<p> Change Parameter: <br>
    given the name of the parameter you want to change, enter a new name and type, updates that parameter</p>
<p> Display Parameters: <br>
    Function to display all parameters contained in this method object </p>


---
# Utilities:



## ActionHandler:

### Overview:

Parcer class feeds a phrase and ActionHandler that attributes to a command from Commands class.

---
## Commands:

### Overview:
Stores UML Editor commands as hash table.

---

## Display:

### Overview:
Handles all display functionality.

---

## Functions:

### Overview:
Stores method calls.

---

## Parser:

### Overview:
Parser class handles all user input then seeks command class.

---

## Storage:

### Overview:

Storage class contains an array list of all the class objects of user's application state.






---
## DeleteUMLClass Utility

<h3> Overview </h3>

The DeleteUMLClass class is a utility designed to delete a UML class by its name from a provided list. This class helps manage UML classes by allowing users to remove classes stored in an ArrayList. The method validates input parameters and provides appropriate feedback depending on the success or failure of the delete operation.

<h3> Features </h3>

• Deletes a UML class from a list based on the class name.
• Checks if the list and the class name provided are valid (i.e., non-empty).
• Provides clear messages for the following cases:
• The class list is empty or invalid.
• The class to delete is not found.
• The class is successfully deleted.

<h3> Usage </h3>

<h3> Method: </h3>
<h3> deleteClassByName </h3>

<p>public static void deleteClassByName(ArrayList<p> storageList, String classNameToDelete)</p>

<h3> • Parameters: </h3>

• storageList: An ArrayList<Object> where each entry represents a class (as an ArrayList<Object> with class details).
• classNameToDelete: A String representing the name of the class to delete.
• Preconditions:
• The list must not be null or empty.
• The class name to delete must not be empty.

<h3> • Description: </h3>

<p>• This method searches through the provided list of classes to find the one matching the name provided. </p>
<p>• If the class is found, it will be deleted from the list, and a confirmation message will be displayed.</p>
<p>• If the class is not found, it will print a message informing the user that the class name was not found and may need to be corrected.</p>


<h3> Error Handling </h3>

<p>• If the class list is null or empty, the method will print:</p>
Storage array list is empty.
<p>• If the class to be deleted is not found, the method will print: </p>
<p> Class 'ClassName' not found. Please make sure the class exists & is spelled correctly.</p>
• On successful deletion, the method will print:
Class 'ClassName' deleted successfully.

---


<h3> ListAllUMLClasses Utility</h3>

<h3> Overview</h3>

<p> The ListAllUMLClasses class is a simple utility designed to display the details of UML classes stored in a list.</p>
<p>This class processes an array list containing class details (class name, fields, and methods) and </p> 
<p>prints these details in a structured format. The utility helps users visualize UML class details quickly and </p>
<p>efficiently.<br> </p>

<h3> Features</h3>

<p> • Display UML Class Details: Lists all the UML classes in the provided list, including their names, fields, and methods.</p>
<p> • Handles Empty Input: Checks if the provided list is empty and informs the user when no classes are available.</p>
<p> • Formatted Output: Outputs the class details in a neat and readable format for easy viewing. <br> </p>

<h3> Usage</h3>

<h3> Method:</h3>
<p>displayClassDetails</p>

<p> public void displayClassDetails(ArrayList<ArrayList<p>> allClasses)</p>

<h3> Parameters:</h3>
<p>• allClasses: An ArrayList where each element is another ArrayList representing a UML class.<br> </p>
<p>Each UML class list contains:</p>
<p>• List of Fields(String)</p>
<p>• List of Methods (String)</p>

• Description:
• If the list of classes is empty, the method prints a message:
The UML Class List is empty.
• If the list contains classes, it loops through each class and prints:
• The class name.
• The fields (e.g., attributes or properties).
• The methods (e.g., functions associated with the class).


Error Handling

• Empty List: If the list of UML classes is null or empty, the method will print:
The UML Class List is empty.












































