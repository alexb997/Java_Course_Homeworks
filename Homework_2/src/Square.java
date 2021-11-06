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
        return "A Square with side=" + super.getWidth() +
                ", which is a subclass of " + super.toString();
    }

    /*
    -do you need to override the getArea() and getPerimeter() methods?

    If you override the methods please leave comments in the methods why you chose to override them,

    otherwise leave a comment in class why they shouldn't be overriden.

    Here as the programmer that wrote them, i know how the methods getArea() and getPerimeter()
        work and what parameters needs, but for a user or another programmer the logic would dictate
        that the getArea() and getPerimeter methods for this class would need just side as parameter.
        So a override for this method would be needed since it's more intuitive and user friendly.
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
