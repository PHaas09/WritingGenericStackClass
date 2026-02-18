/**
 * Thrown when trying to push onto a full stack.
 */
public class StackFullException extends RuntimeException {

    public StackFullException() {
        super("Stack is full.");
    }

    public StackFullException(String message) {
        super(message);
    }
}
