package umleditor.model.utilities;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import umleditor.view.gui.UMLNode;

public class AnchorPoint {

    private double xPos;
    private double yPos;

    public AnchorPoint(double x, double y){
        this.xPos = x;
        this.yPos = y;
    }

    public double getX(){
        return this.xPos;
    }

    public double getY(){
        return this.yPos;
    }

    public void updatePos(double x, double y){
        this.xPos = x;
        this.yPos = y;
    }


}
