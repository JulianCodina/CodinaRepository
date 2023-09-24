package Prog2.Shape;

public class square extends rectangle {
    protected double side;
    public square() {
    }

    public square(double side) {
        this.side = side;
    }

    public square(String color, boolean filled, double width, double length, double side) {
        super(color, filled, width, length);
        this.side = side;
    }

    @Override
    public String toString() {
        return "square{" +
                "side=" + side +
                ", width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }
    public void setLength(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        this.side = side;
    }
}
