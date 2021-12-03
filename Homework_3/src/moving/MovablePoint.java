package moving;

import exceptions.PointOutOfBound;

public class MovablePoint implements Movable {
    private int x;
    private int y;
    private final int xSpeed;
    private final int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) throws PointOutOfBound {
        if(!isInBounds(x,y)){
            throw new PointOutOfBound("The position would be out of the allowed zone");
        }
        if(xSpeed <= 0 || ySpeed <= 0) {
            throw new PointOutOfBound("The xSpeed and ySpeed value can't be negative or zero");
        }
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

    public int getxSpeed() {
        return xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    @Override
    public void moveUp() throws PointOutOfBound{
        if (y + ySpeed > Movable.PLAIN_Y_MAX) {
            throw new PointOutOfBound("Can't move point any higher!");
        }
        y += ySpeed;
    }

    @Override
    public void moveDown() throws PointOutOfBound{
        if(y - ySpeed < Movable.PLAIN_Y_MIN){
            throw new PointOutOfBound("Can't move point any lower!");
        }
        y -= ySpeed;

    }

    @Override
    public void moveLeft() throws PointOutOfBound{
        if(x - xSpeed < Movable.PLAIN_X_MIN){
            throw new PointOutOfBound("Can't move point any more to the left!");
        }
        x -= xSpeed;
    }

    @Override
    public void moveRight() throws PointOutOfBound{
        if(x + xSpeed > Movable.PLAIN_X_MAX){
            throw new PointOutOfBound("Can't move point any more to the right!");
        }
        x += xSpeed;
    }

    @Override
    public void moveUp(int distance) throws PointOutOfBound{
        if(distance > 0) {
            if (x + distance > Movable.PLAIN_Y_MAX) {
                throw new PointOutOfBound("Can't move point any higher!");
            }
            y += distance;
        }else{
            throw new PointOutOfBound("Invalid distance value!");
        }
    }

    @Override
    public void moveDown(int distance) throws PointOutOfBound{
        if(distance > 0) {
            if(y - distance < Movable.PLAIN_Y_MIN){
                throw new PointOutOfBound("Can't move point any lower!");
            }
            y -= distance;
        }else{
            throw new PointOutOfBound("Invalid distance value!");
        }
    }

    @Override
    public void moveLeft(int distance) throws PointOutOfBound{
        if(distance > 0) {
            if(x - distance < Movable.PLAIN_X_MIN){
                throw new PointOutOfBound("Can't move point any more to the left!");
            }
            x -= distance;
        }else{
            throw new PointOutOfBound("Invalid distance value!");
        }
    }

    @Override
    public void moveRight(int distance) throws PointOutOfBound{
        if(distance > 0) {
            if (x + distance > Movable.PLAIN_X_MAX) {
                throw new PointOutOfBound("Can't move point any more to the right!");
            }
            x += distance;
        }else{
            throw new PointOutOfBound("Invalid distance value!");
        }

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
