package moving;

import exceptions.CircleOutOfBound;
import exceptions.PointOutOfBound;

public class MovableCircle implements Movable {
    private int radius;
    private final MovablePoint center;

    private final String radiusMessageError = "Radius would place it out of allowed zone";

    public MovableCircle(MovablePoint center, int radius) throws CircleOutOfBound {
        this.center = center;
        setRadius(radius);

    }

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) throws CircleOutOfBound, PointOutOfBound {
        center = new MovablePoint(x, y, xSpeed, ySpeed);
        setRadius(radius);

    }

    private void setRadius(int radius) throws CircleOutOfBound {
        if(radius > 0) {
            if (!isInBounds(radius, center)) {
                throw new CircleOutOfBound("Radius of " + radius + " would place it out of allowed zone");
            }
            this.radius = radius;
        }else{
            throw new CircleOutOfBound("Radius can't be negative or zero");
        }
    }

    @Override
    public void moveUp() throws CircleOutOfBound, PointOutOfBound {
        validateMove(Direction.UP);
        center.moveUp();
    }

    @Override
    public void moveDown() throws CircleOutOfBound, PointOutOfBound {
        validateMove(Direction.DOWN);
        center.moveDown();

    }

    @Override
    public void moveLeft() throws PointOutOfBound, CircleOutOfBound {
        validateMove(Direction.LEFT);
        center.moveLeft();
    }

    @Override
    public void moveRight() throws CircleOutOfBound, PointOutOfBound {
        validateMove(Direction.RIGHT);
        center.moveRight();
    }

    @Override
    public void moveUp(int distance) throws CircleOutOfBound, PointOutOfBound {
        validateMove(Direction.UP,distance);
        center.moveUp(distance);
    }

    @Override
    public void moveDown(int distance) throws PointOutOfBound, CircleOutOfBound {
        validateMove(Direction.DOWN,distance);
        center.moveDown(distance);
    }

    @Override
    public void moveRight(int distance) throws PointOutOfBound, CircleOutOfBound {
        validateMove(Direction.RIGHT,distance);
        center.moveRight(distance);
    }

    @Override
    public void moveLeft(int distance) throws PointOutOfBound, CircleOutOfBound {
        validateMove(Direction.LEFT,distance);
        center.moveLeft(distance);
    }

    private boolean isInBounds(int radius, MovablePoint center) {
        return radius + center.getX() <= Movable.PLAIN_X_MAX && center.getX() - radius >= Movable.PLAIN_X_MIN &&
                radius + center.getY() <= Movable.PLAIN_Y_MAX && center.getY() - radius >= Movable.PLAIN_Y_MIN;
    }

    private void validateMove(Direction direction) throws CircleOutOfBound {
        switch (direction) {
            case UP: {
                if (center.getY() + radius + center.getySpeed() > Movable.PLAIN_Y_MAX) {
                    throw new CircleOutOfBound(radiusMessageError);
                }
                break;
            }
            case DOWN: {
                if (center.getY() - radius - center.getySpeed() < Movable.PLAIN_Y_MIN){
                    throw new CircleOutOfBound(radiusMessageError);
                }
            }
            case LEFT: {
                if (center.getX() - radius - center.getxSpeed() < Movable.PLAIN_X_MIN){
                    throw new CircleOutOfBound(radiusMessageError);
                }
            }
            case RIGHT: {
                if (center.getX() + radius + center.getxSpeed() > Movable.PLAIN_X_MAX){
                    throw new CircleOutOfBound(radiusMessageError);
                }
            }
        }
    }

    private void validateMove(Direction direction, int distance) throws CircleOutOfBound {
        if(distance<1){
            throw new CircleOutOfBound("Distance can't be negative or zero");
        }
        switch (direction) {
            case UP: {
                if (center.getY() + radius + distance > Movable.PLAIN_Y_MAX) {
                    throw new CircleOutOfBound(radiusMessageError);
                }
                break;
            }
            case DOWN: {
                if (center.getY() - radius - distance < Movable.PLAIN_Y_MIN){
                    throw new CircleOutOfBound(radiusMessageError);
                }
            }
            case LEFT: {
                if (center.getX() - radius - distance < Movable.PLAIN_X_MIN){
                    throw new CircleOutOfBound(radiusMessageError);
                }
            }
            case RIGHT: {
                if (center.getX() + radius + distance > Movable.PLAIN_X_MAX){
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
