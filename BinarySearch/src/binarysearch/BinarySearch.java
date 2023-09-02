package binarysearch;

/**
 *
 * @author DatDDCE171299
 */
import java.util.Scanner;

public class BinarySearch {

    private static int value; // Create an variable that store user searching value    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in); // Create an instance from Scanner class
        Algorithm algo; // Create an instance from Algorithm class

        /*Validate user input*/
        while (true) { // Make sure user input is valid for array size
            try {
                System.out.println("Enter number of array:");
                // Generate a sorted random integer array with user inputted size                
                algo = new Algorithm(Integer.parseInt(input.nextLine()));
                break;
            } catch (NumberFormatException nfe) { // Throw when the array size is non-numerical
                System.out.println("The array size must be a positive integer!");
            } catch (Exception e) { // Throw when the array size is out of range
                System.out.println(e.getMessage());
            }
        }

        while (true) { // Make sure the user input is valid for searching value
            try {
                System.out.println("Enter search value:");
                // Assign a value for searching
                value = Integer.parseInt(input.nextLine());                
                break;
            } catch (NumberFormatException nfe) { // Throw when value inputted is non-numerical
                System.out.println("The value must be an integer!");
            } 
        }

        /*Output section*/        
        System.out.print("Sorted array: ");
        System.out.println(algo.toString()); // Print the sorted array

        // Có khi do hàng dưới ko nhỉ
        // có thể do thế mà thầy bắt
        int index = algo.search(value); // Create an variable to store found array index

        if (index == -1) { // Print when no desired value is found in the array
            System.out.println("There is no value of " + value + " in the array");
        } else { // Print element index of the desired value in the array
            System.out.println("Found " + value + " at index: " + index);
        }
    }
}
