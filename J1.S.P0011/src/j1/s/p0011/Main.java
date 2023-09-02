package j1.s.p0011;

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

        //Loop until user choose exit
        while (true) {
            int choice; // Store user choice
            do {
                gui.menu();
                try {
                    // Input and validate choice
                    choice = Validation.checkRange(input.nextInt(), 1, 4);
                    input.nextLine();

                    break;
                } catch (NumberFormatException nfe) { // Throw when choice is out of range
                    System.out.println("Please enter integer from 1 to 4!");
                    input.nextLine();
                } catch (Exception e) { // Throw when choice is non-numerical
                    System.out.println("Please enter integer from 1 to 4!");
                    input.nextLine();
                }
            } while (true);

            // Task operating session
            switch (choice) {
                case 1:
                    // Add new contact with given information
                    gui.addContact();
                    System.out.println();
                    break;

                case 2:
                    // Display all contact information
                    gui.displayAll("################################### Display all Contact ###################################");
                    System.out.println();
                    break;

                case 3:
                    // Delete contact with given ID
                    gui.deleteContact();
                    System.out.println();
                    break;

                case 4:
                    // Exit the program
                    System.out.println("Thanks for using the program!");
                    return;
            }
        }
    }

}
