package proj.TeamNull.UMLdevkit.utilities;

import java.util.HashMap;
import proj.TeamNull.UMLdevkit.uml.UMLClass;

/**
 * Storage class contains the array list of ALL the class objects the user has created using the
 * program
 * <p>
 * The array list 'classes' is public and should be able to be accessed anywhere, if you need to use
 * the storage object then you can use the getInstance() method
 */

public class Storage {

  private static HashMap<String, UMLClass> umlClasses = new HashMap<>();

  public static HashMap<String, UMLClass> getUMLClasses() {
    return umlClasses;
  }

  public static void addClass(String className, UMLClass umlClass) {
    umlClasses.put(className, umlClass);
  }

  public static void removeClass(String className) {
    umlClasses.remove(className);
  }

  public static boolean classExists(String className) {
    return umlClasses.containsKey(className);
  }
}