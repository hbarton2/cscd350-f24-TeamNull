package proj.TeamNull.UMLdevkit;

import java.util.ArrayList;
import java.util.List;

public class UmlDiagram {

  // List to store UML classes
  private List<UmlClass> classes = new ArrayList<>();

  // Getter method
  public List<UmlClass> getClasses() {
    return this.classes;
  }

  // Setter method
  public void setClasses(List<UmlClass> classes) {
    this.classes = classes;
  }

  //adds a class to the classes in the diagram
  public void addClass(UmlClass myClass){
    this.classes.add(myClass);
  }

  // This method returns an array list of an array list of strings in order for GSon to properly parse and access the data.
  public ArrayList<ArrayList<String[]>> toSon(){

      // Our ArrayList obj that mimics the structure of the UmlDiagram class.
    ArrayList diagram = new ArrayList<ArrayList<String[]>>();

    // for each loop that accesses the data in each class and appends the String[] ArrayList to 'diagram'.
    for (UmlClass c:
         this.classes) {

        //instantiating all String[]
        String[] name;
        String[] attribs;
        String[] methods;

        // uses functions I built in UmlClass to return data of the class.
        name = c.toSonName();
        attribs = c.toSonAtrribs();
        methods = c.toSonMethods();

        //creates the ArrayList of String[]'s and adds the data we just grabbed to it.
        ArrayList myClass = new ArrayList<String[]>();
        myClass.add(name);
        myClass.add(attribs);
        myClass.add(methods);

        diagram.add(myClass);

//      diagram[i][0] = c.toSonName();
//      diagram[i][1] = c.toSonAtrribs();        commented out bc it didn't work and cause invalid type when trying
//      diagram[i][2] = c.toSonMethods();           put them into a 2d Object[].

    }
    //returns the diagram ArrayList we just created.
    return diagram;
  }
}
