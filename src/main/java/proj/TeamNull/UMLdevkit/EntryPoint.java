package proj.TeamNull.UMLdevkit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EntryPoint extends Application {

  @Override
  public void start(Stage stage) throws IOException {

    FXMLLoader fxmlLoader = new FXMLLoader(EntryPoint.class.getResource("HomeScene.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 320, 240);

    stage.setTitle("UML Development Kit");
    stage.setScene(scene);
    stage.show();
  }

  // add if statement for GUI or Command-line Interface
  public static void main(String[] args) {

    Thread javafxThread = new Thread(() -> Application.launch(EntryPoint.class, args));
    javafxThread.setDaemon(true);
    javafxThread.start();

    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("Enter a command: ");
      String command = scanner.nextLine();

      if (command.equalsIgnoreCase("exit")) {
        System.out.println("Exiting...");
        break;
      }

      if (command.equalsIgnoreCase("create class")) {
        createClassTemplate(scanner);
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
}
