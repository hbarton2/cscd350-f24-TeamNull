package proj.TeamNull.UMLdevkit;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class EntryPoint{


  //The GSon obj that will serialize and deserialize objects and JSon files.
  private static Gson save_load = new Gson();

  // The json String will be used to capture the output of Gson save_load.
  // It captures both the save and load states.
  private static String json;
  private static UmlDiagram classes = new UmlDiagram();

  // add if statement for GUI or Command-line Interface
  public static void main(String[] args) throws Exception {


    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("Enter a command: ");
      String command = scanner.nextLine();

      if (command.equalsIgnoreCase("exit")) {
        System.out.println("Exiting...");
        break;
      }else if (command.equalsIgnoreCase("create class")) {
        createClassTemplate(scanner);
      } else if (command.equalsIgnoreCase("save")) {
        System.out.println("Please enter a valid file name: ");
        save(scanner);
        //System.out.println(classes);
      }else if (command.equalsIgnoreCase("load")) {
        System.out.println("Please enter the name of the file: ");
        load(scanner);
        //System.out.println(classes);
      } else {
        System.out.println("Unknown command.");
      }
    }
    scanner.close();
  }

  public static void createClassTemplate(Scanner scanner) {
    // Input for class name
    System.out.print("Enter class name: ");
    String className = scanner.nextLine();

    // Input for attributes
    List<String> attributes = new ArrayList<>();
    System.out.println("Enter attributes (type 'done' when finished): ");
    while (true) {
      System.out.print("Attribute (format: name: Type): ");
      String attribute = scanner.nextLine();
      if (attribute.equalsIgnoreCase("done")) {
        break;
      }
      attributes.add(attribute);
    }

    // Input for methods
    List<String> methods = new ArrayList<>();
    System.out.println("Enter methods (type 'done' when finished): ");
    while (true) {
      System.out.print("Method (format: name(): ReturnType): ");
      String method = scanner.nextLine();
      if (method.equalsIgnoreCase("done")) {
        break;
      }
      methods.add(method);
    }

    //Append the list of classes in UmlDiagram 'classes'
    UmlClass myClass = new UmlClass(className, attributes, methods);
    classes.addClass(myClass);

    // Display the UML class template
    displayClassTemplate(className, attributes, methods);
  }

  public static void displayClassTemplate(String className, List<String> attributes,
    List<String> methods) {
    System.out.println("\n+-----------------------+");
    System.out.printf("|       %-15s      |\n", className);
    System.out.println("+-----------------------+");

    if (!attributes.isEmpty()) {
      for (String attribute : attributes) {
        System.out.printf("| - %-19s |\n", attribute);
      }
    } else {
      System.out.println("|  No attributes         |");
    }

    System.out.println("+-----------------------+");

    if (!methods.isEmpty()) {
      for (String method : methods) {
        System.out.printf("| + %-19s |\n", method);
      }
    } else {
      System.out.println("|  No methods            |");
    }

    System.out.println("+-----------------------+");
  }

  //Saves the UML diagram to a JSon format using the GSon library.
  public static void save(Scanner scanner) throws Exception {
      try {
        // Creates a new Gson instance for save_load.
        save_load = new Gson();
        String fileName = scanner.nextLine() + ".json";  // captures the file-nae to save to.
        FileWriter fOut = new FileWriter(fileName); // creates an output writer based off of fileName.
        ArrayList<ArrayList<String[]>> toSon = classes.toSon(); //prepares data in UmlDiagram for output.
        json = save_load.toJson(toSon); //generates the json formatted String for output.

        fOut.write(json); // writes the String to the file.
        fOut.flush(); //flushes output.
        fOut.close(); // closes the file.
      }catch (Exception e){ // error handling.
        throw e;
      }
  }

  //Loads the UML diagram from a JSon format using the GSon library.
  public static void load(Scanner scanner) throws Exception{
    classes = new UmlDiagram(); // clears the current data in UmlDiagram.
    try {
      save_load = new Gson(); // creates a new Gson instance for save_load.
      String fileName = scanner.nextLine() + ".json"; // gets the fileName from the user.
      FileReader fIn = new FileReader(fileName);// Creates a object to read in the data from the file.
      ArrayList<ArrayList<String[]>> fromJson = save_load.fromJson(fIn, ArrayList.class); // grabs the exact structure in the Json and loads it in.
      UmlDiagram diagram = new UmlDiagram(); //creates a temporary diagram place-holder

      //loops through the whole ArrayList and grabs each ArrayList to be put into a new UmlClass.
      for (int i = 0; i <= fromJson.size() - 1; i++){
        ArrayList myClass = fromJson.get(i); // grabs the 'class' (ArrayList<String[]>)
        ArrayList name = (ArrayList) myClass.get(0); //This looks weird, bc it is. In order to grab the actual data, we need to put it into arrayList 1rst.
        String addName = (String) name.get(0); // gets the name of the 'class'
        ArrayList attribs = (ArrayList) myClass.get(1);//Class constructor takes an arrayList, so we can just grab this tuple.
        ArrayList methods = (ArrayList) myClass.get(2);// Same comment as line above this one.
        UmlClass myUml = new UmlClass(addName, attribs, methods);//finally generates the 'new' UmlClass.
        diagram.addClass(myUml); // appends diagram ArrayList with the new class.
      }
      classes = diagram;// sets the static UmlDiagram to be the newly loaded in one.
      fIn.close();//closes the file.

    }catch (Exception e){//error handling.
      throw e;
    }
  }
}
