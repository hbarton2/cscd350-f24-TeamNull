package proj.TeamNull.UMLdevkit.uml;

import java.util.ArrayList;
import java.util.List;

public class UMLClass {

  private String className;
  private List<String> attributes;
  private List<MethodSignature> methods;  // Store methods with parameters
  private List<UMLRelationship> relationships;

  // Constructor with class name
  public UMLClass(String className) {
    this.className = className;
    this.attributes = new ArrayList<>();  // Initialize blank attributes list
    this.methods = new ArrayList<>();     // Initialize blank methods list
    this.relationships = new ArrayList<>();  // Initialize relationships list
  }

  // Getter and Setter for Attributes
  public List<String> getAttributes() {
    return this.attributes;
  }

  public void addAttribute(String attribute) {
    if (!this.attributes.contains(attribute)) {
      this.attributes.add(attribute);
      System.out.println("Attribute " + attribute + " added to class " + className + ".");
    } else {
      System.out.println(
        "Error: Attribute " + attribute + " already exists in class " + className + ".");
    }
  }

  public void removeAttribute(String attribute) {
    if (this.attributes.contains(attribute)) {
      this.attributes.remove(attribute);
      System.out.println("Attribute " + attribute + " removed from class " + className + ".");
    } else {
      System.out.println(
        "Error: Attribute " + attribute + " does not exist in class " + className + ".");
    }
  }

  // Getter and Setter for Methods
  public List<MethodSignature> getMethods() {
    return this.methods;
  }

  public void addMethod(String methodName, String parameter) {
    MethodSignature newMethod = new MethodSignature(methodName, parameter);
    if (methodExists(methodName, parameter)) {
      System.out.println("Error: Method '" + methodName + "' with parameter '" + parameter
        + "' already exists in class " + className + ".");
      return;
    }
    methods.add(newMethod);
    System.out.println(
      "Method " + methodName + " with parameter '" + parameter + "' added to class " + className
        + ".");
  }

  public void removeMethod(String methodName, String parameter) {
    MethodSignature methodToRemove = null;
    for (MethodSignature method : methods) {
      if (method.methodName.equals(methodName) && method.parameter.equals(parameter)) {
        methodToRemove = method;
        break;
      }
    }

    if (methodToRemove != null) {
      methods.remove(methodToRemove);
      System.out.println(
        "Method '" + methodName + "' with parameter '" + parameter + "' removed from class "
          + className + ".");
    } else {
      System.out.println("Error: Method '" + methodName + "' with parameter '" + parameter
        + "' does not exist in class " + className + ".");
    }
  }

  // Method to check if a method with a specific name and parameter already exists
  public boolean methodExists(String methodName, String parameter) {
    for (MethodSignature method : methods) {
      if (method.methodName.equals(methodName) && method.parameter.equals(parameter)) {
        return true;  // Method with the same name and parameter exists
      }
    }
    return false;  // No duplicate found
  }

  // Getter and Setter for Relationships
  public List<UMLRelationship> getRelationships() {
    return this.relationships;
  }

  public void addOrUpdateRelationship(UMLRelationshipType type) {
    if (this.relationships.isEmpty()) {
      System.out.println("Adding relationship " + type + " to class " + className + ".");
    } else {
      System.out.println("Updating relationship in class " + className + " to " + type + ".");
    }
    this.relationships.add(new UMLRelationship(type));
  }

  public void removeRelationship() {
    if (!this.relationships.isEmpty()) {
      this.relationships.clear();
      System.out.println("Removed all relationships from class " + className + ".");
    } else {
      System.out.println("Error: No relationship exists in class " + className + " to remove.");
    }
  }

  // Get Class Name
  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

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

  // Method to rename an attribute
  public void renameAttribute(String oldAttribute, String newAttribute) {
    if (attributes.contains(oldAttribute)) {
      int index = attributes.indexOf(oldAttribute);
      attributes.set(index, newAttribute);
      System.out.println("Attribute renamed from " + oldAttribute + " to " + newAttribute + " in class " + className + ".");
    } else {
      System.out.println("Error: Attribute " + oldAttribute + " does not exist in class " + className + ".");
    }
  }

  // Method to rename a method
  public void renameMethod(String oldMethodName, String newMethodName, String parameter) {
    MethodSignature oldMethod = findMethod(oldMethodName, parameter);
    if (oldMethod != null) {
      oldMethod.methodName = newMethodName;
      System.out.println("Method renamed from " + oldMethodName + " to " + newMethodName + " in class " + className + ".");
    } else {
      System.out.println("Error: Method " + oldMethodName + " does not exist in class " + className + ".");
    }
  }

  // Helper method to find a method by name and parameter
  private MethodSignature findMethod(String methodName, String parameter) {
    for (MethodSignature method : methods) {
      if (method.methodName.equals(methodName) && method.parameter.equals(parameter)) {
        return method;
      }
    }
    return null;
  }
//  private static class MethodSignature {
//
//    String methodName;
//    String parameter;
//
//    public MethodSignature(String methodName, String parameter) {
//      this.methodName = methodName;
//      this.parameter = parameter != null ? parameter : ""; // Default to empty string if null
//    }
//
//    @Override
//    public String toString() {
//      return methodName + "(" + (parameter.isEmpty() ? "no parameters" : parameter) + ")";
//    }
//  }
}
