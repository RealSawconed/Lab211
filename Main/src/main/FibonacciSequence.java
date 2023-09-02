package main;

/**
 *
 * @author DatDDCE171299
 */
public class FibonacciSequence {

    private int size; // Create a property that store sequence size

    /**
     * Create an empty constructor
     */
    public FibonacciSequence() {
    }

    /**
     * Create a constructor that stores sequence size
     *
     * @param size
     * @throws Exception
     */
    public FibonacciSequence(int size) throws Exception {
        setSize(size); // Set size for the sequence
    }

    /**
     * Get the size of the sequence
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Set the size for the sequence
     *
     * @param size
     * @throws Exception
     */
    public void setSize(int size) throws Exception {
        if (size <= 0) { // Throw when the inputted size is less than or equals to 0
            throw new Exception("The sequence size must be a positive integer!");
        }

        // Assign the size value
        this.size = size;
    }

    /**
     * Get the Fibonacci number at given index
     *
     * @param n
     * @return
     */
    public int getFibonacci(int n) {
        if (n < 2) { // Return value of 1 as the second number
            return n;
        }
        // Return value of index-given number with recursion
        return getFibonacci(n - 2) + getFibonacci(n - 1);
    }

    /**
     * Print the Fibonacci sequence
     *
     * @return
     */
    @Override
    public String toString() {
        String s = "" + getFibonacci(0); // Print the first number 
        for (int i = 1; i < size; i++) {
            s += ", " + getFibonacci(i); // Print the rest of the sequence
        }

        return s;
    }
}
