package proj.TeamNull.UMLdevkit.uml;

import java.util.ArrayList;
import java.util.List;

public class UMLClass {

  private String className;
  private List<String> attributes;
  private List<MethodSignature> methods;  // Store methods with parameters
  private List<String> relationships;

  // Constructor with class name
  public UMLClass(String className) {
    this.className = className;
    this.attributes = new ArrayList<>();  // Initialize blank attributes list
    this.methods = new ArrayList<>();     // Initialize blank methods list
    this.relationships = new ArrayList<>();  // Initialize blank relationships list
  }

  // Getter and Setter for Attributes
  public void setAttributes(List<String> attributes) {
    this.attributes = attributes;
  }

  public List<String> getAttributes() {
    return this.attributes;
  }

  // Check for duplicates when adding an attribute
  public void addAttribute(String attribute) {
    if (!this.attributes.contains(attribute)) {
      this.attributes.add(attribute);
      System.out.println("Attribute " + attribute + " added to class " + className + ".");
    } else {
      System.out.println(
        "Error: Attribute " + attribute + " already exists in class " + className + ".");
    }
  }

  // Getter and Setter for Methods
  public void setMethods(List<MethodSignature> methods) {
    this.methods = methods;
  }

  public List<MethodSignature> getMethods() {
    return this.methods;
  }

  // Add method with duplicate check for overloads
  public void addMethod(String methodName, String parameter) {
    MethodSignature newMethod = new MethodSignature(methodName, parameter);

    // Check for duplicates (same name and no parameters)
    for (MethodSignature method : methods) {
      if (method.methodName.equals(methodName) && method.parameter.equals("") && parameter.equals(
        "")) {
        System.out.println(
          "Error: Method '" + methodName + "' with no parameters already exists in class "
            + className + ".");
        return;
      }
    }

    // If no conflict, add the method
    methods.add(newMethod);
    System.out.println(
      "Method " + methodName + " with parameter '" + parameter + "' added to class " + className
        + ".");
  }

  // Method to check if a method exists (with the same name and parameters)
  public boolean methodExists(String methodName, String parameter) {
    for (MethodSignature method : methods) {
      if (method.methodName.equals(methodName) && method.parameter.equals(parameter)) {
        return true;  // Method with the same name and parameter exists
      }
    }
    return false;  // No duplicate found
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

  // Internal class to represent a method signature with name and parameters
  private static class MethodSignature {

    String methodName;
    String parameter;

    public MethodSignature(String methodName, String parameter) {
      this.methodName = methodName;
      this.parameter = parameter != null ? parameter : ""; // Default to empty string if null
    }

    @Override
    public String toString() {
      return methodName + "(" + (parameter.isEmpty() ? "no parameters" : parameter) + ")";
    }
  }

  // Debugging helper method to display all methods in the class
  public void displayMethods() {
    System.out.println("Methods in class " + className + ":");
    for (MethodSignature method : methods) {
      System.out.println("- " + method);
    }
  }
}
