package shape;

public class Shape {
    private String color;
    private boolean filled;

    public Shape(){
        this.color="green";
        this.filled=true;
    }

    public Shape(String color,boolean filled){
        this.color=color;
        this.filled=filled;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "A shape.Shape with color of " + this.color + (this.filled ? " and filled" : " and not filled");
    }
}