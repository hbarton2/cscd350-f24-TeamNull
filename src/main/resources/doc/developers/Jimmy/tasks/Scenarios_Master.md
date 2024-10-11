# Scenarios and Features

### Scenario: Add Field (ETE: 2-3 hours)
**Feature**: Add a Field to a Class

- **As a user**,  
  **I want to** add fields if they do not already exist,  
  **So that** I can update and add to the application.

#### Steps:
1. **Given** that I am in the menu,
2. **When** I select the option to add a field,
3. **Then** I should be required to input a valid class name,
4. **When** I enter a valid class name,
5. **Then** I should be required to input a unique field name,
6. **Then** I should be returned to the menu.

---

### Scenario: Add Method (ETE: 3-4 hours)
**Feature**: Add a Method to a Class

- **As a user**,  
  **I want to** add methods if they do not already exist,  
  **So that** I can add new features to the application.

#### Steps:
1. **Given** that I am in the menu,
2. **When** I select the option to add a method,
3. **Then** I should be required to input a valid class name,
4. **Then** I should be required to input a method name,
5. **Then** I should be prompted to enter any parameters,
6. **If** I choose to enter parameters, I should be able to continue entering parameters until I type 'done',
7. **Then** I should be returned to the menu.

---

### Scenario: Remove Field (ETE: 2-3 hours)
**Feature**: Remove a Field from a Class

- **As a user**,  
  **I want to** remove fields if they are present,  
  **So that** I can simplify and minimize my application.

#### Steps:
1. **Given** that I am in the menu,
2. **When** I select the option to remove a field,
3. **Then** I should be required to enter a valid class name,
4. **Given** that I have entered a valid class name,
5. **Then** I should be required to enter a valid field name,
6. **Given** that the class name and field name exist,
7. **Then** I should be returned to the menu.

---

### Scenario: Remove Method (ETE: 2-3 hours)
**Feature**: Remove a Method from a Class

- **As a user**,  
  **I want to** remove methods if they exist in the application,  
  **So that** I can remove features that I no longer need.

#### Steps:
1. **Given** that I am in the menu,
2. **When** I select the option to remove a method,
3. **Then** I should be required to enter a valid class name,
4. **Given** that I have entered a valid class name,
5. **Then** I should be required to enter a valid method name,
6. **Given** that a single instance of the method exists,
7. **Then** I should be returned to the menu.

---

### Scenario: Remove Method (Overloaded) (ETE: 3-4 hours)
**Feature**: Remove an Overloaded Method

- **As a user**,  
  **I want to** remove overloaded methods when multiple methods with the same name exist,  
  **So that** I can manage overloaded methods in the class.

#### Steps:
1. **Given** that I am in the menu,
2. **When** I select the option to remove a method,
3. **Then** I should be required to enter a valid class name,
4. **Given** that I have entered a valid class name,
5. **Then** I should be required to enter a valid method name,
6. **Given** that there is more than one method with the same name in this class,
7. **Then** all methods with that name should be displayed,
8. **When** I select the method I want to remove,
9. **Then** I should be returned to the menu.

---

### Scenario: Rename Field (ETE: 2-3 hours)
**Feature**: Rename a Field in a Class

- **As a user**,  
  **I want to** rename fields in the application,  
  **So that** I can easily change and update my application.

#### Steps:
1. **Given** that I am in the menu,
2. **When** I select the option to rename a field,
3. **Then** I should be required to input a valid class name,
4. **Then** I should be required to input the field name I intend to change,
5. **Then** I should input the new name for the field,
6. **Once** the field is renamed,
7. **Then** I should be returned to the menu.

---------------------------------

# Scenarios and Features

### Scenario: Altering Methods (ETE: 3-4 hours)
**Feature**: Alter a Method of a Class

- **As a user**,  
  **I want to** alter the methods of a class,  
  **So that** I can update the function’s purpose.

#### Steps:
1. **Given** that I am in the Menu,
2. **When** I want to alter a method,
3. **Then** I should be required to input a valid class name and one of its valid methods,
4. **Then** I should be required to input the desired attribute(s) I want to change,
5. **Then** I should be required to input a valid value to change the attribute to,
6. **Then** I should be returned back to the Menu.

---

### Scenario: Renaming Methods (ETE: 2-3 hours)
**Feature**: Rename a Method in a Class

- **As a user**,  
  **I want to** rename a method of a class,  
  **So that** I can change the method’s name as needed.

#### Steps:
1. **Given** that I am in the Menu,
2. **When** I select 'Rename Method',
3. **Then** I should be required to input an existing method of a class,
4. **Then** I should be prompted to enter a new name,
5. **Then** the new name should not already exist as another method,
6. **Then** I should be able to enter the new name, changing the old method’s name,
7. **Then** I should be returned to the Menu.

---

### Scenario: Adding Parameters (ETE: 2-3 hours)
**Feature**: Add Parameters to a Method

- **As a user**,  
  **I want to** add parameter(s) to a method,  
  **So that** I can expand the method’s functionality.

#### Steps:
1. **Given** that I am in the Menu,
2. **When** I select 'Add Parameter(s)',
3. **Then** I should be required to enter the existing method of a class I want to alter,
4. **Then** I should be prompted to enter the name and type of the new parameters,
5. **Then** the parameter(s) and their names should be added to the method,
6. **Then** I should be returned to the Menu.

---

### Scenario: Removing Parameters (ETE: 2-3 hours)
**Feature**: Remove Parameters from a Method

- **As a user**,  
  **I want to** remove parameter(s) in a method,  
  **So that** I can simplify the method by removing unwanted parameters.

#### Steps:
1. **Given** that I am in the Menu,
2. **When** I select 'Remove Parameter(s)',
3. **Then** I should be prompted to enter the existing method’s class, name, and the parameter(s) I wish to remove,
4. **Then** the parameter(s) should be removed,
5. **Then** I should be returned to the Menu.

---

### Scenario: Changing Parameters (ETE: 3-4 hours)
**Feature**: Change Parameters of an Existing Method

- **As a user**,  
  **I want to** change the parameter(s) of an existing method,  
  **So that** I can modify the method's functionality as needed.

#### Steps:
1. **Given** that I am in the Menu,
2. **When** I select 'Change Parameter(s)',
3. **Then** I should be required to enter the existing method’s class, name, and the parameter(s) I want to change,
4. **Then** I should be prompted to enter the new name(s) and/or variable type(s) I wish to change the existing parameter(s) to,
5. **Then** the new parameter name(s) and type(s) should replace the old ones,
6. **Then** I should be returned to the Menu.

---

### Expected Time Estimates for All Scenarios:
- **Altering Methods**: 3-4 hours
- **Renaming Methods**: 2-3 hours
- **Adding Parameters**: 2-3 hours
- **Removing Parameters**: 2-3 hours
- **Changing Parameters**: 3-4 hours

-----------------------------------

# Scenarios and Features

### Scenario: Add Class (ETE: 2-3 hours)
**Feature**: Add a Class with a Name

- **As a user**,  
  **I want to** add a class with a name,  
  **So that** I can visualize the class in my project.

#### Steps:
1. **Given** that I am in the Menu,
2. **When** I select 'Add Class',
3. **Then** I should be required to enter a class name,
4. **If** the class name is unique and valid,
5. **Then** the class should be created and visualized,
6. **Then** I should be returned to the Menu.

---

### Scenario: Delete Class (ETE: 2-3 hours)
**Feature**: Delete a Class by Name

- **As a user**,  
  **I want to** delete a named class,  
  **So that** it is removed from the visualized classes.

#### Steps:
1. **Given** that I am in the Menu,
2. **When** I select 'Delete Class',
3. **Then** I should be required to input the name of the class I want to delete,
4. **If** the class name exists,
5. **Then** the class should be deleted and removed from the visualization,
6. **Then** I should be returned to the Menu.

---

### Scenario: Rename Class (ETE: 2-3 hours)
**Feature**: Rename a Class

- **As a user**,  
  **I want to** rename a class,  
  **So that** I can update its name when necessary.

#### Steps:
1. **Given** that I am in the Menu,
2. **When** I select 'Rename Class',
3. **Then** I should be required to input the name of the class I want to rename,
4. **Then** I should be prompted to input a new name,
5. **If** the new name is valid and unique,
6. **Then** the class should be renamed,
7. **Then** I should be returned to the Menu.

---

### Scenario: Add Class Relationship (ETE: 3-4 hours)
**Feature**: Add a Relationship Between Classes

- **As a user**,  
  **I want to** add a class relationship between a source and destination class,  
  **So that** I can visualize how they relate to each other.

#### Steps:
1. **Given** that I am in the Menu,
2. **When** I select 'Add Class Relationship',
3. **Then** I should be required to input the name of the source class,
4. **Then** I should be required to input the name of the destination class,
5. **If** both classes exist,
6. **Then** a relationship should be created and visualized,
7. **Then** I should be returned to the Menu.

---

### Scenario: Delete Class Relationship (ETE: 2-3 hours)
**Feature**: Delete a Relationship Between Classes

- **As a user**,  
  **I want to** delete a relationship between identified source and destination classes,  
  **So that** the relationship is no longer visualized.

#### Steps:
1. **Given** that I am in the Menu,
2. **When** I select 'Delete Class Relationship',
3. **Then** I should be required to input the names of both the source and destination classes,
4. **If** a relationship exists between the classes,
5. **Then** the relationship should be deleted and removed from the visualization,
6. **Then** I should be returned to the Menu.

---

### Expected Time Estimates for All Scenarios:
- **Add Class**: 2-3 hours
- **Delete Class**: 2-3 hours
- **Rename Class**: 2-3 hours
- **Add Class Relationship**: 3-4 hours
- **Delete Class Relationship**: 2-3 hours

-----------------------------------------

# User Stories and Scenarios for CLI Application

### Scenario: List All Classes (ETE: 2-3 hours)
**Feature**: List all classes and their contents

- **As a user**,  
  **I want to** see a list of all classes and their contents,  
  **So that** I can understand which classes exist and what they contain.

#### Steps:
1. **Given** that I am in the CLI application,
2. **When** I select the 'List All Classes' command,
3. **Then** I should see a list of all the classes in the system,
4. **And** each class should display its name, attributes, and methods.

---

### Scenario: List Specific Class (ETE: 2-3 hours)
**Feature**: Display the contents of a specific class

- **As a user**,  
  **I want to** see the contents of a specific class,  
  **So that** I can understand the details of that particular class, including its attributes and methods.

#### Steps:
1. **Given** that I am in the CLI application,
2. **When** I select the 'List Specific Class' command,
3. **Then** I should be prompted to enter the name of the class I want to view,
4. **If** the class exists,
5. **Then** the class name, attributes, and methods should be displayed.

---

### Scenario: List Relationships Between Classes (ETE: 2-3 hours)
**Feature**: Display the relationships between classes

- **As a user**,  
  **I want to** see a list of relationships between classes,  
  **So that** I can understand how different classes interact with each other.

#### Steps:
1. **Given** that I am in the CLI application,
2. **When** I select the 'List Class Relationships' command,
3. **Then** I should see a list of all class relationships,
4. **And** the relationships should show the source class, destination class, and the type of relationship.

---

### Scenario: Help Command (ETE: 1-2 hours)
**Feature**: Display a list of available commands

- **As a user**,  
  **I want to** see the available commands and how to use them,  
  **So that** I can easily understand how to interact with the application.

#### Steps:
1. **Given** that I am in the CLI application,
2. **When** I select the 'Help' command,
3. **Then** I should see a list of available commands,
4. **And** each command should include a short description of what it does.

---

### Scenario: Exit Command (ETE: 1 hour)
**Feature**: Exit the CLI application

- **As a user**,  
  **I want to** exit the application,  
  **So that** I can stop using it when I am finished.

#### Steps:
1. **Given** that I am in the CLI application,
2. **When** I select the 'Exit' command,
3. **Then** the application should close,
4. **And** I should return to my operating system's shell or terminal.

---

### Expected Time Estimates for All Scenarios:
- **List All Classes**: 2-3 hours
- **List Specific Class**: 2-3 hours
- **List Relationships Between Classes**: 2-3 hours
- **Help Command**: 1-2 hours
- **Exit Command**: 1 hour

-----------------------