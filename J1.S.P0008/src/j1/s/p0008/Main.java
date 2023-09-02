package j1.s.p0008;

import java.util.Scanner;

/**
 *
 * @author DatDDCE171299
 */
public class Main {

    private static BaseSystem bs; // Create a new object of BaseSystem class    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Create a new instance of Scanner class

        // Loop until user stop using
        while (true) {
            System.out.println("===== BASE VALUE CONVERTER =====");
            bs = new BaseSystem(); // Initialize object from BaseSystem class

            /*Input section*/
            do { // Input base input
                try {
                    System.out.print("Please enter base number input: ");
                    // Input base
                    bs.setInBase(input.nextInt());
                    input.nextLine();

                    break;
                } catch (IllegalArgumentException iae) { // Throw when user input is invalid
                    System.out.println(iae.getMessage());
                    input.nextLine();
                } catch (Exception e) { // Throw when user inpput is non-numerical
                    System.out.println("Please enter only 2, 10 or 16!");
                    input.nextLine();
                }
            } while (true);

            do { // Input base output
                try {
                    System.out.print("Please enter base number output: ");
                    // Base input
                    bs.setOutBase(input.nextInt());
                    input.nextLine();

                    break;
                } catch (IllegalArgumentException iae) {  // Throw when user input is invalid
                    System.out.println(iae.getMessage());
                    input.nextLine();
                } catch (Exception e) { // Throw when user inpput is non-numerical
                    System.out.println("Please enter only 2, 10 or 16!");
                    input.nextLine();
                }
            } while (true);

            do { // Input converted value
                try {
                    System.out.print("Please enter convert value: ");
                    // Input value
                    bs.setValue(input.nextLine());

                    break;
                } catch (IllegalArgumentException iae) { // Throw when user input is invalid
                    System.out.println(iae.getMessage());
                }
            } while (true);

            /*Output section*/
            // Print the initial value
            System.out.print("The value enter: ");
            System.out.printf("(%s)%d\n", bs.getValue(), bs.getInBase());
            // Convert value into given base            
            bs.baseConverter();
            // Print converted value
            System.out.print("The converted value: ");
            System.out.printf("(%s)%d\n", bs.getValue(), bs.getOutBase());

            /*Looping section*/
            do {
                try {
                    System.out.print("Do you want to convert value again [Yes-No]? ");
                    if (!Validation.loopCheck(input.nextLine())) { // Stop the program
                        System.out.println("Thanks for using the program!");
                        return;
                    } else { // Continue program
                        System.out.println();
                        break;
                    }
                } catch (IllegalArgumentException iae) { // Throw when user input is invalid
                    System.out.println(iae.getMessage());
                }
            } while (true);
        }
    }
}
