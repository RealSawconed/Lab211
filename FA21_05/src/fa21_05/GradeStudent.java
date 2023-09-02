package fa21_05;

import java.util.Scanner;

/**
 *
 * @author DatDDCE171299
 */
public class GradeStudent {

    private int totalWeight; // Store total weight at most 100
    private double totalWeightScore; // Store total weight score

    /**
     * Create a default constructor and initialize main values to 0s
     */
    public GradeStudent() {
        totalWeight = 0;
        totalWeightScore = 0;
    }

    /**
     * Display welcome context
     */
    public void begin() {
        System.out.println("This program reads exam/homework scores\n"
                + "and reports your overall course grade\n");
    }

    /**
     * Input and calculate result of middle term result
     */
    public void midTerm() {
        Scanner input = new Scanner(System.in); // Create an object from Scanner class
        int isShift; // Store shifting option, 1 mean there is a shift while 2 mean no shift happen
        int weight, score, shift = 0, totalPoint; // Store value for calculating

        System.out.println("Midterm:");

        // Input weight
        do { // Make sure weight is valid
            System.out.print("Weight (0-100)? ");
            try {
                // Input and validate weight
                weight = Validation.checkRange(input.nextInt(), 0, (100 - this.totalWeight));
                input.nextLine();
                this.totalWeight += weight;

                break;
            } catch (NumberFormatException nfe) { // Throw when weight is out of range
                System.out.println("Please enter integer from 0 to " + (100 - this.totalWeight) + "!");
            } catch (Exception e) { // Throw when weight is non-numerical
                System.out.println("Please enter integer from 0 to " + (100 - this.totalWeight) + "!");
                input.nextLine();
            }
        } while (true);

        // Input score
        do { // Make sure score is valid
            System.out.print("Score earned? ");
            try {
                // Input and validate score
                score = Validation.checkRange(input.nextInt(), 0, 100);
                input.nextLine();

                break;
            } catch (NumberFormatException nfe) { // Throw when score is out of range
                System.out.println("Please enter integer from 0 to 100!");
            } catch (Exception e) { // Throw when score is non-numerical
                System.out.println("Please enter integer from 0 to 100!");
                input.nextLine();
            }
        } while (true);

        // Input shift option
        do { // Make sure shift option is valid
            System.out.print("Were scores shifted (1=yes, 2=no)? ");
            try {
                // Input and validate shift option
                isShift = Validation.checkRange(input.nextInt(), 1, 2);
                input.nextLine();

                break;
            } catch (NumberFormatException nfe) { // Throw when shift option is out of range
                System.out.println("Please enter integer 1 or 2!");
            } catch (Exception e) { // Throw when shift option is non-numerical
                System.out.println("Please enter integer 1 or 2!");
                input.nextLine();
            }
        } while (true);

        if (isShift == 1) {
            // Input shift 
            do { // Make sure shift is valid
                System.out.print("Shift amount? ");
                try {
                    // Input and validate shift 
                    shift = Validation.checkRange(input.nextInt(), 0, 100);
                    input.nextLine();

                    break;
                } catch (NumberFormatException nfe) { // Throw when shift is out of range
                    System.out.println("Please enter integer 0 or 100!");
                } catch (Exception e) { // Throw when shift is non-numerical
                    System.out.println("Please enter integer 0 or 100!");
                    input.nextLine();
                }
            } while (true);
        }

        totalPoint = score + shift; // Calculate total point as the sum of score earned and shifted value
        if (totalPoint > 100) { // Keep score at 100 if total point is above 100
            totalPoint = 100;
        }
        // Display total point
        System.out.printf("Total points =  %d / 100\n", totalPoint);
        // Display weighted score with the formula of (totalPoint / 100) * weight
        double weightScore = (double) totalPoint / 100 * weight;
        totalWeightScore += weightScore; // Add to total weighted score
        System.out.printf("Weighted score = %.1f / %d\n\n", weightScore, weight);
    }

    /**
     * Input and calculate final term result
     */
    public void finalTerm() {
        Scanner input = new Scanner(System.in); // Create an object from Scanner class
        int isShift;
        int weight, score, shift = 0, totalPoint; // Store value for calculating

        System.out.println("Final:");

        // Input weight
        do { // Make sure weight is valid
            System.out.print("Weight (0-100)? ");
            try {
                // Input and validate weight
                weight = Validation.checkRange(input.nextInt(), 0, (100 - this.totalWeight));
                input.nextLine();
                this.totalWeight += weight;

                break;
            } catch (NumberFormatException nfe) { // Throw when weight is out of range
                System.out.println("Please enter integer from 0 to " + (100 - this.totalWeight) + "!");
            } catch (Exception e) { // Throw when weight is non-numerical
                System.out.println("Please enter integer from 0 to " + (100 - this.totalWeight) + "!");
                input.nextLine();
            }
        } while (true);

        // Input score
        do { // Make sure score is valid
            System.out.print("Score earned? ");
            try {
                // Input and validate score
                score = Validation.checkRange(input.nextInt(), 0, 100);
                input.nextLine();

                break;
            } catch (NumberFormatException nfe) { // Throw when score is out of range
                System.out.println("Please enter integer from 0 to 100!");
            } catch (Exception e) { // Throw when score is non-numerical
                System.out.println("Please enter integer from 0 to 100!");
                input.nextLine();
            }
        } while (true);

        // Input shift option
        do { // Make sure shift option is valid
            System.out.print("Were scores shifted (1=yes, 2=no)? ");
            try {
                // Input and validate shift option
                isShift = Validation.checkRange(input.nextInt(), 1, 2);
                input.nextLine();

                break;
            } catch (NumberFormatException nfe) { // Throw when shift option is out of range
                System.out.println("Please enter integer 1 or 2!");
            } catch (Exception e) { // Throw when shift option is non-numerical
                System.out.println("Please enter integer 1 or 2!");
                input.nextLine();
            }
        } while (true);

        if (isShift == 1) {
            // Input shift 
            do { // Make sure shift is valid
                System.out.print("Shift amount? ");
                try {
                    // Input and validate shift 
                    shift = Validation.checkRange(input.nextInt(), 0, 100);
                    input.nextLine();

                    break;
                } catch (NumberFormatException nfe) { // Throw when shift is out of range
                    System.out.println("Please enter integer from 0 to 100!");
                } catch (Exception e) { // Throw when shift is non-numerical
                    System.out.println("Please enter integer from 0 to 100!");
                    input.nextLine();
                }
            } while (true);
        }

        // Calculate total point as the sum of score earned and shifted value
        totalPoint = score + shift;
        if (totalPoint > 100) { // Keep score at 100 if total point is above 100
            totalPoint = 100;
        }
        // Display total point
        System.out.printf("Total points =  %d / 100\n", totalPoint);
        // Display weighted score with the formula of (totalPoint / 100) * weight
        double weightScore = (double) totalPoint / 100 * weight;
        totalWeightScore += weightScore; // Add to total weighted score
        System.out.printf("Weighted score = %.1f / %d\n\n", weightScore, weight);
    }

    /**
     * Input and calculate homework result
     */
    public void homework() {
        Scanner input = new Scanner(System.in); // Create an object from Scanner class
        int totalAssignment = 0; // Stroe expected score
        int assignments; // Store
        int weight, assignment, section = 30;

        System.out.println("Homework:");

        // Input weight
        do { // Make sure weight is valid
            System.out.print("Weight (0-100)? ");
            try {
                // Input and validate weight
                weight = input.nextInt();
                if (weight != (100 - this.totalWeight)) {
                    throw new NumberFormatException();
                } else {
                    input.nextLine();
                    this.totalWeight += weight;
                }

                break;
            } catch (NumberFormatException nfe) { // Throw when weight is out of range
                System.out.println("Please enter " + (100 - this.totalWeight) + "!");
            } catch (Exception e) { // Throw when weight is non-numerical
                System.out.println("Please enter " + (100 - this.totalWeight) + "!");
                input.nextLine();
            }
        } while (true);

        // Input number of assignment
        do { // Make sure number of assignment is valid
            System.out.print("Number of assignments? ");
            try {
                // Input and validate number of assignment
                assignments = Validation.checkRange(input.nextInt(), 1);
                input.nextLine();

                break;
            } catch (NumberFormatException nfe) { // Throw when number of assignment is out of range
                System.out.println("Please enter integer from 1!");
            } catch (Exception e) { // Throw when number of assignment is non-numerical
                System.out.println("Please enter integer from 1!");
                input.nextLine();
            }
        } while (true);

        // Store values for calculation
        int totalScore = 0, score, max;
        // Input value for given number of assignment
        for (int i = 0; i < assignments; i++) {
            do { // Make sure score and max is valid
                System.out.print("Assignment " + (i + 1) + " score and max? ");
                // Input and validate score and max
                String assignmentValue = formatString(input.nextLine());
                int index = assignmentValue.indexOf(" "); // Get the seperation of score and max
                if (index == -1) { // Catch when values input are not enough for calculating
                    System.out.printf("Please enter integers for score and max again [0 <= score <= max <= %d]!\n", (150 - totalAssignment));
                } else {
                    // Get score and value from input string
                    try {
                        // Make sure total score and max is in range
                        score = Validation.checkRange(Integer.parseInt(assignmentValue.substring(0, index)), 0, 150 - totalAssignment);
                        max = Validation.checkRange(Integer.parseInt(assignmentValue.substring(index + 1)), 0, 150 - totalAssignment);

                        if (score > max) { // Throw when score is higher than expected max
                            throw new Exception();
                        }

                        // Store expected and actual score
                        totalAssignment += max; // Expected value
                        totalScore += score; // Actual value

                        break;
                    } catch (NumberFormatException nfe) { // Throw when score and max is out of range
                        System.out.printf("Please enter integers for score and max again [0 <= score <= max <= %d]!\n", (150 - totalAssignment));
                    } catch (Exception e) { // Store when score and max is non-numerical or not in right order
                        System.out.printf("Please enter integers for score and max again [0 <= score <= max <= %d]!\n", (150 - totalAssignment));
                    }
                }
            } while (true);
        }

        // Input section
        do { // Make sure section is valid
            System.out.print("How many section did you attend? ");
            try {
                // Input and validate section
                section = Validation.checkRange(input.nextInt(), 0);
                input.nextLine();

                break;
            } catch (NumberFormatException nfe) { // Throw when section is out of range
                System.out.println("Please enter integer from 0!");
            } catch (Exception e) { // Throw when section is non-numerical
                System.out.println("Please enter integer from 0!");
                input.nextLine();
            }
        } while (true);

        // Calculate section point
        section *= 5;

        // Keep section point at 30 if point is above
        if (section > 30) {
            section = 30;
        }

        // Display section point
        System.out.printf("Section points = %d / %d\n", section, 30); // Max point for section is 30
        // Calculate and display total point
        System.out.printf("Total points = %d / %d\n", totalScore + section, totalAssignment + 30);
        // Calculate and display weighted score
        double weightScore = (float) (totalScore + section) / (totalAssignment + 30) * weight;
        totalWeightScore += weightScore; // Add weighted score into total weighted score
        System.out.printf("Weighted score = %.1f / %d\n\n", weightScore, weight);
    }

    /**
     * Calculate and display GPA result
     */
    public void report() {
        // Display overall percentage 
        System.out.printf("Overall percentage = %.1f\n", totalWeightScore);
        // Display expecting minimum grade
        System.out.print("Your grade will be at least: ");

        // Display grade with condition
        if (totalWeightScore >= 85) {
            System.out.println("3.0");
        } else if (84.99 >= totalWeightScore && totalWeightScore >= 75) {
            System.out.println("2.0");
        } else if (74.99 >= totalWeightScore && totalWeightScore >= 60) {
            System.out.println("0.7");
        } else { // when total weight is less than 60%
            System.out.println("0.0");
        }

        // Display end messages
        System.out.println("\nGood luck on your result!\n"
                + "=== Thanks for using the program ===");
    }

    /**
     * Format string with given format
     *
     * @param str
     * @return
     */
    private String formatString(String str) {

        String[] word = str.trim().split("\\s"); // Split the string in to array element using white space

        // Store first formatted element
        String newStr = "" + word[0];

        // Store the rest of the formatted element in main string
        for (int i = 1; i < word.length; i++) {
            if (word[i].equals("")) { // Leave out un-needed element
                continue;
            } else {
                // Add new element to main string
                newStr += " " + word[i];
                break;
            }
        }
        return newStr;
    }
}
