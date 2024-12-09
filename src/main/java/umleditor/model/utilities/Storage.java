package umleditor.model.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import umleditor.model.uml.UMLClass;
import umleditor.model.uml.UMLRelationship;
import umleditor.model.uml.UMLRelationshipType;

/**
 * Singleton Storage class contains the collection of all UML class objects the user creates
 * The instance is accessible through a method to add, remove, check, and rename classes
 *
 * Singleton requirements:
 *    1. private static field for storing singleton instance
 *    2. declare a public static creation method for getting singleton instance
 *    3. Implement “lazy initialization” inside the static method. It should create a new object
 *       on its first call and put it into the static field. The method should always return
 *       that instance on all subsequent calls.
 *    4. Make constructor of the class private. Static method of the class will be able to call constructor,
 *       but not other objects
 *    5. Go over program and replace all direct calls to Storage's constructor to its static creation method
 */
public class Storage {

  // single instance of the Storage. Must be declared volatile for double-check locking works correctly.
  private static volatile Storage instance;


  /**
   *  ArrayList for all Class relations.
   * */
  private static ArrayList<UMLRelationship> relationships;

  // HashMap to store UML classes by their name
  private static HashMap<String, UMLClass> umlClasses;

  // Private Constructor
  private Storage() {
    umlClasses = new HashMap<>();
    relationships = new ArrayList<>();
  }


  /**
   * Public static creation method for getting singleton instance
   * Used double-checked locking (DCL) approach to prevent possible thread issues creating multiple instances
   * @return
   */
  public static Storage getInstance() {
    Storage result = instance;
    if (result != null) {   // check avoids unnecessary synchronization once instance is initialized
      return result;
    }
    synchronized (Storage.class) {  // ensures only one thread can create instance if null
      if (instance == null) {
        instance = new Storage();
      }
      return instance;
    }
  }

  // Method to return all UML classes
  public HashMap<String, UMLClass> getUMLClasses() {
    return umlClasses;
  }

  /**
   * Getter for the List of relationships.
   * */
  public ArrayList<UMLRelationship> getRelationships() {
    return relationships;
  }

  // Method to set UML classes (for loading saved progress)
  public void setUMLClasses(HashMap<String, UMLClass> loadedClasses) {
    umlClasses = loadedClasses;  // Replace current classes with loaded classes
  }

  // Method to add a new class to storage
  public UMLClass createClass(String className) {
    if (!umlClasses.containsKey(className)) {
      UMLClass newClass = new UMLClass(className);  // Create a new UMLClass object
      return newClass;

    } else {
      System.out.println("Error: Class " + className + " already exists.");
      return null;
    }
  }

  public void addClass(String className, UMLClass classObject) {
    umlClasses.put(className, classObject);  // Add it to the storage
  }


  // Method to remove a class from storage
  public void removeClass(String className) {
    umlClasses.remove(className);
  }

  // Method to check if a class exists in storage
  public boolean classExists(String className) {
    return umlClasses.containsKey(className);
  }

  // Method to rename an existing class in storage
  public void renameClass(String oldName, String newName) {
    if (umlClasses.containsKey(oldName)) {
      UMLClass umlClass = umlClasses.remove(oldName);  // Remove the old name
      umlClasses.put(newName, umlClass);  // Add the new name with the existing class data
    } else {
      System.out.println("Error: Class " + oldName + " does not exist.");
    }
  }

  // Method to clear all UML classes
  public void clearUMLClasses() {
    umlClasses.clear();  // Clear the map of UML classes
    System.out.println("All UML classes have been cleared.");
  }

  /**
   * Sets the List of relationships to a new List.
   * @param relationships is the new List to be loaded in.
   * */
  public static void setRelationships(ArrayList<UMLRelationship> relationships) {
    Storage.relationships = relationships;
  }

  /**
   * Adds a relation to the relation ArrayList.
   * @param relation is the UMl relationship to be added to the List.
   * */
  public void addRelation(UMLRelationship relation){
    if (relationships.isEmpty()) {
      System.out.println("Adding relationship " + relation.getType() + " to class " + relation.getSource() + ".");
      relationships.add(relation);
      return;
    } else if (findRelation(relation.getSource(), relation.getType(), relation.getDestination()) != -1) {
      System.out.println("No duplicate entries allowed, please try again");
      return;
    }

    System.out.println("Updating relationship in class " + relation.getSource() + " to " + relation.getType() + ".");
    relationships.add(relation);
  }

  /**
   * method that clears the 'relationships' List.
   * */
  public void removeAllRelationship() {
    if (!relationships.isEmpty()) {
      relationships.clear();
      System.out.println("Removed all relationships.");
    } else {
      System.out.println("Error: No relationship exists to remove.");
    }
  }

  /**
   * A function to remove a *SPECIFIC* relation tuple.
   * @param src is the source class argument.
   * @param type is the relationship type argument.
   * @param dest is the destination class argument.
   * */
  public UMLRelationship removeARelation(String src, UMLRelationshipType type, String dest){
    if(relationships.isEmpty()){
      System.out.println("Can not remove relationship from an empty list");
      return null;
    } else if (src.isEmpty() || type == null || dest.isEmpty()) {
      System.out.println("Param(s) should not be empty, please try again.");
      return null;
    }

    for (int i = 0; i < relationships.size(); i++) {
      UMLRelationship temp = relationships.get(i);

      if (temp.getSource().equals(src) && temp.getType().equals(type) && temp.getDestination().equals(dest)){
        relationships.remove(i);
        return temp;
      }
    }

    return null;
  }

  /**
   * Removes all entries in 'relationships' that match the given type.
   * @param type is the relationship type to be completely removed from 'relationships'.
   * */
  public static int removeType(UMLRelationshipType type){
    if (relationships.isEmpty()){
      System.out.println("Can not remove relationship from an empty list");
      return -1;
    }else if(type == null){
      return  -1;
    }
    int numRmvd = 0;

    // Linearly looks through the List and removes all types of relations
    for(int i = 0; i < relationships.size(); i++){
      UMLRelationship temp = relationships.get(i);
      if (temp.getType().equals(type)){
        relationships.remove(i);
        numRmvd++;
        i--;
      }
    }

    return numRmvd;
  }

  /**
   * Removes all relations of a source class.
   * @param sourceClassName is the source class that will have all it's relationships wiped.
   * */
  public int removeAllClassRelations(String sourceClassName){
    if (relationships.isEmpty()){
      System.out.println("Can not remove relationship from an empty list");
      return -1;
    }else if(sourceClassName.isEmpty()){
      System.out.println("Source name can not be empty!");
      return -1;
    }
    int numRmvd = 0;

    // Linearly looks through List and removes all the source class relations
    for(int i = 0; i < relationships.size(); i++){
      UMLRelationship temp = relationships.get(i);
      if (temp.getSource().equals(sourceClassName)){
        relationships.remove(i);
        numRmvd++;
        i--;
      }
    }

    return numRmvd;
  }

  /**
   * Removes all relations referencing a class.
   * @param className is the class to remove completely from 'relationships'.
   * */

  public int removeAllReferences(String className){
    if (relationships.isEmpty()){
      System.out.println("Can not remove relationship from an empty list");
      return -1;
    }else if(className.isEmpty()){
      System.out.println("Class name can not be empty!");
      return -1;
    }
    int numRmvd = 0;

    for(int i = 0; i < relationships.size(); i++){
      UMLRelationship temp = relationships.get(i);
      if (temp.getSource().equals(className) || temp.getDestination().equals(className)){
        relationships.remove(i);
        numRmvd++;
        i--;
      }
    }

    return numRmvd;
  }

  /**
   * This method alters an existing relationship given a source class name
   * @param args array of size == 2, wherein it tells us what attributes to update in the given tuple.
   * @param sourceName the source class relationship we are changing the type & or destination in.
   * TODO: Need to refactor the type into either a Relationship or UMLClass object.
   *   -Also need to un-stub the method.
   * */
  public int alterBySource(UMLRelationship sourceName, Object[] args) {
    return -1;
  }

  /**
   * This method alters an existing relationship given a source class name
   * @param args array of size == 2, wherein it tells us what attributes to update in the given tuple.
   * @param destinationName the destination relationship we are changing the type & or source in.
   * TODO: Need to refactor the type into either a Relationship or UMLClass object.
   *    -Also need to un-stub the method.
   * */
  public int alterByDestination(UMLRelationship destinationName, Object[] args) {
    return -1;
  }

  /**
   * A method for finding an equivalent relation in the List.
   * */
  private int findRelation(String source, UMLRelationshipType type, String destination){

    for (int i = 0; i < relationships.size() - 1; i++){
      UMLRelationship temp = relationships.get(i);
      if (temp.getSource().equals(source) && temp.getType().equals(type) && temp.getDestination().equals(destination)){
        return i;
      }
    }

    return -1;
  }

  /**
   * A function for completely wiping the model,
   *  it's mainly used for testing.
   * */
  public void clear(){
    umlClasses.clear();
    relationships.clear();
  }

  // Method to get a UMLClass by its name
  public UMLClass getClassObject(String className) {
    return umlClasses.get(className);
  }
}
