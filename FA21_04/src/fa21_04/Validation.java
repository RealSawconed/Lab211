package fa21_04;

/**
 *
 * @author DatDDCE171299
 */
public class Validation {

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
