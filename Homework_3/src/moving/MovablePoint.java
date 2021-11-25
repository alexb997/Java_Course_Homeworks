package moving;

import exceptions.OutOfBound;
import exceptions.PointOutOfBound;

public class MovablePoint implements Movable {
    private int x;
    private int y;
    private final int xSpeed;
    private final int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) throws OutOfBound {
        if(!isInBounds(x,y)){
            throw new OutOfBound("The position would be out of the allowed zone");
        }
        if(xSpeed<0 || ySpeed<0)
            throw new OutOfBound("The xSpeed and ySpeed value can't be negative");
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void moveUp() throws PointOutOfBound{
        if (this.y + this.ySpeed > Movable.PLAIN_Y_MAX) {
            throw new PointOutOfBound("Can't move point any higher!");
        }
        this.y += this.ySpeed;
    }

    @Override
    public void moveDown() throws PointOutOfBound{
        if(this.y - this.ySpeed < Movable.PLAIN_Y_MIN){
            throw new PointOutOfBound("Can't move point any lower!");
        }
        this.y -= this.ySpeed;

    }

    @Override
    public void moveLeft() throws PointOutOfBound{
        if(this.x - this.xSpeed < Movable.PLAIN_X_MIN){
            throw new PointOutOfBound("Can't move point any more to the left!");
        }
        this.x -= this.xSpeed;
    }

    @Override
    public void moveRight() throws PointOutOfBound{
        if(this.x + this.xSpeed > Movable.PLAIN_X_MAX){
            throw new PointOutOfBound("Can't move point any more to the right!");
        }
        this.x += this.xSpeed;
    }

    @Override
    public void moveUp(int howMuch) throws PointOutOfBound{
        if(this.x + howMuch > Movable.PLAIN_Y_MAX){
            throw new PointOutOfBound("Can't move point any higher!");
        }
        this.y += howMuch;
    }

    @Override
    public void moveDown(int howMuch) throws PointOutOfBound{
        if(this.y - howMuch < Movable.PLAIN_Y_MIN){
            throw new PointOutOfBound("Can't move point any lower!");
        }
        this.y -= howMuch;
    }

    @Override
    public void moveLeft(int howMuch) throws PointOutOfBound{
        if(this.x - howMuch < Movable.PLAIN_X_MIN){
            throw new PointOutOfBound("Can't move point any more to the left!");
        }
        this.x -= howMuch;

    }

    @Override
    public void moveRight(int howMuch) throws PointOutOfBound{
        if(this.x + howMuch > Movable.PLAIN_X_MAX){
            throw new PointOutOfBound("Can't move point any more to the right!");
        }
        this.x += howMuch;

    }

    private boolean isInBounds(int x,int y){
        return x<=Movable.PLAIN_X_MAX && x>=Movable.PLAIN_X_MIN &&
                y<=Movable.PLAIN_Y_MAX && y>=Movable.PLAIN_Y_MIN;
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
}
