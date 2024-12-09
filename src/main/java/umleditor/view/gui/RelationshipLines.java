package umleditor.view.gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public class RelationshipLines {

    public Line getLine(UMLNode src, UMLNode dest, int type){
        switch(type){
            case 1:
                return createAssociationLine(src, dest);

            case 2:
                return createAggregationLine(src, dest);

            case 3:
                return createCompositionLine(src, dest);

            case 4:
                return createInheritanceLine(src, dest);

            case 5:
                return createGeneralizationLine(src, dest);

            case 6:
                return createRealizationLine(src, dest);

            case 7:
                return createDependencyLine(src, dest);

            default:
                return createRelationshipLine(src, dest);
        }
    }

    private Line createRelationshipLine(UMLNode src, UMLNode dest){
        Line relationshipLine = new Line();

//        //Bind to anchor point
//        System.out.println("src layoutXProperty: " + src.layoutXProperty().get());
//        relationshipLine.startXProperty().bind(src.getBottomCircle().centerXProperty());
//        System.out.println("Src anchorpointX: " + src.getAnchorPoint(0).getX());
//        relationshipLine.startYProperty().bind(src.getBottomCircle().centerXProperty());
//        System.out.println("Src anchorpointY: " + src.getAnchorPoint(0).getY());
//        System.out.println("line: " + relationshipLine);
//
//
//        relationshipLine.endXProperty().bind(dest.layoutXProperty().add(dest.getWidth() / 2));
//        relationshipLine.endYProperty().bind(dest.layoutYProperty().add(dest.getHeight() / 2));

      //  Bind to center of node
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


    private Line createInheritanceLine(UMLNode src, UMLNode dest) {
        Line inheritanceLine = createRelationshipLine(src, dest);
        inheritanceLine.setStroke(Color.BLUE);
        return inheritanceLine;
    }

    private Line createGeneralizationLine(UMLNode src, UMLNode dest){
        Line generalizationLine = createRelationshipLine(src, dest);
        generalizationLine.setStroke(Color.GREEN);
        return generalizationLine;
    }


    private Line createAssociationLine(UMLNode src, UMLNode dest){
        return createRelationshipLine(src, dest);
    }

    private Line createAggregationLine(UMLNode src, UMLNode dest){
        return createRelationshipLine(src, dest);
    }


    private Line createCompositionLine(UMLNode src, UMLNode dest){
        return createRelationshipLine(src, dest);
    }

    private Line createRealizationLine(UMLNode src, UMLNode dest){
        return createRelationshipLine(src, dest);
    }
}
