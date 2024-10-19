package proj.TeamNull.UMLdevkit.utilities;

import java.util.ArrayList;
import java.util.Scanner;
import org.graalvm.collections.EconomicMapUtil;

/**
 * This class deal with all user input and then seek command class for help
 */
public class Parser {
  private ArrayList<String> phrases;
  private String commands;

  public Parser() {}

  public ArrayList<String> getPhrases() {
    return phrases;
  }
  // read methods
  public void setPhrases(String input) {
    phrases.add(input); // change this later because ArrayList
  }

  /**
   * read user input command for parsing
   * takes input, and stores to phrases list
   *
   * TODO FIX ERROR
   */
  public void readInput() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter the phrase you wish to add: ");
    String newPhrase = scanner.nextLine();
    setPhrases(newPhrase);
    scanner.close();
  }

}
