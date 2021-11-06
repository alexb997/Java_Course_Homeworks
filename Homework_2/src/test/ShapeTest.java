package test;

import forms.Circle;
import forms.Rectangle;
import shape.Shape;

public class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape.toString());
        shape.setColor("red");
        shape.setFilled(false);
        System.out.println(shape.toString());
        shape = new Shape("red",true);
        System.out.println(shape.toString());
        Circle circle = new Circle();
        System.out.println(circle.toString());
        circle.setRadius(2.0);
        System.out.println(circle.toString());
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
        circle = new Circle("purple",true,2.0);
        System.out.println(circle.toString());
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle.toString());
        rectangle.setLength(2.2);
        rectangle.setWidth(1.1);
        rectangle.setColor("black");
        System.out.println(rectangle.toString());
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());
    }
}
