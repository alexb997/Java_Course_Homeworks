package moving;

import exceptions.PointOutOfBound;

public class MovablePoint implements Movable {
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    public int getxSpeed() {
        return xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

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
}
