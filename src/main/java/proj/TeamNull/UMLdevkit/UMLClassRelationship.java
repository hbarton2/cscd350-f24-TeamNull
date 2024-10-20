package proj.TeamNull.UMLdevkit;

/**
 * UMLClassRelationship represents the connection between two class objects.
 */
public class UMLClassRelationship {

    /* Name to reference relationship */
    private String name;
    /* Source class in the class relationship */
    private String source;
    /* Destination class in the class relationship */
    private String destination;
    /* Stores relationship type as a string */
    private String type;

    /**
     * Relationship Constructor
     * Takes in name for relationship, source class, destination class, and relationship type.
     * @param name name to reference relationship
     * @param source source class in relationship
     * @param destination destination class in relationship
     * @param type type of relationship
     */
    public UMLClassRelationship(String name, String source, String destination, String type) {
        this.name = name;  // The relationship name could be something like "Source-Destination-Type"
        this.source = source;
        this.destination = destination;
        this.type = type;
    }

    /**
     * Gets relationship name
     * @return name
     */
    public String getName() { return name; }

    /**
     * Sets relationship name
     * @param name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Gets relationship source
     * @return source
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets relationship source
     * @param source
     */
    public void setSource(String source) {this.source = source; }

    /**
     * Gets relationship destination
     * @return destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets relationship destination
     * @param destination
     */
    public void setDestination(String destination) {this.destination = destination; }

    /**
     * Gets type
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type
     * @param type of relationship
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns relationship as string
     * @return "Relationship: " + name + " [" + source.getName() + " -> " + destination.getName()
     *       + "] Type: " + type;
     */
    @Override
    public String toString() {
        return "Relationship: " + getName() + " [" + getSource() + " -> " + getDestination()
                + "] Type: " + getType();
    }
}
