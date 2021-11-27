package moving;

import exceptions.CircleOutOfBound;
import exceptions.OutOfBound;
import exceptions.RuntimeOutOfBound;

public class MovableCircle implements Movable {
    private int radius;
    private final MovablePoint center;

    private final String radiusMessageError = "Radius would place it out of allowed zone";

    public MovableCircle(MovablePoint center, int radius){
        try {
            this.center = center;
            setRadius(radius);
        } catch (OutOfBound e) {
            throw new RuntimeOutOfBound("Couldn't create circle", e);
        }
    }

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        try {
            center = new MovablePoint(x, y, xSpeed, ySpeed);
            setRadius(radius);
        } catch (OutOfBound e) {
            throw new RuntimeOutOfBound("Couldn't create circle", e);
        }
    }

    private void setRadius(int radius) throws CircleOutOfBound {
        if (!isInBounds(radius, center)) {
            throw new CircleOutOfBound("Radius " +
                    (radius < 0 ? "can't be negative " :
                            "would place it out of allowed zone"));
        }
        this.radius = radius;
    }

    @Override
    public void moveUp() {
        try {
            isMovePossible("UP");
            center.moveUp();
        } catch (OutOfBound e) {
            throw new RuntimeOutOfBound("Couldn't move the circle upwards ", e);
        }
    }

    @Override
    public void moveDown() {
        try {
            isMovePossible("DOWN");
            center.moveDown();
        } catch (OutOfBound e) {
            throw new RuntimeOutOfBound("Couldn't move the circle downwards ", e);
        }
    }

    @Override
    public void moveLeft() {
        try {
            isMovePossible("LEFT");
            center.moveLeft();
        } catch (OutOfBound e) {
            throw new RuntimeOutOfBound("Couldn't move the circle to the left ",e);
        }
    }

    @Override
    public void moveRight(){
        try {
            isMovePossible("RIGHT");
            center.moveRight();
        } catch (OutOfBound e) {
            throw new RuntimeOutOfBound("Couldn't move the circle to the right ",e);
        }
    }

    @Override
    public void moveUp(int howMuch) {
        try {
            isMovePossible("UP",howMuch);
            center.moveUp(howMuch);
        } catch (OutOfBound e) {
            throw new RuntimeOutOfBound("Couldn't move the circle upwards ",e);
        }
    }

    @Override
    public void moveDown(int howMuch) {
        try {
            isMovePossible("DOWN",howMuch);
            center.moveDown(howMuch);
        } catch (OutOfBound e) {
            throw new RuntimeOutOfBound("Couldn't move the circle downwards ",e);
        }
    }

    @Override
    public void moveRight(int howMuch){
        try {
            isMovePossible("RIGHT",howMuch);
            center.moveRight(howMuch);
        } catch (OutOfBound e) {
            throw new RuntimeOutOfBound("Couldn't move the circle to the right ",e);
        }
    }

    @Override
    public void moveLeft(int howMuch) {
        try {
            isMovePossible("LEFT",howMuch);
            center.moveLeft(howMuch);
        } catch (OutOfBound e) {
            throw new RuntimeOutOfBound("Couldn't move the circle to the left ",e);
        }
    }

    private boolean isInBounds(int radius, MovablePoint center) {
        return radius + center.getX() <= Movable.PLAIN_X_MAX && center.getX() - radius >= Movable.PLAIN_X_MIN &&
                radius + center.getY() <= Movable.PLAIN_Y_MAX && center.getY() - radius >= Movable.PLAIN_Y_MIN;
    }

    private void isMovePossible(String direction) throws CircleOutOfBound {
        switch (direction) {
            case "UP": {
                if (center.getY() + radius + center.getySpeed() > Movable.PLAIN_Y_MAX) {
                    throw new CircleOutOfBound(radiusMessageError);
                }
                break;
            }
            case "DOWN": {
                if (center.getY() - radius - center.getySpeed() < Movable.PLAIN_Y_MIN){
                    throw new CircleOutOfBound(radiusMessageError);
                }
            }
            case "LEFT": {
                if (center.getX() - radius - center.getxSpeed() < Movable.PLAIN_X_MIN){
                    throw new CircleOutOfBound(radiusMessageError);
                }
            }
            case "RIGHT": {
                if (center.getX() + radius + center.getxSpeed() > Movable.PLAIN_X_MAX){
                    throw new CircleOutOfBound(radiusMessageError);
                }
            }
        }
    }

    private void isMovePossible(String direction,int howMuch) throws CircleOutOfBound {
        switch (direction) {
            case "UP": {
                if (center.getY() + radius + howMuch > Movable.PLAIN_Y_MAX) {
                    throw new CircleOutOfBound(radiusMessageError);
                }
                break;
            }
            case "DOWN": {
                if (center.getY() - radius - howMuch < Movable.PLAIN_Y_MIN){
                    throw new CircleOutOfBound(radiusMessageError);
                }
            }
            case "LEFT": {
                if (center.getX() - radius - howMuch < Movable.PLAIN_X_MIN){
                    throw new CircleOutOfBound(radiusMessageError);
                }
            }
            case "RIGHT": {
                if (center.getX() + radius + howMuch > Movable.PLAIN_X_MAX){
                    throw new CircleOutOfBound(radiusMessageError);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }
}
