package exceptions;

public class CircleOutOfBound extends RuntimeException{
    public CircleOutOfBound(String message, Exception cause) {
        super(message, cause);
    }
}
