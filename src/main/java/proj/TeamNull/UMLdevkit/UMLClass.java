package proj.TeamNull.UMLdevkit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * UMLClass represents a class that the user can create in the application, stores all methods, fields,
 * and relations inside its private arraylists
 * <p>
 * UMLClass constructor only takes name parameter because all other additions to the array lists will be
 * handled by the add methods inside this class.
 * <p>
 * TODO: create add methods for creating and adding to lists: addMethod, addField, addRelationship,
 *  these methods will be private and have no parameters they will be responsible for obtaining the
 *  user input needed to create the objects
 * <p>
 *  TODO: create remove methods: removeMethod, removeField, removeRelationship that will remove an object
 *   from this classes arrays, These methods will not have parameters they will need to ask the user
 *   for the necessary information such as name and type
 * <p>
 *  TODO: implement rename class feature that takes newName parameter and updates current name
 * <p>
 * All of these methods must have some form of print to the screen to confirm to the user that the action has
 * been completed
 */

public class UMLClass {
  Scanner sc = new Scanner(System.in);
  private String name;

  //these ArrayLists contain all the attributes to this class instance
  //TODO Change from <Object> to our new UML objects
  private ArrayList<UMLMethod> methods;
  private ArrayList<UMLField> fields;
  private ArrayList<Object> relationships;

  public UMLClass(String name) {
    this.name = name;
    this.methods = new ArrayList<>();
    this.fields = new ArrayList<>();
    this.relationships = new ArrayList<>();
    createFields();
    createMethods();
  }

  //does not take any parameters because it will prompt for user input itself
  public void createMethods() {
    String methodName;
    while (true) {
      System.out.println("Enter Method Name: (type 'done' to exit)");
      methodName = sc.nextLine();
      if (methodName.equalsIgnoreCase("done"))
        break;
      else {
        if (isMethodNameExists(methodName)) {
          System.out.println("Method name already exists. Please enter a different name.");
        } else {
          UMLMethod newMethod = new UMLMethod(methodName);
          this.methods.add(newMethod);
          System.out.println("Method " + methodName + " created");
        }
      }
      this.displayMethods();
    }
  }
  //Renames method in this class, first checks if method name is taken. Must provide new method name
  public void renameMethod(String oldName, String newName){
    UMLMethod method =  findMethod(oldName);
    if(isMethodNameExists(newName))
      System.out.println("Method name already exists. Please enter a different name.");
    else {
        assert method != null;
        method.changeName(newName);
    }
  }

  private boolean isMethodNameExists(String methodName) {
    for (UMLMethod method : this.methods) {
      if (method.getName().equals(methodName)) {
        return true;
      }
    }
    return false;
  }


  /**
   * Generates as many fields as the user wants.
   * Does not currently handle when user mistypes 'done'.
   * TODO: Check for proper naming convention and add type to field.
   * Does not take any parameters because it will prompt for user input itself.
   * **/
  public void createFields() {
    String fieldName;

    while (true) {
      System.out.println("Enter Field Name: (type 'done' to exit)");
      fieldName = sc.nextLine();
      if (fieldName.equalsIgnoreCase("done"))
        break;
      else {
        UMLField newField = new UMLField(fieldName);
        fields.add(newField);
        System.out.println("Field " + fieldName + " created");
      }
    }
  }

  //does take a parameter name that must be provided
  public void deleteMethod(String name) {
    UMLMethod method = findMethod(name);
    if (method != null) {
      this.methods.remove(method);
      System.out.println("Method " + name + " removed.");
    } else {
      System.out.println("Method " + name + " not found.");
    }
  }

  /**
   * Deletes existing field within this.fields
   * @param name takes name of field to be deleted.
   * **/
  public void deleteField(String name) {
    UMLField field = findField(name);
    if (field != null) {
      fields.remove(field);
      System.out.println("Field " + name + " removed.");
    } else {
      System.out.println("Field " + name + " not found.");
    }
  }

  //private method for searching for a method in this class
  private UMLMethod findMethod(String name) {
    for (UMLMethod method : this.methods) {
      if (method.getName().equalsIgnoreCase(name)) {
        return method;
      }
    }
    return null;
  }

  /**
   * Finds, or doesn't find, a field within the class.
   * If found, return the obj in the Array, else, return null.
   * @param name takes name of field to be found.
   * **/
  private UMLField findField(String name) {
    for (UMLField field : fields) {
      if (field.getName().equalsIgnoreCase(name)) {
        return field;
      }
    }
    return null;
  }

  //displays methods in this class
  public void displayMethods() {
    if (this.methods.isEmpty()) {
      System.out.println("No methods available.");
    } else {
      System.out.println("Methods in " + name + ":");
      for (UMLMethod method : this.methods) {
        System.out.println("- " + method.getName());
      }
    }
  }

  /**
   * Displays all fields within a given class.
   * Takes no params.
   * **/
  public void displayFields() {
    if (fields.isEmpty()) {
      System.out.println("No fields available.");
    } else {
      System.out.println("Fields in " + name + ":");
      for (UMLField field : fields) {
        System.out.println("- " + field.getName());
      }
    }
  }

  /**
   * Accessor method for grabbing class 'name'.
   * **/
  public String getName() {
    return this.name;
  }

  /**
   * Mutator method for changing class 'name'.
   * **/
  public void setName(String name) {
    this.name = name;
  }

/**
 * Takes the name and new name from the user and renames the field.
 * Uses 'findField()' to grab the memory reference and use the field class mutator to
 * set it to the new name.
 * @return String
 * @param name Name of existing field
 * @param newName Name to replace name of existing field.
 * */
  public String renameField(String name, String newName){
    UMLField field = findField(name);
    if (field != null) {
      field.setName(newName);
      return "Field: " + name + " found & renamed to --> " + newName + "\r\n";
    }
    return "Field: " + name + " not found.\nReturning to menu\r\n";
  }
}