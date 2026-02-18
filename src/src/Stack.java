/**
 * A generic LIFO (Last-In-First-Out) stack implementation using an array.
 *
 * @param <T> the element type stored in the stack
 */
public class Stack<T> {

    /** Internal storage (must be Object[] because Java cannot create generic arrays). */
    private Object[] elements;

    /** Number of elements currently stored. */
    private int size;

    /**
     * Creates a stack with a default capacity of 10.
     */
    public Stack() {
        this.elements = new Object[10];
        this.size = 0;
    }

    /**
     * Creates a stack using the given attribute fields.
     * NOTE: This constructor matches the requirement "attribute fields as parameters".
     *
     * @param elements the backing array (stored directly)
     * @param size the number of valid elements currently in the stack
     * @throws IllegalArgumentException if arguments are inconsistent
     */
    public Stack(Object[] elements, int size) {
        if (elements == null) {
            throw new IllegalArgumentException("elements must not be null");
        }
        if (size < 0 || size > elements.length) {
            throw new IllegalArgumentException("size must be between 0 and elements.length");
        }
        this.elements = elements;
        this.size = size;
    }

    /**
     * Pushes an element onto the stack.
     *
     * @param value the value to push
     * @throws StackFullException if the stack is already full
     */
    public void push(T value) {
        if (size == elements.length) {
            throw new StackFullException("Cannot push: stack capacity is " + elements.length);
        }
        elements[size] = value;
        size++;
    }

    /**
     * Removes and returns the top element of the stack.
     *
     * @return the element that was on top
     * @throws StackEmptyException if the stack is empty
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) {
            throw new StackEmptyException("Cannot pop: stack is empty");
        }
        size--;
        Object value = elements[size];
        elements[size] = null; // avoid holding references (helps GC)
        return (T) value;
    }

    /**
     * Returns the top element of the stack without removing it.
     *
     * @return the element on top
     * @throws StackEmptyException if the stack is empty
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0) {
            throw new StackEmptyException("Cannot peek: stack is empty");
        }
        return (T) elements[size - 1];
    }

    /**
     * Returns a string containing all stack elements separated by ';'.
     * Elements are listed from bottom (oldest) to top (newest).
     *
     * @return concatenated list of elements separated by ';'
     */
    public String list() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(';');
            }
        }
        return sb.toString();
    }


}
