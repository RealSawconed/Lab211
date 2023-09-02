package insertionsort;

/**
 *
 * @author DatDDCE171299
 */
import java.util.Scanner;

public class InsertionSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in); // Create an instance from Scanner class
        Algorithm algo; // Create an instance from Algorithm class

        /*Validate user input*/
        while (true) { // Make sure the user input is valid
            try {
                System.out.println("Enter number of array: ");
                // Create an array of random integer elements with inpput value
                algo = new Algorithm(Integer.parseInt(input.nextLine()));
                // Break when the user input is valid
                break;
            } catch (NumberFormatException nfe) { // Throw when input value is non-numerical
                System.out.println("The array size must be a positive integer!");
            } catch (Exception e) { // Throw when the input value is out of range
                System.out.println(e.getMessage());
            }
        }

        /*Output section*/
        System.out.print("Unsorted array: ");
        // Print the unsorted array
        System.out.println(algo.toString());

        // Sort the array
        algo.sort();
        System.out.print("Sorted array: ");
        // Print the sorted array
        System.out.print(algo.toString());
    }

}
