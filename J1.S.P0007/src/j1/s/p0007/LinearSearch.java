package j1.s.p0007;

import java.util.Random;

/**
 *
 * @author DatDDCE171299
 */
public class LinearSearch {

    private int[] arr; // Store array of integer with given length
    private int value; // Store searching value

    /**
     * Get value to display
     *
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * Set value for searching
     *
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Create a constructor that generate random integer array with given length
     *
     * @param length
     */
    public LinearSearch(int length) {
        if (length < 1) { // Throw when length inputted is less than 1
            throw new IllegalArgumentException("Please enter positive integer only!");
        }

        // Generate array of random integers
        generateNumber(length);
    }

    /**
     * Generate an array of random integers with given length
     *
     * @param length
     */
    private void generateNumber(int length) {
        Random rand = new Random(); // Create an instance of Random class
        arr = new int[length]; // Initialize an array with given length

        // Assign each array element with a random integer
        for (int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(11);
        }
    }

    /**
     * Return the index of searching value using linear search algorithm
     *
     * @param value
     * @return
     */
    public int search(int value) {
        // Return index if found        
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                return i;
            }
        }

        // Return -1 if value is not found
        return -1;
    }

    /**
     * Display array
     *
     * @return
     */
    @Override
    public String toString() {
        // Display the first element
        String s = "[" + arr[0];
        // Display the rest of the array elements
        for (int i = 1; i < arr.length; i++) {
            s += ", " + arr[i];
        }
        s += "]";

        return s;
    }
}
