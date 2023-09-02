package fa21_02;

import java.util.Scanner;

/**
 *
 * @author DatDDCE171299
 */
public class HumanResources {
    
    private static Emp_Manager em ;
    
    public static void main(String[] args) {
        em = new Emp_Manager();
        Scanner input = new Scanner(System.in);
        
        while (true) {
            em.menu();
            
            do {
                try {
                    int choice = input.nextInt();
                    
                    switch (choice) {
                        case 1:
                            break;
                        
                        case 2:
                            break;
                            
                        case 3:
                            break;
                        
                        case 4:
                            break;
                        
                        case 5:
                            break;
                        
                        case 6:
                            break;
                        
                        case 7:
                            break;
                        
                        case 0:
                            return;                                                
                    }
                } catch (Exception e) {
                    System.out.println("Please enter integer only [0 - 7]");
                }
            } while (true);
        }
    }
}
