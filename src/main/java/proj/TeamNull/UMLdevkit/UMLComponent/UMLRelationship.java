package proj.TeamNull.UMLdevkit.UMLComponent;

/**
 * UMLRelationship extends UMLComponent. Represents the connection between two class objects.
 *
 */
public class UMLRelationship extends UMLComponent {
    private UMLClass source;
    private UMLClass destination;
    private String type;  // For now, we can store the type of relationship as a string

    /**
     * Relationship Constructor
     * @param name defines relationship. Format: "source - destination relationship"
     * @param source source class
     * @param destination destination class
     * @param type relationship type
     */
    public UMLRelationship(String name, UMLClass source, UMLClass destination, String type) {
        super(name);  // The relationship name could be something like "Person-Address Association"
        this.source = source;
        this.destination = destination;
        this.type = type;
    }

    /**
     * Gets Source
     * @return this source
     */
    public UMLClass getSource() {
        return source;
    }

    /**
     * Gets destination
     * @return this relationship
     */
    public UMLClass getDestination() {
        return destination;
    }

    /**
     * Gets Type
     * @return relationship type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets relationship type
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void add(UMLComponent component) {
        throw new UnsupportedOperationException("Cannot add components to a relationship.");
    }

    @Override
    public void remove(UMLComponent component) {
        throw new UnsupportedOperationException("Cannot remove components from a relationship.");
    }

    @Override
    public UMLComponent getChild(String name) {
        throw new UnsupportedOperationException("No child components in a relationship.");
    }

    @Override
    public String toString() {
        return "Relationship: " + name + " [" + source.getName() + " -> " + destination.getName() + "] Type: " + type;
    }
}
