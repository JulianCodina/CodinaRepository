package Prog2.GeometricObject;

public class ResizableCircle extends Circle implements Resizable{
    public ResizableCircle(double radius) {
        super(radius);
    }
    public void resize(int percent){
        this.radius = this.radius*percent;
    }
}
