package j1.s.p0012;

/**
 *
 * @author DatDDCE171299
 */
public class Validation {

    //Create a regex pattern to check code
    //(DOC) is compulsory at the beginning of code
    // \\d{3} is compulsory for 3 digits at the end of code
    private static final String codeCheck = "(DOC)\\d{3}";

    /**
     * Validate code input
     *
     * @param code
     * @return
     */
    public static String checkCode(String code) {
        code = checkString(code); // Check empty string

        if (!code.matches(codeCheck)) { // Check code with given pattern
            throw new IllegalArgumentException("Please enter doctor's code with syntax [DOCxxx]!");
        } else {
            return code;
        }
    }

    /**
     * Check value with begin and end range
     *
     * @param value
     * @param fromRange
     * @param toRange
     * @return
     */
    public static int checkRange(int value, int fromRange, int toRange) {
        if (value < fromRange || value > toRange) { // Throw when user input is out of range
            throw new NumberFormatException();
        } else {
            return value;
        }
    }

    /**
     * Check value with begin range
     *
     * @param value
     * @param fromRange
     * @return
     */
    public static int checkRange(int value, int fromRange) {
        if (value < fromRange) { // Throw when user input is out of range
            throw new NumberFormatException();
        } else {
            return value;
        }
    }

    /**
     * Check empty string
     *
     * @param str
     * @return
     */
    public static String checkString(String str) {
        if (str.trim().isEmpty()) { // Throw when user input is empty
            throw new IllegalArgumentException("Input value cannot be empty!");
        } else {
            return str;
        }
    }
}
