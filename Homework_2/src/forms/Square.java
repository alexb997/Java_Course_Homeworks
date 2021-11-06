package forms;

import forms.Rectangle;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    public double getSide() {
        return super.getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public String toString() {
        return "A forms.Square with side=" + super.getWidth() +
                ", which is a subclass of " + super.toString();
    }

    /*
    -do you need to override the getArea() and getPerimeter() methods?

    If you override the methods please leave comments in the methods why you chose to override them,
    otherwise leave a comment in class why they shouldn't be overriden.

    They don't need to be overriden since they don't take any parameter and the side setter changes the value
    of length and width at the same time making the getArea() and getPerimeter() methods viable to use.
     */

    @Override
    public void setWidth(double side){
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setLength(double side){
        super.setLength(side);
        super.setWidth(side);
    }
}
