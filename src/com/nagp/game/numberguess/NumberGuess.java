package com.nagp.game.numberguess;

import java.util.Scanner;

public class NumberGuess {
    public void startGame() {
        // Get user input
        Scanner scanner = new Scanner(System.in);
        // Allow the player to set the range for the random number
        playGuessingGame(scanner);
        // Ask the user if they want to play again
        playAgain(scanner);
        scanner.close();
        System.out.print("Thanks for playing the game. Hope you liked it!");
    }

    private void playAgain(Scanner scanner) {
        System.out.print("Do you want to play again? (yes/no): ");
        String playAgain = scanner.next();
        if (playAgain.equalsIgnoreCase("yes")) {
            playGuessingGame(scanner);
        }
    }

    private void playGuessingGame(Scanner scanner) {
        // Generate a random number between 1 and 100
        int numberToGuess = (int) (Math.random() * 100 + 1);
        int numberOfAttempts = 0;
        boolean hasGuessedCorrectly = false;
        while (!hasGuessedCorrectly) {
            System.out.print("Guess the number: ");
            // Validate user input
            try {
                int guess = Integer.parseInt(scanner.next());
                numberOfAttempts++;
                // Provide feedback if the guess is too high, too low, or correct
                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You guessed the number in " + numberOfAttempts + " attempts.");
                    hasGuessedCorrectly = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

}
