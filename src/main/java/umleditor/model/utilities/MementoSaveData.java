package umleditor.model.utilities;

import umleditor.model.uml.UMLClass;
import umleditor.model.uml.UMLRelationship;

import java.util.ArrayList;
import java.util.HashMap;

public class MementoSaveData {
    private HashMap<String, UMLClass> classes;
    private ArrayList<UMLRelationship> relationships;

    public MementoSaveData(HashMap<String, UMLClass> classes, ArrayList<UMLRelationship> relationships) {
        this.classes = classes;
        this.relationships = relationships;
    }

    public HashMap<String, UMLClass> getClasses() {
        return classes;
    }

    public void setClasses(HashMap<String, UMLClass> classes) {
        this.classes = classes;
    }

    public ArrayList<UMLRelationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(ArrayList<UMLRelationship> relationships) {
        this.relationships = relationships;
    }
}
