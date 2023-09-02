package l01;

import java.time.Year;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author DatDDCE171299
 */
public class Validation {
    // Create a regex to check different input pattern

    // (CD) take "CD" as compulsory part
    // [0-9]{4} make sure the rest is 4 numerical characters
    private static final String idCheck = "(CD)[0-9]{4}";

    // [A-Za-z0-9]+ let user input characters except special characters
    // @ is compulsory to input
    // [A-Za-z.-]+ let user input character that email has
    // \\. compulsory for "." character
    // [A-Za-z]{2,4} let user input the tail of the email
    private static final String emailCheck = "^[A-Za-z0-9][A-Za-z0-9.]+[A-Za-z0-9]+@[a-zA-Z0-9][a-zA-Z0-9.]+\\.[a-zA-Z0-9]{2,4}$";

    // (0) is compulsory as the first digit of telephone number
    // [1-9] the second digit is from 1 to 9
    // [0-9]{8,9} check the rest digitz of the phone number are digits
    // The length of phone must be either 10 or 11 digits
    private static final String phoneCheck = "(0)[1-9][0-9]{8,9}";

    // [0-9] check the phone number are digits
    // {3} make sure the phone length is 3 digits
    private static final String threeDigitPhoneCheck = "[0-9]{3}";

    /**
     * Check if the candidate's ID is valid
     *
     * @param id
     * @return
     */
    public static String checkId(String id) {
        id = checkString(id); // Check empty string

        if (!Pattern.compile(idCheck).matcher(id).matches()) { // Throw when inputted ID match given syntax
            throw new IllegalArgumentException("The candidate's ID must follow the syntax CDxxxx!");
        } else {
            return id;
        }
    }

    /**
     * Check if the candidate's date of birth is valid
     *
     * @param birthDate
     * @return
     */
    public static int checkBirthDate(int birthDate) {
        int currentYear = Year.now().getValue(); // Get the current year for comparison
        if (birthDate < 1900 || birthDate > currentYear) { // Throw if the year inputted is out of range
            throw new IllegalArgumentException("The candidate's birthday must be an integer from 1900 to " + currentYear + "!");
        } else {
            return birthDate;
        }
    }

    /**
     * Check if the candidate's phone number is valid
     *
     * @param phone
     * @return
     */
    public static String checkPhone(String phone) {
        phone = checkString(phone); // Check empty string

        if (Pattern.compile(threeDigitPhoneCheck).matcher(phone).matches()) { // Return true when the phone inputted is a length of 3
            return phone;
        } else if (!Pattern.compile(phoneCheck).matcher(phone).matches()) { // Throw when phone inputted is empty or invalid
            throw new IllegalArgumentException("The candidate's phone number must follow the format with length of 10 to 11 digits and start with 0!");
        } else {
            return phone;
        }
    }

    /**
     * Check if the candidate's email is valid
     *
     * @param email
     * @return
     */
    public static String checkEmail(String email) {
        email = checkString(email); // Check empty string

        if (!Pattern.compile(emailCheck).matcher(email).matches()) { // Throw when email inputted is empty or invalid
            throw new IllegalArgumentException("The candidate's email is invalid, please enter again!");
        } else {
            return email;
        }
    }

    /**
     * Check if candidate's year of experience is valid
     *
     * @param yearOfExp
     * @return
     */
    public static int checkYearOfExperience(int yearOfExp, int dateOfBirth) {
        int currentYear = Year.now().getValue(); // Get the current year for comparison
        if ((currentYear - dateOfBirth) == 0 && yearOfExp != 0) {
            throw new IllegalArgumentException("The candidate's year of experience must be 0 [Birthdate in " + dateOfBirth + "]!");
        } else if ((currentYear - dateOfBirth) < yearOfExp || yearOfExp < 0 || yearOfExp > 100) { // Throw when the value inputted is out of range
            throw new IllegalArgumentException("The candidate's year of experience must be from 0 to " + (currentYear - dateOfBirth) + " [" + dateOfBirth + "-" + currentYear + "]!");
        } else {
            return yearOfExp;
        }
    }

    /**
     * Check if candidate's graduation rank is valid
     *
     * @param rank
     * @return
     */
    public static String checkRank(String rank) {
        rank = checkString(rank); // Check empty string

        if (rank.equalsIgnoreCase("Excellence") || rank.equalsIgnoreCase("Good") || rank.equalsIgnoreCase("Fair") || rank.equalsIgnoreCase("Poor")) {
            return rank;
        } else { // Throw when user input is invalid
            throw new IllegalArgumentException("The candidate's graduation rank must be \"Excellence\", \"Good\", \"Fair\", \"Poor\"!");
        }
    }

    /**
     * Check if user's order is correctly inputted
     *
     * @param input
     * @return
     */
    public static boolean checkOrder(String input) {
        input = checkString(input); // Check empty string

        if (input.trim().equalsIgnoreCase("Y")) { // Continue the loop condition
            return true;
        } else if (input.trim().equalsIgnoreCase("N")) { // Stop the loop condition
            return false;
        } else { // Throw when user input is invalid
            throw new IllegalArgumentException("Please enter \"Yes\" or \"No\"!");
        }
    }

    /**
     * Check input with given range
     *
     * @param num
     * @param range1
     * @param range2
     * @return
     */
    public static int checkRange(int num, int range1, int range2) {
        if (num < range1 || num > range2) { // Throw when candidate's type is out of range
            throw new IllegalArgumentException("The candidate's type must be an integer from " + range1 + " to " + range2 + "!");
        } else {
            return num;
        }
    }

    /**
     * Check empty input value
     *
     * @param s
     * @return
     */
    public static String checkString(String s) {
        if (s.trim().isEmpty()) { // Throw when given string is empty
            throw new IllegalArgumentException("The input value cannot be empty!");
        } else {
            return s;
        }
    }

    /**
     * Check candidate's valid graduation date
     *
     * @param birthDate
     * @param graduationDate
     * @return
     */
    public static int checkGraduationDate(int birthDate, int graduationDate) {
        int currentYear = Year.now().getValue(); // Get the current year for comparison
        if (graduationDate < birthDate || graduationDate > currentYear) { // Throw when inputted date is not in range
            throw new IllegalArgumentException("The candidate's graduation date must be an integer from " + birthDate + " to " + currentYear + "!");
        } else {
            return graduationDate;
        }
    }
}
