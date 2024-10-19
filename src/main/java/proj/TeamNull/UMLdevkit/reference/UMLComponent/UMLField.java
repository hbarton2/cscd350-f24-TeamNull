package proj.TeamNull.UMLdevkit.reference.UMLComponent;

/**
 * UMLField extends UMLComponent. Represents a Field in a class.
 * A UMLField should not be able to exist without being in a UMLClass
 * UMLField class only has a constructor that intakes the name of the field and the field's type
 * UMLFields cannot be in the same class and have the same name
 * TODO: add change field name and change field type methods <-- Name is already handled by Super Class of UMLComponent.
 *  Also, I created the setType method, this comment is no longer needed!
 */


public class UMLField extends UMLComponent {

  private String type;

  /**
   * UMLField constructor
   * @param name is the name of the field to be passed to super constructor(UMLComponent).
   * @param type references the type of field to be created.
   * **/
  public UMLField(String type, String name) {
    super(name);
    if (!isValidName(type)){
      throw new IllegalArgumentException("'type' can not be empty or null!");
    }
    this.type = type;
  }

  @Override
  public void add(Object component) {
    //Since we only needed to include them bc Abstract, I just made it an  empty method <-- Shane wuz here
  }

  @Override
  public void remove(Object component) {
    //Since we only needed to include them bc Abstract, I just made it an  empty method <-- Shane wuz here
  }

  /**
   * Returns the Field type;
   * **/
  public String getType() {
    return this.type;
  }

  /**
   * Mutates the Field type;
   * **/
  public void setType(String type) {
    this.type = type;
  }

  /**
   * Decremented feature. Not applicable to type 'Field'
   * **/
  //  @Override  <-- Shane wuz here
  //  public UMLComponent getChild(String name) {
  //    throw new UnsupportedOperationException("No child components in a field.");
  //  }

  /**
   * @Overrride toString() in Object super class.
   * <p>
   * Returns a String object containing both this.(type and name)
   * <p>
   * @return "UMLField{" +
   *             "type='" + this.type + '\'' +
   *             ", name='" + this.name + '\'' +
   *             '}'
   * **/
  @Override
  public String toString() {
    return "UMLField{" +
            "type='" + this.type + '\'' +
            ", name='" + this.name + '\'' +
            '}';
  }

}

