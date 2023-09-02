package fa21_05;

/**
 *
 * @author DatDDCE171299
 */
public class Main {

    private static GradeStudent gs; // Create an object from GradeStudent class

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        gs = new GradeStudent(); // Initialize object from GradeStudent class

        try {
            // Display welcome context
            gs.begin();

            // Add and calculate middle term result
            gs.midTerm();

            // Add and calculate final term result
            gs.finalTerm();

            // Add and calculate homework result
            gs.homework();

            // Calculate and display GPA result
            gs.report();
        } catch (Exception e) { // Throw when the program catch any error
            System.out.println("Something went wrong!");
        }
    }

}
