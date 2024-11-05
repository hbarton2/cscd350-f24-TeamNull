package umleditor.sprint1.uml;

import java.util.ArrayList;
import java.util.List;

public class UMLClass {

  private String className;
  private final List<UMLAttribute> attributes;
  private final List<MethodSignature> methods;  // Store methods with parameters
  private final List<UMLRelationship> relationships;

  // Constructor with class name
  public UMLClass(String className) {
    this.className = className;
    this.attributes = new ArrayList<>();  // Initialize blank attributes list
    this.methods = new ArrayList<>();     // Initialize blank methods list
    this.relationships = new ArrayList<>();  // Initialize relationships list
  }

  // Getter and Setter for Attributes
  public List<UMLAttribute> getAttributes() {
    return this.attributes;
  }

  public void addAttribute(String attributeName, String attributeType) {
    if (!attributeExists(attributeName)) {
      this.attributes.add(new UMLAttribute(attributeName, attributeType));
      System.out.println("Field " + attributeName + " added to class " + className + ".");
    } else {
      System.out.println(
        "Error: Field " + attributeName + " already exists in class " + className + ".");
    }
  }

  public void removeAttribute(String attributeName) {
    if (attributeExists(attributeName)) {
      this.attributes.remove(findAttribute(attributeName));
      System.out.println("Field " + attributeName + " removed from class " + className + ".");
    } else {
      System.out.println(
        "Error: Field " + attributeName + " does not exist in class " + className + ".");
    }
  }

  public boolean attributeExists(String attributeName) {
    for (UMLAttribute attribute : attributes) {
      if (attribute.getName().equals(attributeName)) {
        return true;  // Method with the same name and parameter exists
      }
    }
    return false;  // No duplicate found
  }

  // Helper method to find a method by name and parameter
  public UMLAttribute findAttribute(String attributeName) {
    for (UMLAttribute attribute : attributes) {
      if (attribute.getName().equals(attributeName)) {
        return attribute;
      }
    }
    return null;
  }

  // Getter and Setter for Methods
  public List<MethodSignature> getMethods() {
    return this.methods;
  }

  public void addMethod(String methodName, String methodType) {
    MethodSignature newMethod = new MethodSignature(methodName, methodType);
    if (methodExists(methodName)) {
      System.out.println("Error: Method '" + methodName + " already exists in class " + className + ".");
      return;
    }
    methods.add(newMethod);
    System.out.println(
      "Method " + methodName + " added to class " + className
        + ".");
  }

  public void removeMethod(String methodName) {
    MethodSignature methodToRemove = null;
    for (MethodSignature method : methods) {
      if (method.methodName.equals(methodName)) {
        methodToRemove = method;
        break;
      }
    }

    if (methodToRemove != null) {
      methods.remove(methodToRemove);
      System.out.println(
        "Method '" + methodName + " removed from class "
          + className + ".");
    } else {
      System.out.println("Error: Method '" + methodName + "' does not exist in class " + className + ".");
    }
  }

  // Method to check if a method with a specific name and parameter already exists
  public boolean methodExists(String methodName) {
    for (MethodSignature method : methods) {
      if (method.methodName.equals(methodName)) {
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

  // Debugging helper method to display all methods in the class
  public void displayMethods() {
    System.out.println("Methods in class " + className + ":");
    for (MethodSignature method : methods) {
      System.out.println("- " + method);
    }
  }

  public void displayAttributes(){
    System.out.println("Attributes in class " + className + ":");
    for (UMLAttribute attribute : attributes) {
      System.out.println("- " + attribute);
    }
  }

  // Method to rename an attribute
  public void renameAttribute(String oldName, String newName) {
    if (attributeExists(oldName)) {
      findAttribute(oldName).setName(newName);
      System.out.println(
        "Field renamed from " + oldName + " to " + newName + " in class " + className
          + ".");
    } else {
      System.out.println(
        "Error: Field " + oldName + " does not exist in class " + className + ".");
    }
  }

  // Method to rename a method
  public void renameMethod(String oldMethodName, String newMethodName) {
    MethodSignature oldMethod = findMethod(oldMethodName);
    if (oldMethod != null) {
      oldMethod.methodName = newMethodName;
      System.out.println(
        "Method renamed from " + oldMethodName + " to " + newMethodName + " in class " + className
          + ".");
    } else {
      System.out.println(
        "Error: Method " + oldMethodName + " does not exist in class " + className + ".");
    }
  }

  // Helper method to find a method by name and parameter
  public MethodSignature findMethod(String methodName) {
    for (MethodSignature method : methods) {
      if (method.methodName.equals(methodName)) {
        return method;
      }
    }
    return null;
  }
}