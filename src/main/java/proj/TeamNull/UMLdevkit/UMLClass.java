package proj.TeamNull.UMLdevkit;

import java.util.ArrayList;
import java.util.List;

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
  private String name;

  //these ArrayLists contain all the attributes to this class instance
  //TODO Change from <Object> to our new UML objects
  private ArrayList<Object> methods;
  private ArrayList<Object> fields;
  private ArrayList<Object> relationships;

  public UMLClass(String name) {
    this.name = name;
  }
}
