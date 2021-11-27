package moving;

import exceptions.CircleOutOfBound;
import exceptions.PointOutOfBound;

/**
 * Specifies that a geometric form is movable in a 2D plain.
 */
public interface Movable {

    int PLAIN_X_MAX = 1000;
    int PLAIN_Y_MAX = 1000;
    int PLAIN_X_MIN = -1000;
    int PLAIN_Y_MIN = -1000;

    /**
     * Moves the form up in the plain. The implementation should take care of
     * how much will this movement be.
     */
    void moveUp() throws PointOutOfBound, CircleOutOfBound;

    /**
     * Moves the form down in the plain. The implementation should take care of
     * how much will this movement be.
     */
    void moveDown() throws PointOutOfBound, CircleOutOfBound;

    /**
     * Moves the form left in the plain. The implementation should take care of
     * how much will this movement be.
     */
    void moveLeft() throws PointOutOfBound, CircleOutOfBound;

    /**
     * Moves the form right in the plain. The implementation should take care of
     * how much will this movement be.
     */
    void moveRight() throws PointOutOfBound, CircleOutOfBound;

    /**
     * Moves the form up in the plain with the specified number of points.
     *
     * @param distance
     *            the number of points to move up in the plain
     */
    void moveUp(int distance) throws PointOutOfBound, CircleOutOfBound;

    /**
     * Moves the form down in the plain with the specified number of points.
     *
     * @param distance
     *            the number of points to move down in the plain
     */
    void moveDown(int distance) throws PointOutOfBound, CircleOutOfBound;

    /**
     * Moves the form left in the plain with the specified number of points.
     *
     * @param distance
     *            the number of points to move left in the plain
     */
    void moveLeft(int distance) throws PointOutOfBound, CircleOutOfBound;

    /**
     * Moves the form right in the plain with the specified number of points.
     *
     * @param distance
     *            the number of points to move right in the plain
     */
    void moveRight(int distance) throws PointOutOfBound, CircleOutOfBound;
}
