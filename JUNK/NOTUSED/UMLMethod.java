package proj.TeamNull.UMLdevkit.NOTUSED;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * UML Method represents a method within a class object contains fields name and list of
 * UMLParameter objects
 */


public class UMLMethod {

  private String name;
  private ArrayList<UMLParameter> parameters;
  private final Scanner sc = new Scanner(System.in);

  /**
   * must give the name of the new method, will call createParameter() which will prompt user for
   * parameter information.
   *
   * @param name
   */
  public UMLMethod(String name) {
    this.name = name;
    this.parameters = new ArrayList<>();
    createParameter();
    displayParameters();
  }

  /**
   * UML Parameter, private class only can be accessed by the method that it is a part of
   * <p>
   * TODO: Update createParameter function to prompt user for parameter info immediately when creating a method
   */
  private class UMLParameter {

    private String name;
    private String type;

    private UMLParameter(String name, String type) {
      this.name = name;
      this.type = type;
    }

    public String getName() {
      return this.name;
    }

    public String getInfo() {
      return "Name: " + this.name + " Type: " + this.type;
    }

    private void setNewName(String newName) {
      this.name = newName;
    }

    private void setNewType(String newType) {
      this.type = newType;
    }

  }

  /**
   * creates parameter object and adds it into this methods parameter list takes user input for name
   * and type checks if name or type are empty checks if parameter name already exists in list if
   * none of these are true then it adds
   */
  public void createParameter() {
    while (true) {
      System.out.print("Enter parameter name and type: (type 'done' to exit)");
      String input = sc.nextLine().trim();

      if (input.equals("done")) {
        break;
      }

      String[] parts = input.split("\\s+");
      if (parts.length != 2) {
        System.out.println("Invalid parameter");
        return;
      }

      if (parts[0].isEmpty() || parts[1].isEmpty()) {
        System.out.println("Parameter cannot be empty");
      }
      UMLParameter existingParam = findParameter(parts[0]);
      if (existingParam != null && existingParam.getName() != null) {
        System.out.println(
          "Parameter " + parts[0] + " already exists. Please enter a different name.");

      } else {
        UMLParameter param = new UMLParameter(parts[0].trim(), parts[1].trim());
        this.parameters.add(param);
        System.out.println("Added parameter " + param.name + " with type " + param.type);
      }
    }
  }

  public void removeParameter(String name) {

    if (this.parameters.isEmpty()) {
      System.out.println("This method has no parameters");
    } else if (findParameter(name) == null) {
      System.out.println("Parameter " + name + " not found");
    } else {
      this.parameters.remove(findParameter(name));
      System.out.println("Removed parameter " + name + " with type " + findParameter(name).type);
    }
  }

  public String getName() {
    return this.name;
  }

  public void changeName(String newName) {
    this.name = newName;
  }

  /**
   * Uses scanner to take in user input on its own, first asks for original parameter then finds it
   * in the parameter list. Then prompts for new name and type then changes it.
   */
  public void changeParameter() {
    String oldName;
    System.out.print("Enter original parameter name: ");
    oldName = sc.nextLine().trim();
    System.out.print("Enter New parameter name and type: ");
    String input = sc.nextLine().trim();
    String[] parts = input.split("\\s+");
    if (parts.length != 2) {
      System.out.println("Invalid parameter");
      return;
    }

    UMLParameter param = findParameter(oldName);

    param.setNewName(parts[0].trim());
    param.setNewType(parts[1].trim());
    System.out.print("Parameter changed to:\n" + param.getInfo());
  }

  //Displays all parameters in this method
  public void displayParameters() {
    if (parameters.isEmpty()) {
      System.out.println("No parameters available.");
    } else {
      System.out.println("Parameters in " + this.name + ":");
      for (UMLParameter param : parameters) {
        System.out.println("- " + param.getInfo());
      }
    }
  }

  //returns parameter with given name, in this method object
  public UMLParameter findParameter(String name) {
    for (UMLParameter param : parameters) {
      if (param.getName().equalsIgnoreCase(name)) {
        return param;
      }
    }
    return null;
  }
}