/**
 * Thrown when trying to pop/peek from an empty stack.
 */
public class StackEmptyException extends RuntimeException {

    public StackEmptyException() {
        super("Stack is empty.");
    }

    public StackEmptyException(String message) {
        super(message);
    }
}