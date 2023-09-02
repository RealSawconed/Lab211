package selectionsort;

import java.util.Random;

/**
 *
 * @author DatDDCE171299
 */
public class Algorithm {

    private int[] arr; // Create a property that stores array elements

    /**
     * Create a constructor that store given array size
     *
     * @param arrSize
     * @throws Exception
     */
    public Algorithm(int arrSize) throws Exception {
        if (arrSize <= 0) { // Throw when given input is less than or equals to 0
            throw new Exception("The array size must be a positive integer!");
        } else {
            // Generates array with given size
            arr = new int[arrSize];
            // Generate random elements for array
            generateArray(arrSize);
        }
    }

    /**
     * Generate random array of integer with given size
     *
     * @param arrSize
     */
    public void generateArray(int arrSize) {
        Random rand = new Random(); // Create an instance from Random class

        for (int index = 0; index < arrSize; index++) {
            arr[index] = rand.nextInt(10); // Initialize array elements with random number
        }
    }

    /**
     * Sort the array using selection sort algorithm
     */
    public void sort() {
        // Stop the process when the last index is targetted
        for (int i = 0; i < arr.length - 1; i++) {
            // Traverse through array starting from the above index 
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    // Swap if the first element is greater then the second element
                    swap(i, j);
                }
            }
        }
    }

    /**
     * Swap two array elements using indexes
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
        String s = "[" + arr[0]; // Print the first element of the array

        // Print the rest of the array
        for (int index = 1; index < arr.length; index++) {
            s += ", " + arr[index];
        }
        s += "]";

        return s;
    }
}
