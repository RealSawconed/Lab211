package j1.s.p0008;

/**
 *
 * @author DatDDCE171299
 */
public class Validation {

    // Create regex pattern to check valid input
    // [0-1]+ check binary value
    private static final String inputBINCheck = "[0-1]+";
    // [0-9]+ check decimal value
    private static final String inputDECCheck = "[0-9]+";
    // [a-fA-f0-9]+ check hexadecimal value
    private static final String inputHEXCheck = "[a-fA-f0-9]+";

    /**
     * Validate base value input
     *
     * @param value
     * @param base
     * @return
     */
    public static String inputCheck(String value, int base) {
        if (base == 10 && !value.matches(inputDECCheck)) { // Validate decimal input
            throw new IllegalArgumentException("Please enter positive decimal value [0-9]!");
        } else if (base == 2 && !value.matches(inputBINCheck)) { // Validate binary input
            throw new IllegalArgumentException("Please enter binary value [0-1]!");
        } else if (base == 16 && !value.matches(inputHEXCheck)) { // Validate hexadecimal input
            throw new IllegalArgumentException("Please enter hexadecimal value [0-9, A-F]!");
        } else {
            return value;
        }
    }

    /**
     * Validate base input
     *
     * @param base
     * @return
     */
    public static int baseCheck(int base) {
        if (base == 10 || base == 2 || base == 16) {
            return base;
        } else { // Throw when base inputted is neither 2, 10 nor 16
            throw new IllegalArgumentException("Please enter 2, 10 or 16!");
        }
    }

    /**
     * Validate program loop
     *
     * @param loop
     * @return
     */
    public static boolean loopCheck(String loop) {
        loop = loop.trim(); // Trim inputted value

        if (loop.equalsIgnoreCase("y") || loop.equalsIgnoreCase("yes")) { // Continue looping
            return true;
        } else if (loop.equalsIgnoreCase("n") || loop.equalsIgnoreCase("no")) { // Stop looping
            return false;
        } else { // Throw when user input is invalid
            throw new IllegalArgumentException("Please enter \"Yes\" or \"No\"!");
        }
    }
}
