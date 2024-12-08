package umleditor.view.gui;

import javafx.scene.shape.Line;

public class RelationshipLines {

    public Line getLine(UMLNode src, UMLNode dest, int type){
        switch(type){
            case 7:
                return createDependencyLine(src, dest);

            default:
                return createRelationshipLine(src, dest);
        }
    }

    private Line createRelationshipLine(UMLNode src, UMLNode dest){
        Line relationshipLine = new Line();
        relationshipLine.startXProperty().bind(src.layoutXProperty().add(src.getWidth() / 2));
        relationshipLine.startYProperty().bind(src.layoutYProperty().add(src.getHeight() / 2));
        relationshipLine.endXProperty().bind(dest.layoutXProperty().add(dest.getWidth() / 2));
        relationshipLine.endYProperty().bind(dest.layoutYProperty().add(dest.getHeight() / 2));

        return relationshipLine;
    }

    private Line createDependencyLine(UMLNode src, UMLNode dest) {
        Line dependencyLine = createRelationshipLine(src, dest);
        dependencyLine.getStrokeDashArray().addAll(10.0, 5.0);
        return dependencyLine;
    }
}
