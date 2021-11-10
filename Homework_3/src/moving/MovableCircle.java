package moving;

import exceptions.CircleOutOfBound;
import exceptions.PointOutOfBound;

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
        try{
            center.moveUp();
            if(this.center.getY()+radius> Movable.PLAIN_Y_MAX)
                throw new CircleOutOfBound("Can't move circle upwards!");
        }catch (CircleOutOfBound e){
            e.printStackTrace();
        }
    }

    @Override
    public void moveDown() {
        try{
            center.moveDown();
            if(this.center.getY()-radius< Movable.PLAIN_Y_MIN)
                throw new CircleOutOfBound("Can't move circle downwards!");
        }catch (CircleOutOfBound e){
            e.printStackTrace();
        }
    }

    @Override
    public void moveLeft() {
        try{
            center.moveLeft();
            if(this.center.getX()-radius< Movable.PLAIN_X_MIN)
                throw new CircleOutOfBound("Can't move circle to the left!");
        }catch (CircleOutOfBound e){
            e.printStackTrace();
        }
    }

    @Override
    public void moveRight() {
        try{
            center.moveRight();
            if(this.center.getX()+radius> Movable.PLAIN_X_MAX)
                throw new CircleOutOfBound("Can't move circle to the right!");
        }catch (CircleOutOfBound e){
            e.printStackTrace();
        }
    }

    @Override
    public void moveUp(int howMuch) {
        try{
            center.moveUp(howMuch);
            if(this.center.getY()+radius> Movable.PLAIN_Y_MAX)
                throw new CircleOutOfBound("Can't move circle upwards!");
        }catch (CircleOutOfBound e){
            e.printStackTrace();
        }
    }

    @Override
    public void moveDown(int howMuch) {
        try{
            center.moveDown(howMuch);
            if(this.center.getY()-radius< Movable.PLAIN_Y_MIN)
                throw new CircleOutOfBound("Can't move circle downwards!");
        }catch (CircleOutOfBound e){
            e.printStackTrace();
        }
    }

    @Override
    public void moveRight(int howMuch) {
        try{
            center.moveRight(howMuch);
            if(this.center.getX()+radius> Movable.PLAIN_X_MAX)
                throw new CircleOutOfBound("Can't move circle to the Right!");
        }catch (CircleOutOfBound e){
            e.printStackTrace();
        }
    }

    @Override
    public void moveLeft(int howMuch) {
        try{
            center.moveLeft(howMuch);
            if(this.center.getX()-radius< Movable.PLAIN_X_MIN)
                throw new CircleOutOfBound("Can't move circle to the left!");
        }catch (CircleOutOfBound e){
            e.printStackTrace();
        }
    }
}
