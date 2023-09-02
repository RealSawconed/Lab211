package fa21_03;

/**
 *
 * @author DatDDCE171299
 */
public class Main {

    private static GameManagement gm;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        gm = new GameManagement(); // Create an instance of GameManagement class
        try {
            gm.play(); // Start the game        
        } catch (Exception e) {
            System.out.println("Something went wrong, please try again!");
        }
    }
}
