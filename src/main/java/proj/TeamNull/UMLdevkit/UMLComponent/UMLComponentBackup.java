package proj.TeamNull.UMLdevkit.UMLComponent;

/**
 * UMLComponent abstract class that provides interface for components of UML Editor:
 *      - UMLClases, UMLFields, UMLMethods, UMLParameter, UMLRelationships
 */
public abstract class UMLComponentBackup {
    protected String name;


    public UMLComponentBackup(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    // Basic operations that subclasses can override
    public abstract void add(UMLComponentBackup component);
    public abstract void remove(UMLComponentBackup component);
    public abstract UMLComponentBackup getChild(String name);

    // Other common operations
    public boolean isValidName(String name) {
        // You can add logic for name validation
        if(name == null)
            return false;
        if(name.length() > 50 || name.length() <= 1)
            return false;
        if(name.charAt(0) == '@')
            return false;
        return !name.isBlank();
    }
}
