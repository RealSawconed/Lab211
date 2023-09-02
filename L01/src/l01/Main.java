package l01;

import java.util.Scanner;

/**
 *
 * @author DatDDCE171299
 */
public class Main {

    public static Management mnt; // Create a object to manage data

    public static void main(String[] args) {
        Scanner menuSelection = new Scanner(System.in); // Create an instance of Scanner class
        mnt = new Management(); // Initialize object of Management class
        while (true) { // Loop until user choose Exit
            try {
                // Print main menu
                System.out.println("   CANDIDATE MANAGEMENT SYSTEM");
                System.out.println("1. Experience");
                System.out.println("2. Fresher");
                System.out.println("3. Internship");
                System.out.println("4. Searching");
                System.out.println("5. Exit");
                System.out.print("   Please choose: ");

                // Taking input
                int choice = menuSelection.nextInt();
                menuSelection.nextLine();

                // Implementing choices
                switch (choice) {
                    // Create new candidate data with given type
                    case 1:
                    case 2:
                    case 3:
                        mnt.createCandidate(choice - 1);
                        break;

                    // Search candidate data with given information
                    case 4:
                        mnt.searchCandidate();
                        break;

                    // Exit the program
                    case 5:
                        System.out.println("== Thanks for using the program! == ");
                        return;

                    // Catch invalid input range
                    default:
                        System.out.println("Please enter integer from 1 to 5!\n");
                }
            } catch (Exception e) { // Throw when user input is non-numerical
                System.out.println("Please enter integer from 1 to 5!\n");
                menuSelection.nextLine();
            }
        }
    }

}
