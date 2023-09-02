package v07;

import java.util.ArrayList;
import util.IOCE171607;

/**
 *
 * @author Admin
 */
public class PersonManagement {

    private ArrayList<Person> personList = new ArrayList<>();
    
    {
        personList.add(new Person("NghiaNV", "HaNoi", 2000));
        personList.add(new Person("LienVT", "HaNoi", 500));
        personList.add(new Person("TuanNT", "HaNoi", 1000));
    }
    
    public void showMenu() {
        System.out.println("=====Management Person programer=====");
        System.out.println("1. Input Information of Person");
        System.out.println("2. Show Information of Person");
        System.out.println("3. Exit");
    }

    public void addPersonInfo() {
        String name = IOCE171607.getString("Please input name: ", "---- Error! Please input name again (Not null): ");
        String address = IOCE171607.getString("Please input address: ", "---- Error! Please input address again (Not null): ");
        double salary = IOCE171607.getGreaterDouble("Please input salary: ", "---- Error! Please ipnut salary again (salary must be positive number): ", 0);

        personList.add(new Person(name, address, salary));
    }

    public void displayInfo() {
        if (personList.isEmpty()) {
            System.out.println("--------No Data Available!");
        } else {
            sort();
            for (Person p : personList) {
                p.showInfo();
            }
        }
    }

    private void sort() {
        for (int i = 0; i < personList.size() - 1; i++) {
            for (int j = 0; j < personList.size() - 1 - i; j++) {
                if (personList.get(j).getSalary() > personList.get(j + 1).getSalary()) {
                    Person temp = personList.get(j);
                    personList.set(j, personList.get(j + 1));
                    personList.set(j + 1, temp);
                }
            }
        }
    }
}
