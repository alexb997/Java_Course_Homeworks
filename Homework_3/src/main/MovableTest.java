package main;

import exceptions.CircleOutOfBound;
import exceptions.PointOutOfBound;
import moving.MovableCircle;
import moving.MovablePoint;

public class MovableTest {
    public static void main(String[] args) {
        try{
            MovablePoint point = new MovablePoint(2, 3, 1, 1);
            System.out.println(point);

            MovableCircle circle = new MovableCircle(5, 5, 3, 1, -5);
            System.out.println(circle);

            point.moveLeft();
            point.moveUp(3);
            System.out.println(point);

            circle.moveRight(2);
            circle.moveDown(5221222);
            System.out.println(circle);
        } catch (PointOutOfBound | CircleOutOfBound e){
            e.printStackTrace();
        }
    }
}
