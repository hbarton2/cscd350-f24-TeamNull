package proj.TeamNull.UMLdevkit.uml;

import java.util.ArrayList;
import java.util.List;

public class UMLClass {

  private String className;
  private List<String> attributes;
  private List<String> methods;
  private List<String> relationships;

  // Constructor with class name
  public UMLClass(String className) {
    this.className = className;
    this.attributes = new ArrayList<>();  // Initialize blank
    this.methods = new ArrayList<>();     // Initialize blank
    this.relationships = new ArrayList<>();  // Initialize blank
  }

  // Getter and Setter for Attributes
  public void setAttributes(List<String> attributes) {
    this.attributes = attributes;
  }

  public List<String> getAttributes() {
    return this.attributes;
  }

  public void addAttribute(String attribute) {
    this.attributes.add(attribute);
  }

  // Getter and Setter for Methods
  public void setMethods(List<String> methods) {
    this.methods = methods;
  }

  public List<String> getMethods() {
    return this.methods;
  }

  public void addMethod(String method) {
    this.methods.add(method);
  }

  // Getter and Setter for Relationships
  public void setRelationships(List<String> relationships) {
    this.relationships = relationships;
  }

  public List<String> getRelationships() {
    return this.relationships;
  }

  public void addRelationship(String relationship) {
    this.relationships.add(relationship);
  }

  // Get Class Name
  public String getClassName() {
    return className;
  }

  // Set Class Name
  public void setClassName(String className) {
    this.className = className;
  }

  // Method to rename the class
  public void renameClass(String newName) {
    this.className = newName;
  }
}
