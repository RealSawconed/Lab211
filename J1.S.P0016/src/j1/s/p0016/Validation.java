package j1.s.p0016;

/**
 *
 * @author ASUS PC
 */
public class Validation {

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
}
