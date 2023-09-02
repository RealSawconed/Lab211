package main;

/**
 *
 * @author DatDDCE171299
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FibonacciSequence f = new FibonacciSequence(); // Create an instance of FibonacciSequence class

        /*Validate user input*/
        try { // Make sure the user input is valid
            f.setSize(45); // Set the size of sequence

            // Print the Fibonacci sequence
            System.out.println(f);
        } catch (NumberFormatException nfe) { // Throw when the user input is non-numerical
            System.out.println("The sequence size must be a positive integer!");
        } catch (Exception e) { // Throw when the user input is out of range
            System.out.println(e.getMessage());
        }        
    }

}
