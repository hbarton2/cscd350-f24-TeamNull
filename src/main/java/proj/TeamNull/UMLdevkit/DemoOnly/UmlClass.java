package proj.TeamNull.UMLdevkit.DemoOnly;

import java.util.ArrayList;
import java.util.List;

public class UmlClass {

  private String name;
  private List<String> attributes;
  private List<String> methods;

  // Constructor
  public UmlClass() {
    this.attributes = new ArrayList<>();
    this.methods = new ArrayList<>();
  }

  public UmlClass(String name, List<String> attributes, List<String> methods) {
    this.name = name;
    this.attributes = attributes;
    this.methods = methods;
  }

  // Getter and Setter for name
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // Getter for attributes
  public List<String> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<String> attributes) {
    this.attributes = attributes;
  }

  // Getter for methods
  public List<String> getMethods() {
    return methods;
  }

  public void setMethods(List<String> methods) {
    this.methods = methods;
  }
}
