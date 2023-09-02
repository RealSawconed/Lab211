/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Minh Nhat
 */
import java.util.Scanner;
import java.util.Random;

public class InsertionSort {

    private static int numElements; //Stores the number of elements

    /**
     * declares an array of integers named "arr".
     */
    private int[] arr; //An array to store the elements
    
    /**
     * Constructor to initialize the number of elements in the array. 
     * Sets the size of the array to "num"
     *
     * @param numElements the number of elements in the array
     */
    public InsertionSort(int numElements) {
        arr = new int[numElements];
    }
    /**
     * Method to generate random elements for the array.
     * Sets each element in the array to a random number between 0 and 100
     * Throw an Exception if the input is not valid positive number
     */
    public void generateRandomElements() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        while (true) {
            try {
                numElements = Integer.parseInt(sc.nextLine().trim());
                if (numElements < 0) {
                    System.out.println("Number of elements cannot be negative. Please input again: ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please input again: ");
            }
        }
        arr = new int[numElements]; //Takes the number of elements from the user and stores it in numElements
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100); //Generates random numbers and stores them in arr.
        }
    }
    /**
     * Method to sort the elements in the array using the Insertion Sort algorithm.
     * Insertion sort iterates, consuming one input element each repetition, and grows a sorted output list.
     * This process is repeated until the array is sorted in ascending order.
     */
    public void insertionSort() {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    /**
     * Method to print the array. 
     * Prints each element in the array separated by a comma
     * With the exception of the last element, which is not followed by a comma
     * @return 
     */
    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < arr.length - 1; i++) {
            result += arr[i] + ", ";
        }
        result += arr[arr.length - 1] + "]";
        return result;
    }
    
    /**
     * Main method to test the Insertion Sort algorithm.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        InsertionSort is = new InsertionSort(numElements);
        is.generateRandomElements();
        System.out.println("Unsorted array: " + is.toString());
        is.insertionSort();
        System.out.println("Sorted array: " + is.toString());
    }
}
