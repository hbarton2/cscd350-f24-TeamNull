package proj.TeamNull.UMLdevkit;

import java.util.ArrayList;
import java.util.List;

public class UmlDiagram {
  // List to store UML classes
  private List<UmlClass> classes = new ArrayList<>();

  // Getter method
  public List<UmlClass> getClasses() {
    return classes;
  }

  // Setter method
  public void setClasses(List<UmlClass> classes) {
    this.classes = classes;
  }
}
