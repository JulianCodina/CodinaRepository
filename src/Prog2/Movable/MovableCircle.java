package Prog2.Movable;

public class MovableCircle extends MovablePoint implements Movable{
    int radius;
    MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        super(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                ", x=" + x +
                ", y=" + y +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }

    public void moveUp(){
        this.x+=this.xSpeed;
    }
    public void moveDown(){
        this.x-=this.xSpeed;
    }
    public void moveLeft(){
        this.y-=this.ySpeed;
    }
    public void moveRight(){
        this.y+=this.ySpeed;
    }
}
