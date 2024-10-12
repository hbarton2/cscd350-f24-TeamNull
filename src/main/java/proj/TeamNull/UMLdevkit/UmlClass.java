package proj.TeamNull.UMLdevkit;

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
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // Getter for attributes
  public List<String> getAttributes() {
    return this.attributes;
  }

  public void setAttributes(List<String> attributes) {
    this.attributes = attributes;
  }

  // Getter for methods
  public List<String> getMethods() {
    return this.methods;
  }

  public void setMethods(List<String> methods) {
    this.methods = methods;
  }

  //Creates String[] from this.attributes.
  public String[] toSonAtrribs(){
    String[] attribs = new String[this.attributes.size()];

    //for each loop that takes each attribute string and puts it into a String[] to be returned.
    int i = 0;
    for (String s:
            this.attributes) {
      attribs[i] = s;
      i++;
    }

    //returns the string array.
    return attribs;
  }

  //Creates and returns a String[] generated from method Strings.
  public String[] toSonMethods(){
    String[] methods = new String[this.methods.size()];

    //for each loop that fills out the method String[] array.
    int i = 0;
    for (String s:
            this.methods) {
      methods[i] = s;
      i++;
    }
    //returns String[] methods.
    return methods;
  }

  //returns String[] array of the class name.
  public String[] toSonName(){
    String[] name = {this.name};
    //Although it seems unnecessary, it needs to be this way in order to adhere to the toSon() format in UmlDiagram.
    return name;
  }
}
