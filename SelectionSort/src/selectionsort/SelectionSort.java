package selectionsort;

/**
 *
 * @author DatDDCE171299
 */
import java.util.Scanner;

public class SelectionSort {

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
                // Set the size of the array
                algo = new Algorithm(Integer.parseInt(input.nextLine()));
                // Break when user input is valid
                break;
            } catch (NumberFormatException nfe) {
                // Throw when the user input is non-numerical
                System.out.println("The array size must be a positive integer!");
            } catch (Exception e) {
                // Throw when the number inputted is out of range
                System.out.println(e.getMessage());
            }
        }

        /*Print output*/
        System.out.print("Unsorted array: ");
        System.out.println(algo.toString()); // Print the unsorted array   

        algo.sort(); // Sort the array
        System.out.print("Sorted array: ");
        System.out.print(algo.toString()); // Print the sorted array
    }

}
