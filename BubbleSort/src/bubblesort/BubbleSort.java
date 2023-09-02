package bubblesort;

/**
 *
 * @author DatDDCE171299
 */
import java.util.Scanner;

public class BubbleSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner input = new Scanner(System.in); // Create an instance from Scanner class
        Algorithm algo = new Algorithm(); // Create an instance from Algorithm class

        /*Validate user input*/
        while (true) { // Makes sure the user input is valid
            try {
                System.out.println("Enter number of array: ");
                // Set the size for array
                algo.setSize(Integer.parseInt(input.nextLine()));
                // Break when user input is valid
                break;
            } catch (NumberFormatException nfe) {
                // Throw exception when user input is non-numerical
                System.out.println("The array size must be a positive integer!");
            } catch (Exception e) {
                // Throw when number inputted is out of rangei
                System.out.println(e.getMessage());
            }
        }

        /*Print output*/
        algo.generateArray(); // Generate a random array of integer
        System.out.print("Unsorted array: ");
        algo.printArray(); // Print the unsorted array
        System.out.println();

        algo.sort(); //Sort the array
        System.out.print("Sorted array: ");
        algo.printArray(); // Print the sorted array
    }

}
