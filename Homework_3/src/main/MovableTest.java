package main;

import exceptions.CircleOutOfBound;
import exceptions.OutOfBound;
import exceptions.PointOutOfBound;
import exceptions.RuntimeOutOfBound;
import moving.MovableCircle;
import moving.MovablePoint;

public class MovableTest {
    public static void main(String[] args) {
        try{
            MovablePoint point = new MovablePoint(2, 3, 1, 1);
            System.out.println(point);

            MovableCircle circle2 = new MovableCircle(point,555);
            System.out.println(circle2);

            MovableCircle circle = new MovableCircle(5, 5, 3, 25, 995);
            System.out.println(circle);

            point.moveLeft();
            point.moveUp();
            System.out.println(point);

            circle.moveRight(2);
            circle.moveDown(222);
            System.out.println(circle);
        } catch (PointOutOfBound | CircleOutOfBound e){
            e.printStackTrace();
        }
    }
}
