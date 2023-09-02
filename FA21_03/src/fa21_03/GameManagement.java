package fa21_03;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author DatDDCE171299
 */
public class GameManagement {

    // Contain total games
    private int totalGames;
    // Contain total guesses of every game
    private int totalGuesses;
    // Contain average guess per game
    private double guessAvg;
    // Contain best game number
    private int bestGame;
    // Store array of each game number of guesses
    private static ArrayList<Integer> gameStatistic;

    /**
     * Start the game
     */
    public void play() {
        // Create an instance of Scanner class
        Scanner input = new Scanner(System.in);
        // Initialize game report list
        gameStatistic = new ArrayList<>();
        System.out.println("Welcome to \"Guess The Number\" game!");

        // Loop until player stop playing
        while (true) {
            System.out.println("===========================");
            System.out.println("The number is generating...");
            Game game = new Game(); // Create an instance of Game class
            while (true) { // Loop until player answer is correct
                try {
                    game.countGuess(); // Increase the number for each guesses
                    System.out.print("Please enter your guess: ");
                    // Taking player input value
                    game.setPlayerNumber(Integer.parseInt(input.nextLine()));

                    // Checking winning condition
                    if (game.checkNum() == 0) { // Win condition
                        System.out.println("Congrat! You figure out the number in " + game.getGuessCount() + " guesses");
                        break;
                    } else if (game.checkNum() < 0) { // Expect higher input value
                        System.out.println("- Expect higher number!");
                    } else { // Expect lower input value
                        System.out.println("- Expect lower number!");
                    }
                } catch (IllegalArgumentException iae) { // Throw when input value is non-numerical
                    System.out.println("- Please enter integer only!");
                }
            }
            // Add new data to list
            gameStatistic.add(game.getGuessCount());

            // Continue new game
            System.out.print("Please input \"Yes\" or \"Y\" to continue playing: ");
            // Finish the game in print game report
            if (!checkGameLoop(input.nextLine())) {
                // Print report
                System.out.println("===========================");
                System.out.println("Game Report:");
                report();
                System.out.println("== Thanks for playing! ==");
                return;
            }
        }
    }

    /**
     * Display game statistic
     */
    public void report() {
        countGuess(); // Get total number of guess and average guess
        findBestGame(); // Get number of least guess game

        System.out.println("Total games: " + gameStatistic.size()); // Get total game played
        System.out.println("Total guesses: " + totalGuesses);
        System.out.printf("Average guess: %.2f\n", guessAvg);
        System.out.println("Best game: " + bestGame + " guesses");

    }

    /**
     * Check if player want to continue playing
     *
     * @param loop
     * @return
     */
    private static boolean checkGameLoop(String loop) {
        loop = loop.trim();

        // Looping condition
        return loop.equalsIgnoreCase("Y") || loop.equalsIgnoreCase("YES");
    }

    /**
     * Get number of guesses of every game
     */
    private void countGuess() {
        int total = 0; // Store number of guesses
        for (int i : gameStatistic) {
            total += i;
        }
        // Set number of guesses
        totalGuesses = total;
        //Set average number of guesses per game
        guessAvg = (double) total / gameStatistic.size();
    }

    /**
     * Get the game with the least guesses
     *
     * @return
     */
    private void findBestGame() {
        int min = gameStatistic.get(0); // Initial first element as the least        
        for (int i = 1; i < gameStatistic.size(); i++) {
            if (gameStatistic.get(i) < min) { // get new index and new element if new element is less
                min = gameStatistic.get(i);                
            }
        }

        // Set the order number of game with the least guesses
        bestGame = min;
    }
}
