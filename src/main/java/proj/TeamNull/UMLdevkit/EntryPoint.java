package proj.TeamNull.UMLdevkit;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.stage.Stage;

public class EntryPoint{

//  @Override
//  public void start(Stage stage) throws IOException {
//
//    FXMLLoader fxmlLoader = new FXMLLoader(EntryPoint.class.getResource("HomeScene.fxml"));
//    Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//
//    stage.setTitle("UML Development Kit");
//    stage.setScene(scene);
//    stage.show();
//  }

  //The GSon obj that will serialize and deserialize objects and JSon files.
  private static Gson save_load = new Gson();
  private static UmlDiagram classes = new UmlDiagram();

  // add if statement for GUI or Command-line Interface
  public static void main(String[] args) throws Exception {


//    Thread javafxThread = new Thread(() -> Application.launch(EntryPoint.class, args));
//    javafxThread.setDaemon(true);
//    javafxThread.start();

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
        System.out.println(classes);
      }else if (command.equalsIgnoreCase("load")) {
        System.out.println("Please enter the name of the file: ");
        load(scanner);
        System.out.println(classes);
      } else {
        System.out.println("Unknown command.");
      }
    }
    scanner.close();
    System.exit(0);
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

  //Saves the UML diagram to a JSon format using the GSon library
  public static void save(Scanner scanner) throws Exception {
      try {
        String fileName = scanner.nextLine();
        save_load.toJson(classes, new FileWriter(fileName));
      }catch (Exception e){
        throw e;
      }
  }

  //Loads the UML diagram to a JSon format using the GSon library
  public static void load(Scanner scanner) throws Exception{
    classes = new UmlDiagram();
    try {
      String fileName = scanner.nextLine();
      classes = save_load.fromJson(fileName, UmlDiagram.class);
    }catch (Exception e){
      throw e;
    }
  }
}
