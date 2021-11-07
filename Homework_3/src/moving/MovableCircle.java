package moving;

public class MovableCircle implements Movable {
    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }

    @Override
    public void moveUp(int howMuch) {
        center.moveUp(howMuch);
    }

    @Override
    public void moveDown(int howMuch) {
        center.moveDown(howMuch);
    }

    @Override
    public void moveRight(int howMuch) {
        center.moveRight(howMuch);
    }

    @Override
    public void moveLeft(int howMuch) {
        center.moveLeft(howMuch);
    }
}
