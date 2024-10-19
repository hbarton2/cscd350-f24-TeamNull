package proj.TeamNull.UMLdevkkit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import proj.TeamNull.UMLdevkit.reference.UMLComponent.UMLClass;
import proj.TeamNull.UMLdevkit.reference.UMLComponent.UMLField;

public class FreeToTestAnything {
  @Test
  @Timeout(1)
  public void printLn(){
    /*
     * Sample code I've written to test out the add utility.
     * It literally just creates an object, throws it into the UMLClass.add() and then prints it out.
     * This is just test code, so feel free to remove it later.(In fact, PLEASE remove it later!!!)
     * */

    UMLClass myClass = new UMLClass("Steve");
    System.out.println(myClass);
    UMLField field = new UMLField("int", "age");
    myClass.add(field);
    System.out.println(myClass);

    System.exit(0);
  }
}
