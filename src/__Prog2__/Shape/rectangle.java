package __Prog2__.Shape;

public class rectangle extends Shape{
    protected double width;
    protected double length;

    public rectangle() {
    }

    public rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    //metodos
    protected double getArea(){
        return width*length;
    }
    protected double getPerimeter(){
        return width*2+length*2;
    }

    @Override
    public String toString() {
        return "rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}