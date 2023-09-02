package v07;

import util.IOCE171607;

/**
 *
 * @author Admin
 */
public class V07 {

    public static void main(String[] args) {
        int choice;
        PersonManagement per = new PersonManagement();

        do {
            per.showMenu();
            choice = IOCE171607.getInteger("Please choose: ", "The function of application must be from 1 to 3!", 1, 3);
            switch (choice) {
                case 1:
                    per.addPersonInfo();
                    break;
                case 2:
                    per.displayInfo();
                    break;
                case 3:
                    System.out.println("Exit the program.");
                    break;
            }
        } while (choice != 3);
    }

}
