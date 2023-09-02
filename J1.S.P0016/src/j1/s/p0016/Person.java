package j1.s.p0016;

import java.util.Scanner;

/**
 *
 * @author ASUS PC
 */
public class Person {

    class Wallet {

        private int amount;

        public boolean payMoney(int total) {
            if (total > amount) {
                return false;
            } else {
                return true;
            }
        }

        public void addWallet() {
            Scanner sc = new Scanner(System.in);
            do {
                System.out.print("Input value of wallet: ");

                try {
                    amount = Validation.checkRange(Integer.parseInt(sc.nextLine()), 0);

                    break;
                } catch (NumberFormatException nfe) {
                    System.out.println("Please enter positive integer!");
                } catch (Exception e) {
                    System.out.println("Please enter positive integer!");
                }
            } while (true);
        }
    }

    private int[] bill;

    public Person(int totalBill) {
        bill = new int[totalBill];
    }

    public void add(int totalBill) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < totalBill; i++) {
            do {
                System.out.print("Input value of bill " + (i + 1) + ": ");

                try {
                    bill[i] = Validation.checkRange(Integer.parseInt(sc.nextLine()), 0);

                    break;
                } catch (NumberFormatException nfe) {
                    System.out.println("Please enter positive integer!");
                } catch (Exception e) {
                    System.out.println("Please enter positive integer!");
                }
            } while (true);
        }
    }

    public int calcTotal() {
        int total = 0;
        for (int i : bill) {
            total += i;
        }

        return total;
    }
}
