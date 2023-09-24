package Prog2.Shape;

public abstract class Shape {

    protected String color;
    protected boolean filled;

    public Shape() {
    }
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    protected abstract double getArea();
    protected abstract double getPerimeter();


    @Override
    public String toString() {
        return "Prog2.Shape{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}
