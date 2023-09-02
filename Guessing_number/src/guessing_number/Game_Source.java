/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessing_number;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Vinhmqce170001
 */
public class Game_Source {

    // Variables to keep track of number of times played, total number of guesses, and best game in terms of number of guesses
    private int timesPlayed;
    private int totalGuesses;
    private int bestGame;
    // Variables to store the target number to be guessed and the current guess
    int target;
    int guess;
    int guesses;
// Constructor to initialize timesPlayed, totalGuesses and bestGame

    public Game_Source() {
        timesPlayed = 0;
        totalGuesses = 0;
        bestGame = Integer.MAX_VALUE;

    }

    /**
     * Constructor to initialize timesPlayed, totalGuesses and bestGame
     */
    public void play() {
        String a = "";//string for player play again or not

        // Loop to play the game until the player does not want to play anymore
        do
        {
            target = (int) (Math.random() * 100) + 1;// Generate a random number
            // Initialize the guess and number of guesses
            guess = 0;
            guesses = 0;

            Scanner sc = new Scanner(System.in);
            System.out.println("Guess a number between 1 and 100");
            while (guess != target)
            {
                try
                {
                    // Get the player's guess
                    guess = sc.nextInt();
                    guesses++;

                    // Check if the guess is outside the valid range of 1 to 100
                    if (guess < 1 || guess > 100)
                    {
                        // Display an error message and return to input if invalid
                        System.out.println("Invalid input, guess a number between 1 and 100");
                        continue;
                    }

                    // Check if the guess is too low or too high
                    if (guess < target)
                    {
                        System.out.println("Too low, try again");
                    } else if (guess > target)
                    {
                        System.out.println("Too high, try again");
                    }
                } catch (InputMismatchException e)
                {
                    // Display an error message and return to input if the input is not an integer
                    System.out.println("Invalid input, guess a number between 1 and 100");
                    sc.nextLine();
                    continue;
                }
            }

            // Add the number of times played and add to the total number of guesses
            timesPlayed++;
            totalGuesses += guesses;
            // Update bestGame if this game had fewer guesses
            if (guesses < bestGame)
            {
                bestGame = guesses;
            }
            System.out.println("Correct! You took " + guesses + " guesses.");
            // Read the player's response to playing again
            System.out.println("Do you want to play again???");
            sc.nextLine();
            a = sc.nextLine();

        } while (a.equalsIgnoreCase("yes") || a.equalsIgnoreCase("y"));
    }

    /**
     * Method to display the results of the game
     */
    public void result() {
        System.out.println("Total times played: " + timesPlayed);
        System.out.println("Total number of guesses: " + totalGuesses);
        System.out.println("Average number of guesses per turn: " + (totalGuesses / timesPlayed));
        System.out.println("Best game: " + bestGame + " guesses");
    }

}
