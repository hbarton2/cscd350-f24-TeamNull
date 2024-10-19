package proj.TeamNull.UMLdevkit.reference.UMLComponent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * UMLClass extends UMLComponent. Represents class in UML Editor.
 * Used to create a UMLClass object or add or remove any components from an already created class
 * <p>
 * components list contains all Fields, Methods, and Relationships represented in this class
 * Constructor receives name of class and list of all Fields, Methods, and Relationships
 * Add: takes object of type UMLComponent and adds to components field
 * remove: takes object of type UMLComponent and removes from component field
 * <p>
 * TODO Break up components list into separate lists for Fields, Methods, Relationships. <-- Completed!(Shane wuz here)
 * <p>
 * TODO We have no way of creating UMLField, UMLMethod, UMLRelationship objects within this class,
 *  implement method that will use user input to create these objects then call add()
 */
public class UMLClass extends UMLComponent {

  //private List<UMLComponent> components = new ArrayList<>();
  private List<UMLField> fields = new ArrayList<>();
  private List<UMLMethod> methods = new ArrayList<>();
  private List<UMLRelationship> relations = new ArrayList<>();

/**
 * UMLClass constructor
 * @param name refers to class name.
 * **/
  public UMLClass(String name) {
    super(name);
  }

  /**
   * @Override method from parent class UMLComponent
   * Takes an object, ensures it is a proper UMLComponent that is NOT a UMLClass,
   * then adds the appropriate component to the UMLClass.
   * If the object is NOT a component, it informs the user that this action is not allowed.
   * <p>
   * It first checks if the object being passed is NOT empty.
   * Then it checks that it is in fact a UMLComponent and NOT a UMLClass.
   * It will then check only 2 cases wherein the object is either a field or a method.
   * If it is neither of these two things, it is therefor a relationship.
   * Finally, it will add the new component to one of the 3 UMLClass arrayLists.
   * <p>
   * @param component references UMLComponent Obj to be added to the UMLClass.
   * **/
  @Override
  public void add(Object component) {
    if (component.equals(null))throw new IllegalArgumentException("Can not leave argument as empty!");

    if (component instanceof UMLComponent && !(component instanceof UMLClass)){
      if (component instanceof UMLField){
        this.fields.add((UMLField) component);
        System.out.println("Field: " + component + "has been successfully created!");
      }else if(component instanceof UMLMethod){
        System.out.println("Added a method!!"); // <-- remove this when implementing add method(Shane wuz here)
      }else{
        System.out.println("Added a relationship!!"); // <-- remove this when implementing add relation(Shane wuz here)
      }
    }

//      if (component instanceof UMLField && components.stream()
//        .anyMatch(c -> c.getName().equals(component.getClass()))) {
//        throw new IllegalArgumentException(
//          "Field with name " + component.getClass() + " already exists");
//      }
//      components.add((UMLComponent) component);
     else {
//      throw new IllegalArgumentException(
//        "Only fields, methods, or relationships can be added to a class.");
      System.out.println("Only fields, methods, or relationships can be added to a class.");
    }
  }

  /**
   * @Override method from parent class UMLComponent
   * Takes an object, ensures it is a proper UMLComponent that is NOT a UMLClass,
   * then removes the existing component from the UMLClass.
   * If the object is NOT a component, it informs the user that this action is not allowed.
   * <p>
   * It first checks if the object being passed is NOT empty.
   * Then it checks that it is in fact a UMLComponent and NOT a UMLClass.
   * It will then check only 2 cases wherein the object is either a field or a method.
   * If it is neither of these two things, it is therefor a relationship.
   * Finally, it will remove the existing component, if it exists, from one of the 3 UMLClass arrayLists.
   * <p>
   * @param component references UMLComponent Obj to be removed from the UMLClass.
   * **/
  /* TODO: implement Abstract remove method fully. Need to determine best way of doing this.
      Suggested fix; override Object's compareTo function. Wherein all the UMLComponents just compare by their Name.
        In short, overwrite compareTo in UMLComponent and just use that super function*/
  @Override
  public void remove(Object component) {
//    if (component instanceof UMLComponent && !(component instanceof UMLClass)) {
////      components.remove(component); <-- Shane wuz here
//      if (component instanceof UMLField){
//        if (this.fields.size() > 0 && this.fields.indexOf(component) >= 0) this.fields.remove(component);
//      }else if(component instanceof UMLMethod){
//
//      }else {
//
//      }
//    } else {
////      throw new IllegalArgumentException(
////        "Only fields, methods, or relationships can be removed from a class.");<-- Shane wuz here
//      System.out.println("Only fields, methods, or relationships can be removed from a class.");
//    }
  }

  //TODO: Rewrite this method once relations has been properly implemented.
//  @Override
//  public UMLComponent getChild(String name) {
//    return components.stream()
//      .filter(c -> c.getName().equals(name))
//      .findFirst()
//      .orElse(null);
//  }

  public List<UMLComponent> getComponents() {
    //return this.components; <--Shane wuz here(Best practice to use 'this' keyword)
    return null;
  }

  // Save UMLClass to JSON
  public void saveToFile(String filePath) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    try (FileWriter writer = new FileWriter(filePath)) {
      gson.toJson(this, writer);
      System.out.println("UMLClass saved to " + filePath);
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Failed to save UMLClass to " + filePath);
    }
  }

  // Load UMLClass from JSON
  public static UMLClass loadFromFile(String filePath) {
    Gson gson = new Gson();
    try (FileReader reader = new FileReader(filePath)) {
      UMLClass umlClass = gson.fromJson(reader, UMLClass.class);
      System.out.println("UMLClass loaded from " + filePath);
      return umlClass;
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Failed to load UMLClass from " + filePath);
      return null;
    }
  }

  @Override
  public String toString() {
    return "UMLClass{" +
            "fields=" + fields +
            ", methods=" + methods +
            ", relations=" + relations +
            ", name='" + name + '\'' +
            '}';
  }
}
