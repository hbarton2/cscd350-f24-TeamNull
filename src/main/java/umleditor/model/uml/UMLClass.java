package umleditor.model.uml;

import umleditor.model.utilities.Storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UMLClass {

  private String className;
  private List<UMLAttribute> attributes;
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
  private UMLAttribute findAttribute(String attributeName) {
    for (UMLAttribute attribute : this.attributes) {
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
    for (MethodSignature method : this.methods) {
      System.out.println("- " + method);
    }
  }

  public void displayAttributes(){
    System.out.println("Fields: ");
    for (UMLAttribute attribute : this.attributes) {
      System.out.println("- " + attribute);
    }
  }

  // Method to rename an attribute
  public void renameAttribute(String oldName, String newName) {
    UMLAttribute oldAttribute = findAttribute(oldName);

    if (oldAttribute != null) {
      oldAttribute.setName(newName);
      System.out.println(
        "Field renamed from " + oldName + " to " + newName + " in class " + this.className
          + ".");
    } else {
      System.out.println(
        "Error: Field " + oldName + " does not exist in class " + this.className + ".");
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

  // Methods for updating state
  public void setMethods(List<MethodSignature> methods) {
    this.methods = methods;
  }

  public void setAttributes(List<UMLAttribute> attributes) {
    this.attributes = attributes;
  }

  public void setRelationships(List<UMLRelationship> relationships) {
    this.relationships = relationships;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  // Memento for state management
  public Memento saveToMemento(boolean classExists) {
    if(classExists) {
      return new Memento(className, attributes, methods, relationships);
    }
    else
      return new Memento(className, new ArrayList<>(attributes), new ArrayList<>(methods), new ArrayList<>(relationships));
  }

  public void restoreFromMemento(Memento memento) {
    Storage storage = Storage.getInstance();
    if(storage.classExists(memento.className)) {
      setClassName(memento.getClassName());
      setAttributes(memento.getAttributes());
      this.methods = new ArrayList<>(memento.getMethods());
      this.relationships = new ArrayList<>(memento.getRelationships());
    }
    else
      System.out.println("Restore from memento failed. Still in development");
  }

  // Nested Memento class
  //TODO: Memento fields have the same address as the class attributes. CHANGE THIS
  public static class Memento {
    private final String className;
    private final List<UMLAttribute> attributes;
    private final List<MethodSignature> methods;
    private final List<UMLRelationship> relationships;

    private Memento(String className, List<UMLAttribute> attributes, List<MethodSignature> methods, List<UMLRelationship> relationships) {
      this.className = className;
      this.attributes = new ArrayList<>(attributes);  // Ensure immutability
      this.methods = new ArrayList<>(methods);
      this.relationships = new ArrayList<>(relationships);
    }

    // Getters to access state
    public String getClassName() {
      return className;
    }

    public List<UMLAttribute> getAttributes() {
      return Collections.unmodifiableList(this.attributes);
    }

    public List<MethodSignature> getMethods() {
      return Collections.unmodifiableList(this.methods);
    }

    public List<UMLRelationship> getRelationships() {
      return Collections.unmodifiableList(this.relationships);
    }
  }
}