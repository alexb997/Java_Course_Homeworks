package moving;

import exceptions.OutOfBound;
import exceptions.PointOutOfBound;

public class MovablePoint implements Movable {
    private int x;
    private int y;
    private final int xSpeed;
    private final int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        try{
            if(!isInBounds(x,y)){
                throw new OutOfBound("The position would be out of the allowed zone");
            }
        }catch (OutOfBound e){
            e.printStackTrace();
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

    @Override
    public void moveUp(){
        try {
            if (this.y + this.ySpeed > Movable.PLAIN_Y_MAX) {
                throw new PointOutOfBound("Can't move point any higher!");
            }
            this.y += this.ySpeed;
        } catch (PointOutOfBound e) {
            e.printStackTrace();
        }
    }

    @Override
    public void moveDown(){
        try{
            if(this.y - this.ySpeed < Movable.PLAIN_Y_MIN){
                throw new PointOutOfBound("Can't move point any lower!");
            }
            this.y -= this.ySpeed;
        }catch (PointOutOfBound e){
            e.printStackTrace();
        }
    }

    @Override
    public void moveLeft() {
        try{
            if(this.x - this.xSpeed < Movable.PLAIN_X_MIN){
                throw new PointOutOfBound("Can't move point any more to the left!");
            }
            this.x -= this.xSpeed;
        }catch (PointOutOfBound e){
            e.printStackTrace();
        }

    }

    @Override
    public void moveRight() {
        try{
            if(this.x + this.xSpeed > Movable.PLAIN_X_MAX){
                throw new PointOutOfBound("Can't move point any more to the right!");
            }
            this.x += this.xSpeed;
        }catch (PointOutOfBound e){
            e.printStackTrace();
        }
    }

    @Override
    public void moveUp(int howMuch){
        try{
            if(this.x + howMuch > Movable.PLAIN_Y_MAX){
                throw new PointOutOfBound("Can't move point any higher!");
            }
            this.y += howMuch;
        }catch (PointOutOfBound e){
            e.printStackTrace();
        }
    }

    @Override
    public void moveDown(int howMuch){
        try{
            if(this.y - howMuch < Movable.PLAIN_Y_MIN){
                throw new PointOutOfBound("Can't move point any lower!");
            }
            this.y -= howMuch;
        }catch (PointOutOfBound e){
            e.printStackTrace();
        }
    }

    @Override
    public void moveLeft(int howMuch){
        try{
            if(this.x - howMuch < Movable.PLAIN_X_MIN){
                throw new PointOutOfBound("Can't move point any more to the left!");
            }
            this.x -= howMuch;
        }catch (PointOutOfBound e){
            e.printStackTrace();
        }
    }

    @Override
    public void moveRight(int howMuch)  {
        try{
            if(this.x + howMuch > Movable.PLAIN_X_MAX){
                throw new PointOutOfBound("Can't move point any more to the right!");
            }
            this.x += howMuch;
        }catch (PointOutOfBound e){
            e.printStackTrace();
        }
    }

    public boolean isInBounds(int x,int y){
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
