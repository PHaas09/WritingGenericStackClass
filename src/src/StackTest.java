/**
 * Simple test class for the generic Stack.
 * Uses line comments to explain each test scenario.
 */
public class StackTest {

    public static void main(String[] args) {

        // -------------------------
        // Test 1: Integer stack
        // -------------------------
        System.out.println("=== Integer Stack Test ===");

        // Create a stack with capacity 3 using the "attribute fields" constructor.
        Stack<Integer> intStack = new Stack<>(new Object[3], 0);

        // Push a few numbers
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);

        // List should show bottom-to-top order: 10;20;30
        System.out.println("List: " + intStack.list());

        // Peek should return 30 but not remove it
        System.out.println("Peek: " + intStack.peek());
        System.out.println("After peek, list: " + intStack.list());

        // Pushing now should throw StackFullException
        try {
            intStack.push(40);
            System.out.println("ERROR: expected StackFullException was not thrown.");
        } catch (StackFullException ex) {
            System.out.println("Caught expected StackFullException: " + ex.getMessage());
        }

        // Pop all elements (should be LIFO: 30, 20, 10)
        System.out.println("Pop: " + intStack.pop());
        System.out.println("Pop: " + intStack.pop());
        System.out.println("Pop: " + intStack.pop());

        // Stack is now empty; pop should throw StackEmptyException
        try {
            intStack.pop();
            System.out.println("ERROR: expected StackEmptyException was not thrown.");
        } catch (StackEmptyException ex) {
            System.out.println("Caught expected StackEmptyException: " + ex.getMessage());
        }

        // Peek on empty should also throw
        try {
            intStack.peek();
            System.out.println("ERROR: expected StackEmptyException was not thrown.");
        } catch (StackEmptyException ex) {
            System.out.println("Caught expected StackEmptyException (peek): " + ex.getMessage());
        }


        // -------------------------
        // Test 2: String stack
        // -------------------------
        System.out.println("\n=== String Stack Test ===");

        // Use the no-arg constructor (default capacity 10)
        Stack<String> textStack = new Stack<>();

        // Push some words
        textStack.push("Hello");
        textStack.push("World");
        textStack.push("Stack");

        // Verify list formatting and order: Hello;World;Stack
        System.out.println("List: " + textStack.list());

        // Pop one element and verify it was removed
        System.out.println("Pop: " + textStack.pop());
        System.out.println("After pop, list: " + textStack.list());

        // Push another word and verify LIFO behavior
        textStack.push("Again");
        System.out.println("Peek: " + textStack.peek());
        System.out.println("Final list: " + textStack.list());

        System.out.println("\nAll tests completed.");
    }
}
