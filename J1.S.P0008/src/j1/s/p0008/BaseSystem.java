package j1.s.p0008;

/**
 *
 * @author DatDDCE171299
 */
public class BaseSystem {

    // Create an array that store every possible input value
    private final char[] baseRange = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'A', 'B', 'C', 'D', 'E', 'F'};
    private int inBase, outBase; // Store bases
    private String value; // Store base value

    /**
     * Create a default constructor
     */
    public BaseSystem() {
    }

    /**
     * Get base input value
     *
     * @return
     */
    public int getInBase() {
        return inBase;
    }

    /**
     * Set value for base input
     *
     * @param inBase
     */
    public void setInBase(int inBase) {
        inBase = Validation.baseCheck(inBase); // Validate base input value
        this.inBase = inBase;
    }

    /**
     * Get base output value
     *
     * @return
     */
    public int getOutBase() {
        return outBase;
    }

    /**
     * Set value for base output
     *
     * @param outBase
     */
    public void setOutBase(int outBase) {
        outBase = Validation.baseCheck(outBase); // Validate base output value
        this.outBase = outBase;
    }

    /**
     * Get base value
     *
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     * Set base value
     *
     * @param value
     */
    public void setValue(String value) {
        value = Validation.inputCheck(value.trim().toUpperCase(), inBase); // Validate base value
        this.value = value;
    }

    /**
     * Convert value into given base
     */
    public void baseConverter() {
        if (inBase != 10 && outBase != 10) { // From BIN to HEX and vice versa
            baseToDec(); // Convert to DEC
            decToBase(); // Convert to given base
        } else if (inBase != 10) { // Convert to DEC
            baseToDec();
        } else { // Convert from DEC
            decToBase();
        }
    }

    /**
     * Convert from decimal to given base
     */
    private void decToBase() {
        String newBase = ""; // Store new bas value
        int value = Integer.parseInt(this.value); // To input value to numerical value

        // Calculating base
        while (value != 0) { // Loop until inputted value is 0
            int temp = value % outBase;
            newBase = baseRange[temp] + newBase; // Input new value character to main output string
            value /= outBase;
        }

        this.value = "" + newBase;
    }

    /**
     * Converse from given base to decimal
     */
    private void baseToDec() {
        int newDec = 0; // Store final value
        this.value = this.value.toUpperCase(); // Format inputted value

        // Calculating base using non-loop algorithm
        for (int i = 0; i < this.value.length(); i++) {
            int idx = indexOf(value.charAt(i));
            newDec = inBase * newDec + idx; // Add to final output value
        }

        this.value = "" + newDec;
    }

    /**
     * Find index of given element in array
     *
     * @param c
     * @return
     */
    private int indexOf(char c) {
        for (int i = 0; i < baseRange.length; i++) { // Traverse through the whole array            
            if (Character.compare(baseRange[i], c) == 0) { // Return condition
                return i; // Return element index if found
            }
        }

        // Return -1 if element not found
        return -1;
    }

    /**
     * Display base value
     *
     * @return
     */
    @Override
    public String toString() {
        return value;
    }
}
