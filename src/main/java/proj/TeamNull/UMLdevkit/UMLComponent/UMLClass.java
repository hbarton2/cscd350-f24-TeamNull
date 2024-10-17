package proj.TeamNull.UMLdevkit.UMLComponent;

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
 * TODO Break up components list into seperate lists for Fields, Methods, Relationships.
 * <p>
 * TODO We have no way of creating UMLField, UMLMethod, UMLRelationship objects within this class,
 *  implement method that will use user input to create these objects then call add()
 */
public class UMLClass extends UMLComponent {

  private List<UMLComponent> components = new ArrayList<>();

  public UMLClass(String name, List<UMLComponent> components) {
    super(name);
    if (components != null) {
      this.components.addAll(components);
    }
  }

  @Override
  public void add(UMLComponent component) {
    if (component instanceof UMLField || component instanceof UMLMethod
      || component instanceof UMLRelationship) {
      if (component instanceof UMLField && components.stream()
        .anyMatch(c -> c.getName().equals(component.getName()))) {
        throw new IllegalArgumentException(
          "Field with name " + component.getName() + " already exists");
      }
      components.add(component);
    } else {
      throw new IllegalArgumentException(
        "Only fields, methods, or relationships can be added to a class.");
    }
  }

  @Override
  public void remove(UMLComponent component) {
    if (component instanceof UMLField || component instanceof UMLMethod
      || component instanceof UMLRelationship) {
      components.remove(component);
    } else {
      throw new IllegalArgumentException(
        "Only fields, methods, or relationships can be removed from a class.");
    }
  }

  @Override
  public UMLComponent getChild(String name) {
    return components.stream()
      .filter(c -> c.getName().equals(name))
      .findFirst()
      .orElse(null);
  }

  public List<UMLComponent> getComponents() {
    return components;
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
}
