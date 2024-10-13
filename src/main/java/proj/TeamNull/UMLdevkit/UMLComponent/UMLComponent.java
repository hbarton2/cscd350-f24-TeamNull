package proj.TeamNull.UMLdevkit.UMLComponent;

/**
 * UMLComponent abstract class that provides interface for components of UML Editor:
 *      - UMLClases, UMLFields, UMLMethods, UMLParameter, UMLRelationships
 */
public abstract class UMLComponent {
    protected String name;

    /**
     * Constructs Component
     * @param name component name
     */
    public UMLComponent(String name) {
        this.name = name;
    }

    /**
     * Gets name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name
     * @param name of component
     */
    public void setName(String name) {
        this.name = name;
    }

    // Basic operations that subclasses can override
    public abstract void add(UMLComponent component);
    public abstract void remove(UMLComponent component);
    public abstract UMLComponent getChild(String name);

    // Other common operations
    public boolean isValidName(String name) {
        // You can add logic for name validation
        return name != null && !name.trim().isEmpty();
    }
}
