package umleditor.sprint1.uml;

public class UMLAttribute {

    private String name;
    private final String type;

    public UMLAttribute(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public String getType(){
        return this.type;
    }

    public void setName(String newName){
        this.name = newName;
    }

    @Override
    public String toString() {
        return this.type + " " + this.name;
    }
}
