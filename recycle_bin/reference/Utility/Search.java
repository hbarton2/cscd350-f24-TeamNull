package proj.TeamNull.UMLdevkit.reference.Utility;

public class Search {

  // Linear search for class name
  // Used linear search because names may not be sorted.
  public static void searchClassName(String[] array, String key) {
    if (array == null || array.length == 0) {
      System.out.println("There is nothing in the list");
      return;
    }
    boolean found = false;  // Track if the key is found
    for (int i = 0; i < array.length; i++) {

      if (array[i].equals(key)) {
        System.out.println("Found: " + array[i] + " at index " + i);
        found = true;
        break;  // Exit after finding the first match
      }
    }
    if (!found) {
      System.out.println("Class name not found.");
    }

  }//End of method
}