package j1.s.p0009;

import java.util.Scanner;

/**
 *
 * @author DatDDCE171299
 */
public class Main {

    private static GUI gui; // Create an object from GUI class

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in); // Create an object fomr Scanner class

        // Loop until user to Exit
        while (true) {
            gui = new GUI(); // Initialize object from GUI class

            gui.menu(); // Print main menu
            int choice = 0; // Store user choice

            /*Choice input*/
            do { // Make sure user input is valid
                System.out.print("Please choice one option: ");
                try {
                    // Input and validate input
                    choice = Validation.checkRange(input.nextInt(), 1, 3);
                    input.nextLine();

                    break;
                } catch (NumberFormatException nfe) { // Throw when user input is out of range
                    System.out.println(nfe.getMessage());
                    input.nextLine();
                } catch (Exception e) { // Throw when user input is non-numerical
                    System.out.println("Please enter integer from 1 to 3!");
                    input.nextLine();
                }
            } while (true);

            // Task execute section
            switch (choice) {
                case 1: // Calculate mathematic value
                    gui.getCalculation();
                    break;

                case 2: // Calculate BMI value
                    gui.getBMICalculation();
                    break;

                case 3: // Exit the program
                    System.out.println("========= Thanks for using the program =========");
                    return;
            }
        }
    }

}
