package moving;

public class MovablePoint implements Movable {
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }

    @Override
    public void moveUp() {
        this.y = this.y + this.ySpeed;
    }

    @Override
    public void moveDown() {
        this.y = this.y - this.ySpeed;
    }

    @Override
    public void moveLeft() {
        this.x = this.x - this.xSpeed;
    }

    @Override
    public void moveRight() {
        this.x = this.x + this.xSpeed;
    }

    @Override
    public void moveUp(int howMuch) {
        this.y = this.y + howMuch;
    }

    @Override
    public void moveDown(int howMuch) {
        this.y = this.y - howMuch;
    }

    @Override
    public void moveLeft(int howMuch) {
        this.x = this.x - howMuch;
    }

    @Override
    public void moveRight(int howMuch) {
        this.x = this.x + howMuch;
    }
}
