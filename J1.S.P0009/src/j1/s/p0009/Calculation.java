package j1.s.p0009;

/**
 *
 * @author DatDDCE171299
 */
public class Calculation implements ICalculation {

    private double num; // Store value for mathematic calculating operation
    private double result, resultBMI; // Store result values

    /**
     * Create a default constructor that initialize final results
     */
    public Calculation() {
        result = 0.0; // Set mathematic result to 0
        resultBMI = 1.0; // Set BMI result to 1
    }

    /**
     * Get value of inputted operand
     *
     * @return
     */
    public double getNum() {
        return num;
    }

    /**
     * Set value for operand
     *
     * @param num
     */
    public void setNum(double num) {
        this.num = num;
    }

    /**
     * Get result of mathematic calculating operation
     *
     * @return
     */
    public double getResult() {
        return result;
    }

    /**
     * Set result for mathematic calculating operation
     *
     * @param result
     */
    public void setResult(double result) {
        this.result = result;
    }

    /**
     * Get result of BMI calculating operation
     *
     * @return
     */
    public double getResultBMI() {
        return resultBMI;
    }

    /**
     * Set result for BMI calculating operation
     *
     * @param resultBMI
     */
    public void setResultBMI(double resultBMI) {
        this.resultBMI = resultBMI;
    }

    /**
     * Calculate mathematic operation with given mathematic operator
     *
     * @param operator
     */
    @Override
    public void calculate(char operator) {
        switch (operator) {
            case '+': // Addition calculation           
                this.result = this.num + this.result;
                break;

            case '-': // Subtraction calculation                
                this.result = this.result - this.num;
                break;

            case '*': // Multiplication calculation                
                this.result = this.num * this.result;
                break;

            case '/': // Division calculation       
                if (num == 0) { // Throw when user denominator is 0 
                    throw new ArithmeticException();
                } else {
                    this.result = this.result / this.num;
                }

                break;

            case '^': // Exponent calculation                
                this.result = Math.pow(this.result, this.num);
                break;
        }
    }

    /**
     * Calculate IBM value with given body measurement
     *
     * @param bodyWeight
     * @param height
     */
    @Override
    public void calculateIBM(double bodyWeight, double height) {
        resultBMI = bodyWeight / (height * height);
    }

}
