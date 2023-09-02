package j1.s.p0016;

import java.util.Scanner;

/**
 *
 * @author DatDDCE171299
 */
public class J1SP0016 {

    private static Person person;
    private static Person.Wallet wallet;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int totalBill;

        System.out.println("======= Shopping program =======");
        do {
            System.out.print("Input number of bill: ");
            try {
                totalBill = Validation.checkRange(Integer.parseInt(sc.nextLine()), 1);
                person = new Person(totalBill);
                wallet = person.new Wallet();

                break;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter positive integer!");
            } catch (Exception e) {
                System.out.println("Please enter positive integer!");
            }
        } while (true);

        person.add(totalBill);
        wallet.addWallet();

        int total = person.calcTotal();
        
        System.out.println("This is a total of bill: " + total);
        if (wallet.payMoney(total)) {
            System.out.println("You can buy it.");
        } else {
            System.out.println("You can't buy it.");
        }

    }

}
