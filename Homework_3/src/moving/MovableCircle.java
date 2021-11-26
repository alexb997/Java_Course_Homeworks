package moving;

import exceptions.CircleOutOfBound;
import exceptions.OutOfBound;
import exceptions.PointOutOfBound;

import java.awt.*;

public class MovableCircle implements Movable {
    private final int radius;
    private final MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) throws CircleOutOfBound,PointOutOfBound {

        try{
            this.center = new MovablePoint(x, y, xSpeed, ySpeed);
            if (!isInBounds(radius, this.center)) {
                throw new OutOfBound("Radius "+
                        (radius<0? "can't be negative ":"would place it out of allowed zone"));
            }
            this.radius = radius;
        }catch (OutOfBound e){
            throw new CircleOutOfBound("Couldn't create a circle ",e);
        }

    }

    @Override
    public void moveUp() throws CircleOutOfBound{
        try{
            if (this.center.getY() + radius > Movable.PLAIN_Y_MAX)
                throw new OutOfBound("Center Y + radius can't be higher than " + Movable.PLAIN_Y_MAX);
            center.moveUp();
        }catch (OutOfBound e){
            throw new CircleOutOfBound("Couldn't move the circle upwards ",e);
        }
    }

    @Override
    public void moveDown() throws CircleOutOfBound{
        try {
            if (this.center.getY() - radius < Movable.PLAIN_Y_MIN)
                throw new OutOfBound("Center Y - radius can't be lower than " + Movable.PLAIN_Y_MIN);
            center.moveDown();
        } catch (OutOfBound e) {
            throw new CircleOutOfBound("Couldn't move the circle downwards ",e);
        }
    }

    @Override
    public void moveLeft() throws CircleOutOfBound{
        try {
            if (this.center.getX() - radius < Movable.PLAIN_X_MIN)
                throw new OutOfBound("Center X - radius can't be lower than " +Movable.PLAIN_X_MIN);
            center.moveLeft();
        } catch (OutOfBound e) {
            throw new CircleOutOfBound("Couldn't move the circle to the left ",e);
        }
    }

    @Override
    public void moveRight() throws CircleOutOfBound{
        try {
            if (this.center.getX() + radius > Movable.PLAIN_X_MAX)
                throw new OutOfBound("Center X + radius can't be higher than " +Movable.PLAIN_X_MAX);
            center.moveRight();
        } catch (OutOfBound e) {
            throw new CircleOutOfBound("Couldn't move the circle to the right ",e);
        }
    }

    @Override
    public void moveUp(int howMuch) throws CircleOutOfBound {
        try {
            if (this.center.getY() +howMuch + radius > Movable.PLAIN_Y_MAX)
                throw new OutOfBound("Center Y + howMuch + radius can't be higher than " + Movable.PLAIN_Y_MAX);
            center.moveUp(howMuch);
        } catch (OutOfBound e) {
            throw new CircleOutOfBound("Couldn't move the circle upwards ",e);
        }
    }

    @Override
    public void moveDown(int howMuch) throws CircleOutOfBound {
        try {
            if (this.center.getY() -howMuch - radius < Movable.PLAIN_Y_MIN)
                throw new OutOfBound("Center Y - howMuch -radius can't be lower than "+ Movable.PLAIN_Y_MIN);
            center.moveDown(howMuch);
        } catch (OutOfBound e) {
            e.printStackTrace();
        }
    }

    @Override
    public void moveRight(int howMuch) throws CircleOutOfBound {
        if (this.center.getX() + howMuch + radius > Movable.PLAIN_X_MAX)
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
