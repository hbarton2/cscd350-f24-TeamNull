package proj.TeamNull.UMLdevkit;


import java.util.ArrayList;

/**
 * Storage class contains the array list of ALL the class objects the user has created using
 * the program
 * <p>
 * The array list 'classes' is public and should be able to be accessed anywhere,
 * if you need to use the storage object then you can use the getInstance() method
 */

public class Storage {
  private static Storage instance;
  public ArrayList<UMLClass> classes; //arraylist containing all the created classes

  //Private constructor should never be called outside of getInstance()
  private Storage(){
    classes = new ArrayList<>();
  }

  //method used outside of this class to get instance of storage object
  public static synchronized Storage getInstance() {
    if (instance == null) {
      instance = new Storage();
    }
    return instance;
  }
}
