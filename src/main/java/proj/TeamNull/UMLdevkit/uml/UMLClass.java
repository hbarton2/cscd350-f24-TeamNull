package proj.TeamNull.UMLdevkit.uml;

import java.util.ArrayList;
import java.util.List;

public class UMLClass {

  private String className;
  private List<String> attributes;
  private List<String> methods;
  private List<String> relationships;

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

  // Getter and Setter for Methods
  public void setMethods(List<String> methods) {
    this.methods = methods;
  }

  public List<String> getMethods() {
    return this.methods;
  }

  // Getter and Setter for Relationships
  public void setRelationships(List<String> relationships) {
    this.relationships = relationships;
  }

  public List<String> getRelationships() {
    return this.relationships;
  }

  // Get Class Name
  public String getClassName() {
    return className;
  }
}
