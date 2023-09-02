package j1.s.p0009;

import java.util.Scanner;

/**
 *
 * @author DatDDCE171299
 */
public class GUI {

    private Calculation calc; // Create an object from Calculation class

    /**
     * Create a default constructor that initialize an object from Calculation
     * class
     */
    public GUI() {
        calc = new Calculation();
    }

    /**
     * Print main menu
     */
    public void menu() {
        System.out.println("========= Calculator Program =========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
    }

    /**
     * Execute mathematic calculating operation
     */
    public void getCalculation() {
        Scanner input = new Scanner(System.in); // Create an object from Scanner class

        System.out.println("----- Normal Calculator -----");
        char operator = '='; // Store operator
        int count = 0; // Keep track of operation flow7

        // Loop until user input '=' character
        do {
            // Input operand            
            do { // Make sure operand is valid
                System.out.print("Enter number: ");
                try {
                    // Input and validate operand
                    calc.setNum(input.nextDouble());
                    input.nextLine();

                    if (count == 0) { // Calculate the first round of calculating operation
                        calc.calculate('+');
                    } else {
                        calc.calculate(operator); // Calculate later calculating operation
                    }

                    break;
                } catch (ArithmeticException ae) { // Throw when user input 0 in division operation
                    System.out.println("Please enter non-zero value for division");
                } catch (Exception e) { // Thow when user input is non-numerical
                    System.out.println("Please enter number only");
                    input.nextLine();
                }
            } while (true);

            // Keep track of final result after second calculating operation is implemented
            if (count != 0) {
                System.out.printf("Memory: %.1f\n", calc.getResult());
            }

            // Input operator
            do {
                System.out.print("Enter Operator: ");
                try {
                    // Input and validate operator
                    operator = Validation.checkOperator(input.nextLine().charAt(0));
                    // Keep track of operation flow
                    ++count;

                    break;
                } catch (IllegalArgumentException iae) { // Throw when user input is non-numerical
                    System.out.println(iae.getMessage());
                }
            } while (true);

            // Stop the operation and display final result when user input '=' character
            if (Character.compare('=', operator) == 0) {
                System.out.printf("Result: %.1f\n\n", calc.getResult());
            }
        } while (Character.compare(operator, '=') != 0);
    }

    /**
     * Execute BMI calculation operation
     */
    public void getBMICalculation() {
        Scanner input = new Scanner(System.in); // Create an object from Scanner class

        System.out.println("----- BMI Calculator -----");
        double bodyWeight, height; // Store body measurement

        // Input body weight value
        do {
            try { // Make sure weight value is valid
                System.out.print("Enter Weight(kg): ");
                // Input and validate body weight value
                bodyWeight = Validation.checkDouble(input.nextDouble());
                input.nextLine();

                break;
            } catch (NumberFormatException nfe) { // Throw whem user input is out of range
                System.out.println("BMI is digit");
                input.nextLine();
            } catch (Exception e) { // Throw when user input is non-numerical
                System.out.println("BMI is digit");
                input.nextLine();
            }
        } while (true);

        // Input body height value
        do {
            try { // Make sure height value is valid
                System.out.print("Enter Height(cm): ");
                // Input and validate body height value
                height = Validation.checkDouble(input.nextDouble());
                input.nextLine();

                break;
            } catch (NumberFormatException nfe) { // Throw whem user input is out of range
                System.out.println("BMI is digit");
                input.nextLine();
            } catch (Exception e) { // Throw when user input is non-numerical
                System.out.println("BMI is digit");
                input.nextLine();
            }
        } while (true);

        // Calculate BMI value with given measurement
        calc.calculateIBM(bodyWeight, height / 100); // Change height input into meter measurement

        double bmi = calc.getResultBMI(); // Store bmi value

        // Print BMI value
        System.out.printf("BMI Number: %.2f\n", bmi);
        // Print body status using pre-calculated BMI value
        System.out.print("BMI Status: ");
        if (bmi < 19) { // Status condition for displaying
            System.out.println("UNDER-STANDARD");
        } else if (bmi >= 19 && bmi < 25) {
            System.out.println("STANDARD");
        } else if (bmi >= 25 && bmi < 30) {
            System.out.println("OVERWEIGHT");
        } else if (bmi >= 30 && bmi < 40) {
            System.out.println("FAT");
        } else {
            System.out.println("VERY FAT");
        }

        System.out.println();
    }
}
