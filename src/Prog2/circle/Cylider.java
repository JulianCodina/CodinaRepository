package Prog2.circle;

public class Cylider extends circle {
    double height = 1.0;

    public Cylider() {
    }

    public Cylider(double radius) {
        super(radius);
    }

    public Cylider(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylider(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return this.height*this.getArea();
    }
}
