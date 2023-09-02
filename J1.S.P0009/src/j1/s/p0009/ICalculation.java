package j1.s.p0009;

/**
 *
 * @author DatDDCE171299
 */
public interface ICalculation {

    /**
     * Calculate mathematic problems with given mathematic operator
     *
     * @param operator
     */
    public void calculate(char operator);

    /**
     * Calculate BMI value with given values
     *
     * @param bodyWeight
     * @param height
     */
    public void calculateIBM(double bodyWeight, double height);
}
