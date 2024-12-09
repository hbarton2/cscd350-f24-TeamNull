package umleditor.model.utilities;

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
