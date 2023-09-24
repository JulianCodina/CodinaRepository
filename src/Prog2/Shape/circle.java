package Prog2.Shape;

public class circle extends Shape{
    protected double radius;

    public circle() {
    }

    public circle(double radius) {
        this.radius = radius;
    }

    public circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    //metodos
    protected double getArea(){
        double PI = 3.14159265359;
        return PI* (radius*radius);
    }
    protected double getPerimeter(){
         double PI = 3.14159265359;
         return PI*radius*2;
    }

    @Override
    public String toString() {
        return "Prog2.circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
