package binarysearch;

import java.util.Random;
import java.util.Arrays;

/**
 *
 * @author DatDDCE171299
 */
public class Algorithm {

    private int[] arr; // Create a property that store integer array 

    /**
     * Create a sorted random integer array with the given size
     *
     * @param arrSize
     * @throws Exception
     */
    public Algorithm(int arrSize) throws Exception {
        if (arrSize <= 0) { // Throw when the array size is out of range
            throw new Exception("The array size must be a positive integer!");
        }

        // Initialize a size for the array
        arr = new int[arrSize];
        // Generate the random integer array
        generateArray();
        // Sort the array
        Arrays.sort(arr);
    }

    /**
     * Generate a random integer array
     */
    public void generateArray() {
        Random rand = new Random(); // Create an instance from Random class

        for (int index = 0; index < arr.length; index++) {
            // Initialize random integers for array elements
            arr[index] = rand.nextInt();
        }
    }   

    /**
     * Search user inputted value using binary search algorithm
     *
     * @param value
     * @return
     */
    public int search(int value) {
        // Create variable that store head and tail indexes for searching
        int headIdx = 0, tailIdx = arr.length - 1;

        // Loop until head index is greater then tail index
        while (headIdx <= tailIdx) {
            // Get the middle index of the array
            int targetIdx = (headIdx + tailIdx) / 2;

            // Return value index when the desired value is found
            if (arr[targetIdx] == value) { 
                return targetIdx;
            }
            // Change array searching range
            if (arr[targetIdx] < value) { // Middle element is less than user value
                // Head index start after the middle index
                headIdx = targetIdx + 1;
            } else { // Middle element is greater than user value
                // Tail index end before the middle index
                tailIdx = targetIdx - 1;
            }
        }

        // Return when no desired value is found in the array
        return -1;
    }

    /**
     * Print the array
     * @return 
     */
    @Override
    public String toString() {
        String s = "[" + arr[0]; // Print the first element of the array

        // Print the rest of the array elements
        for (int index = 1; index < arr.length; index++) {
            s += ", " + arr[index];
        }
        s += "]";

        return s;
    }

    
    /**
     * Check invalid range value input
     *
     * @param value
     * @throws Exception
     */
    private static void valueValidator(int value) throws Exception {
        if (value < 0) { // Throw when the inputted value is out of range
            throw new Exception("The value must be a positive integer!");
        }
    }
    
    /**
     * Sort the array using bubble sort algorithm
     */
    /*
    public void sort() {
        int remain = arr.length; // Store the size of the array
        while (remain >= 2) { // Loop until one element is left to compare
            for (int index = 0; index < arr.length - 1; index++) {
                // Swap if the first element is greater than the second element
                if (arr[index] > arr[index + 1]) {
                    swap(index, index + 1);
                }
            }
            remain--; // Decrease the size of the array for comparison
        }
    } */
    
    /**
     * Swap two array elements with using index
     *
     * @param firstIdx
     * @param secondIdx
     */
    /*
    public void swap(int firstIdx, int secondIdx) {
        int temp = arr[firstIdx]; // Create temporary variable to store first element
        arr[firstIdx] = arr[secondIdx]; // Assign second element to first element
        arr[secondIdx] = temp; // Assign second element with previous temporary value
    }*/
}
