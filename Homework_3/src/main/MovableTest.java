package main;

import moving.MovableCircle;
import moving.MovablePoint;

public class MovableTest {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(2,3,1,1);
        System.out.println(point);

        MovableCircle circle = new MovableCircle(5,5,3,1, 3);
        System.out.println(circle);

        point.moveLeft();
        point.moveUp(3);
        System.out.println(point);

        circle.moveRight(2);
        circle.moveDown(521);
        System.out.println(circle);
    }
}
