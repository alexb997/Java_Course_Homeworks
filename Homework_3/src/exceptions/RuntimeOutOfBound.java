package exceptions;

public class RuntimeOutOfBound extends RuntimeException{
    public RuntimeOutOfBound(String message, Exception cause) {
        super(message, cause);
    }
}
