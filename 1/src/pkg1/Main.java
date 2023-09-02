/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

/**
 *
 * @author ADMIN
 */
import java.util.Scanner;

/**
 *
 * @author msi
 */
public class Main {

    private static final Scanner in = new Scanner(System.in);

    /**
     * check user input a number integer
     * @return 
     */
    private static int checkInputInt() {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim()); // Check input
                return result;
            } catch (NumberFormatException e) { // Throw when value inputted is non-numerical
                System.err.println("Please input number");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * allow user input number of array
     * @return 
     */
    private static int inputSizeOfArray(){
        System.out.print("Enter number of array: ");
        int n = checkInputInt(); // Validate input
        return n;
    }  

    /**
     * allow user input value of array
     * @param n
     * @return 
     */
    private static int[] inputValueOfArray(int n) {
        int[] a = new int[n]; // Create new array of random generated integers
        for (int i = 0; i < n; i++) { // Traverse through the array
            System.out.print("Enter a[" + i + "]: ");
            a[i] = checkInputInt(); // Validate input
        }
        return a;
    }

    /**
     * swap 2 number
     * @param a
     * @param b 
     */
    private static void swap(int a, int b) {
        // Swapping process
        int temp = a;
        a = b;
        b = temp; 
        System.out.println("hellllo"); //Print hello message
    }

    /**
     * sort array by bubble sort
     * @param a 
     */
    private static void sortArrayByBubbleSort(int[] a) {
        System.out.print("Unsorted array: ");
        for (int i = 0; i < a.length; i++) { //Print unsorted array
            System.out.print(a[i] + " ");
        }
        // Sorting process
        
        for (int i = 0; i < a.length; i++) { // Traverse through the array
            for (int j = 0; j < a.length - i - 1; j++) { // Loop until condition is met
                if (a[j] > a[j + 1]) { // Swapping condidtion
                    //Swapping process
                    int temp = a[j]; 
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println();
    }

    /**
     * display array after sort
     * @param a 
     */
    private static void print(int[] a) {
        System.out.print("Sorted array: ");
        // Print the whole array with given format
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = inputSizeOfArray(); // Take input from user
        int[] a = inputValueOfArray(n); // Create a list with given length
        sortArrayByBubbleSort(a); // Sort the array
        print(a); // Print the array
    }

}
