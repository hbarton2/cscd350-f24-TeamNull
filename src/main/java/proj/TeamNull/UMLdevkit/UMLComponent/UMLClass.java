package proj.TeamNull.UMLdevkit.UMLComponent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * UMLClass extends UMLComponent. Represents class in UML Editor. Will manage other components like
 * Fields and Methods.
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
