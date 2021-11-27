package moving;

import exceptions.CircleOutOfBound;
import exceptions.PointOutOfBound;

public class MovableCircle implements Movable {
    private int radius;
    private final MovablePoint center;

    enum Directions {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

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
        if (!isInBounds(radius, center)) {
            throw new CircleOutOfBound("Radius " +
                    (radius < 0 ? "can't be negative " :
                            "would place it out of allowed zone"));
        }
        this.radius = radius;
    }

    @Override
    public void moveUp() throws CircleOutOfBound, PointOutOfBound {
        validateMove(Directions.UP);
        center.moveUp();
    }

    @Override
    public void moveDown() throws CircleOutOfBound, PointOutOfBound {
        validateMove(Directions.DOWN);
        center.moveDown();

    }

    @Override
    public void moveLeft() throws PointOutOfBound, CircleOutOfBound {
        validateMove(Directions.LEFT);
        center.moveLeft();
    }

    @Override
    public void moveRight() throws CircleOutOfBound, PointOutOfBound {
        validateMove(Directions.RIGHT);
        center.moveRight();
    }

    @Override
    public void moveUp(int howMuch) throws CircleOutOfBound, PointOutOfBound {
        validateMove(Directions.UP,howMuch);
        center.moveUp(howMuch);
    }

    @Override
    public void moveDown(int howMuch) throws PointOutOfBound, CircleOutOfBound {
        validateMove(Directions.DOWN,howMuch);
        center.moveDown(howMuch);
    }

    @Override
    public void moveRight(int howMuch) throws PointOutOfBound, CircleOutOfBound {
        validateMove(Directions.RIGHT,howMuch);
        center.moveRight(howMuch);
    }

    @Override
    public void moveLeft(int howMuch) throws PointOutOfBound, CircleOutOfBound {
        validateMove(Directions.LEFT,howMuch);
        center.moveLeft(howMuch);
    }

    private boolean isInBounds(int radius, MovablePoint center) {
        return radius + center.getX() <= Movable.PLAIN_X_MAX && center.getX() - radius >= Movable.PLAIN_X_MIN &&
                radius + center.getY() <= Movable.PLAIN_Y_MAX && center.getY() - radius >= Movable.PLAIN_Y_MIN;
    }

    private void validateMove(Directions direction) throws CircleOutOfBound {
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

    private void validateMove(Directions direction, int howMuch) throws CircleOutOfBound {
        switch (direction) {
            case UP: {
                if (center.getY() + radius + howMuch > Movable.PLAIN_Y_MAX) {
                    throw new CircleOutOfBound(radiusMessageError);
                }
                break;
            }
            case DOWN: {
                if (center.getY() - radius - howMuch < Movable.PLAIN_Y_MIN){
                    throw new CircleOutOfBound(radiusMessageError);
                }
            }
            case LEFT: {
                if (center.getX() - radius - howMuch < Movable.PLAIN_X_MIN){
                    throw new CircleOutOfBound(radiusMessageError);
                }
            }
            case RIGHT: {
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
