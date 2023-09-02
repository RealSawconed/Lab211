package stringcounter;

/**
 *
 * @author DatDDCE171299
 */
import java.util.Scanner;

public class StringCounter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in); // Create a new instance from Scanner class
        Counter ctr; // Create an instance from Counter class

        /*Validate user input*/
        while (true) { // Make sure the user input is valid
            try {
                System.out.println("Enter your content:");
                // Create a new instance of Counter class with inputted string
                ctr = new Counter(input.nextLine()); 
                break;
            } catch (Exception e) { // Throw when string inputted is left blank
                System.out.println(e.getMessage());
            }        
        }        
        
        /*Output section*/                            
        ctr.countLetter(); // Count each letters number of occurrences        
        System.out.println(ctr.printLetter()); // Print the list of letters number of occurrences
        
        ctr.countCharacter(); // Count each characters number of occurrences
        System.out.println(ctr.printCharacter()); // Print the list of characters number of occurrences
    }
}
