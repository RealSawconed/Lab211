package j1.s.p0011;

/**
 *
 * @author DatDDCE171299
 */
public class Validation {

    // Create different phone regex pattern for validation    
    // Check phone pattern with only digits, length of 10 and start with 0 and a positive integer
    private static final String phonePattern1 = "(0)[1-9]\\d{8}";
    // Check phone pattern with '-' characters and length of 10
    private static final String phonePattern2 = "(0)[1-9]\\d-\\d{3}-\\d{4}";
    // Check phone pattern with '.' characters and length of 10
    private static final String phonePattern3 = "(0)[1-9]\\d\\.\\d{3}\\.\\d{4}";
    // Check phone pattern with space characters and length of 10
    private static final String phonePattern4 = "(0)[1-9]\\d\\s\\d{3}\\s\\d{4}";
    // Check phone pattern with braces and '-' characters and length of 10
    private static final String phonePattern5 = "\\((0)[1-9]\\d\\)-\\d{3}-\\d{4}";
    // Check phone pattern with extension "x" or "ext" with total length from 13 to 15 digit characters
    private static final String phonePattern6 = "(0)[1-9]\\d-\\d{3}-\\d{4}\\s(x|ext)\\d{3,5}";

    /**
     * Validate phone pattern
     *
     * @param phone
     * @return
     */
    public static String checkPhone(String phone) {
        if (phone.matches(phonePattern1)) { // Check first pattern
            return phone;
        } else if (phone.matches(phonePattern2)) { // Check second pattern
            return phone;
        } else if (phone.matches(phonePattern3)) { // Check third pattern
            return phone;
        } else if (phone.matches(phonePattern4)) { // Check fourth pattern
            return phone;
        } else if (phone.matches(phonePattern5)) { // Check fifth pattern
            return phone;
        } else if (phone.matches(phonePattern6)) { // Check sixth pattern
            return phone;
        } else { // Throw when no pattern is match
            throw new IllegalArgumentException("Please input Phone flow [Start with 0 and a non-zero digit]\n"
                    + "# 1234567890\n"
                    + "# 123-456-7890\n"
                    + "# 123-456-7890 x1234\n"
                    + "# 123-456-7890 ext1234\n"
                    + "# (123)-456-7890\n"
                    + "# 123.456.7890\n"
                    + "# 123 456 7890");
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
