package moving;

import exceptions.CircleOutOfBound;
import exceptions.OutOfBound;
import exceptions.PointOutOfBound;

import java.awt.*;

public class MovableCircle implements Movable {
    private final int radius;
    private final MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) throws CircleOutOfBound,PointOutOfBound {
        if(radius<0){
            throw new CircleOutOfBound("Radius can't be a negative value");
        }
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
        if (!isInBounds(radius, this.center)) {
            throw new CircleOutOfBound("Radius would place it out of allowed zone");
        }
        this.radius = radius;
    }

    @Override
    public void moveUp() throws CircleOutOfBound{
        if (this.center.getY() + radius > Movable.PLAIN_Y_MAX)
            throw new CircleOutOfBound("Can't move circle upwards!");
        try{
            center.moveUp();
        }catch (PointOutOfBound e){
            e.printStackTrace();
        }
    }

    @Override
    public void moveDown() throws CircleOutOfBound{
        if (this.center.getY() - radius < Movable.PLAIN_Y_MIN)
            throw new CircleOutOfBound("Can't move circle downwards!");
        try {
            center.moveDown();
        } catch (PointOutOfBound e) {
            e.printStackTrace();
        }
    }

    @Override
    public void moveLeft() throws CircleOutOfBound{
        if (this.center.getX() - radius < Movable.PLAIN_X_MIN)
            throw new CircleOutOfBound("Can't move circle to the left!");
        try {
            center.moveLeft();
        } catch (PointOutOfBound e) {
            e.printStackTrace();
        }
    }

    @Override
    public void moveRight() throws CircleOutOfBound{
        if (this.center.getX() + radius > Movable.PLAIN_X_MAX)
            throw new CircleOutOfBound("Can't move circle to the right!");
        try {
            center.moveRight();
        } catch (PointOutOfBound e) {
            e.printStackTrace();
        }
    }

    @Override
    public void moveUp(int howMuch) throws CircleOutOfBound {
        if (this.center.getY() + radius > Movable.PLAIN_Y_MAX)
            throw new CircleOutOfBound("Can't move circle upwards!");
        try {
            center.moveUp(howMuch);

        } catch (PointOutOfBound e) {
            e.printStackTrace();
        }
    }

    @Override
    public void moveDown(int howMuch) throws CircleOutOfBound {
        if (this.center.getY() - radius < Movable.PLAIN_Y_MIN)
            throw new CircleOutOfBound("Can't move circle downwards!");
        try {
            center.moveDown(howMuch);
        } catch (PointOutOfBound e) {
            e.printStackTrace();
        }
    }

    @Override
    public void moveRight(int howMuch) throws CircleOutOfBound {
        if (this.center.getX() + radius > Movable.PLAIN_X_MAX)
            throw new CircleOutOfBound("Can't move circle to the Right!");
        try{
            center.moveRight(howMuch);
        }catch (PointOutOfBound e){
            e.printStackTrace();
        }
    }

    @Override
    public void moveLeft(int howMuch) throws CircleOutOfBound {
        if (this.center.getX() - radius < Movable.PLAIN_X_MIN)
            throw new CircleOutOfBound("Can't move circle to the left!");
        try {
            center.moveLeft(howMuch);
        } catch (PointOutOfBound e) {
            e.printStackTrace();
        }
    }

    private boolean isInBounds(int radius, MovablePoint center) {
        return radius + center.getX() <= Movable.PLAIN_X_MAX && center.getX() - radius >= Movable.PLAIN_X_MIN &&
                radius + center.getY() <= Movable.PLAIN_Y_MAX && center.getY() - radius >= Movable.PLAIN_Y_MIN;
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }
}
