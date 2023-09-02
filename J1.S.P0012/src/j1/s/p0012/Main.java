package j1.s.p0012;

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

        Scanner input = new Scanner(System.in); // Create an object from Scanner class
        gui = new GUI(); // Initialize object from GUI class

        // Loop until user choose Exit
        while (true) {
            int choice; // Store user choice

            // Choice input
            do {
                gui.menu(); // Print main menu
                try {
                    // Input and validate choice
                    choice = Validation.checkRange(input.nextInt(), 1, 5);
                    input.nextLine();

                    break;
                } catch (NumberFormatException nfe) { // Throw when user input is out of range
                    System.out.println("Please enter from 1 to 5!");
                    input.nextLine();
                } catch (Exception e) { // Throw when user input is non-numerical
                    System.out.println("Please enter from 1 to 5!");
                    input.nextLine();
                }
            } while (true);

            // Task operating section
            switch (choice) {
                case 1:
                    // Add new doctor's data
                    gui.addDoctor();
                    break;

                case 2:
                    // Update current doctor's data with given code
                    gui.updateDoctor();
                    break;

                case 3:
                    // Delete current doctor's data with given code
                    gui.deleteDoctor();
                    break;

                case 4:
                    // Search doctor's data using given information text
                    gui.searchDoctor();
                    break;

                case 5:
                    // Exit the program
                    System.out.println("THANKS FOR USING THE PROGRAM!");
                    return;
            }
        }

    }

}
