package v07;

/**
 *
 * @author NhutTMCE171607
 */
public class Person {
    private String name;
    private String address;
    private double salary;

    public Person(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public void showInfo() {
        System.out.println("Information of Person you have entered:");
        System.out.printf("Name:%s\n", getName());
        System.out.printf("Address:%s\n", getAddress());
        System.out.printf("Salary:%.1f\n", getSalary());
        System.out.println("");
    }
    
}
