package umleditor.model;

import umleditor.model.utilities.Storage;

/**
 * @Model is an adapter class for sprint-2 (temp)
 */
public class Model {
  // Singleton Storage instance
  private static final Storage storage = Storage.getInstance();

  /**
   * final product whole Node class information
   * nodeClass = (contains)
   * class name
   * attributes list
   * methods w/ parameters list
   * relationships list
   */
  public String createClassNode(String nodeClass){ //currently only holds 'class name'
    storage.addClass(nodeClass);
    return nodeClass;
  }


}