package j1.s.p0007;

import java.util.Scanner;

/**
 *
 * @author DatDDCE171299
 */
public class J1SP0007 {

    private static LinearSearch ls;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here  
        Scanner input = new Scanner(System.in); // Create an object from Scanner class

        /*Input array length*/
        while (true) { // Make sure user input is valid
            try {
                System.out.println("Enter number of array: ");
                // Input and validate number of element
                ls = new LinearSearch(input.nextInt());
                input.nextLine();
                break;
            } catch (IllegalArgumentException iae) { // Throw when user input is out of range
                System.out.println(iae.getMessage());
            } catch (Exception e) { // Throw when user input is non-numerical
                System.out.println("Please enter positive integer only!");
                input.nextLine();
            }
        }

        /*Search value*/
        while (true) { // Make sure user input is valid
            try {
                System.out.println("Enter search value: ");
                // Input and validate value
                ls.setValue(Integer.parseInt(input.nextLine()));
                // Assign search index into temporariy variable
                int index = ls.search(ls.getValue());

                // Print the array
                System.out.println("The array: " + ls);
                // Print search result
                if (index == -1) {
                    System.out.println(ls.getValue() + " is not found in the list!");
                } else {
                    System.out.println("Found " + ls.getValue() + " at index: " + index);
                }
                break;
            } catch (Exception e) { // Throw when user input is non-numerical
                System.out.println("Please enter integer only!");
            }
        }
    }

}
