package __Prog2__.GeometricObject;

public class Circle implements GeometricObject{
    double radius = 1.0;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getPerimeter(){
        double PI = 3.14159265359;
        return PI*radius*2;
    }

    public double getArea() {
        double PI = 3.14159265359;
        return PI* (radius*radius);
    }
}
