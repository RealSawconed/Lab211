package fa21_03;

import java.util.Random;

/**
 *
 * @author DatDDCE171299
 */
public class Game {

    // Give the game the range of pseudorandom number
    private final int maxNum = 101;
    // Contain player guessing number
    private int playerNumber;
    // Contain pseudorandom number
    private int randomNumber;
    // Contain total number of guesses per game
    private int guessCount;

    /**
     * Create a default constructor that generate a random integer
     */
    public Game() {
        random();
    }

    /**
     * Get the number from player
     *
     * @return
     */
    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     * Set the number for player
     *
     * @param playerNumber
     */
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    /**
     * Get the random number
     *
     * @return
     */
    public int getRandomNumber() {
        return randomNumber;
    }

    /**
     * Get the total number of guess per game
     *
     * @return
     */
    public int getGuessCount() {
        return guessCount;
    }

    /**
     * Generate a random integer
     */
    public void random() {
        Random rand = new Random(); // Create an instance from Random class

        randomNumber = rand.nextInt(maxNum); // Generate random integer with given range
    }

    /**
     * Return decrement value for comparison
     *
     * @return
     */
    public int checkNum() {
        return playerNumber - randomNumber;
    }

    /**
     * Increase number of guess by 1
     */
    public void countGuess() {
        guessCount++;
    }

}
