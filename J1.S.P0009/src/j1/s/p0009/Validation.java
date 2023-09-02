package j1.s.p0009;

/**
 *
 * @author DatDDCE171299
 */
public class Validation {

    /**
     * Validate input with from and to range value
     *
     * @param value
     * @param fromRange
     * @param toRange
     * @return
     */
    public static int checkRange(int value, int fromRange, int toRange) {
        if (value < fromRange || value > toRange) { // Throw when user input is out of range
            throw new NumberFormatException("Please enter from " + fromRange + " to " + toRange);
        } else {
            return value;
        }
    }

    /**
     * Validate input with from range value
     *
     * @param value
     * @param fromRange
     * @return
     */
    public static int checkRange(int value, int fromRange) {
        if (value < fromRange) { // Throw when user input is out of range
            throw new NumberFormatException("Please enter from " + fromRange);
        } else {
            return value;
        }
    }

    /**
     * Validate positive input value
     *
     * @param value
     * @return
     */
    public static double checkDouble(double value) {
        if (value <= 0.0) { // Throw when user input is less than or equal to 0
            throw new NumberFormatException();
        } else {
            return value;
        }
    }

    /**
     * Validate mathematic operator input
     *
     * @param operator
     * @return
     */
    public static char checkOperator(char operator) {
        // Throw when operator inputted is not suitable for mathematic calculation
        if (Character.compare('+', operator) != 0 && Character.compare('-', operator) != 0
                && Character.compare('*', operator) != 0 && Character.compare('/', operator) != 0
                && Character.compare('^', operator) != 0 && Character.compare('=', operator) != 0) {
            throw new IllegalArgumentException("Please input (+, -, *, /, ^) or input (=) to finish calculating");
        } else {
            return operator;
        }
    }
}
