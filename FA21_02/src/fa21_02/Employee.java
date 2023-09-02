package fa21_02;

/**
 *
 * @author DatDDCE171299
 */
public class Employee extends Staff implements ICalculator{

    private int overtimeHour;

    public Employee() {
    }
    
    
    
    public double calculateSalary() {
        return 1.0;
    }
    
    @Override
    public void displayInformation() {
        
    }
    
}
