package umleditor.sprint1.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import umleditor.sprint1.uml.UMLClass;
import umleditor.sprint1.uml.UMLRelationship;
import umleditor.sprint1.uml.UMLRelationshipType;

/**
 * Storage class contains the collection of all UML class objects and UML relations the user creates. The collection
 * 'umlClasses' is accessible through static methods to add, remove, check, and rename classes
 * and 'relations' is accessible through static methods as well.
 */
public class Storage {

  /**
   *  ArrayList for all Class relations.
   * */
  private static ArrayList<UMLRelationship> relationships = new ArrayList();

  /**
   * Getter for the List of relationships.
   * */
  public static ArrayList<UMLRelationship> getRelationships() {
    return relationships;
  }

  // HashMap to store UML classes by their name
  private static HashMap<String, UMLClass> umlClasses = new HashMap<>();

  // Method to return all UML classes
  public static HashMap<String, UMLClass> getUMLClasses() {
    return umlClasses;
  }

  // Method to set UML classes (for loading saved progress)
  public static void setUMLClasses(HashMap<String, UMLClass> loadedClasses) {
    umlClasses = loadedClasses;  // Replace current classes with loaded classes
  }

  /**
   * Sets the List of relationships to a new List.
   * @param relationships is the new List to be loaded in.
   * */
  public static void setRelationships(ArrayList<UMLRelationship> relationships) {
    Storage.relationships = relationships;
  }

  // Method to add a new class to storage
  public static void addClass(String className) {
    if (!umlClasses.containsKey(className)) {
      UMLClass newClass = new UMLClass(className);  // Create a new UMLClass object
      umlClasses.put(className, newClass);  // Add it to the storage
    } else {
      System.out.println("Error: Class " + className + " already exists.");
    }
  }

  // Method to remove a class from storage
  public static void removeClass(String className) {
    umlClasses.remove(className);
  }

  // Method to check if a class exists in storage
  public static boolean classExists(String className) {
    return umlClasses.containsKey(className);
  }

  // Method to rename an existing class in storage
  public static void renameClass(String oldName, String newName) {
    if (umlClasses.containsKey(oldName)) {
      UMLClass umlClass = umlClasses.remove(oldName);  // Remove the old name
      umlClasses.put(newName, umlClass);  // Add the new name with the existing class data
    } else {
      System.out.println("Error: Class " + oldName + " does not exist.");
    }
  }

  // Method to clear all UML classes
  public static void clearUMLClasses() {
    umlClasses.clear();  // Clear the map of UML classes
    System.out.println("All UML classes have been cleared.");
  }

  /**
   * Adds a relation to the relation ArrayList.
   * @param relation is the UMl relationship to be added to the List.
   * */
  public static void addRelation(UMLRelationship relation){
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
  public static void removeAllRelationship() {
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
   * TODO: Un-stub method.
   * */
  public static UMLRelationship removeARelation(String src, UMLRelationshipType type, String dest){
    return null;
  }

  /**
   * Removes all entries in 'relationships' that match the given type.
   * @param type is the relationship type to be completely removed from 'relationships'.
   * TODO: Un-stub method.
   * */
  public static int removeType(UMLRelationshipType type){
    return 0;
  }

  /**
   * Removes all relations of a source class.
   * @param sourceClassName is the source class that will have all it's relationships wiped.
   * TODO: Un-stub method.
   * */
  public static int removeAllClassRelations(String sourceClassName){
    return 0;
  }

  /**
   * Removes all relations referencing a class.
   * @param className is the class to remove completely from 'relationships'.
   * TODO: Un-stub method.
   * */

  public static int removeAllReferences(String className){
    return 0;
  }

  /**
   * This method alters an existing relationship given a source class name
   * @param args array of size == 2, wherein it tells us what attributes to update in the given tuple.
   * @param sourceName the source class relationship we are changing the type & or destination in.
   * TODO: Need to refactor the type into either a Relationship or UMLClass object.
   *   -Also need to un-stub the method.
   * */
  public static int alterBySource(UMLRelationship sourceName, Object[] args) {
    return -1;
  }

  /**
   * This method alters an existing relationship given a source class name
   * @param args array of size == 2, wherein it tells us what attributes to update in the given tuple.
   * @param destinationName the destination relationship we are changing the type & or source in.
   * TODO: Need to refactor the type into either a Relationship or UMLClass object.
   *    -Also need to un-stub the method.
   * */
  public static int alterByDestination(UMLRelationship destinationName, Object[] args) {
    return -1;
  }

  /**
   * A method for finding an equivalent relation in the List.
   * */
  private static int findRelation(String source, UMLRelationshipType type, String destination){

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
  public static void clear(){
    umlClasses.clear();
    relationships.clear();
  }

}
