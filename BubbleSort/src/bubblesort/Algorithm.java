package bubblesort;

/**
 *
 * @author DatDDCE171299
 */
import java.util.Random;

public class Algorithm {

    private int[] arr; // Create a property that store array elements
    private int arrSize; // Create a property that stores array size

    public Algorithm() {
    }

    /**
     * Create a constructor with given size parameter
     *
     * @param size
     */
    public Algorithm(int arrSize) throws Exception {
        setSize(arrSize); // Initialize value for array size
    }

    /**
     * Set size for array
     *
     * @param arrSize
     * @throws Exception
     */
    public void setSize(int arrSize) throws Exception {
        if (arrSize <= 0) { // Throw when number inputted is less than or equals to 0
            throw new Exception("The array size must be a positive integer!");
        }
        this.arrSize = arrSize; // Initialize value for array size
    }

    /**
     * Get size from array
     *
     * @return
     */
    public int getSize() {
        return arrSize;
    }

    /**
     * Generate a random integer array with given size
     *
     * @param arrSize
     */
    public void generateArray() {
        Random rand = new Random(); // Create an instance from Random class
        arr = new int[this.arrSize]; // Set the size of the array from user input

        for (int i = 0; i < arr.length; i++) {
            // Initialize array elements with random number within given range
            arr[i] = rand.nextInt(100);
        }
    }

    /**
     * Print out the array
     */
    public void printArray() {
        System.out.print("[" + arr[0]); // Print the first element of the array
        for (int index = 1; index < arr.length; index++) {
            // Print the remaining elements of the array
            System.out.print(", " + arr[index]);
        }
        System.out.print("]");
    }

    /**
     * Sort the array with bubble sort algorithm
     */
    public void sort() {
        int remain = arr.length; // Store the size of the array
        while (remain >= 2) { // Loop until one element is left to compare
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) // Swap if the first element is greater then the second elements
                {
                    swap(i, i + 1);
                }
            }
            remain--; // Decrease the size of the array for comparison
        }
    }

    /**
     * Swap two elements from an array with two given index
     *
     * @param arr
     * @param firstIdx
     * @param secondIdx
     */
    public void swap(int firstIdx, int secondIdx) {
        int temp = arr[firstIdx]; // Create temporary variable to store first element
        arr[firstIdx] = arr[secondIdx]; // Assign second element to first element
        arr[secondIdx] = temp; // Assign second element with previous temporary value
    }

}
