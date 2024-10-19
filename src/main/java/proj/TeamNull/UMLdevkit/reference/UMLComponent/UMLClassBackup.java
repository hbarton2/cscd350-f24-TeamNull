package proj.TeamNull.UMLdevkit.reference.UMLComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * UMLClass extends UMLComponent. Represents class in UML Editor. Will manage other components like
 * Fields and Methods.
 */
public class UMLClassBackup extends UMLComponent {

  private List<UMLComponent> components = new ArrayList<>();

  public UMLClassBackup(String name, List<UMLComponent> components) {
    super(name);
      if (components != null) {
          this.components.addAll(components);
      }
  }

  @Override
  public void add(Object component) {
    if (component instanceof UMLField || component instanceof UMLMethod
      || component instanceof UMLRelationship) {
      if (component instanceof UMLField && components.stream()
        .anyMatch(c -> c.getName().equals(component.getClass()))) { //<-- Changed this bc it was throwing errors.
        throw new IllegalArgumentException(
          "Field with name " + component.getClass() + " already exists"); //<-- Auto generated fix, please ignore bc this is the backup class.
      }
      components.add((UMLComponent) component);
    } else {
      throw new IllegalArgumentException(
        "Only fields, methods, or relationships can be added to a class.");
    }
  }

  @Override
  public void remove(Object component) {
    if (component instanceof UMLField || component instanceof UMLMethod
      || component instanceof UMLRelationship) {
      components.remove(component);
    } else {
      throw new IllegalArgumentException(
        "Only fields, methods, or relationships can be removed from a class.");
    }
  }


//  @Override
  public UMLComponent getChild(String name) {
    return components.stream()
      .filter(c -> c.getName().equals(name))
      .findFirst()
      .orElse(null);
  }

  public List<UMLComponent> getComponents() {
    return components;
  }
}

