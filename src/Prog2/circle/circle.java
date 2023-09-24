package Prog2.circle;

public class circle {
    private double radius = 1.0;
    private String color = "red";

    public circle(){
    }
    public circle(double radius) {
        this.radius = radius;
    }

    public circle(double radius, String color) {
        this.color = color;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public String toString() {
        return "Prog2.circle.Prog2.circle[" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ']';
    }
}
