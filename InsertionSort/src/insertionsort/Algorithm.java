package insertionsort;

import java.util.Random;

/**
 *
 * @author DatDDCE171299
 */
public class Algorithm {

    private int[] arr; // Create a property that store an array

    /**
     * Create a constructor that generate an array with given size
     *
     * @param arrSize
     * @throws Exception
     */
    public Algorithm(int arrSize) throws Exception {
        if (arrSize <= 0) { //Throw when the number inputted is less than or equals to 0
            throw new Exception("The array size must be a positive integer!");
        } else {
            arr = new int[arrSize]; // Create an array with given size
            generateArray(arrSize); // Generate an array of random integer elements
        }
    }

    /**
     * Generate an array with random integer elements
     *
     * @param arrSize
     */
    public void generateArray(int arrSize) {
        Random rand = new Random(); // Create an instance from Random class

        for (int index = 0; index < arr.length; index++) {
            // Initialize each elements with a random integer
            arr[index] = rand.nextInt(100);
        }
    }

    /**
     * Sort the array using insertion sort algorithm
     */
    public void sort() {
        int element;
        // Traverse through the whole array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Hold the current element to compare with other previous elements
            element = arr[i];
            // Comparing current element with previous element
            for (int j = i - 1; j >= 0; j--) {
                if (element < arr[j]) {
                    // Swap when current element is less than the previous element
                    swap(j + 1, j);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Swap two array elements using index
     *
     * @param firstIdx
     * @param secondIdx
     */
    public void swap(int firstIdx, int secondIdx) {
        int temp = arr[firstIdx]; // Create temporary variable to store first element
        arr[firstIdx] = arr[secondIdx]; // Assign second element to first element
        arr[secondIdx] = temp; // Assign second element with previous temporary value
    }

    /**
     * Print the array
     *
     * @return
     */
    @Override
    public String toString() {
        String s = "[" + arr[0]; // Print the first element

        // Print the rest of the array
        for (int index = 1; index < arr.length; index++) {
            s += ", " + arr[index];
        }
        s += "]";

        return s;
    }
}
