package forms;

public class Circle extends Shape {
    private double radius;

    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        double radius = this.getRadius();
        return Math.PI * (radius * radius);
    }

    public double getPerimeter(){
        double radius = this.getRadius();
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "A forms.Circle with radius " + this.radius + ", which is a subclass of " + super.toString();
    }
}
