package umleditor.sprint2.model;

import umleditor.sprint1.uml.UMLClass;
import umleditor.sprint1.utilities.Storage;

/**
 * @Model is an adapter class for sprint-2 (temp)
 */
public class Model {
  /**
   * final product whole Node class information
   * nodeClass = (contains)
   * class name
   * attributes list
   * methods w/ parameters list
   * relationships list
   */
  public String createClassNode(String nodeClass){ //currently only holds 'class name'
    Storage.addClass(nodeClass);
    return nodeClass;
  }


}